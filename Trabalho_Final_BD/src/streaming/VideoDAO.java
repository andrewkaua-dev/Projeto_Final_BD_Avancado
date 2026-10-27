package streaming;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoDAO {
    MongoCollection<Document> colecao = ConexaoMongo.getColecaoVideos();


    public void salvarVideo(Video video){
        Document documento = new Document().append("id", video.getId()).append("titulo", video.getTitulo())
                .append("categoria", video.getCategoria()).append("resolucao", video.getResolucao());

        colecao.insertOne(documento);

        System.out.printf("Vídeo %s inserido com sucesso", video.getTitulo());

    }

    public Video buscarVideo(String busca){
        FindIterable<Document> resultado = colecao.find(Filters.eq("id",busca));

        Gson gson = new Gson();
        Video video = new Video();

        for(Document d : resultado) {
            video = gson
                    .fromJson(d.toJson(), Video.class);
        }
        return video;
    }

    public Map<Integer,Video> listarVideosMap(){
        Map<Integer,Video> listaVideos = new HashMap<>();
        Gson gson= new Gson();

        for (Document d : colecao.find()){
            Video video= gson.fromJson(d.toJson(), Video.class);
            listaVideos.put(video.getId(),video);
        }

        return listaVideos;
    }

    public List<Video> listarVideos(){
        List<Video> listaVideos = new ArrayList<>();
        Gson gson= new Gson();

        for (Document d : colecao.find()){
            Video video= gson.fromJson(d.toJson(), Video.class);
            listaVideos.add(video);
        }

        return listaVideos;
    }

}
