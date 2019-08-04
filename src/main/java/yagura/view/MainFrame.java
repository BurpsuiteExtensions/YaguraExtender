package yagura.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import javax.swing.*;
import yagura.Config;
import yagura.model.OptionProperty;
import yagura.model.UniversalViewProperty;

/**
 *
 * @author isayan
 */
public class MainFrame extends javax.swing.JFrame {

    static {
        File logDir = Config.getExtensionHomeDir();
        logDir.mkdirs();
    }
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        customizeComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        menuLookAndFeel = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 900));

        pnlMain.setPreferredSize(new java.awt.Dimension(1280, 1280));
        pnlMain.setLayout(new java.awt.BorderLayout());
        getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

        menuLookAndFeel.setText("Look and Feel");
        menuBar.add(menuLookAndFeel);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    private JTransCoderTab jTransCoder;

    private static LookAndFeelUI currentLookAndFeel = null;

    private ButtonGroup lafMenuGroup = new ButtonGroup();
 
    public final OptionProperty option = new OptionProperty();

    private final File CONFIG_FILE = new File(Config.getExtensionHomeDir(), Config.getExtensionFile());
    
    private void customizeComponents() {
        this.setTitle("JTranscoder");

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
//                try {
//                    option.setJTransCoderProperty(jTransCoder.getProperty());            
//                    Config.saveToJson(CONFIG_FILE, option);
//                } catch (IOException ex) {
//                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//                }
            }        
        });

        this.jTransCoder = new JTransCoderTab();
        this.pnlMain.add(jTransCoder, java.awt.BorderLayout.CENTER);
        
        try {
            if (CONFIG_FILE.exists()) {
                Config.loadFromJson(CONFIG_FILE, option);        
            }
            this.jTransCoder.setEncodingList(UniversalViewProperty.getDefaultEncodingList(Locale.JAPANESE), "UTF-8");
            this.jTransCoder.setProperty(option.getJTransCoderProperty());
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.WARNING, null, ex);
        }
        
        UIManager.LookAndFeelInfo[] lafInfo = UIManager.getInstalledLookAndFeels();
        for (int i = 0; i < lafInfo.length; i++) {
            createLafMenuItem(this.menuLookAndFeel, new LookAndFeelUI(lafInfo[i].getName(), lafInfo[i].getClassName()));
        }
        LookAndFeel laf = UIManager.getLookAndFeel();
        this.currentLookAndFeel = new LookAndFeelUI(laf.getName(), laf.getClass().getName());

        String lafName = currentLookAndFeel.getName();
        for (int i = 0; i < menuLookAndFeel.getItemCount(); i++) {
            JMenuItem item = menuLookAndFeel.getItem(i);
            item.setSelected(item.getText().equals(lafName));
        }

    }

    public JMenuItem createLafMenuItem(JMenu menu, LookAndFeelUI lafUI) {
        JMenuItem mi = (JRadioButtonMenuItem) menu.add(new JRadioButtonMenuItem(lafUI.getName()));
        this.lafMenuGroup.add(mi);
        mi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setLookAndFeel(lafUI);
            }
        });
        mi.setEnabled(isAvailableLookAndFeel(lafUI));
        return mi;
    }

    protected boolean isAvailableLookAndFeel(LookAndFeelUI lafUI) {
        try {
            Class lnfClass = Class.forName(lafUI.getClassName());
            LookAndFeel newLAF = (LookAndFeel) (lnfClass.newInstance());
            return newLAF.isSupportedLookAndFeel();
        } catch (Exception ex) { 
            Logger.getLogger(MainFrame.class.getName()).log(Level.WARNING, null, ex);
            return false;
        }
    }

    public void setLookAndFeel(LookAndFeelUI lafUI) {
        if (!this.currentLookAndFeel.equals(lafUI)) {
            this.currentLookAndFeel = lafUI;
            String lafName = lafUI.getName();
            updateLookAndFeel();
            for (int i = 0; i < this.menuLookAndFeel.getItemCount(); i++) {
                JMenuItem item = this.menuLookAndFeel.getItem(i);
                item.setSelected(item.getText().equals(lafName));
            }
        }
    }

    /**
     * Sets the current L&F on each demo module
     */
    public void updateLookAndFeel() {
        try {
            UIManager.setLookAndFeel(this.currentLookAndFeel.getClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuLookAndFeel;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables

    static class LookAndFeelUI {

        public String name;
        public String className;

        public LookAndFeelUI(String name, String className) {
            this.name = name;
            this.className = className;
        }

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @return the className
         */
        public String getClassName() {
            return className;
        }

        @Override
        public boolean equals(Object value) {
            if (value instanceof LookAndFeelUI) {
                LookAndFeelUI ui = (LookAndFeelUI) value;
                return ui.name.equals(this.name) && ui.className.equals(this.className);
            }
            return false;
        }

    }

}
