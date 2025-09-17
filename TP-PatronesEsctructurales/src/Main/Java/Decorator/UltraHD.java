package Main.Java.Decorator;

public class UltraHD extends PlanDecorator {
    public UltraHD(Plan plan) {
        super(plan);
    }

    @Override
    public int obtenerCosto() {
        return super.obtenerCosto() + 1000;
    }

    @Override
    public String descripcion() {
        return super.descripcion() + " + UltraHD";
    }
}
