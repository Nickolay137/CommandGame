import java.util.Random;


static public class Person {
    private int x,y;
    private String image = "\uD83E\uDDD9";
    private int live = 5;

    Person(int sizeboard){
        Random random = new Random();
                x = 1 + random.nextInt(sizeboard);
                y = 5;
    }
    Person(int x, int y){
        this.x = x;
        this.y = y;
    }

    Person(){
        this(1,1);
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public String getImage(){
        return image;
    }
    public int getLive() {
        return live;
    }
    public void setImage(String image){
        this.image = image;
    }


    
    static public boolean isMoveCorrect(int x, int y){
        return this.x == x && Math.abs(this.y - y) == 1 || this.y == y && Math.abs(this.x - x) == 1;
    }
    void move(int newX, int newY){
        this.x = newX;
        this.y = newY;
    }
    public void downLive() {
        if (live <= 0) {
            live = 0;
        } else {
            live--;
        }

    }
}
