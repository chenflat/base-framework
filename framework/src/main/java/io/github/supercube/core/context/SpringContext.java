package io.github.supercube.core.context;

import org.springframework.beans.BeansException;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


/**
 * Spring Context Util Class
 *
 * @author chenping
 */
@Component
public class SpringContext implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringContext.applicationContext == null) {
            SpringContext.applicationContext = applicationContext;
        }
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 通过name获取 Bean.
     */
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    /**
     * 通过class获取Bean.
     */
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }


    /**
     * 通过name,以及Clazz返回指定的Bean
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }

    /**
     * 获取系统使用的CacheManager
     */
    public static final CacheManager getApplicationCache() {
        return getBean(CacheManager.class);
    }


    /**
     * 刷新缓存
     *
     * @param cacheName 缓存名称
     * @param key       缓存键
     * @param value     缓存值
     */
    public static final void refreshCache(String cacheName, String key, Object value) {
        CacheManager cacheManager = getBean(CacheManager.class);
        Cache cache = cacheManager.getCache(cacheName);
        if (cache != null) {
            if (cache.get(key) == null) {
                cache.put(key, value);
            } else {
                cache.evict(key);
                cache.put(key, value);
            }
        }
    }
}
