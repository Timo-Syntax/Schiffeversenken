import ea.edu.RechteckE;

/**
 * Diese Klasse stellt ein einfaches Rechteck dar.
 */
public class RECHTECK {

    /**
     * Das Symbol, das dieses Rechteck darstellt.
     */
    protected RechteckE symbol;

    /**
     * Die Farbe dieses Rechtecks
     */
    protected String farbe;

    /**
     * Gibt an, ob dieses Rechteck sichtbar ist.
     */
    protected boolean sichtbar;

    /**
     * Breite des Rechtecks
     */
    protected int breite;

    /**
     * Hoehe des Rechtecks
     */
    protected int hoehe;

    /**
     * x-Koordinate ds Mittelpunkts
     */
    protected int M_x;

    /**
     * y-Koordinate des Mittelpunkts
     */
    protected int M_y;

    
    /**
     * Konstruktor der Klasse <code>RECHTECK</code>. Erstellt ein neues Rechteck.
     */
    public RECHTECK() {
        this.sichtbar = true;
        this.farbe = "Rot";
        this.breite = 200;
        this.hoehe = 130;
        this.M_x = 250;
        this.M_y = 265;
        this.symbol = new RechteckE();
        this.symbol.farbeSetzen(this.farbe);
        this.symbol.masseSetzen(this.breite, this.hoehe);
        this.symbol.mittelpunktSetzen(this.M_x, this.M_y);

    }

    
    /**
     * Setzt die Hoehe und Breite dieses Rechtecks neu.
     * @param   breite  Die neue Breite dieses Rechtecks
     * @param   hoehe   Die neue Hoehe dieses Rechtecks
     */
    public void setzeGroesse(int breite, int hoehe) {
        this.breite = breite;
        this.hoehe = hoehe;
        this.symbol.masseSetzen(breite, hoehe);
    }

    /**
     * Setzt die Farbe dieses Rechtecks neu.
     * @param   farbeNeu    Diese Farbe erhaelt das Rechteck (z.B. "Rot")
     */
    public void setzeFarbe(String farbeNeu) {
        this.farbe = farbeNeu;
        this.symbol.farbeSetzen(farbe);
    }

    /**
     * Setzt den Mittelpunkt dieses Rechtecks neu.
     * @param   m_x Die X-Koordinate des neuen Mittelpunktes
     * @param   m_y Die Y-Koordinate des neuen Mittelpunktes
     */
    public void setzeMittelpunkt(int m_x, int m_y) {
        this.M_x = m_x;
        this.M_y = m_y;
        this.symbol.mittelpunktSetzen(m_x, m_y);
    }

    /**
     * Setzt, ob dieses Rechteck sichtbar sein soll.
     * @param   sichtbarNeu Ist dieser Wert <code>true</code>, ist nach dem Aufruf dieser Methode dieses Rechteck 
     * sichtbar. Ist dieser Wert <code>false</code>, so ist nach dem Aufruf dieser Methode dieses Rechteck unsichtbar.
     */
    public void setzeSichtbar(boolean sichtbarNeu) {
        this.sichtbar = sichtbarNeu;
        this.symbol.sichtbarSetzen(sichtbarNeu);
    }

    /**
     * Verschiebt dieses Rechteck um eine Verschiebung - angegeben durch ein "Delta X" und "Delta Y".
     * @param   deltaX  Der X Anteil dieser Verschiebung. Positive Werte verschieben nach rechts, negative nach links.
     * @param   deltaY  Der Y Anteil dieser Verschiebung. Positive Werte verschieben nach unten, negative nach oben.
     */
    public void verschiebenUm(int deltaX, int deltaY) {
        this.M_x = this.M_x + deltaX;
        this.M_y = this.M_y + deltaY;
        this.symbol.verschieben(deltaX, deltaY);
    }

    /**
     * Gibt das Symbol als grafisches Objekt aus.<br />
     * Diese Methode braucht man nicht nutzen.
     * @return  Das Symbol dieses Rechtecks. Dies ist ein echtes, grafisches Objekt.
     */
    public RechteckE symbol() {
        return this.symbol;
    }

    /**
     * Diese Methode gibt die x-Koordinate des Mittelpunkts dieses Rechtecks zurueck
     * @return  Die aktuelle x-Koordinate des Mittelpunktes dieses Rechtecks
     */
    public int nenneM_x()
    {
        return this.M_x;
    }

    /**
     * Diese Methode gibt die y-Koordinate des Mittelpunkts dieses Rechtecks zurueck
     * @return  Die aktuelle y-Koordinate des Mittelpunktes dieses Rechtecks
     */
    public int nenneM_y()
    {
        return this.M_y;
    }

    
    //------------------------------------------------------------------------
    // Methoden fuer die  K O L L I S I O N S T E S T S  mit anderen Objekten
    //------------------------------------------------------------------------

