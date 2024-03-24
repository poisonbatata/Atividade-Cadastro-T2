package Models;

public class Associacao {
    private String CPF;
    private String evento;

    public Associacao(String CPF, String evento) {
        this.CPF = CPF;
        this.evento = evento;
    }

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
