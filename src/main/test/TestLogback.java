import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by cilu on 2017/10/30.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({@ContextConfiguration(name = "parent", locations = "classpath:spring-mybatis.xml"), @ContextConfiguration(name = "child", locations = "classpath:spring-mvc.xml")})
//@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
//, "classpath:spring-mvc.xml"})
//@WebAppConfiguration(value = "classpath:spring-mvc.xml")
//@WebAppConfiguration("src/main/resources")
public class TestLogback {

    private Log log = LogFactory.getLog(getClass());
//    private Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void testLog(){
        System.out.println("debug enable" + log.isDebugEnabled());
        System.out.println("info enable" + log.isInfoEnabled());
        System.out.println("error enable" + log.isErrorEnabled());
        System.out.println("trace enable" + log.isTraceEnabled());
        System.out.println("warn enable" + log.isWarnEnabled());
    }

}
