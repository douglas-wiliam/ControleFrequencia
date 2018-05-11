/*
 *  Indicar o tipo de licença aqui.
 */
package Command;

import Bussiness.Funcionario;
import Façade.Empresa;

/**
 *
 * @author douglas
 */
public class ComandoRegistraFrequenciaFuncionario implements Comando {

    private final Funcionario funcionario;
    private final String data;
    private final String horaChegada;
    private final String horaSaida;

    public ComandoRegistraFrequenciaFuncionario(Funcionario funcionario, String data, String horaChegada, String horaSaida) {
        this.funcionario = funcionario;
        this.data = data;
        this.horaChegada = horaChegada;
        this.horaSaida = horaSaida;
    }

    @Override
    public String execute() {
        return Empresa.registraFrequenciaFuncionario(funcionario, data, horaChegada, horaSaida);
    }

}
