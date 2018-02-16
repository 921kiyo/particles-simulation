package simulation;

public abstract class AbstractEvent implements Event {

    private final double t;

    /**
     * Constructor for AbstractEvent.
     */
    public AbstractEvent(double time) {
        t = time;

    }

    /**
     * Returns the time (in ticks) at which this event will occur.
     */
    @Override
    public double time() {
        return t;
    }

    /**
     * Compares this object with the specified Event.
     */
    @Override
    public int compareTo(Event that) {
        if (t < that.time())       { return -1; }
        else if (t == that.time()) { return 0;  }
        else                       { return 1;  }
    }

}
