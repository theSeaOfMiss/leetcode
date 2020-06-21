package dir.solution_7;

class Example {
    public int reverse(int x) {
        int result = 0;
        while( x != 0){
            int n = x % 10;
            if(x > 0 && result > (Integer.MAX_VALUE - n)/10){
                return 0;
            }
            if(x < 0 && result < (Integer.MIN_VALUE - n)/10){
                return 0;
            }
            result = result * 10 + n;
            x /= 10;
        }
        return result;
    }
}