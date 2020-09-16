package myProject;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="MyClass_table")
public class MyClass {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long studentId;
    private String status;
    private String studentName;
    private String className;
    private int cnt;

    @PostUpdate
    public void onPostUpdate(){
        SignApproved signApproved = new SignApproved();
        BeanUtils.copyProperties(this, signApproved);
        signApproved.publishAfterCommit();


    }


    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }




}
