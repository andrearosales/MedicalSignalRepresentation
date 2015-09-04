/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package medicalsignalrepresentation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author aRosales
 * Class that plots the selected physiological signals.
 */
class CartesianFrame extends JFrame implements ItemListener{
    private ArrayList<String> signals;
    private BigPanel bigPanel;
    private JPanel containerChecks;
    private JCheckBox FIO2;
    private JCheckBox FEO2;
    //private JCheckBox FICO2;
    private JCheckBox FECO2;
    private JCheckBox FETCO2;
    private JCheckBox FETO2;
    private JCheckBox VE;
    //private JCheckBox RR;
    private JCheckBox TI;
    private JCheckBox TE;
    private JCheckBox HR;
    private JCheckBox VO2;
    private Container contFIO2;
    private Container contFEO2;
    //private Container contFICO2;
    private Container contFECO2;
    private Container contFETCO2;
    private Container contFETO2;
    private Container contVE;
    //private Container contRR;
    private Container contTI;
    private Container contTE;
    private Container contHR;
    private Container contVO2;
    
    /**
     * Constructor of the class that initializes the initial plots with the received selected options.
     * @param options - List of initially selected signals
     */
    public CartesianFrame(ArrayList<String> options){
        signals = options;
        setSize(1000, 800);
        initializeOptions();
            setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        
            //Adding the General Title
            
            JLabel labelTitle = new JLabel();
            labelTitle.setText("MEDICAL PHYSIOLOGICAL SIGNALS");
            labelTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(labelTitle);
            
            //Adding each separate container
            bigPanel = new BigPanel(labelTitle.getHeight());
            bigPanel.setLayout(new BoxLayout(bigPanel, BoxLayout.Y_AXIS));
            
            for(int i=0; i<signals.size(); i++){
                String selected = signals.get(i);
                
                if(selected.equalsIgnoreCase("FIO2")) {
                    contFIO2= new Container();
                    contFIO2.setLayout(new BoxLayout(contFIO2, BoxLayout.Y_AXIS));
                    
                    JLabel title = new JLabel();
                    title.setAlignmentX(Component.CENTER_ALIGNMENT);
                    title.setText("Fraction of inspired oxygen (FIO2)");
                    contFIO2.add(title);
                    
                    CartesianPanel panel = new CartesianPanel();
                    panel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    panel.setAxes("FIO2", 0, 22, Color.BLACK);
                    JScrollPane scroll = new JScrollPane(panel);
                    contFIO2.add(scroll);
                    
                    bigPanel.add(contFIO2);
                    FIO2.setSelected(true);
                }
                else if(selected.equalsIgnoreCase("FEO2")){
                    contFEO2= new Container();
                    contFEO2.setLayout(new BoxLayout(contFEO2, BoxLayout.Y_AXIS));
                    
                    JLabel title = new JLabel();
                    title.setAlignmentX(Component.CENTER_ALIGNMENT);
                    title.setText("Fraction of expired oxygen (FEO2)");
                    contFEO2.add(title);
                    
                    CartesianPanel panel = new CartesianPanel();
                    panel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    panel.setAxes("FEO2", 0, 22, Color.LIGHT_GRAY);
                    JScrollPane scroll = new JScrollPane(panel);
                    contFEO2.add(scroll);
                    
                    bigPanel.add(contFEO2);
                    FEO2.setSelected(true);
                }
                /*else if(selected.equalsIgnoreCase("FICO2")){
                    contFICO2= new Container();
                    contFICO2.setLayout(new BoxLayout(contFICO2, BoxLayout.Y_AXIS));
                    
                    JLabel title = new JLabel();
                    title.setAlignmentX(Component.CENTER_ALIGNMENT);
                    title.setText("Fraction of inspired carbon dioxide (FICO2)");
                    contFICO2.add(title);
                    
                    CartesianPanel panel = new CartesianPanel();
                    panel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    panel.setAxes("FICO2", 0, 1, Color.DARK_GRAY);
                    JScrollPane scroll = new JScrollPane(panel);
                    contFICO2.add(scroll);
                    
                    bigPanel.add(contFICO2);
                    FICO2.setSelected(true);
                }*/
                else if(selected.equalsIgnoreCase("FECO2")){
                    contFECO2= new Container();
                    contFECO2.setLayout(new BoxLayout(contFECO2, BoxLayout.Y_AXIS));
                    
                    JLabel title = new JLabel();
                    title.setAlignmentX(Component.CENTER_ALIGNMENT);
                    title.setText("Fraction of expired carbon dioxide (FECO2)");
                    contFECO2.add(title);
                    
                    CartesianPanel panel = new CartesianPanel();
                    panel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    panel.setAxes("FECO2", 0, 8, Color.YELLOW);
                    JScrollPane scroll = new JScrollPane(panel);
                    contFECO2.add(scroll);
                    
                    bigPanel.add(contFECO2);
                    FECO2.setSelected(true);
                }
                else if(selected.equalsIgnoreCase("FETCO2")){
                    contFETCO2= new Container();
                    contFETCO2.setLayout(new BoxLayout(contFETCO2, BoxLayout.Y_AXIS));
                    
                    JLabel title = new JLabel();
                    title.setAlignmentX(Component.CENTER_ALIGNMENT);
                    title.setText("Fraction of end-tidal carbon dioxide (FETCO2)");
                    contFETCO2.add(title);
                    
                    CartesianPanel panel = new CartesianPanel();
                    panel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    panel.setAxes("FETCO2", 0, 10, Color.PINK);
                    JScrollPane scroll = new JScrollPane(panel);
                    contFETCO2.add(scroll);
                    
                    bigPanel.add(contFETCO2);
                    FETCO2.setSelected(true);
                }
                else if(selected.equalsIgnoreCase("FETO2")){
                    contFETO2= new Container();
                    contFETO2.setLayout(new BoxLayout(contFETO2, BoxLayout.Y_AXIS));
                    
                    JLabel title = new JLabel();
                    title.setAlignmentX(Component.CENTER_ALIGNMENT);
                    title.setText("Fraction of end-tidal oxygen (FETO2)");
                    contFETO2.add(title);
                    
                    CartesianPanel panel = new CartesianPanel();
                    panel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    panel.setAxes("FETO2", 0, 21, Color.ORANGE);
                    JScrollPane scroll = new JScrollPane(panel);
                    contFETO2.add(scroll);
                    
                    bigPanel.add(contFETO2);
                    FETO2.setSelected(true);
                }
                else if(selected.equalsIgnoreCase("VE")){
                    contVE= new Container();
                    contVE.setLayout(new BoxLayout(contVE, BoxLayout.Y_AXIS));
                    
                    JLabel title = new JLabel();
                    title.setAlignmentX(Component.CENTER_ALIGNMENT);
                    title.setText("Ventilation (VE)");
                    contVE.add(title);
                    
                    CartesianPanel panel = new CartesianPanel();
                    panel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    panel.setAxes("VE", 0, 234, Color.MAGENTA);
                    JScrollPane scroll = new JScrollPane(panel);
                    contVE.add(scroll);
                    
                    bigPanel.add(contVE);
                    VE.setSelected(true);
                }
                /*else if(selected.equalsIgnoreCase("RR")){
                    contRR= new Container();
                    contRR.setLayout(new BoxLayout(contRR, BoxLayout.Y_AXIS));
                    
                    JLabel title = new JLabel();
                    title.setAlignmentX(Component.CENTER_ALIGNMENT);
                    title.setText("Respiratory rate (RR)");
                    contRR.add(title);
                    
                    CartesianPanel panel = new CartesianPanel();
                    panel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    panel.setAxes("RR", 6, 47, Color.GREEN);
                    JScrollPane scroll = new JScrollPane(panel);
                    contRR.add(scroll);
                    
                    bigPanel.add(contRR);
                    RR.setSelected(true);
                }*/
                else if(selected.equalsIgnoreCase("TI")){
                    contTI= new Container();
                    contTI.setLayout(new BoxLayout(contTI, BoxLayout.Y_AXIS));
                    
                    JLabel title = new JLabel();
                    title.setAlignmentX(Component.CENTER_ALIGNMENT);
                    title.setText("Inspiratory time (IT)");
                    contTI.add(title);
                    
                    CartesianPanel panel = new CartesianPanel();
                    panel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    panel.setAxes("TI", 0, 6, Color.GRAY);
                    JScrollPane scroll = new JScrollPane(panel);
                    contTI.add(scroll);
                    
                    bigPanel.add(contTI);
                    TI.setSelected(true);
                }
                else if(selected.equalsIgnoreCase("TE")){
                    contTE= new Container();
                    contTE.setLayout(new BoxLayout(contTE, BoxLayout.Y_AXIS));
                    
                    JLabel title = new JLabel();
                    title.setAlignmentX(Component.CENTER_ALIGNMENT);
                    title.setText("Expiratory time (ET)");
                    contTE.add(title);
                    
                    CartesianPanel panel = new CartesianPanel();
                    panel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    panel.setAxes("TE", 0, 12, Color.CYAN);
                    JScrollPane scroll = new JScrollPane(panel);
                    contTE.add(scroll);
                    
                    bigPanel.add(contTE);
                    TE.setSelected(true);
                }
                else if(selected.equalsIgnoreCase("HR")){
                    contHR= new Container();
                    contHR.setLayout(new BoxLayout(contHR, BoxLayout.Y_AXIS));
                    
                    JLabel title = new JLabel();
                    title.setAlignmentX(Component.CENTER_ALIGNMENT);
                    title.setText("Heart rate (HR)");
                    contHR.add(title);
                    
                    CartesianPanel panel = new CartesianPanel();
                    panel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    panel.setAxes("HR", 33, 215, Color.RED);
                    JScrollPane scroll = new JScrollPane(panel);
                    contHR.add(scroll);
                    
                    bigPanel.add(contHR);
                    HR.setSelected(true);
                }
                else if(selected.equalsIgnoreCase("VO2")){
                    contVO2= new Container();
                    contVO2.setLayout(new BoxLayout(contVO2, BoxLayout.Y_AXIS));
                    
                    JLabel title = new JLabel();
                    title.setAlignmentX(Component.CENTER_ALIGNMENT);
                    title.setText("Oxygen consumption (VO2)");
                    contVO2.add(title);
                    
                    CartesianPanel panel = new CartesianPanel();
                    panel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    panel.setAxes("VO2", 0, 6411, Color.BLUE);
                    JScrollPane scroll = new JScrollPane(panel);
                    contVO2.add(scroll);
                    
                    bigPanel.add(contVO2);
                    VO2.setSelected(true);
                }
            }
            
            JScrollPane bigScrollPanel = new JScrollPane(bigPanel);
            add(bigScrollPanel);
            add(containerChecks);
        
    }

