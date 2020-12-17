package model;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author mga
 */
public class PlannedProject extends Project {
    // -projectEmployees: Set<Integer>
    private Set<Employee> projectEmployees;
    // -noOfAllocatedDays: int
    private int noOfAllocatedDays;

    /**
     * <<create>> +PlannedProject()
     */
    public PlannedProject() {
        super();
        this.projectEmployees = new HashSet<>();
        this.noOfAllocatedDays = 0;
    }

    /**
     * <<create>> +PlannedProject(projectCode:String, projectTitle:String, startDate:Calendar, customerId:int, noOfAllocatedDays:int)
     *
     * @param projectCode
     * @param projectTitle
     * @param startDate
     * @param customerId
     * @param noOfAllocatedDays
     */
    public PlannedProject(String projectCode, String projectTitle, Calendar startDate, int customerId, int noOfAllocatedDays) {
        super(projectCode, projectTitle, startDate, customerId);
        this.projectEmployees = new HashSet<>();
        this.noOfAllocatedDays = noOfAllocatedDays;
    }    

    /**
     *  <<create>> +PlannedProject(projectCode:String, projectTitle:String, startDate:Calendar, customerId:int, projectEmployees:Set<Project>, noOfAllocatedDays:int)
     *
     * @param projectCode
     * @param projectTitle
     * @param startDate
     * @param customerId
     * @param projectEmployees
     * @param noOfAllocatedDays
     */
    public PlannedProject(String projectCode, String projectTitle, Calendar startDate, int customerId, Set<Employee> projectEmployees, int noOfAllocatedDays) {
        super(projectCode, projectTitle, startDate, customerId);
        this.projectEmployees = projectEmployees;
        this.noOfAllocatedDays = noOfAllocatedDays;
    }

    /**
     * +getProjectEmployees():Set<Integer>
     *
     * @return projectEmployees
     */
    public Set<Employee> getProjectEmployees() {
        return this.projectEmployees;
    }

    /**
     * +setProjectEmployees(projectEmployees:Set<Integer>)
     *
     * @param projectEmployees
     */
    public void setProjectEmployees(Set<Employee> projectEmployees) {
        this.projectEmployees = projectEmployees;
    }

    /**
     * +getNoOfAllocatedDays():int
     *
     * @return noOfAllocatedDays
     */
    public int getNoOfAllocatedDays() {
        return this.noOfAllocatedDays;
    }

    /**
     * +setNoOfAllocatedDays(noOfAllocatedDays:int)
     *
     * @param noOfAllocatedDays
     */
    public void setNoOfAllocatedDayas(int noOfAllocatedDays) {
        this.noOfAllocatedDays = noOfAllocatedDays;
    }
    
    public boolean employeeAllocatedToProject(int employeeId) {
        boolean employeeAllocated = false;
        for (Employee employee:this.projectEmployees) {
            if (employee.getId() == employeeId)
                employeeAllocated = true;
        }
        return employeeAllocated;
    }

    /**
     * +toString():String
     * 
     * @return 
     */
    @Override
    public String toString() {
        return super.toString() + "\nProject Employees: " + this.projectEmployees +
            " Allocated Days: " + Integer.toString(this.noOfAllocatedDays);
    }    
}
