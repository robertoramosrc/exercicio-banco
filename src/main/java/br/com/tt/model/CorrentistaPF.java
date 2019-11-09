package br.com.tt.model;

public class CorrentistaPF extends Correntista{

    private String tipoDocumento;
    private String documento;
    private static final String TIPO_CONTA = "PF";

    public CorrentistaPF(String nome, Conta conta,
                         String tipoDocumento, String documento) {
        super(nome, conta);
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
    }

    public String getDescricao(){
        return new StringBuffer()
                .append("Tipo de Conta: ").append(TIPO_CONTA)
                .append("Nome: ").append(super.getNome())
                .append("Conta: [").append(this.getConta())
                .append("] Tipo documento: ").append(this.tipoDocumento)
                .append("Documento: ").append(this.documento)
                .toString();
    }
}
