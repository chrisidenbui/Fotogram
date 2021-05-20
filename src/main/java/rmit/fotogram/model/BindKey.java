package rmit.fotogram.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BindKey implements Serializable {
    
    @Column(name = "post_id")
    private Long postId;
    
    @Column(name = "tag_id")
    private Long tagId;
    

    // CONSTRUCTORS
    public BindKey() {
        // default constructor
    }

    public BindKey(Long postId, Long tagId) {
        this.postId = postId;
        this.tagId = tagId;
    }

    
    // GETTERS AND SETTERS 
    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BindKey)) return false;

        BindKey bindKey = (BindKey) o;

        if (getPostId() != null ? !getPostId().equals(bindKey.getPostId()) : bindKey.getPostId() != null) return false;
        return getTagId() != null ? getTagId().equals(bindKey.getTagId()) : bindKey.getTagId() == null;
    }

    @Override
    public int hashCode() {
        int result = getPostId() != null ? getPostId().hashCode() : 0;
        result = 31 * result + (getTagId() != null ? getTagId().hashCode() : 0);
        return result;
    }

    //    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((postId == null) ? 0 : postId.hashCode());
//        result = prime * result + ((tagId == null) ? 0 : tagId.hashCode());
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
//        BindKey other = (BindKey) obj;
//        if (postId == null) {
//            if (other.postId != null)
//                return false;
//        } else if (!postId.equals(other.postId))
//            return false;
//        if (tagId == null) {
//            if (other.tagId != null)
//                return false;
//        } else if (!tagId.equals(other.tagId))
//            return false;
//        return true;
//    }
}
