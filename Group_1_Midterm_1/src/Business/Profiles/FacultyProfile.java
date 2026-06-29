/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

import Business.Course.Course;
import Business.Profiles.*;
import Business.CourseSchedule.CourseOffer;
import Business.Person.Person;
import Business.UserAccounts.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class FacultyProfile extends Profile {

    Person person;
    String title;
    ArrayList<FacultyAssignment> facultyassignments;
    private UserAccount ua;

    public FacultyProfile(Person p) {
        super(p);
        this.person = p;
        this.facultyassignments = new ArrayList();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public double getProfAverageOverallRating() {

        double sum = 0.0;
        //for each facultyassignment extract class rating
        //add them up and divide by the number of teaching assignmnet;
        for (FacultyAssignment fa : facultyassignments) {

            sum = sum + fa.getRating();

        }
        //divide by the total number of faculty assignments

        return sum / (facultyassignments.size() * 1.0); //this ensure we have double/double

    }

    public FacultyAssignment AssignAsTeacher(CourseOffer co) {

        FacultyAssignment fa = new FacultyAssignment(this, co);
        facultyassignments.add(fa);

        return fa;
    }

    public FacultyAssignment getAssignmentByCourseId(String courseId) {
        for (FacultyAssignment fa : facultyassignments) {
            CourseOffer co = fa.getCourseoffer();
            if (co != null) { // adapt matching method to your model
                return fa;
            }
        }
        return null;
    }

    public boolean removeCourseAssignment(String courseId) {
        FacultyAssignment target = getAssignmentByCourseId(courseId);
        if (target == null) {
            return false;
        }
        return facultyassignments.remove(target);
    }

    public FacultyProfile getCourseOffer(String courseid) {
        return null; //complete it later
    }

    public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

    public ArrayList<FacultyAssignment> getFacultyassignments() {
        return facultyassignments;
    }
    
     public void setFacultyassignments(ArrayList<Course> sampleCourses) {
      this.facultyassignments = facultyassignments;
    }
     
     public void setUserAccount(UserAccount ua) {
        this.ua = ua;
    }


    @Override
    public String getRole() {
        return "Faculty";
    }

   
}
