package lab2;

public class RegistroResumos {
    private String[] resumos;
    private int quantidadeResumos;
    private int proximoResumo;

    public RegistroResumos(int numeroDeResumos) {
        this.resumos = new String[numeroDeResumos];
        this.quantidadeResumos = 0;
        this.proximoResumo = 0;
    }

    public void adiciona(String tema, String conteudo) {
        if (resumos.length == 0) {
            return;
        }

        String novoResumo = tema + ": " + conteudo;

        for (int i = 0; i < quantidadeResumos; i++) {
            int indice = (proximoResumo - quantidadeResumos
                    + resumos.length + i) % resumos.length;

            if (resumos[indice].startsWith(tema + ": ")) {
                resumos[indice] = novoResumo;
                return;
            }
        }

        resumos[proximoResumo] = novoResumo;
        proximoResumo = (proximoResumo + 1) % resumos.length;

        if (quantidadeResumos < resumos.length) {
            quantidadeResumos++;
        }
    }

    public void adicionaResumo(String tema, String conteudo) {
        adiciona(tema, conteudo);
    }

    public String[] pegaResumos() {
        String[] resultado = new String[quantidadeResumos];

        for (int i = 0; i < quantidadeResumos; i++) {
            int indice = (proximoResumo - quantidadeResumos
                    + resumos.length + i) % resumos.length;

            resultado[i] = resumos[indice];
        }

        return resultado;
    }

    public int conta() {
        return quantidadeResumos;
    }

    public int contaResumos() {
        return quantidadeResumos;
    }

    public String imprimeResumos() {
        String resultado = "- " + quantidadeResumos
                + " resumo(s) cadastrado(s)\n";

        resultado += "- ";

        String[] atuais = pegaResumos();

        for (int i = 0; i < atuais.length; i++) {
            if (i > 0) {
                resultado += " | ";
            }

            String resumo = atuais[i];
            String tema = resumo.substring(0, resumo.indexOf(": "));

            resultado += tema;
        }

        return resultado;
    }

    public boolean temResumo(String tema) {
        for (String resumo : pegaResumos()) {
            if (resumo.startsWith(tema + ": ")) {
                return true;
            }
        }

        return false;
    }
}
