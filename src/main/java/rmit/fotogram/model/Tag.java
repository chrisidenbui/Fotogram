package rmit.fotogram.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long id;
    
    @Column(name = "tag_name")
    private String tagName;


    private Timestamp creationDate;

    // Tag and Bind
    @OneToMany(mappedBy = "tag")
    private Set<Bind> bind = new HashSet<>();

    // CONSTRUCTORS
    public Tag() {
        // default constructor
    }

    public Tag(String tagName, Timestamp creationDate) {
        this.tagName = tagName;
//        this.tagName = capitalize(tagName); // work OK.
        this.creationDate = creationDate;
    }

    // GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Set<Bind> getBind() {
        return bind;
    }

    public void setBind(Set<Bind> bind) {
        this.bind = bind;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", tagName='" + tagName + '\'' +
                ", bind=" + bind +
                '}';
    }

    //    // convenient methods
//    public void addPost(Post newPost) {
//        if (posts == null) {
//            posts = new ArrayList<>();
//        }
//        posts.add(newPost);
//    }
    
//    public void capitalize() {
//        this.tagName = this.tagName.substring(0,1).toUpperCase() // capitalize first letter.
//                + this.tagName.substring(1).toLowerCase();  // lowercase remaining letters.
//    }
    
    public String capitalize(String s) {
        return s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
    }

}
