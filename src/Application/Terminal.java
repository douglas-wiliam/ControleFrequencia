package Application;

import Façade.Empresa;
import java.util.Scanner;

/*
 * Indicar o tipo de licença aqui.
 */
/**
 *
 * @author douglas
 */
public class Terminal {

    private static String[] getInputTeclado() {
        String input;
        String[] tokens;
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();

        tokens = input.split(" ");

        return tokens;

    }

    public static void main(String[] args) {

        Empresa.getInstance();

        GUI gui = new GUI();
        gui.setVisible(true);
    }

}
