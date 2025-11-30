public class Notificacion {
    private String mensaje;
    private String asunto;
    private Bodeguero bodeguero;
    private TipoEvento tipoEvento;
    private TipoCanal tipoCanal;

    public Notificacion() {
    }

    public Notificacion(String mensaje, String asunto, TipoEvento tipoEvento, TipoCanal tipoCanal) {
        this.mensaje = mensaje;
        this.asunto = asunto;
        this.tipoEvento = tipoEvento;
        this.tipoCanal = tipoCanal;
    }

    public Bodeguero getBodeguero() {
        return bodeguero;
    }

    public void setBodeguero(Bodeguero bodeguero) {
        this.bodeguero = bodeguero;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public TipoCanal getTipoCanal() {
        return tipoCanal;
    }

    public void setTipoCanal(TipoCanal tipoCanal) {
        this.tipoCanal = tipoCanal;
    }
}
