

import java.util.ArrayList;



public class SetGenerator {
    //tester
 //   public static void main(String[] args) {
//        ArrayList experiments = new ArrayList();
//        experiments.add(new Experiment(1, "Cloud Patterns", 36, 5));
//        experiments.add(new Experiment(2, "Solar Flares", 264, 9));
//        experiments.add(new Experiment(3, "Solar Power", 188, 6));
//        experiments.add(new Experiment(4, "Binary Stars", 203, 8));
//        experiments.add(new Experiment(5, "Relativity", 104, 8));
//        experiments.add(new Experiment(6, "Seed Viability", 7, 4));
//        experiments.add(new Experiment(7, "Sun Spots", 90, 2));
//        experiments.add(new Experiment(8, "Mice Tumors", 65, 8));
//        experiments.add(new Experiment(9, "Microgravity Plant Growth", 75, 5));
//        experiments.add(new Experiment(10, "Micrometeorites", 170, 9));
//        experiments.add(new Experiment(11, "Cosmic Rays", 80, 7));
//        experiments.add(new Experiment(12, "Yeast Fermentation", 27, 4));
//
//        ArrayList<ArrayList<Experiment>> test = new ArrayList<>();
//
//            SetGenerator temp = new SetGenerator(experiments);
//            test.addAll(temp.permutation());
//
//
//        System.out.println(test.size());
//    }

    private ArrayList<Experiment> list;
    private int n;
    private int i;

    // generates all possible subsets of a set
    public SetGenerator(ArrayList<Experiment> list) {
        this.list = list;
        n = list.size();
        i = 0;
    }




    public ArrayList<ArrayList<Experiment>> permutation() {
        ArrayList<ArrayList<Experiment>> arrayGroup = new ArrayList<>();


        for (int i = 0; i < (1<<n); i++)
        {
            ArrayList<Experiment> temp = new ArrayList<>();


            for (int j = 0; j < n; j++) {


                if ((i & (1 << j)) > 0)
                    temp.add(list.get(j));
            }

            arrayGroup.add(temp);
        }

        return arrayGroup;

    }
}