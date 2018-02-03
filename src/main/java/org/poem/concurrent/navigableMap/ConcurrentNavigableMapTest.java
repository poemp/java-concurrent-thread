package org.poem.concurrent.navigableMap;

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentNavigableMapTest {

    public static void main(String[] args) {

        ConcurrentNavigableMap<String,String> map = new ConcurrentSkipListMap<String,String>();
        map.put("#","one");
        map.put("aa","one");
        map.put("ab","one");
        map.put("ac","one");
        map.put("bc","two");
        map.put("cd","three");
        //headMap(T toKey) 方法返回一个包含了小于给定 toKey 的 key 的子 map。
        ConcurrentNavigableMap headMap = map.headMap("#");
        System.err.println(headMap);

        ConcurrentNavigableMap m = map.subMap("a","b");
        System.err.println(m);
    }
}
