package com.company.sqlduolingo.service.mapper;

import com.company.sqlduolingo.dto.RegisterDto;
import com.company.sqlduolingo.entity.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class RegisterMapper {

    @Lazy
    @Autowired
    private CourseMapper courseMapper;

    public Register toEntity(RegisterDto dto){
        return Register.builder().build();
    }


    public RegisterDto toDto(Register register) {
        return RegisterDto.builder()
                .registerId(register.getRegisterId())
                .SSN(register.getSSN())
                .course(this.courseMapper.toDto(register.getCourse()))
                .courseId(register.getCourseId())
                .createdAt(register.getCreatedAt())
                .updatedAt(register.getUpdatedAt())
                .deletedAt(register.getDeletedAt())
                .build();
    }

    public Register update(Register register, RegisterDto dto){
        return register;
    }
}
