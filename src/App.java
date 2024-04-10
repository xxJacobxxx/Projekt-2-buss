import java.util.Scanner;
public class App {
    public static Scanner in =new  Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
        final double VUXENPRIS = 269.90;
        final double BARNPRIS = 149.90;
        int[] sittplatserFödnmr = new int [20];
        String[] sittplatserNamn = new String [20];
        for(int i=0; i<sittplatserFödnmr.length; i++){
            sittplatserFödnmr[i] = 0;
            sittplatserNamn[i] = "0";
        }
        System.out.println("Välkommen till bussen!");
        System.out.println("1. Boka");
        System.out.println("2. Hitta bokning");
        System.out.println("3. Avboka");
        System.out.println("4. Avsluta programmet");
        int svar = 0;
        while (svar==0){
            try {
                svar = in.nextInt();
                in.nextLine();
            } catch (Exception e) {
                System.out.println("Svar med siffror");
                svar = 0;
                in.nextLine();
            }
            if (svar>4||svar<1&&svar!=0) {
                System.out.println("Svara med rätt siffror");
                svar=0;
            }
        }
        switch (svar) {
            case 1:
            boka();
            case 2:
            hittaBokning();
            case 3:
            avboka();
            case 4:
            break;
        }
        

    }
    static void boka(){

    }
    static int hittaBokning(){
        int index = 0;
        return index;

    }
    static void avboka(){

    }
}
