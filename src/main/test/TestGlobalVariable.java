import com.ly.util.GlobalVariableManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;

/**
 * Created by cilu on 2017/10/24.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({@ContextConfiguration(name = "parent", locations = "classpath:spring-mybatis.xml"), @ContextConfiguration(name = "child", locations = "classpath:spring-mvc.xml")})
//@ContextConfiguration(locations = {"classpath:spring-mybatis.xml","classpath:spring-mvc.xml"})
public class TestGlobalVariable {


    @Test
    public void test() throws IOException {

        System.out.println(GlobalVariableManager.getInstance().getInfo());
    }
}
