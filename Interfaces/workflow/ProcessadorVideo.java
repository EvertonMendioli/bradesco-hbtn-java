import java.util.ArrayList;

public class ProcessadorVideo {

    private ArrayList<CanalNotificacao> canais = new ArrayList();

    public void registrarCanal(CanalNotificacao canalnotificacao){
        this.canais.add(canalnotificacao);
    }

    public void processar(Video video){
        Mensagem mensagem = new Mensagem();
        for (CanalNotificacao canalNotificacao : canais) {
            mensagem.setTipoMensagem(TipoMensagem.LOG);
            mensagem.setTexto(video.getArquivo() + " - " + video.getFormato());
            canalNotificacao.notificar(mensagem);
        }
    }
}
