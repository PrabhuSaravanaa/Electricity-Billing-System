package Electricity.Billing.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField Usertext, Passwordtext;
    Choice loginChoice;
    JButton loginbutton, cancelbutton, signupbutton;

    Login() {
        super("Login");
        getContentPane().setBackground(Color.white);

        JLabel Username = new JLabel("UserName");
        Username.setBounds(300, 60, 100, 20);
        add(Username);

        Usertext = new JTextField();
        Usertext.setBounds(400, 60, 120, 20);
        add(Usertext);

        JLabel Password = new JLabel("Password");
        Password.setBounds(300, 100, 120, 40);
        add(Password);

        Passwordtext = new JTextField();
        Passwordtext.setBounds(400, 110, 120, 20);
        add(Passwordtext);

        JLabel Loggin = new JLabel("Login In As");
        Loggin.setBounds(300, 140, 100, 40);
        add(Loggin);

        loginChoice = new Choice();
        loginChoice.add("Admin");
        loginChoice.add("Customer");
        loginChoice.setBounds(400, 150, 120, 40);
        add(loginChoice);

        loginbutton = new JButton("Login");
        loginbutton.setBounds(340, 190, 80, 20);
        loginbutton.addActionListener(this );
        add(loginbutton);

        cancelbutton = new JButton("Cancel");
        cancelbutton.setBounds(440, 190, 80, 20);
        cancelbutton.addActionListener(this );
        add(cancelbutton);

        signupbutton = new JButton("SignUp");
        signupbutton.setBounds(385, 225, 80, 20);
        signupbutton.addActionListener(this );
        add(signupbutton);


        setLayout(null);
        ImageIcon profilepic = new ImageIcon(ClassLoader.getSystemResource("icon/splash/profilepic.png"));
        Image imageone = profilepic.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon fprofilepic = new ImageIcon(imageone);
        JLabel profilepicture = new JLabel(fprofilepic);
        profilepicture.setBounds(0, 0, 250, 250);
        add(profilepicture);



        setLayout(null);
        setSize(640, 300);
        setLocation(400, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginbutton) {
            String susername = Usertext.getText();
            String spassword = Passwordtext.getText();
            String suser = loginChoice.getSelectedItem();

            try {
                Database c = new Database();
                String query = "Select * from signup where username = '"+susername+"' and password = '"+spassword+"' and usertype = '"+suser+"'";
                ResultSet resultset = c.statement.executeQuery(query);

                if(resultset.next()){
                    String meter = resultset.getString("meter_no");
                    setVisible(false);
                    new Main_class(suser,meter);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Login");
                }
            }

            catch (Exception E){
                E.printStackTrace();
            }
        }
        else if (e.getSource() == cancelbutton) {
            setVisible(false);
        }
        else if(e.getSource() == signupbutton){
            setVisible(false);
            new Signup();
        }
    }


        public static void main (String[]args){
            new Login();
        }
    }

