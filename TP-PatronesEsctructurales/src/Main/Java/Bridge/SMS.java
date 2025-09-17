package Main.Java.Bridge;

public class SMS implements CanalEnvio {
    @Override
    public void enviarMensaje(String mensaje) {
        System.out.println("Enviando por SMS: " + mensaje);
    }
}
