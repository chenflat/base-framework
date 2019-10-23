package io.github.supercube.utils;


import io.github.supercube.domain.NzTreeNodeOption;

import java.util.ArrayList;
import java.util.List;

public class NzTreeUtil {

    public static List<NzTreeNodeOption> build(List<NzTreeNodeOption> treeNodes) {

        List<NzTreeNodeOption> trees = new ArrayList<>();
        for (NzTreeNodeOption treeNode : treeNodes) {
            if ("".equals(treeNode.getParent())) {
                trees.add(treeNode);
            }
            for (NzTreeNodeOption it : treeNodes) {
                if (it.getParent().equals(treeNode.getKey())) {
                    if (treeNode.getChildren() == null) {
                        treeNode.setChildren(new ArrayList<>());
                    }
                    treeNode.getChildren().add(it);
                }
            }
        }
        return trees;
    }

    /**
     * 使用递归方法建树
     *
     * @param treeNodes 树对象
     * @return 树列表
     */
    public static List<NzTreeNodeOption> buildByRecursive(List<NzTreeNodeOption> treeNodes) {
        List<NzTreeNodeOption> trees = new ArrayList<>();
        for (NzTreeNodeOption treeNode : treeNodes) {
            if (treeNode.getParent() == null || "".equals(treeNode.getParent())) {
                treeNode.setExpanded(true);
                trees.add(findChildren(treeNode, treeNodes));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     *
     * @param treeNode  子节点
     * @param treeNodes 树对象
     * @return 子节点
     */
    public static NzTreeNodeOption findChildren(NzTreeNodeOption treeNode, List<NzTreeNodeOption> treeNodes) {
        treeNode.setChildren(new ArrayList<>());
        for (NzTreeNodeOption it : treeNodes) {
            it.setExpanded(true);
            if (treeNode.getKey().equals(it.getParent())) {
                if (treeNode.getChildren() == null) {
                    treeNode.setChildren(new ArrayList<>());
                }
                treeNode.getChildren().add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }
}
