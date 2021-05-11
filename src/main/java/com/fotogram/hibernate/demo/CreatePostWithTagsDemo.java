package com.fotogram.hibernate.demo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fotogram.hibernate.entity.Likes;
import com.fotogram.hibernate.entity.Post;
import com.fotogram.hibernate.entity.Tag;
import com.fotogram.hibernate.entity.UserAcc;

public class CreatePostWithTagsDemo {

    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.config.xml")
                .addAnnotatedClass(UserAcc.class)
                .addAnnotatedClass(Post.class)
                .addAnnotatedClass(Tag.class)
                .addAnnotatedClass(Likes.class)
                .buildSessionFactory();
        
        // create session
        Session session = factory.getCurrentSession();
        
        try {
            // create Kudzen' post (input from user)
            Post post = new Post(
                    "photo.com/kudzen_1.png", 
                    Timestamp.valueOf("2021-04-29 09:09:09.999"),
                    "RMIT");
            
            // create Kudzen' tags (input from user)
            List<String> tagString = new ArrayList<String>();
            
            tagString.add("Book");
            tagString.add("SchooL");
            tagString.add("RMIT");
            tagString.add("caT");
            tagString.add("DOG");
            tagString.add("MonkEY");
            tagString.add("RocKET");
            
            
            // create Dzen's Tag objects from tag-string
            List<Tag> tags = new ArrayList<>();
            for (String str: tagString) {
                tags.add(new Tag(str));
            }
            
            // start transaction
            session.beginTransaction();
            
            for (Tag tag: tags) {
                session.save(tag);
            }
            
//            // just add tags that have not appeared in the database yet.
//            String hql = "";
//            for (Tag tag: tags) {
//                hql = "select count(t) from Tag as t where t.tagName = :inputTag";
//                Query query = session.createQuery(hql);
//                query.setParameter("inputTag", tag.getTagName());
//                
//                List<Tag> res = query.getResultList(); 
//                
//                if (res.isEmpty()) {
//                    session.save(tag);
//                }
//            }
            
//            new Post("photo.com/kudzen_2.png", Timestamp.valueOf("2021-4-18 8:5:50.222"), "Đắk Lắk");
//            new Post("photo.com/kudzen_3.png", Timestamp.from(Instant.now()), "Purple Hotel");
            
            
            // commit transaction
            session.getTransaction().commit();
            System.out.println("---------DONE--------");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
