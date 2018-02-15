package simulation;

public class ParticleWallCollision extends Collision {

    private Wall w;


    public ParticleWallCollision(Particle p, Wall w, double time) {
        super(time, packageParticle(p));
    }

    private static Particle[] packageParticle(Particle part) {
        Particle[] particle = {part};
        return particle;
    }

    /**
     * Passes self to ParticleEventHandler, which knows
     * how to handle collisions individually
     */
    @Override
    public void happen(ParticleEventHandler h) {
        if (this.isValid()) {
            particles[0].collide(particles[0], w);
            h.reactTo(this);
            return;
        }
    }

}
