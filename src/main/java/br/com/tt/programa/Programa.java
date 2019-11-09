package br.com.tt.programa;

import br.com.tt.dao.BancoDao;
import br.com.tt.tela.Tela;
import br.com.tt.tela.TelaConta;
import br.com.tt.tela.TelaCorrentista;
import br.com.tt.util.MasterUsuarioUtil;
import br.com.tt.util.ScannerInterface;
import br.com.tt.util.UsuarioUtil;

public class Programa {

    private static Tela telaCorrentista;
    private static Tela telaConta;
    private static BancoDao bancoDao;
    private static ScannerInterface scanner;
    private static UsuarioUtil usuarioUtil;

    public static void main(String[] args) {
        bancoDao = new BancoDao();
        scanner = new MasterUsuarioUtil();
        usuarioUtil = new MasterUsuarioUtil();

        telaCorrentista = new TelaCorrentista(bancoDao, scanner, usuarioUtil);
        telaConta = new TelaConta(bancoDao, scanner, usuarioUtil);

        boolean continuar = true;
        while (continuar) {
            continuar = exibeMenuPrincipal();
        }
    }


    public static boolean exibeMenuPrincipal() {
        String mensagemMenu = new StringBuffer()
                .append("\n>> Menu Principal\n")
                .append(" Escolha uma opção: \n")
                .append(" 1 - Correntista \n")
                .append(" 2 - Conta\n")
                .append(" 3 - Movimento\n")
                .append(" 99 - Encerrar\n")
                .toString();
        usuarioUtil.exibeMensagem(mensagemMenu);

        int opcao = Integer.parseInt(scanner.nextLine());

        if (opcao == 1) {
            //TelaCorrentista telaCorrentista = new TelaCorrentista();
            telaCorrentista.exibeMenu();
        } else if (opcao == 2) {
            telaConta.exibeMenu();
        } else if (opcao == 99) {
            return false;
        }

        return true;
    }

}
