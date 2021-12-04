package co.com.poli.courses.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;


@Getter
@Setter
@Entity
@Table(name = "backlogs")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Backlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false,unique = true,nullable = false)
    private Long id;
    @NotEmpty(message = "El projectIdentifier no puede ser vacio")
    private String projectIdentifier;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Project project;

    @JsonManagedReference
    @OneToMany(mappedBy = "backlog",fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    // @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private List<ProjectTask> projectTasks;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Backlog backlog = (Backlog) o;
        return Objects.equals(id, backlog.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
