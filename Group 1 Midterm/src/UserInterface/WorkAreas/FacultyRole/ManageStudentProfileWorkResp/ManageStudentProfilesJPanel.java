package UserInterface.WorkAreas.FacultyRole.ManageStudentProfileWorkResp;

import Business.Business;
import Business.CourseSchedule.CourseOffer;
import Business.CourseSchedule.Seat;
import Business.CourseSchedule.SeatAssignment;
import Business.Profiles.FacultyAssignment;
import Business.Profiles.FacultyProfile;
import Business.Profiles.StudentDirectory;
import Business.Profiles.StudentProfile;
import Business.UserAccounts.UserAccount;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 * WR4 - Manage Student Profiles
 * Faculty can view hobbies, interests, and academic progress
 * of students enrolled in their courses.
 */
public class ManageStudentProfilesJPanel extends javax.swing.JPanel {

    JPanel CardSequencePanel;
    Business business;
    UserAccount userAccount;
    FacultyProfile facultyProfile;
    StudentProfile selectedStudentProfile;

    public ManageStudentProfilesJPanel(Business bz, UserAccount ua, JPanel clp) {
        this.business = bz;
        this.userAccount = ua;
        this.CardSequencePanel = clp;
        this.facultyProfile = (FacultyProfile) ua.getAssociatedPersonProfile();
        initComponents();
        loadEnrolledStudents();
    }

    private void loadEnrolledStudents() {
        DefaultTableModel model = (DefaultTableModel) tblStudents.getModel();
        model.setRowCount(0);

        ArrayList<FacultyAssignment> assignments = facultyProfile.getFacultyassignments();
        StudentDirectory studentDirectory = business.getStudentDirectory();

        for (FacultyAssignment fa : assignments) {
            CourseOffer co = fa.getCourseoffer();
            if (co == null) continue;
            String courseNum = co.getCourseNumber();
            for (Seat seat : co.getSeatList()) {
                if (seat.isOccupied()) {
                    SeatAssignment sa = seat.getSeatAssignment();
                    if (sa != null) {
                        
                        // Find the student profile that owns this course load
                        for (StudentProfile sp : studentDirectory.getStudentList()) {
                            if (sp.getCourseList().contains(sa)) {
                                String name = sp.getPerson().getName();
                                String hobbies = sp.getHobbies();
                                float score = sp.getTranscript().getStudentTotalScore();
                                model.addRow(new Object[]{
                                    name,
                                    courseNum,
                                    hobbies,
                                    String.format("%.1f", score)
                                });
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudents = new javax.swing.JTable();
        lblName = new javax.swing.JLabel();
        lblHobbies = new javax.swing.JLabel();
        lblInterests = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        lblNameValue = new javax.swing.JLabel();
        lblHobbiesValue = new javax.swing.JLabel();
        lblInterestsValue = new javax.swing.JLabel();
        lblScoreValue = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));

        lblTitle.setFont(new java.awt.Font("Arial", 0, 24));
        lblTitle.setText("Manage Student Profiles");

        lblInfo.setFont(new java.awt.Font("Helvetica Neue", 0, 13));
        lblInfo.setForeground(new java.awt.Color(255, 255, 255));
        lblInfo.setText("Students enrolled in your courses — click a row to view their profile.");

        tblStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"Student Name", "Course", "Hobbies", "Total Score"}
        ) {
            boolean[] canEdit = new boolean[]{false, false, false, false};
            public boolean isCellEditable(int row, int col) { return canEdit[col]; }
        });
        tblStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblStudentsMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblStudents);

        lblName.setFont(new java.awt.Font("Helvetica Neue", 0, 15));
        lblName.setText("Name");

        lblHobbies.setFont(new java.awt.Font("Helvetica Neue", 0, 15));
        lblHobbies.setText("Hobbies");

        lblInterests.setFont(new java.awt.Font("Helvetica Neue", 0, 15));
        lblInterests.setText("Interests");

        lblScore.setFont(new java.awt.Font("Helvetica Neue", 0, 15));
        lblScore.setText("Total Score");

        lblNameValue.setFont(new java.awt.Font("Helvetica Neue", 0, 14));
        lblNameValue.setForeground(new java.awt.Color(255, 255, 255));
        lblNameValue.setText("—");

        lblHobbiesValue.setFont(new java.awt.Font("Helvetica Neue", 0, 14));
        lblHobbiesValue.setForeground(new java.awt.Color(255, 255, 255));
        lblHobbiesValue.setText("—");

        lblInterestsValue.setFont(new java.awt.Font("Helvetica Neue", 0, 14));
        lblInterestsValue.setForeground(new java.awt.Color(255, 255, 255));
        lblInterestsValue.setText("—");

        lblScoreValue.setFont(new java.awt.Font("Helvetica Neue", 0, 14));
        lblScoreValue.setForeground(new java.awt.Color(255, 255, 255));
        lblScoreValue.setText("—");

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHobbies, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInterests, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblScore, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNameValue, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHobbiesValue, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInterestsValue, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblScoreValue, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitle)
                .addGap(8, 8, 8)
                .addComponent(lblInfo)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(lblNameValue))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHobbies)
                    .addComponent(lblHobbiesValue))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInterests)
                    .addComponent(lblInterestsValue))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblScore)
                    .addComponent(lblScoreValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>

    private void tblStudentsMousePressed(java.awt.event.MouseEvent evt) {
        int row = tblStudents.getSelectedRow();
        if (row < 0) return;

        DefaultTableModel model = (DefaultTableModel) tblStudents.getModel();
        String studentName = (String) model.getValueAt(row, 0);

        StudentDirectory sd = business.getStudentDirectory();
        for (StudentProfile sp : sd.getStudentList()) {
            if (sp.getPerson().getName().equals(studentName)) {
                selectedStudentProfile = sp;
                lblNameValue.setText(sp.getPerson().getName());
                lblHobbiesValue.setText(sp.getHobbies() != null ? sp.getHobbies() : "N/A");
                lblInterestsValue.setText(sp.getInterests() != null ? sp.getInterests() : "N/A");
                lblScoreValue.setText(String.format("%.1f", sp.getTranscript().getStudentTotalScore()));
                break;
            }
        }
    }

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
        CardSequencePanel.remove(this);
        ((CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }

    // Variables declaration
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHobbies;
    private javax.swing.JLabel lblHobbiesValue;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblInterests;
    private javax.swing.JLabel lblInterestsValue;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameValue;
    private javax.swing.JLabel lblScore;
    private javax.swing.JLabel lblScoreValue;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblStudents;
}
