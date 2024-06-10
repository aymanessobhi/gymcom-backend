package com.ideracloud.gymcom.repository;

import com.ideracloud.gymcom.domain.Base;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends Base<T>> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {
    Page findAll(Specification<T> buildCriteria, Pageable pageable);
}