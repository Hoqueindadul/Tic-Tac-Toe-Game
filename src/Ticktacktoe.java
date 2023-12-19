import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

public class Ticktacktoe implements ActionListener
{
        Random random = new Random();
        JFrame frame = new JFrame();
        JPanel tittle_panel = new JPanel();
        JPanel button_panel = new JPanel();
        JLabel text_field = new JLabel();
        JButton[] btn = new JButton[9];
        JMenuBar bar = new JMenuBar();
        JMenu fileManu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpManu = new JMenu("Help");
        JMenuItem loadItem = new JMenuItem("Load");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");
        //JOptionPane optionPane = new JOptionPane();
        boolean player1_turn;


        Ticktacktoe()
        {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 800);
            frame.getContentPane().setBackground(new Color(50,50,0));
            frame.setVisible(true);
            
            frame.setJMenuBar(bar);
            bar.add(fileManu);
            bar.add(editMenu);
            bar.add(helpManu);
            fileManu.add(loadItem);
            fileManu.add(saveItem);
            fileManu.add(exitItem);


            loadItem.addActionListener(this);
            saveItem.addActionListener(this);
            exitItem.addActionListener(this);

            text_field.setBackground(new Color(25,25,25));
            text_field.setForeground(new Color(25,255,0));
            text_field.setFont(new Font("Arial",Font.BOLD,50));
            text_field.setHorizontalAlignment(JLabel.CENTER);
            text_field.setText("Tic-Tac-Toe");
            text_field.setOpaque(true);

            tittle_panel.setLayout(new BorderLayout());
            tittle_panel.setBounds(0,0,800,500);

            button_panel.setLayout(new GridLayout(3,3));
            button_panel.setBackground(new Color(0,0,0));



            for(int i=0;i<9;i++)
            {
                btn[i] = new JButton();
                button_panel.add(btn[i]);
                btn[i].setFont(new Font("Arial",Font.BOLD,100));
                btn[i].setFocusable(false);
                btn[i].addActionListener(this);

            }

            tittle_panel.add(text_field);
            frame.add(tittle_panel,BorderLayout.NORTH);
            frame.add(button_panel);

