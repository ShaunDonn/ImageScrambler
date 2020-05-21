package actualIAMaybe;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IAframe extends javax.swing.JFrame {
    private RandomAccessFile rowers;
    int rl = 101;
    private RandomAccessFile coaches;
    int cl = 65;
    private RandomAccessFile keyfile;
    private RandomAccessFile athleteStats;
    newAccFrame frame2 = new newAccFrame();
    public String firstName = "";
    public String lastName = "";
    
    public IAframe() {
        initComponents();
        try{
            rowers = new RandomAccessFile ("rowers.txt","rw");
            coaches = new RandomAccessFile ("coaches.txt","rw");
            keyfile = new RandomAccessFile ("key.txt","rw");
            athleteStats = new RandomAccessFile("athleteStats.txt","rw");
        }catch(java.io.IOException e){
            System.out.println(e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idnum = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        ADDACCOUNT = new javax.swing.JButton();
        passwordfield = new javax.swing.JPasswordField();
        logEntry = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID#");

        jLabel2.setText("Password");

        ADDACCOUNT.setBackground(new java.awt.Color(0, 204, 255));
        ADDACCOUNT.setText("Add Account");
        ADDACCOUNT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDACCOUNTActionPerformed(evt);
            }
        });

        logEntry.setBackground(new java.awt.Color(0, 255, 0));
        logEntry.setText("Login");
        logEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logEntryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordfield, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idnum, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ADDACCOUNT, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(logEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passwordfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ADDACCOUNT)
                    .addComponent(logEntry))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ADDACCOUNTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDACCOUNTActionPerformed
    frame2.setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_ADDACCOUNTActionPerformed

    private void logEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logEntryActionPerformed
        rowerFrame frame1 = new rowerFrame();
        String temp;
        String searchid = idnum.getText();
        String temp2;
        String searchpswd = fixpassword(passwordfield.getPassword());
        boolean allgood = false;
        int i = 0;
        try {
            long length = rowers.length()/rl;
            while(i <= length){
                rowers.seek(i*rl);
                temp = rowers.readLine();//take in the record
                firstName = stripx(temp.substring(10,25));
                lastName = stripx(temp.substring(25,45));
                System.out.println(temp);
                if(temp.substring(3,10).equals(searchid)){//if the id number matches the one inputted
                    temp2 = temp.substring(45,65);
                    if(temp2.equals(searchpswd)){//check if the password matches the password inputted
                        allgood = true;//set the all good to true
                        keyfile.seek(0);
                        keyfile.writeBytes(temp.substring(0,3));//stores the key being dealt with in its own raf
                    }else{
                        allgood = false;
                    }
                    break;//exit the while loop because the account has been found
                }else{
                    i++;//or keep looking through the raf
                }
            }
            if(allgood == false){
                loginpopup popup = new loginpopup();
                popup.setVisible(true);
                this.setVisible(false);
            }else{
                frame1.setVisible(true);
                frame1.athleteStatsLabel.setText(firstName + " " + lastName);
                this.setVisible(false);
            }
        keyfile.seek(0);
        int key = Integer.parseInt(keyfile.readLine());
        athleteStats.seek(key*43);
        String line = athleteStats.readLine();
        frame1.heightField.setText(stripxfromnumbers(line.substring(3,6)));
        frame1.weightField.setText(stripxfromnumbers(line.substring(6,9)));
        frame1.wingspanField.setText(stripxfromnumbers(line.substring(9,12)));
        frame1.categoryField.setText(removeXFromopenweight(line.substring(12,23)));
        frame1.twoktimeField.setText(revertTime(line.substring(23,28)));
        frame1.sixktimeField.setText(revertTime(line.substring(28,34)));
        } catch (IOException ex) {
            Logger.getLogger(IAframe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_logEntryActionPerformed
    public String stripxfromnumbers (String string){
        String donenum = "";
        for (int i = 0; i < string.length(); i++) {
            if(string.charAt(i) != 'x'){
                donenum += string.charAt(i);
            }
        }
        return donenum;
    }
    public String stripx (String string){
        String donestring = "";
        int i = 0;
        while(i < string.length()-2){
            if(string.charAt(i)=='x' && string.charAt(i+1) == 'x' && string.charAt(i+2) == 'x'){
               break; 
            }else{
                donestring += string.charAt(i);
            }
            i++;
        }
        return donestring;
    }  
    String fixweight(String weight){
        if("openweightx".equals(weight)){
            weight = weight.substring(0,10);
        }
        return weight;
    }
    private String revertTime(String time){
        String revertedTime = "";
        int size = time.length();
        int temp;
        int temp2;
        int oldTime = Integer.parseInt(time.substring(0,size-2));
        temp = oldTime%60;
        temp2 = (oldTime-temp)/60;
        revertedTime += temp2 + ":" + temp + "." + time.substring(size-1);
        if(time.length() >5 && revertedTime.charAt(4) == '.'){
            revertedTime = addzero(revertedTime);
        }
        return revertedTime;
    }
    private String addzero(String string){
        String doneString = "";
        for (int j = 0; j < 3; j++) {
            doneString += string.charAt(j);
        }
        doneString += "0";
        for (int i = 3; i < 6; i++) {
            doneString += string.charAt(i);
        }
        return doneString;
    }
    private String removeXFromopenweight(String string){
        String newString;
        if("openweightx".equals(string)){
            newString = "openweight";
        }else{
            newString = string;
        }
        return newString;
    }
    private String fixpassword (char [] searchterm){
        int i = searchterm.length;
        String pswd = "";
        for (int j = 0; j < i; j++) {
            pswd+=searchterm[j];
        }
        int pad = 20 - pswd.length();
        for (int j = 0; j < pad; j++) {
            pswd += 'x';
        }
        System.out.println(pswd);
        return pswd;
    } 
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
            java.util.logging.Logger.getLogger(IAframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IAframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IAframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IAframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IAframe().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADDACCOUNT;
    private javax.swing.JTextField idnum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton logEntry;
    private javax.swing.JPasswordField passwordfield;
    // End of variables declaration//GEN-END:variables
}
