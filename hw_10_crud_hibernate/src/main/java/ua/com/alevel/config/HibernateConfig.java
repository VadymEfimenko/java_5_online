package ua.com.alevel.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.springframework.stereotype.Service;


@Service
public class HibernateConfig {

    private final SessionFactory sessionFactory;
    private static HibernateConfig instance = new HibernateConfig();

    private HibernateConfig() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

    public static HibernateConfig getInstance() {
        return instance;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
