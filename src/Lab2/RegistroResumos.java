package lab2;

import java.util.Arrays;

/**
 * Armazena os resumos de estudo e permite consultar seus temas e conteúdos.
 */
public class RegistroResumos {
    private Resumo[] resumos;
    private int quantidadeResumos;
    private int proximoResumo;

    /**
     * Cria um registro com a quantidade máxima de resumos informada.
     *
     * @param numeroDeResumos limite de resumos que podem ser armazenados
     */
    public RegistroResumos(int numeroDeResumos) {
        this.resumos = new Resumo[numeroDeResumos];
        this.quantidadeResumos = 0;
        this.proximoResumo = 0;
    }

    /**
     * Adiciona um resumo ou atualiza o conteúdo de um tema já cadastrado.
     * Quando o limite é atingido, substitui o resumo mais antigo.
     *
     * @param tema tema do resumo
     * @param conteudo conteúdo do resumo
     */
    public void adiciona(String tema, String conteudo) {
        if (resumos.length == 0) {
            return;
        }

        for (int i = 0; i < quantidadeResumos; i++) {
            int indice = (proximoResumo - quantidadeResumos
                    + resumos.length + i) % resumos.length;

            if (resumos[indice].getTema().equals(tema)) {
                resumos[indice] = new Resumo(tema, conteudo);
                return;
            }
        }

        resumos[proximoResumo] = new Resumo(tema, conteudo);
        proximoResumo = (proximoResumo + 1) % resumos.length;

        if (quantidadeResumos < resumos.length) {
            quantidadeResumos++;
        }
    }

    /**
     * Adiciona um resumo usando o nome alternativo do método.
     *
     * @param tema tema do resumo
     * @param conteudo conteúdo do resumo
     */
    public void adicionaResumo(String tema, String conteudo) {
        adiciona(tema, conteudo);
    }

    /**
     * Retorna os resumos cadastrados na ordem de registro.
     *
     * @return vetor com os resumos formatados
     */
    public String[] pegaResumos() {
        String[] resultado = new String[quantidadeResumos];

        if (resumos.length == 0) {
            return resultado;
        }

        for (int i = 0; i < quantidadeResumos; i++) {
            int indice = (proximoResumo - quantidadeResumos
                    + resumos.length + i) % resumos.length;

            resultado[i] = resumos[indice].toString();
        }

        return resultado;
    }

    /**
     * Informa quantos resumos estão cadastrados.
     *
     * @return quantidade de resumos
     */
    public int conta() {
        return quantidadeResumos;
    }

    /**
     * Retorna a quantidade de resumos cadastrados.
     *
     * @return número de resumos
     */
    public int contaResumos() {
        return quantidadeResumos;
    }

    /**
     * Retorna a quantidade de resumos e seus temas.
     *
     * @return texto com a quantidade e os temas cadastrados
     */
    public String imprimeResumos() {
        String resultado = "- " + quantidadeResumos
                + " resumo(s) cadastrado(s)\n- ";

        String[] temas = new String[quantidadeResumos];

        for (int i = 0; i < quantidadeResumos; i++) {
            int indice = (proximoResumo - quantidadeResumos
                    + resumos.length + i) % resumos.length;
            temas[i] = resumos[indice].getTema();
        }

        resultado += String.join(" | ", temas);
        return resultado;
    }

    /**
     * Verifica se existe um resumo com o tema informado.
     *
     * @param tema tema que será procurado
     * @return true se o tema estiver cadastrado, false caso contrário
     */
    public boolean temResumo(String tema) {
        for (int i = 0; i < quantidadeResumos; i++) {
            int indice = (proximoResumo - quantidadeResumos
                    + resumos.length + i) % resumos.length;

            if (resumos[indice].getTema().equals(tema)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Procura uma palavra no conteúdo dos resumos, sem diferenciar
     * letras maiúsculas de minúsculas.
     *
     * @param chaveDeBusca palavra ou trecho procurado
     * @return temas encontrados em ordem alfabética
     */
    public String[] busca(String chaveDeBusca) {
        String chave = chaveDeBusca.toLowerCase();
        String[] encontrados = new String[quantidadeResumos];
        int quantidadeEncontrada = 0;

        for (int i = 0; i < quantidadeResumos; i++) {
            int indice = (proximoResumo - quantidadeResumos
                    + resumos.length + i) % resumos.length;

            Resumo resumo = resumos[indice];

            if (resumo.getConteudo().toLowerCase().contains(chave)) {
                encontrados[quantidadeEncontrada] = resumo.getTema();
                quantidadeEncontrada++;
            }
        }

        String[] resultado = Arrays.copyOf(encontrados, quantidadeEncontrada);
        Arrays.sort(resultado);

        return resultado;
    }
}
