package hwb.study.jpa;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Session session = entityManager.unwrap(Session.class);
//        // Transient State Start
//        Account account = new Account();
//        account.setUsername("woobeom12");
//        account.setPassword("pass!");
//
//        Study study = new Study();
//        study.setName("Spring data JPA");
//
//        account.addStudy(study);
//        // Transient State End
//
//        Session session = entityManager.unwrap(Session.class);
//
//        // Persistent State
//        session.save(account);
//        session.save(study);
//
//        Account account1 = session.load(Account.class, account.getId());
//        account.setUsername("woobeom123");
//        account.setUsername("woobeom");
//        account.setUsername("woobeom12");
//
//        System.out.println("=========================================");
//        System.out.println(account1.getUsername());

//        Post post = new Post();
//        post.setTitle("Spring Data JPA 빨리 보자");
//
//        Comment comment1 = new Comment();
//        comment1.setComment("빨리리리리리리");
//        post.addComment(comment1);
//
//        Comment comment2 = new Comment();
//        comment2.setComment("보고 싶다.");
//        post.addComment(comment2);

//
//        session.save(post);


        Post post = session.get(Post.class, 1l);
        System.out.println("===================================");
        System.out.println(post.getTitle());

        post.getComments().forEach(c -> {
            System.out.println("--------------------------------------------");
            System.out.println(c.getComment());
            System.out.println("--------------------------------------------");
        });

    }
}
