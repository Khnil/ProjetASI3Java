package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import java.util.*;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Serrure;
import fr.insarouen.asi.prog.asiaventure.elements.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsSame;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TestMonstre {
    private Monstre monstre;
    private Monde monde;
    private Piece piece,piece2,piece3;
    private Porte porte,porteFermee;
    private Serrure serrure;

    @Before
    public void avantTest() throws Exception{
        monde = new Monde("Monde");
        piece = new Piece("piece",monde);
        piece2 = new Piece("piece2",monde);
        piece3 = new Piece("piece3",monde);
        serrure = new Serrure("serrure",monde);
        monstre = new Monstre("Monstre",monde,20,20,piece);
        porte = new Porte("porte",monde,piece,piece2);
        porteFermee = new Porte("porteFermee",monde,serrure,piece2,piece3);
    }

    
}
