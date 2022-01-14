public class FindMaxNum {
    
    static int fuctorial(int n) {
        return (n > 0) ? n * fuctorial(n - 1) : 1;
    }
    
    public static int getResult(List<Integer> numb, List<String> arith) {
        // Write your code here...
        String[] arr = new String[arith.size()];
        for (int i = 0; i < arith.size(); i++) {
            arr[i] = arith.get(i);
        }

        int count = fuctorial(arr.length); // 120 - факториал длинны массива
        int max = arr.length - 1; //4

        //System.out.println("Вариантов " + count);
        int shift = max; // 4
        String t;

        int myCount = 0;
        int result = 0;
        int myMax = 0;

        while (count > 0) { // 120
            t = arr[shift];

            arr[shift] = arr[shift - 1];
            arr[shift - 1] = t;
            count--;
            if (shift < 2) {
                shift = max;
            } else {
                shift--; // 119
            }
            while (myCount<arith.size()){

                switch (arr[myCount]) {
                    case "*" : {
                        //  System.out.println(result + " * " + numb.get(myCount));
                        result = result * numb.get(myCount);
                        myCount++;
                        break;
                    }
                    case "/" :{
                        //  System.out.println(result + " / " + numb.get(myCount));
                        result = result / numb.get(myCount);
                        myCount++;
                        break;
                    }
                    case "+" : {
                          //  System.out.println(result + " + " + numb.get(myCount));
                        result = result + numb.get(myCount);
                        myCount++;
                        break;
                    }
                    case "-" :{
                        //  System.out.println(result + " - " + numb.get(myCount));
                        result = result - numb.get(myCount);
                        myCount++;
                        break;
                    }
                }
            }
            //System.out.println("result: " + result);
            if (result > myMax) myMax = result;
            result = 0;
            myCount = 0;
        }
        return myMax;
    }


    public static void main(String[] args) {


        ArrayList<Integer>numb = new ArrayList<>();
        numb.add(1);
        numb.add(4);
        numb.add(2);

        ArrayList<String>arith = new ArrayList<>();
        arith.add("+");
        arith.add("-");
        arith.add("*");

        System.out.println(getResult(numb,arith));


    }
}
