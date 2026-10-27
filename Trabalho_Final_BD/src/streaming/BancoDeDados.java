package streaming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BancoDeDados {
    private VideoDAO videoDao = new VideoDAO();
    private Map<Integer, Video> videos = videoDao.listarVideosMap();

    public void salvarVideo(Video video) {
        videos.put(video.getId(), video);
        videoDao.salvarVideo(video);
    }

    public Video buscarVideo(int id) {
        System.out.println("Buscando vídeo no banco de dados...");
        return videos.get(id);
    }

    public void listarVideos(){
        List<Video> listaVideos = videoDao.listarVideos();

        for (Video v : listaVideos){
            System.out.println("Lista de vídeos:");
            System.out.println("Id: " + v.getId());
            System.out.println("Titulo: " + v.getTitulo());
            System.out.println("Categoria: " + v.getCategoria());
            System.out.println("Resoulção: " + v.getResolucao());
        }
    }
}

