/*
 * Indicar o tipo de licença aqui.
 */
package Application;

import Command.ComandoAlteraNomeEmpresa;
import Command.ComandoCriaFuncionario;
import Command.ComandoExibeFrequenciaFuncionarioPorPeriodo;
import Command.ComandoRegistraFrequenciaFuncionario;
import Command.Invocador;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author douglas
 */
public class GUI extends JFrame {

    private final int MAX_LINHAS_TABELA;
    private final int MAX_COLUNAS_TABELA;

    private ComandoExibeFrequenciaFuncionarioPorPeriodo ceffpp;
    private ComandoAlteraNomeEmpresa cane;
    private ComandoCriaFuncionario ccf;
    private ComandoRegistraFrequenciaFuncionario crff;

    Invocador invocador;

    private javax.swing.JButton BotaoCalcular;
    private JButton BotaoLimparTudo;
    private JDialog CaixaDeDialogo;
    private JTextField CampoParaNome;
    private JLabel LabelNome;
    private JPanel PainelDeFundo;
    private JTable Tabela;
    private JPanel jPanel2;
    private JScrollPane jScrollPane2;

    private JButton BotaoGerarPDF;
    private JLabel LabelCaixaDialogo;

    public GUI() {
        initComponents();
        MAX_LINHAS_TABELA = 25;
        MAX_COLUNAS_TABELA = 3;
        ceffpp = null;
        cane = null;
        ccf = null;
        crff = null;
        invocador = new Invocador();
    }

    private void BotaoGerarPDFActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void CampoParaNomeActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void BotaoCalcularActionPerformed(java.awt.event.ActionEvent evt) {
        int linha, coluna;
        String funcionario, data, horaChegada, horaSaida;

        funcionario = (String) CampoParaNome.getText();
        ccf = new ComandoCriaFuncionario(funcionario);
        invocador.executarComando(ccf);

        for (linha = 0; linha < MAX_LINHAS_TABELA; linha++) {

            if (Tabela.getValueAt(linha, 0) == null) {
                break;
            }

            data = (String) Tabela.getValueAt(linha, 0);
            horaChegada = (String) Tabela.getValueAt(linha, 1);
            horaSaida = (String) Tabela.getValueAt(linha, 2);

            crff = new ComandoRegistraFrequenciaFuncionario(data, horaChegada, horaSaida);
            invocador.executarComando(crff);
        }

        ceffpp = new ComandoExibeFrequenciaFuncionarioPorPeriodo("01/01/1900", "31/12/2099");

        System.out.print(invocador.executarComando(ceffpp));

    }

    private void BotaoLimparTudoActionPerformed(java.awt.event.ActionEvent evt) {
        int linha;

        CampoParaNome.setText("");

        for (linha = 0; linha < MAX_LINHAS_TABELA; linha++) {
            Tabela.setValueAt(null, linha, 0);
            Tabela.setValueAt(null, linha, 1);
            Tabela.setValueAt(null, linha, 2);
        }
    }

    private void initComponents() {

        CaixaDeDialogo = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        BotaoGerarPDF = new javax.swing.JButton();
        LabelCaixaDialogo = new javax.swing.JLabel();
        PainelDeFundo = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        CampoParaNome = new javax.swing.JTextField();
        LabelNome = new javax.swing.JLabel();
        BotaoCalcular = new javax.swing.JButton();
        BotaoLimparTudo = new javax.swing.JButton();

        CaixaDeDialogo.setMinimumSize(new java.awt.Dimension(320, 180));
        CaixaDeDialogo.setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        BotaoGerarPDF.setText("Gerar PDF");
        BotaoGerarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoGerarPDFActionPerformed(evt);
            }
        });

        LabelCaixaDialogo.setText("Pronto!");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(BotaoGerarPDF)
                        .addContainerGap(99, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LabelCaixaDialogo)
                        .addGap(119, 119, 119))
        );
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LabelCaixaDialogo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addComponent(BotaoGerarPDF)
                        .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout CaixaDeDialogoLayout = new javax.swing.GroupLayout(CaixaDeDialogo.getContentPane());
        CaixaDeDialogo.getContentPane().setLayout(CaixaDeDialogoLayout);
        CaixaDeDialogoLayout.setHorizontalGroup(
                CaixaDeDialogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CaixaDeDialogoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        CaixaDeDialogoLayout.setVerticalGroup(
                CaixaDeDialogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(CaixaDeDialogoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(640, 360));
        setMinimumSize(new java.awt.Dimension(640, 360));
        setResizable(false);

        PainelDeFundo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controle de Frequência", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 24))); // NOI18N
        PainelDeFundo.setMaximumSize(new java.awt.Dimension(640, 360));
        PainelDeFundo.setMinimumSize(new java.awt.Dimension(640, 360));
        PainelDeFundo.setPreferredSize(new java.awt.Dimension(640, 360));

        Tabela.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null}
                },
                new String[]{
                    "Data", "Chegada", "Saida"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        Tabela.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(Tabela);

        CampoParaNome.setText("Digite aqui o nome do funcionário...");
        CampoParaNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoParaNomeActionPerformed(evt);
            }
        });

        LabelNome.setText("Nome:");

        BotaoCalcular.setText("Calcular");
        BotaoCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCalcularActionPerformed(evt);
            }
        });

        BotaoLimparTudo.setText("Limpar Tudo");
        BotaoLimparTudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoLimparTudoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelDeFundoLayout = new javax.swing.GroupLayout(PainelDeFundo);
        PainelDeFundo.setLayout(PainelDeFundoLayout);
        PainelDeFundoLayout.setHorizontalGroup(
                PainelDeFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PainelDeFundoLayout.createSequentialGroup()
                                .addGroup(PainelDeFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PainelDeFundoLayout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addGroup(PainelDeFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(PainelDeFundoLayout.createSequentialGroup()
                                                                .addComponent(LabelNome)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(CampoParaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(PainelDeFundoLayout.createSequentialGroup()
                                                .addGap(189, 189, 189)
                                                .addComponent(BotaoLimparTudo)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(BotaoCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PainelDeFundoLayout.setVerticalGroup(
                PainelDeFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PainelDeFundoLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(PainelDeFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(CampoParaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(LabelNome))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PainelDeFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(BotaoCalcular)
                                        .addComponent(BotaoLimparTudo))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(PainelDeFundo, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(PainelDeFundo, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }

}
