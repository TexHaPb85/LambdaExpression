package HomeTask;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextFileWorker {

    public List<String> reatFile(File file){
        List<String> stringList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str = null;
            while((str = reader.readLine()) != null) {
                stringList.add(str);
            }

            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }


}
