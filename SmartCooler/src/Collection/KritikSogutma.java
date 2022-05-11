package Collection;

public class KritikSogutma implements  IObserver{
    @Override
    public int crucialTemp(int crucialtemp, IEyleyici eyleyici) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return eyleyici.TurnOnCooler(crucialtemp);
    }
}
