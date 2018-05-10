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
    private static ArrayList<Funcionario> funcionarios;
    private static String nome;

    private Empresa() {
    }

    public static synchronized Empresa getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Empresa();
            nome = "Sem Nome Definido";
        }

        return uniqueInstance;

    }

    public static String alteraNomeEmpresa(String nome) {
        Empresa.nome = nome;
        return "Nome alterado com Sucesso.";
    }

    private static Funcionario buscaFuncionario(String cpf) {
        for (Funcionario f : funcionarios) {
            if (f.getCPF().equals(cpf)) {
                return f;
            }
        }
        return null;
    }

    public static String addFuncionario(String nome, String cpf) {
        Funcionario f = buscaFuncionario(cpf);
        String output = null;

        if (f == null) {
            funcionarios.add(new Funcionario(nome, cpf));
            output = "Funcinário Adicionado com Sucesso!";
        } else {
            output = "Funcionário NÃO Adicionado. CPF já existente!";
        }
        return output;
    }

    public static String removeFuncionario(String cpf) {
        Funcionario f = buscaFuncionario(cpf);
        String output = null;

        if (f != null) {
            funcionarios.remove(f);
            output = "Funcionário Removido com Sucesso!";
        } else {
            output = "Funcionário NÃO Removido. CPF inexistente!";
        }

        return output;
    }

    public static String exibeFrequenciaFuncionarioPorPeriodo(String cpf, String dataInicio, String dataFim) {
        Funcionario f = buscaFuncionario(cpf);
        ArrayList<Frequencia> localFrequencias;
        String output = null;

        if (f != null) {

            localFrequencias = f.buscarFrequenciaPorPeriodo(dataInicio, dataFim);

            if (!localFrequencias.isEmpty()) {
                output += "\t Empresa: " + nome + " \n"
                        + "\t Funcionário: " + f.getNome() + "\n"
                        + "\t------------------------------------------\n"
                        + "\t Data \t Chegada \t Saida \t H Trabalhada \n";

                for (Frequencia freq : localFrequencias) {
                    output += freq.getData()
                            + "\t"
                            + freq.getHoraChegada()
                            + "\t"
                            + freq.getHoraSaida()
                            + "\t"
                            + freq.getDuracao()
                            + "\n";
                }
            } else {
                output = "Funcionário ainda não possui frequência registrada.";
            }
        } else {
            output = "Funcionário não Encontrado. CPF inexistente!";
        }

        return output;

    }

    public static String registraFrequenciaFuncionario(String cpf, String horaChegada, String horaSaida) {
        Funcionario f = buscaFuncionario(cpf);
        String output = null;

        if (f != null) {
            f.addFrequencia(cpf, horaChegada, horaSaida);
            output = "Frequência de Funcionário Registrada com Sucesso";
        } else {
            output = "Frequência de Funcionário NÃO Registrada. CPF inexistente!";
        }

        return output;

    }

    public static String inicializarDados() {   // Implementar
        return "";
    }

}
