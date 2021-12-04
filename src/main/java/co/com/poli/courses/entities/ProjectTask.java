package co.com.poli.courses.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Getter
@Entity
@Table(name = "projectTasks")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotEmpty(message = "El id no puede ser vacio")
    @Column(name = "id",nullable = true)
    private Long id;
    @NotEmpty(message = "El name no puede ser vacio")
    @Column(name = "name",nullable = true)
    private String name;
    @NotEmpty(message = "El summary no puede ser vacio")
    @Column(name = "summary",nullable = true)
    private String summary;
    @Column(name = "acceptanceCriteria")
    private String description;
    @Column(name = "status")
    private Date status;
    @Size(min = 5, max = 7, message = "El priority de usuario debe tener entre 1 y 5 caracteres")
    @Column(name = "priority")
    private int priority;
    @Size (min = 1, max = 8, message = "Las hours  debe tener entre 8 y 8 caracteres")
    @Positive (message = "La cantidad debe ser mayor que cero")
    @Column(name = "hours")
    private double hours;
    @Column(name = "starDate")
    private Date starDate;
    @Column(name = "endDate")
    private Date endDate;
    @NotEmpty(message = "No se puede actualizar")
    @Column(name = "projectIdentifier",updatable = false)
    private String projectIdentifier;

    @JsonBackReference
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "projectTask_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Backlog backlog;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectTask that = (ProjectTask) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
