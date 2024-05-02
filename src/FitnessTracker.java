import java.util.Random;

public class FitnessTracker {
    private String goal;
    private double currentProgress;
    private boolean goalAchieved;

    public FitnessTracker(String goal) {
        this.goal = goal;
        this.currentProgress = 0.0;
        this.goalAchieved = false;
    }

    public void updateProgress(double progress) {
        this.currentProgress += progress;
        if (this.currentProgress >= 100.0) {
            this.goalAchieved = true;
        }
    }

    public String getProgressUpdate(){
        if (goalAchieved) {
            return "Congratulations! you did it! you achieved your goal of " + goal + "!";
        } else {
            return "You are " + currentProgress + "% closer to your goal of " + goal + ".";
        }
    }

    public String getMotivationalMessage() {
        String[] messages = {
            "Keep going! You're doing great!",
            "Every step gets you closer to your goal!",
            "Don't give up! You're stronger than you think!",
            "Believe in yourself! You can do it!"
        };
        Random rand = new Random();
        return messages[rand.nextInt(messages.length)];
    }
    
}


