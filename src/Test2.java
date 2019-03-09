import org.apache.commons.lang3.ArrayUtils;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        System.out.println("Test działania programu");


        // teraz moze pobawimy sie troche tymi plikami
        File file = new File("new");

        file.mkdir();

        try {

            PrintWriter pw = new PrintWriter("test.txt");

            pw.println("test działania programu. Pewnie za chwilę okaze się ze to jednak nie działa. najgorsze jest " +
                    "to ze nie ");
            pw.flush();
        } catch ( FileNotFoundException ex) {
            System.err.println("nie mona utworzyc pliku");
        }


        Character.toString('c');

        // Symulator lotto.

        int number;
        int[] numbers = new int[6];
        int[] ranNumb = new int[6];
        boolean torf;

        System.out.println("Lotto ver 1.0");
        Scanner sc = new Scanner(System.in);

        for (int i=0; i<numbers.length;i++) {
            System.out.println("Podaj liczbę z zakresu [1-49]");
            while (!sc.hasNextInt()) {
                System.out.println("Podana wartość nie jest liczbą z zakresu [1-49]");
                sc.next();
                System.out.println("Podaj liczbę z zakresu [1-49]");
            }


            number = sc.nextInt();

            if (ArrayUtils.contains(numbers, number) || (number>=49) || (number<=0)) {
                --i;
            } else {
                numbers[i] = number;
            }

        }

        Arrays.sort(numbers);

        System.out.println("Wybrane przez ciebie liczby to :");
        System.out.println(Arrays.toString(numbers));

        System.out.println("Kule trafiły do komoty losującej. Trwa losowanie liczb");
        System.out.println("Wylosowane liczby to");

        Random rn = new Random();

        for (int i=0; i<10; i++) {
            System.out.println(rn.nextInt(3));
        }


        for (int i=0; i<ranNumb.length; i++) {
            ranNumb[i] = rn.nextInt(49)+1;
        }

        Arrays.sort(ranNumb);
        System.out.println(Arrays.toString(ranNumb));

        int isNum=0;

        for (int i=0; i<ranNumb.length;i++) {
            if (ArrayUtils.contains(numbers,ranNumb[i])) ++isNum;
        }

        System.out.println("Trafiłeś "+isNum+ " liczb.");
    }
}
