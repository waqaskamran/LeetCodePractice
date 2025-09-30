package DesignPattern;

public class Singleton {

    private Singleton(){
    }

    private static final class Holder{
       private static final Singleton instance =  new Singleton();
    }

    public Singleton getInstance(){
       return Holder.instance;
    }
}
