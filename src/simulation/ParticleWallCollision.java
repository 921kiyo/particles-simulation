package simulation;

public class ParticleWallCollision extends Collision {

    private Particle p;
    private Wall w;

    /**
     * Passes self to ParticleEventHandler, which knows
     * how to handle collisions individually
     */
    @Override
    public void happen(ParticleEventHandler h) {
        // TODO: Do we need to check isValid() here?
        p.collide(p, w);
        h.reactTo(this);
        return;
    }

}
