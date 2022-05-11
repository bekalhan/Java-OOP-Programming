package Collection;

public class SicaklikAlgilayici implements ISıcaklıkAlgilayici {
    private int sicaklik;
    private String type;
    private final SicaklikAlgilayiciC sicaklikAlgilayiciC;
    private final SicaklikAlgilayicisiF sicaklikAlgilayicisiF;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public SicaklikAlgilayici(){
        this.sicaklikAlgilayiciC = new SicaklikAlgilayiciC();
        this.sicaklikAlgilayicisiF = new SicaklikAlgilayicisiF();
    }

    public int getSicaklik() {
        return sicaklik;
    }

    public void setSicaklik(int sicaklik) {
        this.sicaklik = sicaklik;
    }

    @Override
    public int PrintTemp(String type) {
        int get_temp=0;
        if(type=="C" || type=="c"){
            get_temp = sicaklikAlgilayiciC.GetTempAsC();
            setSicaklik(get_temp);
            setType("C");
            System.out.println("Şuanki sıcaklık "+getSicaklik()+" "+type);
        }
        else if(type =="F" || type=="f"){
            get_temp = sicaklikAlgilayicisiF.GetTempAsF();
            setSicaklik(get_temp);
            setType("F");
            System.out.println("Şuanki sıcaklık"+getSicaklik()+type);
        }else{
            System.out.println("Böyle bir sıcaklık algılayıcısı bulunmamakta...");
        }
        return get_temp;
    }

    @Override
    public String PrintType() {
        return getType();
    }

    @Override
    public void CurrentTemp(int sicaklik) {
        setSicaklik(sicaklik);
    }

    @Override
    public int CurrentTemp() {
       return getSicaklik();
    }
}
