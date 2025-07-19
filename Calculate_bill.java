package Electricity.Billing.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class Calculate_bill extends JFrame implements ActionListener {

    JLabel name , nametext , address , addresstext , unitconsumed , month;
    Choice cmeternumber , cmonth;
    TextField unitconsumedtext ;
    JButton submit , cancel ;

    Calculate_bill(){

        Panel panel= new Panel();
        panel.setLayout(null);
        panel.setBackground(new Color(214,195,247));
        add(panel);

        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(70,10,300,20);
        heading.setFont(new Font("tahoma",Font.BOLD,20));
        panel.add(heading);

        JLabel meternumber = new JLabel("Meter Number ");
        meternumber.setBounds(50,80,100,20);
        panel.add(meternumber);

        cmeternumber = new Choice();
        try {
            Database c = new Database();
            ResultSet resultset = c.statement.executeQuery("select * from new_customer");
            while (resultset.next()){
                cmeternumber.add(resultset.getString("meterno"));
            }
        } catch (Exception E) {
            E.printStackTrace();
        }

        cmeternumber.setBounds(180,80,100,20);
        panel.add(cmeternumber);

        name = new JLabel("Name");
        name.setBounds(50,120,100,20);
        panel.add(name);

        nametext = new JLabel("");
        nametext.setBounds(180,120,150,20);
        panel.add(nametext);

        address = new JLabel("Address");
        address.setBounds(50,160,100,20);
        panel.add(address);

        addresstext = new JLabel("");
        addresstext.setBounds(180,160,150,20);
        panel.add(addresstext);

        try {
                Database c = new Database();
                ResultSet resultSet = c.statement.executeQuery("select * from new_customer where meterno = '"+cmeternumber.getSelectedItem() +"'  ");
                while (resultSet.next()){
                    nametext.setText(resultSet.getString("name"));
                    addresstext.setText(resultSet.getString("address"));
                }
        } catch (Exception E) {
            E.printStackTrace();
        }

        cmeternumber.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Database c = new Database();
                    ResultSet resultSet = c.statement.executeQuery("select * from new_customer where meterno = '"+cmeternumber.getSelectedItem() +"'  ");
                    while (resultSet.next()){
                        nametext.setText(resultSet.getString("name"));
                        addresstext.setText(resultSet.getString("address"));
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        unitconsumed = new JLabel("Unit Consumed");
        unitconsumed.setBounds(50,200,100,20);
        panel.add(unitconsumed);

        unitconsumedtext = new TextField();
        unitconsumedtext.setBounds(180,200,120,20);
        panel.add(unitconsumedtext);

        month = new JLabel("Month");
        month.setBounds(50,240,100,20);
        panel.add(month);

        cmonth = new Choice();
        cmonth.add("January");
        cmonth.add("February");
        cmonth.add("March");
        cmonth.add("April");
        cmonth.add("May");
        cmonth.add("June");
        cmonth.add("July");
        cmonth.add("August");
        cmonth.add("September");
        cmonth.add("October");
        cmonth.add("November");
        cmonth.add("December");
        cmonth.setBounds(180,240,120,20);
        panel.add(cmonth);

        submit = new JButton("Submit");
        submit.setBounds(60,300,100,20);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        panel.add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(200,300,100,20);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        panel.add(cancel);

        setLayout(new BorderLayout());
        add(panel,"Center");
        ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("icon/splash/budget.png"));
        Image image = imageicon.getImage().getScaledInstance(240,200,Image.SCALE_DEFAULT);
        ImageIcon imageicon2 = new ImageIcon(image);
        JLabel jlabelimg = new JLabel(imageicon2);
        add(jlabelimg,"East");

        setSize(650,400);
        setLocation(400,200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==submit){
            String smeterno = cmeternumber.getSelectedItem();
            String sunit =  unitconsumedtext.getText();
            String smonth = cmonth.getSelectedItem();

            int total_bill = 0;
            int units = Integer.parseInt(sunit);
            String query_tax = "select * from tax";
            try {
                    Database c = new Database();
                    ResultSet resultSet = c.statement.executeQuery(query_tax);
                    while(resultSet.next()){
                        total_bill += units * Integer.parseInt(resultSet.getString("cost_per_unit"));
                        total_bill += Integer.parseInt(resultSet.getString("meter_rent"));
                        total_bill += Integer.parseInt(resultSet.getString("service_charge"));
                        total_bill += Integer.parseInt(resultSet.getString("swacch_bharat"));
                        total_bill += Integer.parseInt(resultSet.getString("fixed_tax"));
                    }
            }catch (Exception E){
                E.printStackTrace();
            }

            String query_total_bill = "insert into bill values('"+smeterno+"' , '"+smonth+"' , '"+sunit+"' , '"+total_bill+"' , 'Not Paid')" ;
            try {
                Database c = new Database();
                c.statement.executeUpdate(query_total_bill);
                JOptionPane.showMessageDialog(null , "Customer Bill Updated Successfully");
                setVisible(false);
            }catch (Exception E){
                E.printStackTrace();
            }



        } else if (e.getSource()==cancel) {
            setVisible(false);
        }

    }
    public static void main(String[] args) {
        new Calculate_bill();
    }
}
