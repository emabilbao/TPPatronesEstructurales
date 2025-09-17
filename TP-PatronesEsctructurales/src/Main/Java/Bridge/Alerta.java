package Main.Java.Bridge;

public class Alerta extends Notificacion {
    public Alerta(CanalEnvio canal) {
        super(canal);
    }

    @Override
    public void notificar(String mensaje) {
        canal.enviarMensaje("ALERTA: " + mensaje);
    }
}
