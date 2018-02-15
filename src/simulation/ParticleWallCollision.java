package simulation;

public class ParticleWallCollision extends Collision {

    private Wall w;

    public ParticleWallCollision(Particle p, Wall wall, double time) {
        super(time, packageParticle(p));
        
        w = wall;
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
        Particle.collide(particles[0], w);
        h.reactTo(this);
        return;    
    }

}
