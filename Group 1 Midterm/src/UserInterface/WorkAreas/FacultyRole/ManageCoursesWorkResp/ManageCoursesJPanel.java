package UserInterface.WorkAreas.FacultyRole.ManageCoursesWorkResp;

import Business.Business;
import Business.CourseSchedule.CourseOffer;
import Business.CourseSchedule.CourseSchedule;
import Business.Department.Department;
import Business.Profiles.FacultyAssignment;
import Business.Profiles.FacultyProfile;
import Business.UserAccounts.UserAccount;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import Business.CourseSchedule.Seat;

/**
 * WR1 - Manage Courses
 * Faculty can view all courses they are assigned to teach and update course details.
 */
public class ManageCoursesJPanel extends javax.swing.JPanel {

    JPanel CardSequencePanel;
    Business business;
    UserAccount userAccount;
    FacultyProfile facultyProfile;
    CourseOffer selectedCourseOffer;

    public ManageCoursesJPanel(Business bz, UserAccount ua, JPanel clp) {
        this.business = bz;
        this.userAccount = ua;
        this.CardSequencePanel = clp;
        this.facultyProfile = (FacultyProfile) ua.getAssociatedPersonProfile();
        initComponents();
        loadMyCourses();
    }

    private void loadMyCourses() {
        DefaultTableModel model = (DefaultTableModel) tblCourses.getModel();
        model.setRowCount(0);

        ArrayList<FacultyAssignment> assignments = facultyProfile.getFacultyassignments();
        for (FacultyAssignment fa : assignments) {
            CourseOffer co = fa.getCourseoffer();
            if (co != null) {
                String semester = co.getCourseSchedule() != null ? co.getCourseSchedule().getSemester() : "N/A";
                int seats = co.getSeatList().size();
                int enrolled = 0;
                for (Seat s : co.getSeatList()) {
                    if (s.isOccupied()) enrolled++;
                }
                model.addRow(new Object[]{
                    co.getCourseNumber(),
                    semester,
                    co.getCreditHours(),
                    enrolled + " / " + seats
                });
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCourses = new javax.swing.JTable();
        lblCourseNumber = new javax.swing.JLabel();
        lblSemester = new javax.swing.JLabel();
        lblCredits = new javax.swing.JLabel();
        txtCourseNumber = new javax.swing.JTextField();
        txtSemester = new javax.swing.JTextField();
        txtCredits = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblInfo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 153));

        lblTitle.setFont(new java.awt.Font("Arial", 0, 24));
        lblTitle.setText("Manage My Courses");

        tblCourses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"Course Number", "Semester", "Credits", "Enrollment"}
        ) {
            boolean[] canEdit = new boolean [] {false, false, false, false};
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCourses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblCoursesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblCourses);

        lblCourseNumber.setFont(new java.awt.Font("Helvetica Neue", 0, 15));
        lblCourseNumber.setText("Course Number");

        lblSemester.setFont(new java.awt.Font("Helvetica Neue", 0, 15));
        lblSemester.setText("Semester");

        lblCredits.setFont(new java.awt.Font("Helvetica Neue", 0, 15));
        lblCredits.setText("Credit Hours");

        lblInfo.setFont(new java.awt.Font("Helvetica Neue", 0, 13));
        lblInfo.setForeground(new java.awt.Color(255, 255, 255));
        lblInfo.setText("Select a course above to view or update details.");

        btnUpdate.setText("Update Course");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle)
                    .addComponent(lblInfo)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCourseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCourseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitle)
                .addGap(10, 10, 10)
                .addComponent(lblInfo)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCourseNumber)
                    .addComponent(txtCourseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSemester)
                    .addComponent(txtSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCredits)
                    .addComponent(txtCredits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnUpdate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>

    private void tblCoursesMousePressed(java.awt.event.MouseEvent evt) {
        int row = tblCourses.getSelectedRow();
        if (row < 0) return;

        ArrayList<FacultyAssignment> assignments = facultyProfile.getFacultyassignments();
        if (row < assignments.size()) {
            selectedCourseOffer = assignments.get(row).getCourseoffer();
            if (selectedCourseOffer != null) {
                txtCourseNumber.setText(selectedCourseOffer.getCourseNumber());
                txtSemester.setText(selectedCourseOffer.getCourseSchedule() != null
                        ? selectedCourseOffer.getCourseSchedule().getSemester() : "");
                txtCredits.setText(String.valueOf(selectedCourseOffer.getCreditHours()));
            }
        }
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        if (selectedCourseOffer == null) {
            JOptionPane.showMessageDialog(this, "Please select a course first.", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String newNumber = txtCourseNumber.getText().trim();
        if (newNumber.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Course number cannot be empty.", "Validation", JOptionPane.WARNING_MESSAGE);
            return;
        }
        selectedCourseOffer.setCourseNumber(newNumber);
        loadMyCourses();
        JOptionPane.showMessageDialog(this, "Course updated successfully.");
    }

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
        CardSequencePanel.remove(this);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }

    // Variables declaration
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCourseNumber;
    private javax.swing.JLabel lblCredits;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblSemester;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblCourses;
    private javax.swing.JTextField txtCourseNumber;
    private javax.swing.JTextField txtCredits;
    private javax.swing.JTextField txtSemester;
    // End of variables declaration
}
