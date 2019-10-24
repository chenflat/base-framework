package io.github.supercube.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.util.List;

/**
 * 树形节点
 *
 * @author chenping
 */
@MappedSuperclass
public class AbstractTreeNode implements ITreeNode {

    @Id
    @Column
    protected String id;

    @Column
    protected String name;

    @Column
    protected String text;

    @Column
    protected String parentId;

    @Column
    protected String treeNodePath;

    @Column
    protected String treeNodePathName;

    @Column
    protected boolean open;

    @Column
    protected boolean leaf;

    @Column
    protected Integer orderNum;

    protected Boolean checked;

    @Column
    protected String icon;

    @Column
    private Long value;

    @Transient
    protected List<? extends ITreeNode> children;

    public AbstractTreeNode() {
    }

    public AbstractTreeNode(ITreeNode t) {
        BeanUtils.copyProperties(this, t);
    }

    @Override
    public boolean isIsParent() {
        return !this.leaf;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getParentId() {
        return parentId;
    }

    @Override
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String getTreeNodePath() {
        return treeNodePath;
    }

    @Override
    public void setTreeNodePath(String treeNodePath) {
        this.treeNodePath = treeNodePath;
    }

    @Override
    public String getTreeNodePathName() {
        return treeNodePathName;
    }

    @Override
    public void setTreeNodePathName(String treeNodePathName) {
        this.treeNodePathName = treeNodePathName;
    }

    @Override
    public boolean isOpen() {
        return open;
    }

    @Override
    public void setOpen(boolean open) {
        this.open = open;
    }

    @Override
    public boolean isLeaf() {
        return leaf;
    }

    @Override
    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    @Override
    public Integer getOrderNum() {
        return orderNum;
    }

    @Override
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Boolean getChecked() {
        return checked;
    }

    @Override
    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    @Override
    public String getIcon() {
        return icon;
    }

    @Override
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public Long getValue() {
        return value;
    }

    @Override
    public void setValue(Long value) {
        this.value = value;
    }

    @Override
    public List<? extends ITreeNode> getChildren() {
        return children;
    }

    @Override
    public void setChildren(List<? extends ITreeNode> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AbstractTreeNode)) {
            return false;
        }
        AbstractTreeNode o = (AbstractTreeNode) obj;

        return new EqualsBuilder()
            .append(getClass().getName(), o.getClass().getName())
            .append(getId(), o.getId()).isEquals();
    }
}
