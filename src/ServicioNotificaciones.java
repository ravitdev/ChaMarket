public class ServicioNotificaciones {
    private INotificable estrategia;

    public ServicioNotificaciones(){}

    public void setEstrategia(INotificable estrategia) {
        this.estrategia = estrategia;
    }

    public Boolean notificar(Notificacion notificacion) {
        TipoCanal canalSeleccionado = notificacion.getTipoCanal();

        if (estrategia == null) {
            System.err.println("Error: No se ha configurado ninguna estrategia de notificación.");
            return false;
        }

        return estrategia.notificar(notificacion);
    }
}
