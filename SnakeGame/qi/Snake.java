package qi;

import java.util.LinkedList;

/**
 * Snake表示蛇
 * 一条蛇有多个节点使用，使用LinkedList集合存储Node节点，蛇出生的时候有3个节点
 */
public class Snake {
    /**
     * 蛇的身体
     */
    private LinkedList<Node> body;

    //蛇的运动方向
    private Direction direction = Direction.LEFT;

    //蛇是否活着
    private boolean isLiving = true;

    //构造方法，在创建Snake对象时执行
    public Snake() {
        //初始化蛇的身体
        initSnake();
    }

    //初始化蛇的身体
    private void initSnake() {
        //创建集合
        body = new LinkedList<>();
        //创建6个节点，添加到集合中
        body.add(new Node(17, 20));
        body.add(new Node(18, 20));
        body.add(new Node(19, 20));
        body.add(new Node(20, 20));
        body.add(new Node(21, 20));
        body.add(new Node(22, 20));
    }

    //蛇会沿着蛇头的方向移动
    //控制蛇移动：在蛇头的运动方向添加一个节点，然后将蛇尾的节点删除
    public void move() {
        if (isLiving) {
            //获取蛇头
            Node head = body.getFirst();
            switch (direction) {
                case UP:
                    //在蛇头的上面添加一个节点
                    body.addFirst(new Node(head.getX(), head.getY() - 1));
                    break;
                case DOWN:
                    //在蛇头的下面添加一个节点
                    body.addFirst(new Node(head.getX(), head.getY() + 1));
                    break;
                case LEFT:
                    //在蛇头的左边添加一个节点
                    body.addFirst(new Node(head.getX() - 1, head.getY()));
                    break;
                case RIGHT:
                    //在蛇头的右边添加一个节点
                    body.addFirst(new Node(head.getX() + 1, head.getY()));
                    break;
            }
            //删除最后的节点
            body.removeLast();

            //判断蛇是否撞墙
            head = body.getFirst();
            if (head.getX() < 0 || head.getX() >= 1000 || head.getY() < 0 || head.getY() >= 1000) {
                isLiving = false;
            }

            //判断蛇是否碰到自己的身体
            for (int i = 1; i < body.size(); i++) {
                Node node = body.get(i);
                if (head.getX() == node.getX() && head.getY() == node.getY()) {
                    isLiving = false;
                }
            }
        }
    }


    public LinkedList<Node> getBody() {
        return body;
    }

    public void setBody(LinkedList<Node> body) {
        this.body = body;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    //吃食物：沿着蛇头的移动方向
    public void eat(Node food) {
        //获取蛇头
        Node head = body.getFirst();
        switch (direction) {
            case UP:
                //在蛇头的上面添加一个节点
                body.addFirst(new Node(head.getX(), head.getY() - 1));
                break;
            case DOWN:
                //在蛇头的下面添加一个节点
                body.addFirst(new Node(head.getX(), head.getY() + 1));
                break;
            case LEFT:
                //在蛇头的左边添加一个节点
                body.addFirst(new Node(head.getX() - 1, head.getY()));
                break;
            case RIGHT:
                //在蛇头的右边添加一个节点
                body.addFirst(new Node(head.getX() + 1, head.getY()));
                break;
        }

    }
}
