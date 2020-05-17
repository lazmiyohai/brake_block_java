// 
// Decompiled by Procyon v0.5.36
// 

package gameWindows_General;

import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import Panels_Designs.winnerBeckgroundPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.event.ActionListener;

public class GameOverWindow implements ActionListener
{
    private JFrame frame;
    private JLabel win;
    private JButton LevelTime;
    private JButton LevelHits;
    private JButton LevelScore;
    private JButton BestScore;
    private JButton BackToMenu;
    private JButton SelectLevel;
    private JButton GoToTheNextLevel;
    private int levelTime;
    private int levelHits;
    private int CurrentLevel;
    private int bestScore;
    
    public GameOverWindow(final int levelTime, final int levelHits, final int CurrentLevel, final int bestScore) {
        this.CurrentLevel = CurrentLevel;
        this.levelHits = levelHits;
        this.levelTime = levelTime;
        this.bestScore = bestScore;
        this.initialize(levelTime, levelHits);
    }
    
    private void initialize(final int levelTime, final int levelHits) {
        (this.frame = new JFrame()).setSize(440, 500);
        this.frame.setDefaultCloseOperation(3);
        final winnerBeckgroundPanel backgroundPanel = new winnerBeckgroundPanel();
        this.frame.getContentPane().setLayout(null);
        backgroundPanel.setLayout(null);
        backgroundPanel.setSize(440, 500);
        backgroundPanel.setLocation(0, 0);
        (this.win = new JLabel("you win!!!")).setFont(new Font("Pirata One", 0, 30));
        this.win.setLocation(100, 5);
        this.win.setSize(350, 35);
        (this.LevelTime = new JButton("the time of this level is: " + levelTime + " seconds")).setFont(new Font("Pirata One", 0, 20));
        this.LevelTime.setLocation(50, 50);
        this.LevelTime.setSize(350, 35);
        this.LevelTime.setBorder(BorderFactory.createLineBorder(Color.black));
        this.LevelTime.setBackground(Color.LIGHT_GRAY);
        (this.LevelHits = new JButton("the numbers of hits in this level is: " + levelHits + " hits")).setFont(new Font("Pirata One", 0, 20));
        this.LevelHits.setLocation(50, 100);
        this.LevelHits.setSize(350, 35);
        this.LevelHits.setBorder(BorderFactory.createLineBorder(Color.black));
        this.LevelHits.setBackground(Color.LIGHT_GRAY);
        final int Score = this.ReturnTheScoreOfThisLevel();
        (this.LevelScore = new JButton("the score of this level is: " + Score + " points")).setFont(new Font("Pirata One", 0, 20));
        this.LevelScore.setLocation(50, 150);
        this.LevelScore.setSize(350, 35);
        this.LevelScore.setBorder(BorderFactory.createLineBorder(Color.black));
        this.LevelScore.setBackground(Color.LIGHT_GRAY);
        (this.BestScore = new JButton("the best score is " + this.bestScore + " points")).setFont(new Font("Pirata One", 0, 20));
        this.BestScore.setLocation(50, 200);
        this.BestScore.setSize(350, 35);
        this.BestScore.setBorder(BorderFactory.createLineBorder(Color.black));
        this.BestScore.setBackground(Color.LIGHT_GRAY);
        (this.GoToTheNextLevel = new JButton("go to the next level")).setFont(new Font("Pirata One", 0, 20));
        this.GoToTheNextLevel.setLocation(50, 250);
        this.GoToTheNextLevel.setSize(350, 35);
        this.GoToTheNextLevel.setBackground(Color.LIGHT_GRAY);
        (this.SelectLevel = new JButton("return to select level")).setFont(new Font("Pirata One", 0, 20));
        this.SelectLevel.setLocation(50, 300);
        this.SelectLevel.setSize(350, 35);
        this.SelectLevel.setBackground(Color.LIGHT_GRAY);
        (this.BackToMenu = new JButton("return to the main menu")).setFont(new Font("Pirata One", 0, 20));
        this.BackToMenu.setLocation(50, 350);
        this.BackToMenu.setSize(350, 35);
        this.BackToMenu.setBackground(Color.LIGHT_GRAY);
        backgroundPanel.add(this.win);
        backgroundPanel.add(this.LevelTime);
        backgroundPanel.add(this.LevelHits);
        backgroundPanel.add(this.LevelScore);
        backgroundPanel.add(this.BestScore);
        backgroundPanel.add(this.GoToTheNextLevel);
        backgroundPanel.add(this.SelectLevel);
        backgroundPanel.add(this.BackToMenu);
        this.BackToMenu.addActionListener(this);
        this.GoToTheNextLevel.addActionListener(this);
        this.SelectLevel.addActionListener(this);
        this.frame.setVisible(true);
        this.frame.getContentPane().add(backgroundPanel);
        this.frame.setResizable(false);
    }
    
    private int ReturnTheScoreOfThisLevel() {
        int ans = 1500;
        ans = Math.max(0, ans - this.levelHits - 2 * this.levelTime);
        return ans;
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource().equals(this.BackToMenu)) {
            final MainMenu m = new MainMenu();
            this.frame.dispose();
        }
        if (e.getSource().equals(this.GoToTheNextLevel) && this.CurrentLevel < 4) {
            try {
                final GameWindow gameWindow = new GameWindow(this.CurrentLevel + 1);
            }
            catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
            this.frame.dispose();
        }
        if (e.getSource().equals(this.SelectLevel)) {
            try {
                final SelectLevel selectLevel = new SelectLevel();
            }
            catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
            this.frame.dispose();
        }
    }
}
