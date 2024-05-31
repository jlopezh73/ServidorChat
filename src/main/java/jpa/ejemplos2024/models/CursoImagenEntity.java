package jpa.ejemplos2024.models;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
@Table(name = "curso_imagen", schema = "cursos", catalog = "")
public class CursoImagenEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;

    @Basic
    @Column(name = "Imagen", nullable = true)
    private byte[] imagen;
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
    @Column(name = "Imagen", nullable = true)
    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CursoImagenEntity that = (CursoImagenEntity) o;

        if (id != that.id) return false;
        if (!Arrays.equals(imagen, that.imagen)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;

        result = 31 * result + Arrays.hashCode(imagen);
        return result;
    }


    public void setCursoByIdCurso(CursoEntity cursoByIdCurso) {
        this.cursoByIdCurso = cursoByIdCurso;
    }


}
