package com.ideracloud.gymcom.mapper;

import com.ideracloud.gymcom.domain.Base;
import com.ideracloud.gymcom.dto.BaseDto;
import com.ideracloud.gymcom.dto.Pager;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class BaseMapper<E extends Base<E>, D extends BaseDto<D>> {
    ModelMapper mapper = new ModelMapper();

    public BaseMapper() {
    }

    public Type parametrizeType(int index) {
        Type sooper = this.getClass().getGenericSuperclass();
        return ((ParameterizedType) sooper).getActualTypeArguments()[index];
    }

    public E toEntity(D dto) {
        return (E) this.mapper.map(dto, this.parametrizeType(0));
    }

    public D toDto(E entity) {
        return (D) this.mapper.map(entity, this.parametrizeType(1));
    }

    public List<D> toDtos(List entities) {
        return (List) entities.stream().map((row) -> {
            return this.toDto((E) row);
        }).collect(Collectors.toList());
    }

    public Pager<D> toDtosWithPagination(Page entities) {
        Pager<D> pager = new Pager();
        pager.setContent(this.toDtos(entities.getContent()));
        pager.setPageSize(entities.getSize());
        pager.setTotalPages(entities.getTotalPages());
        pager.setTotalElements(entities.getTotalElements());
        pager.setPageNumber(entities.getNumber());
        return pager;
    }
}