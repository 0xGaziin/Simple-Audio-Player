import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String audioPath = "src\\Your Audio Here.wav"; // - You need to put the audio path here.
        File file = new File(audioPath); // Object for file's manipulation.

        try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
             Scanner scanner = new Scanner(System.in)) {

            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            String userOptionSelected = "";

            while (!userOptionSelected.equals("Q")) {
                System.out.println("P = Play");
                System.out.println("S = Stop");
                System.out.println("R = Reset");
                System.out.println("Q = Quit");

                System.out.print("Enter your choice: ");
                userOptionSelected = scanner.next().toUpperCase();

                switch (userOptionSelected) {
                    case "P":
                        clip.start();
                        break;
                    case "S":
                        clip.stop();
                        break;
                    case "R":
                        clip.setMicrosecondPosition(0);
                        break;
                    case "Q":
                        clip.close();
                        break;
                    default:
                        System.out.println("Not a valid response.");
                }
            }

        } catch (UnsupportedAudioFileException e) {
            System.out.println("Audio file is not supported.");
        } catch (LineUnavailableException e) {
            System.out.println("Unable to access audio resource.");
        } catch (IOException e) {
            System.out.println("Something went wrong.");
        }
    }
}
