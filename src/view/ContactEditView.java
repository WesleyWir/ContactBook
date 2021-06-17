/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import controller.ContactController;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

public class ContactEditView extends javax.swing.JInternalFrame {

    /**
     * Creates new form UserRegisterView
     */
    private int id;
    
    public ContactEditView(int id, JDesktopPane index) {
        index.add(this);
        initComponents();
        
        for(int days = 1; days <= 31; days++){
            select_borndate_day.addItem(days+"");
        }
        
        for (int months = 0; months < 12; months++) {
            select_borndate_month.addItem(months+"");
        }
       
        for(int years = 1970; years <= 2021; years++) {
            select_borndate_year.addItem(years+"");
        }   
        
        ResultSet rs = ContactController.readContact(id);
        
        try {
            while(rs.next()){
                this.id = rs.getInt("id");
                input_name.setText(rs.getString("name"));
                String[] split = rs.getString("born_date").split("-");
                select_borndate_day.setSelectedItem(split[2]);
                select_borndate_month.setSelectedItem(split[1]);
                select_borndate_year.setSelectedItem(split[0]);
                input_phone.setText(rs.getString("phone"));
                input_email.setText(rs.getString("email"));
                select_state.setSelectedItem(rs.getString("state"));
                input_city.setText(rs.getString("city"));
                input_neighborhood.setText(rs.getString("neighborhood"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContactEditView.class.getName()).log(Level.SEVERE, null, ex);
        };
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name_input1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        input_name = new javax.swing.JTextField();
        update_button = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        input_phone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        input_email = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        select_state = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        input_neighborhood = new javax.swing.JTextField();
        input_city = new javax.swing.JTextField();
        select_borndate_day = new javax.swing.JComboBox<>();
        select_borndate_month = new javax.swing.JComboBox<>();
        select_borndate_year = new javax.swing.JComboBox<>();
        delete_button = new javax.swing.JButton();

        name_input1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_input1ActionPerformed(evt);
            }
        });

        setClosable(true);
        setTitle("Registro de Usuários");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setText("Registro de Contato");

        jLabel2.setText("Nome:");

        input_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_nameActionPerformed(evt);
            }
        });

        update_button.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        update_button.setText("Atualizar");
        update_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_buttonActionPerformed(evt);
            }
        });

        jLabel3.setText("Data de nascimento:");

        jLabel4.setText("Telefone:");

        input_phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_phoneActionPerformed(evt);
            }
        });

        jLabel5.setText("Email:");

        input_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_emailActionPerformed(evt);
            }
        });

        jLabel6.setText("Estado:");

        select_state.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Estado", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        jLabel7.setText("Cidade:");

        jLabel8.setText("Bairro:");

        input_neighborhood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_neighborhoodActionPerformed(evt);
            }
        });

        input_city.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_cityActionPerformed(evt);
            }
        });

        select_borndate_day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia" }));

        select_borndate_month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mês" }));

        select_borndate_year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ano" }));

        delete_button.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        delete_button.setText("Deletar");
        delete_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(select_state, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(input_neighborhood)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(input_city, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(158, 158, 158))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(input_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(input_email, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(input_name, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(select_borndate_day, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(select_borndate_month, 0, 53, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(select_borndate_year, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(delete_button)
                .addGap(18, 18, 18)
                .addComponent(update_button)
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(input_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(select_borndate_day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(select_borndate_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(select_borndate_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(input_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(input_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(select_state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(input_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(input_neighborhood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update_button)
                    .addComponent(delete_button))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void update_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_buttonActionPerformed
        String name = input_name.getText();
        int day_num = select_borndate_day.getSelectedIndex();
        int month_num = select_borndate_month.getSelectedIndex();
        int year_num = select_borndate_year.getSelectedIndex();
        String day = (String) select_borndate_day.getSelectedItem();
        String month = (String) select_borndate_month.getSelectedItem();
        String year = (String) select_borndate_year.getSelectedItem();
        String phone = input_phone.getText();
        String email = input_email.getText();
        String state = (String) select_state.getSelectedItem();
        String city = input_city.getText();
        String neighborhood = input_neighborhood.getText();
        
        String bornDate = year+"-";
        bornDate += month+"-";
        bornDate += day;
        
        if(this.hasEmptyFields(name, day_num, month_num, year_num, phone, email)){
             JOptionPane.showMessageDialog(null, "Erro ao Atualizar! Campos Vazios");
        }else{
            ContactController.updateContact(this.id, name, bornDate, phone, email, state, city, neighborhood);
            JOptionPane.showMessageDialog(null, "Contato Atualizado.");
            this.dispose();
        }
    }//GEN-LAST:event_update_buttonActionPerformed

    private boolean hasEmptyFields(String name, int day, int month, 
                                    int year, String phone, String email){
        if(day == 0 || month == 0 || year == 0){
            return true;
        }
        
        if(name.equals("") || phone.equals("") || email.equals("")){
            return true;
        }
        
        return false;
    }
    
    private void input_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_nameActionPerformed

    private void name_input1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_input1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_input1ActionPerformed

    private void input_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_phoneActionPerformed

    private void input_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_emailActionPerformed

    private void input_neighborhoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_neighborhoodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_neighborhoodActionPerformed

    private void input_cityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_cityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_cityActionPerformed

    private void delete_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_buttonActionPerformed
        String mensagem = "Deseja realmente apagar o contato?";
        String titulo = "Remover Contato";
        int resposta = JOptionPane.showConfirmDialog(null, mensagem, titulo, JOptionPane.YES_OPTION);
        if(resposta == JOptionPane.YES_OPTION){
            if(ContactController.deleteContact(this.id)){
                JOptionPane.showMessageDialog(null, "Usuário removido.");
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao remover usuário.");
                this.dispose();
            }
        }
    }//GEN-LAST:event_delete_buttonActionPerformed


    private boolean validarCamposPreenchidos(String campo){
        if(campo.equals("")){
            return false;
        }else{
            return true;
        }     
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delete_button;
    private javax.swing.JTextField input_city;
    private javax.swing.JTextField input_email;
    private javax.swing.JTextField input_name;
    private javax.swing.JTextField input_neighborhood;
    private javax.swing.JTextField input_phone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField name_input1;
    private javax.swing.JComboBox<String> select_borndate_day;
    private javax.swing.JComboBox<String> select_borndate_month;
    private javax.swing.JComboBox<String> select_borndate_year;
    private javax.swing.JComboBox<String> select_state;
    private javax.swing.JButton update_button;
    // End of variables declaration//GEN-END:variables
}
