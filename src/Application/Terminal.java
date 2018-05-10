package Application;

import Command.ComandoExibeFrequenciaFuncionarioPorPeriodo;
import Command.ComandoInicializarDados;
import Command.Comando;
import Command.ComandoAlteraNomeEmpresa;
import Command.Invocador;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Indicar o tipo de licença aqui.
 */
/**
 *
 * @author douglas
 */
public class Terminal {

    private static String[] getInputTeclado() {
        String input;
        String[] tokens;
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();

        tokens = input.split(" ");

        return tokens;

    }

    public static void main(String[] args) {
        String[] input;
        String output;
        Map<String, Comando> mapeamento = new HashMap<>();
        Comando comando = new ComandoInicializarDados();
        Invocador invocador = new Invocador();
        System.out.println("@Empresa: ");
        input = getInputTeclado();

        ComandoExibeFrequenciaFuncionarioPorPeriodo ceffpp = new ComandoExibeFrequenciaFuncionarioPorPeriodo(input[1], input[2], input[3]);
        mapeamento.put("freq", ceffpp);

        ComandoAlteraNomeEmpresa cane = new ComandoAlteraNomeEmpresa(input[1]);
        mapeamento.put("nome", cane);
        
        invocador.executarComando(comando);

        while (!"sai".equals(input[0])) {
            
            // Não trata comandos inexistentes
            comando = mapeamento.get(input[0]);
            
            output = invocador.executarComando(comando);

            System.out.println(output);
            System.out.print("@Empresa: ");
            input = getInputTeclado();
        }

        System.out.println("Usuário saiu do sistema.");
    }

}
