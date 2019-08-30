/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package geradorcodigoautohotkey_planilhaparahistsigaa;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Serac02
 */
public class jan extends javax.swing.JFrame {

    /**
     * Creates new form jan
     */
    
    ExcelAdapter myAd, myAd1;
    String[][] S, D;
    private boolean fim;
    jan outro;
    ArrayList<Integer> nomes = new ArrayList<Integer>();
    private int numeroDisc=0;
    
    public jan(ArrayList<Integer> z) {
        initComponents();
        this.setVisible(true);
        //nomes = z;
        ExcelAdapter myAd = new ExcelAdapter(SIGAA,this,"SIGAA");
       this.setIconImage(createImage("johnsnow.jpg","icone"));
       
       S = new String[70][5];
       //D = new String[70][5];
       
       for(int a=0;a<70;a++){
           S[a][0]="*";
       }
      
       if(z.size()>0){
       Tempo1.setValue(z.get(0));
       TempoEntreDisc.setValue(z.get(1));
       TempoSelecionandoDisc.setValue(z.get(2));
       L1.setValue(z.get(3));
       L2.setValue(z.get(4));

       }


       
        // SIGAA.setCellEditor(0,0,new JTextfield());
       
      // SIGAA.getCellEditor(0, 0).getCellEditorValue() pegar string
     
      // SIGAA.setValueAt("text", 0, 0); setar texto
    }

    void salvar(String value, int i, int i0, String t) {
       
     //  if(S[i][1].equals("Rep")) 
          // return;
           
        S[i][i0]=value;
        if(i>=numeroDisc)
            numeroDisc = i+1;
    }

