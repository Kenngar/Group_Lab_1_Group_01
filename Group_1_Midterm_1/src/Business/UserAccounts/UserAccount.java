/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccounts;

import Business.Profiles.Profile;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author kal bugrara
 */
public class UserAccount {

    Profile profile;
    String username;
    String password;
    String status = "Active";
    Date lastUpdated;

    public UserAccount(Profile profile, String un, String pw) {
        username = un;
        password = pw;
        this.profile = profile;

    }

    public String getPersonId() {
        return profile.getPerson().getPersonId();
    }

    public String getUserLoginName() {
        return username;
    }

    public void setUserLoginName(String un) {
        this.username = un;
        markUpdated();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pw) {
        this.password = pw;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getLastUpdatedText() {
        return format(lastUpdated);
    }

    private String format(Date d) {
        if (d == null) {
            return "Never";
        }
        return new SimpleDateFormat("MM/dd/yyyy").format(d);
    }

    public boolean isMatch(String id) {
        if (getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

    public boolean IsValidUser(String un, String pw) {

        if (username.equalsIgnoreCase(un) && password.equals(pw)) {
            return true;
        } else {
            return false;
        }

    }

    public String getRole() {
        return profile.getRole();
    }

    public Profile getAssociatedPersonProfile() {
        return profile;
    }

    @Override
    public String toString() {
        return getUserLoginName();
    }

    private void markUpdated() {
        lastUpdated = new Date();
    }

}
