package lab2;

/**
 * Registra o tempo dedicado ao estudo online de uma disciplina
 * e verifica se a meta de tempo foi atingida.
 *
 * @author Pedro José
 */
public class RegistroTempoOnline {

    /**
     * Nome da disciplina.
     */
    private String nomeDisciplina;

    /**
     * Quantidade de horas de estudo online realizadas.
     */
    private int tempoOnline;

    /**
     * Quantidade de horas de estudo online esperadas.
     */
    private int tempoOnlineEsperado;

    /**
     * Cria um registro de tempo online com meta padrão de 120 horas.
     *
     * @param nomeDisciplina nome da disciplina
     */
    public RegistroTempoOnline(String nomeDisciplina) {
        this(nomeDisciplina, 120);
    }

    /**
     * Cria um registro de tempo online com a meta informada.
     *
     * @param nomeDisciplina nome da disciplina
     * @param tempoOnlineEsperado quantidade de horas esperadas
     */
    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
        this.tempoOnline = 0;
    }

    /**
     * Adiciona horas ao tempo de estudo online registrado.
     *
     * @param tempo quantidade de horas a adicionar
     */
    public void adicionaTempoOnline(int tempo) {
        this.tempoOnline += tempo;
    }

    /**
     * Verifica se o tempo online registrado atingiu a meta esperada.
     *
     * @return true se a meta foi atingida; false caso contrário
     */
    public boolean atingiuMetaTempoOnline() {
        return tempoOnline >= tempoOnlineEsperado;
    }

    /**
     * Retorna o nome da disciplina, o tempo realizado e a meta esperada.
     * O formato é "nomeDisciplina tempoOnline/tempoOnlineEsperado".
     *
     * @return representação textual do registro de tempo online
     */
    @Override
    public String toString() {
        return nomeDisciplina + " " + tempoOnline + "/" + tempoOnlineEsperado;
    }
}