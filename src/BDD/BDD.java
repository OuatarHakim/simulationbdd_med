package BDD;

import java.util.ArrayList;

public class BDD {
    public static void main(String[] args){
    Requete rq = new Requete();
    System.out.println(rq.nextPoisson(1));

        ArrayList arrivants  = rq.arrivant(20 , 1);
        System.out.println("Liste des arrivants : "+arrivants );
   ArrayList serveurs =  rq.envoie(arrivants, 0.25, 0.5, 0.25);

    }

    }
