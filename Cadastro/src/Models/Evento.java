package Models;

public class Evento {
    private String nome;
    private String tipo;
    private String local;

    public Evento(String nome, String tipo, String local) {
        this.nome = nome;
        this.tipo = tipo;
        this.local = local;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
