/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosservlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "ProdutoAjaxServlet", urlPatterns = {"/produto-ajax"})
public class ProdutoAjaxServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Produto p1 = new Produto(1L, "Bolo de chocolate",
                "descrição do bolo de chocolate",
                new BigDecimal(30.0), "http://lorempixel.com/g/300/300/");
        Produto p2 = new Produto(1L, "Bolo de cenoura",
                "descrição do bolo de cenoura", new BigDecimal(20.0), "http://lorempixel.com/g/300/300/");
        List<Produto> lista = Arrays.asList(p1, p2);

        // Preparar resposta
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        
        // CORS
        response.addHeader("Access-Control-Allow-Origin", "*");
        
        // Jackson 2
        ObjectMapper mapper = new ObjectMapper();
        try (PrintWriter out = response.getWriter()) {
            out.print(mapper.writeValueAsString(lista));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