    /**
     * Default constructor of the class that will initialize the main panels.
     */
    CartesianFrame() {
        setSize(1000, 800);
        initializeOptions();
            setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        
            //Adding the General Title
            
            JLabel labelTitle = new JLabel();
            labelTitle.setText("MEDICAL PHYSIOLOGICAL SIGNALS");
            labelTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(labelTitle);
            
            //Adding the greater container
            bigPanel = new BigPanel(labelTitle.getHeight());
            bigPanel.setLayout(new BoxLayout(bigPanel, BoxLayout.Y_AXIS));
            
            JScrollPane bigScrollPanel = new JScrollPane(bigPanel);
            add(bigScrollPanel);
            add(containerChecks);
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        
        Object source = e.getItemSelectable();
        if(source == FIO2){
            if (e.getStateChange() == ItemEvent.DESELECTED) {
                bigPanel.remove(contFIO2);
                contFIO2=null;
            }
            else {
                if(contFIO2==null){
                    contFIO2= new Container();
                    contFIO2.setLayout(new BoxLayout(contFIO2, BoxLayout.Y_AXIS));
                    
                    JLabel title = new JLabel();
                    title.setAlignmentX(Component.CENTER_ALIGNMENT);
                    title.setText("Fraction of inspired oxygen (FIO2)");
                    contFIO2.add(title);
                    
                    CartesianPanel panel = new CartesianPanel();
                    panel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    panel.setAxes("FIO2", 0, 1, Color.BLACK);
                    panel.setBackground(Color.white);
                    JScrollPane scroll = new JScrollPane(panel);
                    contFIO2.add(scroll);
                    
                    bigPanel.add(contFIO2);
                }
            }
        }
        else if(source == FEO2){
            if (e.getStateChange() == ItemEvent.DESELECTED) {
                bigPanel.remove(contFEO2);
                contFEO2=null;
            }
            else {
                if(contFEO2==null){
                    contFEO2= new Container();
                    contFEO2.setLayout(new BoxLayout(contFEO2, BoxLayout.Y_AXIS));
                    
                    JLabel title = new JLabel();
                    title.setAlignmentX(Component.CENTER_ALIGNMENT);
                    title.setText("Fraction of expired oxygen (FEO2)");
                    contFEO2.add(title);
                    
                    CartesianPanel panel = new CartesianPanel();
                    panel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    panel.setAxes("FEO2", 0, 1, Color.LIGHT_GRAY);
                    panel.setBackground(Color.white);
                    JScrollPane scroll = new JScrollPane(panel);
                    contFEO2.add(scroll);
                    
                    bigPanel.add(contFEO2);
                }
            }
        }
        /*else if(source == FICO2){
            if (e.getStateChange() == ItemEvent.DESELECTED) {
                bigPanel.remove(contFICO2);
                contFICO2=null;
            }
            else {
                if(contFICO2==null){
                    contFICO2= new Container();
                    contFICO2.setLayout(new BoxLayout(contFICO2, BoxLayout.Y_AXIS));
                    
                    JLabel title = new JLabel();
                    title.setAlignmentX(Component.CENTER_ALIGNMENT);
                    title.setText("Fraction of inspired carbon dioxide (FICO2)");
                    contFICO2.add(title);
                    
                    CartesianPanel panel = new CartesianPanel();
                    panel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    panel.setAxes("FICO2", 0, 1, Color.DARK_GRAY);
                    panel.setBackground(Color.white);
                    JScrollPane scroll = new JScrollPane(panel);
                    contFICO2.add(scroll);
                    
                    bigPanel.add(contFICO2);
                }
            }
        }*/
        else if(source == FECO2){
            if (e.getStateChange() == ItemEvent.DESELECTED) {
                bigPanel.remove(contFECO2);
                contFECO2=null;
            }
            else {
                if(contFECO2==null){
                    contFECO2= new Container();
                    contFECO2.setLayout(new BoxLayout(contFECO2, BoxLayout.Y_AXIS));
                    
                    JLabel title = new JLabel();
                    title.setAlignmentX(Component.CENTER_ALIGNMENT);
                    title.setText("Fraction of expired carbon dioxide (FECO2)");
                    contFECO2.add(title);
                    
                    CartesianPanel panel = new CartesianPanel();
                    panel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    panel.setAxes("FECO2", 0, 1, Color.YELLOW);
                    panel.setBackground(Color.white);
                    JScrollPane scroll = new JScrollPane(panel);
                    contFECO2.add(scroll);
                    
                    bigPanel.add(contFECO2);
                }
            }
        }
        else if(source == FETCO2){
            if (e.getStateChange() == ItemEvent.DESELECTED) {
                bigPanel.remove(contFETCO2);
                contFETCO2=null;
            }
            else {
                if(contFETCO2==null){
                    contFETCO2= new Container();
                    contFETCO2.setLayout(new BoxLayout(contFETCO2, BoxLayout.Y_AXIS));
                    
                    JLabel title = new JLabel();
                    title.setAlignmentX(Component.CENTER_ALIGNMENT);
                    title.setText("Fraction of end-tidal carbon dioxide (FETCO2)");
                    contFETCO2.add(title);
                    
                    CartesianPanel panel = new CartesianPanel();
                    panel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    panel.setAxes("FETCO2", 0, 1, Color.PINK);
                    panel.setBackground(Color.white);
                    JScrollPane scroll = new JScrollPane(panel);
                    contFETCO2.add(scroll);
                    
                    bigPanel.add(contFETCO2);
                }
            }
        }
        else if(source == FETO2){
            if (e.getStateChange() == ItemEvent.DESELECTED) {
                bigPanel.remove(contFETO2);
                contFETO2=null;
            }
            else {
                if(contFETO2==null){
                    contFETO2= new Container();
                    contFETO2.setLayout(new BoxLayout(contFETO2, BoxLayout.Y_AXIS));
                    
                    JLabel title = new JLabel();
                    title.setAlignmentX(Component.CENTER_ALIGNMENT);
                    title.setText("Fraction of end-tidal oxygen (FETO2)");
                    contFETO2.add(title);
                    
                    CartesianPanel panel = new CartesianPanel();
                    panel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    panel.setAxes("FETO2", 0, 1, Color.ORANGE);
                    panel.setBackground(Color.white);
                    JScrollPane scroll = new JScrollPane(panel);
                    contFETO2.add(scroll);
                    
                    bigPanel.add(contFETO2);
                }
            }
        }
        else if(source == VE){
            if (e.getStateChange() == ItemEvent.DESELECTED) {
                bigPanel.remove(contVE);
                contVE=null;
            }
            else {
                if(contVE==null){
                    contVE= new Container();
                    contVE.setLayout(new BoxLayout(contVE, BoxLayout.Y_AXIS));
                    
                    JLabel title = new JLabel();
                    title.setAlignmentX(Component.CENTER_ALIGNMENT);
                    title.setText("Ventilation (VE)");
                    contVE.add(title);
                    
                    CartesianPanel panel = new CartesianPanel();
                    panel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    panel.setAxes("VE", 7, 76, Color.MAGENTA);
                    panel.setBackground(Color.white);
                    JScrollPane scroll = new JScrollPane(panel);
                    contVE.add(scroll);
                    
                    bigPanel.add(contVE);
                }
            }
        }
        /*else if(source == RR){
            if (e.getStateChange() == ItemEvent.DESELECTED) {
                bigPanel.remove(contRR);
                contRR=null;
            }
            else {
                if(contRR==null){
                    contRR= new Container();
                    contRR.setLayout(new BoxLayout(contRR, BoxLayout.Y_AXIS));
                    
                    JLabel title = new JLabel();
                    title.setAlignmentX(Component.CENTER_ALIGNMENT);
                    title.setText("Respiratory rate (RR)");
                    contRR.add(title);
                    
                    CartesianPanel panel = new CartesianPanel();
                    panel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    panel.setAxes("RR", 6, 47, Color.GREEN);
                    panel.setBackground(Color.white);
                    JScrollPane scroll = new JScrollPane(panel);
                    contRR.add(scroll);
                    
                    bigPanel.add(contRR);
                }
            }
        }*/
        else if(source == TI){
            if (e.getStateChange() == ItemEvent.DESELECTED) {
                bigPanel.remove(contTI);
                contTI=null;
            }
            else {
                if(contTI==null){
                    contTI= new Container();
                    contTI.setLayout(new BoxLayout(contTI, BoxLayout.Y_AXIS));
                    
                    JLabel title = new JLabel();
                    title.setAlignmentX(Component.CENTER_ALIGNMENT);
                    title.setText("Inspiratory time (IT)");
                    contTI.add(title);
                    
                    CartesianPanel panel = new CartesianPanel();
                    panel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    panel.setAxes("TI", 0, 4, Color.GRAY);
                    panel.setBackground(Color.white);
                    JScrollPane scroll = new JScrollPane(panel);
                    contTI.add(scroll);
                    
                    bigPanel.add(contTI);
                }
            }
        }
        else if(source == TE){
            if (e.getStateChange() == ItemEvent.DESELECTED) {
                bigPanel.remove(contTE);
                contTE=null;
            }
            else {
                if(contTE==null){
                    contTE= new Container();
                    contTE.setLayout(new BoxLayout(contTE, BoxLayout.Y_AXIS));
                    
                    JLabel title = new JLabel();
                    title.setAlignmentX(Component.CENTER_ALIGNMENT);
                    title.setText("Expiratory time (ET)");
                    contTE.add(title);
                    
                    CartesianPanel panel = new CartesianPanel();
                    panel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    panel.setAxes("TE", 0, 7, Color.CYAN);
                    panel.setBackground(Color.white);
                    JScrollPane scroll = new JScrollPane(panel);
                    contTE.add(scroll);
                    
                    bigPanel.add(contTE);
                }
            }
        }
        else if(source == HR){
            if (e.getStateChange() == ItemEvent.DESELECTED) {
                bigPanel.remove(contHR);
                contHR=null;
            }
            else {
                if(contHR==null){
                    contHR= new Container();
                    contHR.setLayout(new BoxLayout(contHR, BoxLayout.Y_AXIS));
                    
                    JLabel title = new JLabel();
                    title.setAlignmentX(Component.CENTER_ALIGNMENT);
                    title.setText("Heart rate (HR)");
                    contHR.add(title);
                    
                    CartesianPanel panel = new CartesianPanel();
                    panel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    panel.setAxes("HR", 58, 164, Color.RED);
                    panel.setBackground(Color.white);
                    JScrollPane scroll = new JScrollPane(panel);
                    contHR.add(scroll);
                    
                    bigPanel.add(contHR);
                }
            }
        }
        else if(source == VO2){
            if (e.getStateChange() == ItemEvent.DESELECTED) {
                bigPanel.remove(contVO2);
                contVO2=null;
            }
            else {
                if(contVO2==null){
                    contVO2= new Container();
                    contVO2.setLayout(new BoxLayout(contVO2, BoxLayout.Y_AXIS));
                    
                    JLabel title = new JLabel();
                    title.setAlignmentX(Component.CENTER_ALIGNMENT);
                    title.setText("Oxygen consumption (VO2)");
                    contVO2.add(title);
                    
                    CartesianPanel panel = new CartesianPanel();
                    panel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    panel.setAxes("VO2", 0, 2, Color.BLUE);
                    panel.setBackground(Color.white);
                    JScrollPane scroll = new JScrollPane(panel);
                    contVO2.add(scroll);
                    
                    bigPanel.add(contVO2);
                }
            }
        }
        //bigPanel.remove();
        revalidate();
        repaint();
    }
    
