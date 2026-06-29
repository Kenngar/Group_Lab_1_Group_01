package UserInterface.WorkAreas.FacultyRole.PerformanceReportWorkResp;

import Business.Business;
import Business.CourseSchedule.CourseOffer;
import Business.CourseSchedule.Seat;
import Business.CourseSchedule.SeatAssignment;
import Business.Profiles.FacultyAssignment;
import Business.Profiles.FacultyProfile;
import Business.UserAccounts.UserAccount;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 * WR3 - Generate Performance Reports
 * Faculty can view student grades for their courses and set grades.
 */
public class PerformanceReportJPanel extends javax.swing.JPanel {

    JPanel CardSequencePanel;
    Business business;
    UserAccount userAccount;
    FacultyProfile facultyProfile;
    SeatAssignment selectedSeatAssignment;
    CourseOffer selectedCourseOffer;

    public PerformanceReportJPanel(Business bz, UserAccount ua, JPanel clp) {
        this.business = bz;
        this.userAccount = ua;
        this.CardSequencePanel = clp;
        this.facultyProfile = (FacultyProfile) ua.getAssociatedPersonProfile();
        initComponents();
        loadCourseDropdown();
    }

    private void loadCourseDropdown() {
        cmbCourse.removeAllItems();
        ArrayList<FacultyAssignment> assignments = facultyProfile.getFacultyassignments();
        for (FacultyAssignment fa : assignments) {
            if (fa.getCourseoffer() != null) {
                cmbCourse.addItem(fa.getCourseoffer().getCourseNumber());
            }
        }
    }

    private void loadStudentGrades() {
        DefaultTableModel model = (DefaultTableModel) tblGrades.getModel();
        model.setRowCount(0);

        String selectedCourse = (String) cmbCourse.getSelectedItem();
        if (selectedCourse == null) return;

        selectedCourseOffer = null;
        for (FacultyAssignment fa : facultyProfile.getFacultyassignments()) {
            if (fa.getCourseoffer() != null
                    && fa.getCourseoffer().getCourseNumber().equals(selectedCourse)) {
                selectedCourseOffer = fa.getCourseoffer();
                break;
            }
        }

        if (selectedCourseOffer == null) return;

        float total = 0;
        int count = 0;
        for (Seat seat : selectedCourseOffer.getSeatList()) {
            if (seat.isOccupied()) {
                SeatAssignment sa = seat.getSeatAssignment();
                if (sa != null) {
                    float grade = sa.getGrade();
                    float score = sa.GetCourseStudentScore();
                    String studentLabel = "Student " + (count + 1);
                    model.addRow(new Object[]{studentLabel, grade, score});
                    total += grade;
                    count++;
                }
            }
        }

        if (count > 0) {
            lblAvgValue.setText(String.format("%.2f", total / count));
        } else {
            lblAvgValue.setText("N/A");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblSelectCourse = new javax.swing.JLabel();
        cmbCourse = new javax.swing.JComboBox<>();
        btnLoad = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGrades = new javax.swing.JTable();
        lblAvg = new javax.swing.JLabel();
        lblAvgValue = new javax.swing.JLabel();
        lblSetGrade = new javax.swing.JLabel();
        txtGrade = new javax.swing.JTextField();
        btnSetGrade = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblInfo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 153));

        lblTitle.setFont(new java.awt.Font("Arial", 0, 24));
        lblTitle.setText("Performance Reports");

        lblSelectCourse.setFont(new java.awt.Font("Helvetica Neue", 0, 15));
        lblSelectCourse.setText("Select Course:");

        btnLoad.setText("Load Grades");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        tblGrades.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"Student", "Grade (0-4.0)", "Score"}
        ) {
            boolean[] canEdit = new boolean[]{false, false, false};
            public boolean isCellEditable(int row, int col) { return canEdit[col]; }
        });
        tblGrades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblGradesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblGrades);

        lblAvg.setFont(new java.awt.Font("Helvetica Neue", 1, 15));
        lblAvg.setText("Class Average Grade:");

        lblAvgValue.setFont(new java.awt.Font("Helvetica Neue", 0, 15));
        lblAvgValue.setForeground(new java.awt.Color(255, 255, 255));
        lblAvgValue.setText("N/A");

        lblSetGrade.setFont(new java.awt.Font("Helvetica Neue", 0, 15));
        lblSetGrade.setText("Set Grade for Selected Student:");

        lblInfo.setFont(new java.awt.Font("Helvetica Neue", 0, 13));
        lblInfo.setForeground(new java.awt.Color(255, 255, 255));
        lblInfo.setText("Select a student row to set their grade.");

        btnSetGrade.setText("Set Grade");
        btnSetGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetGradeActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSelectCourse)
                        .addGap(10, 10, 10)
                        .addComponent(cmbCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnLoad))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAvg)
                        .addGap(10, 10, 10)
                        .addComponent(lblAvgValue, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblInfo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSetGrade)
                        .addGap(10, 10, 10)
                        .addComponent(txtGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnSetGrade))
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitle)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSelectCourse)
                    .addComponent(cmbCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoad))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAvg)
                    .addComponent(lblAvgValue))
                .addGap(15, 15, 15)
                .addComponent(lblInfo)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSetGrade)
                    .addComponent(txtGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSetGrade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {
        loadStudentGrades();
    }

    private void tblGradesMousePressed(java.awt.event.MouseEvent evt) {
        int row = tblGrades.getSelectedRow();
        if (row < 0 || selectedCourseOffer == null) return;

        int occupiedCount = 0;
        for (Seat seat : selectedCourseOffer.getSeatList()) {
            if (seat.isOccupied()) {
                if (occupiedCount == row) {
                    selectedSeatAssignment = seat.getSeatAssignment();
                    if (selectedSeatAssignment != null) {
                        txtGrade.setText(String.valueOf(selectedSeatAssignment.getGrade()));
                    }
                    break;
                }
                occupiedCount++;
            }
        }
    }

    private void btnSetGradeActionPerformed(java.awt.event.ActionEvent evt) {
        if (selectedSeatAssignment == null) {
            JOptionPane.showMessageDialog(this, "Please select a student first.", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            float grade = Float.parseFloat(txtGrade.getText().trim());
            if (grade < 0 || grade > 4.0) {
                JOptionPane.showMessageDialog(this, "Grade must be between 0.0 and 4.0.", "Validation", JOptionPane.WARNING_MESSAGE);
                return;
            }
            selectedSeatAssignment.setGrade(grade);
            loadStudentGrades();
            JOptionPane.showMessageDialog(this, "Grade set successfully.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number (e.g. 3.7).", "Validation", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
        CardSequencePanel.remove(this);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }

    // Variables declaration
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnSetGrade;
    private javax.swing.JComboBox<String> cmbCourse;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAvg;
    private javax.swing.JLabel lblAvgValue;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblSelectCourse;
    private javax.swing.JLabel lblSetGrade;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblGrades;
    private javax.swing.JTextField txtGrade;
    // End of variables declaration
}
