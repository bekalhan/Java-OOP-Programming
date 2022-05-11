package Collection;

public class AgArayuzu implements IAgArayuzu {
    private final ISıcaklıkAlgilayici sıcaklıkAlgilayici;
    private final IEyleyici eyleyici;
    private final KritikSogutma kritikSogutma;
    private int crucial_temp = 50;


    public AgArayuzu(){
       this.sıcaklıkAlgilayici = new SicaklikAlgilayici();
       this.eyleyici = new EyleyiciB();
       this.kritikSogutma = new KritikSogutma();
    }

    public void CheckCrucialTemp(int sicaklik,String type){
        int kontrol = 0;
        if(type=="F" || type=="f"){
            sicaklik  =  sicaklik - 273;
        }
        while(sicaklik >= this.crucial_temp){
            System.out.println("Sıcaklık kritik sıcaklık üzerinde soğutucu çalışıyor : "+sicaklik);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sicaklik = kritikSogutma.crucialTemp(sicaklik,eyleyici);
            kontrol =1;
        }
        sıcaklıkAlgilayici.CurrentTemp(sicaklik);
        if(kontrol==1){
            System.out.println("Sıcaklık normal düzeye getirildi "+sicaklik);
        }
    }

    @Override
    public void PrintTemperature() {
        int sicaklik = sıcaklıkAlgilayici.PrintTemp("C");
        this.CheckCrucialTemp(sicaklik,"C");
    }

    @Override
    public void TurnOnCooler() {
        int sicaklik = sıcaklıkAlgilayici.CurrentTemp();
        System.out.println("Şuanki sıcaklık "+sicaklik);
        int new_sicaklik =  eyleyici.TurnOnCooler(sicaklik);
        sıcaklıkAlgilayici.CurrentTemp(new_sicaklik);
        System.out.println("Soğutucu açıldı sıcaklık "+sıcaklıkAlgilayici.CurrentTemp()+"'e düşürüldü");
    }

    @Override
    public void TurnOffCooler() {
        eyleyici.TurnOffCooler();
    }
}
