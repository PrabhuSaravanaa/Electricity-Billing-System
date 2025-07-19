package Electricity.Billing.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MeterInformation extends JFrame implements ActionListener {
    JLabel meternumber , meternumber2 , metertype , phasecode , billtype ;
    Choice choicemeternumber , choicemetertype , choicephasecode, choicebilltype ;
    JButton select ;
    String meterNumber;
    MeterInformation(String meterNumbern){
        super("Meter Information");
        this.meterNumber = meterNumbern;
        setSize(700,500);
        setLocation(400,200);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(252,186,3));
        add(panel);

        JLabel heading = new JLabel("Meter Information");
        heading.setFont(new Font("tahoma",Font.BOLD,20));
        heading.setBounds(180,10,250,20);
        panel.add(heading);

        meternumber = new JLabel("Meter Number");
        meternumber.setBounds(40,80,180,20);
        panel.add(meternumber);

        JLabel meternumberT = new JLabel(meterNumbern);
        meternumberT.setBounds(220,80,180,20);
        panel.add(meternumberT);

        meternumber2 = new JLabel("Meter Number");
        meternumber2.setBounds(40,130,180,20);
        panel.add(meternumber2);

        metertype = new JLabel("Meter Typer");
        metertype.setBounds(40,180,180,20);
        panel.add(metertype);

        phasecode = new JLabel("Phase Code");
        phasecode.setBounds(40,230,180,20);
        panel.add(phasecode);

        billtype = new JLabel("Bill Type");
        billtype.setBounds(40,280,180,20);
        panel.add(billtype);

        JLabel Day = new JLabel("30 Days Billing Time...");
        Day.setBounds(40,320,180,20);
        panel.add(Day);

        JLabel Note = new JLabel("Note:-");
        Note.setBounds(40,360,180,20);
        panel.add(Note);

        JLabel Note2 = new JLabel("By default bill is calculated for 30 days only");
        Note2.setBounds(40,380,500,20);
        panel.add(Note2);

        choicemeternumber = new Choice();
        choicemeternumber.add("Outside");
        choicemeternumber.add("Inside");
        choicemeternumber.setBounds(220,130,120,20);
        panel.add(choicemeternumber);

        choicemetertype = new Choice();
        choicemetertype.add("Electric Meter");
        choicemetertype.add("Solar Meter");
        choicemetertype.add("Smart Meter");
        choicemetertype.setBounds(220,180,120,20);
        panel.add(choicemetertype);

        choicephasecode = new Choice();
        choicephasecode.add("011");
        choicephasecode.add("022");
        choicephasecode.add("033");
        choicephasecode.add("044");
        choicephasecode.add("055");
        choicephasecode.add("066");
        choicephasecode.add("077");
        choicephasecode.add("088");
        choicephasecode.add("099");
        choicephasecode.setBounds(220,230,120,20);
        panel.add(choicephasecode);

        choicebilltype = new Choice();
        choicebilltype.add("Normal");
        choicebilltype.add("Industrial");
        choicebilltype.setBounds(220,280,120,20);
        panel.add(choicebilltype);

        select = new JButton("Submit");
        select.setBounds(240,420,80,20);
        select.setBackground(Color.BLACK);
        select.addActionListener(this);
        select.setForeground(Color.white);
        panel.add(select);

        setLayout(new BorderLayout());
        add(panel,"Center");

        ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("icon/splash/details.png"));
        Image image = imageicon.getImage().getScaledInstance(230,200,Image.SCALE_DEFAULT);
        ImageIcon imageicon2 = new ImageIcon(image);
        JLabel jlabelimg = new JLabel(imageicon2);
        add(jlabelimg,"East");

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==select){
            String smeternum = meterNumber;
            String schoicemeternumber = choicemeternumber.getSelectedItem();
            String schoicemetertype = choicemetertype.getSelectedItem();
            String schoicephasecode = choicephasecode.getSelectedItem();
            String schoicebilltype = choicebilltype.getSelectedItem();
            String sday = "30";

            String query_meterinfo = "insert into meter_info values ('"+smeternum+"' , '"+schoicemeternumber+"' , '"+schoicemetertype+"' , '"+schoicephasecode+"' , '"+schoicebilltype+"' , '"+sday+"' )";


            try {
                Database c = new Database();
                c.statement.executeUpdate(query_meterinfo);

                JOptionPane.showMessageDialog(null,"Meter Information Submitted Successfully");
                setVisible(false);
            }
            catch (Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {

        new MeterInformation("");
    }
}
