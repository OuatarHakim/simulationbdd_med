package BDD;

public class BDD {
    public static void main(String[] args){
    Requete rq = new Requete();
    System.out.println(rq.nextPoisson(1));

    System.out.println("Liste des arrivants  : \n" +rq.arrivant(20 , 1));
    rq.envoie(rq.arrivant(20 , 1), 0.25, 0.5, 0.25);
    }

    }
