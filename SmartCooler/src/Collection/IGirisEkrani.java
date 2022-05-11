package Collection;

public interface IGirisEkrani {
    boolean LoginUserName(String user_name);
    boolean LoginPassword(String user_name,String password);
    void MesajYaz(String mesaj);
}
