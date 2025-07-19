package Electricity.Billing.System;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class payment_bill extends JFrame implements ActionListener {

    JButton back ;
    String meter;
    payment_bill(String meter){
            this.meter = meter;
            JEditorPane j = new JEditorPane();
            j.setEditable(false);

            try {
                j.setPage("https://paytm.com/-links");
                j.setBounds(400,150,800,600);

            }catch (Exception E){
                E.printStackTrace();
                j.setContentType("text/html");
                j.setText("<html> Error! Error! Error! Error! Error! Error! </html>");
            }

            JScrollPane pane = new JScrollPane(j);
            add(pane);

            back = new JButton("Back");
            back.setBounds(640,20,80,30);
            back.addActionListener(this);
            j.add(back);


            setLocation(400,150);
            setSize(800,600);
            setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
            if(e.getSource()==back){
                setVisible(false);
                new pay_bill("");
            }
    }


    public static void main(String[] args) {
        new payment_bill("");
    }
}
