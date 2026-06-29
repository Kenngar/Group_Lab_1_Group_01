/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

import Business.CourseSchedule.CourseLoad;
import Business.CourseSchedule.SeatAssignment;
import Business.Person.Person;
import Business.UserAccounts.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class StudentProfile extends Profile {

    Person person;
    Transcript transcript;
    //   EmploymentHistroy employmenthistory;

    public StudentProfile(Person p) {
        super(p);

        transcript = new Transcript(this);
//        employmenthistory = new EmploymentHistroy();
    }

    UserAccount ua;
    String hobbies = "N/A";
    String interests = "N/A";

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public boolean isMatch(String id) {
        return person.getPersonId().equals(id);
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public CourseLoad getCourseLoadBySemester(String semester) {

        return transcript.getCourseLoadBySemester(semester);
    }

    public CourseLoad getCurrentCourseLoad() {

        return transcript.getCurrentCourseLoad();
    }

    public CourseLoad newCourseLoad(String s) {
        CourseLoad cl = transcript.newCourseLoad(s);
        cl.setStudentProfile(this);
        return cl;
    }

    public ArrayList<SeatAssignment> getCourseList() {

        return transcript.getCourseList();

    }
    
      public void setUserAccount(UserAccount ua) {
    this.ua = ua;
}
      
     public String getHobbies() {
        return hobbies;
    }
    
    public void setHobbies(){
        this.hobbies = hobbies;
    }

    @Override
    public String getRole() {
        return "Student"; 
    }
    
    public String getInterests() {
    return interests;
}

public void setInterests(String interests) {
    this.interests = interests;
}

}
