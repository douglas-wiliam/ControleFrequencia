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
            funcionarios = new ArrayList<>();
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
                
                output += "\t Total de Horas: " + f.somarTotalHorasTrabalhadasPorPeriodo(dataInicio, dataFim) + "\n";
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

    public static String inicializarDados() {
        Funcionario f1 = new Funcionario("Douglas", "17221476527"); // freq 17221476527 01/01/2018 30/02/2018
        Funcionario f2 = new Funcionario("Igor", "24051455459");    //  freq 24051455459 01/09/2001 30/09/2001
        Funcionario f3 = new Funcionario("Luiz", "36631353149");    // freq 36631353149 01/01/2018 30/01/2018
        //Funcionario f4 = new Funcionario("Marcus", "05474526326");    
        //Funcionario f5 = new Funcionario("Clara", "45556453675"); 
        //Funcionario f6 = new Funcionario("Romualdo", "84261416417");

        f1.addFrequencia("10/01/2018", "11:45", "13:38");
        f1.addFrequencia("21/01/2018", "12:37", "14:47");
        f1.addFrequencia("25/01/2018", "11:30", "16:08");
        f1.addFrequencia("02/02/2018", "00:00", "06:00");
        f1.addFrequencia("10/02/2018", "12:00", "17:00");

        f2.addFrequencia("11/09/2001", "09:00", "12:00");
        f2.addFrequencia("12/09/2001", "10:00", "12:00");
        f2.addFrequencia("13/09/2001", "18:35", "22:08");

        f3.addFrequencia("10/01/2018", "08:45", "09:38");
        f3.addFrequencia("21/01/2018", "08:37", "12:40");
        f3.addFrequencia("25/01/2018", "08:30", "14:03");

        funcionarios.add(f1);
        funcionarios.add(f2);
        funcionarios.add(f3);

        return "";
    }

}
