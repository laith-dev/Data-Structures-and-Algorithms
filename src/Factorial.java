public class Factorial {

    public static int linearFact(int x) {

        int answer = 1;
        for(int i = x; i >= 2; i--)
            answer *= i;

        return answer;

    }

}
