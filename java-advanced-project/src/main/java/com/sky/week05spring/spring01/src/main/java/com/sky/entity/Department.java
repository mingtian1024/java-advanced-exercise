package com.sky.entity;

public class Department {
    int deptNo;
    String deptNames;

    public Department(int deptNo, String deptNames) {
        this.deptNo = deptNo;
        this.deptNames = deptNames;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptNames() {
        return deptNames;
    }

    public void setDeptNames(String deptNames) {
        this.deptNames = deptNames;
    }

    @Override
    public String toString() {
        return "Departments{" +
                "deptNo=" + deptNo +
                ", deptNames='" + deptNames + '\'' +
                '}';
    }
}

