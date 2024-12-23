package com.PaymentService.repository;

import com.PaymentService.entity.StudentInformationTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentInformationTestRepo extends JpaRepository<StudentInformationTest, Long> {

    @Query(value = "select  STUDENTINFORMATION.Roll,\n" +
            "       Name,\n" +
            "       Exam_Result.Reg_Num,\n" +
            "       STUDENTINFORMATION.Age,\n" +
            "       Exam_Result.Group_Name,\n" +
            "       STUDENTINFORMATION.Gender\n" +
            "from STUDENTINFORMATION\n" +
            "         LEFT JOIN Exam_Result ON STUDENTINFORMATION.Roll = Exam_Result.Roll",nativeQuery = true)
    Object getTestData();
}
