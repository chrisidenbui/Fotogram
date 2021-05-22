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
}
