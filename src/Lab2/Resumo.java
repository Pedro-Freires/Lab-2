package lab2;

/**
 * Representa um resumo de estudo com um tema e seu conteúdo.
 */
public class Resumo {
    private String tema;
    private String conteudo;

    /**
     * Cria um resumo com o tema e o conteúdo informados.
     *
     * @param tema tema do resumo
     * @param conteudo texto do resumo
     */
    public Resumo(String tema, String conteudo) {
        this.tema = tema;
        this.conteudo = conteudo;
    }

    /**
     * Retorna o tema do resumo.
     *
     * @return tema cadastrado
     */
    public String getTema() {
        return tema;
    }

    /**
     * Retorna o conteúdo do resumo.
     *
     * @return conteúdo cadastrado
     */
    public String getConteudo() {
        return conteudo;
    }

    /**
     * Retorna o tema seguido do conteúdo.
     *
     * @return resumo formatado
     */
    @Override
    public String toString() {
        return tema + ": " + conteudo;
    }
}
