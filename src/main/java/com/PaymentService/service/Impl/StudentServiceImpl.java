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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        StudentEntity studentEntity=studentRepository.findByNameAndStatus(studentDto.getName(),1);
        if(studentEntity==null){
            studentEntity=modelMapper.map(studentDto, StudentEntity.class);
            studentEntity.setStatus(1);
            StudentEntity student=studentRepository.save(studentEntity);
            StudentDto createstudentDto=modelMapper.map(student, StudentDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED,createstudentDto,
                    "Successfully created");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST,null,
                "Student already exists");
    }

    @Override
    public Response getAllStudent() {
        List<StudentEntity> studentList=studentRepository.findAllByStatus(1);
        if(!studentList.isEmpty()){
            List<StudentDto> studentDtos=new ArrayList<>();
            for(StudentEntity student: studentList){
                StudentDto studentdto=modelMapper.map(student,StudentDto.class);
                studentDtos.add(studentdto);
            }
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK,studentDtos,
                    "Successfully retrieved");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST,null,
                "Student not found");
    }

    @Override
    public Response getPaymentById(Long id) {
        StudentEntity studentEntity=studentRepository.findByIdAndStatus(id,1);
        if(studentEntity!=null){
            StudentDto studentDto=modelMapper.map(studentEntity,StudentDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK,studentDto,
                    "Successfully retrieved");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT,null,
                "Student not found");
    }

    @Override
    public Response deleteById(Long id) {
        StudentEntity studentEntity=studentRepository.findByIdAndStatus(id,0);
        if(studentEntity!=null){
            studentEntity.setStatus(0);//false kore rakhchi
            StudentEntity student=studentRepository.save(studentEntity);
            StudentDto createstudentDto=modelMapper.map(student,StudentDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK,createstudentDto,
                    "Successfully deleted");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT,null,
                "Student not found");
    }

    @Override
    public Response editPaymentById(Long id, StudentDto studentDto) {
        StudentEntity studentEntity=studentRepository.findByIdAndStatus(id,1);
        if(studentEntity!=null){
            studentEntity=modelMapper.map(studentDto, StudentEntity.class);
            studentEntity.setStatus(1);//true
            StudentEntity savedStudent=studentRepository.save(studentEntity);
            StudentDto createstudentDto=modelMapper.map(savedStudent,StudentDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK,createstudentDto,
                    "Successfully updated");

        }
        return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT,null,
                "Student not found");
    }

    @Override
    public Response getNullAge() {
        List<StudentEntity> studentEntities=studentRepository.findByAgeIsNullAndStatus(1);
        if(!studentEntities.isEmpty()){
            List<StudentDto> studentDtos=new ArrayList<>();
            for(StudentEntity student: studentEntities){
                StudentDto studentdto=modelMapper.map(student,StudentDto.class);
                studentDtos.add(studentdto);

            }
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK,studentDtos,
                    "Successfully retrieved");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT,null,
                "Student not found");
    }

    @Override
    public Response getAgeByGenderDesc(Integer age) {
        List<StudentEntity> studentEntities=studentRepository.findByAgeOrderByGenderDesc(13);
        if(!studentEntities.isEmpty()){
            List<StudentDto> studentDtos=new ArrayList<>();
            for(StudentEntity student: studentEntities){
                StudentDto studentdto=modelMapper.map(student,StudentDto.class);
                studentDtos.add(studentdto);
            }
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK,studentDtos,
                    "Successfully retrieved");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT,null,
                "Student not found");
    }

    @Override
    public Response getStudentsByAge(Collection<Integer> ages) {
        List<StudentEntity>studentEntities=studentRepository.findByAgeIn(List.of(13,20));
        if(!studentEntities.isEmpty()){
            List<StudentDto> studentDtos=new ArrayList<>();
            for(StudentEntity student: studentEntities){
                StudentDto studentdto=modelMapper.map(student,StudentDto.class);
                studentDtos.add(studentdto);
            }
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK,studentDtos,
                    "Successfully retrieved");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT,null,
                "Student not found");
    }

    @Override
    public Response getStudentsByGender(String gender) {
        List<StudentEntity>studentEntities=studentRepository.findByGenderStartsWithIgnoreCase("Female");
        if(!studentEntities.isEmpty()){
            List<StudentDto> studentDtos=new ArrayList<>();
            for(StudentEntity student: studentEntities){
                StudentDto studentdto=modelMapper.map(student,StudentDto.class);
                studentDtos.add(studentdto);
            }
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK,studentDtos,
                    "Successfully retrieved");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT,null, "Student not found");
    }


}
