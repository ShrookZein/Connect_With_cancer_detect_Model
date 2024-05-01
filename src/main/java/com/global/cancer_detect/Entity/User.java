package com.global.cancer_detect.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "USER_ID")
    private Long id;
    private String firstName;
    private String lastName;
    @Email
    private String email;
    private String password;

    @OneToMany(mappedBy ="user" ,cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<ImageModel>imageModels;
    @ManyToMany(fetch = FetchType.EAGER)
//    @JsonIgnore
    @JoinTable(name = "sec_user_roles",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    @OrderColumn(name = "id")
    private Set<RoleModel>roles=new HashSet<>();
//    @ManyToMany(mappedBy = "user")
//    @JsonIgnore
//    --------------------------------------------------------------------------------------------------
//    @ManyToMany()
//    @JsonIgnore
//    @JoinTable(name = "user_Appointment",
//            joinColumns =@JoinColumn(name = "user_id",referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "appointment_id",referencedColumnName = "id"))
////    @OrderColumn(name = "id")
//    private Set<AppointmentModel> appointments=new HashSet<>();

    private boolean isEnabled;

    private boolean isCredentialsNonExpired;

    private boolean isAccountNonLocked;

    private boolean isAccountNonExpired;

    public User(Long userId) {
        super();
        this.id=userId;
    }
}
