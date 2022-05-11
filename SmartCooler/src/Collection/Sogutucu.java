package Collection;

import java.util.Scanner;

public class Sogutucu implements ISogutucu {

    private final IAgArayuzu islemci;
    private  final IGirisEkrani ekran;
    private int kontrol;

    public int getKontrol() {
        return kontrol;
    }

    public void setKontrol(int kontrol) {
        this.kontrol = kontrol;
    }

    public Sogutucu(){
        islemci = new AgArayuzu();
        ekran = new GirisEkrani();
    }

    public void MenuİslemSecimi(int secim) {
        boolean check=false;
        if(secim==1){
            if(check==false){
                this.ekran.MesajYaz("******");
                this.ekran.MesajYaz("Cihaz zaten kapalı durumda");
            }else{
                this.ekran.MesajYaz("*****");
                this.ekran.MesajYaz("Cihaz kapatılıyor");
                check = false;
            }
        }

        else if(secim==2){
            this.ekran.MesajYaz("******");
            AcıkMenuGoster();
        }
    }

    public void AcikMenuislemSecimi(int secim) {
        boolean check = false;
        boolean kontrol_sogutucu = false;
        if(secim==1){
            this.ekran.MesajYaz("******");
            this.islemci.PrintTemperature();
            setKontrol(1);
        }
        else if(secim==2){
            if(kontrol==1){
                this.ekran.MesajYaz("******");
                this.ekran.MesajYaz("Soğutucu açılıyor");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.islemci.TurnOnCooler();
            }else{
                this.ekran.MesajYaz("******");
                this.ekran.MesajYaz("Lütfen ilk önce sıcaklık durumunu öğreniniz !");
            }
        }
        else if(secim==3){
            if(kontrol_sogutucu==true){
                this.ekran.MesajYaz("******");
                this.ekran.MesajYaz("Soğutucu zaten kapalı durumda");
            }else{
                this.ekran.MesajYaz("******");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.islemci.TurnOffCooler();
                this.ekran.MesajYaz("Soğutucu kapatıldı");

                kontrol_sogutucu = true;
            }
        }

        else if(secim==4){
            this.ekran.MesajYaz("******");
            MenuGoster();
        }
    }

    @Override
    public void KullaniciEkranGoster() {
        this.ekran.MesajYaz("****GİRİS EKRANI****");
        Scanner tara = new Scanner(System.in);

        String user_name  = "";
        String password = "";
        boolean auth_user_name =  false;
        while(!auth_user_name==true) {
            this.ekran.MesajYaz("Kullanıcı adını giriniz : ");
            user_name = tara.nextLine();
            auth_user_name = this.ekran.LoginUserName(user_name);
        }

        if (auth_user_name) {
            this.ekran.MesajYaz("******");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.ekran.MesajYaz("şifreyi giriniz : ");
            password = tara.nextLine();
            boolean auth_password = this.ekran.LoginPassword(user_name,password);
            if(auth_password){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.ekran.MesajYaz("Şifre ve kullanıcı adı doğrulandı...");
                MenuGoster();
            }else{
                KullaniciEkranGoster();
            }
        }
    }

    @Override
    public void MenuGoster() {
        boolean check = false;
        int secim;
        this.ekran.MesajYaz("Cihaz şuan kapalı durumda");
        this.ekran.MesajYaz("*****MENU*****");
        do {
            this.ekran.MesajYaz("1-Cihazı kapat");
            this.ekran.MesajYaz("2-Cihazı aç");
            this.ekran.MesajYaz("3-Sistemden çıkış yap");

            Scanner tara = new Scanner(System.in);
            this.ekran.MesajYaz("Seçiminiz : ");
            secim = tara.nextInt();

            if(secim==1){
                MenuİslemSecimi(1);
            }
            else if(secim==2){
                MenuİslemSecimi(2);
            }
        }while (secim!=3);
        this.ekran.MesajYaz("Sistemden çıkış yapıldı...");
        KullaniciEkranGoster();
    }

    @Override
    public void AcıkMenuGoster() {
        boolean check = false;
        int secim;
        int kontrol = 0;
        boolean kontrol_sogutucu = false;
        do {
            Scanner tara = new Scanner(System.in);
            this.ekran.MesajYaz("1-Sıcaklık durumu");
            this.ekran.MesajYaz("2-Soğutucu aç");
            this.ekran.MesajYaz("3-Soğutucu kapat");
            this.ekran.MesajYaz("4-Ana menüye dön");
            this.ekran.MesajYaz("Seçiminiz : ");

            secim = tara.nextInt();
            if(secim==1){
                AcikMenuislemSecimi(1);
            }
            else if(secim==2){
                AcikMenuislemSecimi(2);
            }
            else if(secim==3){
                AcikMenuislemSecimi(3);
            }
            else if(secim==4){
                AcikMenuislemSecimi(4);
            }
        }while(secim!=4);
    }



}
