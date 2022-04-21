package example.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import example.mail.EMail;

public class EmailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public void doPost(HttpServletRequest req, HttpServletResponse rsp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        String to = req.getParameter("to");
        String subject = req.getParameter("subject");
        String body = req.getParameter("body");
        EMail email = new EMail();
        email.sendEMail(to, subject, body);
        RequestDispatcher rd = req.getRequestDispatcher("/html/submitted.html");
        rd.forward(req, rsp);
    }
}
