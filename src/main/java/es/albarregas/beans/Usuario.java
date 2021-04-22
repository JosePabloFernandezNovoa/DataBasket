/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ColumnDefault;


/**
 *
 * @author jp-9
 */
@Entity
@Table(name="usuarios", uniqueConstraints = {
@UniqueConstraint(columnNames = "Email", name="UK_usuarios_Email"),@UniqueConstraint(columnNames = "Dni", name="UK_usuarios_Dni")})
@Inheritance(strategy=InheritanceType.JOINED)
public class Usuario implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "IdUsuario")
    private Integer idUsuario;
    
    @Column(name = "Email", length = 60, nullable = false)
    private String email;
    
    @Column(name = "Password", length = 128, nullable = false)
    private String password;
    
    @Column(name = "Nombre", length = 30)
    private String nombre;
    
    @Column(name = "Apellidos", length = 60)
    private String apellidos;
    
    public enum Rol{
        ADMIN, 
        TUTOR,
        ALUMNO
    }
    @Column(name="Rol", nullable=false)
    @Enumerated(EnumType.STRING)
    private Rol rol;
    
    @Column(name = "Dni", length = 9, nullable = false)
    private String dni;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "UltimoAcceso")
    private Date ultimoAcceso;
    
    @Column(name = "Avatar", length = 30, columnDefinition = "varchar(30) default 'avatar.png'")
    private String avatar;

    /**
     * @return the idUsuario
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the rol
     */
    public Rol getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the ultimoAcceso
     */
    public Date getUltimoAcceso() {
        return ultimoAcceso;
    }

    /**
     * @param ultimoAcceso the ultimoAcceso to set
     */
    public void setUltimoAcceso(Date ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }

    /**
     * @return the avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param avatar the avatar to set
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos;
    }

    

    
}
