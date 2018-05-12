package Application;

import Façade.Empresa;

/*
 * Indicar o tipo de licença aqui.
 */
/**
 *
 * @author douglas
 */
public class Terminal {

    public static void main(String[] args) {

        Empresa.getInstance();

        //GUI gui = new GUI();
        //gui.setVisible(true);
        GUI_EdicaoVisual gui = new GUI_EdicaoVisual();
        gui.setVisible(true);
    }

}
