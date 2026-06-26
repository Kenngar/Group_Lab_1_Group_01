/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.CourseSchedule;

import Business.Course.Course;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class SeatAssignment {

    
    public float grade; //(Letter grade mappings: A=4.0, A-=3.7, B+=3.3, B=3.0, )
    Seat seat;
    boolean like; //true means like and false means not like
    CourseLoad courseload;
    private ArrayList<File> submittedAssignments;
    
    public void submitAssignment(File file) {
        submittedAssignments.add(file);
    }

    public ArrayList<File> getSubmittedAssignments() {
        return submittedAssignments;
    }
    
    public SeatAssignment(CourseLoad cl, Seat s){
        seat = s;
        courseload = cl;
        submittedAssignments = new ArrayList<>();    }

    public boolean getLike() {
        return like;
    }

    public void assignSeatToStudent(CourseLoad cl) {
        courseload = cl;
    }

    public int getCreditHours() {
        return seat.getCourseCredits();

    }

    public Seat getSeat() {
        return seat;
    }

    public CourseOffer getCourseOffer() {

        return seat.getCourseOffer();
    }

    public Course getAssociatedCourse() {

        return getCourseOffer().getSubjectCourse();
    }

    public float GetCourseStudentScore() {
        return getCreditHours() * grade;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public CourseLoad getCourseLoad() {
        return courseload;
    }

    
    @Override
    public String toString() {
    // Display the grade instead of the object reference
    return String.valueOf(grade);
    }
    
}
