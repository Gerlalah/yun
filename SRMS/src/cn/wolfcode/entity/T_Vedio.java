package cn.wolfcode.entity;

/**
 * @program: SRMS
 * @description:
 * @author: Mr.Like
 * @create: 2022-08-17 17:36
 **/

public class T_Vedio {
    private Integer vcode;
    private String vname;
    private String vsize;
    private String vtype;
    private String vclass;
    private String vstatus;
    private String vtime;
    private Integer vview;
    private String vurl;

    public String getVurl() {
        return vurl;
    }

    public void setVurl(String vurl) {
        this.vurl = vurl;
    }

    public Integer getVcode() {
        return vcode;
    }

    public void setVcode(Integer vcode) {
        this.vcode = vcode;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVsize() {
        return vsize;
    }

    public void setVsize(String vsize) {
        this.vsize = vsize;
    }

    public String getVtype() {
        return vtype;
    }

    public void setVtype(String vtype) {
        this.vtype = vtype;
    }

    public String getVclass() {
        return vclass;
    }

    public void setVclass(String vclass) {
        this.vclass = vclass;
    }

    public String getVstatus() {
        return vstatus;
    }

    public void setVstatus(String vstatus) {
        this.vstatus = vstatus;
    }

    public String getVtime() {
        return vtime;
    }

    public void setVtime(String vtime) {
        this.vtime = vtime;
    }

    public Integer getVview() {
        return vview;
    }

    public void setVview(Integer vview) {
        this.vview = vview;
    }

    @Override
    public String toString() {
        return "T_Vedio{" +
                "vcode=" + vcode +
                ", vname='" + vname + '\'' +
                ", vsize=" + vsize +
                ", vtype='" + vtype + '\'' +
                ", vclass='" + vclass + '\'' +
                ", vstatus=" + vstatus +
                ", vtime=" + vtime +
                ", vview=" + vview +
                '}';
    }
}
