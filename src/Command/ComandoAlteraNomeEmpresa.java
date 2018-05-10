/*
 *  Indicar o tipo de licença aqui.
 */
package Command;

import Façade.Empresa;

/**
 *
 * @author douglas
 */
public class ComandoAlteraNomeEmpresa implements Comando {

    private final String nome;
    
    public ComandoAlteraNomeEmpresa(String nome) {
        this.nome = nome;
    }

    @Override
    public String execute() {
        return Empresa.alteraNomeEmpresa(nome);
    }

}
