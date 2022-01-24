package program;
import models.Role;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        Role role = new Role();
//        role.setName("admin");
//        session.save(role);
//
//        Role role2 = new Role();
//        role2.setName("student");
//        session.save(role2);
        Query query = session.createQuery("FROM Role");
        List<Role> roles = query.list();
        for (Object role : roles)
            System.out.println(role);
        session.close();
    }
}
