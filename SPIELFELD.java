/* Copyright (C) 2016 Dominik Huber, Lukas Bartl
 * Diese Datei ist ein Teil von Schiffeversenken.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

public class SPIELFELD extends SPIEL {

    private SCHIFF[][] spielfeld1, // 2-dimensionales Array, erst x-Wert, dann y-Wert -> spielfeld1[x][y]
                       spielfeld2, // 2. Spielfeld
                       spielfeldAktuell; // Referenz auf das aktuelle Spielfeld, wird bei Spielerwechsel umgetauscht
                       
    private int xAktuell, yAktuell; // aktuelle x und y-Werte -> spielfeldAktuell[xAktuell][yAktuell] == aktuelles SCHIFF

    public SPIELFELD(){
        super();
        spielfeld1 = new SCHIFF[10][10]; // neues Array mit 10*10 Objekten der Klasse SCHIFF erzeugen

        for(int x=0; x<10; x++){
            for(int y=0; y<10; y++){
                spielfeld1[x][y] = new SCHIFF(20+x*36+12+10, 125+y*36+12); // Feld initialisieren
            }
        }

        spielfeld2 = new SCHIFF[10][10]; // neues Array mit 10*10 Objekten der Klasse SCHIFF erzeugen

        for(int x=0; x<10; x++){
            for(int y=0; y<10; y++){
                spielfeld2[x][y] = new SCHIFF(20+360+30+x*36+12+20, 125+y*36+12); // Feld initialisieren
            }
        }

        spielfeldAktuell = spielfeld1; // der linke Spieler beginnt
        xAktuell = 0; // ganz links
        yAktuell = 0; // ganz oben
        spielfeldAktuell[xAktuell][yAktuell].setzeFarbe("rot"); // links-oberes SCHIFF rot setzen
    }

    @Override
    public void tick() {}

    @Override
    public void tasteReagieren( int code ) {
        if ( code == 26 && yAktuell > 0 ) { // oben
            spielfeldAktuell[xAktuell][yAktuell].setzeFarbe("grau"); // aktuelles SCHIFF grau
            spielfeldAktuell[xAktuell][--yAktuell].setzeFarbe("rot"); // SCHIFF eines weiter oben rot
        } else if ( code == 27 && xAktuell < 9 ) { // rechts
            spielfeldAktuell[xAktuell][yAktuell].setzeFarbe("grau"); // aktuelles SCHIFF grau
            spielfeldAktuell[++xAktuell][yAktuell].setzeFarbe("rot"); // SCHIFF eines weiter rechts rot
        } else if ( code == 28 && yAktuell < 9 ) { // unten
            spielfeldAktuell[xAktuell][yAktuell].setzeFarbe("grau"); // aktuelles SCHIFF grau
            spielfeldAktuell[xAktuell][++yAktuell].setzeFarbe("rot"); // SCHIFF eines weiter unten rot
        } else if ( code == 29 && xAktuell > 0 ) { // links
            spielfeldAktuell[xAktuell][yAktuell].setzeFarbe("grau"); // aktuelles SCHIFF grau
            spielfeldAktuell[--xAktuell][yAktuell].setzeFarbe("rot"); // SCHIFF eines weiter links rot
        } else if ( code == 31 ) { // Enter
            spielfeldAktuell[xAktuell][yAktuell].setzeFarbe("grau"); // aktuelles SCHIFF grau
            
            spielfeldAktuell = spielfeldAktuell == spielfeld1 ? spielfeld2 : spielfeld1; // Anderes Spielfeld auswählen, der andere Spieler ist nun an der Reihe
            xAktuell = 0; // ganz links
            yAktuell = 0; // ganz oben
            spielfeldAktuell[xAktuell][yAktuell].setzeFarbe("rot"); // links-oberes SCHIFF rot setzen
        }
    }
}
