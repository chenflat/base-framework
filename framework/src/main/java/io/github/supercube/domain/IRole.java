package io.github.supercube.domain;

import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author chenping
 */
public interface IRole extends GrantedAuthority, IEntity, RoleHierarchy {

    String ROLE_PUBLIC = "ROLE_PUBLIC";
    String ROLE_ANONYMOUS = "ROLE_ANONYMOUS";
    String SUPER_RIGHTS = "__ALL";

    int getDataRange();

}
