package Servlet;

import Entity.UserEntity;
import Util.HibernateUntil;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet("/UserManager")
public class UserManagerServlet extends HttpServlet {

    public UserManagerServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HibernateUntil.getSessionFactory().getCurrentSession().beginTransaction();
            PrintWriter out = response.getWriter();
            response.setContentType("text/html;charset=utf-8");

            System.out.println("This is a user manager");

            List<UserEntity> result = HibernateUntil.getSessionFactory()
                    .getCurrentSession().createQuery("from UserEntity").list();
            Iterator<UserEntity> it = result.iterator();

            ArrayList<JSONArray> usersJson = new ArrayList<JSONArray>();
            while (it.hasNext()) {
                UserEntity user = (UserEntity) it.next();
                ArrayList<String> arrayList = new ArrayList<String>();
                arrayList.add(String.valueOf(user.getUserId()));
                arrayList.add(user.getUserName());
                arrayList.add(user.getUserPassword());
                arrayList.add(user.getUserType());
                arrayList.add(user.getUserEmail());
                arrayList.add(user.getUserPhone());
                usersJson.add(JSONArray.fromObject(arrayList));
            }
            JSONArray users = JSONArray.fromObject(usersJson.toArray());


            System.out.println(users);

            out.println(users);
            out.flush();
            out.close();
            HibernateUntil.getSessionFactory().getCurrentSession().getTransaction().commit();
        }
        catch (Exception ex) {
            HibernateUntil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            if (ServletException.class.isInstance(ex)) {
                throw (ServletException) ex;
            } else {
                throw new ServletException(ex);
            }
        }
    }
}
