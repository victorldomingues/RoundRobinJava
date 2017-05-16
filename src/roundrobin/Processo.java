/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundrobin;

import estruturas.FilaIO;

/**
 *
 * @author Victor
 */
public class Processo {
    private long pid;
    private long duracao;
    private long chegada;
    private FilaIO operacaoIO;
    private long tempoExecucao;
    public Processo(long pid, long duracao, long chegada, FilaIO operacaoIO) {
        this.pid = pid;
        this.duracao = duracao;
        this.chegada = chegada;
        this.operacaoIO = operacaoIO;
        this.tempoExecucao = 0;
    }

    public void setTempoExecucao(long tempoExecucao) {
        this.tempoExecucao = tempoExecucao;
    }

    public long getTempoExecucao() {
        return tempoExecucao;
    }

    /**
     * @return the pid
     */
    public long getPid() {
        return pid;
    }

    /**
     * @param pid the pid to set
     */
    public void setPid(long pid) {
        this.pid = pid;
    }

    /**
     * @return the duracao
     */
    public long getDuracao() {
        return duracao;
    }

    /**
     * @param duracao the duracao to set
     */
    public void setDuracao(long duracao) {
        this.duracao = duracao;
    }

    /**
     * @return the chegada
     */
    public long getChegada() {
        return chegada;
    }

    /**
     * @param chegada the chegada to set
     */
    public void setChegada(long chegada) {
        this.chegada = chegada;
    }

    /**
     * @return the operacaoIO
     */
    public FilaIO getOperacaoIO() {
        return operacaoIO;
    }

    /**
     * @param operacaoIO the operacaoIO to set
     */
    public void setOperacaoIO(FilaIO operacaoIO) {
        this.operacaoIO = operacaoIO;
    }
}
