package simulation;

public abstract class Collision extends AbstractEvent {

    public Particle[] particles;
    private int[] collisionHistory;
    private int numParticles;

    /**
     * Constructor for Collision
     */
    public Collision(double time, Particle[] ps) {
        super(time);


        numParticles = ps.length; // Will be 1 or 2 only

        particles = new Particle[numParticles];
        collisionHistory = new int[numParticles];
        
//        particles = ps;
        
        // Loop to handle this no matter how many particles passed in
        for (int i = 0; i < numParticles; i++) {
            // Save number of collisions at moment of creation;
            // This won't change, though particles[i].collisons might
            particles[i] = ps[i];
            collisionHistory[i] = ps[i].collisions();
        }
    }

    /**
     * Returns true if this Collision is (still) valid.
     */
    @Override
    public boolean isValid() {
        // Check if particle(s) have incremented number of collisions
        // since the creation of this collision instact
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
