package usuario.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class UsuarioDTO {
    private Long id;
    private String nomeDoUsuario;
    private String senhaDoUsuario;
    private String uuid;
}
