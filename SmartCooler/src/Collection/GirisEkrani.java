package Collection;

public class GirisEkrani implements  IGirisEkrani{
    private final IConnectDataBase database;
    private  final  IAgArayuzu islemci;

    public GirisEkrani(){

        this.database = new ConnectDataBase();
        islemci = new AgArayuzu();
    }

    @Override
    public boolean LoginUserName(String user_name) {
        boolean auth_user_name = this.database.LoginUserName(user_name);
        if(!auth_user_name){
            return false;
        }
        return true;
    }

    @Override
    public boolean LoginPassword(String user_name, String password) {
        boolean auth_password = this.database.LoginPassword(user_name,password);
        if(!auth_password){
            return false;
        }
        return true;
    }

    @Override
    public void MesajYaz(String mesaj) {
        System.out.println(mesaj);
    }


}
