public class Email implements CanalNotificacao{

    @Override
    public void notificar(Mensagem mensagem) {
        System.out.printf("[EMAIL] {"+mensagem.getTipoMensagem()+"} - " + mensagem.getTexto() + "\n");
    }

}