    public void do1(){
       String cod="";
        
      //  cod = "WinWait, SIGAA - Sistema Integrado de Gestão de Atividades Acadêmicas - Google Chrome,\nIfWinNotActive, SIGAA - Sistema Integrado de Gestão de Atividades Acadêmicas - Google Chrome, , WinActivate, SIGAA - Sistema Integrado de Gestão de Atividades Acadêmicas - Google Chrome,\nWinWaitActive, SIGAA - Sistema Integrado de Gestão de Atividades Acadêmicas - Google Chrome,\n";
        
       cod = "Sleep, 2500\n"; 
       
        for(int a=0;a<numeroDisc;a++){
            if(!S[a][1].equals("Rep")){
         //   cod+="disciplina%"+a+"% := " + S[a][0].substring(0, 7) + "\n"; 
          //  cod+="conceito%"+a+"% := " + S[a][1] + "\n"; 
          //  cod+="ano%"+a+"% := " + S[a][2] + "\n"; 
          //  cod+="semestre%"+a+"% := " + S[a][3] + "\n"; 
          //  cod+="frequencia%"+a+"% := " + S[a][4] + "\n"; 
            
      //  }
          
       // cod+="cont=0\n"
             //   + "while cont < "+ numeroDisc + "\n{\nif conceito%cont% <> Rep\n{\n" ;
        
        //MouseClick, left, 237, 297  ;Seleciona campo de disciplina	
        cod  +="MouseClick, left, "+getLocal() + "\n";
//Sleep, 50	
        cod+="Sleep, "+ Tempo1.getValue() + "\n";
//Send, AGI010	
        //cod+="temp1 :=  disciplina%cont%\n";
       // cod+="Send, %temp1%\n";
        
        if(S[a][0].length()>7)
        cod+="Send,"+S[a][0].substring(0, 7)+"\n";
        else
        cod+="Send,"+S[a][0]+"\n";    
        
//Sleep, 2000	
        cod+="Sleep, "+TempoSelecionandoDisc.getValue()+"\n";
//Send, {ENTER} ;MouseClick, left, 244, 303 ;seleciona disciplina	;MouseClick, left,  244,  303
        cod+="Send, {ENTER}\n";
//Sleep, 50
        cod+="Sleep, "+ Tempo1.getValue() + "\n";
//MouseClick, left, 206, 307  ;seleciona campo de conceito
        cod+="Send, {TAB}\n";
//Sleep, 50
         cod+="Sleep, "+ Tempo1.getValue() + "\n";
//Send, A	
         //cod+="temp1 := conceito%cont%\n";
         //cod+="Send, %temp1%\n";
          cod+="Send,"+S[a][1]+"\n";
         
//MouseClick, left, 100,100	
//MouseClick, left, 198, 323  ;seleciona campo de ano	
         cod+="Send, {TAB}\n";
//Sleep, 50	
         cod+="Sleep, "+ Tempo1.getValue() + "\n";
//Send, 2010	
         //cod+="temp1 = ano%cont%\n";
         //cod+="Send, %temp1%\n";
          cod+="Send,"+S[a][2]+"\n";
//MouseClick, left, 233, 326  ;seleciona campo de periodo
         cod+="Send, {TAB}\n";
//Sleep, 50	
         cod+="Sleep, "+ Tempo1.getValue() + "\n";
//Send, 1	
        //  cod+="temp1 = semestre%cont%\n";
         // cod+="Send, %temp1%\n";
          cod+="Send,"+S[a][3]+"\n";
//MouseClick, left, 196, 346   ;seleciona frequencia	
           cod+="Send, {TAB}\n"; //cod+="Send, frequencia%cont%\n";
//Sleep, 50	
         cod+="Sleep, "+ Tempo1.getValue() + "\n";  
//Send, 100  ;marca freq como 100
        //  cod+="temp1 = frequencia%cont%\n";
         // cod+="Send, %temp1%\n";
          cod+="Send,"+S[a][4]+"\n";
//Send, {TAB}	
         cod+="Send, {TAB}\n"; 
//Sleep, 50	
          cod+="Sleep, "+ Tempo1.getValue() + "\n";
//Send, APROVADO{ENTER}	
          cod+="Send, APROVADO\n"
                  + "Sleep, "+ Tempo1.getValue() + "\n"
                  + "MouseClick, left, "+(int)LO1.getValue()+","+(int)LO2.getValue()+"\n"
                  + "MouseClick, left, "+getLocal() + "\n"
                  + "Send, {TAB}{TAB}{TAB}{TAB}{TAB}{TAB}\n"
          //        + "Send, {ENTER}{TAB}{ENTER}\n";
          + "Send, {ENTER}\n";
//MouseClick, left, 253, 366	
//MouseClick, left, 363, 382  ; salva registro	
//Sleep, 3600	; --------- FIM DA DISCIPLINA -----------------------------------
        cod+="Sleep, "+ TempoEntreDisc.getValue() + "\n";  
 // cod+="}\ncont++\n}\nMsgBox Inclusao_completa";
            }
        }
  
        codigo.setText(cod);
        
    } 
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SIGAA = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        codigo = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        Tempo1 = new javax.swing.JSpinner();
        TempoEntreDisc = new javax.swing.JSpinner();
        TempoSelecionandoDisc = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        L1 = new javax.swing.JSpinner();
        L2 = new javax.swing.JSpinner();
        BTSalvar = new javax.swing.JButton();
        TFAluno = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        LO2 = new javax.swing.JSpinner();
        LO1 = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTable1);

        jLabel8.setText("Tempo Geral:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mágica WinterFell 1.2");

        SIGAA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Disciplina", "Conceito", "Ano", "Semestre", "Freq"
            }
        ));
        jScrollPane1.setViewportView(SIGAA);

        jButton1.setText("Go");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Nova Mágica");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Tempo Geral:");

        codigo.setColumns(20);
        codigo.setRows(5);
        jScrollPane2.setViewportView(codigo);

        jLabel1.setText("Cód AHK");

        Tempo1.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(50), Integer.valueOf(0), null, Integer.valueOf(1)));

        TempoEntreDisc.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(3600), Integer.valueOf(1000), null, Integer.valueOf(1)));

        TempoSelecionandoDisc.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(2000), Integer.valueOf(200), null, Integer.valueOf(1)));

        jLabel6.setText("Entre disc:");

        jLabel7.setText("Selecionando disc:");

        jLabel9.setText("Local. campo");

        L1.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(237), Integer.valueOf(0), null, Integer.valueOf(1)));

        L2.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(290), Integer.valueOf(0), null, Integer.valueOf(1)));

        BTSalvar.setText("Salvar arquivo");
        BTSalvar.setEnabled(false);
        BTSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTSalvarActionPerformed(evt);
            }
        });

        TFAluno.setText("nome do aluno");
        TFAluno.setToolTipText("Arquivo salvo em C://macros");

        jLabel10.setText("out 2");

        LO2.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(150), Integer.valueOf(50), null, Integer.valueOf(1)));

        LO1.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(150), Integer.valueOf(50), null, Integer.valueOf(1)));

        jLabel11.setText("Clique out:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Tempo1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TempoEntreDisc, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TempoSelecionandoDisc, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(L1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(L2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LO1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LO2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(149, 149, 149)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                .addGap(28, 28, 28)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BTSalvar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                                .addComponent(TFAluno, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Tempo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TempoEntreDisc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TempoSelecionandoDisc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(L1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(LO1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LO2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jButton1)
                        .addComponent(BTSalvar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TFAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        do1();
        jButton1.setEnabled(false);
        BTSalvar.setEnabled(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       ArrayList<Integer>  a = new ArrayList<Integer>();
       
       a.add((Integer) Tempo1.getValue());
       a.add((Integer)TempoEntreDisc.getValue());
       a.add((Integer)TempoSelecionandoDisc.getValue());
        a.add((Integer)L1.getValue());
        a.add((Integer)L2.getValue());
       
        outro = new jan(a);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void BTSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTSalvarActionPerformed
        CriarArquivo a = new CriarArquivo(this);
        a.salvar(codigo.getText(), TFAluno.getText());  
     
    }//GEN-LAST:event_BTSalvarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            //    new jan().setVisible(true);
                
            }
        });
    }

    // curso = "ELET", "MEC",
    // turno = "M" ou "N"
 
    
    public String getLocal(){
    
    return L1.getValue().toString()+", "+L2.getValue().toString();
    }
    
    
    public void salvou(boolean a){
    if(a==true){
        TFAluno.setText("Salvou com sucesso, macro para " +TFAluno.getText() +"!");
     
    }
    else
        TFAluno.setText("Falha ao salvar macro.");
    
    BTSalvar.setEnabled(false);
     TFAluno.setEnabled(false);
    
    }
    
    
    public void consumirEspacosBrancosNoFinal(int a){
    
        int t;
        boolean g = true;
        
        while(g){
        t = S[a][0].length();
        
        if(S[a][0].charAt(t-1) !=' '){
            g = false;
        } else {
            S[a][0] = S[a][0].substring(0, t-2);
            }
        }
    
    }
    
    
      public Image createImage(String path,
                                           String description) {
    java.net.URL imgURL = getClass().getResource(path);
    if (imgURL != null) {
        return new ImageIcon(imgURL, description).getImage();
    } else {
        System.err.println("Couldn't find file: " + path);
        return null;
    }
}
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTSalvar;
    private javax.swing.JSpinner L1;
    private javax.swing.JSpinner L2;
    private javax.swing.JSpinner LO1;
    private javax.swing.JSpinner LO2;
    private javax.swing.JTable SIGAA;
    private javax.swing.JTextField TFAluno;
    private javax.swing.JSpinner Tempo1;
    private javax.swing.JSpinner TempoEntreDisc;
    private javax.swing.JSpinner TempoSelecionandoDisc;
    private javax.swing.JTextArea codigo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
