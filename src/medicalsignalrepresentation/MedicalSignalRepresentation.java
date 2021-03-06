/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicalsignalrepresentation;

import javax.swing.SwingUtilities;

/**
 * Main class of the project. Runs the panel with the physiological signals that
 * can be displayed.
 *
 * @author aRosales
 */
public class MedicalSignalRepresentation {

    /**
     * Main method that starts the plot visualization.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                CartesianFrame frame = new CartesianFrame();
                frame.showUI();
            }
        });
    }

}
