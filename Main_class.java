package Electricity.Billing.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame implements ActionListener {

    String acctype;
    String meter_pass ;
    Main_class(String acctype , String meter_pass){
        this.acctype= acctype;
        this.meter_pass = meter_pass;
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/splash/ebs.png"));
        Image image = imageIcon.getImage().getScaledInstance(1530,830,Image.SCALE_DEFAULT);
        ImageIcon imageicon2 = new ImageIcon(image);
        JLabel jimage = new JLabel(imageicon2);
        add(jimage);


        JMenuBar Menubar = new JMenuBar();
        setJMenuBar(Menubar);

        JMenu menu = new JMenu("Menu");
        menu.setFont(new Font("serif",Font.PLAIN,10));
        //below it has

        JMenu info = new JMenu("Information");
        info.setFont(new Font("serif",Font.PLAIN,10));
        //Menubar.add(info);

        JMenu user = new JMenu("User");
        user.setFont(new Font("serif",Font.PLAIN,10));
        //Menubar.add(user);

        JMenu bill = new JMenu("Bill");
        bill.setFont(new Font("serif",Font.PLAIN,10));
        //Menubar.add(bill);

        JMenu utility = new JMenu("Utility");
        utility.setFont(new Font("serif",Font.PLAIN,10));
        //Menubar.add(utility);

        JMenu exit = new JMenu("Exit");
        exit.setFont(new Font("serif",Font.PLAIN,10));
        //Menubar.add(exit);

        JMenuItem newcustomer = new JMenuItem("New Customer");
        newcustomer.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon imgnewcustomer = new ImageIcon(ClassLoader.getSystemResource("icon/splash/newcustomer.png"));
        Image cusimage = imgnewcustomer.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        newcustomer.setIcon(new ImageIcon(cusimage));
        newcustomer.addActionListener(this);
        menu.add(newcustomer);

        JMenuItem customerdetails = new JMenuItem("Cutomer Details");
        customerdetails.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon cusdetailimg = new ImageIcon(ClassLoader.getSystemResource("icon/splash/customerDetails.png"));
        Image cusdetailimg2 = cusdetailimg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        customerdetails.setIcon(new ImageIcon(cusdetailimg2));
        customerdetails.addActionListener(this);
        menu.add(customerdetails);

        JMenuItem depositdetails = new JMenuItem("Deposit Details");
        depositdetails.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon depositdetailsimg = new ImageIcon(ClassLoader.getSystemResource("icon/splash/depositdetails.png"));
        Image depositdetailsimg2 = depositdetailsimg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        depositdetails.setIcon(new ImageIcon(depositdetailsimg2));
        depositdetails.addActionListener(this);
        menu.add(depositdetails);

        JMenuItem calculatebill = new JMenuItem("Calculate Bill");
        calculatebill.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon calculatebillimg = new ImageIcon(ClassLoader.getSystemResource("icon/splash/calculatorbills.png"));
        Image calculatebillimg2 = calculatebillimg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculatebill.setIcon(new ImageIcon(calculatebillimg2));
        calculatebill.addActionListener(this);
        menu.add(calculatebill);

        JMenuItem upinfo = new JMenuItem("Update Information");
        upinfo.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon upinfoimg = new ImageIcon(ClassLoader.getSystemResource("icon/splash/refresh.png"));
        Image upinfoimg2 = upinfoimg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        upinfo.setIcon(new ImageIcon(upinfoimg2));
        upinfo.addActionListener(this);
        info.add(upinfo);

        JMenuItem viewinfo = new JMenuItem("View Information");
        viewinfo.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon viewinfoimg = new ImageIcon(ClassLoader.getSystemResource("icon/splash/information.png"));
        Image viewinfoimg2 = viewinfoimg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        viewinfo.setIcon(new ImageIcon(viewinfoimg2));
        viewinfo.addActionListener(this);
        info.add(viewinfo);

        JMenuItem paybill = new JMenuItem("Pay Bill");
        paybill.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon paybillimg = new ImageIcon(ClassLoader.getSystemResource("icon/splash/pay.png"));
        Image paybillimg2 = paybillimg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        paybill.setIcon(new ImageIcon(paybillimg2));
        paybill.addActionListener(this);
        user.add(paybill);

        JMenuItem billdetails = new JMenuItem("Bill Details");
        billdetails.setFont(new Font ("monosoaced",Font.PLAIN,12));
        ImageIcon billdetailsimg = new ImageIcon(ClassLoader.getSystemResource("icon/splash/detail.png"));
        Image billdetailsimg2 = billdetailsimg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        billdetails.setIcon(new ImageIcon(billdetailsimg2));
        billdetails.addActionListener(this);
        user.add(billdetails);

        JMenuItem genbill = new JMenuItem("Generate Bill");
        genbill.setFont(new Font ("monospaced",Font.PLAIN,12));
        ImageIcon genbillimg = new ImageIcon(ClassLoader.getSystemResource("icon/splash/bill.png"));
        Image genbillimg2 = genbillimg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        genbill.setIcon(new ImageIcon(genbillimg2));
        genbill.addActionListener(this);
        bill.add(genbill);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font ("monospaced",Font.PLAIN,12));
        ImageIcon notepadimg = new ImageIcon(ClassLoader.getSystemResource("icon/splash/notepad.png"));
        Image notepadimg2 = notepadimg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(notepadimg2));
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setFont(new Font ("monospaced",Font.PLAIN,12));
        ImageIcon calculatorimg = new ImageIcon(ClassLoader.getSystemResource("icon/splash/calculator.png"));
        Image calculatorimg2 = calculatorimg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(calculatorimg2));
        calculator.addActionListener(this);
        utility.add(calculator);

        JMenuItem eexit = new JMenuItem("Exit");
        eexit.setFont(new Font ("monospaced",Font.PLAIN,12));
        ImageIcon eexitimg = new ImageIcon(ClassLoader.getSystemResource("icon/splash/exit.png"));
        Image eexitimg2 = eexitimg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        eexit.setIcon(new ImageIcon(eexitimg2));
        eexit.addActionListener(this);
        exit.add(eexit);



            /*Menubar.add(menu);
            Menubar.add(bill);
            Menubar.add(user);
            Menubar.add(info);
        Menubar.add(utility);
        Menubar.add(exit);*/


        if (acctype.equals("Admin")){
            Menubar.add(menu);
        }else {
            Menubar.add(bill);
            Menubar.add(user);
            Menubar.add(info);
        }
        Menubar.add(utility);
        Menubar.add(exit);

        setLayout(new FlowLayout());
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        String msg = e.getActionCommand();
        if(msg.equals("New Customer")){
            new Newcustomer();
        } else if (msg.equals("Cutomer Details")) {
            new Customer_details();
        } else if (msg.equals("Deposit Details")) {
            new Deposit_details();
        } else if (msg.equals("Calculate Bill")) {
            new Calculate_bill();
        } else if (msg.equals("View Information")) {
            new View_information(meter_pass);
        } else if (msg.equals(("Update Information"))) {
            new Update_information(meter_pass);
        } else if (msg.equals("Bill Details")) {
            new bill_details(meter_pass);
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception E ){
                E.printStackTrace();
            }
        } else if (msg.equals("Exit")) {
            setVisible(false);
            new Login();
        } else if (msg.equals("Pay Bill")) {
            new pay_bill(meter_pass);
        } else if (msg.equals("Generate Bill")) {
            new generate_bill(meter_pass);
        }

    }

    public static void main(String[] args) {
        new Main_class("" , "");
    }
}
