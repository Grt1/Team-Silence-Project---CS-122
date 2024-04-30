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
    //See if this works
    // Example usage
    public static void main(String[] args) {
        FitnessTracker tracker = new FitnessTracker("Weight loss");
        System.out.println(tracker.getProgressUpdate()); // Initial progress update
        System.out.println(tracker.getMotivationalMessage()); // Initial motivational message
        
        // Update progress (e.g., after a workout)
        tracker.updateProgress(20.0);
        System.out.println(tracker.getProgressUpdate()); // Progress update after workout
        System.out.println(tracker.getMotivationalMessage()); // Motivational message after workout
        
        // Assuming goal is achieved (for demonstration)
        tracker.updateProgress(100.0); // Set progress to 100%
        System.out.println(tracker.getProgressUpdate()); // Final progress update
        System.out.println(tracker.getMotivationalMessage()); // Final motivational message
    }
}


