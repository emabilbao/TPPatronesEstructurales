package Main.Java.Bridge;

public class Recordatorio extends Notificacion {
    public Recordatorio(CanalEnvio canal) {
        super(canal);
    }

    @Override
    public void notificar(String mensaje) {
        canal.enviarMensaje("RECORDATORIO: " + mensaje);
    }
}
