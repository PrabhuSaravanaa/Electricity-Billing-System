package Electricity.Billing.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class View_information extends JFrame implements ActionListener {

            JLabel heading , namelabel , namelabeltext , meterno , meternotext , address , addresstext , city , citytext , state , statetext , email , emailtext , phone , phonetext;
            String view ;
            JButton cancel ;

    View_information(String view){
            this.view = view;
            setBounds(350,150,850,650);
            getContentPane().setBackground(Color.white);


            heading = new JLabel("View Customer Information");
            heading.setBounds(250,0,500,40);
            add(heading);

            namelabel = new JLabel("Name");
            namelabel.setBounds(70,80,100,20);
            add(namelabel);

            namelabeltext = new JLabel("");
            namelabeltext.setBounds(200,80,150,20);
            add(namelabeltext);

            meterno = new JLabel("Meter number");
            meterno.setBounds(70,140,100,20);
            add(meterno);

            meternotext = new JLabel("");
            meternotext.setBounds(200,140,150,20);
            add(meternotext);

            address = new JLabel("Address");
            address.setBounds(70,200,100,20);
            add(address);

            addresstext = new JLabel("");
            addresstext.setBounds(200,200,150,20);
            add(addresstext);


            city = new JLabel("City");
            city.setBounds(70,260,100,20);
            add(city);

            citytext = new JLabel("");
            citytext.setBounds(200,260,150,20);
            add(citytext);

            state = new JLabel("State");
            state.setBounds(500,80,100,20);
            add(state);

            statetext = new JLabel("");
            statetext.setBounds(600,80,150,20);
            add(statetext);

            email = new JLabel("Email");
            email.setBounds(500,140,100,20);
            add(email);

            emailtext = new JLabel("");
            emailtext.setBounds(600,140,150,20);
            add(emailtext);

            phone = new JLabel("Phone");
            phone.setBounds(500,200,100,20);
            add(phone);

            phonetext = new JLabel("");
            phonetext.setBounds(600,200,150,20);
            add(phonetext);

            try {
                Database c = new Database();
                ResultSet resultSet = c.statement.executeQuery("select * from new_customer where meterno = '"+view+"'  ");
                if (resultSet.next()){
                    namelabeltext.setText(resultSet.getString("name"));
                    meternotext.setText(resultSet.getString("meterno"));
                    addresstext.setText(resultSet.getString("address"));
                    citytext.setText(resultSet.getString("city"));
                    statetext.setText(resultSet.getString("state"));
                    emailtext.setText(resultSet.getString("email"));
                    phonetext.setText(resultSet.getString("phone"));

                }

            }catch (Exception E){
                E.printStackTrace();
            }


            cancel = new JButton("Cancel");
            cancel.setBounds(220,350,120,25);
            cancel.setBackground(new Color(24,118,242));
            cancel.setForeground(Color.white);
            cancel.addActionListener(this);
            add(cancel);

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/splash/viewinfo.png"));
            Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel i4 = new JLabel(i3);
            i4.setBounds(100,320,600,300);
            add(i4);



            setLayout(null);
            setVisible(true);
        }

    public void actionPerformed(ActionEvent e){
            if (e.getSource()==cancel){
                setVisible(false);
            }

    }



    public static void main(String[] args) {
        new View_information("");
    }
}
