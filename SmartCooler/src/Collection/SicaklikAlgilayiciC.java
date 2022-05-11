package Collection;

import java.util.Random;

public class SicaklikAlgilayiciC{
 /*   private final String type = "c";
    private final int crucial_temp = 60;
    @Override
    public int PrintTemp() {
        System.out.println("Sıcaklık derecesi : ");
        Random random = new Random();
        int random_number = random.nextInt(80);
        System.out.println("Sıcaklık : "+random_number+this.type);
        return random_number;
    }*/

    public int GetTempAsC(){
        Random random = new Random();
        int random_number = random.nextInt(80);
        return random_number;
    }


}
