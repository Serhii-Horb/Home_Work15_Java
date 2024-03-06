package org.example.Task4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Task4 {
    public static void main(String[] args) {
        List<Employee> employeeList =
                List.of(new Employee("Петров", "Пётp", "Петрович", "Сторож", "Автоцех", 850),
                        new Employee("Петров", "Пётp", "Петрович", "Сторож", "Автоцех", 800),
                        new Employee("Иванов", "Иван", "Иваныч", "Слесарь", "Автоцех", 1750),
                        new Employee("Сидоров", "Степан", "Степаныч", "Инженер", "Маркетинг", 1950),
                        new Employee("Платонова", "Анна", "Викторовна", "Инженер", "Маркетинг", 2500),
                        new Employee("Шаповал", "Ольга", "Анатольевна", "Директор", "Маркетинг", 4500));
        System.out.println(averageSalary(employeeList));
        System.out.println(minSalary(employeeList));
        System.out.println(salaryIncrease(employeeList, "Маркетинг", 1.15));
        System.out.println(findMinSalaryEmployee(employeeList));
        System.out.println(findMaxSalaryEmployee(employeeList));
        System.out.println(findEmployeeWithMaxSalary(employeeList));
        System.out.println(groupEmployeesByPosition(employeeList));
    }

    // Вычислить среднюю зарплату всех сотрудников
    private static double averageSalary(List<Employee> employeeList) {
        return employeeList.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .getAsDouble();
    }

    // Получить список сотрудников со зп > 1000
    private static List<Employee> minSalary(List<Employee> employeeList) {
        return employeeList.stream()
                .filter(employee -> employee.getSalary() > 1000)
                .toList();
    }

    // Получить список сотрудников из отдела маркетинг и увеличить зп на 15%
    private static List<Employee> salaryIncrease(List<Employee> employeeList, String department, double percent) {
        return employeeList.stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .map(employee -> new Employee(employee.getSurname(), employee.getName(), employee.getPatronymic(),
                        employee.getJobTitle(), employee.getDepartment(), employee.getSalary() * percent))
                .collect(Collectors.toList());
    }

    // Получить сотрудника с самой низкой зп
    private static Optional<Employee> findMinSalaryEmployee(List<Employee> employeeList) {
        return employeeList.stream()
                .min(Comparator.comparingDouble(Employee::getSalary));
    }

    // Получить сотрудника с самой высокой зп
    private static Optional<Employee> findMaxSalaryEmployee(List<Employee> employeeList) {
        return employeeList.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
    }

    // Получите сотрудников из всех отделов с максимальной зп
    private static Map<String, List<Employee>> findEmployeeWithMaxSalary(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                        optional -> optional.map(List::of).orElse(List.of())
                )));
    }

    // Сгруппировать сотрудников по должности
    private static Map<String, List<Employee>> groupEmployeesByPosition(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
