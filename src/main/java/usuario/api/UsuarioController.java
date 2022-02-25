package usuario.api;


import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import util.response.ResponseUtil;
import usuario.service.UsuarioService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
public class UsuarioController {
    @EJB
    private UsuarioService usuarioService;

    @Getter
    @Context
    private SecurityContext securityContext;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(httpMethod = "GET",
            value = "Serviço reponsavel por buscar a senha do usuario",
            response = Response.class,
            consumes = MediaType.APPLICATION_JSON,
            produces = MediaType.APPLICATION_JSON)
    public Response getSenhaPorUsuario(@QueryParam("nomeDoUsuario") String usuario) throws InterruptedException {
        return Response.ok(
                ResponseUtil.montaResponse(
                        this.usuarioService.getSenhaPorUsuario(usuario),
                        "Registro retornado!")).build();
    }

}
