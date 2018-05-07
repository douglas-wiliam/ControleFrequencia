/*
 * Indicar o tipo de licença aqui
 */
package Bussiness;

import java.util.ArrayList;
import java.time.LocalDateTime;

/**
 *
 * @author douglas
 */
public class Funcionario {

    private final String nome;
    private final String cpf;
    private ArrayList<Frequencia> frequencias;

    public Funcionario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return cpf;
    }

    public void addFrequencia(String data, String horaChegada, String horaSaida) {
        frequencias.add(new Frequencia(data, horaChegada, horaSaida));
    }

    public ArrayList<Frequencia> buscarFrequenciaPorPeriodo(String dataInicio, String dataFim) {
        ArrayList<Frequencia> localFrequencias = new ArrayList<>();

        LocalDateTime localDateInicio = LocalDateTime.parse(dataInicio);
        LocalDateTime localDateFim = LocalDateTime.parse(dataFim);
        LocalDateTime localDateFrequencia;

        for (Frequencia f : frequencias) {
            localDateFrequencia = LocalDateTime.parse(f.getData());

            if (localDateFrequencia.isAfter(localDateInicio) && localDateFrequencia.isBefore(localDateFim)) {
                localFrequencias.add(f);
            }

        }
        return localFrequencias;
    }

    public String somarTotalHorasTrabalhadasPorPeriodo(String dataInicio, String dataFim) {
        long horas = 0;
        long minutos = 0;

        LocalDateTime localDateInicio = LocalDateTime.parse(dataInicio);
        LocalDateTime localDateFim = LocalDateTime.parse(dataFim);
        LocalDateTime localDateFrequencia;

        for (Frequencia f : frequencias) {
            localDateFrequencia = LocalDateTime.parse(f.getData());

            if (localDateFrequencia.isAfter(localDateInicio) && localDateFrequencia.isBefore(localDateFim)) {
                horas += f.getHoras();
                minutos += f.getMinutos();
            }

        }

        horas += minutos / 60;
        minutos = minutos % 60;

        return Long.toString(horas) + ":" + Long.toString(minutos);
    }
}
