package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.CourseDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/course")
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseDto<CourseDto> create(@RequestBody CourseDto dto){
        return this.courseService.create(dto);
    }

    @GetMapping
    public ResponseDto<CourseDto> get(@RequestParam(value = "id") Integer courseId){
        return this.courseService.get(courseId);
    }

    @PutMapping
    public ResponseDto<CourseDto> update(@RequestParam(value = "id") Integer courseId,@RequestBody CourseDto dto){
        return this.courseService.update(courseId, dto);
    }

    @DeleteMapping
    public ResponseDto<CourseDto> delete(@RequestParam(value = "id") Integer courseId){
        return this.courseService.delete(courseId);
    }
}
