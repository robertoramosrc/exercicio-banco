package br.com.tt.dao;

import br.com.tt.model.Conta;
import br.com.tt.model.Correntista;

import java.util.ArrayList;
import java.util.List;

public class BancoDao {

    private List<Correntista> correntistas;
    private List<Conta> contas;

    public BancoDao() {
        correntistas = new ArrayList<>();
        contas = new ArrayList<>();
    }

    public void adicionarCorrentista(Correntista correntista){
        correntistas.add(correntista);
    }

    public List<Correntista> listarCorrentistas(){
        return correntistas;
    }

    public Correntista buscarCorrentistaPor(String nome){
        for (Correntista correntista: correntistas) {
            if(correntista.getNome().equals(nome)){
                return correntista;
            }
        }

        throw new IllegalArgumentException("Correntista não encontrado!");
    }

    public void adicionarConta(Conta conta){
        contas.add(conta);
    }

    public List<Conta> listarContas(){
        return contas;
    }

    public Conta buscarContaPor(Integer agencia, Integer numero){
        for (Conta conta: contas) {
            if(agencia.equals(conta.getAgencia()) && numero.equals(conta.getNumero())){
                return conta;
            }
        }

        throw new IllegalArgumentException("Conta não encontrada!");
    }

}
