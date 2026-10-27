package streaming;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

public class ConexaoMongo {

    private static MongoClient cliente =
            MongoClients.create("mongodb://localhost:27017");

    private static MongoDatabase banco =
            cliente.getDatabase("Streaming");

    public static MongoCollection<Document> getColecaoVideos() {
        return banco.getCollection("videos");
    }

}