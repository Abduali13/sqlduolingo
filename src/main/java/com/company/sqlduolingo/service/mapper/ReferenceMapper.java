package com.company.sqlduolingo.service.mapper;

import com.company.sqlduolingo.dto.ReferenceDto;
import com.company.sqlduolingo.entity.Reference;
import org.springframework.stereotype.Component;

@Component
public class ReferenceMapper {

    public Reference toEntity(ReferenceDto dto){
        return Reference.builder()
                .book(dto.getBook())
                .reference(dto.getReference())
                .build();
    }


    public ReferenceDto toDto(Reference reference) {
        return ReferenceDto.builder()
                .referenceId(reference.getReferenceId())
                .courseId(reference.getCourseId())
                .reference(reference.getReference())
                .book(reference.getBook())
                .createdAt(reference.getCreatedAt())
                .updatedAt(reference.getUpdatedAt())
                .deletedAt(reference.getDeletedAt())
                .build();
    }

    public Reference update(Reference reference, ReferenceDto dto){
        if (dto.getReference() != null){
            reference.setReference(dto.getReference());
        }
        if (dto.getBook() != null){
            reference.setBook(dto.getBook());
        }
        return reference;
    }
}
