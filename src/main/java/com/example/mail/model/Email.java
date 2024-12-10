package com.example.mail.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime; // for time_stamp if it's a date-time value
import java.util.List;

@Entity
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generate the ID
    @Column(name = "email_id")  // Custom column name
    private int id;

    @Column(name = "subject")  // Custom column name
    private String subject;

    @Column(name = "time_stamp")  // Custom column name
    private LocalDateTime timeStamp;  // changed to LocalDateTime for better handling of timestamps

    @Column(name = "from_address")  // Custom column name
    private String fromAddress;  // renamed to match Java convention

    @Column(name = "to_address")  // Custom column name
    private String toAddress;  // renamed to match Java convention

    @Column(name = "body")  // Custom column name
    private String body;

    @Column(name = "attachments")  // Custom column name
    private List<byte[]> attachments;

    @Column(name = "type")  // Custom column name
    private String type;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")  // Foreign key to User entity
    @JsonBackReference
    private User user;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<byte[]> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<byte[]> attachments) {
        this.attachments = attachments;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}