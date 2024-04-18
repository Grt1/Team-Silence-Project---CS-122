public class Exercise {
    private String exercise;
    private double hours;
    private int intensity;
    
    public Exercise(String exercise, double hours, int intensity){
        this.exercise = exercise;
        this.hours = hours;
        this.intensity = intensity;
    }

    public String getExercise(){
        return exercise;
    }
    public double getHours(){
        return hours;
    }

    public int getIntensity(){
        return intensity;
    }

    @Override
    public String toString(){
        return exercise + ", " + hours + ", " + intensity;
    }

}
