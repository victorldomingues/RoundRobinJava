
package estruturas;

public class FilaIO {
    
    private NoIO inicio, fim;            

    public FilaIO() {
        inicio = null;      //Fila vazia
        fim = null;
    }

    public NoIO getInicio() {
        return inicio;
    }
    
    

    public boolean isEmpty() {
        // true se a Fila está vazia
        return (inicio == null);
    }

    public void enqueue(long dd ) {                           
        NoIO newNo = new NoIO(dd);

        if(inicio == null) {
            inicio = newNo;
            fim = inicio;
        } else {
            fim.next = newNo;
            fim = newNo;
        }
    }
    
    public long dequeue( ) {      // remove do inicio da fila                         
        if ( isEmpty( ) )      //se estiver vazia retorna null
            return 0;

        // utilizado para retornar o dado
        NoIO temp = inicio;
        // move o topo para o prox nó
        inicio = inicio.next;         
        if(inicio==null)
           fim=null;
        return temp.dado;        // retorna o dado
    }

    public void display() {
        if (isEmpty()) {
            System.out.print("Fila vazia.");
        } else {
            NoIO atual = inicio;            // do inicio
            while (atual != null) {      // até o final
                // exibe a informação do nó
                atual.displayNo();   
                // move para o proximo nó     
                atual = atual.next;     
            }
            System.out.println();
        }
    }

        
}
