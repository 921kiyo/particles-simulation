package simulation;

import java.lang.reflect.InvocationTargetException;
import javax.swing.SwingUtilities;
import utils.MinPriorityQueue;

public class ParticleSimulation implements Runnable, ParticleEventHandler {

    private static final long FRAME_INTERVAL_MILLIS = 40;

    private final ParticlesModel          model;
    private final ParticlesView           screen;

    private double                        clock;
    private MinPriorityQueue<Event>       queue;

    /**
     * Constructor.
     */
    public ParticleSimulation(String name, ParticlesModel m) {
        model = m;
        screen = new ParticlesView(name, model);
        
        clock = 1;
        Tick kickoff = new Tick(clock);
        
        queue = new MinPriorityQueue<Event>();
        model.predictAllCollisions(clock);
    }

    /**
     * Runs the simulation.
     */
    @Override
    public void run() {
        try {
            SwingUtilities.invokeAndWait(screen);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // TODO complete implementing this method
        Event currentEvent = queue.remove();
        if (currentEvent.isValid()) {
            clock = currentEvent.time(); // Update time to event's time
            model.moveParticles(clock); // Move particles for this much time
            currentEvent.happen(this); // Let the current event occur
        }
    }
    
    public void reactTo(Tick tick) {

//            Thread.sleep(FRAME_INTERVAL_MILLIS);
//            Tell the display to update
        queue.add(tick);
        
    }
    
    public void reactTo(Collision c) {
        List<Collision> futureCollisions;
        
        Particle[] allParticles = c.getParticles();
//        futureCollisions = model.predictAllCollisions(clock);
        
        for (int i = 0; i < allParticles.length; i++) {
            futureCollisions = model.predictCollisions(allParticles[i], clock);
//            queue.add(futureCollisions[i]);
        }
        
        queue.add(c);
    }
            

}
