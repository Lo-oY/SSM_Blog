package ly.ehcache;

import com.ly.annotation.Cacheable;

import java.io.Serializable;

/**
 * Created by cilu on 2018/1/23.
 */

public class People implements Cacheable {

    private int id;
    private String name;
    private String password;

    @Override
    public Serializable id() {
        return id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
