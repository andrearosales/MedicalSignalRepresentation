/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package medicalsignalrepresentation;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author aRosales
 * Panel that contains the plots of the signal the user selected.
 */
public class BigPanel extends JPanel {
    
    private ArrayList<String> signals;

    /**
     * Specific height of each plot.
     */
    public static int Y_AXIS_AMOUNT = 450;

    /**
     * Initial width of each plot.
     */
    public static int X_AXIS_AMOUNT = 100;
    private static int xLength = 23;
    private static int xCoordNumbers = 23;
    private int titleAmount;
    
    /**
     * Constructor of the class that initializes the values that are needed to specify the panel dimension.
     * @param height - Height of the title label
     */
    public BigPanel(int height) {
        titleAmount = height;
    }
    
    
    
    @Override
    public Dimension getPreferredSize() {
        //return new Dimension(X_AXIS_AMOUNT + (xCoordNumbers * xLength), (Y_AXIS_AMOUNT*signals.size())+titleAmount);
        return new Dimension(X_AXIS_AMOUNT + (xCoordNumbers * xLength), (Y_AXIS_AMOUNT*this.getComponents().length)+titleAmount);
    }
    
}
