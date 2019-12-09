package pack;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegWind {
    private String login="admin";
    private String password="admin";
    RegWind(){
        //Frame
        JFrame frame=new JFrame("Hello");
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocation(700,400);
        frame.setLayout(null);

        //Label login
        JLabel log = new JLabel("Please enter your login:");
        log.setBounds(25, 25, 175, 20);
        frame.add(log);
        //Text Field for login
        JTextField txLog = new JTextField();
        txLog.setBounds(25, 50, 175, 30);
        frame.add(txLog);

        //Label password
        JLabel pas = new JLabel("Please enter your password:");
        pas.setBounds(25, 100, 175, 20);
        frame.add(pas);

        //Text Field for password
        JPasswordField txPas = new JPasswordField();
        txPas.setBounds(25, 125, 175, 30);
        frame.add(txPas);

        //Button
        JButton b=new JButton("Enter");
        b.setBounds(150,200,100,20);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lo1=txLog.getText();
                String pa1=txPas.getText();
                    if(lo1.equals(login)&&pa1.equals(password)){
                        new MainWind();
                    }
                    else {
                        JFrame f = new JFrame();
                        JOptionPane.showMessageDialog(f, " Wrong login or password," +
                                " try again");
                    }
            }
        });
        frame.add(b);
        frame.setVisible(true);
    }
}
