package rmit.fotogram.demo;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import rmit.fotogram.model.*;

public class CreateUserAndPostsDemo {

    public static Timestamp generateTimeStamp() {
        long offset = Timestamp.valueOf("2021-01-01 00:00:00").getTime();
        long end = Timestamp.from(Instant.now()).getTime();
        long diff = end - offset + 1;
        return new Timestamp(offset + (long) (Math.random() * diff));
    }

    public static String randomLocation() {
        List<String> locations = new ArrayList<>(Arrays.asList("Thành Hồ", "Bình Địa", "Vũng Lầy", "Đồng Hươu",
                "Tây Ninh", "Bình Phước", "Lắk Lắk", "Lắk Lông", "Lâm Đồng", "Gia Lai", "Long An",
                "Tiền Giang", "Bến Tre", "Đồng Tháp", "Sóc Trăng"));
        Random rand = new Random();
        return locations.get(rand.nextInt(locations.size()));
    }

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
            users.add(new User("nhan", "Nhàn", "Nguyễn", "nhan@nhan.com", "nhanpass",
                    LocalDate.parse("1999-08-08"), "Nhan's Bio", "https://avatar.com/nhan_123.jpeg",
                    Timestamp.from(Instant.now())));
            // create and add Chau into 'users' list
            users.add(new User("chau", "Châu", "Nguyễn", "chau@chau.net", "chaupass",
                    LocalDate.parse("2000-03-03"), "Chau's Bio", "https://avatar.com/chau_456.jpeg",
                    Timestamp.valueOf("2021-05-05 07:08:09.111")));

            // create and add Triet into 'users' list
            users.add(new User("triet", "Chrisiden", "Bùi", "triet@triet.lol", "trietpass",
                    LocalDate.parse("1999-10-10"), "Triet's Bio",
                    "https://avatar.com/triet_789.jpeg", Timestamp.from(Instant.now())));
            // create and add Minh into 'users' list
            users.add(new User("minh", "Minh", "Mai", "minh@minh.loto", "minhpass",
                    LocalDate.parse("1999-08-12"), "Minh's Bio", "https://avatar.com/minh_246.jpeg",
                    Timestamp.valueOf("2021-05-06 13:14:15.666")));

