package Main.Java.Decorator;

public abstract class PlanDecorator implements Plan {
    protected Plan plan; // el plan que se está decorando

    public PlanDecorator(Plan plan) {
        this.plan = plan;
    }

    // Delegamos los métodos al plan decorado, se sobrescriben en los decoradores concretos
    public int obtenerCosto() {
        return plan.obtenerCosto();
    }

    public String descripcion() {
        return plan.descripcion();
    }
}
