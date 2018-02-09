package simulation;

public class ParticleWallCollision extends Collision {

    private Particle p;
    private Wall w;
    private double t;


    // TODO: happen() might need further work

    /**
     * Passes self to ParticleEventHandler, which knows
     * how to handle collisions individually
     */
    @Override
    public void happen(ParticleEventHandler h) {
        p.collide(p, w);
        h.reactTo(this);
        return;
    }

}
