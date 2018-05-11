/*
 *  Indicar o tipo de licença aqui.
 */
package Command;

import Façade.Empresa;

/**
 *
 * @author douglas
 */
public class ComandoCriaFuncionario implements Comando {

    private final String nome;

    public ComandoCriaFuncionario(String nome) {
        this.nome = nome;
    }

    @Override
    public String execute() {
        return Empresa.criaFuncionario(nome);
    }

}
