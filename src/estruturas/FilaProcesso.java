
package estruturas;

import roundrobin.Processo;

public class FilaProcesso {
    
    private NoProcesso inicio, fim;            
    private long quantidade;
    public FilaProcesso() {
        inicio = null;      //Fila vazia
        fim = null;
        quantidade = 0;
    }           

    public boolean isEmpty() {
        // true se a Fila está vazia
        return (inicio == null);
    }

    public void enqueue(Processo dd ) {                           
        NoProcesso newNo = new NoProcesso(dd);

        if(inicio == null) {
            inicio = newNo;
            fim = inicio;
        } else {
            fim.next = newNo;
            fim = newNo;
        }
        quantidade++;
    }
    
    public Processo dequeue( ) {      // remove do inicio da fila                         
        if ( isEmpty( ) )      //se estiver vazia retorna null
            return null;

        // utilizado para retornar o dado
        NoProcesso temp = inicio;
        // move o topo para o prox nó
        inicio = inicio.next;         
        if(inicio==null)
           fim=null;
        
        quantidade--;
        return temp.dado;        // retorna o dado
        
    }

    public void display() {
        if (isEmpty()) {
            System.out.print("Fila vazia.");
        } else {
            NoProcesso atual = inicio;            // do inicio
            while (atual != null) {      // até o final
                // exibe a informação do nó
                atual.displayNo();   
                // move para o proximo nó     
                atual = atual.next;     
            }
            System.out.println();
        }
    }

    /**
     * @return the quantidade
     */
    public long getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(long quantidade) {
        this.quantidade = quantidade;
    }

    public NoProcesso getInicio() {
        return inicio;
    }
    
    @Override
    public String toString(){
        String retorno  =  "";
        if (isEmpty()) {
            retorno += "Fila vazia.";
        } else {
            NoProcesso atual = inicio;            // do inicio
            while (atual != null) {      // até o final
                // exibe a informação do nó
                //atual.displayNo();   
                // move para o proximo nó   
                long contexto  = atual.dado.getDuracao() - atual.dado.getTempoExecucao();
                retorno += ("P" +  atual.dado.getPid() + "(" + contexto +  ")\t");
                atual = atual.next;     
                
            }
        }
        return retorno;
    }
    
    

        
}
