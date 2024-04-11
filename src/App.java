import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.StyleConstants;

import java.util.*;
import java.io.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private ArrayList<String> logs = new ArrayList<String>();
    private static int choice;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);


        JFrame mainFrame = new JFrame("Team Silence - Fitness Tracker");
        JFrame exerciseFrame = new JFrame("Workouts");
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JTextField txt = new JTextField();
        JTextField ExerciseTxt = new JTextField();
        JButton Exercise = new JButton();
        JButton Calorie = new JButton();
        JButton Goals = new JButton();
        JButton Hydration = new JButton();

        txt.setText("Choose an activity to log");
        txt.setHorizontalAlignment(JTextField.CENTER);
        txt.setSize(300, 60);
        txt.setLocation(0, 0);
        txt.setVisible(true);

        Exercise.setText("Workout");
        Exercise.setSize(100, 60);
        Exercise.setLocation(100, 80);
        Exercise.setVisible(true);

        ExerciseTxt.setText("Enter the name of the workout, the length in hours, and the intensity (1-10).");
        ExerciseTxt.setAlignmentY(JTextField.TOP_ALIGNMENT);
        ExerciseTxt.setSize(300, 60);
        ExerciseTxt.setLocation(0, 0);
        ExerciseTxt.setVisible(true);


        Exercise.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setChoice(1);
                panel1.add(ExerciseTxt);
                exerciseFrame.add(ExerciseTxt);                
                exerciseFrame.add(panel1);
                exerciseFrame.setSize(300, 450);
                exerciseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                exerciseFrame.setVisible(true);
            }
        });


        panel.add(txt);
        panel.add(Exercise);
        mainFrame.add(txt);
        mainFrame.add(Exercise);
        mainFrame.add(panel);
        mainFrame.setSize(300, 450);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);



        int choice = 0;
        if (choice == 1){
            while (true) {
            String input1 = sc.nextLine();
            int input2 = sc.nextInt();
            int input3 = sc.nextInt();
            try{
                Exercise entry = new Exercise(input1, input2, input3);
            } catch(Exception e){
                System.out.print("Invalid entry for the most recent log. Please try again.");
                System.out.println("Please log you exercise in this format 'name, time(in hours), intensity(1-10)': ");
            }
                
        }
        } else if (choice == 2){

        } else if (choice == 3){

        }


        sc.close();
    }   
    public ArrayList<String> getLogs(){
        return logs;
    }

    public static void setChoice(int a){
        choice = a;
    }

}

