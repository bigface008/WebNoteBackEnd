package Servlet;

import Entity.ProblemEntity;
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

@WebServlet("/Source")
public class SourceServlet extends HttpServlet {

    public SourceServlet() {
        super();
    }

    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HibernateUntil.getSessionFactory().getCurrentSession().beginTransaction();
            PrintWriter out = response.getWriter();
            response.setContentType("text/html;charset=utf-8");

            System.out.println("This is a source manager");

            List<ProblemEntity> problem_result = HibernateUntil.getSessionFactory()
                    .getCurrentSession().createQuery("from ProblemEntity").list();
            Iterator<ProblemEntity> probelm_it = problem_result.iterator();

            ArrayList<JSONArray> problemsJson = new ArrayList<JSONArray>();
            while (probelm_it.hasNext()) {
                ProblemEntity problem = (ProblemEntity) probelm_it.next();
                ArrayList<String> arrayList = new ArrayList<String>();
                arrayList.add(String.valueOf(problem.getProblemId()));
                arrayList.add(problem.getUserName());
                arrayList.add(problem.getProblemName());
                arrayList.add(problem.getSubject());
                arrayList.add(problem.getDescription());
                arrayList.add(problem.getReason());
                arrayList.add(problem.getAddDate());
                arrayList.add(problem.getAnswer());
                arrayList.add(problem.getSemester());
                arrayList.add(String.valueOf(problem.getRedoTimes()));
                problemsJson.add(JSONArray.fromObject(arrayList));
            }
            JSONArray problems = JSONArray.fromObject(problemsJson.toArray());

            List<UserEntity> user_result = HibernateUntil.getSessionFactory()
                    .getCurrentSession().createQuery("from UserEntity").list();
            Iterator<UserEntity> user_it = user_result.iterator();

            ArrayList<JSONArray> usersJson = new ArrayList<JSONArray>();
            while (user_it.hasNext()) {
                UserEntity user = (UserEntity) user_it.next();
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

            ArrayList<JSONArray> result = new ArrayList<JSONArray>();
            result.add(problems);
            result.add(users);

            System.out.println(problems);

            out.println(result);
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
