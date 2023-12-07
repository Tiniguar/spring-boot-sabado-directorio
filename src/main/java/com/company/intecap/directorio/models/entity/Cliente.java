package com.company.intecap.directorio.models.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //full name
    @NotEmpty
    @Column(unique = true, length = 200) //Validacion valor unico y tamaño de campo 200
    private String nombreCompleto;

    //Street Address 1
    @NotEmpty
    private String calleDireccion1;

    //Street Address 2
    @NotEmpty
    private String calleDireccion2;

    //city
    @NotEmpty
    private String ciudad;

    //state
    @NotEmpty
    private String estado;


    // zip code
    @NotEmpty
    private String codigoPostal;

    @NotNull
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;


    // Getter y Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCalleDireccion1() {
        return calleDireccion1;
    }

    public void setCalleDireccion1(String calleDireccion1) {
        this.calleDireccion1 = calleDireccion1;
    }

    public String getCalleDireccion2() {
        return calleDireccion2;
    }

    public void setCalleDireccion2(String calleDireccion2) {
        this.calleDireccion2 = calleDireccion2;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
