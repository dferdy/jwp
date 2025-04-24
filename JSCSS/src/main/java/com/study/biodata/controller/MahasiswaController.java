/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.study.biodata.controller;

import com.study.biodata.dao.MahasiswaDao;
import com.study.biodata.javabeans.Mahasiswa;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pins
 */
public class MahasiswaController extends HttpServlet {
    
    Mahasiswa mahasiswa = new Mahasiswa();
    Connection connection;
    Statement st;
    MahasiswaDao mahasiswaDao = new MahasiswaDao();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, SQLException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter() // Hanya dijalankan jika tidak ada forward
        // Ganti QUI -> out untuk konsistensi
        ) {
        String nim = request.getParameter("nim");
        String nama = request.getParameter("nama");
        String jenisKelamin = request.getParameter("jenkel");
        String tempatLahir = request.getParameter("tempatlahir");
        String tanggalLahir = request.getParameter("tanggallahir");
        String handphone = request.getParameter("hp");
        String email = request.getParameter("email");
        String alamat = request.getParameter("alamat");

        if(request.getParameter("simpan") != null){
            mahasiswa.setNim(nim);
            mahasiswa.setNama(nama);
            mahasiswa.setJenisKelamin(jenisKelamin);
            mahasiswa.setTempatLahir(tempatLahir);
            mahasiswa.setTanggalLahir(tanggalLahir);
            mahasiswa.setHandphone(handphone);
            mahasiswa.setEmail(email);
            mahasiswa.setAlamat(alamat);
            mahasiswaDao.simpan(mahasiswa);
            
            // Pindahkan forward SEBELUM close()
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
            return; // Penting: keluar dari method setelah forward
        }
    }
}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
