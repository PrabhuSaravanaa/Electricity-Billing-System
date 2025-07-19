package Electricity.Billing.System;

import com.mysql.cj.xdevapi.Table;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterAbortException;
import java.awt.print.PrinterException;
import java.sql.ResultSet;

public class Customer_details extends JFrame implements ActionListener {

    JLabel searchmeter , searchname;
    Choice csearchmeter , csearchname ;
    JTable table ;
    JButton bsearch , bprint , bclose;

    Customer_details(){
        super("Customer Details");

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
            ResultSet resultset = c.statement.executeQuery("select * from new_customer");

            while (resultset.next()){
                csearchmeter.add(resultset.getString("meterno"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }

        searchname = new JLabel("Search By Name");
        searchname.setBounds(400,20,100,20);
        add(searchname);

        csearchname = new Choice();
        csearchname.setBounds(520,20,150,20);
        add(csearchname);

        try {
            Database c = new Database();
            ResultSet resultSet = c.statement.executeQuery("select * from new_customer");
            while(resultSet.next()){
                csearchname.add(resultSet.getString("name"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }

        table = new JTable();
        try {
            Database c = new Database();
            ResultSet resultset = c.statement.executeQuery("select * from new_customer");
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
                String query_search = "select * from new_customer where meterno  = '"+csearchmeter.getSelectedItem()+"' and name = '"+csearchname.getSelectedItem()+"' ";

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
        new Customer_details();
    }
}
