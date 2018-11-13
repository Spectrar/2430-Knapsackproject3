import java.util.ArrayList;
import java.util.Collections;

public class KnapSackApp {

    private ArrayList<Experiment> experiments = new ArrayList();
    private ArrayList<Experiment> knapSack = new ArrayList();
    private int weightLeft=700;
    private int payloadWeight=0;
    private int payloadRating=0;

    public static void main(String[] args) {
        KnapSackApp app = new KnapSackApp();
        app.fillExperiments();

        //fill knapsack by rating
        System.out.println("Add by Rating");
        Collections.sort(app.experiments, new SortbyRating());
        fillKnapSack(app, app.experiments);
        toString(app);

        System.out.println("\n");

        //fill knapsack by weight
        System.out.println("Add by Weight");
        Collections.sort(app.experiments, new SortbyWeight());
        fillKnapSack(app, app.experiments);
        toString(app);

        System.out.println("\n");

        //fill knapsack by rating to weight ratio
        System.out.println("Add by Ratio");
        Collections.sort(app.experiments, new SortbyRatio());
        fillKnapSack(app, app.experiments);
        toString(app);


        //fill knapsack by brute forcing all possible knapsacks and picking best one
        SetGenerator bruteForce = new SetGenerator(app.experiments);
        ArrayList<ArrayList<Experiment>> bruteArrayAll = bruteForce.permutation();
        ArrayList<Experiment> bestArray = new ArrayList<>();
        int bestRating=0;

        for(ArrayList<Experiment> e: bruteArrayAll){
            fillKnapSack(app, e);
            if (bestRating<app.payloadRating){
                bestRating=app.payloadRating;
                bestArray.clear();
                bestArray.addAll(e);

            }
        }

        System.out.println();

        System.out.println("Brute force all");
        fillKnapSack(app, bestArray);
        toString(app);


    }
    //prints results and contents of the knapsack
    private static void toString(KnapSackApp app) {
        System.out.println("Payload Weight: "+app.payloadWeight);
        System.out.println("Payload Rating: "+app.payloadRating);
        System.out.println("Payload Contents:");
        int tempCounter=0;
        for(Experiment e: app.knapSack){
            System.out.println("   "+e.getName());
            tempCounter++;
        }
        System.out.println("TOTAL Experiments: "+tempCounter);
    }
    //fills knapsack with max amount of experiments based on how it was sorted previously
    private static void fillKnapSack(KnapSackApp app, ArrayList<Experiment> list) {
        //reset knapsack values
        app.knapSack.clear();
        app.payloadRating=0;
        app.payloadWeight=0;
        app.weightLeft=700;
        for(Experiment e: list){
            int tempWeight =app.weightLeft;
            //if the amount of weight left is 0 then exit the loop
            if (app.weightLeft == 0)
                break;
            //if adding experiment e leaves the weight left greater then 0 then add it to the knapsack
            if((tempWeight -= e.getWeight())>0){
                app.weightLeft-= e.getWeight();
                app.payloadRating+=e.getRating();
                app.knapSack.add(e);
                app.payloadWeight+=e.getWeight();
            }
        }
    }
    //fills experiment list with possible experiments
    private void fillExperiments(){
        experiments.add(new Experiment(1, "Cloud Patterns", 36, 5));
        experiments.add(new Experiment(2, "Solar Flares", 264, 9));
        experiments.add(new Experiment(3, "Solar Power", 188, 6));
        experiments.add(new Experiment(4, "Binary Stars", 203, 8));
        experiments.add(new Experiment(5, "Relativity", 104, 8));
        experiments.add(new Experiment(6, "Seed Viability", 7, 4));
        experiments.add(new Experiment(7, "Sun Spots", 90, 2));
        experiments.add(new Experiment(8, "Mice Tumors", 65, 8));
        experiments.add(new Experiment(9, "Microgravity Plant Growth", 75, 5));
        experiments.add(new Experiment(10, "Micrometeorites", 170, 9));
        experiments.add(new Experiment(11, "Cosmic Rays", 80, 7));
        experiments.add(new Experiment(12, "Yeast Fermentation", 27, 4));
    }
}
