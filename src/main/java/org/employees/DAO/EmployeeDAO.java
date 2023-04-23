package org.employees.DAO;

import org.employees.Employee;

import java.util.List;

public interface EmployeeDAO {
    // Создание(добавление) сущности Employee в таблицу
    void create(Employee employee);

    // Получение конкретного объекта Employee по id
    Employee readById(int id);

    // Получение списка всех объектов Employee из базы
    List<Employee> readAll();

    // Изменение конкретного объекта Employee в базе
    void updateAmount(Employee employee);

    // Удаление конкретного объекта Employee из базы
    void delete(Employee employee);
}
