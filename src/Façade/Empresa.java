/*
 * Indicar o tipo de licença aqui
 */
package Façade;

import Bussiness.Frequencia;
import Bussiness.Funcionario;
import java.util.ArrayList;

/**
 *
 * @author douglas
 */
public class Empresa {

    private static Empresa uniqueInstance;
    private static String nome;
    private static Funcionario funcionario;

    private Empresa() {
    }

    public static synchronized Empresa getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Empresa();
            nome = "Sem Nome Definido";
            funcionario = null;
        }
        return uniqueInstance;
    }

    public static String alteraNomeEmpresa(String nome) {
        Empresa.nome = nome;
        return "Nome alterado com Sucesso.";
    }

    public static String criaFuncionario(String nome) {
        String output = null;

        if (nome.length() != 0) {
            funcionario = new Funcionario(nome);
            output = "Funcionário criado com Sucesso.";
        } else {
            output = "Funcionário NÃO foi criado.";
        }

        return output;
    }

    public static String registraFrequenciaFuncionario(String data, String horaChegada, String horaSaida) {
        String output = null;

        if (funcionario != null) {
            funcionario.addFrequencia(data, horaChegada, horaSaida);
            output = "Frequência Registrada com Sucesso";
        } else {
            output = "Frequência NÃO Registrada.";
        }

        return output;

    }

    public static String exibeFrequenciaFuncionarioPorPeriodo(String dataInicio, String dataFim) {
        ArrayList<Frequencia> localFrequencias;
        String output = null;

        if (funcionario != null) {

            localFrequencias = funcionario.buscarFrequenciaPorPeriodo(dataInicio, dataFim);

            if (!localFrequencias.isEmpty()) {
                output += "\t Empresa: " + nome + " \n"
                        + "\t Funcionário: " + funcionario.getNome() + "\n"
                        + "\t------------------------------------------\n"
                        + "\t Data \t Chegada \t Saida \t H Trabalhada \n";

                for (Frequencia freq : localFrequencias) {
                    output += "\t"
                            + freq.getData()
                            + "\t"
                            + freq.getHoraChegada()
                            + "\t"
                            + freq.getHoraSaida()
                            + "\t"
                            + freq.getDuracao()
                            + "\n";
                }

                output += "\t Total de Horas: " + funcionario.somarTotalHorasTrabalhadasPorPeriodo(dataInicio, dataFim) + "\n";
            } else {
                output = "Funcionário ainda não possui frequência registrada.";
            }
        } else {
            output = "Funcionário não Encontrado. CPF inexistente!";
        }

        return output;

    }
}
