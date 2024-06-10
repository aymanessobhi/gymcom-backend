package com.ideracloud.gymcom.specification;


import com.ideracloud.gymcom.domain.User;
import com.ideracloud.gymcom.dto.UserSearchDto;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserCriteria {

        public Specification<User> fetchUsers(UserSearchDto request){
            return (root, query, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();
                if (request != null) {
                    if (isNotEmpty(request.getId())) {
                        predicates.add(criteriaBuilder.equal(root.get("id"), request.getId()));
                    }

                    if (isNotEmpty(request.getNom())) {
                        predicates.add(criteriaBuilder.like(root.get("nom"), "%" + request.getNom().trim() + "%"));
                    }

                    if (isNotEmpty(request.getPrenom())) {
                        predicates.add(criteriaBuilder.like(root.get("prenom"), "%" + request.getPrenom().trim() + "%"));
                    }

                    if (isNotEmpty(request.getUsername())) {
                        predicates.add(criteriaBuilder.like(root.get("username"), "%" + request.getUsername().trim() + "%"));
                    }

                    if (isNotEmpty(request.getTel())) {
                        predicates.add(criteriaBuilder.like(root.get("tel"), "%" + request.getTel().trim() + "%"));
                    }

                    if (isNotEmpty(request.getEmail())) {
                        predicates.add(criteriaBuilder.like(root.get("email"), "%" + request.getEmail().trim() + "%"));
                    }
                }else{
                    return criteriaBuilder.conjunction();
                }

                query.distinct(true);
                query.orderBy(criteriaBuilder.desc(root.get("createdDate")));
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            };
        }

        Boolean isNotEmpty(String val) {
            return val != null && !val.isEmpty();
        }
        Boolean isNotEmpty(Object val) {
            return val != null;
        }

}
