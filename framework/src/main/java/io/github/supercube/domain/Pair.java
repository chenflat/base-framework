package io.github.supercube.domain;

import java.io.Serializable;

/**
 * 对值
 *
 * @author chenping
 */
public class Pair<L, R> implements Serializable {
    private static final long serialVersionUID = 7838072938875014319L;
    private L leftObject = null;
    private R rightObject = null;

    public Pair() {
    }

    public Pair(L leftObject, R rightObject) {
        this.setLeftObject(leftObject);
        this.setRightObject(rightObject);
    }

    public L getLeftObject() {
        return this.leftObject;
    }

    public void setLeftObject(L leftObject) {
        this.leftObject = leftObject;
    }

    public R getRightObject() {
        return this.rightObject;
    }

    public void setRightObject(R rightObject) {
        this.rightObject = rightObject;
    }

    @Override
    public boolean equals(Object anotherObject) {
        if (this == anotherObject) {
            return true;
        } else if (!this.getClass().isAssignableFrom(anotherObject.getClass())) {
            return false;
        } else {
            Pair<L, R> anotherPair = (Pair<L, R>) anotherObject;
            if (this.leftObject == null && this.rightObject == null) {
                return anotherPair.leftObject == null && anotherPair.rightObject == null;
            } else if (this.leftObject == null) {
                return this.rightObject.equals(anotherPair.leftObject);
            } else if (this.rightObject == null) {
                return this.rightObject.equals(anotherPair.rightObject);
            } else {
                return this.leftObject.equals(anotherPair.leftObject) && this.rightObject.equals(anotherPair.rightObject);
            }
        }
    }

    @Override
    public int hashCode() {
        if (this.leftObject != null && this.rightObject != null) {
            return this.leftObject.hashCode() ^ this.rightObject.hashCode();
        } else if (this.leftObject != null) {
            return 17 ^ this.leftObject.hashCode();
        } else {
            return this.rightObject != null ? 17 ^ this.rightObject.hashCode() : super.hashCode();
        }
    }

    @Override
    public String toString() {
        return "Pair:" + this.getClass() + "<<" + (this.leftObject == null ? "EMPTY" : this.leftObject.toString()) + ">,<" + (this.rightObject == null ? "EMPTY" : this.rightObject.toString()) + ">>";
    }
}
