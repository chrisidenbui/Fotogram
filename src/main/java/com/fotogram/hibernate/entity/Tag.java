package com.fotogram.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.Table;

@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long id;
    
    @Column(name = "tag_name")
    private String tagName;
    
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "bind",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "post_id")
            )
    private List<Post> posts;
    
    
    // constructors
    public Tag() {
        // default constructor
    }
    
    public Tag(String tagName) {
//        this.tagName = tagName;
        this.tagName = capitalize(tagName);
    }

    // getters and setters
    
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
//        this.tagName = tagName;
        this.tagName = capitalize(tagName);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    
    
    // convenient methods
    public void addPost(Post newPost) {
        if (posts == null) {
            posts = new ArrayList<>();
        }
        posts.add(newPost);
    }
    
//    public void capitalize() {
//        this.tagName = this.tagName.substring(0,1).toUpperCase() // capitalize first letter.
//                + this.tagName.substring(1).toLowerCase();  // lowercase remaining letters.
//    }
    
    public String capitalize(String s) {
        return s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
    }
    
    @Override
    public String toString() {
        return "Tag [id=" + id + ", tagName=" + tagName + ", posts=" + posts + "]";
    }
    
    
}
