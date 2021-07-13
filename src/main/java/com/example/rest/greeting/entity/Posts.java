package com.example.rest.greeting.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.Fetch;
//import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "POSTS")
public class Posts {
    @Id
    @SequenceGenerator(name = "POSTS_SEQ", allocationSize = 1)                      //Set Increment generator to +1
    @GeneratedValue(generator = "POSTS_SEQ", strategy = GenerationType.SEQUENCE)    //Set column as auto_increment
    private Long id;

    private String slug;
    private String title;
    private String body;

    @CreationTimestamp                                                              //Put the current date as default value
    @Column(name = "created_at")
    private Date created;
    
    private Long userid;
    
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "userid", insertable = false, updatable = false)
//	@Fetch(FetchMode.JOIN)
//	private Users users;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSlug() {
        return this.slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreated() {
        return this.created;
    }

    public void setCreated(Date created_at) {
        this.created = created_at;
    }

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

}
