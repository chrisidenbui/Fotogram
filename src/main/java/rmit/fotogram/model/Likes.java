package rmit.fotogram.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

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
    @ManyToOne(cascade = CascadeType.ALL)   // delete a post, associated like also was deleted.
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

    //    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((id == null) ? 0 : id.hashCode());
//        return result;
//    }
//
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        if (obj == null)
//            return false;
//        if (getClass() != obj.getClass())
//            return false;
//        Likes other = (Likes) obj;
//        if (id == null) {
//            if (other.id != null)
//                return false;
//        } else if (!id.equals(other.id))
//            return false;
//        return true;
//    }



    // CONVENIENT METHODS
    @Override
    public String toString() {
        return "Likes [liker=" + liker.getUserName() + 
                ", likeAtPost=" + likeAtPost.getPostId() + 
                ", creationDate=" + creationDate + "]";
    }

  
}
