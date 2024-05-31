package jpa.ejemplos2024.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "Usuario_Accion", schema = "cursos", catalog = "")
public class UsuarioAccionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "FechaHora", nullable = true)
    private Timestamp fechaHora;
    @Basic
    @Column(name = "Accion", nullable = true, length = 500)
    private String accion;
    @Basic
    @Column(name = "IDUsuarioSesion", nullable = true)
    private Integer idUsuarioSesion;

    @ManyToOne
    @JoinColumn(name = "IDUsuario", referencedColumnName = "ID", nullable = false)
    private UsuarioEntity usuarioByIdUsuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Integer getIdUsuarioSesion() {
        return idUsuarioSesion;
    }

    public void setIdUsuarioSesion(Integer idUsuarioSesion) {
        this.idUsuarioSesion = idUsuarioSesion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuarioAccionEntity that = (UsuarioAccionEntity) o;

        if (id != that.id) return false;
        if (fechaHora != null ? !fechaHora.equals(that.fechaHora) : that.fechaHora != null) return false;
        if (accion != null ? !accion.equals(that.accion) : that.accion != null) return false;
        if (idUsuarioSesion != null ? !idUsuarioSesion.equals(that.idUsuarioSesion) : that.idUsuarioSesion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fechaHora != null ? fechaHora.hashCode() : 0);
        result = 31 * result + (accion != null ? accion.hashCode() : 0);
        result = 31 * result + (idUsuarioSesion != null ? idUsuarioSesion.hashCode() : 0);
        return result;
    }
}
