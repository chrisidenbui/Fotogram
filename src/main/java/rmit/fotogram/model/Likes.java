package rmit.fotogram.model;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = "likes")
public class Likes {

    @EmbeddedId
    private LikesKey id;
    
    // Likes and UserAcc        
    @ManyToOne(cascade = CascadeType.ALL)   // delete an user, associated like also was deleted.
    @MapsId("userId")       // 'userId' is the property of UserAcc class.
    @JoinColumn(name = "user_id")   // 'user_id' is a column of table 'Likes'.
    private User liker;  // Like này của User nào.
    
    // Likes and Post
    @ManyToOne(cascade = CascadeType.ALL, // delete a post, associated like also was deleted.
                fetch = FetchType.LAZY)
    @MapsId("postId")       // 'postId' is the property of Post class.
    @JoinColumn(name = "post_id")   // 'post_id' is a column of table 'Likes'.
    private Post likeAtPost;  // Like này thuộc Post nào.
    
    @Column(name = "creation_date")
    private Timestamp creationDate; 
    
    public Likes() {
        // default constructor
    }
    
    public Likes(User liker, Post likeAtPost, Timestamp creationDate) {
        this.liker = liker;
        this.likeAtPost = likeAtPost;
        this.creationDate = creationDate;
    }


    // GETTERS and SETTERS
    public LikesKey getId() {
        return id;
    }

    public void setId(LikesKey id) {
        this.id = id;
    }

    public User getLiker() {
        return liker;
    }

    public void setLiker(User liker) {
        this.liker = liker;
    }

    public Post getLikeAtPost() {
        return likeAtPost;
    }

    public void setLikeAtPost(Post likeAtPost) {
        this.likeAtPost = likeAtPost;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Likes)) return false;

        Likes likes = (Likes) o;

        return getId() != null ? getId().equals(likes.getId()) : likes.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }


    @Override
    public String toString() {
        return "Likes [liker=" + liker.getUserName() + 
                ", likeAtPost=" + likeAtPost.getPostId() + 
                ", creationDate=" + creationDate + "]";
    }

}
