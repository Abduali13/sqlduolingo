package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.CourseDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.sqlduolingo.dto.SimpleResponseDto.convertStatusCodeByData;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/course")
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<ResponseDto<CourseDto>> create(@RequestBody CourseDto dto){
        return convertStatusCodeByData(this.courseService.create(dto));
    }

    @GetMapping
    public ResponseEntity<ResponseDto<CourseDto>> get(@RequestParam(value = "id") Integer courseId){
        return convertStatusCodeByData(this.courseService.get(courseId));
    }

    @PutMapping
    public ResponseEntity<ResponseDto<CourseDto>> update(@RequestParam(value = "id") Integer courseId,@RequestBody CourseDto dto){
        return convertStatusCodeByData(this.courseService.update(courseId, dto));
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto<CourseDto>> delete(@RequestParam(value = "id") Integer courseId){
        return convertStatusCodeByData(this.courseService.delete(courseId));
    }
}
