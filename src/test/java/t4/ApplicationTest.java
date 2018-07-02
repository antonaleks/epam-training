package t4;

import lombok.val;
import org.junit.Test;

public class ApplicationTest {

    @Test
    public void testApp() throws Throwable {
        Actor actor1 = new Actor("Кира Найтли");
        Actor actor2 = new Actor("Джек воробей");
        Actor actor3 = new Actor("Данила Козловский");
//        val app = Application.builder()
//            .film(Film.builder().name("Икрок").actors(List.of(actor1, actor2, actor3)).build()).
//                film(Film.builder().name("Один").actors(List.of(actor1)).build()).build();
        val app = new Application();
        app.showFilms();
        //app.addFilm(Film.builder().name("Пила").actors(List.of(actor2, actor3)).build());
        app.showFilms();
        app.saveFilms();
        //app.removeFilm(Film.builder().name("Пила").actors(List.of(actor2, actor3)).build());
        app.showFilms();
        app.saveFilms();

    }

}