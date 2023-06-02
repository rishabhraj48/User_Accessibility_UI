package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    JTextField userText, passwordText;                                              //Here we have declared userText and passwordText globally so that we do not get problem during connectivity from the backend
    Choice loginChoice;                                                             //Here we have declared loginChoice globally so that we do not get any problem during backend connectivity

    JButton loginButton, cancelButton, signupButton;
    Login(){
        super("User-Login");                                                    //It is the java rule to write the super statement in very first line of the constructor, It is used to give the heading of the frame
        getContentPane().setBackground(Color.white);
        JLabel username = new JLabel("UserName");                               //step 17            //JLabel is mainly used to make the text visible in our frame
        username.setBounds(300,60,100,20);                         //step 19            //here we set the height, width of the label in frame
        add(username);                                                               //step 18            //

                userText = new JTextField();                                        //JTextField() is used to take input from the user
                userText.setBounds(400,60,150,20);
                add(userText);


        JLabel password = new JLabel("Password");
        password.setBounds(300,100,100,20);
        add(password);

                passwordText = new JTextField();
                passwordText.setBounds(400,100,150,20);
                add(passwordText);


        JLabel loggin = new JLabel("Logged In As");
        loggin.setBounds(300,140,100,20);
        add(loggin);

                loginChoice= new Choice();                                             //Choice() is used to make dropdown
                loginChoice.add("Admin");                                              //Here loginChoice.add() is used to lists
                loginChoice.add("Customer");
                loginChoice.setBounds(400,140,150,20);
                add(loginChoice);


        loginButton= new JButton("Login");
        loginButton.setBounds(330,180,100,20);
        loginButton.addActionListener(this);
        add(loginButton);


        cancelButton= new JButton("Cancel");
        cancelButton.setBounds(460,180,100,20);
        cancelButton.addActionListener(this);
        add(cancelButton);


        signupButton= new JButton("SignUp");
        signupButton.setBounds(400,215,100,20);
        signupButton.addActionListener(this);
        add(signupButton);


        ImageIcon profileOne = new ImageIcon(ClassLoader.getSystemResource("icon/user2.png"));
        Image profileTwo = profileOne.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon fprofileOne = new ImageIcon(profileTwo);
        JLabel profileLable = new JLabel(fprofileOne);
        profileLable.setBounds(10,10,250,250);
        add(profileLable);




        setSize(640, 300);                                                //step 13       //size of login page is set
        setLocation(350, 200);                                                   //step 15
        setLayout(null);                                                               //step 16      //the default border layout is removed which is the default layout, there are different kinds of layouts to design our frame but we have to customize our frame by our own so, we remove our default layout
        setVisible(true);                                                              //step 14



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton){

        }

        else if(e.getSource() == cancelButton){
            setVisible(false);
        }

        else if(e.getSource() == signupButton){
            setVisible(false);
            new Signup();
        }
    }

    public static void main(String[] args){

        new Login();
    }
}
