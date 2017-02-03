import java.util.ArrayList;

/**
 * Created by Rene on 03/02/2017.
 */
public class MainWindowVM {

    ArrayList<Soitja> soitjad;

    String[] suunad;

    public MainWindowVM() {
        soitjad = new ArrayList<Soitja>();
        suunad = new String[]{"Paldiski", "Tabasalu", "Mustamae", "Kesklinn"};
    }


    public int getSUM() {
        int s = 0;

        for (int i = 0; i < 4; i++) {
            s = s + soitjad.get(i).getHulk();
        }
        return s;
    }

    public String getPop() {
        String pop = "";
        int max = 0;

        for (int i = 0; i < 4; i++) {
            int k = soitjad.get(i).getHulk();

            if (k > max) {
                max = k;
                pop = soitjad.get(i).getSuund();
            }
        }

        return pop;
    }
}
