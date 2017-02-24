package mongodb;


import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.Document;

import java.util.function.Consumer;

/**
 * Test1
 * 
 * @author liuruichao
 * Created on 2016-01-19 14:11
 */
public class Test1 {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient();
        // 获得所有数据库名称
        /*MongoIterable<String> dbNames = mongoClient.listDatabaseNames();
        dbNames.forEach((Block<String>) System.out::println);*/

        // 获得数据库所有表名
        MongoDatabase db = mongoClient.getDatabase("test");
        /*MongoIterable<String> collectionNames = db.listCollectionNames();
        collectionNames.forEach((Block<String>) System.out::println);*/

        /*MongoCollection<Document> studentList = db.getCollection("student");
        System.out.println("count : " + studentList.count());*/
        // 跳过1条数据,取两条数据
        /*FindIterable<Document> iterable = studentList.find().skip(1).limit(2);
        iterable.forEach((Consumer<Document>) document -> {
            String name = document.getString("name");
            double age = document.getDouble("age");
            System.out.println(String.format("name : %s, age : %s.", name, age));
        });*/

        // 添加一条记录
        /*MongoCollection<Document> studentList = db.getCollection("student");
        Document document = new Document();
        document.put("name", "liuruichao");
        document.put("age", 23);
        document.put("gender", 1);
        studentList.insertOne(document);*/

        // 更新一条记录
        /*MongoCollection<Document> studentList = db.getCollection("student");
        Document filter = new Document("name", "liuruichao2");
        Document update = new Document("$set", new Document("age", 23));
        studentList.updateOne(filter, update);*/

        // 删除一条记录
        MongoCollection<Document> studentList = db.getCollection("student");
        studentList.deleteOne(new Document("name", "liuruichao3"));
    }
}
