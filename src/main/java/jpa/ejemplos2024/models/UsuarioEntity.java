package jpa.ejemplos2024.models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@NamedQueries({
        @NamedQuery(name="Usuario.PorEmailyPassword", query="SELECT u FROM UsuarioEntity u WHERE u.correoElectronico = :email and u.password = :password")
})
@Table(name = "Usuario", schema = "cursos", catalog = "")
public class UsuarioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "CorreoElectronico", nullable = true, length = 100)
    private String correoElectronico;
    @Basic
    @Column(name = "Paterno", nullable = true, length = 50)
    private String paterno;
    @Basic
    @Column(name = "Materno", nullable = true, length = 50)
    private String materno;
    @Basic
    @Column(name = "Nombre", nullable = true, length = 50)
    private String nombre;
    @Basic
    @Column(name = "Puesto", nullable = true, length = 50)
    private String puesto;
    @Basic
    @Column(name = "Password", nullable = true, length = 50)
    private String password;
    @Basic
    @Column(name = "Activo", nullable = true)
    private Boolean activo;
    @OneToMany(mappedBy = "usuarioByIdUsuario")
    private Collection<UsuarioSesionEntity> usuarioSesionsById;
    @OneToMany(mappedBy = "usuarioByIdUsuario")
    private Collection<UsuarioAccionEntity> usuarioAccionsById;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CorreoElectronico", nullable = true, length = 100)
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Basic
    @Column(name = "Paterno", nullable = true, length = 50)
    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    @Basic
    @Column(name = "Materno", nullable = true, length = 50)
    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    @Basic
    @Column(name = "Nombre", nullable = true, length = 50)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "Puesto", nullable = true, length = 50)
    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Basic
    @Column(name = "Password", nullable = true, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "Activo", nullable = true)
    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuarioEntity that = (UsuarioEntity) o;

        if (id != that.id) return false;
        if (correoElectronico != null ? !correoElectronico.equals(that.correoElectronico) : that.correoElectronico != null)
            return false;
        if (paterno != null ? !paterno.equals(that.paterno) : that.paterno != null) return false;
        if (materno != null ? !materno.equals(that.materno) : that.materno != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (puesto != null ? !puesto.equals(that.puesto) : that.puesto != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (activo != null ? !activo.equals(that.activo) : that.activo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (correoElectronico != null ? correoElectronico.hashCode() : 0);
        result = 31 * result + (paterno != null ? paterno.hashCode() : 0);
        result = 31 * result + (materno != null ? materno.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (puesto != null ? puesto.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (activo != null ? activo.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "usuarioByIdUsuario")
    public Collection<UsuarioSesionEntity> getUsuarioSesionsById() {
        return usuarioSesionsById;
    }

    public void setUsuarioSesionsById(Collection<UsuarioSesionEntity> usuarioSesionsById) {
        this.usuarioSesionsById = usuarioSesionsById;
    }

    public Collection<UsuarioAccionEntity> getUsuarioAccionsById() {
        return usuarioAccionsById;
    }

    public void setUsuarioAccionsById(Collection<UsuarioAccionEntity> usuarioAccionsById) {
        this.usuarioAccionsById = usuarioAccionsById;
    }
}
