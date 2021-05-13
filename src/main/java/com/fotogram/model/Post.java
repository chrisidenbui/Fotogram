package com.fotogram.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;
        
    @Column(name = "photo_url")
    private String photoUrl;
    
    @Column(name = "creation_date")
    private Timestamp createDate; 
    
    
    @Column(name = "photo_location")
    private String photoLocation;
    
    // Post and UserAcc
    @ManyToOne(cascade = CascadeType.ALL)   // delete the user, related post also was deleted.
    @JoinColumn(name = "user_id")   // 'user_id' is a column of table 'Post'.
    private UserAcc postedUser;
    
    // Post and Likes
    @OneToMany(mappedBy = "likeAtPost")       // 'likeAtPost' is the property of 'Likes' class.
    private Set<Likes> likes = new HashSet<>();

    // Post and Tag
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "bind",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;
    
    
    // CONSTRUCTORS
    public Post() {
        // default constructor
    }
    
    public Post(String photoUrl, Timestamp createDate, String photoLocation) {
        this.photoUrl = photoUrl;
        this.createDate = createDate;
        this.photoLocation = photoLocation;
    }

    // getters and setters
    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public String getPhotoLocation() {
        return photoLocation;
    }

    public void setPhotoLocation(String photoLocation) {
        this.photoLocation = photoLocation;
    }

    
    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
    
    public UserAcc getPostedUser() {
        return postedUser;
    }

    public void setPostedUser(UserAcc postedUser) {
        this.postedUser = postedUser;
    }
    
    public Set<Likes> getLikes() {
        return likes;
    }

    public void setLikes(Set<Likes> likes) {
        this.likes = likes;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((postId == null) ? 0 : postId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Post other = (Post) obj;
        if (postId == null) {
            if (other.postId != null)
                return false;
        } else if (!postId.equals(other.postId))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "Post [postId=" + postId + ", photoUrl=" + photoUrl + ", createDate=" + createDate + ", photoLocation="
                + photoLocation + ", postedUser=" + postedUser + ", likes=" + likes + ", tags=" + tags
                + ", getPostId()=" + getPostId() + ", getPhotoUrl()=" + getPhotoUrl() + ", getCreateDate()="
                + getCreateDate() + ", getPhotoLocation()=" + getPhotoLocation() + ", getTags()=" + getTags()
                + ", getPostedUser()=" + getPostedUser() + ", getLikes()=" + getLikes() + ", getClass()=" + getClass()
                + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }
    
    // convenient methods
    public void addTag(Tag newTag) {
        if (tags == null) {
            tags = new ArrayList<>();
        }
        
        tags.add(newTag);
    }

}
