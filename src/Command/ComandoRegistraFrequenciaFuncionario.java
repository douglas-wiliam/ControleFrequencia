/*
 *  Indicar o tipo de licença aqui.
 */
package Command;

import Façade.Empresa;

/**
 *
 * @author douglas
 */
public class ComandoRegistraFrequenciaFuncionario implements Comando {

    private final String data;
    private final String horaChegada;
    private final String horaSaida;

    public ComandoRegistraFrequenciaFuncionario(String data, String horaChegada, String horaSaida) {
        this.data = data;
        this.horaChegada = horaChegada;
        this.horaSaida = horaSaida;
    }

    @Override
    public String execute() {
        return Empresa.registraFrequenciaFuncionario(data, horaChegada, horaSaida);
    }

}
