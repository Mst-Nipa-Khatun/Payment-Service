package com.PaymentService.service.Impl;

import com.PaymentService.dto.Response;
import com.PaymentService.dto.StudentDto;
import com.PaymentService.entity.StudentEntity;
import com.PaymentService.repository.StudentRepository;
import com.PaymentService.service.StudentService;
import com.PaymentService.utils.ResponseBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Response createStudent(StudentDto studentDto) {
        StudentEntity studentEntity=studentRepository.findByNameAndActiveTrue(studentDto.getName());
        if(studentEntity==null){
            studentEntity=modelMapper.map(studentDto, StudentEntity.class);
            StudentEntity student=studentRepository.save(studentEntity);
            StudentDto createstudentDto=modelMapper.map(student, StudentDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED,createstudentDto,
                    "Successfully created");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST,null,"Student already exists");
    }
}
