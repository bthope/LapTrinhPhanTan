package vn.edu.iuh.fit.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "role")
public class Role implements Serializable {
    @Id
    @Column(columnDefinition = "varchar(50)")
    private String role_id;
    @Column(columnDefinition = "varchar(50)")
    private String roll_name;
    @Column(columnDefinition = "varchar(50)")
    private String description;
    @Column(columnDefinition = "tinyint")
    private byte status;

    public Role() {
    }

    public Role(String role_id, String roll_name, String description, byte status) {
        this.role_id = role_id;
        this.roll_name = roll_name;
        this.description = description;
        this.status = status;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getRoll_name() {
        return roll_name;
    }

    public void setRoll_name(String roll_name) {
        this.roll_name = roll_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id='" + role_id + '\'' +
                ", roll_name='" + roll_name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
