package Main.Java.Adapter;

public class ImpresoraPDF implements Impresora {
    @Override
    public void imprimir(String texto) {
        System.out.println("Imprimiendo documento en PDF: " + texto);
    }
}
