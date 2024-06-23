package Controler;
import Model.Reserva;

public class ReservaCtrl {
    String statusPagamento;    
    int dataInicio;
    int dataFim;
    int numQuarto;
    int idReserva;
    
    public ReservaCtrl(){
        //abrir conexão com o banco de dados
    }
    
    public void cancelaReserva(Reserva reserva){
        System.out.println("Reserva cancelada com sucesso!");
    }
}
