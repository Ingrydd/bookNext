/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


public class Planos {
    String nomePlano;
    int valorPlano;
    String tipoPlano;
    String duracaoPlano;
    
    public Planos(String nomePlano, int valorPlano, String tipoPlano, String duracaoPlano) {
        this.nomePlano = nomePlano;
        this.valorPlano = valorPlano;
        this.tipoPlano = tipoPlano;
        this.duracaoPlano = duracaoPlano;
    }

    public String getNomePlano() {
        return nomePlano;
    }

    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
    }

    public int getValorPlano() {
        return valorPlano;
    }

    public void setValorPlano(int valorPlano) {
        this.valorPlano = valorPlano;
    }

    public String getTipoPlano() {
        return tipoPlano;
    }

    public void setTipoPlano(String tipoPlano) {
        this.tipoPlano = tipoPlano;
    }

    public String getDuracaoPlano() {
        return duracaoPlano;
    }

    public void setDuracaoPlano(String duracaoPlano) {
        this.duracaoPlano = duracaoPlano;
    }
    
}
