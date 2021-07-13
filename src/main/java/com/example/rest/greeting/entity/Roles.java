package com.example.rest.greeting.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE")
public class Roles {
    @Id
	@SequenceGenerator(name = "ROLE_SEQ", sequenceName = "ROLE_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "ROLE_SEQ", strategy = GenerationType.SEQUENCE)
    private Long ID;

    private String ROLE;

    private String KETERANGAN;

    public Long getID() {
        return this.ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getROLE() {
        return this.ROLE;
    }

    public void setROLE(String ROLE) {
        this.ROLE = ROLE;
    }

    public String getKETERANGAN() {
        return this.KETERANGAN;
    }

    public void setKETERANGAN(String KETERANGAN) {
        this.KETERANGAN = KETERANGAN;
    }
}
