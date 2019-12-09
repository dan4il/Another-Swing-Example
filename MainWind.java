package pack;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;

public class MainWind {
    int price = 0;

    static void writing(String inp) {
        File file = new File("results.txt");
        FileWriter write = null;
        BufferedWriter buff = null;
        try {
            write = new FileWriter(file, true);
            buff = new BufferedWriter(write);
            buff.write(inp);
        } catch (IOException l) {
            System.out.println("ERROR");
        } finally {
            try {
                buff.flush();
                buff.close();
            } catch (IOException e1) {
            }
        }
    }

    MainWind() {
        //Frame
        JFrame mainFrame = new JFrame("Welcome Back!");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setSize(new Dimension((int) (screenSize.getWidth() * 0.5), (int) (screenSize.getHeight() * 0.7)));
        mainFrame.setLocation(400, 200);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);

        //styles
        Border solidBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        Font font1 = new Font("Verdana", Font.PLAIN, 16);

        //Label for price
        JLabel priceLbl = new JLabel("Total price:");
        priceLbl.setBounds(30, 35, 110, 20);
        priceLbl.setFont(font1);
        mainFrame.add(priceLbl);

        //text area for show price
        JTextArea priceArea = new JTextArea("0$");
        priceArea.setBounds(30, 70, 110, 30);
        priceArea.setFont(font1);
        priceArea.setBorder(solidBorder);
        mainFrame.add(priceArea);

        //Label for cart
        JLabel cartlbl = new JLabel("Your cart:");
        cartlbl.setBounds(30, 120, 110, 20);
        cartlbl.setFont(font1);
        mainFrame.add(cartlbl);

        //label for list of items which u r already bought
        JLabel listlbl = new JLabel("You already bought:");
        listlbl.setBounds(670, 120, 190, 20);
        listlbl.setFont(font1);
        mainFrame.add(listlbl);

        //Text area for list of that u bought
        JTextArea listArea = new JTextArea();
        listArea.setBounds(670, 150, 200, 400);
        listArea.setFont(font1);
        listArea.setBorder(solidBorder);
        mainFrame.add(listArea);


        //Table  for shopping list
        Object[] row1;
        row1 = new Object[2];
        row1[0] = "Product";
        row1[1] = "Price";
        JTable table1 = new JTable();
        DefaultTableModel model1 = new DefaultTableModel();
        model1.setColumnIdentifiers(row1);
        table1.setModel(model1);
        table1.setBounds(30, 150, 300, 400);
        table1.setBorder(solidBorder);
        table1.setFont(font1);
        mainFrame.add(table1);
        JScrollPane scroll1 = new JScrollPane(table1);
        scroll1.setBounds(30, 150, 300, 400);
        mainFrame.getContentPane().add(scroll1);

