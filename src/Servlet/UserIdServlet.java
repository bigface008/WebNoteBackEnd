package Servlet;

import Entity.UserEntity;
import Util.HibernateUntil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/getUserId")
public class UserIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();

            String username = request.getParameter("name");
            int isValid = getId(username);

            out.println(isValid);
            out.flush();
            out.close();
        } catch (Exception ex) {
            if (ServletException.class.isInstance(ex)) {
                throw (ServletException) ex;
            } else {
                throw new ServletException(ex);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private int getId(String username) {
        Session session = HibernateUntil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<UserEntity> result = (List<UserEntity>) session
                .createQuery("select userId from UserEntity where userName = :name")
                .setParameter("name", username).list();
        tx.commit();
        return result.get(0).getUserId();
    }
}
