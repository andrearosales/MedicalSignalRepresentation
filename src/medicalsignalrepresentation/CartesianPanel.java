/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package medicalsignalrepresentation;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


/**
 *
 * @author aRosales
 * Class that individually manages each of the signals.
 */
class CartesianPanel extends JPanel implements ActionListener{
    private final Timer timer = new Timer(2000, this);
    // x-axis coord constants
    public static final int X_AXIS_FIRST_X_COORD = 50;
    public int X_AXIS_SECOND_X_COORD = 400;
    public int X_AXIS_Y_COORD = 400;
    
    // y-axis coord constants
    public static final int Y_AXIS_DATA_Y_COORD = 20;
    public static final int Y_AXIS_FIRST_Y_COORD = 30;
    public int Y_AXIS_SECOND_Y_COORD = 400;
    public static final int Y_AXIS_X_COORD = 50;
    
    //arrows of axis are represented with "hipotenuse" of
    //triangle
    // now we are define length of cathetas of that triangle
    public static final int FIRST_LENGHT = 10;
    public static final int SECOND_LENGHT = 5;
    
    // size of start coordinate lenght
    public static final int ORIGIN_COORDINATE_LENGHT = 6;
    public static final int point_lenght = 3;
    
    // distance of coordinate strings from axis
    public static final int AXIS_STRING_DISTANCE = 30;

    private double counter;
    private int counterTop;
    private ArrayList<Point2D.Double> listPoints;
    private String dataY;
    private boolean finish;
    private int column;
    private final int xCoordNumbers = 15;
    private final int yCoordNumbers = 10;
    private int yMinimum;
    private int yMaximum;
    private Color titleColor;
    private int cicle;
    private int xLength;
    
    /**
     * Method that allows the initialization of the specific data for each signal.
     * @param data - Title of the signal
     * @param minimum - Minimum value the signal can take
     * @param maximum - Maximum value the signal can take
     * @param color - Specified color for displaying the signal
     */
    public void setAxes(String data, int minimum, int maximum, Color color) {
        xLength = (X_AXIS_SECOND_X_COORD - X_AXIS_FIRST_X_COORD)
                / xCoordNumbers;
        counter=0;
        counterTop=0;
        cicle=0;
        finish=false;
        listPoints = new ArrayList<>();
        Point2D.Double origin = new Point2D.Double(counter, 0);
        listPoints.add(origin);
        counter++;
        dataY = data;
        yMinimum = minimum;
        yMaximum = maximum;
        titleColor = color;
        readFile();
        //printPoints();
    }
        
