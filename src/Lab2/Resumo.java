package lab2;

/**
 * Representa um resumo de estudo, composto por um tema e seu conteúdo.
 *
 * @author Pedro José
 */
public class Resumo {

    /**
     * Tema do resumo.
     */
    private String tema;

    /**
     * Conteúdo textual do resumo.
     */
    private String conteudo;

    /**
     * Cria um resumo com o tema e o conteúdo informados.
     *
     * @param tema tema do resumo
     * @param conteudo conteúdo do resumo
     */
    public Resumo(String tema, String conteudo) {
        this.tema = tema;
        this.conteudo = conteudo;
    }

    /**
     * Retorna o tema do resumo.
     *
     * @return tema do resumo
     */
    public String getTema() {
        return tema;
    }

    /**
     * Retorna o conteúdo do resumo.
     *
     * @return conteúdo do resumo
     */
    public String getConteudo() {
        return conteudo;
    }

    /**
     * Retorna o tema seguido do conteúdo do resumo.
     *
     * @return representação textual no formato "tema: conteúdo"
     */
    @Override
    public String toString() {
        return tema + ": " + conteudo;
    }
}