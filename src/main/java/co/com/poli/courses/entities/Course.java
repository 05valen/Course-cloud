package co.com.poli.courses.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@Entity
@Table(name = "courses")
public class Course extends EntityBase{

    @Column(name = "name")
    private String name;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "instructor_id")
    @NotEmpty (message = "El projectIdentifier no puede ser vacio")
    private Instructor instructor;

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
