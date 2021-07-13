package com.example.rest.greeting.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "USERROLE")
public class UserRoleView {
    @Id
	@SequenceGenerator(name = "USERROLE_SEQ", sequenceName = "USERROLE_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "USERROLE_SEQ", strategy = GenerationType.SEQUENCE)
    private Long ID;

    private Long USERID;
    private Long ROLEID;
    private Long AKTIF;

    private String USERNAME;
    private String NAME;
    private String EMAIL;
    private String ROLE;
    private String ZIPCODE;
    private String PASSWORD;

    @CreationTimestamp
	@Column(name = "register_date")
    private Timestamp REGDATE;

    public Long getID() {
        return this.ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getUSERID() {
        return this.USERID;
    }

    public void setUSERID(Long USERID) {
        this.USERID = USERID;
    }

    public Long getROLEID() {
        return this.ROLEID;
    }

    public void setROLEID(Long ROLEID) {
        this.ROLEID = ROLEID;
    }

    public Long getAKTIF() {
        return this.AKTIF;
    }

    public void setAKTIF(Long AKTIF) {
        this.AKTIF = AKTIF;
    }

    public String getUSERNAME() {
        return this.USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getNAME() {
        return this.NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getEMAIL() {
        return this.EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getROLE() {
        return this.ROLE;
    }

    public void setROLE(String ROLE) {
        this.ROLE = ROLE;
    }

    public String getZIPCODE() {
        return this.ZIPCODE;
    }

    public void setZIPCODE(String ZIPCODE) {
        this.ZIPCODE = ZIPCODE;
    }

    public String getPASSWORD() {
        return this.PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public Timestamp getREGDATE() {
        return this.REGDATE;
    }

    public void setREGDATE(Timestamp REGDATE) {
        this.REGDATE = REGDATE;
    }

}
