package Models;

public class Cadastro {
    private String CPF;
    private String evento;

    public Cadastro(String CPF, String evento) {
        this.CPF = CPF;
        this.evento = evento;
    }

    // Getters e Setters
    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }
}
