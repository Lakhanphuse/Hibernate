package domain;

import javax.persistence.*;

@Entity
@Table(name = "student_info")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studid")
    private int studId;
    @Column(name = "studname")
    private String studName;
    @Column(name = "studpercent")
    private double studPercent;
    @Column(name = "studstream")
    private String studStream;

    public Student(int studId, String studName, double studPercent, String studStream) {
        this.studId = studId;
        this.studName = studName;
        this.studPercent = studPercent;
        this.studStream = studStream;
    }

     public Student(){

    }

    public int getStudId(int id) {
        return studId;
    }

    public void setStudId(int studId) {
        this.studId = studId;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public double getStudPercent() {
        return studPercent;
    }

    public void setStudPercent(double studPercent) {
        this.studPercent = studPercent;
    }

    public String getStudStream(String stream) {
        return studStream;
    }

    public void setStudStream(String studStream) {
        this.studStream = studStream;
    }

    @Override
    public String toString() {
        return studId+"\t"+studName+"\t"+studPercent+"\t"+studStream;
    }
}
