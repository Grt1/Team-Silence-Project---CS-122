import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class App {
    private static ArrayList<Exercise> logs = new ArrayList<>();
    public static JTextArea exerciseLogs = new JTextArea();

    private static ArrayList<Calorie> calorieLogs = new ArrayList<>();
    public static JTextArea calorieLogsArea = new JTextArea();
    public static int totalCalories = 0;

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Team Silence - Fitness Tracker");
        JPanel panel = new JPanel();
        JButton Exercise = new JButton("Workout");
        JButton Calories = new JButton("Calories");

        panel.add(new JLabel("Choose an activity to log"));
        panel.add(Exercise);
        panel.add(Calories);
        mainFrame.add(panel);
        mainFrame.setSize(300, 150);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        Exercise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame exerciseFrame = new JFrame("Workouts");
                JPanel panel1 = new JPanel();
                JTextField ExerciseInputName = new JTextField(20);
                JTextField ExerciceInputHours = new JTextField(20);
                JTextField ExerciseInputIntensity = new JTextField(20);
                JButton submitExercise = new JButton("Submit");
                
                Box.Filler filler = new Box.Filler(new Dimension(0, 0), new Dimension(0, 40), new Dimension(200, 40));
                panel.add(filler);
                panel1.add(new JLabel("Enter the name of the workout:"));
                panel1.add(ExerciseInputName);
                panel1.add(new JLabel("Enter the length in hours:"));
                panel1.add(ExerciceInputHours);
                panel1.add(new JLabel("Enter the intensity (1-10):"));
                panel1.add(ExerciseInputIntensity);
                panel1.add(submitExercise);
                panel1.add(exerciseLogs);

                submitExercise.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String name = ExerciseInputName.getText();
                        double hours = Double.parseDouble(ExerciceInputHours.getText());
                        int intensity = Integer.parseInt(ExerciseInputIntensity.getText());
                        Exercise exercise = new Exercise(name, hours, intensity);
                        logs.add(exercise);
                        updateDisplayPanel();
                    }
                });

                exerciseFrame.add(panel1);
                exerciseFrame.setSize(400, 300);
                exerciseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                exerciseFrame.setVisible(true);
            }
        });

        Calories.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame exerciseFrame = new JFrame("Calories");
                JPanel panel1 = new JPanel();
                JTextField ExerciceInputHours = new JTextField(20);
                JTextField ExerciseInputIntensity = new JTextField(20);
                JButton submitExercise = new JButton("Submit");
                
                Box.Filler filler = new Box.Filler(new Dimension(0, 0), new Dimension(0, 40), new Dimension(200, 40));
                panel.add(filler);
                panel1.add(new JLabel("Enter the amount of calories gained:"));
                panel1.add(ExerciceInputHours);
                panel1.add(new JLabel("Enter the amount of calories spent:"));
                panel1.add(ExerciseInputIntensity);
                panel1.add(submitExercise);
                panel1.add(calorieLogsArea);

                submitExercise.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int gained = Integer.parseInt(ExerciceInputHours.getText());
                        int spent = Integer.parseInt(ExerciseInputIntensity.getText());
                        Calorie calorie = new Calorie(gained, spent);
                        totalCalories += calorie.getTotalCalories();
                        calorieLogs.add(calorie);
                        updateDisplayPanel();
                    }
                });

                exerciseFrame.add(panel1);
                exerciseFrame.setSize(400, 300);
                exerciseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                exerciseFrame.setVisible(true);
            }
        });

        exerciseLogs.setEditable(false);
        exerciseLogs.setLineWrap(true);
        exerciseLogs.setWrapStyleWord(true);
        calorieLogsArea.setEditable(false);
        calorieLogsArea.setLineWrap(true);
        calorieLogsArea.setWrapStyleWord(true);
        panel.add(exerciseLogs);
        panel.add(calorieLogsArea);
    }
    public ArrayList<Exercise> getLogs(){
        return logs;
    }

    private static void updateDisplayPanel() {
        exerciseLogs.setText(""); 
        for (Exercise exercise : logs) {
            exerciseLogs.append(exercise.toString() + "\n");
        }
        calorieLogsArea.setText(""); 
        for (Calorie calorie : calorieLogs) {
            calorieLogsArea.append(calorie.toString() + "\n");
        }
        calorieLogsArea.append("Total: " + totalCalories);
    }

}