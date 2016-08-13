import ea.*;
import ea.edu.AnzeigeE;

/**
 * Klasse SPIEL als Vererbungs-Vorlage fuer alle selbst geschriebenen Spiele. 
 * Sie stellt die Faehigkeit fuer Tasten-Reaktionen, Timer-Aktionen, ... zu Verfuegung.
 * @author      mike ganshorn 
 * @version     2012-09-05
 */
public class SPIEL implements TICKER, TASTENREAGIERBAR
{
    protected MANAGER manager;
    protected int zaehler;
    protected ZUFALL zufall;

    /**
     * Konstruktor fuer Objekte der Klasse SPIEL
     */
    public SPIEL()
    {
        this.manager = new MANAGER();
        this.zaehler = 0;
        this.manager.tickerAnmelden(this, 300);
        this.manager.tastenReagierbarAnmelden(this);
        this.zufall = new ZUFALL();
    }

    /**
     * Methode tickerIntervallSetzen setzt das Intervall zum Aufrufen des Tickers neu. 
     * @param   neuesIntervall  Zeitintervall in Millisekunden zwischen den Ticks
     */
    public void tickerIntervallSetzen(int neuesIntervall)
    {
        this.manager.tickerAbmelden(this);
        this.manager.tickerAnmelden(this, neuesIntervall);
    }

    /**
     * Methode tickerStoppen zum stoppen des Tickers. 
     * Anschließend finden keine zeitlich wiederkehrenden Ereignisse mehr statt. 
     * Das Spiel steht still. 
     */
    public void tickerStoppen() {
        this.manager.tickerAbmelden(this);
    }

    /**
     * Methode tickerStarten zum erneuten Starten des Tickers nach einem Stoppen. 
     * Bei einem neuen SPIEL-Objekt ist der Ticker schon gestartet. 
     * V O R S I C H T ! Mehrmaliges starten fuehrt zur Halbierung, Drittelung ... des Zeitintervalls!
     * @param   neuesIntervall      Das Zeitintervall zwischen den Ticks in Millisekunden
     */
    public void tickerStarten(int neuesIntervall) {
        this.manager.tickerAnmelden(this, neuesIntervall);
    }

    /**
     * Methode gibZufallszahlVonBis gibt ganze Zufallszahlen
     * @param   von     kleinste moegliche Zufallszahl
     * @param   bis     groesste moegliche Zufallszahl
     */
    public int zufallszahlVonBis(int von, int bis)
    {
        return this.zufall.gibZufallszahl(von, bis);
    }

    @Override
    /**
     * Methode tick zum Reagieren auf Ticker-Signale. 
     * Diese Methode wird bei jedem Tick automatisch aufgerufen. 
     * Dann wird das, was im Rumpf dieser Methode steht, automatisch ausgefuehrt. 
     * Der Abstand zwischen den Tick-Signalen kann mit der Methode 
     * tickerIntervallSetzen(int neuesIntervall) veraendert werden.
     */
    public void tick() 
    {
        this.zaehler += 1;
        if (this.zaehler % 2 == 0) 
        {
            System.out.println("tack");
        }
        else
        {
            System.out.println("tick");
        }
    }

    @Override
    /**
     * Methode tasteReagieren zum Reagieren auf Tastatur-Eingaben
     * @param   code    Code der Taste (A=0, B=1, ... Z=25, Pfeil-rauf=26, Pfeil-rechts=27, Pfeil-runter=28, Pfeil-links=29, ...)
     */
    public void tasteReagieren(int code)
    {
        System.out.println("Taste mit code " + code + " wurde gedrueckt");
    }     

}

/**
 * Diese Klasse ermoeglicht das Anmelden von EDU-Interfaces.<br />
 * Zusaetzlich laesst sich hiermit ein Punktestand einblenden.
 * @author      michael andonie 
 * @version     2.0
 */
