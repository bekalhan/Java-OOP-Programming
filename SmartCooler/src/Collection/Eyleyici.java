package Collection;

public class Eyleyici implements IEyleyici{
    @Override
    public int TurnOnCooler(int temp) {
        System.out.println("Soğutucu açıldı");
        temp = temp - 5;
        return temp;
    }

    @Override
    public void TurnOffCooler() {
        System.out.println("Soğutucu kapatılıyor");
    }
}
