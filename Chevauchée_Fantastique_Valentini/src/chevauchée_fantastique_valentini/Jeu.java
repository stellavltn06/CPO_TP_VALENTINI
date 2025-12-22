/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package chevauchée_fantastique_valentini;
        import javax.swing.JOptionPane;
        import java.awt.Color;
import java.awt.GridLayout;
        import javax.swing.JButton;


/**
 *
 * @author stell
 */
public class Jeu extends javax.swing.JFrame {
    
   
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Jeu.class.getName());

        private Plateau plateau;
        private javax.swing.JButton[][] boutons;
        private int niveauActuel = 1;

    
    /**
     * Creates new form Jeu
     */
        
public Jeu() {
    initComponents();
    niveauActuel = 1;
    initialiserJeu(niveauActuel);
}

public Jeu(int niveau) {
    initComponents();

    niveauActuel = niveau;   // définit le niveau choisi
    initialiserJeu(niveauActuel);
}

void initialiserJeu(int niveau) {

    int taille;
    switch (niveau) {
        case 1 -> taille = 5;
        case 2 -> taille = 6;
        case 3 -> taille = 7;
        default -> taille = 5;
    }

    plateau = new Plateau(taille, taille);
    boutons = new JButton[taille][taille];

    // On nettoie SEULEMENT le panel du damier
    jPanelDamier.removeAll();
    jPanelDamier.setLayout(new GridLayout(taille, taille));

    for (int i = 0; i < taille; i++) {
        for (int j = 0; j < taille; j++) {
            JButton btn = new JButton();
            boutons[i][j] = btn;

            int x = i;
            int y = j;
            btn.addActionListener(e -> clicCase(x, y));

            jPanelDamier.add(btn);
        }
    }

    mettreAJourAffichage();
    jPanelDamier.revalidate();
    jPanelDamier.repaint();
}


private void mettreAJourAffichage() {
    // Définition des couleurs
    Color roseAllumee = new Color(255, 204, 204);
    Color roseEteinte = new Color(200, 200, 200); // gris clair pour contraste
    Color blancAllume = Color.WHITE;
    Color blancEteint = new Color(220, 220, 220); // gris clair pour contraste

    for (int i = 0; i < plateau.getLignes(); i++) {
        for (int j = 0; j < plateau.getColonnes(); j++) {

            Damier casePlateau = plateau.getCase(i, j);

            // Choix de la couleur de fond en fonction du damier et de l'état de la case
            Color couleurBase = (i + j) % 2 == 0 ? roseAllumee : blancAllume;
            if (!casePlateau.estAllumee()) {
                couleurBase = (i + j) % 2 == 0 ? roseEteinte : blancEteint;
            }
            boutons[i][j].setBackground(couleurBase);

            // Affichage du cavalier
            if (plateau.getCavalier().getX() == i && plateau.getCavalier().getY() == j) {
                boutons[i][j].setText("♞");
                boutons[i][j].setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 36));
                boutons[i][j].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                boutons[i][j].setVerticalAlignment(javax.swing.SwingConstants.CENTER);
            } else {
                boutons[i][j].setText("");
            }

            // Activer ou désactiver le bouton selon l'état
            boutons[i][j].setEnabled(casePlateau.estAllumee());
        }
    }
}

private void clicCase(int x, int y) {
    if (plateau.deplacementValide(x, y)) {
        plateau.deplacerCavalier(x, y);
        mettreAJourAffichage();

if (plateau.victoire()) {
    JOptionPane.showMessageDialog(this,
        "Bravo ! Vous avez terminé le niveau " + niveauActuel + " 🎉",
        "Victoire",
        JOptionPane.INFORMATION_MESSAGE);

    // passer au niveau suivant
    niveauActuel++;
    initialiserJeu(niveauActuel);

    mettreAJourAffichage(); // rafraîchit le damier
}
    }}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelDamier = new javax.swing.JPanel();
        jPanelBouton = new javax.swing.JPanel();
        Recommencer = new javax.swing.JButton();
        Quitter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelDamier.setLayout(new java.awt.GridLayout(6, 6));

        jPanelBouton.setLayout(new java.awt.GridLayout());

        Recommencer.setText("RECOMMENCER");
        Recommencer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecommencerActionPerformed(evt);
            }
        });
        jPanelBouton.add(Recommencer);

        Quitter.setText("QUITTER");
        Quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitterActionPerformed(evt);
            }
        });
        jPanelBouton.add(Quitter);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelDamier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanelBouton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanelDamier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanelBouton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RecommencerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecommencerActionPerformed
initialiserJeu(niveauActuel);
    }//GEN-LAST:event_RecommencerActionPerformed

    private void QuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitterActionPerformed
System.exit(0);
    }//GEN-LAST:event_QuitterActionPerformed
  
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Jeu().setVisible(true));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Quitter;
    private javax.swing.JButton Recommencer;
    private javax.swing.JPanel jPanelBouton;
    private javax.swing.JPanel jPanelDamier;
    // End of variables declaration//GEN-END:variables
}

