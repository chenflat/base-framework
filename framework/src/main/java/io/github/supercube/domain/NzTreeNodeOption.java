package io.github.supercube.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * @author chenping
 */
public class NzTreeNodeOption implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String title;

    private String key;

    private String parent;

    private int level;

    private Boolean isLeaf;

    private Boolean checked;

    private Boolean expanded;

    private Boolean disabled;

    private String treeNodePath;

    private String treeNodePathName;

    private List<NzTreeNodeOption> children;

    public NzTreeNodeOption() {
        this.id = "0";
        this.title = "";
        this.key = "";
        this.level = 0;
        this.children = new ArrayList<>();
        this.isLeaf = false;
        this.checked = false;
        this.expanded = true;
        this.disabled = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<NzTreeNodeOption> getChildren() {
        return children;
    }

    public void setChildren(List<NzTreeNodeOption> children) {
        this.children = children;
    }

    public void addChildrenItem(NzTreeNodeOption childrenItem) {
        if (!this.children.contains(childrenItem)) {
            this.children.add(childrenItem);
        }

    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public Boolean getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Boolean leaf) {
        isLeaf = leaf;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public Boolean getExpanded() {
        return expanded;
    }

    public void setExpanded(Boolean expanded) {
        this.expanded = expanded;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public String getTreeNodePath() {
        return treeNodePath;
    }

    public void setTreeNodePath(String treeNodePath) {
        this.treeNodePath = treeNodePath;
    }

    public String getTreeNodePathName() {
        return treeNodePathName;
    }

    public void setTreeNodePathName(String treeNodePathName) {
        this.treeNodePathName = treeNodePathName;
    }

    @Override
    public String toString() {
        return "NzTreeNodeOption{" +
            "title='" + title + '\'' +
            ", key='" + key + '\'' +
            ", parent='" + parent + '\'' +
            ", level=" + level +
            ", isLeaf=" + isLeaf +
            ", checked=" + checked +
            ", expanded=" + expanded +
            ", disabled=" + disabled +
            ", treeNodePath='" + treeNodePath + '\'' +
            ", treeNodePathName='" + treeNodePathName + '\'' +
            ", children=" + children +
            '}';
    }
}
