package jpa.ejemplos2024.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "Participante_Pago", schema = "cursos", catalog = "")
public class ParticipantePagoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "Monto", nullable = true, precision = 2)
    private BigDecimal monto;
    @Basic
    @Column(name = "Fecha", nullable = true)
    private Timestamp fecha;
    @ManyToOne
    @JoinColumn(name = "IDParticipante", referencedColumnName = "ID")
    private ParticipanteEntity participanteByIdParticipante;
    @ManyToOne
    @JoinColumn(name = "IDCurso", referencedColumnName = "ID")
    private CursoEntity cursoByIdCurso;

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
    @Column(name = "Monto", nullable = true, precision = 2)
    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    @Basic
    @Column(name = "Fecha", nullable = true)
    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParticipantePagoEntity that = (ParticipantePagoEntity) o;

        if (id != that.id) return false;
        if (monto != null ? !monto.equals(that.monto) : that.monto != null) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (monto != null ? monto.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        return result;
    }


    public void setParticipanteByIdParticipante(ParticipanteEntity participanteByIdParticipante) {
        this.participanteByIdParticipante = participanteByIdParticipante;
    }


    public void setCursoByIdCurso(CursoEntity cursoByIdCurso) {
        this.cursoByIdCurso = cursoByIdCurso;
    }



}
