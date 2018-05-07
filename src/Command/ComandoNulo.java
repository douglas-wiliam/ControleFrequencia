/*
 *  Indicar o tipo de licença aqui.
 */
package Command;

import Command.Comando;

/**
 *
 * @author douglas
 */
public class ComandoNulo implements Comando {

    public ComandoNulo() {
    }

    @Override
    public String execute() {
        return "Nenhum Comando Registrado.";
    }

}
