import com.ly.pojo.TestAutowire;
import com.ly.util.SpringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by cilu on 2017/10/24.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({@ContextConfiguration(name = "parent", locations = "classpath:spring-mybatis.xml"), @ContextConfiguration(name = "child", locations = "classpath:spring-mvc.xml")})
//@ContextConfiguration(locations = {"classpath:spring-mybatis.xml","classpath:spring-mvc.xml"})
public class TestAutowireFactory {


    @Before
    public void before() {

        SpringUtils.register(new TestAutowire(), "");
    }

    //    @Autowired
    private TestAutowire testAutowire;

    @Test
    public void testAuto() {
        testAutowire = (TestAutowire) SpringUtils.getBeanOfType(TestAutowire.class);
        System.out.println(testAutowire);
    }
}
