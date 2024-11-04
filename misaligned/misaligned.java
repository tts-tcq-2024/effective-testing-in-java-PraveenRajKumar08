import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Misaligned {
    static int printColorMap() {
        String majorColors[] = {"White", "Red", "Black", "Yellow", "Violet"};
        String minorColors[] = {"Blue", "Orange", "Green", "Brown", "Slate"};
        int i = 0, j = 0;
        for(i = 0; i < 5; i++) {
            for(j = 0; j < 5; j++) {
                System.out.printf("%d | %s | %s\n", i * 5 + j, majorColors[i], minorColors[i]);
            }
        }
        return i * j;
    }
    public static void main(String[] args) { 
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        int result = printColorMap();
        assert(result == 25);
        System.setOut(originalOut);
        String output = outputStream.toString();
        String expectedOutput = "0 | White | Blue\n"
                                + "1 | White | Orange\n"
                                + "2 | White | Green\n"
                                + "3 | White | Brown\n"
                                + "4 | White | Slate\n"
                                + "5 | Red | Blue\n"
                                + "6 | Red | Orange\n"
                                + "7 | Red | Green\n"
                                + "8 | Red | Brown\n"
                                + "9 | Red | Slate\n"
                                + "10 | Black | Blue\n"
                                + "11 | Black | Orange\n"
                                + "12 | Black | Green\n"
                                + "13 | Black | Brown\n"
                                + "14 | Black | Slate\n"
                                + "15 | Yellow | Blue\n"
                                + "16 | Yellow | Orange\n"
                                + "17 | Yellow | Green\n"
                                + "18 | Yellow | Brown\n"
                                + "19 | Yellow | Slate\n"
                                + "20 | Violet | Blue\n"
                                + "21 | Violet | Orange\n"
                                + "22 | Violet | Green\n"
                                + "23 | Violet | Brown\n"
                                + "24 | Violet | Slate\n";
        assert output.equals(expectedOutput);
        System.out.println("All is well (maybe!)");
    }
}
