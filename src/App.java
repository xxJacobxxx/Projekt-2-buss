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
            boka(sittplatserFödnmr, sittplatserNamn);
            case 2:
            hittaBokning();
            case 3:
            avboka();
            case 4:
            break;
        }
        

    }
    static void boka(int []sittplatserFödnmr, String []sittplatserNamn){
        System.out.println("Vill du boka en fönsterplats eller gångplats?");
        int [] fönsterplatser = new int[10];
        if (in.nextLine().equalsIgnoreCase("fönsterplats")){
            hittaFönsterPlatser(fönsterplatser);
            System.out.println("Skriv ditt födelsenummer först med ÅÅÅÅMMDD format");
            int födnmr = 0;
            while (födnmr==0){
                try {
                    födnmr = in.nextInt();
                    in.nextLine();
                } catch (Exception e) {
                    System.out.println("Svar med siffror");
                    födnmr = 0;
                    in.nextLine();
                }
                if (födnmr>30000000||födnmr<10000000&&födnmr!=0) {
                    System.out.println("Svara i ÅÅÅÅMMDD format");
                    födnmr=0;
                }
            }

        }
    }
    static void hittaFönsterPlatser (int []fönsterplatser){
        int fönsterindex = 0;
        int fyra = 4;
        for (int i=0; i<20; i++){
            if (i%4==1||i%4==0) {
                fönsterplatser[fönsterindex] = i;
                fönsterindex++;
            }
        }
    }
    static int hittaBokning(){
        int index = 0;
        return index;

    }
    static void avboka(){

    }
}
