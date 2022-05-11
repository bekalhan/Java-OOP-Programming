package Collection;

import java.util.Random;

public class SicaklikAlgilayicisiF{
   /* private final String type = "F";
    private final int crucial_temp = 333;
    @Override
    public int PrintTemp() {
        System.out.println("Sıcaklık derecesi : ");
        Random random = new Random();
        int random_number = random.nextInt(80)+273;
        System.out.println("Sıcaklık : "+random_number+this.type);
        return random_number;
    }*/

    public int GetTempAsF(){
        Random random = new Random();
        int random_number = random.nextInt(80)+273;
        return random_number;
    }
}
