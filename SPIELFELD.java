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

    private SCHIFF[][] spielfeld1, spielfeld2, spielfeldAktuell;
    private int xAktuell, yAktuell;

    public SPIELFELD(){
        super();
        spielfeld1 = new SCHIFF[10][10];

        for(int x=0; x<10; x++){
            for(int y=0; y<10; y++){
                spielfeld1[x][y] = new SCHIFF(20+x*36+12+10, 125+y*36+12);
            }
        }

        spielfeld2 = new SCHIFF[10][10];

        for(int x=0; x<10; x++){
            for(int y=0; y<10; y++){
                spielfeld2[x][y] = new SCHIFF(20+360+30+x*36+12+20, 125+y*36+12);
            }
        }

        spielfeldAktuell = spielfeld1;
        xAktuell = 0;
        yAktuell = 0;
        spielfeldAktuell[xAktuell][yAktuell].setzeFarbe("rot");
    }

    @Override
    public void tick() {}

    @Override
    public void tasteReagieren( int code ) {
        if ( code == 26 && yAktuell > 0 ) { // oben
            spielfeldAktuell[xAktuell][yAktuell].setzeFarbe("grau");
            spielfeldAktuell[xAktuell][--yAktuell].setzeFarbe("rot");
        } else if ( code == 27 && xAktuell < 9 ) { // rechts
            spielfeldAktuell[xAktuell][yAktuell].setzeFarbe("grau");
            spielfeldAktuell[++xAktuell][yAktuell].setzeFarbe("rot");
        } else if ( code == 28 && yAktuell < 9 ) { // unten
            spielfeldAktuell[xAktuell][yAktuell].setzeFarbe("grau");
            spielfeldAktuell[xAktuell][++yAktuell].setzeFarbe("rot");
        } else if ( code == 29 && xAktuell > 0 ) { // links
            spielfeldAktuell[xAktuell][yAktuell].setzeFarbe("grau");
            spielfeldAktuell[--xAktuell][yAktuell].setzeFarbe("rot");
        } else if ( code == 31 ) { // Enter
            spielfeldAktuell[xAktuell][yAktuell].setzeFarbe("grau");
            
            spielfeldAktuell = spielfeldAktuell == spielfeld1 ? spielfeld2 : spielfeld1; // Anderes Spielfeld
            xAktuell = 0;
            yAktuell = 0;
            spielfeldAktuell[xAktuell][yAktuell].setzeFarbe("rot");
        }
    }
}
