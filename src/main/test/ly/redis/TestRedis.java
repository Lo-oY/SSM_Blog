package ly.redis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

/**
 * Created by cilu on 2018/1/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({@ContextConfiguration(name = "parent", locations = "classpath:spring-mybatis.xml"),@ContextConfiguration(name = "child",  locations = "classpath:spring-mvc.xml")})
public class TestRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String,Article> redisTemplate;

    @Test
    public void insertString(){
        stringRedisTemplate.opsForValue().set("liangyong","123456");
        stringRedisTemplate.opsForValue().set("liangyong:1","123456");
//        stringRedisTemplate.opsForList().ra
//        stringRedisTemplate.opsForValue().getOperations().delete("liangyong");
//        stringRedisTemplate.opsFor
    }

    @Test
    public void getString(){
        String value = stringRedisTemplate.opsForValue().get("liangyong:1");
        Assert.assertEquals("123456",value);
    }


    @Test
    public void insertHash(){
        redisTemplate.setKeySerializer(stringRedisTemplate.getKeySerializer());
        redisTemplate.setValueSerializer(stringRedisTemplate.getValueSerializer());
        post_article(redisTemplate,"liangyong","hello world","www.baidu.com");
        Article o = (Article) redisTemplate.opsForHash().get("article:", "12345");
        System.out.println(o);
    }

    private static void post_article(RedisTemplate<String,Article> redisTemplate,String user,String title,String link){

        Article article = new Article();
        article.setLink(link);
        article.setTime(new Timestamp(System.currentTimeMillis()));
        article.setTitle(title);
        article.setUser(user);
        String article_id = "12345";
        String voted = "voted:" + article_id;
        redisTemplate.expire(voted,7 , TimeUnit.DAYS);
        redisTemplate.opsForHash().put("article:",article_id, article);
    }

    static class Article implements Serializable{
        private String user;
        private String title;
        private String link;
        private Timestamp time;
        private String votes="1";

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public Timestamp getTime() {
            return time;
        }

        public void setTime(Timestamp time) {
            this.time = time;
        }

        public String getVotes() {
            return votes;
        }

        public void setVotes(String votes) {
            this.votes = votes;
        }

        @Override
        public String toString() {
            return "Article{" +
                    "user='" + user + '\'' +
                    ", title='" + title + '\'' +
                    ", link='" + link + '\'' +
                    ", time=" + time +
                    ", votes='" + votes + '\'' +
                    '}';
        }
    }

}
