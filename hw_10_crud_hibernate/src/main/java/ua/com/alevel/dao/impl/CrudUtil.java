package ua.com.alevel.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import ua.com.alevel.config.HibernateConfig;
import ua.com.alevel.dao.BaseDAO;
import ua.com.alevel.entity.BaseEntity;

import java.util.List;
import java.util.Optional;

@Service
public class CrudUtil<E extends BaseEntity> implements BaseDAO<E> {

    private final SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

    @Override
    public void create(E entity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
    }

    @Override
    public void update(E entity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
    }

    @Override
    public void delete(E entity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
    }

    @Override
    public Optional<E> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<E> findAll() {
        return null;
    }

    private void rollbackTransaction(Transaction transaction) {
        if (transaction != null) {
            transaction.rollback();
        }
    }
}
