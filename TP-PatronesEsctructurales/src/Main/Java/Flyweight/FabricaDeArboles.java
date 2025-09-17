package Main.Java.Flyweight;

import java.util.HashMap;
import java.util.Map;

public class FabricaDeArboles {
    private Map<String, Arbol> arboles = new HashMap<>();

    public Arbol obtenerArbol(String tipo, String textura, String color) {
        String key = tipo + "-" + textura + "-" + color;
        if (!arboles.containsKey(key)) {
            arboles.put(key, new Arbol(tipo, textura, color));
        }
        return arboles.get(key);
    }

    public int totalArbolesCreados() {
        return arboles.size();
    }
}
