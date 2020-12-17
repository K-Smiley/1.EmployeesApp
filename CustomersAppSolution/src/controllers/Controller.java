package controllers;

import helpers.InputHelper;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.AdHocProject;
import model.Customer;
import model.Employee;
import model.PlannedProject;
import model.Project;
import repositories.Repository;

/**
 *
 * @author mga
 */
public class Controller {
    private Repository repository;

    /**
     *
     */
    public Controller() {
        repository = new Repository();
    }

    /**
     *
     */
    public void run() {
        boolean finished = false;

        do {
            InputHelper inputHelper = new InputHelper();
            System.out.print("\nA. List Customers");
            System.out.print("\tB. Add Project");
            System.out.print("\tC. Remove Project");
            System.out.print("\nD. List Employees");
            System.out.print("\tE. Add Employee"); 
            System.out.print("\nF. List Employee Details");
            System.out.print("\tQ. Quit\n");
            char choice = inputHelper.readCharacter("Enter choice", "ABCDEFQ");
            switch (choice) {
                case 'A':
                	listCustomers();
                    break;
                case 'B':
                	addProjectToCustomer();
                    break;
                case 'C':
                	removeProjectFromCustomer();
                    break;
                case 'D':
                	listEmployees();
                    break;
                case 'E':
                	addEmployee();
                    break;               
                case 'F':
                	listEmployeeDetails();
                    break;                    
                case 'Q':
                    finished = true;
            }
        } while (!finished);
    }

    private void listCustomers() {
        System.out.println("List Customers");
        System.out.println("==============");
        List<Customer> customersList = repository.getItems();
        System.out.println(customersList);
    }

    private void addProjectToCustomer() {
        System.out.println("Add Project");
        System.out.println("===========");
        InputHelper inputHelper = new InputHelper();
        Customer requiredCustomer = findCustomer();
        System.out.println("Customer\n========\n" + requiredCustomer);
        String newProjectCode = inputHelper.readString("Enter New Project Code");
        String newProjectTitle = inputHelper.readString("Enter New Project Title");
        Calendar newStartDate = inputHelper.readDate("Enter New Start Date", "yyyy-MM-dd");
        char c = inputHelper.readCharacter("Planned or Ad Hoc Project (P/A)?", "PA");
        if (c == 'P' || c == 'p') {
            Set<Employee> projectEmployees = new HashSet<>();
            boolean moreEmployees = true;
            do {
                int employeeId = inputHelper.readInt("Enter Employee (0 to finish)");
                if (employeeId != 0) {
                    Employee employee = repository.getEmployee(employeeId);
                    projectEmployees.add(employee);
                }    
                else
                    moreEmployees = false;
            } while (moreEmployees);
            int noAllocatedDays = inputHelper.readInt("Enter Allocated Days");
            Project newProject = new PlannedProject(newProjectCode, newProjectTitle, newStartDate, requiredCustomer.getId(), projectEmployees, noAllocatedDays);
            repository.update(newProject);
        }
        else {
            int employeeId = inputHelper.readInt("Enter Employee");
            Employee employee = repository.getEmployee(employeeId);
            Project newProject = new AdHocProject(newProjectCode, newProjectTitle, newStartDate, requiredCustomer.getId(), employee);
            repository.update(newProject);
        }
    }

    private void removeProjectFromCustomer() {
        InputHelper inputHelper = new InputHelper();
        System.out.println("Remove Project");
        System.out.println("==============");
        Customer requiredCustomer = findCustomer();
        System.out.println("Customer\n========\n" + requiredCustomer);
        String projectCode = inputHelper.readString("Enter Project Code");
        repository.update(requiredCustomer.getId(), projectCode);
    }

    private Customer findCustomer() {
        InputHelper inputHelper = new InputHelper();
        Customer requiredCustomer=null;
        int customerId;
        do {
            customerId = inputHelper.readInt("Enter Customer Id (0 to Quit)");
            if (customerId != 0) {
                requiredCustomer = repository.getItem(customerId);
                if (requiredCustomer != null)
                    return requiredCustomer;
                else
                    System.out.println("Customer Not Found");
            }
        } while (customerId != 0);
        return null;
    }
    
    private void listEmployees() {
        System.out.println("List Employees");
        System.out.println("==============");
        List<Employee> employeesList = repository.getEmployees();
        System.out.println(employeesList);
    }    
    
    private void addEmployee() {
        InputHelper inputHelper = new InputHelper();
        String firstName = inputHelper.readString("Enter New Employee's first name");
        String lastName = inputHelper.readString("Enter New Employee's last name");        
        Employee newEmployee = new Employee(firstName, lastName);
        this.repository.addEmployee(newEmployee);
    }
    
    /* Solution 1
    private void listEmployeeDetails() {
        System.out.println("List Employee Details");
        System.out.println("=====================");
        InputHelper inputHelper = new InputHelper();         
        int employeeId = inputHelper.readInt("Enter Employee Id"); 
        Employee employee = repository.getEmployee(employeeId);
        System.out.println(employee);
        String str ="";
        List<Customer> customersList = repository.getItems();
        for (Customer customer : customersList) {
            boolean flag = false;
            for (Project project : customer.getCustomerProjects()) {
                // If Employee is allocated to Project Then
                if (project.employeeAllocatedToProject(employeeId)) {
                    //System.out.println(project);
                    str += "Project Code: " + project.getProjectCode() + " Title: " + project.getProjectTitle() +"\n";
                    flag = true;
                // End If
                }
            }
            if (flag)
                //System.out.println(customer);
                str += "Id: " + Integer.toString(customer.getId()) + " Name: " + customer.getCustomerName() + "\n";
        }
        System.out.println(str);
    } */
    
    // Solution 2
    private void listEmployeeDetails() {
        System.out.println("List Employee Details");
        System.out.println("=====================");
        InputHelper inputHelper = new InputHelper();         
        int employeeId = inputHelper.readInt("Enter Employee Id"); 
        Employee employee = repository.getEmployee(employeeId);
        String str = "Id: " + Integer.toString(employee.getId()) + " Name: " + employee.getName() + "\n";
        for (String project : employee.getEmployeeProjects()) {
            Project requiredProject = repository.getProject(project);
            str += "Project Code : " + requiredProject.getProjectCode() + " Title: " + requiredProject.getProjectTitle() +"\n";
            Customer requiredCustomer = repository.getItem(requiredProject.getCustomerId());
            str += "Customer: " + Integer.toString(requiredCustomer.getId()) + " Name: " + requiredCustomer.getCustomerName() + "\n";
        }
        System.out.println(str);
    }
}
