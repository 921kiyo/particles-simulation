package simulation;

public interface Event extends Comparable<Event>{

    public double time(); // returns the time this event will occur

    public boolean isValid(); // returns true if this event can occur

    public void happen(ParticleEventHandler h); // makes event happen
        // When called, this must do two things:
        // 1) Update any objects that are part of the event (like particles)
        // 2) Signal that it has happened

}
