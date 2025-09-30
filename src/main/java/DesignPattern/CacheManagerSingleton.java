package DesignPattern;

import java.util.HashMap;

public class CacheManagerSingleton {

    private HashMap<String,Integer> map ;
    private CacheManagerSingleton(){
        map = new HashMap<>();
    }

    private static class Holder{
        private static  CacheManagerSingleton  INSTANCE = new CacheManagerSingleton();
    }

    public static CacheManagerSingleton getInstance(){
        return Holder.INSTANCE;
    }

    public void put(String key, Integer value){
        map.put(key,value);
    }
    public Integer getByKey(String key){
        return map.get(key);
    }


}

class Invoker{
    public static void main(String[] args) {
        CacheManagerSingleton.getInstance().put("Test",123);
        System.out.println("Invoker..."+ CacheManagerSingleton.getInstance().getByKey("Test"));

    }
}
