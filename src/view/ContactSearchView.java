
package view;

import controller.ContactController;
import javax.swing.JDesktopPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ContactSearchView extends javax.swing.JInternalFrame {

    /**
     * Creates new form UserSearchView
     */
    JDesktopPane index;
    public ContactSearchView(JDesktopPane desktop){
        try {
            index = desktop;
            initComponents();
            DefaultTableModel table = (DefaultTableModel) tableContact.getModel();
            ResultSet rs = ContactController.readContacts();
            
            while(rs.next()){
                Object[] dados = { rs.getInt("id"), rs.getString("name"), rs.getString("phone"), rs.getString("email")};
                table.addRow(dados);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContactSearchView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        searchContact = new javax.swing.JTextField();
        button_Contact = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableContact = new javax.swing.JTable();

        setClosable(true);
        setTitle("Contatos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar"));

        button_Contact.setText("Buscar");
        button_Contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ContactActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchContact, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_Contact, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_Contact))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        tableContact.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tableContact.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nome", "Telefone", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableContact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableContactMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableContact);
        if (tableContact.getColumnModel().getColumnCount() > 0) {
            tableContact.getColumnModel().getColumn(0).setPreferredWidth(2);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableContactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableContactMouseClicked
       int id = (int) tableContact.getValueAt(tableContact.getSelectedRow(), 0);
      ContactEditView editUser = new ContactEditView(id, index);
      editUser.setVisible(true);
    }//GEN-LAST:event_tableContactMouseClicked

    private void button_ContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ContactActionPerformed
        String query = searchContact.getText();
        if(query.equals("")){
            JOptionPane.showMessageDialog(null, "ERRO! Campo de busca vazio!");
        }else{
            DefaultTableModel table = (DefaultTableModel) tableContact.getModel();
            ResultSet rs = ContactController.searchContact(query);
            
            table.getDataVector().removeAllElements();
            table.fireTableDataChanged();
            
            try {
                while(rs.next()){
                    Object[] dados = { rs.getInt("id"), rs.getString("name"), rs.getString("phone"), rs.getString("email")};
                    table.addRow(dados);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ContactSearchView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_button_ContactActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_Contact;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchContact;
    private javax.swing.JTable tableContact;
    // End of variables declaration//GEN-END:variables
}