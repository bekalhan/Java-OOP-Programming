package Collection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectDataBase implements IConnectDataBase{

    public Connection connect(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Berat.6934");
          //  System.out.println("Veritabanına bağlanıldı...");
        }catch (Exception err){
           // System.out.println("Veritabanına bağlılamadı...");
            err.printStackTrace();
        }
        return connection;
    }

    @Override
    public boolean LoginUserName(String user_name) {
        try{
            boolean user_authentication;
            Connection connection = this.connect();
            String sql = "SELECT *  FROM \"akillicihaz\" WHERE \"user_name\"='"+ user_name + "'";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            connection.close();
            if(!rs.next()){
                System.out.println("Bu kullanıcı adına ait kullanıcı bulunamadı");
                user_authentication = false;
            }else{
                System.out.println("Kullanıcı adına ait kisi bulundu");
                // file
                user_authentication = true;
            }

            rs.close();
            statement.close();
            return user_authentication;
        }catch (Exception err){
            err.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean LoginPassword(String user_name, String password) {
        try{
            boolean user_authentication;
            Connection connection = this.connect();
            String sql = "SELECT *  FROM \"akillicihaz\" WHERE \"user_name\"='" + user_name + "' and \"password\"='" + password + "'";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            connection.close();
            if(!rs.next()){
                System.out.println("Şifreler eşleşemedi");
                user_authentication = false;
            }else{
                //System.out.println("User has been found");
                // file
                user_authentication = true;
            }

            rs.close();
            statement.close();
            return user_authentication;
        }catch (Exception err){
            err.printStackTrace();
            return false;
        }
    }





  /*  @Override
    public boolean Login(String user_name, String password) {
        try{
            boolean user_authentication;
            Connection connection = this.connect();
            String sql = "SELECT *  FROM \"akillicihaz\" WHERE \"user_name\"='" + user_name + "' and \"password\"='" + password + "'";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            connection.close();
            if(!rs.next()){
                System.out.println("User not found");
                user_authentication = false;
            }else{
                System.out.println("User has been found");
                // file
                user_authentication = true;
            }

            rs.close();
            statement.close();
            return user_authentication;
        }catch (Exception err){
            err.printStackTrace();
            return false;
        }
    }*/


}
