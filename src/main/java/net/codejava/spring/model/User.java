package net.codejava.spring.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private int id;
    @Size(min = 2, max = 30, message = "min 2")
    private String username;
    @Size(min = 8, message = "mai mare ca 8")
    private String password;
    @NotEmpty(message = "nu trebuie sa fie gol")
    @Email(message = "zdesi ii e-mail")
    private String email;
    @Column(name = "enabled", nullable = false)
    private Boolean enabled;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_project", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
    private List<Project> projects;
    @OneToMany(cascade = CascadeType.ALL, targetEntity = Adress.class, mappedBy = "user")
    private List<Adress> adresses;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<UserRole> roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    public Set<UserRole> getUserRole() {
        return this.roles;
    }

    public void setUserRole(Set<UserRole> roles) {
        this.roles = roles;
    }

    public List<Adress> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<Adress> adresses) {
        this.adresses = adresses;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }


}