    /**
     * Diese Methode prueft dieses Rechteck und ein weiteres Rechteck auf Kollision.
     * @param   r   Das Rechteck, auf dessen Ueberschneiden mit dem die Methode ausfuehrenden Rechteck geprueft werden soll.
     * @return  <code>true</code>, wenn sich die beiden Rechteck ueberlagern - also schneiden - sonst <code>false</code>.
     */
    public boolean schneidet(RECHTECK r) {
        return symbol.schneidet(r.symbol());
    }

    //     /**
    //      * Diese Methode prueft dieses Rechteck und einen Kreis auf Kollision.
    //      * @param   k   Der Kreis, auf dessen Ueberschneiden mit dem die Methode ausfuehrenden Rechteck geprueft werden soll.
    //      * @return  <code>true</code>, wenn sich Kreis und Rechteck ueberlagern - also schneiden - sonst <code>false</code>.
    //      */
    //     public boolean schneidet(KREIS k) {
    //         return symbol.schneidet(k.symbol());
    //     }

    //     /**
    //      * Diese Methode prueft dieses Rechteck und ein Dreieck auf Kollision.
    //      * @param   d   Das Dreieck, auf dessen Ueberschneiden mit dem die Methode ausfuehrenden Rechteck geprueft werden soll.
    //      * @return  <code>true</code>, wenn sich Dreieck und Rechteck ueberlagern - also schneiden - sonst <code>false</code>.
    //      */
    //     public boolean schneidet(DREIECK d) {
    //         return symbol.schneidet(d.symbol());
    //     }
    //     

    //     //----------------------------------------------------------------------------------
    //     // Methoden zur  B E R E C H N U N G   D E S   A B S T A N D S  zu anderen Objekten
    //     //----------------------------------------------------------------------------------
    //     
    //     /**
    //      * Diese Methode prueft, wie weit der Mittelpunkt dieses Rechtecks vom Mittelpunkt 
    //      * eines anderen Kreises in x-Richtung entfernt ist.
    //      * @param   k   Der andere Kreis
    //      * @return  Abstand (in Pixeln) dieses Rechtecks vom anderen Kreis in x-Richtung (>0, wenn dieses Rechteck rechts des anderen Kreises liegt)
    //      */
    //     public int berechneAbstandX(KREIS k)
    //     {
    //         return this.M_x - k.nenneM_x();
    //     }

    /**
     * Diese Methode prueft, wie weit der Mittelpunkt dieses Rechtecks vom Mittelpunkt 
     * eines anderen Rechtecks in x-Richtung entfernt ist.
     * @param   r   Das andere Rechteck
     * @return  Abstand (in Pixeln) der beiden Rechtecke in x-Richtung (>0, wenn dieses Rechteck rechts des anderen Rechtecks liegt)
     */
    public int berechneAbstandX(RECHTECK r)
    {
        return this.M_x - r.nenneM_x();
    }

    //     /**
    //      * Diese Methode prueft, wie weit der Mittelpunkt dieses Rechtecks vom Mittelpunkt 
    //      * eines anderen Dreiecks in x-Richtung entfernt ist.
    //      * @param   d   Das andere Dreieck
    //      * @return  Abstand (in Pixeln) dieses Rechtecks vom anderen Dreieck in x-Richtung (>0, wenn dieses Rechteck rechts des anderen Dreieck liegt)
    //      */
    //     public int berechneAbstandX(DREIECK d)
    //     {
    //         return this.M_x - d.nenneM_x();
    //     }

    //     /**
    //      * Diese Methode prueft, wie weit der Mittelpunkt dieses Rechtecks vom Mittelpunkt 
    //      * eines anderen Kreises in y-Richtung entfernt ist.
    //      * @param   k   Der andere Kreis
    //      * @return  Abstand (in Pixeln) der dieses Rechtecks von dem anderen Kreis in y-Richtung (>0, wenn dieses Rechteck unter dem anderen Kreis liegt)
    //      */
    //     public int berechneAbstandY(KREIS k)
    //     {
    //         return this.M_y - k.nenneM_y();
    //     }

    /**
     * Diese Methode prueft, wie weit der Mittelpunkt dieses Rechtecks vom Mittelpunkt 
     * eines anderen Rechtecks in y-Richtung entfernt ist.
     * @param   r   Das andere Rechteck
     * @return  Abstand (in Pixeln) der beiden Rechtecke in y-Richtung (>0, wenn dieses Rechteck unter dem anderen Rechteck liegt)
     */
    public int berechneAbstandY(RECHTECK r)
    {
        return this.M_y - r.nenneM_y();
    }
    //     
    //     /**
    //      * Diese Methode prueft, wie weit der Mittelpunkt dieses Rechtecks vom Mittelpunkt 
    //      * eines anderen Dreiecks in y-Richtung entfernt ist.
    //      * @param   d   Das andere Dreieck
    //      * @return  Abstand (in Pixeln) dieses Rechtecks vom anderen Dreieck in y-Richtung (>0, wenn dieses Rechteck unter dem anderen Dreieck liegt)
    //      */
    //     public int berechneAbstandY(DREIECK d)
    //     {
    //         return this.M_y - d.nenneM_y();
    //     }

}