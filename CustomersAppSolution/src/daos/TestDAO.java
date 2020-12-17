package daos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import model.Customer;
import model.Project;
import model.PlannedProject;
import model.AdHocProject;
import model.Employee;

/**
 *
 * @author mga
 */
public class TestDAO extends DAO {
	List<Customer> customersList;
        List<Employee> employeesList;
        List<Project> projectsList;

    /**
     *
     */
    public TestDAO() {
        populateCustomers();
        populateEmployees();
        populateProjects();
        
        customersList.get(0).addProject(projectsList.get(0));
        employeesList.get(0).addProjectToEmployee(projectsList.get(0).getProjectCode());
        
        customersList.get(0).addProject(projectsList.get(1));
        employeesList.get(0).addProjectToEmployee(projectsList.get(1).getProjectCode());
        employeesList.get(1).addProjectToEmployee(projectsList.get(1).getProjectCode());

        customersList.get(0).addProject(projectsList.get(2));
        employeesList.get(0).addProjectToEmployee(projectsList.get(2).getProjectCode());
        
        customersList.get(1).addProject(projectsList.get(3));        
        employeesList.get(2).addProjectToEmployee(projectsList.get(3).getProjectCode());
        
        customersList.get(1).addProject(projectsList.get(4));        
        employeesList.get(0).addProjectToEmployee(projectsList.get(4).getProjectCode());        

        customersList.get(2).addProject(projectsList.get(5));        
        employeesList.get(2).addProjectToEmployee(projectsList.get(5).getProjectCode());
        employeesList.get(0).addProjectToEmployee(projectsList.get(5).getProjectCode());
        employeesList.get(1).addProjectToEmployee(projectsList.get(5).getProjectCode());          
    }

    @Override
    public List<Customer> getCustomers() {
        return customersList;
    }

    @Override
    public Customer getCustomer(int customerId) {
        Iterator<Customer> it = customersList.iterator();
        while (it.hasNext()) {
            Customer customer = (Customer) it.next();
            if (customer.getId() == customerId) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void addCustomer(Customer customer) {
    	customersList.add(customer);
    }
    
    @Override
    public List<Employee> getEmployees() {
        return employeesList;
    }

    @Override
    public Employee getEmployee(int employeeId) {
        Iterator<Employee> it = employeesList.iterator();
        while (it.hasNext()) {
            Employee employee = (Employee) it.next();
            if (employee.getId() == employeeId) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public void addEmployee(Employee employee) {
    	employeesList.add(employee);
    }    

    @Override
    public void addProject(Project project) {
        Iterator<Customer> it = customersList.iterator();
        while (it.hasNext()) {
            Customer customer = (Customer) it.next();
            if (customer.getId() == project.getCustomerId()) {
            	customer.addProject(project);
            }
        }
    }

    @Override
    public void removeProject(int customerId, String projectCode) {
        Iterator<Customer> it = customersList.iterator();
        while (it.hasNext()) {
            Customer customer = (Customer) it.next();
            if (customer.getId() == customerId) {
            	customer.removeProject(projectCode);
            }
        }
    }
    
    @Override
    public Project getProject(String projectCode) {
        Iterator<Project> it = projectsList.iterator();
        while (it.hasNext()) {
            Project project = (Project) it.next();
            if (project.getProjectCode().equals(projectCode)) {
                return project;
            }
        }
        return null;
    }    
    
    private void populateEmployees() {
        this.employeesList = new ArrayList<>();
        Employee employee1 = new Employee(1, "Andres", "Iniesta", 1, 500000);
        employeesList.add(employee1);
        Employee employee2 = new Employee(2, "Sergi", "Busquets", 2, 200000);
        employeesList.add(employee2);
        Employee employee3 = new Employee(3, "Leo", "Messi", 1, 1500000);
        employeesList.add(employee3);        
    }
    
    private void populateCustomers() {
        this.customersList = new ArrayList<>();
        Customer customer1 = new Customer(1, "Barcelona");
        customersList.add(customer1);
        Customer customer2 = new Customer(2, "Bilbao");
        customersList.add(customer2);        
        Customer customer3 = new Customer(3, "Sevilla");
        customersList.add(customer3);           
    }    
    
    private void populateProjects() {
        this.projectsList = new ArrayList<>();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2020,04,01);
        Set<Employee> projectEmployees1 = new HashSet<>();
        projectEmployees1.add(employeesList.get(0));
        Project project1 = new PlannedProject("Proj1", "Project 1", calendar1, 1, projectEmployees1, 2);
        this.projectsList.add(project1);  
        
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2020,05,02);
        Set<Employee> projectEmployees2 = new HashSet<>();
        projectEmployees2.add(employeesList.get(0));
        projectEmployees2.add(employeesList.get(1));
        Project project2 = new PlannedProject("Proj2", "Project 2", calendar2, 1, projectEmployees2, 3);
        this.projectsList.add(project2);
        
        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(2020,05,04);
        Project project3 = new AdHocProject("Proj3", "Project 3", calendar3, 1, employeesList.get(0));
        this.projectsList.add(project3);  
        
        Calendar calendar4 = Calendar.getInstance();
        calendar4.set(2020,05,02);
        Set<Employee> projectEmployees4 = new HashSet<>();
        projectEmployees4.add(employeesList.get(2));
        Project project4 = new PlannedProject("Proj4", "Project 4", calendar4, 2, projectEmployees4, 12);   
        this.projectsList.add(project4);        
     
        Calendar calendar5 = Calendar.getInstance();
        calendar5.set(2020,06,02);
        Project project5 = new AdHocProject("Proj5", "Project 5", calendar5, 2, employeesList.get(0));   
        this.projectsList.add(project5);        
        
        Calendar calendar6 = Calendar.getInstance();
        calendar6.set(2020,07,17);
        Set<Employee> projectEmployees6 = new HashSet<>();
        projectEmployees6.add(employeesList.get(2));
        projectEmployees6.add(employeesList.get(0));
        projectEmployees6.add(employeesList.get(1));
        Project project6 = new PlannedProject("Proj6", "Project 6", calendar6, 3, projectEmployees6, 21);   
        this.projectsList.add(project6);         
    }
}
