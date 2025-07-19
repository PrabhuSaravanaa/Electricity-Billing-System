package Electricity.Billing.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Signup extends JFrame implements ActionListener {
    JTextField employeeidtext,meternotext,usernametext,nametext,passwordtext;
    Choice createaccchoice;
    JButton createbutton,backbutton;
    Signup(){
        super("Signup Page");
        getContentPane().setBackground(new Color(154 , 202, 251));

        JLabel createaccas = new JLabel("Create Account As");
        createaccas.setBounds(30,40,100,20);
        add(createaccas);

        createaccchoice = new Choice();
        createaccchoice.add("Admin");
        createaccchoice.add("Customer");
        createaccchoice.setBounds(180,40,120,20);
        add(createaccchoice);

        JLabel meterno = new JLabel("Meter Number");
        meterno.setBounds(30,80,300,20);
        meterno.setVisible(false);
        add(meterno);

        meternotext = new JTextField();
        meternotext.setBounds(180,80,120,20);
        meternotext.setVisible(false);
        add(meternotext);

        JLabel employeeid = new JLabel("Employee ID");
        employeeid.setBounds(30,80,300,20);
        employeeid.setVisible(true);
        add(employeeid);

        employeeidtext = new JTextField();
        employeeidtext.setBounds(180,80,120,20);
        employeeidtext.setVisible(true);
        add(employeeidtext);

        createaccchoice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String user = createaccchoice.getSelectedItem();
                if(user.equals("Customer"))
                {
                    employeeid.setVisible(false);
                    employeeidtext.setVisible(false);
                    meterno.setVisible(true);
                    meternotext.setVisible(true);
                }
                else {
                    employeeid.setVisible(true);
                    employeeidtext.setVisible(true);
                    meterno.setVisible(false);
                    meternotext.setVisible(false);
                }
            }
        });

        JLabel username = new JLabel("User Name");
        username.setBounds(30,120,300,20);
        add(username);

        usernametext = new JTextField();
        usernametext.setBounds(180,120,120,20);
        add(usernametext);

        JLabel name = new JLabel("Name");
        name.setBounds(30,160,300,20);
        add(name);

        nametext = new JTextField();
        nametext.setBounds(180,160,120,20);
        add(nametext);

        meternotext.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }
            @Override
            public void focusLost(FocusEvent e) {
                try {
                    Database c = new Database();
                    //System.out.println("focus lostttttttttttttttt");
                    System.out.println(meternotext.getText());
                    ResultSet resultSet = c.statement.executeQuery("select * from signup where meter_no = '"+meternotext.getText()+"' ");
                    if (resultSet.next()){
                        nametext.setText(resultSet.getString("name"));
                    }

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JLabel password = new JLabel("Password");
        password.setBounds(30,200,300,20);
        add(password);

        passwordtext = new JTextField();
        passwordtext.setBounds(180,200,120,20);
        add(passwordtext);

        createbutton = new JButton("Create");
        createbutton.setBackground(new Color(96, 163, 230));
        createbutton.setForeground( Color.white);
        createbutton.setBounds(60,260,100,20);
        createbutton.addActionListener(this);
        add(createbutton);

        backbutton = new JButton("Back");
        backbutton.setBackground(new Color(96, 163, 230));
        backbutton.setForeground( Color.white);
        backbutton.setBounds(200,260,100,20);
        backbutton.addActionListener(this);
        add(backbutton);

        setLayout(null);

       ImageIcon Signup = new ImageIcon(ClassLoader.getSystemResource("icon/splash/signup.png"));
        Image imageone = Signup.getImage().getScaledInstance(220,220, Image.SCALE_DEFAULT);
        ImageIcon Signup2 = new ImageIcon(imageone);
        JLabel jlabelpic = new JLabel(Signup2);
        jlabelpic.setBounds(330,40,250,250);
        add(jlabelpic);

        setSize(600,360);
        setLocation(400,200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==createbutton){
            String screateaccchoice = createaccchoice.getSelectedItem();
            String susernametext    = usernametext.getText();
            String snametext = nametext.getText();
            String spasswordtext = passwordtext.getText();
            //System.out.println("enterrrrrrrrrrrrrrrrrrrrrrr");
            System.out.println( susernametext + screateaccchoice +  spasswordtext  );
            //System.out.println("before value");
            String smeternotext = meternotext.getText();
            //System.out.println("afterrrrrrrrrrrr");

            try {
                Database c = new Database();
                String query ;
                if (screateaccchoice.equals("Admin")) {
                    query = "insert into Signup value ('" + 0 + "','" + susernametext + "','" + snametext + "','" + spasswordtext + "','" + screateaccchoice + "')";
                }
                else {
                    query = "update signup set username = '"+susernametext+"' , password = '"+spasswordtext+"' , usertype='"+screateaccchoice+"' where meter_no = '"+smeternotext+"' ";
                }
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Account Created");

                setVisible(false);

                new Login();
            } catch (Exception E) {
                E.printStackTrace();
            }
        }
        else if (e.getSource() == backbutton) {
            setVisible(false);
            new Login();
        }



    }
    public static void main(String[] args) {
        new Signup();
    }
}
