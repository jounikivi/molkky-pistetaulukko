import java.util.ArrayList;
import java.util.Date;

public class Pelisessio {
    private Date aloitusPvm;
    private Date lopetusPvm;
    private ArrayList<Integer> heitot;

    /**
     * Konstruktori, joka luo uuden Pelisessio-olion
     * ja asettaa aloitusPvm:n nykyhetkeksi.
     */
    public Pelisessio() {
        aloitusPvm = new Date();
        heitot = new ArrayList<Integer>();
    }

    /**
     * Palauttaa pelisession aloituspäivämäärän.
     * @return aloitusPvm aloituspäivämäärä
     */
    public Date getAloitusPvm() {
        return aloitusPvm;
    }

    /**
     * Asettaa pelisession lopetuspäivämäärän.
     * @param lopetusPvm lopetuspäivämäärä
     */
    public void setLopetusPvm(Date lopetusPvm) {
        this.lopetusPvm = lopetusPvm;
    }

    /**
     * Palauttaa pelisession lopetuspäivämäärän.
     * @return lopetusPvm lopetuspäivämäärä
     */
    public Date getLopetusPvm() {
        return lopetusPvm;
    }

    /**
     * Lisää uuden heiton pelisessioon.
     * @param tulos heiton tulos
     */
    public void lisaaHeitto(int tulos) {
        heitot.add(tulos);
    }

    /**
     * Palauttaa kaikki pelisession heitot.
     * @return heitot pelisession heitot
     */
    public ArrayList<Integer> getHeitot() {
        return heitot;
    }
}

