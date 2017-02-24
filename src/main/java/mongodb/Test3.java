package mongodb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Set;

/**
 * Test3
 * 
 * @author liuruichao
 * Created on 2016-01-19 15:03
 */
public class Test3 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MongoTemplate mongoTemplate = (MongoTemplate) context.getBean("mongoTemplate");
        //Set<String> collectionNames = mongoTemplate.getCollectionNames();
        // 所有表名
        //collectionNames.forEach(System.out::println);

        Student student = mongoTemplate.findOne(new Query(Criteria.where("name").is("liuruichao")), Student.class);
        System.out.println(student);
    }
    private static class Student {
        private String id;
        private String name;
        private int age;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
