package streaming;

public class PlataformaStreaming {

    public static void main(String[] args) {

        BancoDeDados banco = new BancoDeDados();
        CacheRedisSimulado cache = new CacheRedisSimulado();

        Video video1 = new Video(1, "Série DevOps", "Tecnologia", "4K");
        Video video2 = new Video(2, "Filme Banco de Dados", "Educação", "Full HD");

        banco.salvarVideo(video1);
        banco.salvarVideo(video2);

        Cliente cliente1 = new Cliente(1, "Pedro", "Tecnologia");
        
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.salvarCliente(cliente1);

        System.out.println("Cliente: " + cliente1.getNome());
        System.out.println("Preferência: " + cliente1.getPreferencia());

        int idVideoBuscado = 1;

        Video video = cache.buscarVideoNoCache(idVideoBuscado);

        if (video == null) {
            video = banco.buscarVideo(idVideoBuscado);
            cache.salvarVideoNoCache(video);
            System.out.println("Vídeo salvo no cache.");
        } else {
            System.out.println("Vídeo encontrado no cache.");
        }

        System.out.println("Vídeo escolhido: " + video);

        cache.iniciarVisualizacao(1);
        cache.iniciarVisualizacao(1);
        cache.iniciarVisualizacao(1);

        System.out.println("Pessoas assistindo agora: " + cache.contarVisualizacoesAoVivo(1));

        cache.encerrarVisualizacao(1);

        System.out.println("Pessoas assistindo agora após saída de um usuário: " 
                + cache.contarVisualizacoesAoVivo(1));

        System.out.println("Resumo enviado posteriormente ao banco de dados.");

        banco.listarVideos();
    }
}