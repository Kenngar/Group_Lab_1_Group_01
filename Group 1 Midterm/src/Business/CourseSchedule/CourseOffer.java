/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.CourseSchedule;

import Business.Course.Course;
import Business.Profiles.FacultyAssignment;
import Business.Profiles.FacultyProfile;
import java.util.ArrayList;

/**
 *
 * @author Kenneth Garcia
 */
public class CourseOffer {

    Course course;
    ArrayList<Seat> seatlist;
    FacultyAssignment facultyassignment;
    CourseSchedule courseSchedule;

    public CourseOffer(Course c, CourseSchedule cs) {
        course = c;
        courseSchedule = cs;
        seatlist = new ArrayList();
    }
    
    public CourseOffer(Course c){
        course = c;
        seatlist = new ArrayList();
    }
    
    public CourseSchedule getCourseSchedule() {
        return courseSchedule;
    }
     
    public void AssignAsTeacher(FacultyProfile fp) {

        facultyassignment = new FacultyAssignment(fp, this);
    }

    public FacultyProfile getFacultyProfile() {
        return facultyassignment.getFacultyProfile();
    }

    public String getCourseNumber() {
        return course.getCOurseNumber();
    }
    
    public void setCourseNumber(String courseNum){
        this.course.setNumber(courseNum);
    }

    public void generatSeats(int n) {

        for (int i = 0; i < n; i++) {

            seatlist.add(new Seat(this, i));

        }

    }

    public Seat getEmptySeat() {

        for (Seat s : seatlist) {

            if (!s.isOccupied()) {
                return s;
            }
        }
        return null;
    }


    public SeatAssignment assignEmptySeat(CourseLoad cl) {

        Seat seat = getEmptySeat();
        if (seat == null) {
            return null;
        }
        SeatAssignment sa = seat.newSeatAssignment(cl); //seat is already linked to course offer
        cl.registerStudent(sa); //coures offer seat is now linked to student
        return sa;
    }

    public int getTotalCourseRevenues() {

        int sum = 0;

        for (Seat s : seatlist) {
            if (s.isOccupied() == true) {
                sum = sum + course.getCoursePrice();
            }

        }
        return sum;
    }
    public Course getSubjectCourse(){
        return course;
    }
    public int getCreditHours(){
        return course.getCredits();
    }
    
    public ArrayList<Seat> getSeatList(){
        return seatlist;
    }

}
