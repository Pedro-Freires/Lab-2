package lab2;

/**
 * Controla as horas de descanso do aluno e informa seu estado geral
 * de acordo com a quantidade de horas descansadas por semana.
 *
 * @author Pedro José
 */
public class Descanso {

    /**
     * Quantidade de horas de descanso registradas.
     */
    private int horasDescanso;

    /**
     * Número de semanas considerado no registro de descanso.
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
     * Define o número de semanas considerado no registro.
     *
     * @param valor quantidade de semanas
     */
    public void defineNumeroSemanas(int valor) {
        this.numeroSemanas = valor;
    }

    /**
     * Informa o estado geral de descanso do aluno.
     * O aluno é considerado descansado quando possui pelo menos
     * 26 horas de descanso por semana e o número de semanas é positivo.
     *
     * @return "descansado" se atingir o mínimo exigido; "cansado" caso contrário
     */
    public String getStatusGeral() {
        if (numeroSemanas > 0 && horasDescanso >= 26 * numeroSemanas) {
            return "descansado";
        }

        return "cansado";
    }
}