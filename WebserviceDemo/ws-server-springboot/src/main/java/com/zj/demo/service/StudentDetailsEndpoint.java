package com.zj.demo.service;

import com.zj.demo.jaxb.GetStudentDetailsRequest;
import com.zj.demo.jaxb.GetStudentDetailsResponse;
import com.zj.demo.jaxb.StudentDetails;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Creator: zhuji
 * Date: 2018/10/14
 * Time: 15:22
 * Description:
 */
@Endpoint
public class StudentDetailsEndpoint {
    @PayloadRoot(namespace = "http://com.zj.demo.ws/students", localPart = "GetStudentDetailsRequest")
    @ResponsePayload
    public GetStudentDetailsResponse processCourseDetailsRequest(@RequestPayload GetStudentDetailsRequest request) {
        GetStudentDetailsResponse response = new GetStudentDetailsResponse();

        StudentDetails studentDetails = new StudentDetails();
        studentDetails.setId(request.getId());
        studentDetails.setName("Adam");
        studentDetails.setPassportNumber("E1234567");

        response.setStudentDetails(studentDetails);

        return response;
    }
}
