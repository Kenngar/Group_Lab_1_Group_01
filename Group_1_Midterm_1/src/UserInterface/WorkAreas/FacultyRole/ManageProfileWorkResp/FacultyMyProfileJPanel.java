package UserInterface.WorkAreas.FacultyRole.ManageProfileWorkResp;

import Business.Business;
import Business.Person.Person;
import Business.Profiles.FacultyProfile;
import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * WR2 - Manage Own Profile
 * Faculty can view and update their own profile details.
 */
public class FacultyMyProfileJPanel extends javax.swing.JPanel {

    JPanel CardSequencePanel;
    Business business;
    UserAccount userAccount;

    public FacultyMyProfileJPanel(Business bz, UserAccount ua, JPanel clp) {
        this.business = bz;
        this.userAccount = ua;
        this.CardSequencePanel = clp;
        initComponents();
        populate();
    }

    private void populate() {
        FacultyProfile profile = (FacultyProfile) userAccount.getAssociatedPersonProfile();
        Person person = profile.getPerson();

        lblNameValue.setText(person.getName());
        lblRoleValue.setText(profile.getRole());
        lblLastUpdatedValue.setText(userAccount.getLastUpdatedText());

        txtTitle.setText(profile.getTitle() != null ? profile.getTitle() : "");
        txtEmail.setText(person.getEmail() != null ? person.getEmail() : "");
        txtPhone.setText(person.getPhoneNumber() != null ? person.getPhoneNumber() : "");
        txtUsername.setText(userAccount.getUserLoginName());
        txtPassword.setText(userAccount.getPassword());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        lblFacultyTitle = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblLastUpdated = new javax.swing.JLabel();
        lblNameValue = new javax.swing.JLabel();
        lblRoleValue = new javax.swing.JLabel();
        lblLastUpdatedValue = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnUpdateProfile = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));

        lblTitle.setFont(new java.awt.Font("Arial", 0, 24));
        lblTitle.setText("My Profile (Faculty)");

        lblName.setFont(new java.awt.Font("Helvetica Neue", 0, 15));
        lblName.setText("Name");

        lblRole.setFont(new java.awt.Font("Helvetica Neue", 0, 15));
        lblRole.setText("Role");

        lblFacultyTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 15));
        lblFacultyTitle.setText("Title");

        lblEmail.setFont(new java.awt.Font("Helvetica Neue", 0, 15));
        lblEmail.setText("Email");

        lblPhone.setFont(new java.awt.Font("Helvetica Neue", 0, 15));
        lblPhone.setText("Phone");

        lblUserName.setFont(new java.awt.Font("Helvetica Neue", 0, 15));
        lblUserName.setText("User Name");

        lblPassword.setFont(new java.awt.Font("Helvetica Neue", 0, 15));
        lblPassword.setText("Password");

        lblLastUpdated.setFont(new java.awt.Font("Helvetica Neue", 0, 15));
        lblLastUpdated.setText("Last Updated");

        lblNameValue.setFont(new java.awt.Font("Helvetica Neue", 0, 14));
        lblNameValue.setForeground(new java.awt.Color(255, 255, 255));

        lblRoleValue.setFont(new java.awt.Font("Helvetica Neue", 0, 14));
        lblRoleValue.setForeground(new java.awt.Color(255, 255, 255));

        lblLastUpdatedValue.setFont(new java.awt.Font("Helvetica Neue", 0, 14));
        lblLastUpdatedValue.setForeground(new java.awt.Color(255, 255, 255));

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnUpdateProfile.setText("Update Profile");
        btnUpdateProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateProfileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdateProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName)
                            .addComponent(lblRole, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFacultyTitle)
                            .addComponent(lblEmail)
                            .addComponent(lblPhone)
                            .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPassword)
                            .addComponent(lblLastUpdated, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNameValue, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRoleValue, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLastUpdatedValue, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitle)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(lblNameValue, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRole)
                    .addComponent(lblRoleValue, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFacultyTitle)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserName)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLastUpdated)
                    .addComponent(lblLastUpdatedValue, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnUpdateProfile))
                .addGap(40, 40, 40))
        );
    }// </editor-fold>

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
        CardSequencePanel.remove(this);
        ((CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }

    private void btnUpdateProfileActionPerformed(java.awt.event.ActionEvent evt) {
        String titleVal = txtTitle.getText().trim();
        String email = txtEmail.getText().trim();
        String phone = txtPhone.getText().trim();
        String un = txtUsername.getText().trim();
        String pw = txtPassword.getText().trim();

        if (email.isEmpty() || phone.isEmpty() || un.isEmpty() || pw.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required.", "Validation", JOptionPane.WARNING_MESSAGE);
            return;
        }

        UserAccountDirectory uad = business.getUserAccountDirectory();
        UserAccount existing = uad.findByUsername(un);
        if (existing != null && existing != userAccount) {
            JOptionPane.showMessageDialog(this, "That username is already taken.", "Duplicate", JOptionPane.WARNING_MESSAGE);
            return;
        }

        FacultyProfile profile = (FacultyProfile) userAccount.getAssociatedPersonProfile();
        Person person = profile.getPerson();

        profile.setTitle(titleVal);
        person.setEmail(email);
        person.setPhoneNumber(phone);
        userAccount.setUserLoginName(un);
        userAccount.setPassword(pw);
        userAccount.setLastUpdated(new java.util.Date());

        lblLastUpdatedValue.setText(userAccount.getLastUpdatedText());
        JOptionPane.showMessageDialog(this, "Profile updated successfully.");
    }

    // Variables declaration
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnUpdateProfile;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFacultyTitle;
    private javax.swing.JLabel lblLastUpdated;
    private javax.swing.JLabel lblLastUpdatedValue;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameValue;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblRoleValue;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtTitle;
    private javax.swing.JTextField txtUsername;
}
