package com.example.ltpastasbackend;

import org.hibernate.SessionFactory;
import java.io.File;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final  SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try
        {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration cfg = new Configuration();
            return cfg.configure(new File("src/main/java/com/example/ltpastasbackend/hibernate.cfg.xml"))
                    .addAnnotatedClass(CountryEntity.class)
                    .buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
