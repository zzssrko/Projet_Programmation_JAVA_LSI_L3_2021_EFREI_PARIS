import objects.*;
import tools.Constants;

import java.util.Arrays;
import java.util.HashSet;

public class MAIN {
    public static void main(String[] args) {
        Ligne lignePoly1 = new Ligne(new Point(2, 2), new Point(5, 3));
        Ligne lignePoly2 = new Ligne(new Point(2, 2), new Point(2, 4));
        Ligne lignePoly3 = new Ligne(new Point(2, 4), new Point(5, 3));

        Polygone polygone = new Polygone(new Point(0, 0), new HashSet<>(Arrays.asList(lignePoly1, lignePoly2, lignePoly3)));

        System.out.println("Perimetre : " + polygone.calculerPerimetre());
        System.out.println("Aire : " + polygone.calculerAire());

        System.out.println("Symetrie Centrale");
        System.out.println(polygone);
        polygone.symetrieCentrale();
        System.out.println(polygone);

        lignePoly1 = new Ligne(new Point(2, 2), new Point(5, 3));
        lignePoly2 = new Ligne(new Point(2, 2), new Point(2, 4));
        lignePoly3 = new Ligne(new Point(2, 4), new Point(5, 3));
        polygone = new Polygone(new Point(0, 0), new HashSet<>(Arrays.asList(lignePoly1, lignePoly2, lignePoly3)));

        System.out.println("Symetrie Axiale");
        System.out.println(polygone);
        polygone.symetrieAxiale(Constants.Axe.ORDONNEE);
        System.out.println(polygone);

        lignePoly1 = new Ligne(new Point(2, 2), new Point(5, 3));
        lignePoly2 = new Ligne(new Point(2, 2), new Point(2, 4));
        lignePoly3 = new Ligne(new Point(2, 4), new Point(5, 3));
        polygone = new Polygone(new Point(0, 0), new HashSet<>(Arrays.asList(lignePoly1, lignePoly2, lignePoly3)));

        System.out.println("Homothetie");
        System.out.println(polygone);
        polygone.homothetie(2);
        System.out.println(polygone);


        // Les trie
        Image monImage = new Image();
        monImage.ajoutFormes(getNewPolygone());
        monImage.ajoutFormes(getNewPolygone());
        monImage.ajoutFormes(getNewPolygone());
        monImage.ajoutFormes(getNewPolygone());

        System.out.println("Avant");
        System.out.println(monImage);
        monImage.trierParPerimetre();
        System.out.println("Apres trie par perimetre");
        System.out.println(monImage);
        monImage.trierParAire();
        System.out.println("Apres trie par l'aire");
        System.out.println(monImage);


    }

    public static Point getNewPoint() {
        return new Point(Math.random() * 5, Math.random() * 5);
    }

    public static Ligne getNewLigne() {
        return new Ligne(getNewPoint(), getNewPoint());
    }

    public static Ellipse getNewEllipse() {
        return new Ellipse(getNewPoint(), Math.random() * 5, Math.random() * 5);
    }

    public static Cercle getNewCercle() {
        return new Cercle(getNewPoint(), Math.random() * 5);
    }

    public static Polygone getNewPolygone() {
        double multiplyer = Math.random() * 5;
        Ligne al1 = new Ligne(new Point(1 * multiplyer, 9 * multiplyer), new Point(0 * multiplyer, 0 * multiplyer));
        Ligne al2 = new Ligne(new Point(0 * multiplyer, 0 * multiplyer), new Point(3 * multiplyer, 0 * multiplyer));
        Ligne al3 = new Ligne(new Point(3 * multiplyer, 0 * multiplyer), new Point(3 * multiplyer, 2 * multiplyer));
        Ligne al4 = new Ligne(new Point(3 * multiplyer, 2 * multiplyer), new Point(1 * multiplyer, 9 * multiplyer));
        return new Polygone(new Point(Math.random(), Math.random()), new HashSet<>(Arrays.asList(al1, al2, al3, al4)));
    }

    public static Image getNewImage() {
        Image image = new Image();
        image.ajoutFormes(getNewLigne());
        image.ajoutFormes(getNewPolygone());
        image.ajoutFormes(getNewCercle());
        image.ajoutFormes(getNewEllipse());

        image.ajoutFormes(getNewLigne());
        image.ajoutFormes(getNewPolygone());
        image.ajoutFormes(getNewCercle());
        image.ajoutFormes(getNewEllipse());

        image.ajoutFormes(getNewLigne());
        image.ajoutFormes(getNewCercle());
        image.ajoutFormes(getNewPolygone());
        image.ajoutFormes(getNewEllipse());
        return image;
    }

    public static Dessin getNewDessin() {
        Dessin dessin = new Dessin();
        dessin.ajouterImage(getNewImage());
        dessin.ajouterImage(getNewImage());
        dessin.ajouterImage(getNewImage());
        dessin.ajouterImage(getNewImage());
        dessin.ajouterImage(getNewImage());
        return dessin;
    }


}
