package simulation;

public interface ParticleEventHandler {

    public void reactTo(Tick tick); // Defined in ParticleSimultion

    public void reactTo(Collision c); // Defined in ParticleSimultion

}


