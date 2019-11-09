package br.com.tt.tela;

import br.com.tt.dao.BancoDao;
import br.com.tt.model.Conta;
import br.com.tt.util.ScannerInterface;
import br.com.tt.util.UsuarioUtil;

import java.util.List;
import java.util.Scanner;

public class TelaConta implements Tela{

    private BancoDao bancoDao;
    private ScannerInterface scanner;
    private UsuarioUtil usuarioUtil;

    public TelaConta(BancoDao bancoDao, ScannerInterface scanner, UsuarioUtil usuarioUtil) {
//        this.bancoDao = new BancoDao();
        this.bancoDao = bancoDao;
        this.scanner = scanner;
        this.usuarioUtil = usuarioUtil;
    }

    @Override
    public void exibeMenu() {

        String mensagemMenu = new StringBuffer()
                .append("> Menu Conta")
                .append("Escolha uma opção: ")
                .append(" 1 - Criar conta")
                .append(" 2 - Listar contas")
                .toString();
        usuarioUtil.exibeMensagem(mensagemMenu);

        int opcao = Integer.parseInt(this.scanner.nextLine());

        if (opcao == 1) {
            exibeMenuCriarConta();
        } else if (opcao == 2) {
            exibeMenuListarConta();
        }
    }

    private void exibeMenuCriarConta() {
        usuarioUtil.exibeMensagem("Informe o número da agência: ");
        int agencia = Integer.parseInt(this.scanner.nextLine());

        usuarioUtil.exibeMensagem("Informe o número da conta: ");
        int conta = Integer.parseInt(this.scanner.nextLine());

        this.bancoDao.adicionarConta(new Conta(agencia, conta));
        usuarioUtil.exibeMensagem("Adicionado com sucesso!");
    }

    private void exibeMenuListarConta() {
        List<Conta> lista = this.bancoDao.listarContas();
        usuarioUtil.exibeMensagem("Lista de contas: ");

        for (Conta conta : lista) {
//            String descricao = new StringBuffer()
//                    .append(conta.getDescricao())
//                    .toString();
//            usuarioUtil.exibeMensagem(descricao);
            usuarioUtil.exibeMensagem(conta.getDescricao());
        }

    }

}