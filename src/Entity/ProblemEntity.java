package Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "problem", schema = "test_web_note", catalog = "")
public class ProblemEntity {
    private int problemId;
    private String problemName;
    private String userName;
    private String description;
    private String reason;
    private String subject;
    private String semester;
    private String addDate;
    private String latestEditDate;
    private Integer redoTimes;
    private String answer;
    private String tags;

    @Id
    @Column(name = "problemId")
    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    @Basic
    @Column(name = "problemName")
    public String getProblemName() {
        return problemName;
    }

    public void setProblemName(String problemName) {
        this.problemName = problemName;
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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "reason")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Basic
    @Column(name = "subject")
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Basic
    @Column(name = "semester")
    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Basic
    @Column(name = "addDate")
    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    @Basic
    @Column(name = "latestEditDate")
    public String getLatestEditDate() {
        return latestEditDate;
    }

    public void setLatestEditDate(String latestEditDate) {
        this.latestEditDate = latestEditDate;
    }

    @Basic
    @Column(name = "redoTimes")
    public Integer getRedoTimes() {
        return redoTimes;
    }

    public void setRedoTimes(Integer redoTimes) {
        this.redoTimes = redoTimes;
    }

    @Basic
    @Column(name = "answer")
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Basic
    @Column(name = "tags")
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProblemEntity that = (ProblemEntity) o;
        return problemId == that.problemId &&
                Objects.equals(problemName, that.problemName) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(description, that.description) &&
                Objects.equals(reason, that.reason) &&
                Objects.equals(subject, that.subject) &&
                Objects.equals(semester, that.semester) &&
                Objects.equals(addDate, that.addDate) &&
                Objects.equals(latestEditDate, that.latestEditDate) &&
                Objects.equals(redoTimes, that.redoTimes) &&
                Objects.equals(answer, that.answer) &&
                Objects.equals(tags, that.tags);
    }

    @Override
    public int hashCode() {

        return Objects.hash(problemId, problemName, userName, description, reason, subject, semester, addDate, latestEditDate, redoTimes, answer, tags);
    }
}
