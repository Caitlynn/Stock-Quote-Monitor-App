package gui;

import stock.InputHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * this class generates the window for this application,
 * takes input from user, and parse the information to InputHandler ,
 * it also calls the InputHandler to get the Panel to show on the screen
 * param: N/A
 * exception: N/A
 * return: none
 */
public class AppDisplay{

    private String stocksymbol = null;
    private boolean isNumerical;
    private boolean isSQSapi;

    private JFrame mainFrame;
    private JPanel mainpanel;
    private JPanel toppanel;
    private JPanel bottompanel;
    private JButton addMonitor ;
    private JButton deleteMonitor ;
    private JLabel inputLabel;
    private JTextField inputSymbol;
    private JTabbedPane tabpanel;
    private JPanel textpanel;
    private DefaultComboBoxModel apiChoices  = new DefaultComboBoxModel();
    private DefaultComboBoxModel monitorChoices = new DefaultComboBoxModel();
    private JComboBox apiComboBox ;
    private JComboBox monitorComboBox;


    public AppDisplay(){
        this.mainFrame = new JFrame();
        this.mainpanel = new JPanel();
        this.toppanel = new JPanel();
        this.bottompanel = new JPanel();
        this.textpanel = new JPanel();
        this.apiComboBox = new JComboBox(apiChoices);
        this.monitorComboBox  = new JComboBox(monitorChoices) ;
        this.inputLabel = new JLabel("Stock symbol:");
        this.inputSymbol  = new JTextField();

        this.addMonitor= new JButton("Add Monitor");
        addMonitor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stocksymbol = inputSymbol.getText();
                inputSymbol.setText("");
                if(apiComboBox.getSelectedIndex() == 0){
                    isSQSapi = true;
                } else{
                    isSQSapi = false;
                }
                if(monitorComboBox.getSelectedIndex() == 0){
                    isNumerical = true;
                } else{
                    isNumerical = false;
                }

                InputHandler info = new InputHandler(stocksymbol, isNumerical, isSQSapi);
                info.ChooseAPI();
                setPanel(info.ChooseMonitor());
                tabpanel.add(stocksymbol,textpanel);

            }
        });

        this.deleteMonitor = new JButton("Delete");
        deleteMonitor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer index = tabpanel.getSelectedIndex();
                tabpanel.remove(index);
            }
        });

        this.tabpanel = new JTabbedPane(JTabbedPane.TOP);

        prepareWindow();

    }


    /**
     * this function prepare the window by adding the elements to the panels/frame
     * and set them visible
     */
    private void prepareWindow(){

        apiChoices.addElement("StockQuoteService");
        apiChoices.addElement("StockQuoteTimeLapseService");
        monitorChoices.addElement("Numerical");
        monitorChoices.addElement("Graphic");


        mainFrame.setBounds(100, 100, 1500, 600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        mainpanel.setLayout(new BorderLayout(0,0));
        toppanel.setLayout(new GridLayout(2,3));
        bottompanel.setLayout(new BorderLayout(0,0));

        mainFrame.getContentPane().add(mainpanel,BorderLayout.CENTER);
        mainpanel.add(toppanel, BorderLayout.NORTH);
        mainpanel.add(bottompanel, BorderLayout.CENTER);


        toppanel.add(this.inputLabel);
        toppanel.add(this.inputSymbol);
        toppanel.add(this.addMonitor);
        toppanel.add(this.monitorComboBox);
        toppanel.add(this.apiComboBox);


        toppanel.add(this.deleteMonitor);

        bottompanel.add(this.tabpanel, BorderLayout.CENTER);

    }

    private void setPanel(JPanel p){
        textpanel = p;
    }

}


