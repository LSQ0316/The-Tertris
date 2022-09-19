package qi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class MainFrame extends JFrame {
    private Snake snake; //蛇
    private JPanel jPanel;//游戏棋盘
    private Timer timer; //定时器，在规定的时间内调用蛇移动的方法

    private Node food;//食物

    public MainFrame() throws HeadlessException {
        //初始化窗体参数
        initFrame();
        //初始化游戏棋盘
        initGamePanel();
        //初始化蛇
        initSnake();
        //初始化食物
        initFood();
        //初始化定时器
        initTimer();
        //设置键盘监听，让蛇移动
        setKeyListener();
    }

    //初始化食物
    private void initFood() {
        food = new Node();
        food.random();
    }

    private void setKeyListener() {
        addKeyListener(new KeyAdapter() {
            //当键盘按下时，会自动调用此方法
            @Override
            public void keyPressed(KeyEvent e) {
                //键盘中每一个键都有一个编号
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP://上键
                        if (snake.getDirection() != Direction.DOWN) {
                            //修改蛇的运动方向
                            snake.setDirection(Direction.UP);
                        }
                        break;
                    case KeyEvent.VK_DOWN://下键
                        if (snake.getDirection() != Direction.UP) {
                            snake.setDirection(Direction.DOWN);
                        }
                        break;
                    case KeyEvent.VK_LEFT://左键
                        if (snake.getDirection() != Direction.RIGHT) {
                            snake.setDirection(Direction.LEFT);
                        }
                        break;
                    case KeyEvent.VK_RIGHT://右键
                        if (snake.getDirection() != Direction.LEFT) {
                            snake.setDirection(Direction.RIGHT);
                        }
                        break;
                }
            }
        });
    }

    private void initTimer() {
        timer = new Timer();
        //初始化定时任务
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                snake.move();
                //判断蛇头是否与食物重合
                Node head = snake.getBody().getFirst();
                if (head.getX() == food.getX() && head.getY() == food.getY()) {
                    snake.eat(food);
                    food.random();
                }
                //重绘游戏棋盘
                jPanel.repaint();
            }
        };

        //每100ms，执行一次定时任务
        timer.scheduleAtFixedRate(timerTask, 0, 100);
    }

    private void initSnake() {
        snake = new Snake();
    }

    //初始化游戏棋盘
    private void initGamePanel() {
        jPanel = new JPanel() {
            //绘制游戏棋盘中的内容
            @Override
            public void paint(Graphics g) {
                //清空棋盘
                g.clearRect(0, 0, 1000, 1000);

                //Graphics g 可以看作一个画笔

                //绘制40条横线
                for (int i = 0; i < 40; i++) {
                    g.drawLine(0, i * 25, 1000, i * 25);
                }

                //绘制40条竖线
                for (int i = 0; i < 40; i++) {
                    g.drawLine(i * 25, 0, i * 25, 1000);
                }

                //绘制蛇
                LinkedList<Node> body = snake.getBody();
                for (Node node : body) {
                    g.fillRect(node.getX() * 25, node.getY() * 25, 25, 25);
                }

                //绘制食物
                g.fillRect(food.getX() * 25, food.getY() * 25, 25, 25);
            }
        };
        //把棋盘添加到窗体中
        add(jPanel);
    }

    //初始化窗体参数
    private void initFrame() {
        setTitle("贪吃蛇");
        //设置窗体宽高
        setSize(1000, 1000);
        //设置窗体位置
        setLocation(400, 0);
        //设置关闭按钮的作用 (退出)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗体大小不可变
        setResizable(false);
    }

    public static void main(String[] args) {
        //创建窗体对象，并显示
        new MainFrame().setVisible(true);
    }
}
