import com.ly.service.AdminService;
import com.ly.service.AdminService2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by cilu on 2017/11/6.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({@ContextConfiguration(name = "parent", locations = "classpath:spring-mybatis.xml"),@ContextConfiguration(name = "child",  locations = "classpath:spring-mvc.xml")})
//@ContextConfiguration(locations = {"classpath:spring-mybatis.xml","classpath:spring-mvc.xml"})
public class TestService {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminService2 adminService2;

    @Test
    public void test(){

        System.out.println(adminService.getClass());
        System.out.println(adminService.NAME);
        System.out.println(AdminService.NAME);
        System.out.println(adminService2.getClass());
        System.out.println(AdminService2.NAME);
    }
}
