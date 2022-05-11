package Collection;

public class AnaIslemAuth implements IAnaIslemAuth {
   private final IConnectDataBase connect_database;

    public AnaIslemAuth(){
        this.connect_database = new ConnectDataBase();
    }
    @Override
    public boolean Login(String user_name, String password) {
        boolean auth_user_name = this.connect_database.LoginUserName(user_name);
        if(!auth_user_name){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Bu kullanıcı adına sahip kullanıcı bulunamadı...");
            return false;
        }
        if(auth_user_name){
            boolean auth_password = this.connect_database.LoginPassword(user_name,password);
            if(!auth_password){
                return false;
            }
        }
        return true;
    }
}
