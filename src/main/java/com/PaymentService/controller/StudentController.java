package com.PaymentService.controller;

import com.PaymentService.dto.Response;
import com.PaymentService.dto.StudentDto;
import com.PaymentService.service.StudentService;
import com.PaymentService.utils.UrlConstraint;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UrlConstraint.PaymentService.ROOT)
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping(UrlConstraint.PaymentService.CREATE)
    public Response createStudent(@RequestBody StudentDto studentDto){
        return studentService.createStudent(studentDto);
    }
    @GetMapping(UrlConstraint.PaymentService.GET_ALL)
    public Response getAllStudents(){
        return studentService.getAllStudent();
    }
    @GetMapping(UrlConstraint.PaymentService.GET_PAYMENTS_BY_ID)
    public Response getPaymentsById(@PathVariable("id") Long id){
        return studentService.getPaymentById(id);
    }
    @DeleteMapping(UrlConstraint.PaymentService.DELETE_PAYMENT)
    public Response deletePaymentById(@PathVariable("id") Long id){
        return studentService.deleteById(id);
    }
    @PutMapping(UrlConstraint.PaymentService.EDIT_PAYMENT)
    public Response editPaymentById(@PathVariable("id") Long id,@RequestBody StudentDto studentDto){
        return studentService.editPaymentById(id,studentDto);
    }
    @GetMapping(UrlConstraint.PaymentService.GET_NULL_AGE)
    public Response getNullAge(){
        return studentService.getNullAge();
    }
    @GetMapping(UrlConstraint.PaymentService.GET_AGE_BY_GENDER_DESC)
    public Response getAgeByGenderDesc(@RequestParam Integer age){
        return studentService.getAgeByGenderDesc(age);

    }
}
