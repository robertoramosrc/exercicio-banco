package br.com.tt.tela;

import br.com.tt.dao.BancoDao;
import br.com.tt.model.Conta;
import br.com.tt.model.Correntista;
import br.com.tt.model.CorrentistaPF;
import br.com.tt.model.CorrentistaPJ;
import br.com.tt.util.ScannerInterface;
import br.com.tt.util.UsuarioUtil;

import java.util.List;

public class TelaCorrentista implements Tela {

    private BancoDao bancoDao;
    private ScannerInterface scanner;
    private UsuarioUtil usuarioUtil;

    public TelaCorrentista(BancoDao bancoDao, ScannerInterface scanner, UsuarioUtil usuarioUtil) {
//        bancoDao = new BancoDao(); Deve vir de fora
        this.bancoDao = bancoDao;
        this.scanner = scanner;
        this.usuarioUtil = usuarioUtil;
    }

    public void imprime() {
        usuarioUtil.exibeMensagem("Imprime");
    }

    @Override
    public void exibeMenu() {

        String mensagemMenu = new StringBuffer()
                .append("\n> Menu Correntista\n")
                .append("Escolha uma opção: \n")
                .append(" 1 - Criar correntista\n")
                .append(" 2 - Listar correntistas\n")
                .toString();
        usuarioUtil.exibeMensagem(mensagemMenu);

        int opcao = Integer.parseInt(this.scanner.nextLine());

        if (opcao == 1) {
            exibeMenuCriarCorrentista();
        } else if (opcao == 2) {
            exibeMenuListarCorrentista();
        }
    }

    private void exibeMenuCriarCorrentista() {
        usuarioUtil.exibeMensagem("Informe o nome do correntista: ");
        String nome = this.scanner.nextLine();

        usuarioUtil.exibeMensagem("Segue lista de contas disponíveis: ");
        //obtendo a lista do dao
        List<Conta> listaContas = this.bancoDao.listarContas();

        int posicao = 0;
        for (Conta c : listaContas) {
            posicao++;

            String descricao = new StringBuffer()
                    .append(posicao)
                    .append(" - ")
                    .append(c.getDescricao())
                    .toString();

            usuarioUtil.exibeMensagem(descricao);
        }

        usuarioUtil.exibeMensagem("Escolha um número da lista: ");
        //pedir pro usuario
        int posicaoEscolhida = Integer.parseInt(this.scanner.nextLine());

        Conta contaEscolhida = listaContas.get(posicaoEscolhida-1);

        //Pedir tipo de conta
        usuarioUtil.exibeMensagem("Escolha um tipo de conta: PF/PJ");
        String tipoConta = this.scanner.nextLine();

        if("PF".equalsIgnoreCase(tipoConta)){
            usuarioUtil.exibeMensagem("Informe o Tipo de Documento:");
            String tipo = this.scanner.nextLine();

            usuarioUtil.exibeMensagem("Informe o número do Documento");
            String doc = this.scanner.nextLine();

            bancoDao.adicionarCorrentista(
                    new CorrentistaPF(nome, contaEscolhida, tipo, doc));

        }else if("PJ".equalsIgnoreCase(tipoConta)){
            bancoDao.adicionarCorrentista(
                    new CorrentistaPJ(nome, contaEscolhida));

        }else {
            throw new IllegalArgumentException("Informe um tipo válido!");
        }

        usuarioUtil.exibeMensagem("Correntista cadastrado com sucesso!");
    }

    private void exibeMenuListarCorrentista() {
        List<Correntista> lista = bancoDao.listarCorrentistas();
        usuarioUtil.exibeMensagem("Lista de correntistas: ");
        for (Correntista correntista : lista) {
            usuarioUtil.exibeMensagem(" - ".concat(correntista.getDescricao()));
        }
    }
}
