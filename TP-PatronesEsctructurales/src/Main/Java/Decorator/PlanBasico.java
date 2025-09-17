package Main.Java.Decorator;

public class PlanBasico implements Plan {
    @Override
    public int obtenerCosto() {
        return 1000;
    }

    @Override
    public String descripcion() {
        return "Plan Básico";
    }
}
