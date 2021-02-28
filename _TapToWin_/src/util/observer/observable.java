package util.observer;

import java.util.Iterator;
import java.util.Vector;

public class observable {
    protected Vector<iObserver> subscribers = new Vector(2);

    public observable() {
    }

    public void addObserver(iObserver s) {
        this.subscribers.addElement(s);
    }

    public void removeObserver(iObserver s) {
        this.subscribers.removeElement(s);
    }

    public void removeAllObservers() {
        this.subscribers.removeAllElements();
    }

    public void notifyObservers() {
        Iterator iter = this.subscribers.iterator();

        while(iter.hasNext()) {
            iObserver observer = (iObserver)iter.next();
            observer.update();
        }

    }
}
