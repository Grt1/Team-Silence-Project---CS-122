public class Exercise {
    private String exercise;
    private int hours;
    private int intensity; //Should be a number 1-10
    
    public Exercise(String exercise, int hours, int intensity){
        this.exercise = exercise;
        this.hours = hours;
        this.intensity = intensity;
    }

    public String getExercise(){
        return exercise;
    }
    public int getHours(){
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
