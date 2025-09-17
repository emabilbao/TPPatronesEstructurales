package Main.Java.Decorator;

public class DescargasOffline extends PlanDecorator {
    public DescargasOffline(Plan plan) {
        super(plan);
    }

    @Override
    public int obtenerCosto() {
        return super.obtenerCosto() + 700;
    }

    @Override
    public String descripcion() {
        return super.descripcion() + " + Descargas Offline";
    }
}
