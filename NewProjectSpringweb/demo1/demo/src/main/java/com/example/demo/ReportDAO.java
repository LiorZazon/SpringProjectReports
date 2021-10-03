package com.example.demo;

import java.sql.*;
import java.util.ArrayList;

public class ReportDAO {

    private String m_conn;

    public ReportDAO(String m_conn) {
        this.m_conn = m_conn;
    }

    public void setM_conn(String m_conn){
        this.m_conn = m_conn;
    }

    public ArrayList<ReportDTO> getAllReports() {
        ArrayList<ReportDTO>  reports = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(m_conn)){

            if(conn != null){
                String sql = "SELECT * FROM Reports";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()){
                    ReportDTO r = new ReportDTO(
                            rs.getInt("Id"),
                            rs.getString("LicensePlate"),
                            rs.getInt("DriverId"),
                            rs.getInt("Speed"));
                    reports.add(r);
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return reports;
    }



    public ReportDTO getReportById(int id) {
        try (Connection conn = DriverManager.getConnection(m_conn)){
            if(conn != null) {
                String sql = "SELECT * FROM Reports WHERE id = " + id;
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()){
                    ReportDTO reportss = new ReportDTO(
                            rs.getInt("Id"),
                            rs.getString("LicensePlate"),
                            rs.getInt("DriverId"),
                            rs.getInt("Speed"));
                    return reportss;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    public ArrayList<ReportDTO> select(String query) {

        ArrayList<ReportDTO> reports = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(m_conn)) {
            if (conn != null) {

                String sql = query;

                Statement stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    ReportDTO r = new ReportDTO(
                            rs.getInt("Id"),
                            rs.getString("LicensePlate"),
                            rs.getInt("DriverId"),
                            rs.getInt("Speed"));
                    reports.add(r);
                }

            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return reports;
    }

    public void insertReport(ReportDTO report){
        try (Connection conn = DriverManager.getConnection(m_conn)){
            if(conn != null) {
                String sql = String.format("INSERT INTO Reports (Id, LicensePlate, DriverId, Speed)" +
                                " VALUES ('%d', '%s', '%d', '%d')", report.getId(),
                        report.getLicense_plate(), report.getDriver_id(),
                        report.getSpeed());
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    public void updateReport(ReportDTO report, int id){
        try (Connection conn = DriverManager.getConnection(m_conn)){
            if(conn != null) {
                String sql = String.format("UPDATE Reports SET " +
                                "LicensePlate = '%s', " +
                                "DriverId = %d, " +
                                "Speed = %d " +
                                " WHERE id = %d", report.getLicense_plate(), report.getDriver_id(),
                        report.getSpeed(), id);
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteReport(int id){
        try (Connection conn = DriverManager.getConnection(m_conn)){
            if(conn != null) {
                String sql = "DELETE FROM Reports WHERE id = " + id;
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
