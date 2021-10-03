package com.example.demo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController

public class ReportController {



    private static List<ReportDAO> reports = new ArrayList<>();
    ReportDAO repDAO = new ReportDAO("jdbc:sqlite:D:/Users/ליאור/Downloads/QA course/NewProjectSpringweb/Reports.db");



    @GetMapping("/report")
    public List<ReportDTO> getAllReport()
    {
        return repDAO.getAllReports();
    }

    @GetMapping("/report/{id}")
    public ReportDTO doGetReportById(@PathVariable("id") int id)
    {
        return repDAO.getReportById(id);
    }

    @PostMapping("/report")
    public void addReport(@RequestBody ReportDTO r)
    {
        repDAO.insertReport(r);
    }

    @PutMapping("/report/{id}")
    public void updateReportById (@PathVariable("id") int id,
                             @RequestBody ReportDTO update_r)
    {
        repDAO.updateReport(update_r, id);
    }

    @DeleteMapping("/report/{id}")
    public void delReportById(@PathVariable("id") int id) {
        repDAO.deleteReport(id);
    }

}



