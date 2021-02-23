package com.itheima.vo;

public class StudentAndClassroomVo {
    private int sid;
    private String sname;
    private int sage;
    private String saddress;

    private int cid;
    private String cname;

    @Override
    public String toString() {
        return "StudentAndClassroomVo{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sage=" + sage +
                ", saddress='" + saddress + '\'' +
                ", cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public StudentAndClassroomVo() {
    }

    public StudentAndClassroomVo(int sid, String sname, int sage, String saddress, int cid, String cname) {
        this.sid = sid;
        this.sname = sname;
        this.sage = sage;
        this.saddress = saddress;
        this.cid = cid;
        this.cname = cname;
    }
}
