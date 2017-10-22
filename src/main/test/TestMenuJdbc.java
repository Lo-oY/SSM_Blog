import com.ly.dao.MenuMapper;
import com.ly.pojo.Menu;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Created by liangyong on 2017/10/19.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({@ContextConfiguration(name = "parent", locations = "classpath:spring-mybatis.xml"), @ContextConfiguration(name = "child", locations = "classpath:spring-mvc.xml")})
//@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
//, "classpath:spring-mvc.xml"})
//@WebAppConfiguration(value = "classpath:spring-mvc.xml")
//@WebAppConfiguration("src/main/resources")
public class TestMenuJdbc {

    @Autowired
    private MenuMapper menuMapper;


    @Test
    public void testInsert() {

        Menu menu = new Menu();
        menu.setTitle("Title1");
        menu.setDescription("test Title");
        menu.setOrderid(1);
        int i = menuMapper.insertSelective(menu);
        Assert.assertEquals(1, i);
    }

    @Test
    public void testListAll() {

        List<Menu> menuList = menuMapper.getAllMenu();
        System.out.println(menuList);
    }
}
