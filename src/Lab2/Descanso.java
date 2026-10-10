package lab2;

/**
 * Controla as horas de descanso do aluno e informa seu estado geral.
 *
 * @author Pedro José
 */
public class Descanso {

    /**
     * Quantidade de horas de descanso.
     */
    private int horasDescanso;

    /**
     * Quantidade de semanas consideradas.
     */
    private int numeroSemanas;

    /**
     * Define a quantidade de horas de descanso.
     *
     * @param valor quantidade de horas de descanso
     */
    public void defineHorasDescanso(int valor) {
        this.horasDescanso = valor;
    }

    /**
     * Define a quantidade de semanas consideradas.
     *
     * @param valor quantidade de semanas
     */
    public void defineNumeroSemanas(int valor) {
        this.numeroSemanas = valor;
    }

    /**
     * Verifica se o aluno descansou pelo menos 26 horas por semana.
     *
     * @return "descansado" se atingiu a quantidade necessária;
     * "cansado" caso contrário
     */
    public String getStatusGeral() {
        if (numeroSemanas > 0 && horasDescanso >= 26 * numeroSemanas) {
            return "descansado";
        }

        return "cansado";
    }
}