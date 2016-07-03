package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import javax.swing.*;

public class Controller {
    public static boolean isValid(double side1, double side2, double side3) {
        //double[] sideCycle = {side1, side2, side3};

        if(side1 + side2 < side3 | side2 + side3 < side1 |
                side3 + side1 < side2) {
        return false;
        }
        return true;
    }
    public static double area(double side1, double side2, double side3) {
    double s = (side1+side2+side3) / 2;
    double area = Math.sqrt(s*((s - side1) * (s - side2) * (s - side3)));
    return area; //returns area of the triangle
    }

    @FXML private TextField side1;
    @FXML private TextField side2;
    @FXML private TextField side3;
    @FXML private Text outputText;
    // Xs from action^
    static double side1Calc;
    static double side2Calc;
    static double side3Calc;
    //Xs ^ Ys v
    @FXML
    public void checkSides(ActionEvent actionEvent) {
        try {
            side1Calc = Double.parseDouble(side1.getText());
            side2Calc = Double.parseDouble(side2.getText());
            side3Calc = Double.parseDouble(side3.getText());
        }catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error! must input all values!");
        }
        //pulled X values ^
        if(!isValid(side1Calc, side2Calc, side3Calc)) {
            outputText.setText("Invalid");
        } else {
            outputText.setText("area is " +area(side1Calc, side2Calc, side3Calc));
        }
    }

}


