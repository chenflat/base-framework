package io.github.supercube.service.demo;

import io.github.supercube.service.QueryService;
import io.github.supercube.service.filter.LongFilter;
import io.github.supercube.service.filter.StringFilter;
import org.springframework.data.jpa.domain.Specification;

public class BaseEntityQueryService extends QueryService<BaseEntity> {

    static class BaseEntityCriteria {
        LongFilter id;
        StringFilter name;

        public LongFilter getId() {
            return id;
        }

        public StringFilter getName() {
            return name;
        }
    }

    public Specification<BaseEntity> createSpecification(BaseEntityCriteria criteria) {
        Specification<BaseEntity> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildSpecification(criteria.getId(), BaseEntity_.id));
            }
            if (criteria.getName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getName(), BaseEntity_.name));
            }
        }
        return specification;
    }
}
