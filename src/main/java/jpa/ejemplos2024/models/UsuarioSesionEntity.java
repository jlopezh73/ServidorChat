package jpa.ejemplos2024.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "usuario_sesion", schema = "cursos", catalog = "")
public class UsuarioSesionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;

    @Basic
    @Column(name = "FechaInicio", nullable = true)
    private Timestamp fechaInicio;
    @Basic
    @Column(name = "FechaUltimoAcceso", nullable = true)
    private Timestamp fechaUltimoAcceso;
    @Basic
    @Column(name = "DireccionIP", nullable = true, length = 20)
    private String direccionIp;
    @Basic
    @Column(name = "Token", nullable = true, length = 600)
    private String token;
    @ManyToOne
    @JoinColumn(name = "IDUsuario", referencedColumnName = "ID", nullable = false)
    private UsuarioEntity usuarioByIdUsuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Timestamp getFechaUltimoAcceso() {
        return fechaUltimoAcceso;
    }

    public void setFechaUltimoAcceso(Timestamp fechaUltimoAcceso) {
        this.fechaUltimoAcceso = fechaUltimoAcceso;
    }

    public String getDireccionIp() {
        return direccionIp;
    }

    public void setDireccionIp(String direccionIp) {
        this.direccionIp = direccionIp;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuarioSesionEntity that = (UsuarioSesionEntity) o;

        if (id != that.id) return false;
        if (fechaInicio != null ? !fechaInicio.equals(that.fechaInicio) : that.fechaInicio != null) return false;
        if (fechaUltimoAcceso != null ? !fechaUltimoAcceso.equals(that.fechaUltimoAcceso) : that.fechaUltimoAcceso != null)
            return false;
        if (direccionIp != null ? !direccionIp.equals(that.direccionIp) : that.direccionIp != null) return false;
        if (token != null ? !token.equals(that.token) : that.token != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fechaInicio != null ? fechaInicio.hashCode() : 0);
        result = 31 * result + (fechaUltimoAcceso != null ? fechaUltimoAcceso.hashCode() : 0);
        result = 31 * result + (direccionIp != null ? direccionIp.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        return result;
    }

    public UsuarioEntity getUsuarioByIdUsuario() {
        return usuarioByIdUsuario;
    }

    public void setUsuarioByIdUsuario(UsuarioEntity usuarioByIdUsuario) {
        this.usuarioByIdUsuario = usuarioByIdUsuario;
    }
}