class MANAGER
extends AnzeigeE {

    /**
     * Meldet ein TICKER-Interface an. <br />
     * Sobald diese Anmeldung erfolgreich abgeschlossen wurde, wird der TICKER in seiner Intervallschaltung aufgerufen.
     * @param   ticker  Der anzumeldende Ticker. Dies muss ein Objekt einer Klasse sein, die das Interface <code>TICKER</code> 
     * implementiert.
     * @param   intervall   Das Intervall (<i>in Millisekunden</i>), in dem dieser Ticker aufgerufen wird.
     * @see TICKER
     * @see tickerAbmelden(TICKER)
     */
    public void tickerAnmelden(TICKER ticker, int intervall) {
        super.tickerAnmelden(ticker, intervall);
    }

    /**
     * Meldet ein TICKER-Interface ab. <br />
     * Sobald diese Abmeldung erfolgreich abgeschlossen wurde, wird der TICKER nicht mehr gemaess seiner 
     * Intervallschaltung aufgerufen.
     * @param   ticker  Der abzumeldende TICKER. War dieser Ticker abgemeldet passiert gar nichts.
     * @see tickerAnmelden(TICKER, int)
     */
    public void tickerAbmelden(TICKER ticker) {
        super.tickerAbmelden(ticker);
    }

    /**
     * Meldet ein TASTENREAGIERBAR-Interface an.<br />
     * Sobald diese Anmeldung erfolgreich abgeschlossen wurde, wird das TASTENREAGIERBAR-Interface bei jedem Tastendruck
     * informiert, indem seine <code>tasteReagieren</code>-Methode aufgerufen wurde.
     * @see TASTENREAGIERBAR
     */
    public void tastenReagierbarAnmelden(TASTENREAGIERBAR tastenreagierbar) {
        super.tastenReagierbarAnmelden(tastenreagierbar);
    }

    /**
     * Setzt den Punktestand auf der linken Seite neu.
     * @param   punkte  Dieser Punktestand wird ab sofort auf der linken Seite angezeigt.
     */
    public void punkteLinksSetzen(int punkte) {
        super.punkteLinksSetzen(punkte);
    }

    /**
     * Setzt den Punktestand auf der rechten Seite neu.
     * @param   punkte  Dieser Punktestand wird ab sofort auf der rechten Seite angezeigt.
     */
    public void punkteRechtsSetzen(int punkte) {
        super.punkteRechtsSetzen(punkte);
    }
}


/**
 * Interface TASTENREAGIERBAR zur Reaktion auf Tastatur-Ereignisse.
 * 
 * @author      michael andonie 
 * @version     2.0
 */

interface TASTENREAGIERBAR
{
    /**
     * Diese Methode wird immer dann aufgerufen, wenn eine Taste heruntergedrueckt wird.<br />
     * Hierzu jedoch muss ein Objekt einer Klasse, die dieses Interface implementiert, <b>ZUNAECHST am 
     * <code>MANAGER</code>-Objekt angemeldet werden</b>.
     * @param   code    Jede heruntergedrueckte Taste hat einen eigenen Zahlencode. <i>So kann mit einer Methode
     * jedem Tastendruck ein eigenes Handeln zugewiesen werden</i>. Zum Beispiel durch eine <code>switch</code>-Anweisung:
     * <br /><br /><code>
     * switch(code) {<br />
     * case 0: //Die Taste A<br />
     * //Vorgehen bei Druck auf A<br />
     * break;<br />
     * case 28: //Die Pfeiltaste nach UNTEN<br />
     * //Vorgehen bei Druck auf diese Taste<br />
     * break;<br />
     * }<br />
     * </code><br />
     * Die Code-Zuordnung lautet wie folgt:<br />
     * A: 0<br />
     * B:1<br />
     * //...//<br />
     * Z: 25<br />
     * Pfeil oben: 26<br />
     * rechts: 27<br />
     * unten: 28<br />
     * links: 29<br />
     * Leertaste: 30<br /> 
     * Enter: 31<br />
     * Escape: 32<br />
     * 0-Taste:33<br />
     * 1-Taste:34<br />
     * //...//
     */
    public abstract void tasteReagieren(int code);
}    

/**
 * Ein Ticker-Interface beschreibt einen periodisch aufzurufenden Auftrag oder Algorithmus.
 * 
 * @author      michael andonie 
 * @version     2.0
 */

interface TICKER
{
    /**
     * Die Tick-Methode.<br />
     * Diese Methode wird in Regelmaessigen Abstaenden aufgerufen, <b>WENN das Objekt der implementierenden Klasse 
     * an einem Manager angemeldet wurde</b>.
     * @see MANAGER
     */
    public abstract void tick();
}


/**
 * Klasse ZUFALL erzeugt ganze Zufallszahlen in einem beliebigen Bereich
 * @author      mike ganshorn
 * @version     2012-08-12
 */
class ZUFALL
{
    private java.util.Random generator;

    /**
     * Konstruktor fuer Objekte der Klasse ZUFALL
     */
    public ZUFALL()
    {
        this.generator = new java.util.Random();
    }

    /**
     * Methode gibZufallszahl zum Geben einer ganzen Zufallszahl in einem beliebigen Bereich
     * @param   von     Die kleinste moegliche Zufallszahl
     * @param   bis     Die groesste moegliche Zufallszahl
     */
    public int gibZufallszahl(int von, int bis)
    {
        return von + this.generator.nextInt(bis +1);
    }
}

