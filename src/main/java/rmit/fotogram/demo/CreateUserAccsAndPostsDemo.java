package rmit.fotogram.demo;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import rmit.fotogram.model.*;


public class CreateUserAccsAndPostsDemo {

    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration().configure()
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Post.class)
                .addAnnotatedClass(Tag.class)
                .addAnnotatedClass(Likes.class)
                .addAnnotatedClass(Bind.class)
                .buildSessionFactory();

        try (factory; Session session = factory.getCurrentSession()) {
            List<User> users = new ArrayList<>();

            // DUMMY DATA
            // ----------Add Users----------
            // create and add Nhan into 'users' list
            users.add(new User(
                    "nhan",
                    "Nhàn",
                    "Nguyễn",
                    "nhan@nhan.com",
                    "nhanpass",
                    LocalDate.parse("1999-08-08"),
                    "Nhan's Bio",
                    "https://avatar.com/nhan_123.jpeg",
                    Timestamp.from(Instant.now())
            ));
            // create and add Chau into 'users' list
            users.add(new User(
                    "chau",
                    "Châu","Nguyễn",
                    "chau@chau.net",
                    "chaupass",
                    LocalDate.parse("2000-03-03"),
                    "Chau's Bio",
                    "https://avatar.com/chau_456.jpeg",
                    Timestamp.valueOf("2021-05-05 07:08:09.111")
            ));

            // create and add Triet into 'users' list
            users.add(new User(
                    "triet",
                    "Chrisiden",
                    "Bùi",
                    "triet@triet.lol",
                    "trietpass",
                    LocalDate.parse("1999-10-10"),
                    "Triet's Bio",
                    "https://avatar.com/triet_789.jpeg",
                    Timestamp.from(Instant.now())
            ));
            // create and add Minh into 'users' list
            users.add(new User(
                    "minh",
                    "Minh",
                    "Mai",
                    "minh@minh.loto",
                    "minhpass",
                    LocalDate.parse("1999-08-12"),
                    "Minh's Bio",
                    "https://avatar.com/minh_246.jpeg",
                    Timestamp.valueOf("2021-05-06 13:14:15.666")
            ));

            // ----------Add Posts----------
            // Create Nhan's posts
            List<Post> nhanPosts = new ArrayList<>();
            nhanPosts.add(new Post("photo.com/nhan_1.png", Timestamp.valueOf("2021-03-31 19:02:56.111"), "Bình Dương"));
            nhanPosts.add(new Post("photo.com/nhan_2.png", Timestamp.valueOf("2021-4-18 8:5:50.222"), "Lắk Lắk"));
            nhanPosts.add(new Post("photo.com/nhan_3.png", Timestamp.valueOf("2021-4-18 8:5:50.222"), "Lạt Đà"));
            nhanPosts.add(new Post("photo.com/nhan_4.png", Timestamp.from(Instant.now()), "Purple Hotel"));


            // Create Chau's posts
            List<Post> chauPosts = new ArrayList<>();
            chauPosts.add(new Post("photo.com/chau_1.png", Timestamp.valueOf("2021-03-31 19:02:56.111"), "Tây Ninh"));
            chauPosts.add(new Post("photo.com/chau_2.png", Timestamp.valueOf("2021-4-18 8:5:50.222"), "Bình Địa"));
            chauPosts.add(new Post("photo.com/chau_3.png", Timestamp.valueOf("2021-4-25 18:15:50.333"), "Đồng Nai"));
            chauPosts.add(new Post("photo.com/chau_4.png", Timestamp.valueOf("2021-5-03 9:18:55.444"), "Vũng Lầy"));
            chauPosts.add(new Post("photo.com/chau_5.png", Timestamp.from(Instant.now()), "Thành Hồ"));

            // associate all above useracc objects and post objects
            for (Post post : nhanPosts) {
                post.setPostedUser(users.get(0)); // associate posts of Nhan
            }
            for (Post post : chauPosts) {
                post.setPostedUser(users.get(1)); // associate posts of Chau
            }

            // ----------Save All Data----------
            // start transaction
            session.beginTransaction();

            // insert all users into DB
            for (User user : users) {
                session.save(user);
            }
            // insert Nhan's posts into DB
            for (Post post : nhanPosts) {
                session.save(post);
            }
            // insert Chau's posts into DB
            for (Post post : chauPosts) {
                session.save(post);
            }

            // commit transaction
            session.getTransaction().commit();
            System.out.println("---------Transaction Accomplished!--------");
        }
    }
}
