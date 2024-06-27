/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import Model.Quarto;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class QuartoController {
    private List<Quarto> quartos;
    private DefaultTableModel tableModel;

    public QuartoController(DefaultTableModel tableModel) {
        this.quartos = new ArrayList<>();
        this.tableModel = tableModel;
    }

    public void adicionarQuarto(Quarto quarto) {
        quartos.add(quarto);
        atualizarTabela();
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa a tabela
        for (Quarto quarto : quartos) {
            Object[] rowData = {
                quarto.getNumQuarto(),
                quarto.getValorDiaria(),
                quarto.getAndar(),
                quarto.getTipoQuarto(),
                quarto.getEstado()
            };
            tableModel.addRow(rowData);
        }
    }
}