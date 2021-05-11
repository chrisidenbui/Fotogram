package com.fotogram.hibernate.demo;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fotogram.hibernate.entity.Likes;
import com.fotogram.hibernate.entity.Post;
import com.fotogram.hibernate.entity.Tag;
import com.fotogram.hibernate.entity.UserAcc;

public class CreateUserAccDemo {

    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration().configure("src/main/java/hibernate.config.xml")
                .addAnnotatedClass(UserAcc.class)
                .addAnnotatedClass(Post.class)
                .addAnnotatedClass(Tag.class)
                .addAnnotatedClass(Likes.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        
        try {
            List<UserAcc> users = new ArrayList<UserAcc>();
            
            // kubeo's info
            users.add(new UserAcc(
                    "kubeo",
                    "ku@beo.com",
                    "kubeopass",
                    LocalDate.parse("1996-06-21"),
                    "Kubeo's Bio",
                    "https://avatar.com/kubeo_123.jpeg",
                    Timestamp.from(Instant.now())
                    ));
            
            // kudzen's info
            users.add(new UserAcc(
                    "kudzen",
                    "ku@dzen.com",
                    "kudzenpass",
                    LocalDate.parse("2000-01-23"),
                    "Kudzen's Bio",
                    "https://avatar.com/kudzen_456.jpeg",
                    Timestamp.from(Instant.now())
                    ));
            
            
            // start transaction
            session.beginTransaction();
            
            // insert java objects to DB
            for(UserAcc user: users) {
                session.save(user);
            }
            
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
