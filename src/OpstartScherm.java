public class OpstartScherm {

    private String gekozenFile;
    private ExterneLibrary gekozenEventLibrary;

    private OpstartScherm opstartScherm;

    public OpstartScherm(String gekozenFile, ExterneLibrary gekozenEventLibrary,  OpstartScherm opstartScherm) {
        this.gekozenFile = gekozenFile;
        this.gekozenEventLibrary = gekozenEventLibrary;
        this.opstartScherm = opstartScherm;
    }

    public void startSimulatie(){

    }

    public String vraagJsonBestand(){
        return gekozenFile;
    }

    public ExterneLibrary vraagEventLibrary(){
        return gekozenEventLibrary;
    }

    public String getGekozenFile() {
        return gekozenFile;
    }
    public void setGekozenFile(String gekozenFile) {
        this.gekozenFile = gekozenFile;
    }
    public ExterneLibrary getGekozenEventLibrary() {
        return gekozenEventLibrary;
    }
    public void setGekozenEventLibrary(ExterneLibrary gekozenEventLibrary) {
        this.gekozenEventLibrary = gekozenEventLibrary;
    }
}
