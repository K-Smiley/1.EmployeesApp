package repositories;

import daos.DAO;
import daos.TestDAO;
import java.util.List;
import model.Customer;
import model.Employee;
import model.Project;

/**
 *
 * @author mga
 */
public class Repository {
    private DAO dao;
	
    /**
     *
     */
    public Repository() { 
    	dao = new TestDAO(); 
    }
    
    /**
     *
     * @return
     */
    public List<Customer> getItems() {      	
        return dao.getCustomers();
    }
    
    /**
     *
     * @param id
     * @return
     */
    public Customer getItem(int id) {
        return dao.getCustomer(id);
    }   
    
    /**
     *
     * @param item
     */
    public void add(Customer item) {
        dao.addCustomer(item);
    }
    
    /**
     *
     * @param project
     */
    public void update(Project project) {
    	dao.addProject(project);
    } 
    
    /**
     *
     * @param id
     * @param projectCode
     */
    public void update(int id, String projectCode) {
        dao.removeProject(id, projectCode);
    }     
    
    /**
     *
     * @return
     */
    public List<Employee> getEmployees() {      	
        return dao.getEmployees();
    }
    
    /**
     *
     * @param id
     * @return
     */
    public Employee getEmployee(int id) {
        return dao.getEmployee(id);
    }   
    
    /**
     *
     * @param item
     */
    public void addEmployee(Employee item) {
        dao.addEmployee(item);
    }    
    
    public Project getProject(String projectCode) {
        return dao.getProject(projectCode);
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "\nItems: " + getItems();
    }       
}
