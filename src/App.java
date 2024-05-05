import java.util.Random;
import java.util.Scanner;

public class App {
    public static Scanner in =new  Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
        final double VUXENPRIS = 269.90;
        final double BARNPRIS = 149.90;
        int[] sittplatserFödnmr = new int [20];
        String[] sittplatserNamn = new String [20];
        double totalPris = 0;
        for(int i=0; i<sittplatserFödnmr.length; i++){
            sittplatserFödnmr[i] = 0;
            sittplatserNamn[i] = "0";
        }
        boolean meny = true;
        while (meny) {
            System.out.println("Välkommen till bussen!");
            System.out.println("1. Boka");
            System.out.println("2. Hitta bokning");
            System.out.println("3. Avboka");
            System.out.println("4. Avsluta programmet");
            System.out.println("5. Skriv ut platser");
            System.out.println("6. Visa bokningar i åldersordning");
            System.out.println("7. Beräkna vinsten ");
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
                if (svar>7||svar<1&&svar!=0) {
                    System.out.println("Svara med rätt siffror");
                    svar=0;
                }
            }
            switch (svar) {
                case 1:
                    boka(sittplatserFödnmr, sittplatserNamn);
                    break;
                case 2:
                    int hittadBokning =hittaBokning(sittplatserFödnmr, sittplatserNamn);
                    if(hittadBokning==0){
                        System.out.println("Kunde inte hitta bokningen, kontrollera att du inte har använt å,ä,ö i namnet eller skrivit fel någonstans.");
                    }
                    else{
                        System.out.println("Bokningen finns på plats nummer: "+(hittadBokning+1));
                    }
                    break;
                case 3:
                    avboka(sittplatserFödnmr, sittplatserNamn);
                break;
                case 4:
                meny = false;
                break;
                case 5:
                visaPlatser(sittplatserFödnmr);
                break;
                case 6:
                skrivUtSorteradLista(sittplatserFödnmr,sittplatserNamn);
                break;
                case 7:
                beräknaVinst(sittplatserFödnmr, 21, BARNPRIS, VUXENPRIS, totalPris);
            }
        }
        

    }
    static void boka(int []sittplatserFödnmr, String []sittplatserNamn){
        System.out.println("Vill du specialboka en fönsterplats");
        System.out.println("Välj 1 för fönsterplats och 2 för ospecifierat sittplats");
        int [] fönsterplatser = new int[10];
        Random rand = new Random();
        int fönsterEllerGång = 0;
            while (fönsterEllerGång==0){
                try {
                    fönsterEllerGång = in.nextInt();
                    in.nextLine();
                } catch (Exception e) {
                    System.out.println("Svar med siffror");
                    fönsterEllerGång = 0;
                    in.nextLine();
                }
                if (fönsterEllerGång>2||fönsterEllerGång<1&&fönsterEllerGång!=0) {
                    System.out.println("Svara med rätt siffror");
                    fönsterEllerGång=0;
                }
            }
        System.out.println("Skriv ditt födelsenummer först med ÅÅÅÅMMDD format");
        int födnmr = 0;
        while (födnmr==0){
            try {
                födnmr = in.nextInt();
                in.nextLine();                } catch (Exception e) {
                System.out.println("Svar med siffror");
                födnmr = 0;
                in.nextLine();
            }
            if (födnmr>30000000||födnmr<10000000&&födnmr!=0) {
                System.out.println("Svara i ÅÅÅÅMMDD format");
                födnmr=0;
            }
            }
        if (fönsterEllerGång==1){
            
            hittaFönsterPlatser(fönsterplatser);
            int platsindex = rand.nextInt(10);
            sittplatserFödnmr[fönsterplatser[platsindex]] = födnmr;
            System.out.println("Skriv nu in ditt namn");
            sittplatserNamn[fönsterplatser[platsindex]] = in.nextLine();

        }
        else{
            int platsindex = rand.nextInt(10);
            sittplatserFödnmr[platsindex] = födnmr;
            System.out.println("Skriv nu in ditt namn");
            sittplatserNamn[platsindex] = in.nextLine();

        }
        
    }
    static void hittaFönsterPlatser (int []fönsterplatser){
        int fönsterindex = 0;
        int fyra = 4;
        for (int i=0; i<20; i++){
            if ((i+1)%4==1||(i+1)%4==0) {
                fönsterplatser[fönsterindex] = i;
                fönsterindex++;
            }
        }
    }
    static int hittaBokning(int []sittplatserFödnmr, String []sittplatserNamn){
        System.out.println("Skriv in namnet eller personnummret till platsen du söker.");
        boolean namn = false;
        int index = 0;
        String sökVärde = in.nextLine();
        try {
            Integer.parseInt(sökVärde);
        } catch (Exception e) {
            namn = true;
        }
        if (namn){
            for(int i=0; i<20;i++){
                if (sökVärde.equalsIgnoreCase(sittplatserNamn[i])){
                    index = i;
                }
                else{

                }
            }
        }
        return index;

    }
    static void avboka(int[]sittplatserFödnmr, String[]sittplatserNamn){
        int index = hittaBokning(sittplatserFödnmr, sittplatserNamn);
        sittplatserFödnmr[index] = 0;
        sittplatserNamn[index] = "0";
    }
    static void visaPlatser(int[]sittplatserFödnmr){
        for (int i=0; i<sittplatserFödnmr.length;i++){
            if(sittplatserFödnmr[i]==0){
                if (i<=8){
                    System.out.print("[0"+(i+1)+"]");
                }
                else{
                    System.out.print("["+(i+1)+"]");
                }
            }
            else{
                System.out.print("[XX]");
            }
            if ((i+1)%4==2) {
                System.out.print("   ");
            }
            if ((i+1)%4==0) {
                System.out.println();
            }
        }
    }
    static void skrivUtSorteradLista(int[] sittplatserFödnmr, String[] sittplatserNamn) {
        int[] åldersSorterade = new int[20];
        String[] namnSorterade = new String[20];
        int platsRäknare = 0;
        sorteraLista(åldersSorterade, sittplatserFödnmr, namnSorterade, sittplatserNamn);
        for (int i = 0; i < 20; i++) {
            if (åldersSorterade[i] == 0) {
                platsRäknare++;
            } else {
                System.out.println(åldersSorterade[i] + " " + namnSorterade[i]);
            }
    
        }
        if (platsRäknare == 20) {
            System.out.println("Inga platser bokade");
        }
    }
    
    static void sorteraLista(int[] åldersSorterade, int[] sittplatserFödnmr, String[] namnSorterade, String[] sittplatserNamn) {
        int åldertemp = 0;
        String namntemp = "";
        for (int i = 0; i < 20; i++) {
            åldersSorterade[i] = sittplatserFödnmr[i];
            namnSorterade[i] = sittplatserNamn[i];
        }
        for (int j = 0; j < 20; j++) {
            for (int i = 0; i < 19; i++) {
                if (åldersSorterade[i] > åldersSorterade[i + 1]) {
                    åldertemp = åldersSorterade[i];
                    åldersSorterade[i] = åldersSorterade[i + 1];
                    åldersSorterade[i + 1] = åldertemp;
    
                    namntemp = namnSorterade[i];
                    namnSorterade[i] = namnSorterade[i + 1];
                    namnSorterade[i + 1] = namntemp;
    
                }
            }
    
        }
    }
    static void beräknaVinst(int[]sittplatserFödnmr,int index,double BARNPRIS, double VUXENPRIS, double totalPris){
        if (index==0) {
            System.out.println("Vinsten är: "+totalPris);
        }
        else{
            if (sittplatserFödnmr[index-1]<20060500&&sittplatserFödnmr[index-1]!=0){
               totalPris = totalPris+VUXENPRIS;
            }
            else if(sittplatserFödnmr[index-1]!=0){
                totalPris = totalPris+BARNPRIS;
            }
            beräknaVinst(sittplatserFödnmr, index-1, BARNPRIS, VUXENPRIS, totalPris);
        }
    }
}