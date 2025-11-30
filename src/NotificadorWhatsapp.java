public class NotificadorWhatsapp implements INotificable {
    private String apiKey;

    public NotificadorWhatsapp(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public Boolean notificar(Notificacion notificacion) {

        Bodeguero bodeguero = notificacion.getBodeguero();

        if(bodeguero == null || bodeguero.getTelefono() == null) {
            System.out.println("El bodeguero o su teléfono son nulos.");
            return false;
        }

        System.out.println("Enviando WhatsApp: " + notificacion.getAsunto());
        return true;
    }
}
