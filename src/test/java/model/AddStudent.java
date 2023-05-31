package model;

import org.junit.jupiter.api.Test;
import org.w3c.dom.ranges.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.Date;

/**
 *  Implement and test {Programme.addStudent } that respects the considtion given the assignment specification
 * NOTE: You are expected to verify that the constraints to add a new student to a programme are met.
 *
 * Each test criteria must be in an independent test method .
 *
 * Initialize the test object with initialise method.
 */
public class AddStudent {
	@Test
    void studentAbletoEnrolTest() throws IllegalStudentEnrollException{
   
        Programme program = new Programme();
        program.setStartDate(LocalDate.of(24, 10, 10));
        assertEquals(true, program.addStudent(new Student("Daniel",123),LocalDate.of(23,10,14)));
    }

    @Test
    void studentEnrolmentLateTest() throws IllegalStudentEnrollException{
     
        Programme program = new Programme();
        program.setStartDate(LocalDate.of(24, 10, 10));
        assertEquals(false, program.addStudent(new Student("Daniel",123),LocalDate.of(24,11,14)));
    }

    @Test
    void tooManyStudentsTest() throws IllegalStudentEnrollException{
        
        Programme program = new Programme();
        program.setStartDate(LocalDate.of(24, 10, 10));
        for (int i =0; i < 250; i++){
             program.addStudent(new Student("Daniel",i),LocalDate.of(23,11,14));
           
        }
        assertEquals(false, program.addStudent(new Student("Daniel",123),LocalDate.of(23,11,14)));
    }


    @Test
    void studentAlreadyAdded() throws IllegalStudentEnrollException{
        
        Programme program = new Programme();
        program.setStartDate(LocalDate.of(24, 10, 10));
        Student student = new Student("Daniel",123);
        
        program.addStudent(student,LocalDate.of(23,11,14));
           
        
        assertThrows(IllegalStudentEnrollException.class, ()-> program.addStudent(student,LocalDate.of(23,11,14)));
    }

}