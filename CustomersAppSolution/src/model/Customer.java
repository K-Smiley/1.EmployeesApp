package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author mga
 */
public class Customer {
    // <<final>> -id:int
    private final int id;
    // -customerName:String
    private String customerName;
    // -customerProjects:List<Project>
    private List<Project> customerProjects;
    
    // - lastAllocatedId:int = 0
    private static int lastIdAllocated = 0;
    
    /**
     * <<create>> +Customer()
     */
    public Customer() {
        this.id = ++lastIdAllocated;
        this.customerName = "Unknown";
        this.customerProjects = new ArrayList<>();
    }
    
    /**
     * <<create>> + Customer(customerName:String)
     * 
     * @param customerName
     */
    public Customer(String customerName) {
        this.id = ++lastIdAllocated;
        this.customerName = customerName;
        this.customerProjects = new ArrayList<>();
    }
    
    /**
     * <<create>> +Customer(id:int, customerName:String)
     * 
     * @param id
     * @param customerName
     */
    public Customer(int id, String customerName) {
        this.id = id;
        this.customerName = customerName;
        this.customerProjects = new ArrayList<>();
    }
    
    /**
     * <<create>> +Customer(id:int, customerName:String, customerProjects: List<Project>
     * 
     * @param id
     * @param customerName
     * @param customerProjects
     */
    public Customer(int id, String customerName, List<Project> customerProjects) {
        this.id = id;
        this.customerName = customerName;
        this.customerProjects = customerProjects;
    }    
        
    /**
     * +getId():int
     * 
     * @return id
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * +getCustomerName() : String
     * 
     * @return customerName
     */
    public String getCustomerName() {
        return this.customerName;
    }
    
    /**
     * +setCustomerName(customerName:String)
     * 
     * @param customerName
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    /**
     * +getCustomerProjects():List<Project>
     * 
     * @return customerProjects
     */
    public List<Project> getCustomerProjects() {
        return this.customerProjects;
    }
     
    /**
     * +setCustomerProjects(customerProjects:List<Project>
     * 
     * @param customerProjects
     */
    public void setCustomerProjects(List<Project> customerProjects) {
        this.customerProjects = customerProjects;
    }
    
    /**
     * +addProject(project:Project)
     *
     * @param project
     */
    public void addProject(Project project) {
        this.customerProjects.add(project);
    }

    /**
     * +removeProject(projectCode:String)
     *
     * @param projectCode
     */
    public void removeProject(String projectCode) {
        Predicate<Project> projectPredicate = p -> p.getProjectCode().equals(projectCode);       
        this.customerProjects.removeIf(projectPredicate); 
    }
   
    /**
     * +toString():String
     * 
     * @return
     */
    @Override
    public String toString() {
        return "\nCustomer Id: " + id + " - customerName: " + customerName +            
                "\nProjects: " + customerProjects + "\n";
    }
}
