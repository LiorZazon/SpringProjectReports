package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		List<ReportDAO> reports = new ArrayList<>();
		ReportDAO repDAO = new ReportDAO("jdbc:sqlite:D:/Users/ליאור/Downloads/QA course/NewProjectSpringweb/Reports.db");
		System.out.println(repDAO.getAllReports());









	}





}



