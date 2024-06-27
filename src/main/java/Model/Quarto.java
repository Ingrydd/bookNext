package Model;

public class Quarto {
    int numQuarto;
    int valorDiaria;
    String andar;
    String tipoQuarto;
    String estado;

    public Quarto(int numQuarto, int valorDiaria, String andar, String tipoQuarto, String estado) {
        this.numQuarto = numQuarto;
        this.valorDiaria = valorDiaria;
        this.andar = andar;
        this.tipoQuarto = tipoQuarto;
        this.estado = estado;
    }

    public int getNumQuarto() {
        return numQuarto;
    }

    public void setNumQuarto(int numQuarto) {
        this.numQuarto = numQuarto;
    }

    public int getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(int valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}