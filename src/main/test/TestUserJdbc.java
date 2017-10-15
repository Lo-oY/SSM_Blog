import com.ly.dao.UserMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by liangyong on 2017/10/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextHierarchy({@ContextConfiguration(name = "parent", locations = "classpath:spring-mybatis.xml"),@ContextConfiguration(name = "child",  locations = "classpath:spring-mvc.xml")})
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml","classpath:spring-mvc.xml"})
public class TestUserJdbc {

    @Autowired
    private UserMapper userMapper;
}
