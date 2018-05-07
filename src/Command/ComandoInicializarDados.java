/*
 * Indicar o tipo de licença aqui.
 */
package Command;

import Command.Comando;
import Façade.Empresa;

/**
 *
 * @author douglas
 */
public class ComandoInicializarDados implements Comando {

    public ComandoInicializarDados() {
    }

    @Override
    public String execute() {
       return Empresa.inicializarDados();
    }
    
}