        //Check box
        JCheckBox first = new JCheckBox("Apple-3$");
        JCheckBox second = new JCheckBox("Banana-2$");
        JCheckBox third = new JCheckBox("Cake-6$");
        JCheckBox forth = new JCheckBox("Water-1$");
        JCheckBox fifth = new JCheckBox("Bread-2$");
        JCheckBox sixth = new JCheckBox("Cheese-10$");
        first.setFont(font1);
        second.setFont(font1);
        third.setFont(font1);
        forth.setFont(font1);
        fifth.setFont(font1);
        sixth.setFont(font1);
        JPanel boxesPanel = new JPanel();
        boxesPanel.add(first);
        first.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (first.isSelected()) {
                    row1[0] = "apples";
                    row1[1] = "3$";
                    model1.addRow(row1);
                    price += 3;
                    writing("apples 3$\n");
                    priceArea.setText(price + "$");
                }
            }
        });

        boxesPanel.add(second);
        second.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (second.isSelected()) {
                    row1[0] = "banana";
                    row1[1] = "2$";
                    model1.addRow(row1);
                    writing("banana 2$\n");
                    price += 2;
                    priceArea.setText(price + "$");
                }
            }
        });

        boxesPanel.add(third);
        third.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (third.isSelected()) {
                    row1[0] = "cake";
                    row1[1] = "6$";
                    writing("cake 6$\n");
                    model1.addRow(row1);
                    price += 6;
                    priceArea.setText(price + "$");
                }
            }
        });

        boxesPanel.add(forth);
        forth.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (forth.isSelected()) {
                    row1[0] = "water";
                    row1[1] = "1$";
                    writing("water 1$\n");
                    model1.addRow(row1);
                    price += 1;
                    priceArea.setText(price + "$");
                }
            }
        });

        boxesPanel.add(fifth);
        fifth.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (fifth.isSelected()) {
                    row1[0] = "bread";
                    row1[1] = "2$";
                    writing("bread 2$\n");
                    model1.addRow(row1);
                    price += 2;
                    priceArea.setText(price + "$");
                }
            }
        });

        boxesPanel.add(sixth);
        sixth.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (sixth.isSelected()) {
                    row1[0] = "cheese";
                    row1[1] = "10$";
                    writing("cheese 10$\n");
                    model1.addRow(row1);
                    price += 10;
                    priceArea.setText(price + "$");
                }
            }
        });

        boxesPanel.setBounds(450, 200, 140, 500);
        boxesPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        mainFrame.add(boxesPanel);

        //Jbutton Clear
        JButton clear = new JButton("Clear");
        clear.setBounds(30, 600, 100, 20);
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model1.setRowCount(0);
                price = 0;
                priceArea.setText(price + "$");
                //чистим файл от добавленных продуктов
                File fil = new File("results.txt");
                FileWriter wrt = null;
                BufferedWriter buf = null;
                try {
                    wrt = new FileWriter(fil);
                    buf = new BufferedWriter(wrt);
                    buf.write("");
                } catch (IOException l) {
                    System.out.println("ERROR");
                } finally {
                    try {
                        buf.flush();
                        buf.close();
                    } catch (IOException e1) {
                    }
                }

                //снятие всех галочек
                Component[] components = boxesPanel.getComponents();
                for (Component component : components) {
                    if (component instanceof JCheckBox) {
                        JCheckBox checkBox = (JCheckBox) component;
                        if (checkBox.isSelected()) {
                            checkBox.setSelected(false);
                        }
                    }
                }
            }
        });
        mainFrame.add(clear);


        //Jbutton Submit
        JButton submit = new JButton("Submit");
        submit.setBounds(230, 600, 100, 20);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Thanks for your buy," +
                        " total price:" + price + " $ ");
                //добавляем купленные продукты во второй список
                FileReader read = null;
                BufferedReader bufRead = null;
                try {
                    read = new FileReader("results.txt");
                    bufRead = new BufferedReader(read);
                    while (true) {
                        String line = bufRead.readLine();
                        if(line==null)break;
                        listArea.append(line+"\n");
                    }
                } catch (IOException e1) {
                    System.out.println("");
                } finally {
                    try {
                        bufRead.close();
                        read.close();
                    } catch (IOException q) {
                        System.out.println("");
                    }
                }
                    //после совершения покупки все счетчики обнуляются( то есть просто копируем)
                    //функционал кнопки clear

                    model1.setRowCount(0);
                    price = 0;
                    priceArea.setText(price + "$");
                    //чистим файл от добавленных продуктов
                    File fil = new File("results.txt");
                    FileWriter wrt = null;
                    BufferedWriter buf = null;
                    try {
                        wrt = new FileWriter(fil);
                        buf = new BufferedWriter(wrt);
                        buf.write("");
                    } catch (IOException l) {
                        System.out.println("ERROR");
                    } finally {
                        try {
                            buf.flush();
                            buf.close();
                        } catch (IOException e1) {
                        }
                    }

                    //снятие всех галочек
                    Component[] components = boxesPanel.getComponents();
                    for (Component component : components) {
                        if (component instanceof JCheckBox) {
                            JCheckBox checkBox = (JCheckBox) component;
                            if (checkBox.isSelected()) {
                                checkBox.setSelected(false);
                            }
                        }
                    }
            }
        });
        mainFrame.add(submit);

        mainFrame.setVisible(true);
    }
}
