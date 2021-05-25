package rmit.fotogram.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import rmit.fotogram.model.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class CreateTagsAndBindDemo {

    public static Timestamp generateTimeStamp() {
        long offset = Timestamp.valueOf("2021-01-01 00:00:00").getTime();
        long end = Timestamp.from(Instant.now()).getTime();
        long diff = end - offset + 1;
        return new Timestamp(offset + (long) (Math.random() * diff));
    }

    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration ().configure ()
                .addAnnotatedClass (User.class)
                .addAnnotatedClass (Post.class)
                .addAnnotatedClass (Tag.class)
                .addAnnotatedClass (Likes.class)
                .addAnnotatedClass (Bind.class)
                .buildSessionFactory ();

        try (factory; Session session = factory.getCurrentSession ()) {
            List<User> users = new ArrayList<> ();

            // DUMMY DATA
            // ----------Add Tags----------
            List<Tag> tags = new ArrayList<> ();
            tags.add (new Tag ("animal", generateTimeStamp ()));
            tags.add (new Tag ("sky", generateTimeStamp ()));
            tags.add (new Tag ("family", generateTimeStamp ()));
            tags.add (new Tag ("nature", generateTimeStamp ()));



            
            // ----------Save All Data----------
            // start transaction
            session.beginTransaction();

            for(Tag tag: tags) {
                session.save(tag);
            }


            // commit transaction
            session.getTransaction().commit();
            System.out.println("---------Transaction Accomplished!--------");

        }
    }
}
