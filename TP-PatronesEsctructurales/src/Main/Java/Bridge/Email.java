package Main.Java.Bridge;

public class Email implements CanalEnvio{
    @Override
    public void enviarMensaje(String mensaje) {
        System.out.println("Enviando por Email: " + mensaje);
    }
}
