
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserDaoFactory.class)
class UserDaoTest {

    @Autowired
    ApplicationContext context;

    UserDao userDao;
    User user1;
    User user2;
    User user3;

    @BeforeEach
    void setUp(){
        this.userDao = context.getBean("aswsUserDao", UserDao.class);
        this.user1 = new User("1", "pear", "111");
        this.user2 = new User("2", "melon", "111");
        this.user3 = new User("3", "lemon", "111");
    }


    @Test
    void addAndSelect() throws SQLException, ClassNotFoundException {
        User user1 = new User("1","doo","1234");

        UserDao userDao = context.getBean("awsUserDao", UserDao.class);

        // delete column
        userDao.deleteAll();
        assertEquals(0,userDao.getCount());

        userDao.add(user1);
        assertEquals(1,userDao.getCount());
        User user = userDao.findById(user1.getId());

        Assertions.assertEquals(user1.getName(),user.getName());
        Assertions.assertEquals(user1.getPassword(),user.getPassword());

    }

    @Test
    void count() throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDaoFactory().awsUserDao();

        User user1 = new User("100","noodle","jk");
        User user2 = new User("200","tofu","mk");
        User user3 = new User("300","soup","uk");

        userDao.deleteAll();
        assertEquals(0,userDao.getCount());

        userDao.add(user1);
        assertEquals(1,userDao.getCount());

        userDao.add(user2);
        assertEquals(2,userDao.getCount());

        userDao.add(user3);
        assertEquals(3,userDao.getCount());

    }
}