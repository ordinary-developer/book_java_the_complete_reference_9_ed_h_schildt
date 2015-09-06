import java.util.*;


class Watcher implements Observer {
    public void update(Observable obj, Object arg) {
        System.out.println("update() called, count is " +
                ((Integer)arg).intValue());
    }
}

class BeingWatched extends Observable {
    void counter(int period) {
        for ( ; period >= 0; period--) {
            setChanged();
            notifyObservers(new Integer(period));

            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                System.out.println("Sleep interrupted");
            }
        }

    }
}
class ObserverDemo {
    public static void main(String args[]) {
        BeingWatched observed = new BeingWatched();
        Watcher observing = new Watcher();

        observed.addObserver(observing);

        observed.counter(10);
    }
}
