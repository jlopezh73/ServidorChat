package jpa.ejemplos2024.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "Curso", schema = "cursos", catalog = "")
@NamedQueries({
        @NamedQuery(name="Curso.Todos", query="SELECT c FROM CursoEntity c"),
        @NamedQuery(name="Curso.PorID", query="SELECT c FROM CursoEntity c WHERE c.id = :id"),
        @NamedQuery(name="Curso.PorInstructor", query="SELECT c FROM CursoEntity c WHERE c.instructor = :instructor")
})
public class CursoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "Clave", nullable = true, length = 10)
    private String clave;
    @Basic
    @Column(name = "Nombre", nullable = true, length = 200)
    private String nombre;
    @Basic
    @Column(name = "Descripcion", nullable = true, length = 1000)
    private String descripcion;
    @Basic
    @Column(name = "NoHoras", nullable = true)
    private Integer noHoras;
    @Basic
    @Column(name = "FechaInicio", nullable = true)
    private Timestamp fechaInicio;
    @Basic
    @Column(name = "FechaTermino", nullable = true)
    private Timestamp fechaTermino;
    @Basic
    @Column(name = "Costo", nullable = true, precision = 2)
    private BigDecimal costo;
    @Basic
    @Column(name = "Instructor", nullable = true, length = 100)
    private String instructor;
    @OneToMany(mappedBy = "cursoByIdCurso", cascade = CascadeType.ALL)
    private Collection<ParticipanteEntity> participantesById;
    @OneToMany(mappedBy = "cursoByIdCurso", cascade = CascadeType.ALL)
    private Collection<ParticipantePagoEntity> participantePagosById;
    @OneToMany(mappedBy = "cursoByIdCurso", cascade = CascadeType.ALL)
    private Collection<CursoImagenEntity> cursoImagensById;

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
    @Column(name = "Clave", nullable = true, length = 10)
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Basic
    @Column(name = "Nombre", nullable = true, length = 200)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "Descripcion", nullable = true, length = 1000)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "NoHoras", nullable = true)
    public Integer getNoHoras() {
        return noHoras;
    }

    public void setNoHoras(Integer noHoras) {
        this.noHoras = noHoras;
    }

    @Basic
    @Column(name = "FechaInicio", nullable = true)
    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Basic
    @Column(name = "FechaTermino", nullable = true)
    public Timestamp getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Timestamp fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    @Basic
    @Column(name = "Costo", nullable = true, precision = 2)
    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    @Basic
    @Column(name = "Instructor", nullable = true, length = 100)
    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CursoEntity that = (CursoEntity) o;

        if (id != that.id) return false;
        if (clave != null ? !clave.equals(that.clave) : that.clave != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (noHoras != null ? !noHoras.equals(that.noHoras) : that.noHoras != null) return false;
        if (fechaInicio != null ? !fechaInicio.equals(that.fechaInicio) : that.fechaInicio != null) return false;
        if (fechaTermino != null ? !fechaTermino.equals(that.fechaTermino) : that.fechaTermino != null) return false;
        if (costo != null ? !costo.equals(that.costo) : that.costo != null) return false;
        if (instructor != null ? !instructor.equals(that.instructor) : that.instructor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (clave != null ? clave.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (noHoras != null ? noHoras.hashCode() : 0);
        result = 31 * result + (fechaInicio != null ? fechaInicio.hashCode() : 0);
        result = 31 * result + (fechaTermino != null ? fechaTermino.hashCode() : 0);
        result = 31 * result + (costo != null ? costo.hashCode() : 0);
        result = 31 * result + (instructor != null ? instructor.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "cursoByIdCurso")
    public Collection<ParticipanteEntity> getParticipantesById() {
        return participantesById;
    }

    public void setParticipantesById(Collection<ParticipanteEntity> participantesById) {
        this.participantesById = participantesById;
    }

    @OneToMany(mappedBy = "cursoByIdCurso")
    public Collection<ParticipantePagoEntity> getParticipantePagosById() {
        return participantePagosById;
    }

    public void setParticipantePagosById(Collection<ParticipantePagoEntity> participantePagosById) {
        this.participantePagosById = participantePagosById;
    }

    @OneToMany(mappedBy = "cursoByIdCurso")
    public Collection<CursoImagenEntity> getCursoImagensById() {
        return cursoImagensById;
    }

    public void setCursoImagensById(Collection<CursoImagenEntity> cursoImagensById) {
        this.cursoImagensById = cursoImagensById;
    }
}
