package io.github.supercube.domain;


import java.io.Serializable;
import java.util.List;

/**
 * @author chenping
 */
public class NzTreeNode implements Serializable {

    private String title;

    private String key;

    private int level;

    private List<NzTreeNode> children;

    private NzTreeNodeOption origin;

    private boolean isLeaf;

    private boolean isExpanded;

    private boolean isDisabled;

    private boolean isDisableCheckbox;

    private boolean isSelectable;

    private boolean isChecked;

    private boolean isAllChecked;

    private boolean isHalfChecked;

    private boolean isSelected;

    private boolean isLoading;

    private boolean isMatched;

    public NzTreeNode() {
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

    public List<NzTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<NzTreeNode> children) {
        this.children = children;
    }

    public NzTreeNodeOption getOrigin() {
        return origin;
    }

    public void setOrigin(NzTreeNodeOption origin) {
        this.origin = origin;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void setDisabled(boolean disabled) {
        isDisabled = disabled;
    }

    public boolean isDisableCheckbox() {
        return isDisableCheckbox;
    }

    public void setDisableCheckbox(boolean disableCheckbox) {
        isDisableCheckbox = disableCheckbox;
    }

    public boolean isSelectable() {
        return isSelectable;
    }

    public void setSelectable(boolean selectable) {
        isSelectable = selectable;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public boolean isAllChecked() {
        return isAllChecked;
    }

    public void setAllChecked(boolean allChecked) {
        isAllChecked = allChecked;
    }

    public boolean isHalfChecked() {
        return isHalfChecked;
    }

    public void setHalfChecked(boolean halfChecked) {
        isHalfChecked = halfChecked;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    @Override
    public String toString() {
        return "NzTreeNode{" +
                "title='" + title + '\'' +
                ", key='" + key + '\'' +
                ", level=" + level +
                ", children=" + children +
                ", origin=" + origin +
                ", isLeaf=" + isLeaf +
                ", isExpanded=" + isExpanded +
                ", isDisabled=" + isDisabled +
                ", isDisableCheckbox=" + isDisableCheckbox +
                ", isSelectable=" + isSelectable +
                ", isChecked=" + isChecked +
                ", isAllChecked=" + isAllChecked +
                ", isHalfChecked=" + isHalfChecked +
                ", isSelected=" + isSelected +
                ", isLoading=" + isLoading +
                ", isMatched=" + isMatched +
                '}';
    }
}
