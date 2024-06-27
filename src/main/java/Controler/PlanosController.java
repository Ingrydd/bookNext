/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import Model.Planos;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class PlanosController {
    private List<Planos> planos;
    private DefaultTableModel tableModel;

    public PlanosController(DefaultTableModel tableModel) {
        this.planos = new ArrayList<>();
        this.tableModel = tableModel;
    }

    public void adicionarPlano(String nomePlano, int valorPlano, String tipoPlano, String duracaoPlano) {
        Planos plano = new Planos(nomePlano, valorPlano, tipoPlano, duracaoPlano);
        planos.add(plano);
        atualizarTabela();
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0); 
        for (Planos plano : planos) {
            Object[] rowData = {
                plano.getNomePlano(),
                plano.getValorPlano(),
                plano.getTipoPlano(),
                plano.getDuracaoPlano()
            };
            tableModel.addRow(rowData);
            }
    }
}