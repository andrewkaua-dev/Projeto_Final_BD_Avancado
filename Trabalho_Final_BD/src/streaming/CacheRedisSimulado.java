package streaming;

import java.util.HashMap;
import java.util.Map;

class CacheRedisSimulado {
    private Map<Integer, Video> cacheVideos = new HashMap<>();
    private Map<Integer, Integer> visualizacoesAoVivo = new HashMap<>();

    public Video buscarVideoNoCache(int id) {
        return cacheVideos.get(id);
    }

    public void salvarVideoNoCache(Video video) {
        cacheVideos.put(video.getId(), video);
    }

    public void iniciarVisualizacao(int idVideo) {
        int total = visualizacoesAoVivo.getOrDefault(idVideo, 0);
        visualizacoesAoVivo.put(idVideo, total + 1);
    }

    public void encerrarVisualizacao(int idVideo) {
        int total = visualizacoesAoVivo.getOrDefault(idVideo, 0);

        if (total > 0) {
            visualizacoesAoVivo.put(idVideo, total - 1);
        }
    }

    public int contarVisualizacoesAoVivo(int idVideo) {
        return visualizacoesAoVivo.getOrDefault(idVideo, 0);
    }
}
