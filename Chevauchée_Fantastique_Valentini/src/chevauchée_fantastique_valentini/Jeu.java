/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package chevauchée_fantastique_valentini;
        import javax.swing.JOptionPane;
        import java.awt.Color;
import java.awt.GridLayout;
        import javax.swing.JButton;
import java.awt.Dimension;


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
    mettreAJourNiveau();

}


public Jeu(int niveau) {
    initComponents();
    niveauActuel = niveau;   // définit le niveau choisi
    mettreAJourNiveau(); 
    solution_5x5.setVisible(false); 
    texte_solution.setVisible(false);
    jPanelSolution.setVisible(false);
    
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

    jPanelDamier.setPreferredSize(new Dimension(600, 600)); // par ex. 600x600 pixels
    jPanelDamier.setLayout(new GridLayout(taille, taille));

    plateau = new Plateau(taille, taille);
    boutons = new JButton[taille][taille];

    
// Le bouton solution n'est visible QUE pour le niveau 1 (5x5)
solutionBtn.setVisible(niveau == 1);
solution_5x5.setVisible(false); // on cache le texte solution à chaque reset


    // On nettoie le panel du damier
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
boutonRetour.setVisible(true);
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

    niveauActuel++;
    initialiserJeu(niveauActuel);
    mettreAJourNiveau(); 
    solution_5x5.setVisible(false);
    texte_solution.setVisible(false);
}

if (plateau.estBloque() && !plateau.victoire()) {
    JOptionPane.showMessageDialog(
        this,
        "Bloqué 😢 Recommence la partie",
        "Perdu",
        JOptionPane.WARNING_MESSAGE
    );
}
    }}

private int[][] solution = {
    {2,2}, {0,1}, {1,3}, {3,4}, {4,2}, {3,0}, {1,1}, {0,3},
    {2,4}, {4,3}, {3,1}, {1,0}, {0,2}, {1,4}, {3,3}, {4,1}, {2,0} ,{1,2}, {0,4}, {2,3}, {4,4}, {3,2}, {4,0}, {2,1}, {0,0}
};

// Méthode pour exécuter la solution automatiquement
private void montrerSolution() {
    initialiserJeu(1);
    new Thread(() -> { // Thread pour ne pas bloquer l'interface
        try {
            for (int[] move : solution) {
                int x = move[0];
                int y = move[1];
                
                // Déplacer le cavalier uniquement si le déplacement est valide
                if (plateau.deplacementValide(x, y)) {
                    plateau.deplacerCavalier(x, y);
                    mettreAJourAffichage();
                    Thread.sleep(500); // pause 0,5s entre chaque mouvement
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }).start();
}

private void mettreAJourNiveau() {
    int taille;
    switch (niveauActuel) {
        case 1 -> taille = 5;
        case 2 -> taille = 6;
        case 3 -> taille = 7;
        default -> taille = 5;
    }

    lblNiveau.setText("Niveau " + niveauActuel + " : " + taille + "x" + taille);
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNiveau = new javax.swing.JLabel();
        jPanelDamier = new javax.swing.JPanel();
        jPanelBouton = new javax.swing.JPanel();
        Recommencer = new javax.swing.JButton();
        Quitter = new javax.swing.JButton();
        boutonRetour = new javax.swing.JButton();
        solutionBtn = new javax.swing.JButton();
        jPanelSolution = new javax.swing.JPanel();
        texte_solution = new javax.swing.JLabel();
        solution_5x5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNiveau.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        lblNiveau.setForeground(new java.awt.Color(0, 51, 204));
        lblNiveau.setText("Niveau : ");
        getContentPane().add(lblNiveau, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 355, 36));

        jPanelDamier.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 153, 153)));
        jPanelDamier.setLayout(new java.awt.GridLayout(6, 6));
        getContentPane().add(jPanelDamier, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 670, 540));

        jPanelBouton.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 0, 255)));
        jPanelBouton.setForeground(new java.awt.Color(255, 255, 255));
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

        boutonRetour.setText("RETOUR");
        boutonRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonRetourActionPerformed(evt);
            }
        });
        jPanelBouton.add(boutonRetour);

        solutionBtn.setText("SOLUTION");
        solutionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solutionBtnActionPerformed(evt);
            }
        });
        jPanelBouton.add(solutionBtn);

        getContentPane().add(jPanelBouton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 650, 64));

        jPanelSolution.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(51, 0, 255)));

        texte_solution.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        texte_solution.setForeground(new java.awt.Color(51, 153, 255));
        texte_solution.setText("Une combinaison possible pour résoudre le niveau 1 : ");
        texte_solution.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        texte_solution.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        solution_5x5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        solution_5x5.setForeground(new java.awt.Color(0, 153, 255));
        solution_5x5.setText("{2,2}    {0,1}    {1,3}    {3,4}    {4,2}    {3,0}   {1,1}    {0,3}     {2,4}    {4,3}    {3,1}    {1,0}    {0,2}    {1,4}    {3,3}    {4,1}   {2,0}     {1,2}     {0,4}    {2,3}    {4,4}    {3,2}   {4,0}     {2,1}    {0,0}");

        javax.swing.GroupLayout jPanelSolutionLayout = new javax.swing.GroupLayout(jPanelSolution);
        jPanelSolution.setLayout(jPanelSolutionLayout);
        jPanelSolutionLayout.setHorizontalGroup(
            jPanelSolutionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSolutionLayout.createSequentialGroup()
                .addGroup(jPanelSolutionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texte_solution)
                    .addComponent(solution_5x5))
                .addGap(12, 12, 12))
        );
        jPanelSolutionLayout.setVerticalGroup(
            jPanelSolutionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSolutionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(texte_solution)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(solution_5x5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelSolution, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 670, -1, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RecommencerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecommencerActionPerformed
initialiserJeu(niveauActuel);
mettreAJourNiveau();

solution_5x5.setVisible(false);
texte_solution.setVisible(false);
jPanelSolution.setVisible(false);
    }//GEN-LAST:event_RecommencerActionPerformed

    private void QuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitterActionPerformed
System.exit(0);
    }//GEN-LAST:event_QuitterActionPerformed

    private void boutonRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonRetourActionPerformed
    plateau.retourCoupPrecedent();
    mettreAJourAffichage();
    // TODO add your handling code here:
    }//GEN-LAST:event_boutonRetourActionPerformed

    private void solutionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solutionBtnActionPerformed
        montrerSolution(); // appelle ta méthode qui montre la solution
        solution_5x5.setVisible(true);
        texte_solution.setVisible(true);
        jPanelSolution.setVisible(true);
    }//GEN-LAST:event_solutionBtnActionPerformed
  
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
    private javax.swing.JButton boutonRetour;
    private javax.swing.JPanel jPanelBouton;
    private javax.swing.JPanel jPanelDamier;
    private javax.swing.JPanel jPanelSolution;
    private javax.swing.JLabel lblNiveau;
    private javax.swing.JButton solutionBtn;
    private javax.swing.JLabel solution_5x5;
    private javax.swing.JLabel texte_solution;
    // End of variables declaration//GEN-END:variables
}

