package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Programmes offered by a university
 */
public class Programme {
    /**
     * Name and id of the programme
     */
    private String name;
    private String pID;

    /**
     * Start date of the programme
     */
    private LocalDate startDate;

    /**
     * End date of the programme
     */
    private LocalDate dueDate;

    /**
     * Estimated duration of the course in months
     */
    private int estimatedDuration;

    /**
     * Students allocated to the programme
     */
    private List<Student> enrolled = new ArrayList<Student>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return pID;
    }

    public void setID(String ID) {
        this.pID = ID;
    }


    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public int getEstimatedDuration() {
        return estimatedDuration;
    }

    public void setEstimatedDuration(int estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

    public List<Student> getEnrollments() {
        return enrolled;
    }

    
    public boolean removeEnrolledStudent(Student student) {
    
    	return false;
    	   
    }



    /**
     * Add a new student to the programme
     * @param Student: to enroll  to student in a programme 
     * @param Date: to check enrolemnt is within time
     * @return true if the student is successfully enrolled, false otherwise
     * @throws IllegalStudentEnrollException
     */

    public boolean addStudent(Student student, LocalDate localDate) throws IllegalStudentEnrollException{
        // Date starDate = getStartDate();
   
            if (localDate.compareTo(startDate) > 0){
                return false;
            }
            else{
                if (enrolled.contains(student)){
                
                    throw new IllegalStudentEnrollException("Student Already Enrolled");
                    
                }
                else if( enrolled.size()>=250){
                    return false;
                    
                }
                else{
                    enrolled.add(student);
                    Football football= new Football();
                    football.addAvailStudent(student);
                    return true;

                }

                
            }
     
   
    }

}
