
package lab2;

/**
 * Registra o tempo online de uma disciplina.
 */
public class RegistroTempoOnline {
    private String nomeDisciplina;
    private int tempoOnline;
    private int tempoOnlineEsperado;

    /**
     * Cria um registro com meta de 120 horas.
     *
     * @param nomeDisciplina nome da disciplina
     */
    public RegistroTempoOnline(String nomeDisciplina) {
        this(nomeDisciplina, 120);
    }

    /**
     * Cria um registro com a meta informada.
     *
     * @param nomeDisciplina nome da disciplina
     * @param tempoOnlineEsperado meta de horas
     */
    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
        this.tempoOnline = 0;
    }

    /**
     * Adiciona tempo ao registro.
     *
     * @param tempo horas adicionadas
     */
    public void adicionaTempoOnline(int tempo) {
        this.tempoOnline += tempo;
    }

    /**
     * Verifica se a meta foi atingida.
     *
     * @return true se atingiu a meta
     */
    public boolean atingiuMetaTempoOnline() {
        return tempoOnline >= tempoOnlineEsperado;
    }

    /**
     * Retorna os dados do registro.
     *
     * @return nome, tempo realizado e meta
     */
    @Override
    public String toString() {
        return nomeDisciplina + " " + tempoOnline + "/" + tempoOnlineEsperado;
    }
}
