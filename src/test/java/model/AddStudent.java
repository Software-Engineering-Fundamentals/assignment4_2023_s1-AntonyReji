package model;

import org.junit.jupiter.api.Test;
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
    void test1(){
        Date date = new Date();
        Programme program = new Programme();
        program.setStartDate(LocalDate.of(24, 10, 10));
        assertEquals(true, program.addStudent(new Student("Daniel",123),LocalDate.of(23,10,14)));
    }



}