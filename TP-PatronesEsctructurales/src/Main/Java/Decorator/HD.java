package Main.Java.Decorator;

public class HD extends PlanDecorator {
    public HD(Plan plan) {
        super(plan);
    }

    @Override
    public int obtenerCosto() {
        return super.obtenerCosto() + 500;
    }

    @Override
    public String descripcion() {
        return super.descripcion() + " + HD";
    }
}
