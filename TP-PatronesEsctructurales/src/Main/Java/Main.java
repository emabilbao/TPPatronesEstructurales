package Main.Java;

import Main.Java.Adapter.Impresora;
import Main.Java.Adapter.ImpresoraPDF;
import Main.Java.Adapter.ImpresoraTexto;
import Main.Java.Adapter.ImpresoraTextoAdapter;
import Main.Java.Bridge.*;
import Main.Java.Composite.Menu;
import Main.Java.Composite.Plato;
import Main.Java.Decorator.*;
import Main.Java.Facade.TiendaFacade;
import Main.Java.Flyweight.Arbol;
import Main.Java.Flyweight.FabricaDeArboles;
import Main.Java.Proxy.Archivo;
import Main.Java.Proxy.ArchivoProxy;

import java.util.Random;


public class Main {
    public static void main(String[] args) {
        //Prueba Adapter
        Impresora pdf = new ImpresoraPDF();
        pdf.imprimir("Documento en uso directo");

        ImpresoraTexto impresoraTexto = new ImpresoraTexto();
        Impresora textoAdapter = new ImpresoraTextoAdapter(impresoraTexto);

        textoAdapter.imprimir("Imforme en texto plano");

        //Prueba Bridge
        // Crear canales
        CanalEnvio email = new Email();
        CanalEnvio sms = new SMS();

        // Crear notificaciones
        Notificacion alertaEmail = new Alerta(email);
        Notificacion recordatorioSMS = new Recordatorio(sms);
        Notificacion promocionEmail = new Promocion(email);

        // Enviar mensajes
        alertaEmail.notificar("Sistema fuera de línea");
        recordatorioSMS.notificar("Reunión mañana a las 9AM");
        promocionEmail.notificar("50% de descuento en tu proxima compra");

        //Prueba Decorator
        // Plan básico
        Plan plan1 = new PlanBasico();
        System.out.println(plan1.descripcion() + " = $" + plan1.obtenerCosto());

        // Plan básico + HD + Descargas
        Plan plan2 = new DescargasOffline(new HD(new PlanBasico()));
        System.out.println(plan2.descripcion() + " = $" + plan2.obtenerCosto());

        // Plan básico + UltraHD
        Plan plan3 = new UltraHD(new PlanBasico());
        System.out.println(plan3.descripcion() + " = $" + plan3.obtenerCosto());

        // Plan básico + HD + UltraHD + Descargas
        Plan plan4 = new DescargasOffline(new UltraHD(new HD(new PlanBasico())));
        System.out.println(plan4.descripcion() + " = $" + plan4.obtenerCosto());

        //Prueba Facade
        TiendaFacade tienda = new TiendaFacade();

        tienda.comprar("Notebook", 1500.0, "Rodriguez 273");
        tienda.comprar("Auriculares", 300.0, "Av. Belgrano 123");

        //Prueba de Flyweight
        FabricaDeArboles fabrica = new FabricaDeArboles();
        Random random = new Random();

        String[] tipos = {"Pino", "Roble", "Abeto"};
        String[] texturas = {"VerdeOscuro", "VerdeClaro"};
        String[] colores = {"Normal", "Otoño"};

        // Simulamos la creación de 1 millón de árboles
        for (int i = 0; i < 1_000_000; i++) {
            String tipo = tipos[random.nextInt(tipos.length)];
            String textura = texturas[random.nextInt(texturas.length)];
            String color = colores[random.nextInt(colores.length)];

            Arbol arbol = fabrica.obtenerArbol(tipo, textura, color);

            // Cada árbol tiene posición única
            int x = random.nextInt(1000);
            int y = random.nextInt(1000);

            // Dibujamos
            if (i < 5) { // para no saturar la consola
                arbol.dibujar(x, y);
            }
        }

        System.out.println("Tipos de árboles únicos creados: " + fabrica.totalArbolesCreados());

        //Prueba de Proxy
        String[] permitidos = {"admin", "juan", "maria"};

        Archivo archivo1 = new ArchivoProxy("documento_secreto.txt", "juan", permitidos);
        Archivo archivo2 = new ArchivoProxy("documento_secreto.txt", "pedro", permitidos);

        archivo1.abrir();
        archivo2.abrir();

        //Prueba de composite
        // Platos individuales
        Plato plato1 = new Plato("Ensalada", 5000);
        Plato plato2 = new Plato("Hamburguesa", 6000);
        Plato plato3 = new Plato("Papas Fritas", 3000);
        Plato plato4 = new Plato("Gaseosa", 2000);

        // Submenú de postres
        Menu postres = new Menu("Postres");
        postres.agregar(new Plato("Helado", 4000));
        postres.agregar(new Plato("Flan", 3500));

        // Menú principal
        Menu menuPrincipal = new Menu("Menú del Día");
        menuPrincipal.agregar(plato1);
        menuPrincipal.agregar(plato2);
        menuPrincipal.agregar(plato3);
        menuPrincipal.agregar(plato4);
        menuPrincipal.agregar(postres); // submenú incluido

        // Mostrar_todo_el menu
        menuPrincipal.mostrar();
    }
}