package KlajdiNdoci.U5W2D3.utente;

import KlajdiNdoci.U5W2D3.post.Post;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private String avatar;
    @CreationTimestamp
    private Date createdAt;
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "utente")
    private List<Post> posts;
}
