package com.remote.hospital.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {


    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long Id;


    @Column(name="user_name")
    private String user_name;

    @Column(name="email_address")

    private String emailAddress;

    @Column(name="phone_number")
    private String phone_number;
    @Column(name="password")
    private String password;

    @Column(name="gender")
    private String gender;
    @Column(name="dob")
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dob;
    @Column(name="cnic")
    private String cnic;
    @Column(name="address")
    private String address;
    @Column(name="display_image")
    private String display_image;
    @Column(name="created_on")
    private Date Created_on;
    @Column(name="created_by")
    private Long Created_by;
    @Column(name="updated_on")
    private Date Updated_on;
    @Column(name="updated_by")
    private Long Updated_by;
    @Column(name="is_active")
    private Boolean isActive;
    @Column(name="blood_group")
    private String blood_group;


    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;


    @OneToMany(mappedBy = "user")
    List<Doctor_Hospital> doctorHospitals;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDisplay_image() {
        return display_image;
    }

    public void setDisplay_image(String display_image) {
        this.display_image = display_image;
    }

    public Date getCreated_on() {
        return Created_on;
    }

    public void setCreated_on(Date created_on) {
        Created_on = created_on;
    }

    public Long getCreated_by() {
        return Created_by;
    }

    public void setCreated_by(Long created_by) {
        Created_by = created_by;
    }

    public Date getUpdated_on() {
        return Updated_on;
    }

    public void setUpdated_on(Date updated_on) {
        Updated_on = updated_on;
    }

    public Long getUpdated_by() {
        return Updated_by;
    }

    public void setUpdated_by(Long updated_by) {
        Updated_by = updated_by;
    }


    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public List<Doctor_Hospital> getDoctorHospitals() {
        return doctorHospitals;
    }

    public void setDoctorHospitals(List<Doctor_Hospital> doctorHospitals) {
        this.doctorHospitals = doctorHospitals;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User() {
    }

    public User(Long id, String user_name, String emailAddress, String phone_number, String password, String gender, Date dob, String cnic, String address, String display_image, Date created_on, Long created_by, Date updated_on, Long updated_by, Boolean isActive, String blood_group, Role role, List<Doctor_Hospital> doctorHospitals) {
        Id = id;
        this.user_name = user_name;
        this.emailAddress = emailAddress;
        this.phone_number = phone_number;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
        this.cnic = cnic;
        this.address = address;
        this.display_image = display_image;
        Created_on = created_on;
        Created_by = created_by;
        Updated_on = updated_on;
        Updated_by = updated_by;
        this.isActive = isActive;
        this.blood_group = blood_group;
        this.role = role;
        this.doctorHospitals = doctorHospitals;
    }
}
