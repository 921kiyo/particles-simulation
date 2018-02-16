package simulation;

public interface ParticleEventHandler {

    public void reactTo(Tick tick); // Defined in ParticleSimulation

    public void reactTo(Collision c); // Defined in ParticleSimulation

}
