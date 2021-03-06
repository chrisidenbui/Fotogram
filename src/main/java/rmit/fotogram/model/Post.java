package rmit.fotogram.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;
        
    @Column(name = "url_full")
    private String urlFull;

    @Column(name = "url_raw")
    private String urlRaw;

    @Column(name = "url_regular")
    private String urlRegular;

    @Column(name = "url_small")
    private String urlSmall;

    @Column(name = "url_thumb")
    private String urlThumb;
    
    @Column(name = "creation_date")
    private Timestamp createdDate;

    @Column(name = "photo_location")
    private String photoLocation;
    
    // Post and UserAcc
    @ManyToOne(cascade = CascadeType.ALL, // delete the user, related post also was deleted.
            fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")   // 'user_id' is a column of table 'Post'.
    private User postedUser;

    // Post and Likes
    @OneToMany(mappedBy = "likeAtPost",
            fetch = FetchType.LAZY)       // 'likeAtPost' is the property of 'Likes' class.
    private Set<Likes> likes = new HashSet<>();

//    // Post and Tag
//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//    @JoinTable(name = "bind",
//            joinColumns = @JoinColumn(name = "post_id"),
//            inverseJoinColumns = @JoinColumn(name = "tag_id"))
//    private List<Tag> tags;

    // Post and Bind
    @OneToMany(mappedBy = "post")
    private Set<Bind> bind = new HashSet<>();
    
    // CONSTRUCTORS
    public Post() {
        // default constructor
    }

    public Post (String urlFull, String urlRaw, String urlRegular, String urlSmall, String urlThumb, Timestamp createdDate, String photoLocation) {
        this.urlFull = urlFull;
        this.urlRaw = urlRaw;
        this.urlRegular = urlRegular;
        this.urlSmall = urlSmall;
        this.urlThumb = urlThumb;
        this.createdDate = createdDate;
        this.photoLocation = photoLocation;
    }

    // GETTERS AND SETTERS
    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getUrlFull () {
        return urlFull;
    }

    public void setUrlFull (String urlFull) {
        this.urlFull = urlFull;
    }

    public String getUrlRaw () {
        return urlRaw;
    }

    public void setUrlRaw (String urlRaw) {
        this.urlRaw = urlRaw;
    }

    public String getUrlRegular () {
        return urlRegular;
    }

    public void setUrlRegular (String urlRegular) {
        this.urlRegular = urlRegular;
    }

    public String getUrlSmall () {
        return urlSmall;
    }

    public void setUrlSmall (String urlSmall) {
        this.urlSmall = urlSmall;
    }

    public String getUrlThumb () {
        return urlThumb;
    }

    public void setUrlThumb (String urlThumb) {
        this.urlThumb = urlThumb;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getPhotoLocation() {
        return photoLocation;
    }

    public void setPhotoLocation(String photoLocation) {
        this.photoLocation = photoLocation;
    }

    public User getPostedUser() {
        return postedUser;
    }

    public void setPostedUser(User postedUser) {
        this.postedUser = postedUser;
    }

    public Set<Likes> getLikes() {
        return likes;
    }

    public void setLikes(Set<Likes> likes) {
        this.likes = likes;
    }

    public Set<Bind> getBind() {
        return bind;
    }

    public void setBind(Set<Bind> bind) {
        this.bind = bind;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;

        Post post = (Post) o;

        return getPostId() != null ? getPostId().equals(post.getPostId()) : post.getPostId() == null;
    }

    @Override
    public int hashCode() {
        return getPostId() != null ? getPostId().hashCode() : 0;
    }

    @Override
    public String toString () {
        return "Post{" +
                "postId=" + postId +
                ", urlFull='" + urlFull + '\'' +
                ", urlRaw='" + urlRaw + '\'' +
                ", urlRegular='" + urlRegular + '\'' +
                ", urlSmall='" + urlSmall + '\'' +
                ", urlThumb='" + urlThumb + '\'' +
                ", createdDate=" + createdDate +
                ", photoLocation='" + photoLocation + '\'' +
                ", postedUser=" + postedUser +
                ", likes=" + likes +
                ", bind=" + bind +
                '}';
    }

    //    // convenient methods
//    public void addTag(Tag newTag) {
//        if (tags == null) {
//            tags = new ArrayList<>();
//        }
//
//        tags.add(newTag);
//    }

}
