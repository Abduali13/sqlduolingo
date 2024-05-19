package com.company.sqlduolingo.service.impl;

import com.company.sqlduolingo.dto.RegisterDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.entity.Course;
import com.company.sqlduolingo.entity.Register;
import com.company.sqlduolingo.entity.Users;
import com.company.sqlduolingo.repository.CourseRepository;
import com.company.sqlduolingo.repository.RegisterRepository;
import com.company.sqlduolingo.repository.UsersRepository;
import com.company.sqlduolingo.service.RegisterService;
import com.company.sqlduolingo.service.mapper.RegisterMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final CourseRepository courseRepository;
    private final UsersRepository usersRepository;
    private final RegisterRepository registerRepository;
    private final RegisterMapper registerMapper;


    @Override
    public ResponseDto<RegisterDto> registerUserToCourse(Integer SSN, String courseName) {
        Optional<Users> optional = this.usersRepository.findUsersBySSNAndDeletedAtIsNull(SSN);
        if (optional.isEmpty()) {
            return ResponseDto.<RegisterDto>builder()
                    .code(-1)
                    .message("SSN is not found")
                    .build();
        }
        Optional<Course> optionalCourse = this.courseRepository.findCourseByCourseNameAndDeletedAtIsNull(courseName);
        if (optionalCourse.isEmpty()) {
            return ResponseDto.<RegisterDto>builder()
                    .code(-1)
                    .message("Course is not found")
                    .build();
        }
        Register register = new Register();
        register.setSSN(optional.get().getSSN());
        register.setCourseId(optionalCourse.get().getCourseId());
        return ResponseDto.<RegisterDto>builder()
                .success(true)
                .message("OK")
                .content(
                        this.registerMapper.toDto(
                                this.registerRepository.save(register)))
                .build();
    }


    @Override
    public ResponseDto<RegisterDto> create(RegisterDto dto) {
        return null;
    }

    @Override
    public ResponseDto<RegisterDto> get(Integer registerId) {
        return null;
    }

    @Override
    public ResponseDto<RegisterDto> update(Integer registerId, RegisterDto dto) {
        return null;
    }

    @Override
    public ResponseDto<RegisterDto> delete(Integer referenceId) {
        return null;
    }
}
