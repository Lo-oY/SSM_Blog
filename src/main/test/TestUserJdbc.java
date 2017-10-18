import com.ly.dao.UserMapper;
import com.ly.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.sql.Date;

/**
 * Created by liangyong on 2017/10/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({@ContextConfiguration(name = "parent", locations = "classpath:spring-mybatis.xml"),@ContextConfiguration(name = "child",  locations = "classpath:spring-mvc.xml")})
//@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
//, "classpath:spring-mvc.xml"})
//@WebAppConfiguration(value = "classpath:spring-mvc.xml")
//@WebAppConfiguration("src/main/resources")
public class TestUserJdbc {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void testInsert() {
        User user = new User();
        user.setName("liangyongTest");
        user.setId(7);
        user.setIp("192.168.2.123");
        user.setLastLogin(new Date(System.currentTimeMillis()));
        user.setNickname("梁勇");
        user.setPassword("123456");
        user.setRegisterTime(new Date(System.currentTimeMillis()));
        userMapper.insert(user);
    }

    @Test
    public void testDelete() {
        int i = userMapper.deleteByPrimaryKey(6);
        Assert.assertEquals(1, i);
    }

    @Test
    public void testUpdate() {
        User user = userMapper.selectByPrimaryKey(7);
        Assert.assertNotNull(user);
        user.setName("liangyongUpdate");
        int i = userMapper.updateByPrimaryKey(user);
        Assert.assertEquals(1, i);
    }


    @Test
    public void testSelect() {

        User user = userMapper.selectByPrimaryKey(7);
        Assert.assertNotNull(user);
    }
}
