import java.util.Comparator;

public class Experiment {
    private int number;
    private String name;
    private int weight;
    private int rating;

    public Experiment(int number, String name, int weight, int rating) {
        this.number = number;
        this.name = name;
        this.weight = weight;
        this.rating = rating;
    }
    //Experiment Number
    public int getNumber() {
        return number;
    }
    //experiment Name
    public String getName() {
        return name;
    }
    //Experiment Weight
    public int getWeight() {
        return weight;
    }
    //Experiment Rating
    public int getRating() {
        return rating;
    }
}

//Used to sort Experiments from least to greatest by weight
class SortbyWeight implements Comparator<Experiment>{

    @Override
    public int compare(Experiment o1, Experiment o2) {
        return o1.getWeight()-o2.getWeight();
    }
}

//Used to sort experiments from greatest to least by rating, if rating is the same
//then the experiment is sorted least to greatest by weight
class SortbyRating implements Comparator<Experiment>{

    @Override
    public int compare(Experiment o1, Experiment o2) {
        if(o1.getRating()-o2.getRating()>0 || o1.getRating()-o2.getRating()<0) {
            return o2.getRating() - o1.getRating();
        }else{
            return o1.getWeight()-o2.getWeight();
        }
    }
}

//Used to sort Experiments from greatest to least based on rating to weight ratio
class SortbyRatio implements Comparator<Experiment>{

    @Override
    public int compare(Experiment o1, Experiment o2) {
        return (o2.getRating()/o2.getWeight())-(o1.getRating()/o1.getWeight());
    }
}