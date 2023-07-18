import java.util.ArrayList;

import java.util.List;

class Main {
    public static void main(String[] args) {

    }

    public static int Fib(int pos) {
        if (pos <= 2) {
            return 1;
        }
        return Fib(pos - 1) + Fib(pos - 2);
    }

    public static int fib_no_rec(int num) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        res.add(1);
        for (int i = 2; i <= num; i++) {
            res.add(res.get(i - 1) + res.get(i - 2));
        }
        return res.get(num);
    }

}

