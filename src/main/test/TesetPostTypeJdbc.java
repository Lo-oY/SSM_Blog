import com.ly.dao.PostTypeMapper;
import com.ly.pojo.PostType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by liangyong on 2017/10/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextHierarchy({@ContextConfiguration(name = "parent", locations = "classpath:spring-mybatis.xml"),@ContextConfiguration(name = "child",  locations = "classpath:spring-mvc.xml")})
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml","classpath:spring-mvc.xml"})
public class TesetPostTypeJdbc {

    @Autowired
    private PostTypeMapper postTypeMapper;

    @Test
    public void testInsert(){

        PostType postType = new PostType();
        postType.setId(11);
        postType.setName("java");
        postType.setOrder(1);
        postTypeMapper.insert(postType);
    }

    @Test
    public void testInsertSelective(){

        PostType postType = new PostType();
//        postType.setId(11);
        postType.setName("java");
        postType.setOrder(1);
        postTypeMapper.insertSelective(postType);
    }

    @Test
    public void testDelete(){

        int i = postTypeMapper.deleteByPrimaryKey(1);
        Assert.assertEquals(1,i);
    }

    @Test
    public void testUpdate(){
        PostType postType = postTypeMapper.selectByPrimaryKey(3);
        Assert.assertNotNull(postType);
        postType.setName("update posttype");
        int i = postTypeMapper.updateByPrimaryKey(postType);
        Assert.assertEquals(1,i);
    }
}
