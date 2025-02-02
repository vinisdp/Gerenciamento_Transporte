package telas;

import classes.Veiculo;
import io.Gravador;
import io.LeitorGravadorObj;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import objetos.ObjetoVeiculo;
import operacoes.Editar;

public class EditVeiculo extends javax.swing.JFrame {

    private ArrayList<Veiculo> veiculos;

    public EditVeiculo(ArrayList<Veiculo> veiculos) {
        this.veiculos = veiculos;

        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.tabelaVeiculo.getColumnModel().getColumn(0).setMinWidth(0);
        this.tabelaVeiculo.getColumnModel().getColumn(0).setMaxWidth(0);

        this.tabelaVeiculo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tabelaVeiculo.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                bRemover.setEnabled(tabelaVeiculo.getSelectedRow() >= 0);
                bEditar.setEnabled(tabelaVeiculo.getSelectedRow() >= 0);
            }
        });
        
        this.carregarDados();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgAcessivel = new javax.swing.ButtonGroup();
        pTabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaVeiculo = new javax.swing.JTable();
        pBotoes = new javax.swing.JPanel();
        bFechar = new javax.swing.JButton();
        bEditar = new javax.swing.JButton();
        bRemover = new javax.swing.JButton();
        lTitulo = new javax.swing.JLabel();
        pCampo = new javax.swing.JPanel();
        lCapacidade = new javax.swing.JLabel();
        lCPF1 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();
        rbSim = new javax.swing.JRadioButton();
        rbNao = new javax.swing.JRadioButton();
        lTipo1 = new javax.swing.JLabel();
        sCapacidade = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema de Transporte");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pTabela.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tabelaVeiculo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabelaVeiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Tipo", "Data Aquisição", "Capacidade", "Acessibilidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaVeiculo);

        javax.swing.GroupLayout pTabelaLayout = new javax.swing.GroupLayout(pTabela);
        pTabela.setLayout(pTabelaLayout);
        pTabelaLayout.setHorizontalGroup(
            pTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        pTabelaLayout.setVerticalGroup(
            pTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addContainerGap())
        );

        bFechar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/multiply (1).png"))); // NOI18N
        bFechar.setText("Fechar");
        bFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFecharActionPerformed(evt);
            }
        });

        bEditar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar-arquivo.png"))); // NOI18N
        bEditar.setText("Editar");
        bEditar.setEnabled(false);
        bEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditarActionPerformed(evt);
            }
        });

        bRemover.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/trash-bin.png"))); // NOI18N
        bRemover.setText("Remover");
        bRemover.setEnabled(false);
        bRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pBotoesLayout = new javax.swing.GroupLayout(pBotoes);
        pBotoes.setLayout(pBotoesLayout);
        pBotoesLayout.setHorizontalGroup(
            pBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pBotoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bRemover)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bFechar)
                .addGap(66, 66, 66))
        );
        pBotoesLayout.setVerticalGroup(
            pBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pBotoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        lTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cliente.png"))); // NOI18N
        lTitulo.setText("Veículos");

        pCampo.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));

        lCapacidade.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lCapacidade.setText("Capacidade:");

        lCPF1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lCPF1.setText("Acessível:");

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Metrô", "Ônibus", "Trem" }));

        bgAcessivel.add(rbSim);
        rbSim.setText("Sim");

        bgAcessivel.add(rbNao);
        rbNao.setText("Não");

        lTipo1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lTipo1.setText("Tipo:");

        javax.swing.GroupLayout pCampoLayout = new javax.swing.GroupLayout(pCampo);
        pCampo.setLayout(pCampoLayout);
        pCampoLayout.setHorizontalGroup(
            pCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCampoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lTipo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(lCPF1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbSim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbNao)
                .addGap(28, 28, 28)
                .addComponent(lCapacidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pCampoLayout.setVerticalGroup(
            pCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCampoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lCPF1)
                        .addComponent(rbSim)
                        .addComponent(rbNao)
                        .addComponent(lCapacidade)
                        .addComponent(sCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lTipo1)))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lTitulo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pCampo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditarActionPerformed
        int linha = this.tabelaVeiculo.getSelectedRow();
        if (linha >= 0) {
            String id = this.tabelaVeiculo.getValueAt(linha, 0).toString();
            Editar.editarVeiculo(veiculos, id);
        }
    }//GEN-LAST:event_bEditarActionPerformed

    private void bFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFecharActionPerformed
        ObjetoVeiculo veiculo = new ObjetoVeiculo();
        veiculo.setVeiculos(veiculos);
        Gravador.gravarObjeto(new LeitorGravadorObj(), veiculo, "./dados/veiculos.txt");
        this.dispose();
    }//GEN-LAST:event_bFecharActionPerformed

    private void bRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRemoverActionPerformed
        int linha = this.tabelaVeiculo.getSelectedRow();
        int resposta = JOptionPane.showConfirmDialog(null, "Confirma a exclusão", "Exclusão", JOptionPane.YES_NO_OPTION);
        if (linha >= 0 && resposta == 0) {
            String idVeiculo = this.tabelaVeiculo.getValueAt(linha, 0).toString();
            for (Veiculo veiculo : this.veiculos) {
                if (veiculo.getId().equals(idVeiculo)) {
                    this.veiculos.remove(veiculo);
                    this.carregarDados();
                    break;
                }
            }
        }
    }//GEN-LAST:event_bRemoverActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ObjetoVeiculo veiculo = new ObjetoVeiculo();
        veiculo.setVeiculos(veiculos);
        Gravador.gravarObjeto(new LeitorGravadorObj(), veiculo, "./dados/veiculos.txt");
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bEditar;
    private javax.swing.JButton bFechar;
    private javax.swing.JButton bRemover;
    private javax.swing.ButtonGroup bgAcessivel;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lCPF1;
    private javax.swing.JLabel lCapacidade;
    private javax.swing.JLabel lTipo1;
    private javax.swing.JLabel lTitulo;
    private javax.swing.JPanel pBotoes;
    private javax.swing.JPanel pCampo;
    private javax.swing.JPanel pTabela;
    private javax.swing.JRadioButton rbNao;
    private javax.swing.JRadioButton rbSim;
    private javax.swing.JSpinner sCapacidade;
    private javax.swing.JTable tabelaVeiculo;
    // End of variables declaration//GEN-END:variables

    private void carregarDados() {
        DefaultTableModel modelo = (DefaultTableModel) this.tabelaVeiculo.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        
        
        
        /*String cpf = this.tCPF.getText().toLowerCase();
        String nome = this.tNome.getText().toLowerCase();
        String tipo = (String) this.cbTipo.getSelectedItem();*/
        for (Veiculo veiculo : this.veiculos) {
            Date dataAquisicao = veiculo.getAquisicao();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String data = dateFormat.format(dataAquisicao);
            
            //if ((nome.isBlank() || usuario.getNome().toLowerCase().contains(nome)) && (cpf.isBlank() || usuario.getCpf().contains(cpf)) && (tipo == null || tipo.equals("Selecione") || usuario.getTipo().contains(tipo))) {
            Object[] row = {veiculo.getId(), veiculo.getTipo(), data, veiculo.getCapacidade(), veiculo.getAcessibilidade()};
            modelo.addRow(row);
            //}
        }
    }
}
