package ua.shkarupeta.training.practice1;

public class Part4 {

    public static void main(String[] args) {

        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);

        System.out.println(nod(x, y).toString());

    }

    static Integer nod(int arg1, int arg2) {
        int min;
        int nod = 0;
        min = Math.min(arg1, arg2);
        for (int count = 1; count <= min; count++) {
            boolean countMoreNod = count > nod;
            if (arg1 % count == 0 && arg2 % count == 0 && countMoreNod) {
                nod = count;

            }
        }

        return nod;
    }

}
