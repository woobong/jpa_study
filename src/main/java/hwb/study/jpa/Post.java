package hwb.study.jpa;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    // Cascade 저장/삭제 지정, OneToMany 는 기본적으로 FETCH_MODE = LAZY
    @OneToMany(mappedBy = "post", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private Set<Comment> comments = new HashSet<>();

    // Convenient Method
    public void addComment(Comment comment) {
        this.getComments().add(comment);
        comment.setPost(this);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
