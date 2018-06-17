package t6;

import org.junit.Test;


public class АтомнаяЛодкаTest {

    @Test
    public void запуститьЛодкуВПлавание() {
        АтомнаяЛодка лодка = new АтомнаяЛодка("Беда");
        лодка.запуститьЛодку();
    }
}