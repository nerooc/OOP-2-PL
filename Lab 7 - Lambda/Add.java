package lab07;

public class Add {
    int add(int x0, int... x){
        int sum = x0;
        System.out.print(x0 + "+");

        for(int i = 0; i < x.length; i++){
            sum += x[i];

            if(i != x.length - 1){
                System.out.print(x[i] + "+");
            } else {
                System.out.print(x[i] + "=" + sum + "\n");
            }
        }

        return sum;
    }
}
