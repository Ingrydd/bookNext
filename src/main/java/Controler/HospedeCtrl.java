package Controler;
import Model.Hospede;

public class HospedeCtrl {
    String avaliacao;
    String email;
    String nome;
    int idHospede;
    int telefone;
    int idade;
    int cpf;
    
    public HospedeCtrl(){
        //abrir conexão com o banco de dados
    }
    
    public void adicionaAvaliacao(Hospede hospede){
        System.out.println("Avaliação cadastrada com sucesso!");
    }
    
    public void verificaPagamento(Hospede hospede){
        System.out.println("Pagamento aprovado com sucesso!");
    }
}
