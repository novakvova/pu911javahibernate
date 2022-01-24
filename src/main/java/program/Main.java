package program;
import models.Role;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateSessionFactoryUtil;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Scanner in = new Scanner(System.in, "UTF-8");
        System.out.println("Enter role name:");
        Role role = new Role();
        role.setName(in.nextLine());
        session.save(role);
//
//        Role role2 = new Role();
//        role2.setName("student");
//        session.save(role2);
        Query query = session.createQuery("FROM Role");
        List<Role> roles = query.list();
        System.out.println("Roles list: ");
        for (Object item : roles)
            System.out.println(item);
        session.close();
    }
}
