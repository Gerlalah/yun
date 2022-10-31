package cn.wolfcode.entity;

import java.sql.Date;

public class T_Pic {


    public String pcode;
    public String pname;
    public String pclass;
    public String pstatus;
    public Date ptime;
    public String pauthor;

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPclass() {
        return pclass;
    }

    public void setPclass(String pclass) {
        this.pclass = pclass;
    }

    public String getPstatus() {
        return pstatus;
    }

    public void setPstatus(String pstatus) {
        this.pstatus = pstatus;
    }

    public Date getPtime() {
        return ptime;
    }

    public void setPtime(Date ptime) {
        this.ptime = ptime;
    }

    public String getPauthor() {
        return pauthor;
    }

    public void setPauthor(String pauthor) {
        this.pauthor = pauthor;
    }

    @Override
    public String toString() {
        return "T_Pic{" +
                "pcode='" + pcode + '\'' +
                ", pname='" + pname + '\'' +
                ", pclass='" + pclass + '\'' +
                ", pstatus='" + pstatus + '\'' +
                ", ptime=" + ptime +
                ", pauthor='" + pauthor + '\'' +
                '}';
    }
}
