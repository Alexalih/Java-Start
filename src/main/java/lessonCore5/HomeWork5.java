package lessonCore5;

import java.io.File;
import java.util.Arrays;

public class HomeWork5 {
    public static void main(String[] args) {

        AppData appData = new AppData();
        appData.setHeader(new String[]{"Value 1", "Value 2", "Value 3"});
        appData.setData(new Integer[][] {{100, 200, 123}, {300, 400, 500}});

        File file1 = new File("src/main/resources/test1.csv");
        appData.save(file1);
        File file2 = new File("src/main/resources/test2.csv");
        appData.load(file2);

        System.out.println(Arrays.toString(appData.getHeader()));
        for (Integer[] arr : appData.getData()) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