    /**
     * Method that initializes the panel with all the possible signal options.
     */
    public void initializeOptions(){
        
        FIO2 = new JCheckBox("Fraction of inspired oxygen (FIO2)");
        FIO2.addItemListener(this);
        FEO2 = new JCheckBox("Fraction of expired oxygen (FEO2)");
        FEO2.addItemListener(this);
        //FICO2 = new JCheckBox("Fraction of inspired carbon dioxide (FICO2)");
        //FICO2.addItemListener(this);
        FECO2 = new JCheckBox("Fraction of expired carbon dioxide (FECO2)");
        FECO2.addItemListener(this);
        FETCO2 = new JCheckBox("Fraction of end-tidal carbon dioxide (FETCO2)");
        FETCO2.addItemListener(this);
        FETO2 = new JCheckBox("Fraction of end-tidal oxygen (FETO2)");
        FETO2.addItemListener(this);
        VE = new JCheckBox("Ventilation (VE)");
        VE.addItemListener(this);
        //RR = new JCheckBox("Respiratory rate (RR)");
        //RR.addItemListener(this);
        TI= new JCheckBox("Inspiratory time (IT)");
        TI.addItemListener(this);
        TE = new JCheckBox("Expiratory time (ET)");
        TE.addItemListener(this);
        HR = new JCheckBox("Heart rate (HR)");
        HR.addItemListener(this);
        VO2 = new JCheckBox("Oxygen consumption (VO2)");
        VO2.addItemListener(this);
        
        containerChecks = new JPanel();
        //containerChecks.setLayout(new GridLayout(6,2));
        containerChecks.setLayout(new GridLayout(5,2));
        containerChecks.add(FIO2);
        containerChecks.add(FEO2);
        //containerChecks.add(FICO2);
        containerChecks.add(FECO2);
        containerChecks.add(FETCO2);
        containerChecks.add(FETO2);
        containerChecks.add(VE);
        //containerChecks.add(RR);
        containerChecks.add(TI);
        containerChecks.add(TE);
        containerChecks.add(HR);
        containerChecks.add(VO2);
        
    }
    
    /**
     * Method that allows the visualization of the frame with the different options and the selected plots.
     */
    public void showUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Medical Signal Representation");
        //pack();
        
        setVisible(true);
    }
    
    
    
}
