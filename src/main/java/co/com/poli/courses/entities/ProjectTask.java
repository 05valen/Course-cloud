package co.com.poli.courses.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
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
    private Long id;
    @NotEmpty(message = "El name no puede ser vacio")
    @Column(name = "name",nullable = false)
    private String name;
    @NotEmpty(message = "El summary no puede ser vacio")
    @Column(name = "summary",nullable = false)
    private String summary;
    @Column(name = "acceptanceCriteria")
    private String acceptanceCriteria;
    @Pattern(regexp="^(Not Stared|in progress|completed|deleted)$",message="invalid code")
    @Column(name = "status")
    private String status;
    @Min(1)
    @Max(5)
    @Column(name = "priority")
    private int priority;
    @Min(1)
    @Max(8)
    @Positive (message = "La cantidad debe ser mayor que cero")
    @Column(name = "hours")
    private double hours;
    @JsonFormat(pattern="yyyy-MM-dd")
    private String startDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private String endDate;
    @NotEmpty(message = "No se puede actualizar")
    @Column(name = "projectIdentifier",updatable = false)
    private String projectIdentifier;




    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "backlog_id")
    @NotEmpty (message = "El projectIdentifier no puede ser vacio")
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
