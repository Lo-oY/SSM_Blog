import com.ly.dao.PostMapper;
import com.ly.dao.PostTypeMapper;
import com.ly.dao.UserMapper;
import com.ly.pojo.Post;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liangyong on 2017/10/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({@ContextConfiguration(name = "parent", locations = "classpath:spring-mybatis.xml"),@ContextConfiguration(name = "child",  locations = "classpath:spring-mvc.xml")})
//@ContextConfiguration(locations = {"classpath:spring-mybatis.xml","classpath:spring-mvc.xml"})
public class TestPostJdbc {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private PostTypeMapper postTypeMapper;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert(){
        Post post = new Post();
//        post.setId(4);
        post.setContent("Hello World");
        post.setKeywords("java spring");
        post.setPostTime(new Date(System.currentTimeMillis()));
        post.setTitle("First Post");
        post.setPostType(postTypeMapper.selectByPrimaryKey(6));
        post.setUser(userMapper.selectByPrimaryKey(1));
        int i = postMapper.insert(post);
        Assert.assertEquals(1,i);
    }

    @Test
    public void testSelect(){
        Post post = postMapper.selectByPrimaryKey(1);
        Assert.assertNotNull(post);
    }

    @Test
    public void testUpdate(){
        Post post = postMapper.selectByPrimaryKey(1);
        post.setTitle("TestAutowire Update");
        int i = postMapper.updateByPrimaryKey(post);
        Assert.assertEquals(1,i);
    }

    @Test
    public void testDelete(){
        Post post = postMapper.selectByPrimaryKey(2);
        int i = postMapper.deleteByPrimaryKey(post.getId());
        Assert.assertEquals(1,i);
    }

    @Test
    public void testListPost(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("typeId",6);
        map.put("start",0);
        map.put("end",10);
        System.out.println(postMapper.listPost(map));
    }
}
