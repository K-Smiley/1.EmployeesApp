package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author mga
 */
public abstract class Project {

    /**
     * #projectCode:String
     */
    protected String projectCode;

    /**
     * #projectTitle:String
     */
    protected String projectTitle;

    /**
     * #startDate:Calendar
     */
    protected Calendar startDate;

    /**
     * #customerId:int
     */
    protected int customerId;

    /**
     * <<create>> +Project()
     */
    public Project() {
        this.projectCode = "Unknown";
        this.projectTitle = "Unknown";
        this.startDate = null;
        this.customerId = 0;
    } 

    /**
     * <<create>> +Project(projectCode:String, projectTitle:String, startDate:Calendar, customerId:int)
     * 
     * @param projectCode
     * @param projectTitle
     * @param startDate
     * @param customerId
     */
    public Project(String projectCode, String projectTitle, Calendar startDate, int customerId) {
    	this.projectCode = projectCode;    	
        this.projectTitle = projectTitle;
        this.startDate = startDate;
        this.customerId = customerId;        
    }
    
    /**
     * +getProjectCode():String
     * 
     * @return projectCode
     */
    public String getProjectCode() {
        return projectCode;
    }

    /**
     * +setProjectCode(projectCode:String)
     * 
     * @param projectCode
     */
    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }    

    /**
     * +getProjectTitle():String
     *
     * @return
     */
    public String getProjectTitle() {
        return projectTitle;
    }

    /**
     * +setProjectTitle(projectTitle:String)
     *
     * @param projectTitle
     */
    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    /**
     * +getStartDate():Calendar
     *
     * @return startDate
     */
    public Calendar getStartDate() {
        return this.startDate;
    }

    /**
     * +setStartDate(startDate:Calendar)
     *
     * @param startDate
     */
    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }    
    
    /**
     * +getCustomerId():int
     *
     * @return customerId
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * +setCustomerId(customerId:int)
     *
     * @param customerId
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }       
    
    /**
     * #getFormattedStartDate():String
     *
     * @return formattedStartDate
     */
    protected String getFormattedStartDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
        String dateString = formatter.format(this.startDate.getTime());
        return dateString;
    }
    
    /**
     * +toString():String
     *
     * @return
     */
    @Override
    public String toString() {
        return "\nProject Code: " + this.projectCode + " projectTitle=" + this.projectTitle + ", startDate=" + getFormattedStartDate() + ", customer=" + Integer.toString(customerId);
    }      
    
    public abstract boolean employeeAllocatedToProject(int employeeId);
    
}
