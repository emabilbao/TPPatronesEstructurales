package Main.Java.Bridge;

public class Promocion extends Notificacion {
    public Promocion(CanalEnvio canal) {
        super(canal);
    }

    @Override
    public void notificar(String mensaje) {
        canal.enviarMensaje("PROMOCIÓN: " + mensaje);
    }
}
