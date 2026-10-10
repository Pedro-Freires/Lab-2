package lab2;

import java.util.Arrays;

/**
 * Representa uma disciplina com horas de estudo, notas e pesos.
 * Permite cadastrar notas, calcular a média ponderada e verificar
 * se o aluno foi aprovado.
 *
 * @author Pedro José
 */
public class Disciplina {

    /**
     * Nome da disciplina.
     */
    private String nomeDisciplina;

    /**
     * Quantidade total de horas de estudo da disciplina.
     */
    private int horasEstudo;

    /**
     * Notas cadastradas na disciplina.
     */
    private double[] notas;

    /**
     * Pesos correspondentes a cada nota.
     */
    private int[] pesos;

    /**
     * Cria uma disciplina com quatro notas de mesmo peso.
     *
     * @param nomeDisciplina nome da disciplina
     */
    public Disciplina(String nomeDisciplina) {
        this(nomeDisciplina, 4);
    }

    /**
     * Cria uma disciplina com a quantidade de notas informada,
     * considerando todas as notas com o mesmo peso.
     *
     * @param nomeDisciplina nome da disciplina
     * @param numeroNotas quantidade de notas
     */
    public Disciplina(String nomeDisciplina, int numeroNotas) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.notas = new double[numeroNotas];
        this.pesos = new int[numeroNotas];

        for (int i = 0; i < numeroNotas; i++) {
            this.pesos[i] = 1;
        }
    }

    /**
     * Cria uma disciplina com a quantidade de notas e seus respectivos pesos.
     * Se o vetor de pesos for nulo, todas as notas terão o mesmo peso.
     *
     * @param nomeDisciplina nome da disciplina
     * @param numeroNotas quantidade de notas
     * @param pesos vetor com os pesos das notas
     * @throws IllegalArgumentException se a quantidade de pesos for diferente
     * da quantidade de notas
     */
    public Disciplina(String nomeDisciplina, int numeroNotas, int[] pesos) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.notas = new double[numeroNotas];

        if (pesos == null) {
            this.pesos = new int[numeroNotas];

            for (int i = 0; i < numeroNotas; i++) {
                this.pesos[i] = 1;
            }
        } else {
            if (pesos.length != numeroNotas) {
                throw new IllegalArgumentException(
                        "A quantidade de pesos deve ser igual à quantidade de notas.");
            }

            this.pesos = Arrays.copyOf(pesos, pesos.length);
        }
    }

    /**
     * Adiciona horas ao total de estudo da disciplina.
     *
     * @param horas quantidade de horas estudadas
     */
    public void cadastraHoras(int horas) {
        this.horasEstudo += horas;
    }

    /**
     * Cadastra ou substitui uma nota da disciplina.
     * As posições das notas começam em 1.
     *
     * @param nota posição da nota
     * @param valorNota valor da nota
     */
    public void cadastraNota(int nota, double valorNota) {
        if (nota >= 1 && nota <= notas.length) {
            notas[nota - 1] = valorNota;
        }
    }

    /**
     * Verifica se a média da disciplina é igual ou superior a 7.
     *
     * @return true se o aluno foi aprovado; false caso contrário
     */
    public boolean aprovado() {
        return calcularMedia() >= 7.0;
    }

    /**
     * Calcula a média ponderada das notas cadastradas.
     *
     * @return média ponderada das notas
     */
    private double calcularMedia() {
        double somaPonderada = 0;
        int somaPesos = 0;

        for (int i = 0; i < notas.length; i++) {
            somaPonderada += notas[i] * pesos[i];
            somaPesos += pesos[i];
        }

        if (somaPesos == 0) {
            return 0;
        }

        return somaPonderada / somaPesos;
    }

    /**
     * Retorna o nome, as horas de estudo, a média e as notas da disciplina.
     *
     * @return representação textual da disciplina
     */
    @Override
    public String toString() {
        return nomeDisciplina + " " + horasEstudo + " "
                + calcularMedia() + " " + Arrays.toString(notas);
    }
}