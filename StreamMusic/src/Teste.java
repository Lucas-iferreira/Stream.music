import br.com.lucas.stream.menu.Menu;
import br.com.lucas.stream.service.MusicService;
import br.com.lucas.stream.service.PodcastService;

public class Teste {
    public static void main(String[] args) {
        MusicService musicService = new MusicService();
        PodcastService podcastService = new PodcastService();
        Menu menu = new Menu(musicService, podcastService);
        menu.menuPrincipal();
    }
}
