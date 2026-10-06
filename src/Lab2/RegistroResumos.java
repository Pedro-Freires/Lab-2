package Lab2;

public class RegistroResumos {

    private String[] resumos;
    private int proximoResumo;
    private int quantidadeResumos;

    public RegistroResumos(int numeroDeResumos) {
        this.resumos = new String[numeroDeResumos];
        this.proximoResumo = 0;
        this.quantidadeResumos = 0;
    }

    //adicionaResumo pode ser melhorado.
    public void adicionaResumo(String tema, String conteudo) {
        String resumo = tema + ": " + conteudo;

        for (int i = 0; i < resumos.length; i++) {
            if (resumos[i] != null && resumos[i].startsWith(tema + ": ")) {
                resumos[i] = resumo;
                return;
            }
        }

        resumos[proximoResumo] = resumo;

        if (quantidadeResumos < resumos.length) {
            quantidadeResumos++;
        }

        proximoResumo++;

        if (proximoResumo == resumos.length) {
            proximoResumo = 0;
        }
    }

    public String[] pegaResumos() {
        return resumos;
    }

    public String imprimeResumos() {
        String resultado = "";

        for (int i = 0; i < resumos.length; i++) {
            if (resumos[i] != null) {
                resultado += resumos[i] + " | ";
            }
        }

        return resultado;
    }

    /*
    Método incomplmeto
     */
    public int contaResumos() {
        return quantidadeResumos;
    }

    //Não existe o método temResumo();
}

