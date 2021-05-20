package rmit.fotogram.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "useracc")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    
    @Column(name = "user_name")
    private String userName;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "dob")
    private LocalDate dob;
    
    @Column(name = "bio")
    private String bio;
    
    @Column(name = "avatar_url")
    private String avatarUrl;
    
    @Column(name = "last_login_time")
    private Timestamp lastLoginTime;
    
    // UserAcc and Post
    @OneToMany(mappedBy = "postedUser", // 'postedUser' is the property of Post class.
            cascade = CascadeType.ALL)
    private List<Post> postList;
    
    // User and Likes
    @OneToMany(mappedBy = "liker")      // 'liker' is the property of Likes class.
    private Set<Likes> likes = new HashSet<>();
    
    
    
    // CONSTRUCTORS
    public User() {
        // default constructor
    }
    
    public User(String userName, String email, String password, LocalDate dob, String bio, String avatarUrl,
                Timestamp lastLonginTime) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.bio = bio;
        this.avatarUrl = avatarUrl;
        this.lastLoginTime = lastLonginTime;
    }


    // GETTERS AND SETTERS
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
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
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
        User other = (User) obj;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        return true;
    }

    // convenient methods
    public void addPost(Post newPost) {
        if (postList == null)  {
            postList = new ArrayList<Post>();
        }
        
        postList.add(newPost);
        
        // bi-directional
        newPost.setPostedUser(this);
    }

    @Override
    public String toString() {
        return "UserAcc [userId=" + userId + ", userName=" + userName + ", email=" + email + ", password=" + password
                + ", dob=" + dob + ", bio=" + bio + ", avatarUrl=" + avatarUrl + ", lastLoginTime=" + lastLoginTime
                + ", postList=" + postList + ", likes=" + likes + "]";
    }
}
