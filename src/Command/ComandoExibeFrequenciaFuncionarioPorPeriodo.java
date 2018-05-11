/*
 *  Indicar o tipo de licença aqui.
 */
package Command;

import Façade.Empresa;

/**
 *
 * @author douglas
 */
public class ComandoExibeFrequenciaFuncionarioPorPeriodo implements Comando {

    private final String dataInicio;
    private final String dataFim;

    public ComandoExibeFrequenciaFuncionarioPorPeriodo(String dataInicio, String dataFim) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    @Override
    public String execute() {
        return Empresa.exibeFrequenciaFuncionarioPorPeriodo(dataInicio, dataFim);
    }

}
