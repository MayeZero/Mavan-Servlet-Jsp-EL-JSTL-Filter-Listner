package com.study;

public class Emp {
    int Empno;
    String Ename;
    String Job;
    Department department;

    public void setEmpno(int empno) {
        Empno = empno;
    }

    public int getEmpno() {
        return Empno;
    }

    public void setEname(String ename) {
        Ename = ename;
    }

    public String getEname() {
        return Ename;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setJob(String job) {
        Job = job;
    }

    public String getJob() {
        return Job;
    }
}
