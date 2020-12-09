package lab07;

public class Add {
    int add(int x0, int... x){
        int sum = x0;
        System.out.print(x0 + "+");

        for(int i = 0; i < x.length - 1; i++){
            sum += x[i];
            System.out.print(x[i] + "+");
        }
       
        System.out.print(x[x.length - 1] + "=" + sum, + "\n");
        return sum;
    }
}
