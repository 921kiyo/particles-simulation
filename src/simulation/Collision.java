package simulation;

public abstract class Collision extends AbstractEvent {

    public Particle[] particles;
    private int[] collisionHistory;
    private int numParticles;

    /**
     * Constructor for Collision
     */
    public Collision(double time, Particle[] ps) {
        super(time); // Calls AbstractEvent constructor

        numParticles = ps.length; // Will be 1 or 2 only

        particles = new Particle[numParticles];
        collisionHistory = new int[numParticles];

        for (int i = 0; i < numParticles; i++) {
            particles[i] = ps[i]; // Manually copy particle references
            collisionHistory[i] = ps[i].collisions(); // Save hits for later ref
        }
    }

    /**
     * Returns true if this Collision is (still) valid.
     */
    @Override
    public boolean isValid() {
        // Only false if particles have hit something else since prediction made
        for (int i = 0; i < numParticles; i++) {
            if (particles[i].collisions() != collisionHistory[i]) {
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
