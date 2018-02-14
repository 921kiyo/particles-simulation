package simulation;

public abstract class Collision extends AbstractEvent {

    private static double t;
    private static Particle[2] particles;
    private static int[2] collisionHistory;
    /**
     * Constructor for Collision
     */
    public Collision(double time, Particle[] ps) {
        t = time;

        // This only copies over the pointer to the heap, but that's what we
        // actually want so we can look into their collision history later
        particles = ps;

        // Save number of collisions at moment of creation;
        // This won't change, though particles[i].collisons might
        collisionHistory[0] = particles[0].collisions;
        collisionHistory[1] = particles[1].collisions;
    }

    /**
     * Returns true if this Collision is (still) valid.
     */
    @Override
    public boolean isValid() {
        // Check if both items have not changed their number of collisions
        // since the creation of this collision instact
        for (int i = 0; i < 2; i++) {
            if (particles[i].collisions != collisionHistory[i].collisions) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns an array containing the Particles involved in this Collision.
     */
    public Particle[] getParticles() {
        return particles;
    }
}
