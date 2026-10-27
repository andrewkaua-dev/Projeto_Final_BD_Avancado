package streaming;

class Cliente {
    private int id;
    private String nome;
    private String preferencia;

    public Cliente(int id, String nome, String preferencia) {
        this.id = id;
        this.nome = nome;
        this.preferencia = preferencia;
    }

    public String getNome() {
        return nome;
    }

    public String getPreferencia() {
        return preferencia;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preferencia='" + preferencia + '\'' +
                '}';
    }
}