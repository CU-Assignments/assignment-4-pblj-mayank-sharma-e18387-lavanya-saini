import java.util.*;
class Employee {
    int id;
    String name;
    double salary;
    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}
public class EmployeeManagementSystem {
    static ArrayList<Employee> empList = new ArrayList<>();
    static void addEmployee(Scanner sc) {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();
        empList.add(new Employee(id, name, salary));
        System.out.println("Employee Added Successfully!\n");
    }
    static void updateEmployee(Scanner sc) {
        System.out.print("Enter Employee ID to Update: ");
        int id = sc.nextInt();
        boolean found = false;
        for (Employee e : empList) {
            if (e.id == id) {
                sc.nextLine(); 
                System.out.print("Enter New Name: ");
                e.name = sc.nextLine();
                System.out.print("Enter New Salary: ");
                e.salary = sc.nextDouble();
                System.out.println("Employee Updated Successfully!\n");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee Not Found!\n");
        }
    }
    static void removeEmployee(Scanner sc) {
        System.out.print("Enter Employee ID to Remove: ");
        int id = sc.nextInt();
        boolean removed = empList.removeIf(e -> e.id == id);
        if (removed) {
            System.out.println("Employee Removed Successfully!\n");
        } else {
            System.out.println("Employee Not Found!\n");
        }
    }
    static void searchEmployee(Scanner sc) {
        System.out.print("Enter Employee ID to Search: ");
        int id = sc.nextInt();
        boolean found = false;
        for (Employee e : empList) {
            if (e.id == id) {
                System.out.println("Employee Found: " + e + "\n");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee Not Found!\n");
        }
    }
    static void displayEmployees() {
        if (empList.isEmpty()) {
            System.out.println("No Employees Available!\n");
            return;
        }
        System.out.println("All Employee Details:");
        for (Employee e : empList) {
            System.out.println(e);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: addEmployee(sc); break;
                case 2: updateEmployee(sc); break;
                case 3: removeEmployee(sc); break;
                case 4: searchEmployee(sc); break;
                case 5: displayEmployees(); break;
                case 6: System.out.println("Exiting... Thank you!"); break;
                default: System.out.println("Invalid Choice! Try Again.\n");
            }
        } while (choice != 6);
    }
}

