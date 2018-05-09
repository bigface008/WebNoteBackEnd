package Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "test_web_note", catalog = "")
public class UserEntity {
    private int userId;
    private String userName;
    private String userPassword;
    private String userType;
    private String userEmail;
    private String userPhone;

    @Id
    @Column(name = "userId")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "userPassword")
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "userType")
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Basic
    @Column(name = "userEmail")
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "userPhone")
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return userId == that.userId &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userPassword, that.userPassword) &&
                Objects.equals(userType, that.userType) &&
                Objects.equals(userEmail, that.userEmail) &&
                Objects.equals(userPhone, that.userPhone);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, userName, userPassword, userType, userEmail, userPhone);
    }
}
