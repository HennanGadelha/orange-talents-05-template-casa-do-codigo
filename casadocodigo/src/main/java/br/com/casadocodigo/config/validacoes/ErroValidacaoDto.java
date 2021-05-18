package br.com.casadocodigo.config.validacoes;

public class ErroValidacaoDto {

    private String campo;
    private String mensagemDeErro;

    public ErroValidacaoDto(String campo, String mensagemDeErro) {
        this.campo = campo;
        this.mensagemDeErro = mensagemDeErro;
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagemDeErro() {
        return mensagemDeErro;
    }
}
