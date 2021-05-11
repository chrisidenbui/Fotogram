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

public class CreateUserAccsAndPostsDemo {

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
            List<UserAcc> users = new ArrayList<UserAcc>();
            
            // create and add Kubeo into 'users' list
            users.add(new UserAcc(
                    "kubeo",
                    "ku@beo.com",
                    "kubeopass",
                    LocalDate.parse("1996-06-21"),
                    "Kubeo's Bio",
                    "https://avatar.com/kubeo_123.jpeg",
                    Timestamp.valueOf("2021-03-31 13:02:56.111")
                    ));
            
            // create and add Kudzen into 'users' list
            users.add(new UserAcc(
                    "kudzen",
                    "ku@dzen.com",
                    "kudzenpass",
                    LocalDate.parse("2000-01-23"),
                    "Kudzen's Bio",
                    "https://avatar.com/kudzen_456.jpeg",
                    Timestamp.from(Instant.now())
                    ));
            
            // Create Kubeo's posts
            List<Post> kubeoPosts = new ArrayList<Post>();
            kubeoPosts.add(new Post("photo.com/kubeo_1.png", Timestamp.valueOf("2021-03-31 19:02:56.111"), "Bình Dương"));
            kubeoPosts.add(new Post("photo.com/kubeo_2.png", Timestamp.valueOf("2021-4-18 8:5:50.222"), "Đắk Lắk"));
            kubeoPosts.add(new Post("photo.com/kubeo_3.png", Timestamp.from(Instant.now()), "Purple Hotel"));
            
            
            // Create Dzen's posts
            List<Post> dzenPosts = new ArrayList<Post>();
            dzenPosts.add(new Post("photo.com/kubeo_1.png", Timestamp.valueOf("2021-03-31 19:02:56.111"), "Tây Ninh"));
            dzenPosts.add(new Post("photo.com/kubeo_2.png", Timestamp.valueOf("2021-4-18 8:5:50.222"), "Bình Phước"));
            dzenPosts.add(new Post("photo.com/kubeo_3.png", Timestamp.valueOf("2021-4-35 18:15:50.333"), "Vũng Tàu"));
            dzenPosts.add(new Post("photo.com/kubeo_4.png", Timestamp.from(Instant.now()), "Đồng Nai"));
            
            
            // associate useracc objects and post objects
            for (Post post: kubeoPosts) {
                post.setPostedUser(users.get(0)); // associate posts of Kubeo
            }
            for (Post post: dzenPosts) {
                post.setPostedUser(users.get(0)); // associate posts of dzen
            }
            
            
            // start transaction
            session.beginTransaction();
            
            // insert all users into DB
            for(UserAcc user: users) {
                session.save(user);
            }
            // insert Kubeo's posts into DB
            for (Post post: kubeoPosts) {
                session.save(post);
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
