import java.util.List;

public class NotificadorCombinado implements INotificable {
    private final List<INotificable> notificadores;

    public NotificadorCombinado(List<INotificable> notificadores) {
        this.notificadores = notificadores;
    }

    @Override
    public Boolean notificar(Notificacion notificacion) {
        boolean exitoGeneral = true;

        for (INotificable notificador : notificadores) {
            Boolean exitoParcial = notificador.notificar(notificacion);
            if (!exitoParcial) {
                exitoGeneral = false;
            }
        }

        return exitoGeneral;
    }
}
