package model;

import java.util.Calendar;

/**
 *
 * @author mga
 */
public class AdHocProject extends Project {
    // -projectEmployee:int
    private Employee projectEmployee;

    /**
     * <<create>> +AdHocProject()
     */
    public AdHocProject() {
        super();
        this.projectEmployee = new Employee();
    }

    /**
     * <<create>> +AdHocProject(projectCode:String, projectTitle:String, startDate:Calendar, customerId:int, projectEmployee:int)
     *
     * @param projectCode
     * @param projectTitle
     * @param startDate
     * @param customerId
     * @param projectEmployee
     */
    public AdHocProject(String projectCode, String projectTitle, Calendar startDate, int customerId, Employee projectEmployee) {
        super(projectCode, projectTitle, startDate, customerId);
        this.projectEmployee = projectEmployee;
    }

    /**
     * +getProjectEmployee():int
     *
     * @return projectEmployee
     */
    public Employee getProjectEmployee() {
        return this.projectEmployee;
    }

    /**
     * +setProjectEmployee(projectEmployee:int)
     *
     * @param projectEmployee
     */
    public void setProjectEmployee(Employee projectEmployee) {
        this.projectEmployee = projectEmployee;
    }

    public boolean employeeAllocatedToProject(int employeeId) {
        return employeeId == this.projectEmployee.getId();
    }
    
    /**
    * +toString():String
    */
    @Override
    public String toString() {
        return super.toString() + "\nProject Employee: " + this.projectEmployee;
    }
}
