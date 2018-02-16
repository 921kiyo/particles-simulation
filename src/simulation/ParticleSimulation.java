package simulation;

import java.lang.reflect.InvocationTargetException;
import javax.swing.SwingUtilities;
import utils.MinPriorityQueue;
import utils.List;
import java.util.logging.*;

public class ParticleSimulation implements Runnable, ParticleEventHandler {

    private static final long FRAME_INTERVAL_MILLIS = 40;

    private final ParticlesModel                   model;
    private final ParticlesView                   screen;

    private double                                 clock;
    private double                             lastClock;
    private MinPriorityQueue<Event>                queue;
    private Iterable<Collision>            allCollisions;

    /**
     * Constructor.
     */
    public ParticleSimulation(String name, ParticlesModel m) {
        model = m;
        screen = new ParticlesView(name, model);
        queue = new MinPriorityQueue<Event>();

        // Initialise clock and send to queue
        clock = 1;
        Tick kickoff = new Tick(clock);
        queue.add(kickoff);

        // At time of construction, predict ALL potential collisions at kickoff
        allCollisions = (Iterable<Collision>) model.predictAllCollisions(clock);
        allCollisions.forEach(c -> queue.add(c));
    }

    /**
     * Runs the simulation.
     */
    @Override
    public void run() {
        // Launch GUI
        try {
            SwingUtilities.invokeAndWait(screen);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Primary simulation loop
        while(!queue.isEmpty()) {

            Event currentEvent = queue.remove(); // Grab event at head of queue
            lastClock = clock; // Save most recent clock time

            if (currentEvent.isValid()) {
                // Update time and check for particle movements since last time
                clock = currentEvent.time();
                model.moveParticles(clock - lastClock);

                currentEvent.happen(this); // Let the current event occur
            }
        }
    }

    /**
     * Increment ticks and add to queue every 1.0 ticks.
     */
    public void reactTo(Tick tick) {
        // Try-catch because Thread.sleep() can be interrupted
        try {
            Thread.sleep(FRAME_INTERVAL_MILLIS);
        } catch (InterruptedException ex) {
            Logger.getLogger(ParticleSimulation.class.getName()).
                                                    log(Level.SEVERE, null, ex);
        }

        // Repaint screen and increment the tick
        screen.update();
        Tick nextTick = new Tick(clock + 1);
        queue.add(nextTick);
    }

    /**
     * Changes future predictions for particles in collision and adds to queue
     */
    public void reactTo(Collision c) {
        // Get all particles involved in collision (1 or 2 only)
        Particle[] particlesInvolved = c.getParticles();

        // Get all future collisions for these particles and add all to queue
        Iterable<Collision> newCollisions;
        for (int i = 0; i < particlesInvolved.length; i++) {
            newCollisions = model.predictCollisions(particlesInvolved[i],
                                                    clock);
            newCollisions.forEach(nC -> queue.add(nC));
        }
    }

}
