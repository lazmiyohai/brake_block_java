// 
// Decompiled by Procyon v0.5.36
// 

package gameWindows_General;

import Panels_Designs.BlockPanel;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.awt.Component;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.KeyListener;
import Balls.AllFoueElementsBall;
import Balls.WoodenBall;
import Balls.ElectricityBall;
import Balls.WaterBall;
import Balls.FireBall;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.LayoutManager;
import javax.swing.JLabel;
import javax.swing.Timer;
import Panels_Designs.PaddlePanel;
import javax.swing.JPanel;
import Balls.Ball;
import javax.swing.JToolBar;
import Panels_Designs.BallPanel;
import javax.swing.JFrame;
import java.awt.event.ActionListener;

public class GameWindow implements ActionListener
{
    private ListOfRecords records;
    private JFrame jframe;
    private int CurrentLevel;
    private BallPanel ballPanel;
    private JToolBar toolbar;
    private int GameTime;
    private Ball ball;
    private JPanel bgPanel;
    private PaddlePanel paddlePanel;
    private Board board;
    private Paddle paddle;
    private Levels level;
    private Boolean TheBallReleased;
    private Timer BallTimer;
    private Timer GameTimer;
    private Timer ThreeSecondsTimer;
    private int stayTime;
    private final int delay = 25;
    private int fromx;
    private int fromy;
    private Boolean GoingUp;
    private int CaseOfShot;
    private boolean AllTheMatrixEmpty;
    private boolean isFirstShot;
    private JLabel time;
    private JLabel hits;
    private int NumOfHits;
    private Boolean PaddleMoved;
    
