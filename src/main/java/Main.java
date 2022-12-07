import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata =
                new MetadataSources(serviceRegistry)
                        .addAnnotatedClass(User.class)
                        .getMetadataBuilder()
                        .build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        session.beginTransaction();


        session.save(new User("Nick","Patton"));
        session.save(new User("Sherlock","Homes"));
        session.save(new User("Jack"));
        session.save(new User("Sam"));
        session.save(new User("Lily"));
        session.save(new User("Peggy","Nelson"));


        List<User> list =
//        session.createNativeQuery("select * from user_table", User.class).list();
        session.createQuery("select u from User u",User.class).list();
        System.out.println(list);

        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }
}