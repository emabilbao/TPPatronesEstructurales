package Main.Java.Proxy;

public class ArchivoProxy implements Archivo {
    private ArchivoReal archivoReal;
    private String nombreArchivo;
    private String usuario;
    private String[] usuariosPermitidos;

    public ArchivoProxy(String nombreArchivo, String usuario, String[] usuariosPermitidos) {
        this.nombreArchivo = nombreArchivo;
        this.usuario = usuario;
        this.usuariosPermitidos = usuariosPermitidos;
    }

    private boolean tienePermiso() {
        for (String u : usuariosPermitidos) {
            if (u.equals(usuario)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void abrir() {
        if (tienePermiso()) {
            if (archivoReal == null) {
                archivoReal = new ArchivoReal(nombreArchivo);
            }
            archivoReal.abrir();
        } else {
            System.out.println("Acceso denegado para el usuario: " + usuario);
        }
    }
}
