/*
 *  Indicar o tipo de licença aqui.
 */
package Command;

import Façade.Empresa;

/**
 *
 * @author douglas
 */
public class ComandoAlterarNomeEmpresa implements Comando {

    private final String nome;
    
    public ComandoAlterarNomeEmpresa(String nome) {
        this.nome = nome;
    }

    @Override
    public String execute() {
        return Empresa.alteraNomeEmpresa(nome);
    }

}
