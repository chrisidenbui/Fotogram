package rmit.fotogram.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LikesKey implements Serializable {

    @Column(name = "user_id")
    private Long userId;
    
    @Column(name = "post_id")
    private Long postId;
    
    
    // CONSTRUCTORS
    public LikesKey() {
        // default constructor
    }
        
    public LikesKey(Long userId, Long postId) {
        this.userId = userId;
        this.postId = postId;
    }



    // GETTERS and SETTERS
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LikesKey)) return false;

        LikesKey likesKey = (LikesKey) o;

        if (getUserId() != null ? !getUserId().equals(likesKey.getUserId()) : likesKey.getUserId() != null)
            return false;
        return getPostId() != null ? getPostId().equals(likesKey.getPostId()) : likesKey.getPostId() == null;
    }

    @Override
    public int hashCode() {
        int result = getUserId() != null ? getUserId().hashCode() : 0;
        result = 31 * result + (getPostId() != null ? getPostId().hashCode() : 0);
        return result;
    }

    //    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((postId == null) ? 0 : postId.hashCode());
//        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
//        return result;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        if (obj == null)
//            return false;
//        if (getClass() != obj.getClass())
//            return false;
//        LikesKey other = (LikesKey) obj;
//        if (postId == null) {
//            if (other.postId != null)
//                return false;
//        } else if (!postId.equals(other.postId))
//            return false;
//        if (userId == null) {
//            if (other.userId != null)
//                return false;
//        } else if (!userId.equals(other.userId))
//            return false;
//        return true;
//    }
    
}
