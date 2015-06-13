/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package medicalsignalrepresentation;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author aRosales
 * Class that initially allows the selection of the signal plots to be displayed.
 */
public class SignalOptions extends JFrame{
    private JCheckBox FIO2;
    private JCheckBox FEO2;
    private JCheckBox FICO2;
    private JCheckBox FECO2;
    private JCheckBox FETCO2;
    private JCheckBox FETO2;
    private JCheckBox VE;
    private JCheckBox RR;
    private JCheckBox TI;
    private JCheckBox TE;
    private JCheckBox HR;
    private JCheckBox VO2;
    private JLabel title;
    private JButton button;
    private ArrayList<String> options;

    /**
     *  Constructor of the class that initializes the container with all the possible signal options.
     */
    public SignalOptions() {
        FIO2 = new JCheckBox("Fraction of inspired oxygen (FIO2)");
        FEO2 = new JCheckBox("Fraction of expired oxygen (FEO2)");
        FICO2 = new JCheckBox("Fraction of inspired carbon dioxide (FICO2)");
        FECO2 = new JCheckBox("Fraction of expired carbon dioxide (FECO2)");
        FETCO2 = new JCheckBox("Fraction of end-tidal carbon dioxide (FETCO2)");
        FETO2 = new JCheckBox("Fraction of end-tidal oxygen (FETO2)");
        VE = new JCheckBox("Ventilation (VE)");
        RR = new JCheckBox("Respiratory rate (RR)");
        TI= new JCheckBox("Inspiratory time (IT)");
        TE = new JCheckBox("Expiratory time (ET)");
        HR = new JCheckBox("Heart rate (HR)");
        VO2 = new JCheckBox("Oxygen consumption (VO2)");
        
        title = new JLabel("Select the physiological signals to visualize");
        title.setAlignmentX(CENTER_ALIGNMENT);
        
        JPanel containerChecks = new JPanel();
        containerChecks.setLayout(new GridLayout(6,2));
        containerChecks.add(FIO2);
        containerChecks.add(FEO2);
        containerChecks.add(FICO2);
        containerChecks.add(FECO2);
        containerChecks.add(FETCO2);
        containerChecks.add(FETO2);
        containerChecks.add(VE);
        containerChecks.add(RR);
        containerChecks.add(TI);
        containerChecks.add(TE);
        containerChecks.add(HR);
        containerChecks.add(VO2);
        
        button = new JButton("Continue");
        button.setAlignmentX(CENTER_ALIGNMENT);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                options = new ArrayList<String>();
                if(FIO2.isSelected()){
                    options.add("FIO2");
                }
                if(FEO2.isSelected()){
                    options.add("FEO2");
                }
                if(FICO2.isSelected()){
                    options.add("FICO2");
                }
                if(FECO2.isSelected()){
                    options.add("FECO2");
                }
                if(FETCO2.isSelected()){
                    options.add("FETCO2");
                }
                if(FETO2.isSelected()){
                    options.add("FETO2");
                }
                if(VE.isSelected()){
                    options.add("VE");
                }
                if(RR.isSelected()){
                    options.add("RR");
                }
                if(TI.isSelected()){
                    options.add("TI");
                }
                if(TE.isSelected()){
                    options.add("TE");
                }
                if(HR.isSelected()){
                    options.add("HR");
                }
                if(VO2.isSelected()){
                    options.add("VO2");
                }
                for(int i=0; i<options.size();i++)
                    System.out.println(options.get(i));
                setVisible(false);
                CartesianFrame frame = new CartesianFrame(options);
                frame.showUI();
            }
        });
        
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        add(title);
        add(containerChecks);
        add(button);
        
    }
    
    /**
     *  Method that allows the visualization of the frame with the different options.
     */
    public void showUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Physiological Signals");
        pack();
        setVisible(true);
    }
    
        
}
