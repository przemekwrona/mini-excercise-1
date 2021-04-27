package pl.edu.pw.mini.wronadb.generator;

import java.util.List;
import java.util.Random;

public class NameGenerator {

    private static final List<String> names = List.of("Przemyslaw", "Jan", "Wiktor", "Rafał");

    public static String getRandomName() {
        return names.get(new Random().nextInt(names.size()));
    }
}
