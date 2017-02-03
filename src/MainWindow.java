import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by Rene on 03/02/2017.
 */
public class MainWindow {

    MainWindowVM vm;

    ArrayList<Button> buttons;
    ArrayList<Text> texts;
    Text kokkuValue;
    Text popValue;

    public MainWindow(Stage primaryStage) {
        vm = new MainWindowVM();

        GridPane grid = new GridPane();

        buttons = new ArrayList<Button>();
        texts = new ArrayList<Text>();

        for (int i = 0; i < 4; i++) {
            Soitja s = new Soitja(vm.suunad[i], 0);
            vm.soitjad.add(i, s);

            Button btn = new Button(vm.suunad[i]);
            buttons.add(i, btn);
            listenToClick(i);
            grid.add(btn,0,i);

            Text txt = new Text();
            texts.add(i, txt);
            grid.add(txt,1,i);
        }

        Text kokku = new Text("Kokku");
        grid.add(kokku,0,vm.soitjad.size()+1);
        kokkuValue = new Text();
        grid.add(kokkuValue,1,vm.soitjad.size()+1);

        Text pop = new Text("Populaarseim");
        grid.add(pop,0,vm.soitjad.size()+2);
        popValue = new Text();
        grid.add(popValue,1,vm.soitjad.size()+2);

        Scene scene = new Scene(grid, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void createView(Stage primaryStage) {

    }



    public void listenToClick(int i) {
        buttons.get(i).setOnAction((event) -> {
            Soitja s = vm.soitjad.get(i);
            s.incrementHulk();
            texts.get(i).setText(Integer.toString(s.getHulk()));
            kokkuValue.setText(Integer.toString(vm.getSUM()));
            popValue.setText(vm.getPop());

        });
    }




}
