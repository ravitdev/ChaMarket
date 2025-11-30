public class NotificadorPush implements INotificable{
    @Override
    public Boolean notificar(Notificacion notificacion) {
        System.out.println("Enviando Push Notification: " + notificacion.getAsunto());
        return true;
    }
}
