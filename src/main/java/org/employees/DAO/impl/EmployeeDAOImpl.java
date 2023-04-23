package org.employees.DAO.impl;

import org.employees.DAO.EmployeeDAO;
import org.employees.Employee;
import org.employees.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    final String user = "postgres";
    final String password = "4717";
    final String url = "jdbc:postgresql://localhost:5432/skypro";

    @Override
    public void create(Employee employee) {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }


    @Override
    public Employee readById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().
                openSession().get(Employee.class, id);
    }

    @Override
    public List<Employee> readAll() {
        List<Employee> employees = (List<Employee>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from Employee").list();
        return employees;
    }

    @Override
    public void updateAmount(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }


    @Override
    public void delete(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }
}
