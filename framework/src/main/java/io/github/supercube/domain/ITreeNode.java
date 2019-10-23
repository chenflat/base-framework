package io.github.supercube.domain;


import java.util.List;

/**
 * 树形节点
 *
 * @author chenping
 */
public interface ITreeNode extends IEntity {


    Character DEFAULT_PATH_SEPARATOR = Character.valueOf('/');

    String getParentId();

    void setParentId(String paramString);

    String getName();

    void setName(String paramString);

    String getText();

    String getTreeNodePath();

    void setTreeNodePath(String treeNodePath);

    String getTreeNodePathName();

    void setTreeNodePathName(String treeNodePathName);

    List<? extends ITreeNode> getChildren();

    void setChildren(List<? extends ITreeNode> paramList);

    boolean isLeaf();

    void setLeaf(boolean paramBoolean);

    boolean isIsParent();

    boolean isOpen();

    void setOpen(boolean paramBoolean);

    Integer getOrderNum();

    void setOrderNum(Integer paramInteger);

    String getIcon();

    void setIcon(String paramString);

    void setChecked(Boolean paramBoolean);

    void setValue(Long value);

    Long getValue();
}
