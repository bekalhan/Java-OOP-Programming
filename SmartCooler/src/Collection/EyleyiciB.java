package Collection;

public class EyleyiciB implements IEyleyici{
    @Override
    public int TurnOnCooler(int temp) {
        System.out.println("Soğutucu açıldı");
        temp = temp - 10;
        return temp;
    }

    @Override
    public void TurnOffCooler() {
        System.out.println("Soğutucu kapatılıyor");
    }
}
