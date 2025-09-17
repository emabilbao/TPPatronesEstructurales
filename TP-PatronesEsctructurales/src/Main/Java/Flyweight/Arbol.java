package Main.Java.Flyweight;

public class Arbol {
    private String tipo;
    private String textura;
    private String color;

    public Arbol(String tipo, String textura, String color) {
        this.tipo = tipo;
        this.textura = textura;
        this.color = color;
    }

    // Metodo para dibujar el árbol en una posición específica
    public void dibujar(int x, int y) {
        // Simulamos dibujar en el mapa
        System.out.println("Dibujando " + tipo + " en (" + x + "," + y + ")");
    }
}
