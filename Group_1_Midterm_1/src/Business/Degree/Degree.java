/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Degree;

import Business.Course.Course;
import Business.CourseSchedule.SeatAssignment;
import Business.Profiles.StudentProfile;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class Degree {

    String title;
    public ArrayList<Course> corelist;
    ArrayList<Course> electives;

    public Degree(String name) {
        title = name;
        corelist = new ArrayList();
        electives = new ArrayList();
    }

    public void addCoreCourse(Course c) {
        corelist.add(c);

    }

    public void addElectiveCourse(Course c) {
        electives.add(c);

    }

    public boolean isStudentReadyToGraduate(StudentProfile sp) {

        ArrayList<SeatAssignment> sas = sp.getCourseList(); //seatAssignments extracted from course loads

        // Check if all core classes are satisfied
        if (validateCoreClasses(sas) == false) {
            return false;
        }
    
        // Calculate total credit hours
        int totalCredits = 0;
        for (SeatAssignment sa : sas) {
            totalCredits += sa.getCreditHours();
        }
    
        // Check if total credits meet minimum requirement (32)
        if (totalCredits < 32) {
            return false;
        }
    
        // Check electives - student must have at least 4 elective courses (or whatever your requirement is)
        int electiveCount = getTotalElectiveCoursesTaken(sas);
        if (electiveCount < 4) { // Adjust this number based on your program requirements
            return false;
        }
    
        // All requirements satisfied
        return true;

    }

    public boolean validateCoreClasses(ArrayList<SeatAssignment> sas) {

        //For each core course in the core list of the degree do the following:
        //Check if the core class at hand is in the transcrip
        //Repeat this check for the electives as well
        for (Course c : corelist) {
            if (!isCoreSatisfied(sas, c)) { //if selected core class not on the trascript return false
                return false;
            }
        }
        return true; //all core classes are on the transcript satifying core reqs

    }

    public boolean isCoreSatisfied(ArrayList<SeatAssignment> sas, Course c) {
        for (SeatAssignment sa : sas) {
            if (sa.getAssociatedCourse().equals(c)) {
                return true;
            }
        }
        return false;

    }

    public int getTotalElectiveCoursesTaken(ArrayList<SeatAssignment> sas) {
        int electivecount = 0;
        for (SeatAssignment sa : sas) {
            if (isElectiveSatisfied(sa)) {
                electivecount = electivecount + 1;
            }
        }
        return electivecount;

    }

    public boolean isElectiveSatisfied(SeatAssignment sa) {
        for (Course c : electives) {
            if (sa.getAssociatedCourse().equals(c)) {
                return true;
            }
        }
        return false;

    }

}
