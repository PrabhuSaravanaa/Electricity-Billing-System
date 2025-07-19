package Electricity.Billing.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class pay_bill extends JFrame implements ActionListener {
    String meter;
    JLabel heading , meternumber , meternumbertext , name , nametext , month , unit , unittext , totalbill , totalbilltext , status , statustext ;
    Choice searchmonthcho ;
    JButton pay , back ;
    pay_bill(String meter){
        super("Pay Bill");
        this.meter = meter ;
        setLocation(300,150);
        setSize(900,600);

        Panel panel = new Panel();
        add(panel,"Center");


        heading = new JLabel("Pay Bill");
        heading.setFont(new Font("tahoma",Font.BOLD,24));
        heading.setBounds(120,5,400,30);
        add(heading);

        meternumber = new JLabel("Meter Number");
        meternumber.setBounds(35,80,200,20);
        add(meternumber);

        meternumbertext = new JLabel("");
        meternumbertext.setBounds(300,80,200,20);
        add(meternumbertext);

        name = new JLabel("Name");
        name.setBounds(35,140,200,20);
        add(name);

        nametext = new JLabel("");
        nametext.setBounds(300,140,200,20);
        add(nametext);

        month = new JLabel("Month");
        month.setBounds(35,200,200,20);
        add(month);

        searchmonthcho = new Choice();
        searchmonthcho.add("January");
        searchmonthcho.add("February");
        searchmonthcho.add("March");
        searchmonthcho.add("April");
        searchmonthcho.add("May");
        searchmonthcho.add("June");
        searchmonthcho.add("July");
        searchmonthcho.add("August");
        searchmonthcho.add("September");
        searchmonthcho.add("October");
        searchmonthcho.add("November");
        searchmonthcho.add("December");
        searchmonthcho.setBounds(300,200,100,20);
        add(searchmonthcho);

        unit = new JLabel("Unit");
        unit.setBounds(35,260,200,20);
        add(unit);

        unittext = new JLabel("");
        unittext.setBounds(300,260,200,20);
        add(unittext);

        totalbill = new JLabel("Total Bill");
        totalbill.setBounds(35,320,200,20);
        add(totalbill);

        totalbilltext = new JLabel("");
        totalbilltext.setBounds(300,320,200,20);
        add(totalbilltext);

        status = new JLabel("Status");
        status.setBounds(35,380,200,20);
        add(status);

        statustext = new JLabel("");
        statustext.setBounds(300,380,200,20);
        status.setForeground(Color.RED);
        add(statustext);

        try {
            Database c = new Database();
            ResultSet resultSet = c.statement.executeQuery("select * from new_customer where meterno = '"+meter+"' ");
            while (resultSet.next()){
                meternumbertext.setText(meter);
                nametext.setText(resultSet.getString("name"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }

        searchmonthcho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                //Database c = new Database();
                try {
                    Database c = new Database();
                    ResultSet resultSet = c.statement.executeQuery("select * from bill where meter_no ='"+meter+"' and month = '"+searchmonthcho.getSelectedItem()+"' ");
                    while (resultSet.next()){
                        unittext.setText(resultSet.getString("unit"));
                        totalbilltext.setText(resultSet.getString("total_bill"));
                        statustext.setText(resultSet.getString("status"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        pay = new JButton("Pay");
        pay.setBackground(Color.black);
        pay.setForeground(Color.white);
        pay.setBounds(100,460,100,25);
        pay.addActionListener(this);
        add(pay);


        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(230,460,100,25);
        back.addActionListener(this);
        add(back);

       // ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/splash/"))

        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
            if(e.getSource()==pay){
                try {
                    Database c = new Database();
                    c.statement.executeUpdate("update bill set status = 'Paid' where meter_no = '"+meter+"' and month = '"+searchmonthcho.getSelectedItem()+"' ");
                }catch (Exception E){
                    E.printStackTrace();
                }
                setVisible(false);
                new payment_bill(meter);
            }else{
                setVisible(false);
            }

    }

    public static void main(String[] args) {
        new pay_bill("");
    }
}
