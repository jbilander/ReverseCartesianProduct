import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

public class Table {

    private final Map<Integer, TreeSet<Integer>> map = new HashMap<>();

    Table(int rowLength) {

        for (int i = 1; i <= rowLength; i++) {
            map.put(i, new TreeSet<>());
        }
    }

    public Map<Integer, TreeSet<Integer>> getMap() {
        return map;
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder("Table{");

        Iterator it = map.keySet().iterator();

        while (it.hasNext()) {
            int key = (int) it.next();
            result.append(key + "=" + map.get(key));
            if (it.hasNext()) {
                result.append(", ");
            }
        }

        result.append("}");

        return result.toString();
    }
}
