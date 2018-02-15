package simulation;

public class TwoParticleCollision extends Collision {



    public TwoParticleCollision(Particle p1, Particle p2, double time) {       
        super(time, packageParticles(p1, p2));
    }

    private static Particle[] packageParticles(Particle part1, Particle part2) {
        Particle[] particles = {part1, part2};
        return particles;
    }
    /**
     * Passes self to ParticleEventHandler, which knows
     * how to handle collisions individually
     */
    @Override
    public void happen(ParticleEventHandler h) {
        if (this.isValid()) {
            // Note: don't need to repeat for p2 bc Particle
            // function updates both input particle attributes
            particles[0].collide(particles[0], particles[1]);
            h.reactTo(this);
            return;
        }
    }

}
