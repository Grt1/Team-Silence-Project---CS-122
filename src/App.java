import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class App {
    private static ArrayList<Exercise> exerciseLogs = new ArrayList<>();
    private static JTextArea exerciseLogsArea = new JTextArea();
    private static ArrayList<Hydration> hydrationLogs = new ArrayList<>();
    private static JTextArea logsTextArea = new JTextArea();
    private static ArrayList<Calorie> calorieLogs = new ArrayList<>();
    public static JTextArea calorieLogsArea = new JTextArea();
    public static int totalCalories = 0;

    private static ArrayList<FitnessTracker> FitnessTrackerLogs = new ArrayList<>();
    private static JTextArea FitnessTrackerTextArea = new JTextArea();

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Team Silence - Fitness Tracker");
        JPanel panel = new JPanel();
        JButton exerciseButton = new JButton("Log Workout");
        JButton hydrationButton = new JButton("Log Hydration");
        JButton FitnessTrackerButton = new JButton("Log Goals");
        
        JLabel messageLabel = new JLabel("Welcome to Team Silence - Fitness Tracker!");
        panel.add(messageLabel); // Adding the label to the panel

        panel.add(new JLabel("Choose an activity to log"));
        panel.add(exerciseButton);
        panel.add(hydrationButton);
        //panel.add(FitnessTrackerButton);
        JButton Calories = new JButton("Calories");

        panel.add(Calories);
        mainFrame.add(panel);
        mainFrame.setSize(300, 200); // Increased height to accommodate the label
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        exerciseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showExerciseLogDialog();
            }
        });

        hydrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showHydrationLogDialog();
            }
        });

        FitnessTrackerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showFitnessTrackerLogDialog();
            }
        });

        logsTextArea.setEditable(false);
        logsTextArea.setLineWrap(true);
        logsTextArea.setWrapStyleWord(true);
        panel.add(logsTextArea);
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

        exerciseLogsArea.setEditable(false);
        exerciseLogsArea.setLineWrap(true);
        exerciseLogsArea.setWrapStyleWord(true);
        calorieLogsArea.setEditable(false);
        calorieLogsArea.setLineWrap(true);
        calorieLogsArea.setWrapStyleWord(true);
        panel.add(exerciseLogsArea);
        panel.add(calorieLogsArea);
    }

    private static void showExerciseLogDialog() {
        JFrame exerciseFrame = new JFrame("Log Workout");
        JPanel panel = new JPanel();
        JTextField nameField = new JTextField(20);
        JTextField hoursField = new JTextField(20);
        JTextField intensityField = new JTextField(20);
        JButton submitButton = new JButton("Submit");

        panel.add(new JLabel("Enter the name of the workout:"));
        panel.add(nameField);
        panel.add(new JLabel("Enter the length in hours:"));
        panel.add(hoursField);
        panel.add(new JLabel("Enter the intensity (1-10):"));
        panel.add(intensityField);
        panel.add(submitButton);
        panel.add(logsTextArea);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                double hours = Double.parseDouble(hoursField.getText());
                int intensity = Integer.parseInt(intensityField.getText());
                Exercise exercise = new Exercise(name, hours, intensity);
                exerciseLogs.add(exercise);
                updateDisplayPanel();
                exerciseFrame.dispose();
            }
        });

        exerciseFrame.add(panel);
        exerciseFrame.setSize(400, 300);
        exerciseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        exerciseFrame.setVisible(true);
        
    }   

    private static void showHydrationLogDialog() {
        JFrame hydrationFrame = new JFrame("Log Hydration");
        JPanel panel = new JPanel();
        JTextField beverageField = new JTextField(20);
        JTextField ouncesField = new JTextField(20);
        JButton submitButton = new JButton("Submit");

        panel.add(new JLabel("Enter the beverage:"));
        panel.add(beverageField);
        panel.add(new JLabel("Enter the amount in ounces:"));
        panel.add(ouncesField);
        panel.add(submitButton);
        panel.add(logsTextArea);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String beverage = beverageField.getText();
                double ounces = Double.parseDouble(ouncesField.getText());
                Hydration hydration = new Hydration(beverage, ounces);
                hydrationLogs.add(hydration);
                updateDisplayPanel();
                hydrationFrame.dispose();
            }
        });

        hydrationFrame.add(panel);
        hydrationFrame.setSize(400, 300);
        hydrationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        hydrationFrame.setVisible(true);
    }

    private static void showFitnessTrackerLogDialog() {
        JFrame FitnessTrackerFrame = new JFrame("Log Goals");
        JPanel panel = new JPanel();
        JTextField GoalField = new JTextField(20);
        JTextField ProgressField = new JTextField(20);
        JButton submitButton = new JButton("Submit");

        panel.add(new JLabel("Enter Your goals:"));
        panel.add(GoalField);
        panel.add(new JLabel("Enter Your current progress:"));
        panel.add(ProgressField);
        panel.add(submitButton);
        panel.add(logsTextArea);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Goal = GoalField.getText();
                double progress = Double.parseDouble(ProgressField.getText());
                FitnessTracker goal = new FitnessTracker(Goal);
                FitnessTrackerLogs.add(goal);
                updateDisplayPanel();
                FitnessTrackerFrame.dispose();
            }
        });

        FitnessTrackerFrame.add(panel);
        FitnessTrackerFrame.setSize(400, 300);
        FitnessTrackerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        FitnessTrackerFrame.setVisible(true);

        FitnessTrackerTextArea.setEditable(false);
        FitnessTrackerTextArea.setLineWrap(true);
        FitnessTrackerTextArea.setWrapStyleWord(true);
        FitnessTrackerTextArea.setEditable(false);
        FitnessTrackerTextArea.setLineWrap(true);
        FitnessTrackerTextArea.setWrapStyleWord(true);
        panel.add(FitnessTrackerTextArea);
    }

    private static void updateDisplayPanel() {
        logsTextArea.setText("");
        for (Exercise exercise : exerciseLogs) {
            logsTextArea.append(exercise.toString() + "\n");
        }
        for (Hydration hydration : hydrationLogs) {
            logsTextArea.append(hydration.toString() + "\n");
        }
        calorieLogsArea.setText(""); 
        for (Calorie calorie : calorieLogs) {
            calorieLogsArea.append(calorie.toString() + "\n");
        }
        calorieLogsArea.append("Total: " + totalCalories);
    }

}
