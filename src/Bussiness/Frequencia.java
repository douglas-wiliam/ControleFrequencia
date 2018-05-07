package Bussiness;

import java.time.LocalTime;
import java.time.Duration;

/*
 * Indicar o tipo de licença aqui.
 */
/**
 *
 * @author douglas
 */
public class Frequencia {

    private final String data;
    private final String horaChegada;
    private final String horaSaida;
    private final String duracao;
    private long horas;
    private long minutos;

    public Frequencia(String data, String horaChegada, String horaSaida) {
        this.data = data;
        this.horaChegada = horaChegada;
        this.horaSaida = horaSaida;
        duracao = calcularHoraTrabalhada();
    }

    private String calcularHoraTrabalhada() {
        long total;

        LocalTime localHoraChegada = LocalTime.parse(horaChegada);
        LocalTime localHoraSaida = LocalTime.parse(horaSaida);

        total = Duration.between(localHoraChegada, localHoraSaida).toMinutes();
        horas = total / 60;
        minutos = total % 60;

        return Long.toString(horas) + ":" + Long.toString(minutos);
    }

    public String getData() {
        return data;
    }

    public String getHoraChegada() {
        return horaChegada;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public String getDuracao() {
        return duracao;
    }

    public long getHoras() {
        return horas;
    }

    public long getMinutos() {
        return minutos;
    }
}
