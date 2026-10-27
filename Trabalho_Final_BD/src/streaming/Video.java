package streaming;

class Video {
    private int id;
    private String titulo;
    private String categoria;
    private String resolucao;

    public Video(){}

    public Video(int id, String titulo, String categoria, String resolucao) {
        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
        this.resolucao = resolucao;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getResolucao() {
        return resolucao;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + 
               " | Categoria: " + categoria + 
               " | Resolução: " + resolucao;
    }
}
