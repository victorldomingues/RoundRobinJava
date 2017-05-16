/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import estruturas.FilaIO;
import estruturas.FilaProcesso;
import roundrobin.Escalonador;
import roundrobin.Processo;

/**
 *
 * @author Victor
 */
public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FilaProcesso  fila =  new FilaProcesso();
        
        /* PROCESSO 1 */
        FilaIO p1IO =  new FilaIO();
        p1IO.enqueue(2);
        fila.enqueue(new Processo(3, 5, 0, p1IO));

        /* PROCESSO 2 */
        FilaIO p4IO =  new FilaIO();
        p1IO.enqueue(2);
        p1IO.enqueue(3);
        fila.enqueue(new Processo(4, 7, 1, p4IO));
        
        Escalonador escalodor  = new Escalonador(4, fila);
        escalodor.escalonar();
        
    }
    
}
