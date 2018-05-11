/*
 * Indicar o tipo de licença aqui
 */
package Bussiness;

import java.time.LocalDate;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author douglas
 */
public class Funcionario {

    private final String nome;
    private final String cpf;
    private ArrayList<Frequencia> frequencias;

    public Funcionario(String nome, String cpf) {
        frequencias = new ArrayList<>();
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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        LocalDate localDateInicio = LocalDate.parse(dataInicio, dtf);
        LocalDate localDateFim = LocalDate.parse(dataFim, dtf);
        LocalDate localDateFrequencia;

        for (Frequencia f : frequencias) {
            localDateFrequencia = LocalDate.parse(f.getData(), dtf);

            if (localDateFrequencia.isAfter(localDateInicio) && localDateFrequencia.isBefore(localDateFim)) {
                localFrequencias.add(f);
            }

        }
        return localFrequencias;
    }

    public String somarTotalHorasTrabalhadasPorPeriodo(String dataInicio, String dataFim) {
        long horas = 0;
        long minutos = 0;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate localDateInicio = LocalDate.parse(dataInicio, dtf);
        LocalDate localDateFim = LocalDate.parse(dataFim, dtf);
        LocalDate localDateFrequencia;

        for (Frequencia f : frequencias) {
            localDateFrequencia = LocalDate.parse(f.getData(), dtf);

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
