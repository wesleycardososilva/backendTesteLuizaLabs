package usuario.service;

import usuario.dto.UsuarioDTO;

public interface UsuarioService {

    UsuarioDTO getSenhaPorUsuario(String usuario) throws InterruptedException;

}
