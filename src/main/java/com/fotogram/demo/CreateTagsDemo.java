package com.fotogram.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fotogram.model.Likes;
import com.fotogram.model.Post;
import com.fotogram.model.Tag;
import com.fotogram.model.UserAcc;

public class CreateTagsDemo {

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
            // create tags
            List<Tag> tags = new ArrayList<>();
            
            tags.add(new Tag("CaT"));
            tags.add(new Tag("University"));
            tags.add(new Tag("SchOOl"));
            tags.add(new Tag("DoG"));
            tags.add(new Tag("Fish"));
            tags.add(new Tag("natUre"));
            tags.add(new Tag("FiELD"));
            tags.add(new Tag("TrEE"));
            
            
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
//                System.out.println("> > > > >" + res);
//                System.out.println("----------");
//                
//                if (res.isEmpty()) {
//                    session.save(tag);
//                }
//            }
            

            
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
