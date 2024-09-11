import java.util.*;

public class aMorning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
            while(t-->0){
                String input = sc.next();
                String[] arr = input.split("");

                for(int i=0;i<arr.length; i++){
                    if(arr[i].equals("0")){
                        arr[i] ="10";
                    }
                }


                int d1 = Integer.parseInt(arr[0]);
                int d2 = Integer.parseInt(arr[1]);
                int d3 = Integer.parseInt(arr[2]);
                int d4 = Integer.parseInt(arr[3]);
                int totalSteps = 4+ Math.abs(d1-d2)+Math.abs(d2-d3)+Math.abs(d3-d4);
                System.out.println(totalSteps);
                t--;
            }
        }
        

    }


    

