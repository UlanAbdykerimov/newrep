import java.util.Scanner;
import java.util.Random;

public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        int[] entKm = new int [3];
        int[] hidKm = hiddenKm();
        boolean match = false;
        int sumHidKm = hidKm[0] + hidKm[1] + hidKm[2];
        int schetMatch = 0;


        System.out.println("               Welcome to the Earth!");
        System.out.println("Our valuable guest, enter 3 points where the boxes could be burried: ");



        while (match==false){
            for (int i=5; i>0; i--){
                for (int e=0; e<3; e++){
                    int enKm = sc.nextInt();
                    entKm[e] = enKm;
                }
                int sumEntKm = entKm[0] + entKm[1] + entKm[2];
                if (sumEntKm==sumHidKm){
                    for (int j=0; j<3; j++){
                        for (int q=0; q<3; q++){
                            if(hidKm[j]==entKm[q]){
                                schetMatch++;
                                hidKm[j]= -1;
                            }
                        }
                    }
                }
                if (schetMatch==3) {
                    match=true;
                    i=0;
                }
                else {
                    System.out.println("Points are not matching, please enter again (legs will change points in " + i + " attemts!)");
                }
            }
            hidKm = hiddenKm();
        }
        System.out.println("You have successfully found all points!!!");

    }
    public static int[] hiddenKm() {
        Random ran = new Random();
        int[] arr = new int [3];
        for (int i=0; i<3; i++) {
            arr[i] = ran.nextInt(8);
            while (i==1 && arr[1]==arr[0]) arr[i] = ran.nextInt(8);
            while (i==2 && (arr[2]==arr[0] || arr[2]==arr[1])) arr[i] = ran.nextInt(8);
        }
        return arr;
    }
}