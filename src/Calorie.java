public class Calorie {
    private int gained;
    private int spent;
    private int total;
    
    public Calorie(int gained, int spent) {
        this.gained = gained;
        this.spent = spent;
        this.total = gained - spent;
    }

    public int getGainedCalories() {
        return gained;
    }

    public int getSpentCalories() {
        return spent;
    }

    public int getTotalCalories() {
        return total;
    }

    @Override
    public String toString(){
        return gained + ", " + spent + ", " + total;
    }
}