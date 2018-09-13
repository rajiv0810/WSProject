package com.in28minutes.soap.webservices.coursemanagement;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.in28minutes.courses.CourseDetails;
import com.in28minutes.courses.GetAllCourseDetailsRequest;
import com.in28minutes.courses.GetAllCourseDetailsResponse;
import com.in28minutes.courses.GetCourseDetailsRequest;
import com.in28minutes.courses.GetCourseDetailsResponse;

@Endpoint
public class CourseDetailsEndpoint {

	
	@PayloadRoot(namespace = "http://in28minutes.com/courses", localPart = "GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setId(request.getId());
		courseDetails.setName("Microservices Course");
		courseDetails.setDescription("Sample Soap Web Service program!");
		courseDetails.setAge(23);
//		GregorianCalendar dateConverted = new GregorianCalendar(2018, 09, 08);
		
//		courseDetails.setDob("08-09-2018");
		courseDetails.setStudentName("Raju");
		
		response.setCourseDetails(courseDetails);
		
		return response;
	}

	@PayloadRoot(namespace = "http://in28minutes.com/courses", localPart = "GetAllCourseDetailsRequest")
	@ResponsePayload
	public GetAllCourseDetailsResponse processAllCourseDetailsRequest(@RequestPayload GetAllCourseDetailsRequest request) {
		GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
		
		ArrayList<CourseDetails> listCourse = new ArrayList<CourseDetails>();
		
		
		
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setId(request.getId());
		courseDetails.setName("Microservices Course");
		courseDetails.setDescription("Sample Soap Web Service program!");
		courseDetails.setAge(23);
//		GregorianCalendar dateConverted = new GregorianCalendar(new);
		DatatypeFactory factory=null;
		try {
			factory = DatatypeFactory.newInstance();
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Parses a string in ISO 8601 format to an XMLGregorianCalendar
		XMLGregorianCalendar xmlCal = factory.newXMLGregorianCalendar("2012-05-16T10:39:00+03:00");
		
		courseDetails.setDob(xmlCal);
		courseDetails.setStudentName("Raju");
		
		CourseDetails courseDetails1 = new CourseDetails();
		courseDetails1.setId(request.getId());
		courseDetails1.setName("Microservices Course");
		courseDetails1.setDescription("Sample Soap Web Service program!");
		courseDetails1.setAge(25);
		XMLGregorianCalendar xmlCal1 = factory.newXMLGregorianCalendar("2018-06-16T10:39:00+03:00");
//		GregorianCalendar dateConverted = new GregorianCalendar(2018, 09, 08);
		courseDetails1.setDob(xmlCal1);
		courseDetails1.setStudentName("Gopi");
		
		
		listCourse.add(courseDetails);
		listCourse.add(courseDetails1);
		
		response.getCourseDetails().add(courseDetails);
		response.getCourseDetails().add(courseDetails1);
//		response.setCourseDetails(listCourse);
		
		return response;
	}
}