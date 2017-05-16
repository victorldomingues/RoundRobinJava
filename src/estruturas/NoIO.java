

package estruturas;

public class NoIO {
    
    public long dado;             
    public NoIO next;              

    public NoIO(long dd) { 
        dado = dd;
        next = null;
    }

    public void displayNo() { 
        System.out.print(dado + "|"); 
    }

}
