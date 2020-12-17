package daos;

import java.util.List;

import model.Customer;
import model.Employee;
import model.Project;

/**
 *
 * @author mga
 */
public abstract class DAO {

    /**
     *
     * @param customer
     */
    public abstract void addCustomer(Customer customer);

    /**
     *
     * @param project
     */
    public abstract void addProject(Project project);	

    /**
     *
     * @param customerId
     * @param projectCode
     */
    public abstract void removeProject(int customerId, String projectCode);

    /**
     *
     * @param customerId
     * @return
     */
    public abstract Customer getCustomer(int customerId);

    /**
     *
     * @return
     */
    public abstract List<Customer> getCustomers();	
    
    public abstract List<Employee> getEmployees();
    
    public abstract Employee getEmployee(int employeeId);
    
    public abstract void addEmployee(Employee employee);
    
    public abstract Project getProject(String projectCode);
}
