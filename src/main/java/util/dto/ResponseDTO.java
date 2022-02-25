package util.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO<T> extends BaseDTO {
    private static final long serialVersionUID = -8490755772558316793L;

    private T dados;
    private String mensagem;

    public ResponseDTO(T dados) {
        super();
        this.dados = dados;
    }

    public ResponseDTO(String mensagem) {
        super();
        this.mensagem = mensagem;
    }
}
