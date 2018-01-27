package com.ly;

import com.ly.annotation.Cacheable;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.CacheStoreHelper;
import net.sf.ehcache.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cilu on 2018/1/23.
 */
public class EntityCache<T extends Cacheable> {

    private Cache cache;
    private CacheStoreHelper cacheStoreHelper;
    private Class<T> clazz;

    public EntityCache(Class<T> clazz) {
        if (clazz != null) {
            this.clazz = clazz;
            CacheManager cm = CacheManager.getInstance();
            this.cache = cm.getCache(clazz.getName());
            if (this.cache == null) {
                cm.addCache(clazz.getName());
                this.cache = cm.getCache(clazz.getName());
            }

            this.cacheStoreHelper = new CacheStoreHelper(this.cache);
        }
    }

    public Class<T> getClzz() {
        return this.clazz;
    }

    public T get(Object id) {
        if (id == null) {
            return null;
        } else {
            Element element = this.cache.get(id);
            return element != null ? (T) element.getObjectValue() : null;
        }
    }

    public void set(Cacheable t) {
        Element element = new Element(t.id(), t);
        this.cache.put(element);
    }

    public void remove(Object id) {
        this.cache.remove(id);
    }

    public void reset() {
        this.cache.removeAll();
    }

    public List<T> all() {
        List keys = this.cache.getKeys();
        List<T> result = new ArrayList<T>();
        for (Object key : keys) {
            Element element = this.cache.get(key);
            if (element != null) {
                result.add((T) element.getObjectValue());
            }
        }
        return result;
    }
}
