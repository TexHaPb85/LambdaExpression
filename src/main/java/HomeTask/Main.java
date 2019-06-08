package HomeTask;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        TextFileWorker textWorker = new TextFileWorker();
        textWorker.reatFile(new File("homeTask.txt"));
    }
}