            // ----------Add Animal Posts----------
            // Create Nhan's posts
            List<Post> nhanPosts = new ArrayList<>();
            nhanPosts.add(new Post("https://images.unsplash.com/photo-1463501810073-6e31c827a9bc?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwzMHx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1463501810073-6e31c827a9bc?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwzMHx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1463501810073-6e31c827a9bc?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwzMHx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1463501810073-6e31c827a9bc?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwzMHx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1463501810073-6e31c827a9bc?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwzMHx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            nhanPosts.add(new Post("https://images.unsplash.com/photo-1484557985045-edf25e08da73?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOXx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1484557985045-edf25e08da73?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOXx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1484557985045-edf25e08da73?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOXx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1484557985045-edf25e08da73?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOXx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1484557985045-edf25e08da73?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOXx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            nhanPosts.add(new Post("https://images.unsplash.com/photo-1518593929011-2b5ef6be57c7?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOHx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1518593929011-2b5ef6be57c7?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOHx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1518593929011-2b5ef6be57c7?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOHx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1518593929011-2b5ef6be57c7?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOHx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1518593929011-2b5ef6be57c7?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOHx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            nhanPosts.add(new Post("https://images.unsplash.com/photo-1452857297128-d9c29adba80b?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyN3x8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1452857297128-d9c29adba80b?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyN3x8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1452857297128-d9c29adba80b?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyN3x8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1452857297128-d9c29adba80b?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyN3x8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1452857297128-d9c29adba80b?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyN3x8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            nhanPosts.add(new Post("https://images.unsplash.com/photo-1459262838948-3e2de6c1ec80?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNnx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1459262838948-3e2de6c1ec80?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNnx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1459262838948-3e2de6c1ec80?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNnx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1459262838948-3e2de6c1ec80?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNnx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1459262838948-3e2de6c1ec80?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNnx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            nhanPosts.add(new Post("https://images.unsplash.com/photo-1490718720478-364a07a997cd?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNXx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1490718720478-364a07a997cd?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNXx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1490718720478-364a07a997cd?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNXx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1490718720478-364a07a997cd?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNXx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1490718720478-364a07a997cd?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNXx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            nhanPosts.add(new Post("https://images.unsplash.com/photo-1516728778615-2d590ea1855e?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNHx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1516728778615-2d590ea1855e?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNHx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1516728778615-2d590ea1855e?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNHx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1516728778615-2d590ea1855e?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNHx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1516728778615-2d590ea1855e?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNHx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            nhanPosts.add(new Post("https://images.unsplash.com/photo-1545006398-2cf47cd87b90?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyM3x8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1545006398-2cf47cd87b90?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyM3x8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1545006398-2cf47cd87b90?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyM3x8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1545006398-2cf47cd87b90?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyM3x8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1545006398-2cf47cd87b90?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyM3x8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            nhanPosts.add(new Post("https://images.unsplash.com/photo-1472491235688-bdc81a63246e?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMnx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1472491235688-bdc81a63246e?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMnx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1472491235688-bdc81a63246e?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMnx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1472491235688-bdc81a63246e?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMnx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1472491235688-bdc81a63246e?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMnx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            nhanPosts.add(new Post("https://images.unsplash.com/photo-1463852247062-1bbca38f7805?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMXx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1463852247062-1bbca38f7805?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMXx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1463852247062-1bbca38f7805?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMXx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1463852247062-1bbca38f7805?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMXx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1463852247062-1bbca38f7805?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMXx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            nhanPosts.add(new Post("https://images.unsplash.com/photo-1497752531616-c3afd9760a11?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMHx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1497752531616-c3afd9760a11?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMHx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1497752531616-c3afd9760a11?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMHx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1497752531616-c3afd9760a11?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMHx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1497752531616-c3afd9760a11?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMHx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            nhanPosts.add(new Post("https://images.unsplash.com/photo-1550699566-83f93df24072?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwxOXx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1550699566-83f93df24072?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwxOXx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1550699566-83f93df24072?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwxOXx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1550699566-83f93df24072?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwxOXx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1550699566-83f93df24072?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwxOXx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            nhanPosts.add(new Post("https://images.unsplash.com/photo-1534759846116-5799c33ce22a?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwxOHx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1534759846116-5799c33ce22a?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwxOHx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1534759846116-5799c33ce22a?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwxOHx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1534759846116-5799c33ce22a?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwxOHx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1534759846116-5799c33ce22a?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwxOHx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            nhanPosts.add(new Post("https://images.unsplash.com/reserve/RFDKkrvXSHqBaWMMl4W5_Heavy%20company%20by%20Alessandro%20Desantis%20-%20Downloaded%20from%20500px_jpg.jpg?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwxN3x8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/reserve/RFDKkrvXSHqBaWMMl4W5_Heavy%20company%20by%20Alessandro%20Desantis%20-%20Downloaded%20from%20500px_jpg.jpg?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwxN3x8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/reserve/RFDKkrvXSHqBaWMMl4W5_Heavy%20company%20by%20Alessandro%20Desantis%20-%20Downloaded%20from%20500px_jpg.jpg?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwxN3x8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/reserve/RFDKkrvXSHqBaWMMl4W5_Heavy%20company%20by%20Alessandro%20Desantis%20-%20Downloaded%20from%20500px_jpg.jpg?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwxN3x8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/reserve/RFDKkrvXSHqBaWMMl4W5_Heavy%20company%20by%20Alessandro%20Desantis%20-%20Downloaded%20from%20500px_jpg.jpg?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwxN3x8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            nhanPosts.add(new Post("https://images.unsplash.com/photo-1560343787-b90cb337028e?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwxNnx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1560343787-b90cb337028e?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwxNnx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1560343787-b90cb337028e?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwxNnx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1560343787-b90cb337028e?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwxNnx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1560343787-b90cb337028e?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwxNnx8YW5pbWFsfGVufDB8fHx8MTYyMTg2NDE5OQ&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));



            // ----------Add Natures Posts----------
            // Create Chau's posts

            List<Post> chauPosts = new ArrayList<>();
            chauPosts.add(new Post("https://images.unsplash.com/photo-1504567961542-e24d9439a724?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwzMHx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1504567961542-e24d9439a724?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwzMHx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1504567961542-e24d9439a724?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwzMHx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1504567961542-e24d9439a724?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwzMHx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1504567961542-e24d9439a724?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwzMHx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            chauPosts.add(new Post("https://images.unsplash.com/photo-1501854140801-50d01698950b?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOXx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1501854140801-50d01698950b?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOXx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1501854140801-50d01698950b?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOXx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1501854140801-50d01698950b?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOXx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1501854140801-50d01698950b?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOXx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            chauPosts.add(new Post("https://images.unsplash.com/photo-1473773508845-188df298d2d1?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOHx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1473773508845-188df298d2d1?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOHx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1473773508845-188df298d2d1?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOHx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1473773508845-188df298d2d1?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOHx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1473773508845-188df298d2d1?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOHx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            chauPosts.add(new Post("https://images.unsplash.com/photo-1444464666168-49d633b86797?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyN3x8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1444464666168-49d633b86797?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyN3x8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1444464666168-49d633b86797?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyN3x8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1444464666168-49d633b86797?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyN3x8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1444464666168-49d633b86797?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyN3x8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            chauPosts.add(new Post("https://images.unsplash.com/photo-1504198266287-1659872e6590?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNnx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1504198266287-1659872e6590?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNnx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1504198266287-1659872e6590?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNnx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1504198266287-1659872e6590?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNnx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1504198266287-1659872e6590?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNnx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            chauPosts.add(new Post("",
                    "",
                    "",
                    "",
                    "",
                    generateTimeStamp(), randomLocation()));

            chauPosts.add(new Post("https://images.unsplash.com/photo-1546514355-7fdc90ccbd03?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNXx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1546514355-7fdc90ccbd03?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNXx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1546514355-7fdc90ccbd03?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNXx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1546514355-7fdc90ccbd03?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNXx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1546514355-7fdc90ccbd03?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNXx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            chauPosts.add(new Post("https://images.unsplash.com/photo-1469474968028-56623f02e42e?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNHx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1469474968028-56623f02e42e?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNHx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1469474968028-56623f02e42e?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNHx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1469474968028-56623f02e42e?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNHx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1469474968028-56623f02e42e?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNHx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            chauPosts.add(new Post("https://images.unsplash.com/photo-1446329813274-7c9036bd9a1f?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyM3x8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1446329813274-7c9036bd9a1f?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyM3x8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1446329813274-7c9036bd9a1f?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyM3x8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1446329813274-7c9036bd9a1f?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyM3x8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1446329813274-7c9036bd9a1f?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyM3x8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            chauPosts.add(new Post("https://images.unsplash.com/photo-1587502536575-6dfba0a6e017?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MXwxfHNlYXJjaHwyMnx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1587502536575-6dfba0a6e017?ixid=MnwxNTU2Mjl8MXwxfHNlYXJjaHwyMnx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1587502536575-6dfba0a6e017?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MXwxfHNlYXJjaHwyMnx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1587502536575-6dfba0a6e017?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MXwxfHNlYXJjaHwyMnx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1587502536575-6dfba0a6e017?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MXwxfHNlYXJjaHwyMnx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            chauPosts.add(new Post("https://images.unsplash.com/photo-1552083375-1447ce886485?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMXx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1552083375-1447ce886485?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMXx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1552083375-1447ce886485?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMXx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1552083375-1447ce886485?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMXx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1552083375-1447ce886485?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMXx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            chauPosts.add(new Post("https://images.unsplash.com/photo-1439853949127-fa647821eba0?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMHx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1439853949127-fa647821eba0?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMHx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1439853949127-fa647821eba0?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMHx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1439853949127-fa647821eba0?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMHx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1439853949127-fa647821eba0?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMHx8bmF0dXJlfGVufDB8fHx8MTYyMTkzNDAxMg&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));



            // ----------Add Sky Posts----------
            // Create Triet's posts:
            List<Post> trietPosts = new ArrayList<>();
            trietPosts.add(new Post("https://images.unsplash.com/photo-1520985244272-9d0b8067a4ff?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwzMHx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1520985244272-9d0b8067a4ff?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwzMHx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1520985244272-9d0b8067a4ff?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwzMHx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1520985244272-9d0b8067a4ff?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwzMHx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1520985244272-9d0b8067a4ff?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwzMHx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            trietPosts.add(new Post("https://images.unsplash.com/photo-1435224654926-ecc9f7fa028c?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOXx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1435224654926-ecc9f7fa028c?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOXx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1435224654926-ecc9f7fa028c?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOXx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1435224654926-ecc9f7fa028c?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOXx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1435224654926-ecc9f7fa028c?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOXx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            trietPosts.add(new Post("https://images.unsplash.com/photo-1497465135434-9dc15238075a?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOHx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1497465135434-9dc15238075a?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOHx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1497465135434-9dc15238075a?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOHx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1497465135434-9dc15238075a?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOHx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1497465135434-9dc15238075a?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOHx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            trietPosts.add(new Post("https://images.unsplash.com/photo-1472068113808-609faf3a6cf1?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyN3x8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1472068113808-609faf3a6cf1?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyN3x8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1472068113808-609faf3a6cf1?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyN3x8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1472068113808-609faf3a6cf1?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyN3x8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1472068113808-609faf3a6cf1?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyN3x8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            trietPosts.add(new Post("https://images.unsplash.com/reserve/e66NHyUFQx6lNahLbW6g_IMG_2536_2.jpg?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNnx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/reserve/e66NHyUFQx6lNahLbW6g_IMG_2536_2.jpg?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNnx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/reserve/e66NHyUFQx6lNahLbW6g_IMG_2536_2.jpg?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNnx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/reserve/e66NHyUFQx6lNahLbW6g_IMG_2536_2.jpg?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNnx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/reserve/e66NHyUFQx6lNahLbW6g_IMG_2536_2.jpg?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNnx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            trietPosts.add(new Post("https://images.unsplash.com/photo-1429734956993-8a9b0555e122?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNXx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1429734956993-8a9b0555e122?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNXx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1429734956993-8a9b0555e122?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNXx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1429734956993-8a9b0555e122?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNXx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1429734956993-8a9b0555e122?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNXx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            trietPosts.add(new Post("https://images.unsplash.com/photo-1532983330958-4b32bbe9bb0e?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNHx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1532983330958-4b32bbe9bb0e?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNHx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1532983330958-4b32bbe9bb0e?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNHx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1532983330958-4b32bbe9bb0e?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNHx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1532983330958-4b32bbe9bb0e?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNHx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            trietPosts.add(new Post("https://images.unsplash.com/photo-1472552944129-b035e9ea3744?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyM3x8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1472552944129-b035e9ea3744?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyM3x8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1472552944129-b035e9ea3744?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyM3x8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1472552944129-b035e9ea3744?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyM3x8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1472552944129-b035e9ea3744?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyM3x8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            trietPosts.add(new Post("https://images.unsplash.com/photo-1437435409766-a478cc6da81a?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMnx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1437435409766-a478cc6da81a?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMnx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1437435409766-a478cc6da81a?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMnx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1437435409766-a478cc6da81a?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMnx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1437435409766-a478cc6da81a?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMnx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            trietPosts.add(new Post("https://images.unsplash.com/photo-1568112122445-27b3815d2ed8?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMXx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1568112122445-27b3815d2ed8?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMXx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1568112122445-27b3815d2ed8?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMXx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1568112122445-27b3815d2ed8?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMXx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1568112122445-27b3815d2ed8?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyMXx8c2t5fGVufDB8fHx8MTYyMTkzNDM2NA&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            // ----------Add Family Posts----------
            // Create Minh's posts:
            List<Post> minhPosts = new ArrayList<>();
            minhPosts.add(new Post("https://images.unsplash.com/photo-1542037012038-5f9fb2b3c681?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwzMHx8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1542037012038-5f9fb2b3c681?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwzMHx8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1542037012038-5f9fb2b3c681?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwzMHx8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1542037012038-5f9fb2b3c681?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwzMHx8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1542037012038-5f9fb2b3c681?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwzMHx8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            minhPosts.add(new Post("https://images.unsplash.com/photo-1543342384-1f1350e27861?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOXx8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1543342384-1f1350e27861?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOXx8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1543342384-1f1350e27861?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOXx8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1543342384-1f1350e27861?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOXx8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1543342384-1f1350e27861?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOXx8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            minhPosts.add(new Post("https://images.unsplash.com/photo-1611024847487-e26177381a3f?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOHx8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1611024847487-e26177381a3f?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOHx8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1611024847487-e26177381a3f?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOHx8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1611024847487-e26177381a3f?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOHx8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1611024847487-e26177381a3f?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyOHx8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            minhPosts.add(new Post("https://images.unsplash.com/photo-1503431153573-96e959f4d9b7?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyN3x8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1503431153573-96e959f4d9b7?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyN3x8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1503431153573-96e959f4d9b7?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyN3x8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1503431153573-96e959f4d9b7?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyN3x8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1503431153573-96e959f4d9b7?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyN3x8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            minhPosts.add(new Post("https://images.unsplash.com/photo-1484665754804-74b091211472?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNnx8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1484665754804-74b091211472?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNnx8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1484665754804-74b091211472?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNnx8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1484665754804-74b091211472?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNnx8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1484665754804-74b091211472?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNnx8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            minhPosts.add(new Post("https://images.unsplash.com/photo-1606788075819-9574a6edfab3?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNXx8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1606788075819-9574a6edfab3?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNXx8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1606788075819-9574a6edfab3?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNXx8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1606788075819-9574a6edfab3?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNXx8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1606788075819-9574a6edfab3?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNXx8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            minhPosts.add(new Post("https://images.unsplash.com/photo-1496275068113-fff8c90750d1?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNHx8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1496275068113-fff8c90750d1?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNHx8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1496275068113-fff8c90750d1?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNHx8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1496275068113-fff8c90750d1?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNHx8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1496275068113-fff8c90750d1?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyNHx8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));

            minhPosts.add(new Post("https://images.unsplash.com/photo-1557446772-0985ac892643?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyM3x8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1&q=85",
                    "https://images.unsplash.com/photo-1557446772-0985ac892643?ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyM3x8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1",
                    "https://images.unsplash.com/photo-1557446772-0985ac892643?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyM3x8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1&q=80&w=1080",
                    "https://images.unsplash.com/photo-1557446772-0985ac892643?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyM3x8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1&q=80&w=400",
                    "https://images.unsplash.com/photo-1557446772-0985ac892643?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTU2Mjl8MHwxfHNlYXJjaHwyM3x8ZmFtaWx5fGVufDB8fHx8MTYyMTkzNDgzMw&ixlib=rb-1.2.1&q=80&w=200",
                    generateTimeStamp(), randomLocation()));


            // associate all above useracc objects and post objects
            for (Post post : nhanPosts) {
                post.setPostedUser(users.get(0)); // associate posts of Nhan
            }
            for (Post post : chauPosts) {
                post.setPostedUser(users.get(1)); // associate posts of Chau
            }
            for (Post post : trietPosts) {
                post.setPostedUser(users.get(2)); // associate posts of Triet
            }
            for (Post post : minhPosts) {
                post.setPostedUser(users.get(3)); // associate posts of Minh
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
            // insert Triet's posts into DB
            for (Post post : trietPosts) {
                session.save(post);
            }
            // insert Minh's posts into DB
            for (Post post : minhPosts) {
                session.save(post);
            }

            // commit transaction
            session.getTransaction().commit();
            System.out.println("---------Transaction Accomplished!--------");

        }
    }
}
