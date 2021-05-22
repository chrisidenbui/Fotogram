package rmit.fotogram.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "bind")
public class Bind {

    @EmbeddedId
    private BindKey id;
    
    @ManyToOne
    @MapsId("postId")   // 'postId' is the property of Post class
    @JoinColumn(name = "post_id")
    private Post post;
    
    @ManyToOne
    @MapsId("tagId")    // 'tagId' is the property of Tag class
    @JoinColumn(name = "tag_id")
    private Tag tag;
    
    
    // CONTRUCTORS
    public Bind() {
        // default constructor
    }

    public Bind(Post post, Tag tag) {
        this.post = post;
        this.tag = tag;
    }

    // GETTERS AND SETTERS
    public BindKey getId() {
        return id;
    }

    public void setId(BindKey id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bind)) return false;

        Bind bind = (Bind) o;

        return getId() != null ? getId().equals(bind.getId()) : bind.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

}
