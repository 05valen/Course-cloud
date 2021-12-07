package co.com.poli.courses.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "projects")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El projectName no puede ser vacio")
    @Column(name = "projectName" ,unique = true,nullable = false)
    private String projectName;
    @NotEmpty(message = "El projectIdentifier no puede ser vacio")
    @Column(name = "projectIdentifier", unique = true,nullable = false,updatable = false)
    @Size (min = 5, max = 7, message = "El projectIdentifier de usuario debe tener entre 5y 7 caracteres")
    private String projectIdentifier;
    @NotEmpty(message = "El description no puede ser vacio")
    @Column(name = "description",nullable = false)
    private String description;
    @JsonFormat(pattern="yyyy-MM-dd")
    private String startDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private String endDate;


    @JsonManagedReference
    @OneToOne(fetch = FetchType.EAGER,cascade =CascadeType.PERSIST,mappedBy = "project")
    private Backlog backlog;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
