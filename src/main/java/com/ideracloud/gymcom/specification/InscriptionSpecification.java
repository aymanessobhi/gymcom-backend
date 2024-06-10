package com.ideracloud.gymcom.specification;

import com.ideracloud.gymcom.domain.Inscription;
import com.ideracloud.gymcom.dto.InscriptionSearchDto;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InscriptionSpecification {

    public Specification<Inscription> findInscriptions(InscriptionSearchDto request){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

//            if(isNotEmpty(request.getCodeCategory())){
//                predicates.add(criteriaBuilder.equal(root.get("category").get("code"), request.getCodeCategory()));
//            }
//
//
//            if(isNotEmpty(request.getCodeSubCategory())){
//                predicates.add(criteriaBuilder.equal(root.get("subCategory").get("code"), request.getCodeCategory()));
//            }

            query.distinct(true);
            query.orderBy(criteriaBuilder.desc(root.get("createdDate")));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }



    Boolean isNotEmpty(String val) {
        return val != null && !val.isEmpty();
    }
}
