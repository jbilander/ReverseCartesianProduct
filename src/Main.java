import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<List<Integer>> data = List.of(List.of(1, 3, 7, 11), List.of(1, 5, 7, 11), List.of(1, 3, 8, 11), List.of(1, 5, 8, 11), List.of(1, 6, 8, 11));
        boolean done = false;
        int rowLength = data.get(0).size(); //4
        List<Table> tables = new ArrayList<>();

        // load data into table
        for (List<Integer> integerList : data) {

            Table table = new Table(rowLength);
            tables.add(table);

            for (int i = 0; i < integerList.size(); i++) {
                table.getMap().get(i + 1).add(integerList.get(i));
            }
        }

        // start algorithm
        while (!done) {

            Collection<List<Table>> result = getMinimumGroupByResult(tables, rowLength);

            if (result.size() < tables.size()) {

                tables.clear();

                for (List<Table> tableList : result) {

                    Table t = new Table(rowLength);
                    tables.add(t);

                    for (Table table : tableList) {
                        for (int i = 1; i <= rowLength; i++) {
                            t.getMap().get(i).addAll(table.getMap().get(i));
                        }
                    }
                }
            } else {
                done = true;
            }
        }

        tables.forEach(System.out::println);
    }

    private static Collection<List<Table>> getMinimumGroupByResult(List<Table> tables, int rowLength) {

        Collection<List<Table>> result = null;
        int min = Integer.MAX_VALUE;

        for (List<Integer> keyCombination : getKeyCombinations(rowLength)) {

            switch (rowLength) {

                case 4: {
                    Map<Tuple3<TreeSet<Integer>, TreeSet<Integer>, TreeSet<Integer>>, List<Table>> map =
                            tables.stream().collect(Collectors.groupingBy(t -> new Tuple3<>(
                                    t.getMap().get(keyCombination.get(0)),
                                    t.getMap().get(keyCombination.get(1)),
                                    t.getMap().get(keyCombination.get(2))
                            )));
                    if (map.size() < min) {
                        min = map.size();
                        result = map.values();
                    }
                }
                break;
                case 5: {
                    //TODO: Handle n = 5
                }
                break;
                case 6: {
                    //TODO: Handle n = 6
                }
                break;
            }
        }

        return result;
    }

    private static List<List<Integer>> getKeyCombinations(int rowLength) {

        switch (rowLength) {
            case 4:
                return List.of(List.of(1, 2, 3), List.of(1, 2, 4), List.of(2, 3, 4), List.of(1, 3, 4));

            //TODO: handle n = 5, n = 6, etc...
        }

        return List.of(List.of());
    }
}
