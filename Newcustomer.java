package Electricity.Billing.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Newcustomer extends JFrame implements ActionListener {

        JLabel heading , newcustomer , meternumbertext , meternumber , address , city , state ,email , phone ;
        TextField nametext  , addresstext , citytext , statetext , emailtext , phonetext ;
        JButton next , cancel;

    Newcustomer(){
        super("New Customer");
        setSize(700,500);
        setLocation(400,200);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(252,186,3));
        add(panel);

        heading = new JLabel("New Customer");
        heading.setBounds(200,10,250,20);
        heading.setFont(new Font("tahoma",Font.BOLD,20));
        panel.add(heading);

        newcustomer = new JLabel("New Customer");
        newcustomer.setBounds(30,80,100,20);
        panel.add(newcustomer);

        nametext = new TextField();
        nametext.setBounds(180,80,150,20);
        panel.add(nametext);

        meternumber = new JLabel("Meter Number ");
        meternumber.setBounds(30,120,100,20);
        panel.add(meternumber);

        meternumbertext = new JLabel("");
        meternumbertext.setBounds(180,120,150,20);

        Random ran = new Random();
        long number = ran.nextLong() % 1000000;
        meternumbertext.setText(" "+ Math.abs(number));
        panel.add(meternumbertext);

        address = new JLabel("Address");
        address.setBounds(30,160,100,20);
        panel.add(address);

        addresstext = new TextField();
        addresstext.setBounds(180,160,150,20);
        panel.add(addresstext);

        city = new JLabel("City");
        city.setBounds(30,200,100,20);
        panel.add(city);

        citytext = new TextField();
        citytext.setBounds(180,200,150,20);
        panel.add(citytext);

        state = new JLabel("State");
        state.setBounds(30,240,100,20);
        panel.add(state);

        statetext = new TextField();
        statetext.setBounds(180,240,150,20);
        panel.add(statetext);

        email = new JLabel("Email");
        email.setBounds(30,280,100,20);
        panel.add(email);

        emailtext = new TextField();
        emailtext.setBounds(180,280,150,20);
        panel.add(emailtext);

        phone = new JLabel("phone");
        phone.setBounds(30,320,100,20);
        panel.add(phone);

        phonetext = new TextField();
        phonetext.setBounds(180,320,150,20);
        panel.add(phonetext);

        next = new JButton("Next");
        next.setBounds(80,380,80,20);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.addActionListener(this);
        panel.add(next);

        cancel = new JButton("Cancel");
        cancel.setBounds(240,380,80,20);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        panel.add(cancel);

        setLayout(new BorderLayout());
        add(panel,"Center");

        ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("icon/splash/boy.png"));
        Image image = imageicon.getImage().getScaledInstance(230,200,Image.SCALE_DEFAULT);
        ImageIcon imageicon2 = new ImageIcon(image);
        JLabel imageiconlabel = new JLabel(imageicon2);
        add(imageiconlabel,"West");

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==next){
            String sname = nametext.getText();
            String smeternumber = meternumbertext.getText();
            String saddress = addresstext.getText();
            String scity = citytext.getText();
            String sstate = statetext.getText();
            String semail = emailtext.getText();
            String sphone = phonetext.getText();

            String query_customer = "insert into new_customer values('"+sname+"' , '"+smeternumber+"' , '"+saddress+"' , '"+scity+"' , '"+sstate+"' , '"+semail+"' , '"+sphone+"')";
            String query_signup = "insert into signup values('"+smeternumber+"','','"+sname+"','','')";

            try {
                    Database c = new Database();
                    c.statement.executeUpdate(query_customer);
                    c.statement.executeUpdate(query_signup);

                    JOptionPane.showMessageDialog(null , "Customer Details Added Successfully");
                    setVisible(false);
                    new MeterInformation(smeternumber);
            }
            catch (Exception E){
                E.printStackTrace();
            }

        }else {
            setVisible(false);
        }
    }

       public static void main(String[] args) {
        new Newcustomer();
    }
}
