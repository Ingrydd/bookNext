package Controler;
import Model.Funcionario;
import Model.Hospede;
import Model.Reserva;

public class FuncionarioCtrl {
    String nome;
    int numFuncionario;
    int telefone;
    int cpf;
    
    public FuncionarioCtrl(){
        
    }
    
    public void cadastraHospede(Funcionario funcionario){
        System.out.println("Hóspede cadastrado com sucesso!");
    }
    
    public void registraPagamento(Hospede hospede){
        System.out.println("Pagamento registrado com sucesso!");
    }
    
    public void alteraReserva(Reserva reserva){
        System.out.println("Reserva alterada com sucesso!");
    }
    
    public void cancelaReserva(Reserva reserva){
        System.out.println("Reserva cancelada com sucesso!");
    }
}
