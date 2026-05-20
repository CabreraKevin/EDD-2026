import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBManager {
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public MongoDBManager() {
        // Conexión a MongoDB local
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("SistemaUniversitario");
        collection = database.getCollection("estudiantes");
    }

    // Método para guardar tu objeto Estudiante en NoSQL
    public void guardarEstudiante(Estudiante est) {
        Document doc = new Document("id", est.getId())
                .append("nombre", est.getNombre())
                .append("email", est.getEmail())
                .append("semestre", est.getSemestre());
        
        collection.insertOne(doc);
        System.out.println("Estudiante persistido en MongoDB con éxito.");
    }
}