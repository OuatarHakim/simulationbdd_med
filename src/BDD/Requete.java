package BDD;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class Requete {
    Random rand = new Random();

    int nextPoisson(double lambda) {
        double elambda = Math.exp(-1*lambda);
        double product = 1;
        int count =  0;
        do {
            product *= rand.nextDouble();
            count++ ;
        } while( product >= elambda ) ;
        return count;
    }
    public double poisson(double d , double lambda) {
        Random random = new Random();
        double x = 0;
        double p = Math.exp(-lambda);
        double s = p;
        double u = random.nextDouble();
        while (u > s) {
            x = x + 1;
            p = p * lambda / x;
            s = s + p;
        }
        return x;
    }

    public ArrayList<Double> arrivant(int periode , double lambda  ) {
        double nb_naissance = 0 ;
       ArrayList naissance = new ArrayList<Double>() ;
        double a = 0 ;

        Random rand = new Random();
        double alea = 0 ;
        while(nb_naissance <= periode) {
            alea = rand.nextDouble() ;
            a += poisson(alea, lambda) ;
            naissance.add(a) ;
            nb_naissance ++ ;
        }
        return naissance ;

    }



    public ArrayList<Double> service(int periode , double mu ) {
        ArrayList<Double> service = new ArrayList<Double>() ;
        double temps =  0 ;
        for(int i = 0 ; i<= periode; i++) {
            temps += expo( mu)  ;
            service.add(temps) ;
        }
        return service ;

    }

    public ArrayList envoie(ArrayList arrivants ,  double p1, double p2 , double p3){
        ArrayList serveur1= new ArrayList();
        ArrayList serveur2= new ArrayList();
        ArrayList serveur3= new ArrayList();

        ArrayList serveurs = new ArrayList();


for (int i = 0 ; i < arrivants.size();i++) {
    double poba = new Random().nextDouble();
    double res = Math.round(poba * 100.0) / 100.0;
    if (res <= p1) {
        System.out.println("Serveur 1");
        serveur1.add("Client n° ="+ arrivants.get(i)+" "+service(1, 0.5)+"\n");
        //System.out.println(serveur1);

    } else if (res <= p1 + p2) {
        System.out.println("Serveur 2");
        serveur2.add("Client n° ="+ arrivants.get(i)+" "+service(1, 0.5)+"\n");
      //  System.out.println(serveur2);

    } else if (res <= p1 + p2 + p3) {
        System.out.println("Serveur 3");
        serveur3.add("Client n° ="+ arrivants.get(i)+" "+service(1, 0.5)+"\n");
    }
}

     //   System.out.println("Serveur 1" +serveur1);
      //  System.out.println("Serveur 2" +serveur2);
      //  System.out.println("Serveur 3" +serveur3);


        serveurs.add( "Serveur 1 "+serveur1+"\n Serveur 2 "+ serveur2 + "\nServeur 3" +serveur3);
        System.out.println(serveurs);

        return serveurs ;

    }

   // public ArrayList sortie(ArrayList serveur , )


  /* public ArrayList cordinateur(ArrayList<Double> arrivants){
        ArrayList<Double> serveurs = new ArrayList<Double>() ;

        for (int i = 0 ; i < arrivants.size(); i++){

            arrivants.get(i)
        }

    }*/


    public double expo( double lambda) {
        Random rand = new Random();
        double y   = rand.nextDouble() ;
        return -(Math.log(1-y)/lambda);
    }
/*
    public ArrayList serveurs(int nb){
        ArrayList serveurs = new ArrayList() ;
        for (int i =0  ; i<= nb; i++ )
        serveurs.add();


    }
    */


}
