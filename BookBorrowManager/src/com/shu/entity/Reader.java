package com.shu.entity;

import java.sql.Date;

/**
 * Created by Dell on 2017/2/23.
 */
public class Reader {
    private String readerid;
    private Integer type;
    private String name;
    private Integer age;
    private String sex;
    private String phone;
    private String dept;
    private Date regdate;

    public String getReaderid() {
        return readerid;
    }

    public void setReaderid(String readerid) {
        this.readerid = readerid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reader reader = (Reader) o;

        if (readerid != null ? !readerid.equals(reader.readerid) : reader.readerid != null) return false;
        if (type != null ? !type.equals(reader.type) : reader.type != null) return false;
        if (name != null ? !name.equals(reader.name) : reader.name != null) return false;
        if (age != null ? !age.equals(reader.age) : reader.age != null) return false;
        if (sex != null ? !sex.equals(reader.sex) : reader.sex != null) return false;
        if (phone != null ? !phone.equals(reader.phone) : reader.phone != null) return false;
        if (dept != null ? !dept.equals(reader.dept) : reader.dept != null) return false;
        if (regdate != null ? !regdate.equals(reader.regdate) : reader.regdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = readerid != null ? readerid.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (dept != null ? dept.hashCode() : 0);
        result = 31 * result + (regdate != null ? regdate.hashCode() : 0);
        return result;
    }
}
