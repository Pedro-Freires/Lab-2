package Lab2;

public class Disciplina {

    private String nomeDisciplina;
    private int horasEstudo;
    private double nota1;
    private double nota2;
    private double nota3;
    private double nota4;

    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.nota1 = 0;
        this.nota2 = 0;
        this.nota3 = 0;
        this.nota4 = 0;
    }

    public void cadastraHoras(int horas) {
        this.horasEstudo += horas;
    }

    public void cadastraNota(int nota, double valorNota) {
        if (nota == 1) {
            this.nota1 = valorNota;
        } else if (nota == 2) {
            this.nota2 = valorNota;
        } else if (nota == 3) {
            this.nota3 = valorNota;
        } else if (nota == 4) {
            this.nota4 = valorNota;
        }
    }

    public boolean aprovado() {
        double media = (nota1 + nota2 + nota3 + nota4) / 4;
        return media >= 7.0;
    }

    // Declarar as 4 notas parece não ser necessário. Talvez um array seria uma fo
    @Override
    public String toString() {
        double media = (nota1 + nota2 + nota3 + nota4) / 4;

        return nomeDisciplina + " " + horasEstudo + " " + media
                + " [" + nota1 + ", " + nota2 + ", " + nota3 + ", " + nota4 + "]";
    }
}