    public GameWindow(final int CurrentLevel) throws FileNotFoundException {
        this.GameTime = 0;
        this.paddle = new Paddle();
        this.level = new Levels();
        this.TheBallReleased = false;
        this.stayTime = 0;
        this.GoingUp = true;
        this.AllTheMatrixEmpty = false;
        this.isFirstShot = true;
        this.NumOfHits = 0;
        this.PaddleMoved = false;
        (this.records = new ListOfRecords()).loadFromFile("records.txt");
        this.CurrentLevel = CurrentLevel;
        this.GameTimer = new Timer(1000, this);
        this.ThreeSecondsTimer = new Timer(1000, this);
        (this.jframe = new JFrame()).setVisible(true);
        this.jframe.setSize(440, 500);
        this.jframe.getContentPane().setLayout(null);
        this.jframe.getContentPane().setFocusable(true);
        this.jframe.getContentPane().addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(final MouseEvent e) {
                if (!GameWindow.this.ThreeSecondsTimer.isRunning()) {
                    final int XCordinateOfMouse = e.getX();
                    if (XCordinateOfMouse < 300 && GameWindow.this.TheBallReleased) {
                        GameWindow.this.paddle.setX(XCordinateOfMouse);
                        GameWindow.this.paddlePanel.setLocation(GameWindow.this.paddle.getX(), GameWindow.this.paddle.getY());
                        GameWindow.this.paddlePanel.setSize(120, 10);
                        GameWindow.this.paddlePanel.setLayout(null);
                    }
                    else if (XCordinateOfMouse < 300) {
                        GameWindow.this.paddle.setX(XCordinateOfMouse);
                        GameWindow.this.paddlePanel.setLocation(GameWindow.this.paddle.getX(), GameWindow.this.paddle.getY());
                        GameWindow.this.paddlePanel.setSize(120, 10);
                        GameWindow.this.paddlePanel.setLayout(null);
                        GameWindow.this.ballPanel.setLocation(GameWindow.this.paddlePanel.getX() + 50, GameWindow.this.paddlePanel.getY() - 15);
                        GameWindow.access$5(GameWindow.this, true);
                    }
                }
            }
        });
        this.jframe.getContentPane().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(final KeyEvent e) {
                if (!GameWindow.this.TheBallReleased) {
                    if (e.getKeyCode() == 49 || e.getKeyCode() == 97) {
                        GameWindow.access$6(GameWindow.this, new FireBall());
                    }
                    else if (e.getKeyCode() == 50 || e.getKeyCode() == 98) {
                        GameWindow.access$6(GameWindow.this, new WaterBall());
                    }
                    else if (e.getKeyCode() == 51 || e.getKeyCode() == 99) {
                        GameWindow.access$6(GameWindow.this, new ElectricityBall());
                    }
                    else if (e.getKeyCode() == 52 || e.getKeyCode() == 100) {
                        GameWindow.access$6(GameWindow.this, new WoodenBall());
                    }
                    GameWindow.access$7(GameWindow.this, GameWindow.this.paddlePanel.getX() + 50);
                    GameWindow.access$8(GameWindow.this, GameWindow.this.paddlePanel.getY() - 15);
                    GameWindow.this.paintShot(GameWindow.this.fromx, GameWindow.this.fromy, GameWindow.this.ball);
                    if (e.getKeyCode() == 119) {
                        GameWindow.access$6(GameWindow.this, new AllFoueElementsBall());
                    }
                    if (e.getKeyCode() == 121) {
                        GameWindow.access$6(GameWindow.this, new FireBall());
                    }
                }
                else {
                    if (e.getKeyCode() == 49 || e.getKeyCode() == 97) {
                        GameWindow.access$6(GameWindow.this, new FireBall());
                    }
                    else if (e.getKeyCode() == 50 || e.getKeyCode() == 98) {
                        GameWindow.access$6(GameWindow.this, new WaterBall());
                    }
                    else if (e.getKeyCode() == 51 || e.getKeyCode() == 99) {
                        GameWindow.access$6(GameWindow.this, new ElectricityBall());
                    }
                    else if (e.getKeyCode() == 52 || e.getKeyCode() == 100) {
                        GameWindow.access$6(GameWindow.this, new WoodenBall());
                    }
                    if (e.getKeyCode() == 119) {
                        GameWindow.access$6(GameWindow.this, new AllFoueElementsBall());
                    }
                    if (e.getKeyCode() == 121) {
                        GameWindow.access$6(GameWindow.this, new FireBall());
                    }
                }
            }
        });
        this.jframe.getContentPane().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(final MouseEvent e) {
                if (e.getButton() == 1 && !GameWindow.this.TheBallReleased && !GameWindow.this.ThreeSecondsTimer.isRunning()) {
                    if (GameWindow.this.isFirstShot) {
                        GameWindow.access$14(GameWindow.this, GameWindow.this.RandomAngle());
                        GameWindow.access$15(GameWindow.this, true);
                        GameWindow.this.Relaese();
                        GameWindow.this.GameTimer.start();
                        GameWindow.access$18(GameWindow.this, false);
                        GameWindow.access$7(GameWindow.this, GameWindow.this.paddlePanel.getX() + 50);
                        GameWindow.access$8(GameWindow.this, GameWindow.this.paddlePanel.getY() - 15);
                        GameWindow.this.ballPanel.setLocation(GameWindow.this.fromx, GameWindow.this.fromy);
                    }
                    else {
                        GameWindow.access$14(GameWindow.this, GameWindow.this.RandomAngle());
                        GameWindow.access$15(GameWindow.this, true);
                        GameWindow.this.Relaese();
                        GameWindow.access$7(GameWindow.this, GameWindow.this.paddlePanel.getX() + 50);
                        GameWindow.access$8(GameWindow.this, GameWindow.this.paddlePanel.getY() - 15);
                        GameWindow.this.ballPanel.setLocation(GameWindow.this.fromx, GameWindow.this.fromy);
                    }
                }
            }
        });
        this.toolbar = new JToolBar();
        (this.time = new JLabel("Time :" + this.GameTime + " seconds")).setLocation(15, 0);
        this.time.setSize(150, 30);
        (this.hits = new JLabel("Hits :" + this.NumOfHits)).setLocation(170, 0);
        this.hits.setSize(150, 30);
        (this.bgPanel = new JPanel()).setLocation(0, 0);
        this.bgPanel.setSize(440, 500);
        this.bgPanel.setLayout(null);
        this.bgPanel.setBackground(Color.WHITE);
        this.toolbar.setLocation(0, 0);
        this.toolbar.setSize(500, 30);
        this.toolbar.setLayout(null);
        this.toolbar.add(this.time);
        this.toolbar.add(this.hits);
        (this.board = new Board(this.level.getMatrixLevelByNumLevel(CurrentLevel))).setLocation(10, 50);
        this.board.setSize(400, 120);
        (this.paddlePanel = new PaddlePanel()).setLocation(this.paddle.getX(), this.paddle.getY());
        this.paddlePanel.setSize(120, 10);
        this.paddlePanel.setLayout(null);
        this.bgPanel.add(this.paddlePanel);
        this.bgPanel.add(this.board);
        this.bgPanel.add(this.toolbar);
        this.ball = new FireBall();
        (this.ballPanel = new BallPanel(this.ball)).setSize(15, 15);
        this.ballPanel.setLayout(null);
        this.bgPanel.add(this.ballPanel);
        this.jframe.getContentPane().add(this.bgPanel);
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == this.ThreeSecondsTimer) {
            ++this.stayTime;
            if (this.stayTime == 2) {
                this.ThreeSecondsTimer.stop();
                this.stayTime = 0;
            }
        }
        if (e.getSource() == this.GameTimer) {
            ++this.GameTime;
            this.toolbar.remove(this.time);
            this.bgPanel.remove(this.toolbar);
            (this.time = new JLabel("Time :" + this.GameTime + " seconds")).setSize(150, 30);
            this.time.setLocation(15, 0);
            this.toolbar.setLocation(0, 0);
            this.toolbar.setSize(500, 30);
            this.toolbar.setLayout(null);
            this.toolbar.add(this.time);
            this.bgPanel.add(this.toolbar);
            this.bgPanel.revalidate();
            this.bgPanel.repaint();
            if (!this.BallTimer.isRunning() && !this.ThreeSecondsTimer.isRunning() && !this.TheBallReleased && !this.PaddleMoved) {
                this.ReturnTheBallToTheFirstLocation();
            }
            if (this.CheckIfAllTheMatrixEnmpty()) {
                this.GameTimer.stop();
                this.AllTheMatrixEmpty = true;
                final int score = this.ReturnTheScoreOfThisLevel();
                if (score > this.records.getRecords()[this.CurrentLevel - 1]) {
                    this.records.getRecords()[this.CurrentLevel - 1] = score;
                    try {
                        this.records.saveToFile("records.txt");
                    }
                    catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                final GameOverWindow gow = new GameOverWindow(this.GameTime, this.NumOfHits, this.CurrentLevel, this.records.getRecords()[this.CurrentLevel - 1]);
                this.jframe.dispose();
            }
        }
        if (e.getSource() == this.BallTimer) {
            if (this.CheckIfAllTheMatrixEnmpty()) {
                this.AllTheMatrixEmpty = true;
                this.BallTimer.stop();
                this.GoingUp = true;
            }
            if (this.ballPanel.getY() >= 440) {
                this.BallTimer.stop();
                this.ThreeSecondsTimer.start();
                this.TheBallReleased = false;
                this.PaddleMoved = false;
                if (this.ball.getBallType() == "AllFoueElementsBall") {
                    this.ball = new FireBall();
                }
            }
            this.paintShot(this.fromx, this.fromy, this.ball);
            if (this.fromy > 0) {
                if (this.GoingUp) {
                    if (this.CaseOfShot == 1) {
                        this.fromy -= 5;
                        this.paintShot(this.fromx -= 10, this.fromy, this.ball);
                    }
                    else if (this.CaseOfShot == 2) {
                        this.fromy -= 10;
                        this.paintShot(this.fromx -= 5, this.fromy, this.ball);
                    }
                    else if (this.CaseOfShot == 3) {
                        this.fromy -= 10;
                        this.paintShot(this.fromx += 5, this.fromy, this.ball);
                    }
                    else if (this.CaseOfShot == 4) {
                        this.fromy -= 5;
                        this.paintShot(this.fromx += 10, this.fromy, this.ball);
                    }
                    else if (this.CaseOfShot == 5) {
                        this.fromy -= 10;
                        this.paintShot(this.fromx, this.fromy, this.ball);
                    }
                    if (this.ballPanel.getX() <= 0 || this.ballPanel.getX() >= 390) {
                        this.ReplaceSide();
                    }
                    BlockPanel[][] blocks = this.board.getBlock();
                    for (int i = 0; i < blocks.length; ++i) {
                        for (int j = 0; j < blocks[i].length; ++j) {
                            blocks = this.board.getBlock();
                            final boolean isInX = blocks[i][j].getX() <= this.ballPanel.getX() && blocks[i][j].getX() + 40 >= this.ballPanel.getX();
                            final boolean isInY = blocks[i][j].getY() + 50 <= this.ballPanel.getY() && blocks[i][j].getY() + 65 >= this.ballPanel.getY();
                            final boolean isNotZero = this.board.getMatrix()[i][j] != 0;
                            if (isInX && isInY && isNotZero) {
                                final int[][] matrix1 = this.board.getMatrix();
                                if ((this.ball.getBallType() == "Water" && matrix1[i][j] == 2) || (this.ball.getBallType() == "Electricity" && matrix1[i][j] == 3) || (this.ball.getBallType() == "Wooden" && matrix1[i][j] == 4) || (this.ball.getBallType() == "Fire" && matrix1[i][j] == 5) || this.ball.getBallType() == "AllFoueElementsBall") {
                                    this.ball.impact(blocks[i][j].block);
                                    this.bgPanel.remove(this.board);
                                    this.board.update();
                                    this.board.setLocation(10, 50);
                                    this.board.setSize(400, 120);
                                    this.bgPanel.add(this.board);
                                    this.bgPanel.revalidate();
                                    this.bgPanel.repaint();
                                    this.jframe.getContentPane().validate();
                                    this.jframe.getContentPane().repaint();
                                    this.UpdateHits();
                                }
                                else if ((this.ball.getBallType() == "Water" && matrix1[i][j] == 4) || (this.ball.getBallType() == "Electricity" && matrix1[i][j] == 5) || (this.ball.getBallType() == "Wooden" && matrix1[i][j] == 2) || (this.ball.getBallType() == "Fire" && matrix1[i][j] == 3)) {
                                    this.ball.impact(blocks[i][j].block);
                                    this.bgPanel.remove(this.board);
                                    this.board.update();
                                    this.board.setLocation(10, 50);
                                    this.board.setSize(400, 120);
                                    this.bgPanel.add(this.board);
                                    this.BallTimer.stop();
                                    this.UpdateHits();
                                    this.TheBallReleased = false;
                                    this.ThreeSecondsTimer.start();
                                    this.PaddleMoved = false;
                                    if (!this.ThreeSecondsTimer.isRunning() && !this.TheBallReleased) {
                                        this.ReturnTheBallToTheFirstLocation();
                                    }
                                }
                                else {
                                    this.ball.impact(blocks[i][j].block);
                                    this.bgPanel.remove(this.board);
                                    this.board.update();
                                    this.board.setLocation(10, 50);
                                    this.board.setSize(400, 120);
                                    this.bgPanel.add(this.board);
                                    this.bgPanel.revalidate();
                                    this.bgPanel.repaint();
                                    this.jframe.getContentPane().validate();
                                    this.jframe.getContentPane().repaint();
                                    this.GoingUp = false;
                                    this.UpdateHits();
                                }
                            }
                        }
                    }
                    if (this.ballPanel.getY() <= 20) {
                        if (this.CaseOfShot == 1) {
                            this.fromy += 5;
                            this.paintShot(this.fromx -= 10, this.fromy, this.ball);
                        }
                        else if (this.CaseOfShot == 2) {
                            this.fromy += 10;
                            this.paintShot(this.fromx -= 5, this.fromy, this.ball);
                        }
                        else if (this.CaseOfShot == 3) {
                            this.fromy += 10;
                            this.paintShot(this.fromx += 5, this.fromy, this.ball);
                        }
                        else if (this.CaseOfShot == 4) {
                            this.fromy += 5;
                            this.paintShot(this.fromx += 10, this.fromy, this.ball);
                        }
                        else if (this.CaseOfShot == 5) {
                            this.fromy += 10;
                            this.paintShot(this.fromx, this.fromy, this.ball);
                        }
                        this.GoingUp = false;
                    }
                }
                else if (!this.GoingUp) {
                    if (this.CaseOfShot == 1) {
                        this.fromy += 5;
                        this.paintShot(this.fromx -= 10, this.fromy, this.ball);
                    }
                    else if (this.CaseOfShot == 2) {
                        this.fromy += 10;
                        this.paintShot(this.fromx -= 5, this.fromy, this.ball);
                    }
                    else if (this.CaseOfShot == 3) {
                        this.fromy += 10;
                        this.paintShot(this.fromx += 5, this.fromy, this.ball);
                    }
                    else if (this.CaseOfShot == 4) {
                        this.fromy += 5;
                        this.paintShot(this.fromx += 10, this.fromy, this.ball);
                    }
                    else if (this.CaseOfShot == 5) {
                        this.fromy += 10;
                        this.paintShot(this.fromx, this.fromy, this.ball);
                    }
                    if (this.ballPanel.getX() <= 0 || this.ballPanel.getX() >= 390) {
                        if (this.CaseOfShot == 1) {
                            this.fromy += 5;
                            this.paintShot(this.fromx += 10, this.fromy, this.ball);
                            this.CaseOfShot = 4;
                        }
                        else if (this.CaseOfShot == 2) {
                            this.fromy += 10;
                            this.paintShot(this.fromx += 5, this.fromy, this.ball);
                            this.CaseOfShot = 3;
                        }
                        else if (this.CaseOfShot == 3) {
                            this.fromy += 10;
                            this.paintShot(this.fromx -= 5, this.fromy, this.ball);
                            this.CaseOfShot = 2;
                        }
                        else if (this.CaseOfShot == 4) {
                            this.fromy += 5;
                            this.paintShot(this.fromx -= 10, this.fromy, this.ball);
                            this.CaseOfShot = 1;
                        }
                    }
                    BlockPanel[][] blocks = this.board.getBlock();
                    for (int i = 0; i < blocks.length; ++i) {
                        for (int j = 0; j < blocks[i].length; ++j) {
                            blocks = this.board.getBlock();
                            final boolean isInX = blocks[i][j].getX() <= this.ballPanel.getX() && blocks[i][j].getX() + 40 >= this.ballPanel.getX();
                            final boolean isInY = blocks[i][j].getY() + 50 <= this.ballPanel.getY() && blocks[i][j].getY() + 65 >= this.ballPanel.getY();
                            final boolean isNotZero = this.board.getMatrix()[i][j] != 0;
                            if (isInX && isInY && isNotZero) {
                                final int[][] matrix1 = this.board.getMatrix();
                                if ((this.ball.getBallType() == "Water" && matrix1[i][j] == 2) || (this.ball.getBallType() == "Electricity" && matrix1[i][j] == 3) || (this.ball.getBallType() == "Wooden" && matrix1[i][j] == 4) || (this.ball.getBallType() == "Fire" && matrix1[i][j] == 5) || this.ball.getBallType() == "AllFoueElementsBall") {
                                    this.ball.impact(blocks[i][j].block);
                                    this.bgPanel.remove(this.board);
                                    this.board.update();
                                    this.board.setLocation(10, 50);
                                    this.board.setSize(400, 120);
                                    this.bgPanel.add(this.board);
                                    this.bgPanel.revalidate();
                                    this.bgPanel.repaint();
                                    this.jframe.getContentPane().validate();
                                    this.jframe.getContentPane().repaint();
                                    this.UpdateHits();
                                }
                                else if ((this.ball.getBallType() == "Water" && matrix1[i][j] == 4) || (this.ball.getBallType() == "Electricity" && matrix1[i][j] == 5) || (this.ball.getBallType() == "Wooden" && matrix1[i][j] == 2) || (this.ball.getBallType() == "Fire" && matrix1[i][j] == 3)) {
                                    this.ball.impact(blocks[i][j].block);
                                    this.bgPanel.remove(this.board);
                                    this.board.update();
                                    this.board.setLocation(10, 50);
                                    this.board.setSize(400, 120);
                                    this.bgPanel.add(this.board);
                                    this.BallTimer.stop();
                                    this.UpdateHits();
                                    this.bgPanel.revalidate();
                                    this.bgPanel.repaint();
                                    this.jframe.getContentPane().validate();
                                    this.jframe.getContentPane().repaint();
                                    this.TheBallReleased = false;
                                    this.ThreeSecondsTimer.start();
                                    this.PaddleMoved = false;
                                    if (!this.ThreeSecondsTimer.isRunning() && !this.TheBallReleased) {
                                        this.ReturnTheBallToTheFirstLocation();
                                    }
                                }
                                else {
                                    this.ball.impact(blocks[i][j].block);
                                    this.bgPanel.remove(this.board);
                                    this.board.update();
                                    this.board.setLocation(10, 50);
                                    this.board.setSize(400, 120);
                                    this.bgPanel.add(this.board);
                                    this.bgPanel.revalidate();
                                    this.bgPanel.repaint();
                                    this.jframe.getContentPane().validate();
                                    this.jframe.getContentPane().repaint();
                                    this.GoingUp = true;
                                    this.UpdateHits();
                                }
                            }
                        }
                    }
                    final boolean isy = this.ballPanel.getY() + 15 >= this.paddle.getY();
                    final boolean isx = this.ballPanel.getX() <= this.paddle.getX() + 110 && this.ballPanel.getX() >= this.paddle.getX() - 10;
                    if (isx && isy) {
                        if (this.ballPanel.getX() < this.paddle.getX() + 14 && this.ballPanel.getX() >= this.paddle.getX() - 10) {
                            this.CaseOfShot = 1;
                        }
                        else if (this.ballPanel.getX() < this.paddle.getX() + 38 && this.ballPanel.getX() >= this.paddle.getX() + 14) {
                            this.CaseOfShot = 2;
                        }
                        else if (this.ballPanel.getX() < this.paddle.getX() + 62 && this.ballPanel.getX() >= this.paddle.getX() + 38) {
                            this.CaseOfShot = 5;
                        }
                        else if (this.ballPanel.getX() < this.paddle.getX() + 86 && this.ballPanel.getX() >= this.paddle.getX() + 62) {
                            this.CaseOfShot = 3;
                        }
                        else if (this.ballPanel.getX() < this.paddle.getX() + 110 && this.ballPanel.getX() >= this.paddle.getX() + 86) {
                            this.CaseOfShot = 4;
                        }
                        this.GoingUp = true;
                    }
                }
            }
        }
    }
    
    private int ReturnTheScoreOfThisLevel() {
        int ans = 1500;
        ans = Math.max(0, ans - this.NumOfHits - 2 * this.GameTime);
        return ans;
    }
    
    private void Relaese() {
        (this.BallTimer = new Timer(25, this)).start();
    }
    
    public void paintShot(final int fromX, final int fromY, final Ball ball) {
        if (this.ballPanel != null) {
            this.bgPanel.remove(this.ballPanel);
        }
        (this.ballPanel = new BallPanel(ball)).setLocation(this.fromx, this.fromy);
        this.ballPanel.setSize(15, 15);
        this.ballPanel.setLayout(null);
        this.bgPanel.remove(this.board);
        this.bgPanel.add(this.ballPanel);
        this.bgPanel.add(this.board);
        this.bgPanel.validate();
        this.bgPanel.repaint();
        this.jframe.getContentPane().validate();
        this.jframe.getContentPane().repaint();
    }
    
    private int RandomAngle() {
        double x = Math.random();
        x *= 5.0;
        if (x < 1.0 && x >= 0.0) {
            this.CaseOfShot = 1;
        }
        else if (x < 2.0 && x >= 1.0) {
            this.CaseOfShot = 2;
        }
        else if (x < 3.0 && x >= 2.0) {
            this.CaseOfShot = 3;
        }
        else if (x < 4.0 && x >= 3.0) {
            this.CaseOfShot = 4;
        }
        else if (x < 5.0 && x >= 4.0) {
            this.CaseOfShot = 5;
        }
        return this.CaseOfShot;
    }
    
    private void ReplaceSide() {
        if (this.CaseOfShot == 1) {
            this.fromy -= 5;
            this.paintShot(this.fromx += 10, this.fromy, this.ball);
            this.CaseOfShot = 4;
        }
        else if (this.CaseOfShot == 2) {
            this.fromy -= 10;
            this.paintShot(this.fromx += 5, this.fromy, this.ball);
            this.CaseOfShot = 3;
        }
        else if (this.CaseOfShot == 3) {
            this.fromy -= 10;
            this.paintShot(this.fromx -= 5, this.fromy, this.ball);
            this.CaseOfShot = 2;
        }
        else if (this.CaseOfShot == 4) {
            this.fromy -= 5;
            this.paintShot(this.fromx -= 10, this.fromy, this.ball);
            this.CaseOfShot = 1;
        }
    }
    
    private Boolean CheckIfAllTheMatrixEnmpty() {
        final int[][] matrix = this.board.getMatrix();
        boolean ans = false;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j] != 0) {
                    return false;
                }
                ans = true;
            }
        }
        return ans;
    }
    
    private void UpdateHits() {
        ++this.NumOfHits;
        this.toolbar.remove(this.hits);
        this.bgPanel.remove(this.toolbar);
        (this.hits = new JLabel("Hits :" + this.NumOfHits)).setSize(150, 30);
        this.hits.setLocation(170, 0);
        this.toolbar.setLocation(0, 0);
        this.toolbar.setSize(500, 30);
        this.toolbar.setLayout(null);
        this.toolbar.add(this.hits);
        this.bgPanel.add(this.toolbar);
        this.bgPanel.revalidate();
        this.bgPanel.repaint();
    }
    
    private void ReturnTheBallToTheFirstLocation() {
        this.ballPanel.setLocation(170, 405);
        this.paddlePanel.setLocation(120, 420);
        this.ballPanel.setSize(15, 15);
        this.ballPanel.setLayout(null);
        this.fromx = 170;
        this.fromy = 405;
        this.bgPanel.add(this.ballPanel);
        this.bgPanel.add(this.paddlePanel);
        this.jframe.getContentPane().add(this.bgPanel);
        this.GoingUp = true;
    }
    
    static /* synthetic */ void access$5(final GameWindow gameWindow, final Boolean paddleMoved) {
        gameWindow.PaddleMoved = paddleMoved;
    }
    
    static /* synthetic */ void access$6(final GameWindow gameWindow, final Ball ball) {
        gameWindow.ball = ball;
    }
    
    static /* synthetic */ void access$7(final GameWindow gameWindow, final int fromx) {
        gameWindow.fromx = fromx;
    }
    
    static /* synthetic */ void access$8(final GameWindow gameWindow, final int fromy) {
        gameWindow.fromy = fromy;
    }
    
    static /* synthetic */ void access$14(final GameWindow gameWindow, final int caseOfShot) {
        gameWindow.CaseOfShot = caseOfShot;
    }
    
    static /* synthetic */ void access$15(final GameWindow gameWindow, final Boolean theBallReleased) {
        gameWindow.TheBallReleased = theBallReleased;
    }
    
    static /* synthetic */ void access$18(final GameWindow gameWindow, final boolean isFirstShot) {
        gameWindow.isFirstShot = isFirstShot;
    }
}