            firstTurn();
        }

        public void actionPerformed(ActionEvent e)
        {
            for(int i=0;i<9;i++)
            {
                if(e.getSource()==btn[i])
                {
                    if(player1_turn)
                    {
                        if(Objects.equals(btn[i].getText(), ""))
                        {
                            btn[i].setBackground(new Color(0,0,0));
                            btn[i].setForeground(new Color(255,0,0));
                            btn[i].setText("X");
                            player1_turn = false;
                            text_field.setText("O turn");
                            checkX();
                        }
                    }
                    else
                    {
                        if(Objects.equals(btn[i].getText(), ""))
                        {
                            btn[i].setBackground(new Color(0,0,0));
                            btn[i].setForeground(new Color(0,0,255));
                            btn[i].setText("O");
                            player1_turn = true ;
                            text_field.setText("X turn");
                            checkO();
                        }
                    }
                }
            }
            matchDraw();

            if(e.getSource() ==  loadItem)
            {
                frame.areFocusTraversalKeysSet(1);
            }
            if(e.getSource() == saveItem)
            {
                System.out.println("Save");
            }
            if(e.getSource() == exitItem)
            {
                System.exit(0);
            }

        }





    public void firstTurn()
        {
            try{
                Thread.sleep(3000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

              if(random.nextInt(2 )==0)
              {
                  player1_turn = true;
                  text_field.setText("X turn");
              }
              else
              {
                  player1_turn = false;
                  text_field.setText("0 turn");
              }
        }
        public void checkX() {
            if ((Objects.equals(btn[0].getText(), "X")) && (Objects.equals(btn[1].getText(), "X")) &&
                    (Objects.equals(btn[2].getText(), "X"))) {
                xWins(0, 1, 2);
            }
            if ((Objects.equals(btn[3].getText(), "X")) && (Objects.equals(btn[4].getText(), "X")) &&
                    (Objects.equals(btn[5].getText(), "X"))) {
                xWins(3, 4, 5);
            }
            if ((Objects.equals(btn[6].getText(), "X")) && (Objects.equals(btn[7].getText(), "X")) &&
                    (Objects.equals(btn[8].getText(), "X"))) {
                xWins(6, 7, 8);
            }
            if ((Objects.equals(btn[0].getText(), "X")) && (Objects.equals(btn[3].getText(), "X")) &&
                    (Objects.equals(btn[6].getText(), "X"))) {
                xWins(0, 3, 6);
            }
            if ((Objects.equals(btn[1].getText(), "X")) && (Objects.equals(btn[4].getText(), "X")) &&
                    (Objects.equals(btn[7].getText(), "X"))) {
                xWins(1, 4, 7);
            }
            if ((Objects.equals(btn[0].getText(), "X")) && (Objects.equals(btn[1].getText(), "X")) &&
                    (Objects.equals(btn[2].getText(), "X"))) {
                xWins(0, 1, 2);
            }
            if ((Objects.equals(btn[2].getText(), "X")) && (Objects.equals(btn[5].getText(), "X")) &&
                    (Objects.equals(btn[8].getText(), "X"))) {
                xWins(2, 5, 8);
            }
            if ((Objects.equals(btn[0].getText(), "X")) && (Objects.equals(btn[4].getText(), "X")) &&
                    (Objects.equals(btn[8].getText(), "X"))) {
                xWins(0, 4, 8);
            }
            if ((Objects.equals(btn[2].getText(), "X")) && (Objects.equals(btn[4].getText(), "X")) &&
                    (Objects.equals(btn[6].getText(), "X"))) {
                xWins(2, 4, 6);
            }

        }
        public void checkO()
        {
            if((Objects.equals(btn[0].getText(), "O"))&& (Objects.equals(btn[1].getText(), "O"))&&
                    (Objects.equals(btn[2].getText(), "O")))
            {
                oWins(0,1,2);
            }
            if((Objects.equals(btn[3].getText(), "O"))&& (Objects.equals(btn[4].getText(), "O"))&&
                    (Objects.equals(btn[5].getText(), "O")))
            {
                oWins(3,4,5);
            }
            if((Objects.equals(btn[6].getText(), "O"))&& (Objects.equals(btn[7].getText(), "O"))&&
                    (Objects.equals(btn[8].getText(), "O")))
            {
                oWins(6,7,8);
            }
            if((Objects.equals(btn[0].getText(), "O"))&& (Objects.equals(btn[3].getText(), "O"))&&
                    (Objects.equals(btn[6].getText(), "O")))
            {
                oWins(0,3,6);
            }
            if((Objects.equals(btn[1].getText(), "O"))&& (Objects.equals(btn[4].getText(), "O"))&&
                    (Objects.equals(btn[7].getText(), "O")))
            {
                oWins(1,4,7);
            }
            if((Objects.equals(btn[0].getText(), "O"))&& (Objects.equals(btn[1].getText(), "O"))&&
                    (Objects.equals(btn[2].getText(), "O")))
            {
                oWins(0,1,2);
            }
            if((Objects.equals(btn[2].getText(), "O"))&& (Objects.equals(btn[5].getText(), "O"))&&
                    (Objects.equals(btn[8].getText(), "O")))
            {
                oWins(2,5,8);
            }
            if((Objects.equals(btn[0].getText(), "O"))&& (Objects.equals(btn[4].getText(), "O"))&&
                    (Objects.equals(btn[8].getText(), "O")))
            {
                oWins(0,4,8);
            }
            if((Objects.equals(btn[2].getText(), "O"))&& (Objects.equals(btn[4].getText(), "O"))&&
                    (Objects.equals(btn[6].getText(), "O")))
            {
                oWins(2,4,6);
            }
        }

        public void xWins(int a, int b, int c)
        {
            btn[a].setBackground(Color.GREEN);
            btn[b].setBackground(Color.GREEN);
            btn[c].setBackground(Color.GREEN);
            for(int i=0;i<9;i++)
            {
                btn[i].setEnabled(false);
            }
            int option = JOptionPane.showConfirmDialog(frame,
                    "Game Over! X is Win. Do You Continue the Game?", "Massage Box",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (option == JOptionPane.YES_OPTION) {
                resetGame();
            }
            text_field.setText("X Wins");

        }
        public void resetGame()
        {
            for (int i = 0; i < 9; i++)
            {
                btn[i].setText("");
                btn[i].setEnabled(true);
                btn[i].setBackground(null);
            }

        text_field.setText("Tic-Tac-Toe");

        // Determine the starting player for the new game
        firstTurn();
    }



    public void oWins(int a, int b, int c)
        {
            btn[a].setBackground(Color.GREEN);
            btn[b].setBackground(Color.GREEN);
            btn[c].setBackground(Color.GREEN);
            for(int i=0;i<9;i++)
            {
                btn[i].setEnabled(false);
            }

            int option1 = JOptionPane.showConfirmDialog(frame,
                    "Game Over! O is Win. Do You Continue the Game?", "Massage Box",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (option1 == JOptionPane.YES_OPTION) {
                resetGame();

            }

            text_field.setText("O Wins");
        }
        public void matchDraw()
        {
            for (int i = 0; i < 9; i++) {
                if (Objects.equals(btn[i].getText(), "")) {
                    return; // If any button is still empty, the game is not a draw
                }
            }

            // All buttons are filled, and no one has won, so it's a draw
            int option2 = JOptionPane.showConfirmDialog(frame, "The Game is Tie! Do you continue?", "Massage Box", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (option2 == JOptionPane.YES_OPTION)
                resetGame();

        }
}
