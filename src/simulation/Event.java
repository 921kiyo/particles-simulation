package simulation;

public interface Event extends Comparable<Event> {

    // Defined in AbstractEvent
    public double time();

    // Defined in Collision and Tick
    public boolean isValid();

    // Defined in Tick, TwoParticleCollision, and ParticleWallCollision
    public void happen(ParticleEventHandler h);

}
