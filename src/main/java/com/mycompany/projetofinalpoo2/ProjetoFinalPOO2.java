package com.mycompany.projetofinalpoo2;
import View.PrincipalGUI;

public class ProjetoFinalPOO2 {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new PrincipalGUI().setVisible(true);
            }
        });        
    }
}

