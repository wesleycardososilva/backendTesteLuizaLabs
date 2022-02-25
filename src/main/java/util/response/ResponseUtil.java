
package util.response;

import util.dto.ResponseDTO;

import java.io.Serializable;

/**
 * Criação de classe utilitária para respostas padrões do servidor
 *
 * Ajuste para generalização do tipo para facilitar desserializar os objetos
 *
 * @author
 */
public final class ResponseUtil implements Serializable {

    private static final long serialVersionUID = -823090313385853278L;

    private ResponseUtil() {
    }

    public static<T> ResponseDTO<T> montaResponse(T dados, String mensagem) {
        ResponseDTO<T> response = new ResponseDTO<>();
        response.setDados(dados);
        response.setMensagem(mensagem);
        return response;
    }

    public static ResponseDTO<?> montaResponse(String mensagem) {
        ResponseDTO<?> response = new ResponseDTO<>();
        response.setMensagem(mensagem);
        return response;
    }

    public static<T> ResponseDTO<T> montaResponse(T dados) {
        ResponseDTO<T> response = new ResponseDTO<>();
        response.setDados(dados);
        return response;
    }

}
