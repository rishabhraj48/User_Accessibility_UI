package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {                                                                                // JFrame comes from the inside of swing package

    Splash(){

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/splash.jpg"));                //step 4    //to get the image from local storage or System memory, here getSystemResource is a static function used to get the system's location for image to be provided. Here imageIcon is a new object that is formed
        Image imageOne = imageIcon.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);         //step 7    //here we have to set three types of credentials after the use of getScaledInstance(), 1.image_breadth, 2.image_height, 3.image_type, these credensials are used to scale the image
        ImageIcon imageIcon2 = new ImageIcon( imageOne);                                                              //
        JLabel imageLabel = new JLabel(imageIcon2);                                                                  //step 5    //this image cannot be added in our page directly, so we have created an object here
        add(imageLabel);                                                                                            //step 6    //after this the image will get appear to the frame ,but not with proper size, the image size will be too much big



        setSize(600,400);        //step 1      //the size of the frame is set using the setSize() function
        setLocation(350, 100);         //step 3       //to relocate the frame in x and y axis, now the frame opens up from the given location
        setVisible(true);                    //step 2       //to make the visibility true we use the function setVisible(true),bcz the visibility of the JFrame is hidden by default
                                                                    // all the parts of code that you want to make visible in the frame like steps 1,2,3,4,5,6,7 should be placed above this, otherwise the image will not be visible

        //here we will use "sleep function" inside try and catch block bcz there are chances of getting some exceptions

        try{
            Thread.sleep(3000);             //step 8        //the screen holds for 3 seconds here
            setVisible(false);                   //step 9         //the frame will get disappear because of this
            new Login();                         //step 10        // It will take us to the login frame after the splash frame is closed
        }
        catch(Exception e){
            e.printStackTrace();                  //step 11      //this is same as system.out.println(e) which prints the error
            //System.out.println(e);
        }

    }

    public static void main(String[] args) {


        new Splash();                              // very first step due to which the new splash function gets called

    }
}













//JFrame comes from the inside of swing package
//Frames visibility is hidden by default
//to make the visibility true we use the function setVisible(true)