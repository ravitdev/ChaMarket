public class NotificadorEmail implements INotificable{
    @Override
    public Boolean notificar(Notificacion notificacion) {

        Bodeguero bodeguero = notificacion.getBodeguero();

        if (bodeguero == null || bodeguero.getCorreo() == null || bodeguero.getCorreo().isEmpty()) {
            System.err.println("El bodeguero o su correo son nulos");
            return false;
        }

        System.out.println("Enviando Email: " + notificacion.getAsunto());
        return true;
    }
}
