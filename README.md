# Group_Lab_1_Group_01
INFO5100 Group 1 Midterm

Project Title: Digital University System

1. Team Information: 
Kenneth Garcia - member 1 - Student use case 
Anh Nguyen - member 2 - Admin use case - implement user accounts, student records, faculty records, and their own profile
Christopher Carmant - member 3 - Faculty use case

2. Project Overview: 
The Digital University System is a Java Swing desktop application that models the core administrative operations of a university. The system supports three user roles(Administrator, Faculty, and Student), each with its own work area. After a user
logs in, the application authenticates their credentials and routes them to the work area that matches their role, enforcing role-based access control throughout.

3. Installation & Setup Instructions: 
    Netbeans IDE 16, JDK 19
// Provide step-by-step setup instructions, including how to clone the repository and run the project
- Once the skeleton code is uploaded to the group repo, each team member opens GitHub Desktop:
    1. On the main branch, click Fetch origin to pull the latest skeleton.
    2. Switch to your own branch (e.g. feature-member2).
    3. Merge main into your branch so you can work without affecting the main skeleton.
    4. Open the project in NetBeans and start your work.
    5. Run the project: Run → Run Project (or press F6). The login window appears.


4. Authentication & Access Control: 
// Explain the authentication process (e.g., login, logout)
- On launch, the application shows a login screen with User Name and Password fields.
  When the user clicks Login, the system calls UserAccountDirectory.AuthenticateUser(username, password), which checks the entered       credentials against every stored UserAccount.
  If no match is found, login is rejected and the user remains on the login screen.
  If a match is found, the system retrieves the account's associated Profile and routes the user to the correct work area.
// Describe the authorization rules for different user roles (Admin, Faculty, Student)
- After successful authentication, the system inspects the profile type and opens only that role's work area:
    Admin - EmployeeProfile - "Admin" - AdminRoleWorkAreaJPanel

5. Features Implemented
//Detail the functionalities implemented for each role
//Clearly specify which team member was responsible for each feature
Admin - (Anh Nguyen - Member 2)
- Administer User Accounts (ManageUserAccountsJPanel, AdminUserAccount, CreateUserAccountJPanel) 
  View all user accounts in a table (User Name, Status, Person, Last Updated).
  Create a new account for any person who has a profile but no account yet (the create screen lists only account-less profiles
  from the Employee, Student, and Faculty directories).
  Modify an account's username, password, and status; the person's name is shown read-only.
  Delete an account with a confirmation prompt.
- Register Persons (HR) (ManagePersonsJPanel → AdministerPersonJPanel)
  Register a new person with name, email, and phone.
  Select a registered person and assign them a role (Employee/Admin, Faculty, or Student), which creates the matching profile.
  Create a user account (username + password) for the newly profiled person, with duplicate username validation.
- Manage Students (ManageStudentJPanel)
  View all students (Name, Email, Phone, Hobbies).
  Update a selected student's details.
  Delete a student (and their linked login if one exists).
- Manage Faculty (ManageFacultyJPanel)
  View all faculty members in a table.
  Update a selected faculty member's name.
  Delete a faculty member.
- Manage Staff / Employees (ManageEmployeeJPanel)
  View all employees (Name, Email, Phone).
  Update a selected employee's details.
  Delete an employee, with a guard that prevents the logged-in admin from deleting their own record.
- My Profile (AdminMyProfileJPanel)
  View the logged-in admin's own details (name, role, last updated).
  Update their own email, phone, username, and password, with duplicate-username validation.

6. Usage Instructions
//Provide a step-by-step guide on how to interact with the system.
Logging in 
    Open the application.
    Enter a username and password from the seeded accounts (see the table below).
    Click Login. You are taken to the work area for that account's role.
    Click Logout (or the Back navigation) to return to the login screen.

//Include example scenarios for different user roles.
- Example scenario — Administrator
   ADMIN - Log in as admin / ****.
   Click Register Persons (HR), add a person (name, email, phone), then click Add Person.
   Select that person in the table and click Next.
   Choose a role (e.g. Employee/ Admin) and click Create Profile, then enter a username/password and click Create User Account.
   Return to Administer User Accounts to see the new account in the list; select it and click Modify to change the password, or Delete    to remove it.
   Use Manage Students / Manage Faculty / Manage Staff to view and edit existing records.
   Click My Profile to update your own contact details and credentials.


7. Testing Guide:
//Outline how to test the system, including sample test cases.
//Explain how to verify that authentication and authorization work correctly.

8. Challenges & Solutions
//Summarize any difficulties encountered during development.
//Highlight the solutions implemented to overcome these challenges.

ADMIN Role:
- Keeping the simplified Person model compatible with seeded data. The original model mixed the person id and display name. We simplified Person to a single-argument constructor and kept the id equal to the name, then set email/phone via setters in ConfigureABusiness. This matched the way the rest of the system creates people and avoided constructor-mismatch compile errors.
- Hand-built Swing forms and code staying in sync. Because the screens were designed by hand in the NetBeans Design tab, the action code had to reference the exact component variable names from the designer. Several early bugs were simply name mismatches (e.g. an empty table-selection handler meaning Delete/Modify could never find the selected row). The fix was to wire each table's mousePressed handler to set the selected object before any button used it.


9. Future Enhancements
//Suggest potential improvements or additional features that could be implemented.
ADMIN: 
- Separate admin and non-admin employees. Replace the hardcoded EmployeeProfile role with a flag so some staff are administrators and others are regular employees, and add a dedicated non-admin employee work area.
- Password security. Store hashed passwords instead of plain text, and mask the password field.


10. Contribution Breakdown:
//Clearly state each team member’s contributions to the project.
//Provide details on coding, documentation, testing, and other task

Member 2 - Anh Nguyen (Admin)
- Coding: Implemented the full Administrator work area and its screens — Manage User Accounts, Create/Administer User Account,         Register Persons, Administer Person (role + account creation), Manage Students, Manage Faculty, Manage Staff/Employees, and Admin My Profile. Contributed the Admin branch of the login routing and shared business-layer adjustments (Person, PersonDirectory, ConfigureABusiness seed data).
- Documentation: Authored the Administrator sections of this README (overview, features, usage, testing, challenges). 
- Testing: Manually tested all Administrator functions and the authentication/authorization flow. Other: Managed branch commits and pull requests for the Admin feature branch.


 
