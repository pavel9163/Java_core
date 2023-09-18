import java.util.ArrayList;
import java.util.List;

// Базовый класс Employee
abstract class Employee {
    private String name;
    
    public Employee(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    // Абстрактный метод для расчёта среднемесячной заработной платы
    public abstract double calculateMonthlySalary();
}

// Потомок класса Employee - Freelancer (работник с почасовой оплатой)
class Freelancer extends Employee {
    private double hourlyRate;
    
    public Freelancer(String name, double hourlyRate) {
        super(name);
        this.hourlyRate = hourlyRate;
    }
    
    @Override
    public double calculateMonthlySalary() {
        return 20.8 * 8 * hourlyRate;
    }
}

// Потомок класса Employee - Worker (работник с фиксированной оплатой)
class Worker extends Employee {
    private double fixedMonthlySalary;
    
    public Worker(String name, double fixedMonthlySalary) {
        super(name);
        this.fixedMonthlySalary = fixedMonthlySalary;
    }
    
    @Override
    public double calculateMonthlySalary() {
        return fixedMonthlySalary;
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем коллекцию сотрудников
        List<Employee> employees = new ArrayList<>();
        
        // Добавляем работников разных типов
        employees.add(new Freelancer("Иван", 15.0));
        employees.add(new Worker("Петр", 2000.0));
        employees.add(new Freelancer("Мария", 20.0));
        employees.add(new Worker("Анна", 2500.0));
        
        // Выводим информацию о заработной плате каждого сотрудника
        for (Employee employee : employees) {
            System.out.println("Сотрудник: " + employee.getName());
            System.out.println("Среднемесячная заработная плата: " + employee.calculateMonthlySalary());
            System.out.println();
        }
    }
}
