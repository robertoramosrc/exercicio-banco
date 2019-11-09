package br.com.tt.util;

import javax.swing.*;

public class MasterUsuarioUtil extends UsuarioUtil implements ScannerInterface{

    @Override
    public void exibeMensagem(String mensagem){
        super.exibeMensagem(mensagem);
        JOptionPane.showMessageDialog(null, mensagem);
    }

    @Override
    public String nextLine() {
        return JOptionPane.showInputDialog("Informe um valor:");
    }
}