    /**
     * Method that reads the file where the points are stored.
     */
    public void readFile(){
        try
        {
            //listPoints.clear();
            
            POIFSFileSystem file = new POIFSFileSystem(new FileInputStream("File004.xls"));
            
            //Create Workbook instance holding reference to .xlsx file
            HSSFWorkbook workbook = new HSSFWorkbook(file);
            
            //Get first/desired sheet from the workbook
            HSSFSheet sheet = workbook.getSheetAt(1);
            
            Iterator<Row> rowIterator = sheet.iterator();
            Row titles = rowIterator.next();
            Iterator<Cell> titlesIterator = titles.cellIterator();
            int count = 0;
            while (titlesIterator.hasNext())
            {
                Cell cell = titlesIterator.next();
                //Check the cell type and format accordingly
                if(cell.getStringCellValue().equals(dataY)){
                    column = count;
                    break;
                }
                else{
                    count++;
                }
            }
            for(int i=1;i<=counterTop;i++){
                rowIterator.next();
            }
            int top = 0;
            while (rowIterator.hasNext() && top<xCoordNumbers)
            {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                for(int i=0;i<column;i++){
                    cellIterator.next();
                }
                Cell cell = cellIterator.next();
                Double yValue = null;
                yValue = cell.getNumericCellValue();
                Point2D.Double point = new Point2D.Double(counter, yValue);
                listPoints.add(point);
                counter++;
                counterTop++;
                top++;
            }
            if(!rowIterator.hasNext())
                finish=true;
            System.out.println("countertop "+counterTop);
            //counter=1;
            
            cicle++;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * Method that prints the stored points so far. Used for debugging purposes.
     */
    public void printPoints(){
        for(int i=0;i<listPoints.size();i++){
            System.out.println("x: " + listPoints.get(i).x + " y: " + listPoints.get(i).y);
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        
        // x-axis
        g2.drawLine(Y_AXIS_X_COORD, Y_AXIS_FIRST_Y_COORD,
                Y_AXIS_X_COORD, Y_AXIS_SECOND_Y_COORD);
        
        // y-axis arrow
        g2.drawLine(Y_AXIS_X_COORD - SECOND_LENGHT,
                Y_AXIS_FIRST_Y_COORD + FIRST_LENGHT,
                Y_AXIS_X_COORD, Y_AXIS_FIRST_Y_COORD);
        g2.drawLine(Y_AXIS_X_COORD + SECOND_LENGHT,
                Y_AXIS_FIRST_Y_COORD + FIRST_LENGHT,
                Y_AXIS_X_COORD, Y_AXIS_FIRST_Y_COORD);
        
        // draw origin Point
        g2.fillOval(
                X_AXIS_FIRST_X_COORD - (ORIGIN_COORDINATE_LENGHT / 2),
                Y_AXIS_SECOND_Y_COORD - (ORIGIN_COORDINATE_LENGHT / 2),
                ORIGIN_COORDINATE_LENGHT, ORIGIN_COORDINATE_LENGHT);
        
        Font font1 = new Font(g2.getFont().getFontName(), Font.BOLD, 12);
        g2.setFont(font1); 
        
        // x-axis arrow
        g2.drawLine(X_AXIS_FIRST_X_COORD + (listPoints.size() * xLength) - FIRST_LENGHT,
                X_AXIS_Y_COORD - SECOND_LENGHT,
                X_AXIS_FIRST_X_COORD + (listPoints.size() * xLength), X_AXIS_Y_COORD);
        g2.drawLine(X_AXIS_FIRST_X_COORD + (listPoints.size() * xLength) - FIRST_LENGHT,
                X_AXIS_Y_COORD + SECOND_LENGHT,
                X_AXIS_FIRST_X_COORD + (listPoints.size() * xLength), X_AXIS_Y_COORD);
        
        // draw text "X" and draw text "Y"
        g2.drawString("X", X_AXIS_FIRST_X_COORD + (listPoints.size() * xLength) ,
                X_AXIS_Y_COORD + AXIS_STRING_DISTANCE);
        g2.drawString(dataY, Y_AXIS_X_COORD - AXIS_STRING_DISTANCE,
                Y_AXIS_DATA_Y_COORD );
        g2.drawString("(0, 0)", X_AXIS_FIRST_X_COORD - AXIS_STRING_DISTANCE,
                Y_AXIS_SECOND_Y_COORD + AXIS_STRING_DISTANCE);
        
        Font font2 = new Font(g2.getFont().getFontName(), Font.PLAIN, 10);
        g2.setFont(font2); 
        
        
        // draw x-axis numbers
        for(int i = 1; i < listPoints.size(); i++) {
            g2.drawLine(X_AXIS_FIRST_X_COORD + (i * xLength),
                    X_AXIS_Y_COORD - SECOND_LENGHT,
                    X_AXIS_FIRST_X_COORD + (i * xLength),
                    X_AXIS_Y_COORD + SECOND_LENGHT);
            g2.drawLine(X_AXIS_FIRST_X_COORD + ((i) * xLength), X_AXIS_Y_COORD,
                X_AXIS_FIRST_X_COORD + ((i-1) * xLength), X_AXIS_Y_COORD);
        }
        g2.drawLine(X_AXIS_FIRST_X_COORD + (listPoints.size() * xLength), X_AXIS_Y_COORD,
                X_AXIS_FIRST_X_COORD + ((listPoints.size()-1) * xLength), X_AXIS_Y_COORD);
        for(int i = 1; i < listPoints.size(); i++) {
                g2.drawString(Integer.toString(i),
                        X_AXIS_FIRST_X_COORD + (i * xLength) - 3,
                        X_AXIS_Y_COORD + AXIS_STRING_DISTANCE);
            }
        
                
        int yLength;
        
        float division;
        if(yMaximum > yCoordNumbers){
            Float max = (float)yMaximum;
            yLength = (Y_AXIS_SECOND_Y_COORD - Y_AXIS_FIRST_Y_COORD)
                    / yCoordNumbers;
            //division = (int)Math.ceil(max / yCoordNumbers);
            division = max / yCoordNumbers;
            for(int i = 1; i < yCoordNumbers; i++) {
                g2.drawLine(Y_AXIS_X_COORD - SECOND_LENGHT,
                        Y_AXIS_SECOND_Y_COORD - (i * yLength),
                        Y_AXIS_X_COORD + SECOND_LENGHT,
                        Y_AXIS_SECOND_Y_COORD - (i * yLength));
                String result = String.format("%.2f", i * division);
                g2.drawString(result,
                        Y_AXIS_X_COORD - AXIS_STRING_DISTANCE,
                        Y_AXIS_SECOND_Y_COORD - (i * yLength));
            }
            g2.drawString(Double.toString(yCoordNumbers * division),
                        Y_AXIS_X_COORD - AXIS_STRING_DISTANCE,
                        Y_AXIS_SECOND_Y_COORD - (yCoordNumbers * yLength));
        }
        else{
            yLength = (Y_AXIS_SECOND_Y_COORD - Y_AXIS_FIRST_Y_COORD)
                / yMaximum;
            for(int i = yMinimum+1; i < yMaximum; i++) {
                g2.drawLine(Y_AXIS_X_COORD - SECOND_LENGHT,
                        Y_AXIS_SECOND_Y_COORD - (i * yLength),
                        Y_AXIS_X_COORD + SECOND_LENGHT,
                        Y_AXIS_SECOND_Y_COORD - (i * yLength));
                g2.drawString(Integer.toString(yMinimum+i),
                    Y_AXIS_X_COORD - AXIS_STRING_DISTANCE,
                    Y_AXIS_SECOND_Y_COORD - (i * yLength));
            }
            g2.drawString(Integer.toString(yMaximum),
                        Y_AXIS_X_COORD - AXIS_STRING_DISTANCE,
                        Y_AXIS_SECOND_Y_COORD - (yMaximum * yLength));
        }
        
        Stroke stroke = new BasicStroke(2f);
        float[] dashingPattern1 = {2f, 2f};
        Stroke stroke1 = new BasicStroke(0.5f, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER, 1.0f, dashingPattern1, 2.0f);
        
        for (int i=0;i<listPoints.size()-1;i++){
            g2.setStroke(stroke);
            g2.setColor(titleColor);
            Point2D.Double initial;
            Point2D.Double end;
            Point2D.Double initialVertical;
            Point2D.Double endVertical;
            Point2D.Double initialHorizontal;
            Point2D.Double endHorizontal;
            
            if(yMaximum > yCoordNumbers){
                initial = new Point2D.Double(X_AXIS_FIRST_X_COORD + (listPoints.get(i).x * xLength),
                        Y_AXIS_SECOND_Y_COORD - ((listPoints.get(i).y*yCoordNumbers/yMaximum) * yLength));
                end = new Point2D.Double(X_AXIS_FIRST_X_COORD + (listPoints.get(i+1).x * xLength),
                        Y_AXIS_SECOND_Y_COORD - ((listPoints.get(i+1).y*yCoordNumbers/yMaximum)* yLength));
                initialVertical = new Point2D.Double(X_AXIS_FIRST_X_COORD + (listPoints.get(i).x * xLength),
                        Y_AXIS_SECOND_Y_COORD);
                
                g2.draw(new Ellipse2D.Double(X_AXIS_FIRST_X_COORD + (listPoints.get(i).x * xLength) - (point_lenght / 2),
                        Y_AXIS_SECOND_Y_COORD - ((listPoints.get(i).y*yCoordNumbers/yMaximum) * yLength) - (point_lenght / 2),
                        point_lenght, point_lenght));
                
                endVertical = new Point2D.Double(X_AXIS_FIRST_X_COORD + (listPoints.get(i).x * xLength),
                        Y_AXIS_SECOND_Y_COORD - ((listPoints.get(i).y*yCoordNumbers/yMaximum) * yLength));
                initialHorizontal = new Point2D.Double(X_AXIS_FIRST_X_COORD,
                        Y_AXIS_SECOND_Y_COORD - ((listPoints.get(i).y*yCoordNumbers/yMaximum) * yLength));
                endHorizontal = new Point2D.Double(X_AXIS_FIRST_X_COORD + (listPoints.get(i).x * xLength),
                        Y_AXIS_SECOND_Y_COORD - ((listPoints.get(i).y*yCoordNumbers/yMaximum) * yLength));
            }
            else{
                initial = new Point2D.Double(X_AXIS_FIRST_X_COORD + (listPoints.get(i).x * xLength),
                        Y_AXIS_SECOND_Y_COORD - (listPoints.get(i).y * yLength));
                end = new Point2D.Double(X_AXIS_FIRST_X_COORD + (listPoints.get(i+1).x * xLength),
                        Y_AXIS_SECOND_Y_COORD - (listPoints.get(i+1).y * yLength));
                
                g2.draw(new Ellipse2D.Double(X_AXIS_FIRST_X_COORD + (listPoints.get(i).x * xLength) - (point_lenght / 2),
                        Y_AXIS_SECOND_Y_COORD - (listPoints.get(i).y * yLength) - (point_lenght / 2),
                        point_lenght, point_lenght));
                
                initialVertical = new Point2D.Double(X_AXIS_FIRST_X_COORD + (listPoints.get(i).x * xLength),
                        Y_AXIS_SECOND_Y_COORD);
                endVertical = new Point2D.Double(X_AXIS_FIRST_X_COORD + (listPoints.get(i).x * xLength),
                        Y_AXIS_SECOND_Y_COORD - (listPoints.get(i).y * yLength));
                initialHorizontal = new Point2D.Double(X_AXIS_FIRST_X_COORD,
                        Y_AXIS_SECOND_Y_COORD - (listPoints.get(i).y * yLength));
                endHorizontal = new Point2D.Double(X_AXIS_FIRST_X_COORD + (listPoints.get(i).x * xLength),
                        Y_AXIS_SECOND_Y_COORD - (listPoints.get(i).y * yLength));
            }
                        
            g2.draw(new Line2D.Double(initial,end));
            
            g2.setColor(Color.BLACK);
            g2.setStroke(stroke1);
            
            g2.draw(new Line2D.Double(initialVertical,endVertical));
            g2.draw(new Line2D.Double(initialHorizontal,endHorizontal));
            
        }
        Point2D.Double initialVertical;
        Point2D.Double endVertical;
        Point2D.Double initialHorizontal;
        Point2D.Double endHorizontal;
        if(yMaximum > yCoordNumbers){
            initialVertical = new Point2D.Double(X_AXIS_FIRST_X_COORD + (listPoints.get(listPoints.size()-1).x * xLength),
                    Y_AXIS_SECOND_Y_COORD);
            endVertical = new Point2D.Double(X_AXIS_FIRST_X_COORD + (listPoints.get(listPoints.size()-1).x * xLength),
                    Y_AXIS_SECOND_Y_COORD - ((listPoints.get(listPoints.size()-1).y*yCoordNumbers/yMaximum) * yLength));
            initialHorizontal = new Point2D.Double(X_AXIS_FIRST_X_COORD,
                    Y_AXIS_SECOND_Y_COORD - ((listPoints.get(listPoints.size()-1).y*yCoordNumbers/yMaximum) * yLength));
            endHorizontal = new Point2D.Double(X_AXIS_FIRST_X_COORD + (listPoints.get(listPoints.size()-1).x * xLength),
                    Y_AXIS_SECOND_Y_COORD - ((listPoints.get(listPoints.size()-1).y*yCoordNumbers/yMaximum) * yLength));
        }
        else{
            initialVertical = new Point2D.Double(X_AXIS_FIRST_X_COORD + (listPoints.get(listPoints.size()-1).x * xLength),
                    Y_AXIS_SECOND_Y_COORD);
            endVertical = new Point2D.Double(X_AXIS_FIRST_X_COORD + (listPoints.get(listPoints.size()-1).x * xLength),
                    Y_AXIS_SECOND_Y_COORD - (listPoints.get(listPoints.size()-1).y * yLength));
            initialHorizontal = new Point2D.Double(X_AXIS_FIRST_X_COORD,
                    Y_AXIS_SECOND_Y_COORD - (listPoints.get(listPoints.size()-1).y * yLength));
            endHorizontal = new Point2D.Double(X_AXIS_FIRST_X_COORD + (listPoints.get(listPoints.size()-1).x * xLength),
                    Y_AXIS_SECOND_Y_COORD - (listPoints.get(listPoints.size()-1).y * yLength));
        }
        
        g2.draw(new Line2D.Double(initialVertical,endVertical));
        g2.draw(new Line2D.Double(initialHorizontal,endHorizontal));
        
        if(!finish)
            timer.start();
        revalidate();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==timer){
            if(!finish){
                //removeAll();
                readFile();
                //printPoints();
                revalidate();
                repaint();// this will call at every s seconds
            }
            //else
              //  revalidate();
        }
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension((X_AXIS_FIRST_X_COORD*2) + (listPoints.size() * xLength), Y_AXIS_SECOND_Y_COORD+Y_AXIS_X_COORD);
        //return new Dimension((X_AXIS_FIRST_X_COORD*2) + X_AXIS_SECOND_X_COORD, Y_AXIS_SECOND_Y_COORD+Y_AXIS_X_COORD);
    }
}