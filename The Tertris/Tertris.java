import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Tertris extends JFrame{
    //游戏行数为26，列数为12
    private static final int game_x = 26;
    private static final int game_y = 12;
    //文本域数组
    JTextArea[][] text;
    //二维数组
    int[][] data;

    public void initWindow(){
        //设置窗口大小
        this.setSize(600, 850);
        //设置窗口是否可见
        this.setVisible(true);
        //设置窗口居中
        this.setLocationRelativeTo(null);
        //设置释放窗体
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口大小不可变
        this.setResizable(false);
        //设置标题
        this.setTitle("俄罗斯方块");

    }

    //初始化游戏界面
    public void initGamePanle(){
        JPanel game_main = new JPanel();
        game_main.setLayout(new GridLayout(game_x,game_y,1,1));
    }

    public Tertris(){
        text = new JTextArea[game_x][game_y];
        data = new int[game_x][game_y];

        initWindow();
    }

    public static void main(String[] args) {
        Tertris tertris = new Tertris();
    }
}