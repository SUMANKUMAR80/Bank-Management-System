package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
    
    JButton deposit, withdraw, ministatement, pinchange, fastcash, balanceenquiry, exit;
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 730, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 730);
        add(image);
        
        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(215, 230, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(165, 327, 130, 20);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdraw = new JButton("Cash Withdraw");
        withdraw.setBounds(380, 327, 130, 20);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(165, 352, 130, 20);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(380, 352, 130, 20);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(165, 377, 130,20);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(380, 377, 130, 20);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        exit = new JButton("Exit");
        exit.setBounds(380, 405, 130, 20);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900, 730);
        setLocation(200, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource() == withdraw){
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);
        }else if(ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource() == balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource() == ministatement){
            new MiniStatement(pinnumber).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Transactions("");
    }
}
