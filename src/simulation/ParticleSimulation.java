package simulation;

import java.lang.reflect.InvocationTargetException;
import javax.swing.SwingUtilities;
import utils.MinPriorityQueue;

public class ParticleSimulation implements Runnable, ParticleEventHandler {

    private static final long FRAME_INTERVAL_MILLIS = 40;

    private final ParticlesModel          model;
    private final ParticlesView           screen;

    private double                        clock;
    private MinPriorityQueue<Event>              queue;

    /**
     * Constructor.
     */
    public ParticleSimulation(String name, ParticlesModel m) {
        model = m;
        screen = new ParticlesView(name, m);
        clock = 1;
        Tick kickoff = new Tick(clock);
        queue = new MinPriorityQueue<Event>();
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
        Event e = queue.remove();
        if(e.isValid()){
            clock = e.time();
        }
    }
    
    public void reactTo(Tick tick) {

//            Thread.sleep(FRAME_INTERVAL_MILLIS);
//            Tell the display to update
        queue.add(tick);
        
    }
    
    public void reactTo(Collision c) {
        queue.add(c);
    }
            

}
