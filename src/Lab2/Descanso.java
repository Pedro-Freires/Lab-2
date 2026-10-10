
package lab2;

/**
 * Controla as horas de descanso do aluno.
 */
public class Descanso {
    private int horasDescanso;
    private int numeroSemanas;

    /**
     * Define as horas de descanso.
     *
     * @param valor horas de descanso
     */
    public void defineHorasDescanso(int valor) {
        this.horasDescanso = valor;
    }

    /**
     * Define o número de semanas.
     *
     * @param valor quantidade de semanas
     */
    public void defineNumeroSemanas(int valor) {
        this.numeroSemanas = valor;
    }

    /**
     * Informa se o aluno está descansado ou cansado.
     *
     * @return status do aluno
     */
    public String getStatusGeral() {
        if (numeroSemanas > 0 && horasDescanso >= 26) {
            return "descansado";
        }
        return "cansado";
    }
}
