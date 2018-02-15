package simulation;

public abstract class Collision extends AbstractEvent {

    private static double t;
    public static Particle[] particles;
    private static int[] collisionHistory;

    /**
     * Constructor for Collision
     */
    public Collision(double time, Particle[] ps) {
        super(time);

        t = time;

        // Save number of collisions at moment of creation;
        // This won't change, though particles[i].collisons might

        int num_part = ps.length;

        Particle[] particles = new Particle[num_part];
        int[] collisionHistory = new int[num_part];

        // Loop to handle this no matter how many particles passed in
        for (int i = 0; i < num_part; i++) {
            particles[i] = ps[i];
            collisionHistory[i] = particles[i].collisions();
        }


    }

    /**
     * Returns true if this Collision is (still) valid.
     */
    @Override
    public boolean isValid() {
        // Check if particle(s) have incremented number of collisions
        // since the creation of this collision instact
        for (int i = 0; i < particles.length; i++) {
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
