package com.LazaruslieJmartKD;
import java.awt.*;
import java.util.Vector;
import java.util.function.Function;

/**
 * class ObjectPoolThread
 *
 * @author (Lazaruslie Karsono)
 */

public class ObjectPoolThread<T> extends Thread {
    private boolean exitSignal;
    private Vector<T>  objectPool = new Vector<>();
    private Function<T, Boolean> routine;

    public ObjectPoolThread(String name, Function<T, Boolean> routine) {
        super(name);
        this.routine = routine;
    }

    public ObjectPoolThread(Function<T, Boolean> routine) {
        super();
        this.routine = routine;
    }

    public synchronized void add(T object) {
        objectPool.add(object);
        super.notify();
    }

    public synchronized void exit() {
        exitSignal = true;
        super.notify();
    }

    public int size() {
        return objectPool.size();
    }

    @Override
    public void run() {
        while(!exitSignal){
            try
            {
                for(int i = 0; i < objectPool.size(); i++){
                    if(routine.apply(objectPool.get(i))){
                        objectPool.remove(objectPool.get(i));
                    }
                }
                synchronized (this){
                    this.wait();
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}
