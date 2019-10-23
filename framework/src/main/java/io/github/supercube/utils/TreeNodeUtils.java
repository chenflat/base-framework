package io.github.supercube.utils;

import io.github.supercube.domain.ITreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author chenping
 */
public final class TreeNodeUtils {

    public static final <S extends ITreeNode> List<S> parseFormList(List<S> list) {
        return bulidFormList(list);
    }

    public static final <S extends ITreeNode> List<S> parseAndAddRootFormList(Class<S> clazz, List<S> list, boolean showRoot) {
        List<S> nodeList = bulidFormList(list);
        if (showRoot) {
            List<S> result = new ArrayList<>();
            S root = creatRootTreenode(clazz);
            root.setChildren(nodeList);
            result.add(root);
            return result;
        }
        return nodeList;
    }

    private static final <S extends ITreeNode> List<S> bulidFormList(List<S> list) {
        List<S> nodeList = new ArrayList<>();
        if (list == null) {
            return nodeList;
        }
        for (S node1 : list) {
            boolean mark = false;
            for (S node2 : list) {
                if ((node1.getParentId() != null) &&
                    (node1.getParentId().equals(node2.getId()))) {
                    mark = true;
                    if (node2.getChildren() == null) {
                        node2.setChildren(new ArrayList<>());
                    }
                    // node2.getChildren().add(node1);
                    break;
                }
            }
            if (!mark) {
                nodeList.add(node1);
            }
        }
        return nodeList;
    }

    public static <S extends ITreeNode> S creatRootTreenode(Class<S> clazz) {
        return creatRootTreenode(clazz, "所有");
    }

    public static <S extends ITreeNode> S creatRootTreenode(Class<S> clazz, String rootName) {
        S root = null;
        try {
            root = clazz.newInstance();
        } catch (Exception e) {
            return root;
        }
        root.setId("");
        root.setName(rootName);
        root.setTreeNodePath("/");
        root.setTreeNodePathName("/");
        root.setOpen(true);

        return root;
    }

    public String getUpdatePath(String oldPath, String newPath) {
        if ((oldPath == null) || (oldPath.trim().length() < 1) ||
            (oldPath.trim().equals(ITreeNode.DEFAULT_PATH_SEPARATOR))) {
            return "";
        }
        if ((newPath == null) || (newPath.trim().length() < 1)) {
            newPath = ITreeNode.DEFAULT_PATH_SEPARATOR.toString();
        }
        if (oldPath.charAt(0) != '-') {
            oldPath = ITreeNode.DEFAULT_PATH_SEPARATOR + oldPath;
        }
        if (oldPath.charAt(oldPath.length() - 1) != '-') {
            oldPath = oldPath + ITreeNode.DEFAULT_PATH_SEPARATOR;
        }
        if (newPath.charAt(0) != '-') {
            newPath = ITreeNode.DEFAULT_PATH_SEPARATOR + newPath;
        }
        if (newPath.charAt(newPath.length() - 1) != '-') {
            newPath = newPath + ITreeNode.DEFAULT_PATH_SEPARATOR;
        }
        String newPathTemp = newPath.trim();
        String oldPathTemp = oldPath.trim();

        StringBuilder hql = new StringBuilder();
        hql.append(" update ");
        hql.append(" table");
        hql.append(" o ");
        hql.append(" set o.tree_node_path=replace(tree_node_path," +
            oldPathTemp.trim());
        hql.append(",").append(newPathTemp).append(")");

        hql.append(" set o.tree_node_path_name=replace(treenodepath_name," +
            oldPathTemp.trim());
        hql.append(",").append(newPathTemp).append(")");

        hql.append(" where o.tree_node_path  like %" + oldPathTemp + "%");

        return hql.toString();
    }

    public static int rebulidTree(String tableName) {
        return 0;
    }

    public static final List<Map<String, Object>> sortTree(List<Map<String, Object>> list) {
        List<Map<String, Object>> nodeList = buildTree(list);
        List<Map<String, Object>> nodeList2 = new ArrayList<>();
        for (Map<String, Object> node1 : nodeList) {
            addTreeList(node1, nodeList2);
        }
        return nodeList2;
    }


    private static final void addTreeList(Map<String, Object> node, List<Map<String, Object>> list) {
        List<Map<String, Object>> children = (List<Map<String, Object>>) node.get("children");

        list.add(node);
        if ((children != null) && (children.size() != 0)) {
            for (Map<String, Object> m : children) {
                addTreeList(m, list);
            }
        }
    }

    private static final List<Map<String, Object>> buildTree(List<Map<String, Object>> list) {
        List<Map<String, Object>> nodeList = new ArrayList<>();
        for (Map<String, Object> node1 : list) {
            boolean mark = false;
            String parentId = (String) node1.get("parent_id");
            for (Map<String, Object> node2 : list) {
                String id = (String) node2.get("id");
                if ((parentId != null) && (parentId.equals(id))) {
                    mark = true;
                    if (node2.get("children") == null) {
                        node2.put("children",
                            new ArrayList());
                    }
                    ((List<Map<String, Object>>) node2.get("children")).add(node1);
                    break;
                }
            }
            if (!mark) {
                nodeList.add(node1);
            }
        }
        return nodeList;
    }
}
