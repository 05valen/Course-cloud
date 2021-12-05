package co.com.poli.courses.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    private Long id;
    @Column(name = "projectIdentifier",nullable = false)
    private String projectIdentifier;





    @JsonBackReference
    @OneToOne(fetch = FetchType.EAGER)
    @NotEmpty (message = "El projectIdentifier no puede ser vacio")
    private Project project;






    @OneToMany(mappedBy = "backlog",fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
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
