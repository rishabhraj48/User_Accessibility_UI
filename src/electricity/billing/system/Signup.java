package electricity.billing.system;

import javax.swing.*;                                                       //JFrame comes from the inside of Swing package
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Signup extends JFrame implements ActionListener
{

    Choice loginAsCho;
    TextField meterText, employerText, userNameText, nameText, passwordText;

    JButton createButton, backButton;
    Signup(){
        super("Signup page");


        // To change the frame background color we use
        getContentPane().setBackground(new Color(168,203,255));


        // This addAdminLabel will be visible if we are signing up for a new Admin
        ImageIcon addAdmin = new ImageIcon(ClassLoader.getSystemResource("icon/addUser5.png"));
        Image addAdminImg = addAdmin.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon addAdmin2 = new ImageIcon(addAdminImg);
        JLabel addAdminLabel = new JLabel(addAdmin2);
        addAdminLabel.setBounds(320,30,250,250);
        add(addAdminLabel);

        // This addUserLabel will be visible if we are signing up for a new customer
        ImageIcon addUser = new ImageIcon(ClassLoader.getSystemResource("icon/addUser4.png"));
        Image addUserImg = addUser.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon addUser2 = new ImageIcon(addUserImg);
        JLabel addUserLabel = new JLabel(addUser2);
        addUserLabel.setBounds(320,30,250,250);
        add(addUserLabel);


        JLabel createAs = new JLabel("Create Account As");
        createAs.setBounds(30,50,125,20);
        add(createAs);

                loginAsCho  = new Choice();
                loginAsCho.add("Admin");
                loginAsCho.add("Customer");
                loginAsCho.setBounds(170,50,120,20);
                add(loginAsCho);


        JLabel meterNo= new JLabel("Meter Number");
        meterNo.setBounds(30,100,125,20);
        meterNo.setVisible(false);                                                                  //It is set as false because the default selection choice is admin not customer
        add(meterNo);

                meterText = new TextField();
                meterText.setBounds(170,100,120,20);
                meterText.setVisible(false);
                add(meterText);


        JLabel employer= new JLabel("Employer Id");
        employer.setBounds(30,100,125,20);
        employer.setVisible(true);                                                                  //It is set as true because the default selection choice is admin
        add(employer);

                employerText = new TextField();
                employerText.setBounds(170,100,120,20);
                employerText.setVisible(true);
                add(employerText);


        JLabel userName = new JLabel("UserName");
        userName.setBounds(30,140,125,20);
        add(userName);

                userNameText = new TextField();
                userNameText.setBounds(170,140,125,20);
                add(userNameText);


        JLabel name = new JLabel("Name");
        name.setBounds(30,180,125,20);
        add(name);

                nameText = new TextField();
                nameText.setBounds(170,180,125,20);
                add(nameText);


        JLabel password = new JLabel("Password");
        password.setBounds(30,220,125,20);
        add(password);

                passwordText = new TextField();
                passwordText.setBounds(170,220,125,20);
                add(passwordText);



        loginAsCho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                String user = loginAsCho.getSelectedItem();
                if(user.equals("Customer")){
                        employer.setVisible(false);
                        employerText.setVisible(false);
                        meterNo.setVisible(true);
                        meterText.setVisible(true);


                    addUserLabel.setVisible(true);
                    addAdminLabel.setVisible(false);

                }
                else{

                        employer.setVisible(true);
                        employerText.setVisible(true);
                        meterNo.setVisible(false);
                        meterText.setVisible(false);

                     addUserLabel.setVisible(false);
                     addAdminLabel.setVisible(true);

                }

            }
        });


        createButton = new JButton("Create");
        createButton.setBackground(new Color(66,127,219));                                                                   // with the use of color picker we selects the RGB value of any color, we can set the default value of the color by using Color.white
        createButton.setForeground(Color.white);                                                                                      // with the help of foreground we change the color of the text in the button
        createButton.setBounds(50,285,100,25);
        createButton.addActionListener(this);                                                                                       //
        add(createButton);


        backButton = new JButton("back");
        backButton.setBackground(new Color(66,127,219));
        backButton.setForeground(Color.white);
        backButton.setBounds(180,285,100,25);
        backButton.addActionListener(this);
        add(backButton);




        setSize(600,380);
        setLocation(350,200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {                                                                                       // It tells that which button has been clicked
            if(e.getSource() == createButton){

                String sloginAs = loginAsCho.getSelectedItem();
                String susername = userNameText.getText();
                String sname = nameText.getText();
                String spassword = passwordText.getText();
                String smeter= meterText.getText();

                try{
                    Database c= new Database();
                    String query = null;
                    query = "insert into Signup value('"+smeter+"', '"+susername+"', '"+sname+"', '"+spassword+"','"+sloginAs+"' )";

                    c.statement.executeUpdate(query);

                    //Used to show some message dialog
                    JOptionPane.showMessageDialog(null,"Account Created" );
                    setVisible(false);
                    new Login();

                }
                catch(Exception E){
                    E.printStackTrace();
                }


            }
            else if(e.getSource() == backButton){
                setVisible(false);
                new Login();
            }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
