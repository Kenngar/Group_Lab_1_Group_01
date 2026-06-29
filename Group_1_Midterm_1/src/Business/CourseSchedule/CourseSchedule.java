/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.CourseSchedule;

import Business.Course.Course;
import Business.Course.CourseCatalog;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseSchedule {

    CourseCatalog coursecatalog;

    ArrayList<CourseOffer> schedule;
    String semester;
    
    public CourseSchedule(String s, CourseCatalog cc) {
        semester = s;
        coursecatalog = cc;
        schedule = new ArrayList();

    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
    
    public ArrayList<CourseOffer> getSchedule() {
        return schedule;
    }

    public void setSchedule(ArrayList<CourseOffer> schedule) {
        this.schedule = schedule;
    }
    
    public CourseOffer newCourseOffer(String  n) {

        Course c = coursecatalog.getCourseByNumber(n);
        if(c==null) return null;
        CourseOffer co;
        co = new CourseOffer(c, this);
        schedule.add(co);
        return co;
    }

    public CourseOffer getCourseOfferByNumber(String n) {

        for (CourseOffer co : schedule) {

            if (co.getCourseNumber().equals(n)) {
                return co;
            }
        }
        return null;
    }

    public int calculateTotalRevenues() {
        int sum = 0;
        for (CourseOffer co : schedule) {

            sum = sum + co.getTotalCourseRevenues();

        }
        return sum;
    }

}
