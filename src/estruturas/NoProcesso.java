

package estruturas;

import roundrobin.Processo;

public class NoProcesso {
    public Processo dado;             
    public NoProcesso next;              

    public NoProcesso(Processo dd) { 
        dado = dd;
        next = null;
    }

    public void displayNo() { 
        System.out.print(dado.toString() + "|"); 
    }

}
