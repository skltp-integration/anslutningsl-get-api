package se.skltp.anslutningslagetApi.service.impl;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import javax.persistence.criteria.*;
import java.util.LinkedList;

public abstract class SpecificationBuilder<T, S> {

    protected Specification<T> buildSpecification(final S criteria) {

        LinkedList<Specification<T>> specifications = new LinkedList<Specification<T>>();

        addSpecifactionsToQuery(specifications, criteria);

        Specification<T> specification = specifications.poll();

        while (!specifications.isEmpty()) {
            specification = Specifications.where(specification).and(specifications.poll());
        }

        return specification;
    }

    protected abstract void addSpecifactionsToQuery(
            LinkedList<Specification<T>> specifications, S criteria);



     protected Specification<T> like(final String tableName, final String value) {
        return (root, query, builder) -> builder.equal( root.join(tableName, JoinType.LEFT).get("name"), value);
    }

}
