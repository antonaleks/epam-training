package t6;

import t7.Страна;

@Страна(название = "Россия")
public class АтомнаяЛодка {

    private String имя;
    private ДвигательДляАтомнойЛодки двигатель;

    public АтомнаяЛодка(String имя) {
        this.имя = имя;
        this.двигатель = new ДвигательДляАтомнойЛодки();
    }

    class ДвигательДляАтомнойЛодки {

        private boolean включен;

        public void запуститьДвигатель() {
            включен = true;
            System.out.println("Лодка запущена в плавание");
        }
    }

    public void запуститьЛодку() {
        двигатель.запуститьДвигатель();
    }
}
