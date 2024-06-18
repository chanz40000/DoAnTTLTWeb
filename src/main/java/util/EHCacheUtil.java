package util;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EHCacheUtil {
    private static CacheManager cacheManager = CacheManager.create();
    private static Cache cache = cacheManager.getCache("productsCache");

    public static void set(String key, Object value) {
        cache.put(new Element(key, value));
    }

    public static Object get(String key) {
        Element element = cache.get(key);
        return element != null ? element.getObjectValue() : null;
    }

    public static void delete(String key) {
        cache.remove(key);
    }
}
