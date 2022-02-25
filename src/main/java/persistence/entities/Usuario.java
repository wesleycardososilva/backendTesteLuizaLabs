package persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.persistence.annotations.Customizer;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {


    public static final String SCHEMA = "db_magalu";
    public static final String NAME = "USUARIO";
    public static final String ID_COLUMN_NAME = NAME;
    public static final String SEQUENCE_NAME =  "USUARIO_COSEQU";

    @Id
    @Column(name = ID_COLUMN_NAME, unique = true, nullable = false)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1, schema = SCHEMA)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    private Long id;

    @Column(name = "USUARIO", nullable = false)
    private String nomeDoUsuario;

    @Column(name =  "SENHA_USUARIO", nullable = false)
    private String senhaDoUsuario;

}
