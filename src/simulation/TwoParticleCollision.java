package simulation;

public class TwoParticleCollision extends Collision {

    private Particle p1;
    private Particle p2;
    private double t;

    // TODO: happen() might need further work

    /**
     * Passes self to ParticleEventHandler, which knows
     * how to handle collisions individually
     */
    @Override
    public void happen(ParticleEventHandler h) {
        // Note: don't need to repeat for p2 bc Particle
        // function updates both input particle attributes
        p1.collide(p1, p2);
        h.reactTo(this);
        return;
    }

}
