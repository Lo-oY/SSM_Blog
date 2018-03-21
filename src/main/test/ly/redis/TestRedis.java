package ly.redis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
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
//        redisTemplate.opsForHash().increment("article:","12345",1);
//        Article o2 = (Article) redisTemplate.opsForHash().get("article:", "12345");
//        System.out.println(o2);

    }

    @Test
    public void insertZSet(){
        String articleId_1 = "article:12345";
        String articleId_2 = "article:12347";
        stringRedisTemplate.opsForZSet().add("score:",articleId_1,1);
        stringRedisTemplate.opsForZSet().incrementScore("score:",articleId_1,1);
        double score = stringRedisTemplate.opsForZSet().score("score:", articleId_1);
        Assert.assertEquals(score,2.0,0);

        stringRedisTemplate.opsForZSet().add("score:",articleId_2,9);
    }

    @Test
    public void insertSet(){
        String articleId_1 = "article:12345";
        String articleId_2 = "article:12346";
        String articleId_3 = "article:12347";
        String articleId_4 = "article:12348";
        String articleId_5 = "article:12349";
        String groupId  = "groups:programming";
        stringRedisTemplate.opsForSet().add(groupId,articleId_1,articleId_2,articleId_3,articleId_4,articleId_5);
    }

    /**
     * ZSet交集，score取和，set score默认为1
     * 60s失效
     */
    @Test
    public void testIntersectStore(){
//        List<String> stringList = new ArrayList<>();
//        stringList.add("groups:programming");
//        stringList.add("score:");
        if(!stringRedisTemplate.hasKey("score:programming")){
            stringRedisTemplate.opsForZSet().intersectAndStore("groups:programming", "score:", "score:programming");
            stringRedisTemplate.expire("score:programming",60,TimeUnit.SECONDS);
        }
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
        RedisSerializer<String> stringSerializer = redisTemplate.getStringSerializer();
        redisTemplate.opsForHash().put("article:",article_id, article);
//        redisTemplate.execute(new RedisCallback<Object>() {
//
//            @Override
//            public Object doInRedis(RedisConnection connection) throws DataAccessException {
//                stringSerializer.serialize()
//                return null;
//            }
//        });
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
