/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundrobin;

import estruturas.FilaProcesso;

/**
 *
 * @author Victor
 */
public class Escalonador {

    private int quantum;
    private int tempo;
    private FilaProcesso processos;
    private Processo processo;
    private FilaProcesso espera;

    public Escalonador(int quantum) {
        this.quantum = quantum;
        this.processos = new FilaProcesso();
        this.espera =  new FilaProcesso();
        this.tempo = 0;
    }

    public Escalonador(int quantum, FilaProcesso processos) {
        this.quantum = quantum;
        this.processos = processos;
        this.espera =  new FilaProcesso();
        this.tempo = 0;
    }

    public void adicionarNovoProcesso(Processo processo) {
        this.processos.enqueue(processo);
    }

    public boolean escalonar() {
        if (processos.isEmpty()) {
            System.out.println("A fila de processos está vaiza");
            return false;
        }
        int count = 0;
        long operacaoIO;
        do {
            this.processo = this.processos.getInicio().dado;
            Processo proximoProcesso = processos.getInicio().next == null ?  processo : processos.getInicio().next.dado; 
            while (count < quantum && processo.getDuracao() > processo.getTempoExecucao()) {
                if (this.tempo == processo.getChegada() || this.tempo == proximoProcesso.getChegada()){
                    this.ganttState(" chegada de processo ", (this.tempo == processo.getChegada() ? processo : proximoProcesso));
                    espera.enqueue((this.tempo == processo.getChegada() ? processo : proximoProcesso));
                }
                long novoTempoExecucao  = processo.getTempoExecucao() + 1;
                if (processo.getOperacaoIO().isEmpty()) {
                    processo.setTempoExecucao(novoTempoExecucao);
                    count++;
                } else {
                    operacaoIO = processo.getOperacaoIO().getInicio().dado;
                    if (operacaoIO == processo.getTempoExecucao()) {
                        this.ganttState(" operacao de I/O ", (processo));
                        processos.enqueue(processo);
                        espera.enqueue(processo);
                        count++;
                        processo.setTempoExecucao(novoTempoExecucao);
                        //break;
                    } else {
                        processo.setTempoExecucao(novoTempoExecucao);
                        count++;
                    }
                    this.tempo++;
                }
            }
            count = 0;
            this.processos.dequeue();
            this.espera.dequeue();
        } while (!this.processos.isEmpty());
        return true;
    }
    
    private void ganttState(String complemento, Processo p){
        long contexto =  processo.getDuracao() - processo.getTempoExecucao();
        
        System.out.println("----------------------- \nTEMPO: " + this.tempo + " " + complemento + " P" +  p.getPid());
        System.out.println("FILA: " + espera.toString());
        System.out.println("CPU: P" + processo.getPid() + "(" + contexto + ")" );
    }
}
