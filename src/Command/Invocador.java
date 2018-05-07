/*
 * Indicar o tipo de licença aqui.
 */
package Command;

/**
 *
 * @author douglas
 */
public class Invocador {

    public Invocador() {
    }

    public String executarComando(Comando comando) {
        return comando.execute();
    }
}
