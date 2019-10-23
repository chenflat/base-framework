package io.github.supercube.domain;

import java.io.Serializable;

/**
 * @author chenping
 */
public interface IEntity extends Serializable {

    String getId();

    void setId(String id);
}
