
public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int N = 50;
        for(int i = 0; i < 100; i++){
            double row = (Math.random() * N + 1);
            double col = (Math.random() * N + 1);
            System.out.println("row: "+row+"\trowi: "+(int)row+"\tcol: "+col+"\tcoli: "+(int)col);
        }
    }

}
