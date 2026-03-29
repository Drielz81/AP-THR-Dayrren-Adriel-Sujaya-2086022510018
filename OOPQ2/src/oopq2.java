import java.util.*;

abstract class Stand{
    protected String stands;
    
    Stand(String stands){
        this.stands = stands;
    }

    protected abstract boolean tersangka(String suspect);

    public String getStand(){return stands;}
}

class Josuke extends Stand{
    Josuke(){
        super("Josuke");
    }

    @Override
    protected boolean tersangka(String suspect){
        return suspect.toLowerCase().startsWith("k");
    }
}

class Jotaro extends Stand{
    Jotaro(){
        super("Jotaro");
    }

    @Override
    protected boolean tersangka(String suspect){
        return suspect.length() <= 3;
    }
}

class Okuyasu extends Stand{
    Okuyasu(){
        super("Okuyasu");
    }

    @Override
    protected boolean tersangka(String suspect){
        for(int i = 0; i < suspect.length()-1;i++){
            if (suspect.charAt(i) == suspect.charAt(i+1)){
                return true;
            }
        }
        return false;
    }
}

class Koichi extends Stand{
    private int total_vowels = 0;
    Koichi(){
        super("Koichi");
    }
    @Override
    protected boolean tersangka(String suspect){
        int total_vowels = 0;
        for(char i : suspect.toLowerCase().toCharArray()){
            if("aiueo".indexOf(i) != -1){
                total_vowels++;
            }
        }
        return total_vowels >= 3;
    }
}

class Rohan extends Stand{
    Rohan(){
        super("Rohan");
    }
    @Override
    protected boolean tersangka(String suspect){
        String reversed = new StringBuilder(suspect).reverse().toString();
        return suspect.equalsIgnoreCase(reversed);
    }
}
public class oopq2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String nama_detektif = scanner.nextLine();
        String nama_suspect = scanner.nextLine();
        scanner.close();

        Stand stand = null;
        switch (nama_detektif.toLowerCase()) {
            case "josuke":
                stand = new Josuke();
                break;
            case "jotaro":
                stand = new Jotaro();
                break;
            case "okuyasu":
                stand = new Okuyasu();
                break;
            case "koichi":
                stand = new Koichi();
                break;
            case "rohan":
                stand = new Rohan();
                break;
            default:
                break;
        }
        
        Queue<String> input_nama_suspect = new LinkedList<>(Arrays.asList(nama_suspect.split(" ")));
        Stack<String> hasil_akhir_suspect = new Stack<>();
        while(!input_nama_suspect.isEmpty()){
            String nama = input_nama_suspect.poll();
            if (stand.tersangka(nama)){
                hasil_akhir_suspect.push(nama);
            }
        }
        if(hasil_akhir_suspect.isEmpty()){
            System.out.println(nama_detektif + " exposed no one.");
            System.out.println("Arrested: []");
        } else {
            System.out.println(nama_detektif + " exposed someone!");
            System.out.print("Arrested:" + hasil_akhir_suspect);
        }
    }
}
