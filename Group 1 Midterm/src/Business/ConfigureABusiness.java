/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

*/
package Business;

import Business.Course.Course;
import Business.CourseSchedule.CourseLoad;
import Business.CourseSchedule.CourseOffer;
import Business.CourseSchedule.CourseSchedule;
import Business.CourseSchedule.SeatAssignment;
import Business.Department.Department;
import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Profiles.EmployeeDirectory;
import Business.Profiles.EmployeeProfile;
import Business.Profiles.StudentDirectory;
import Business.Profiles.StudentProfile;

import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;


/**
 *
 * @author kal bugrara
 */
class ConfigureABusiness {

    static Business initialize() {
        Business business = new Business("Information Systems");

// Create Persons
      PersonDirectory persondirectory = business.getPersonDirectory();
// person representing sales organization        
        Person person001 = persondirectory.newPerson("John Smith");
        Person person002 = persondirectory.newPerson("Gina Montana");
        Person person003 = persondirectory.newPerson("Adam Rollen");
 
        Person person005 = persondirectory.newPerson("Jim Dellon");
        Person person006 = persondirectory.newPerson("Anna Shnider");
        Person person007 = persondirectory.newPerson("Laura Brown");
        Person person008 = persondirectory.newPerson("Jack While");
        Person person009 = persondirectory.newPerson("Fidelity"); //we use this as customer

// Create Admins to manage the business
        EmployeeDirectory employeedirectory = business.getEmployeeDirectory();
        EmployeeProfile employeeprofile0 = employeedirectory.newEmployeeProfile(person001);
        
        StudentDirectory studentdirectory = business.getStudentDirectory();
        StudentProfile studentprofile0 = studentdirectory.newStudentProfile(person003);
        


   
// Create User accounts that link to specific profiles
        UserAccountDirectory uadirectory = business.getUserAccountDirectory();
        UserAccount ua3 = uadirectory.newUserAccount(employeeprofile0, "admin", "****"); /// order products for one of the customers and performed by a sales person
        UserAccount ua4 = uadirectory.newUserAccount(studentprofile0, "adam", "****"); /// order products for one of the customers and performed by a sales person

        Department department = new Department("MSIS");
        business.setDepartment(department);
        
        Course c001 = department.newCourse("0001", "INFO5001", 3);
        Course c002 = department.newCourse("0002", "INFO5002", 3);
        Course c003 = department.newCourse("0003", "APPL5011", 3);
        Course c004 = department.newCourse("0004", "APPL5012", 3);
        Course c005 = department.newCourse("0005", "SYST5021", 3);
        Course c006 = department.newCourse("0006", "SYST5022", 3);
        Course c007 = department.newCourse("0007", "DAMG5031", 3); 
        Course c008 = department.newCourse("0008", "DAMG5032", 3);
         
        CourseSchedule cs001 = department.newCourseSchedule("Fall 2026");
        CourseSchedule cs002 = department.newCourseSchedule("Spring 2027");
        
        CourseOffer co1 = cs001.newCourseOffer("INFO5001");
        CourseOffer co2 = cs002.newCourseOffer("INFO5002");
        CourseOffer co3 = cs001.newCourseOffer("APPL5011");
        CourseOffer co4 = cs002.newCourseOffer("APPL5012");
        CourseOffer co5 = cs001.newCourseOffer("SYST5021");
        CourseOffer co6 = cs002.newCourseOffer("SYST5022");
        CourseOffer co7 = cs001.newCourseOffer("DAMG5031");
        CourseOffer co8 = cs002.newCourseOffer("DAMG5032");
        CourseOffer co9 = cs002.newCourseOffer("INFO5001");
        
        department.addCoreCourse(c001);
        department.addCoreCourse(c002);
        department.addCoreCourse(c003);
        department.addCoreCourse(c004);
        department.addElectiveCourse(c005);
        department.addElectiveCourse(c006);
        department.addElectiveCourse(c007);
        department.addElectiveCourse(c008);
        
        CourseLoad load1 = studentprofile0.newCourseLoad("Fall 2026");
        SeatAssignment sa1 = co1.assignEmptySeat(load1);
        SeatAssignment sa2 = co2.assignEmptySeat(load1);
        return business;
    }

}
