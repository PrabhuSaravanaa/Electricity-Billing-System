package Electricity.Billing.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;

public class Deposit_details extends JFrame implements ActionListener {
    JLabel searchmeter , searchmonth;
    Choice csearchmeter , csearchmonth ;
    JTable table ;
    JButton bsearch , bprint , bclose;

    Deposit_details(){
        super("Deposit Details");

        getContentPane().setBackground(new Color(192,186,254));
        setLayout(null);
        setLocation(400,200);
        setSize(700,500);

        searchmeter = new JLabel("Search By Meter Number");
        searchmeter.setBounds(20,20,150,20);
        add(searchmeter);

        csearchmeter = new Choice();
        csearchmeter.setBounds(180,20,150,20);
        add(csearchmeter);

        try {
            Database c = new Database();
            ResultSet resultset = c.statement.executeQuery("select * from bill");

            while (resultset.next()){
                csearchmeter.add(resultset.getString("meter_no"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }

        searchmonth = new JLabel("Search By Month");
        searchmonth.setBounds(400,20,100,20);
        add(searchmonth);

        csearchmonth = new Choice();
        csearchmonth.add("January");
        csearchmonth.add("February");
        csearchmonth.add("March");
        csearchmonth.add("April");
        csearchmonth.add("May");
        csearchmonth.add("June");
        csearchmonth.add("July");
        csearchmonth.add("August");
        csearchmonth.add("September");
        csearchmonth.add("October");
        csearchmonth.add("November");
        csearchmonth.add("December");
        csearchmonth.setBounds(520,20,150,20);      //csearchname = csearchmonth
        add(csearchmonth);

        table = new JTable();
        try {
            Database c = new Database();
            ResultSet resultset = c.statement.executeQuery("select * from bill");
            table.setModel(DbUtils.resultSetToTableModel(resultset));
        }catch (Exception E){
            E.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,100,700,500);
        scrollPane.setBackground(Color.white);
        add(scrollPane);

        bsearch = new JButton("Search");
        bsearch.setBounds(20,70,80,20);
        bsearch.setForeground(Color.black);
        bsearch.setBackground(Color.white);
        bsearch.addActionListener(this);
        add(bsearch);

        bprint = new JButton("Print");
        bprint.setBounds(120,70,80,20);
        bprint.setBackground(Color.white);
        bprint.setForeground(Color.black);
        bprint.addActionListener(this);
        add(bprint);

        bclose = new JButton("Close");
        bclose.setBounds(220,70,80,20);
        bclose.setForeground(Color.black);
        bclose.setBackground(Color.white);
        bclose.addActionListener(this);
        add(bclose);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==bsearch){
            String query_search = "select * from bill where meter_no  = '"+csearchmeter.getSelectedItem()+"' and month = '"+csearchmonth.getSelectedItem()+"' ";

            try {
                Database c = new Database();
                ResultSet resultSet = c.statement.executeQuery(query_search);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }catch (Exception E){
                E.printStackTrace();
            }

        } else if (e.getSource()==bprint) {
            try {
                table.print();
            }catch (PrinterException E){
                E.printStackTrace();
            }
        } else if (e.getSource()==bclose) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Deposit_details();
    }
}
