import java.util.Arrays;

public class Main {
    private static final Bodeguero BODEGUERO_PRUEBA = new Bodeguero("brayan.bodeguero@chamarket.com", 987654321);
    private static final String WHATSAPP_API_KEY = "ABC123";
    private static final INotificable WHATSAPP_NOTIFICADOR = new NotificadorWhatsapp(WHATSAPP_API_KEY);
    private static final INotificable EMAIL_NOTIFICADOR = new NotificadorEmail();
    private static final INotificable PUSH_NOTIFICADOR = new NotificadorPush();
    public static void main(String[] args) {

        ServicioNotificaciones notificador = new ServicioNotificaciones();


        System.out.println("Evento stock mínimo");
        // Para un evento de stockMinimo
        Notificacion stockMinimo = new Notificacion(
                "¡Alerta!",
                "Quedan 5 unidades del producto A",
                TipoEvento.STOCK_MINIMO,
                TipoCanal.PUSH
        );

        notificador.setEstrategia(PUSH_NOTIFICADOR);

        Boolean exito1 = notificador.notificar(stockMinimo);
        System.out.println("Envío exitoso: " + exito1);

        //Evento promoción
        System.out.println("Evento promoción wtsp + email");
        Notificacion promocion = new Notificacion(
                "Gran Oferta 2x1 en todas las bebidas.",
                "Nueva Promoción ChaMarket",
                TipoEvento.PROMOCION,
                null
        );

        promocion.setBodeguero(BODEGUERO_PRUEBA);

        notificador.setEstrategia(new NotificadorCombinado(Arrays.asList(WHATSAPP_NOTIFICADOR, EMAIL_NOTIFICADOR)));
        Boolean exitoPromo = notificador.notificar(promocion);

        System.out.println("\n-> Resultado Final Envío Promoción: " + (exitoPromo ? "ÉXITO" : "FALLO"));

        // //Evento Mantenimiento
        System.out.println("Evento Mantenimiento (Email + Push)");

        Notificacion mantenimiento = new Notificacion(
                "Sistema fuera de línea por 2 horas.",
                "Aviso de Mantenimiento",
                TipoEvento.MANTENIMIENTO,
                null
        );
        mantenimiento.setBodeguero(BODEGUERO_PRUEBA);

        INotificable mantenimientoCompuesto = new NotificadorCombinado(Arrays.asList(EMAIL_NOTIFICADOR, PUSH_NOTIFICADOR));

        notificador.setEstrategia(mantenimientoCompuesto);
        Boolean exitoMant = notificador.notificar(mantenimiento);

        System.out.println("\n-> Resultado Final Envío Mantenimiento: " + (exitoMant ? "ÉXITO" : "FALLO"));

    }
}