package com.sid.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sid.security.Auditable;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "mobile"),
        @UniqueConstraint(columnNames = "username")
})
@Data
public class User extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String middleName;

    @Column(length = 50)
    private String lastName;

    @Column(length = 50)
    private String username;

    @Column(length = 15)
    private String mobile;

    @Column(length = 50)
    private String email;

    private String imageUrl;
    private String occupation;

    @ManyToOne
    @JoinColumn(name = "locationid", insertable = false, updatable = false)
    private Location location;
    private Integer locationid;

    private String phone;
    private Date dateOfBirth;
    private String company;

    @Column(nullable = false)
    private String password;

    private String passwordHash;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;

    @Column(columnDefinition = "TINYTEXT")
    private String intro;

    @Column(columnDefinition = "TEXT")
    private String profile;
    
    @OneToMany(mappedBy="user")
    private List<UserPrivelegeAssignment> priveleges;
    

	
	 
	 @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	  
	  @JoinTable( name = "user_role", joinColumns = {@JoinColumn(name =
	  "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")} )
	  List<Role> roles;
	 

    @ElementCollection
    @CollectionTable(name = "social_links", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "url")
    @MapKeyColumn(name = "platform")
    private Map<String, String> socialLinks;
    /*
        In this case, the socialLinks map holds platform names (e.g., "twitter", "linkedin") as keys and their URLs as values.
        The @ElementCollection annotation is used to store this map in a separate table social_links
     */
    //@JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Task> tasks;

    //@JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    //@JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Conversation> conversations;

    //@JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Project> projects;

    //@JsonManagedReference
    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Message> messages;
}
