package jpa.ejemplos2024.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name = "Participante", schema = "cursos", catalog = "")
public class ParticipanteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "Paterno", nullable = true, length = 30)
    private String paterno;
    @Basic
    @Column(name = "Materno", nullable = true, length = 30)
    private String materno;
    @Basic
    @Column(name = "Nombre", nullable = true, length = 30)
    private String nombre;
    @Basic
    @Column(name = "Matricula", nullable = true, length = 20)
    private String matricula;
    @Basic
    @Column(name = "Precio", nullable = true, precision = 2)
    private BigDecimal precio;
    @Basic
    @Column(name = "Pagado", nullable = true, precision = 2)
    private BigDecimal pagado;
    @ManyToOne
    @JoinColumn(name = "IDCurso", referencedColumnName = "ID")
    private CursoEntity cursoByIdCurso;

    public CursoEntity getCurso() {
        return cursoByIdCurso;
    }

    public void setCurso(CursoEntity curso) {
        cursoByIdCurso = curso;
    }

    @OneToMany(mappedBy = "participanteByIdParticipante")
    private Collection<ParticipantePagoEntity> participantePagosById;

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
    @Column(name = "Paterno", nullable = true, length = 30)
    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    @Basic
    @Column(name = "Materno", nullable = true, length = 30)
    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    @Basic
    @Column(name = "Nombre", nullable = true, length = 30)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "Matricula", nullable = true, length = 20)
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Basic
    @Column(name = "Precio", nullable = true, precision = 2)
    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @Basic
    @Column(name = "Pagado", nullable = true, precision = 2)
    public BigDecimal getPagado() {
        return pagado;
    }

    public void setPagado(BigDecimal pagado) {
        this.pagado = pagado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParticipanteEntity that = (ParticipanteEntity) o;

        if (id != that.id) return false;
        if (paterno != null ? !paterno.equals(that.paterno) : that.paterno != null) return false;
        if (materno != null ? !materno.equals(that.materno) : that.materno != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (matricula != null ? !matricula.equals(that.matricula) : that.matricula != null) return false;
        if (precio != null ? !precio.equals(that.precio) : that.precio != null) return false;
        if (pagado != null ? !pagado.equals(that.pagado) : that.pagado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (paterno != null ? paterno.hashCode() : 0);
        result = 31 * result + (materno != null ? materno.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (matricula != null ? matricula.hashCode() : 0);
        result = 31 * result + (precio != null ? precio.hashCode() : 0);
        result = 31 * result + (pagado != null ? pagado.hashCode() : 0);
        return result;
    }





}
