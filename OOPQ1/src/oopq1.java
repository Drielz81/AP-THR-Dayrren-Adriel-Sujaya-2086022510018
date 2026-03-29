import java.util.*;

class Pair{
    String nama;
    String bulan;

    Pair(String nama, String bulan){
        this.nama = nama;
        this.bulan = bulan;
    }
}
public class oopq1 {
    public static void main(String[] args) throws Exception {
        Stack<String> stack_input = new Stack<String>();
        Scanner scanner = new Scanner(System.in);   
        Map<String, Integer> pair_month_index = new HashMap<>();
        List<Pair> input_user = new ArrayList<>();
        Stack<String> stack_hasil = new Stack<>();
        
        pair_month_index.put("januari",1);
        pair_month_index.put("februari",2);
        pair_month_index.put("maret",3);
        pair_month_index.put("april",4);
        pair_month_index.put("mei",5);
        pair_month_index.put("juni",6);
        pair_month_index.put("juli",7);
        pair_month_index.put("agustus",8);
        pair_month_index.put("september",9);
        pair_month_index.put("oktober",10);
        pair_month_index.put("november",11);
        pair_month_index.put("desember",12);

        for (String i : scanner.nextLine().split(" ")){
            stack_input.push(i);
        }
        scanner.close();

        while(!stack_input.empty()){
            String bulan1 = stack_input.pop();
            String nama1 = stack_input.pop();
            input_user.add(new Pair(nama1, bulan1));
        }

        input_user.sort((a, b) -> {
            int bulanx = pair_month_index.get(a.bulan.toLowerCase());
            int bulany = pair_month_index.get(b.bulan.toLowerCase());
            return Integer.compare(bulanx, bulany);
        });
        
        for (Pair p : input_user){
            stack_hasil.push(p.nama);
            stack_hasil.push(p.bulan);
        }

        String[] hasil = new String[stack_hasil.size()];
        for (int i = stack_hasil.size() - 1; i >= 0; i--){
            hasil[i] = stack_hasil.pop();
        }

        System.out.println(Arrays.toString(hasil));
    }
}
