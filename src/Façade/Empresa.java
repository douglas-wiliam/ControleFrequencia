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
        }

        return uniqueInstance;

    }

    public static String getNome() {
        return nome;
    }
    
    public static void setNome(String nome){
        Empresa.nome = nome;
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
        ArrayList<Frequencia> localFrequencias = new ArrayList<>();
        String output = null;

        if (f != null) {
            localFrequencias = f.buscarFrequenciaPorPeriodo(dataInicio, dataFim);

            output += "\t Empresa: VIVA NATUREZA IND E COM DE PROD NAT LTDA \n"
                    + "\t Funcionário: " + f.getNome() + "\n"
                    + "\t: ";

        } else {
            output = "Funcionário NÃO Removido. CPF inexistente!";
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
