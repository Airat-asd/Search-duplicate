package ru.asd.data;

import ru.asd.search.PrintDuplicate;

import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class SearchOfDuplicatesImpl implements SearchOfDuplicates {

    @Override
    public List<Path> getListOfDuplicatesUsingHashMap(Map<Path, String> mapMd5) {
        List<Path> listOfDuplicateKey = new ArrayList<>();
        Map<String, Path> mapMd5NotDuplicate = new HashMap<>();
        mapMd5.forEach((k, v) -> mapMd5NotDuplicate.put(v, k));
        mapMd5NotDuplicate.forEach((k, v) -> mapMd5.remove(v));
        mapMd5.forEach((k, v) -> listOfDuplicateKey.add(k));
        return listOfDuplicateKey;
    }

    @Override
    //Проходим стримом по мапе, фильтруем элементы с помощью Set(если элемент в set уже есть,
    // то set.add возвращает false и получаем лист с дубликатами.
    public List<Path> getListOfDuplicatesUsingStream(Map<Path, String> mapMd5) {
        Set<String> set = new HashSet<>(mapMd5.size());
        List<String> listCodeDuplicate = mapMd5.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(e -> !set.add(e))
                .distinct()
                .collect(Collectors.toList());
        //Составляем лист с ссылками на дубликаты файлов
        List<Path> listPathDuplicate = new ArrayList<>(listCodeDuplicate.size());
        for (String duplicate : listCodeDuplicate) {
            int count = 0;
            for (Map.Entry<Path, String> entry : mapMd5.entrySet()) {
                if (entry.getValue().equals(duplicate)) {
                    count++;
                    if (count > 1) {
                        listPathDuplicate.add(entry.getKey());
                    }
                }
            }
        }
        return listPathDuplicate;
    }

    @Override
    public List<Path> getListOfDuplicatesUsingHashSet(Map<Path, String> mapMd5) {
        Set<String> set = new HashSet<>(mapMd5.size());
        List<Path> listPathOfDuplicate = new ArrayList<>();
        for (Map.Entry<Path, String> entry : mapMd5.entrySet()) {
            if (!set.add(entry.getValue())) {
                listPathOfDuplicate.add(entry.getKey());
            }
        }
        return listPathOfDuplicate;
    }

    @Override
    public List<Path> getListOfDuplicatesUsingSorted(Map<Path, String> mapMd5) {
        List<String> listMd5 = new LinkedList<String>(mapMd5.values());
        Set<String> listDuplicate = new HashSet<>();

        listMd5.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        String buffer = null;
        for (String element : listMd5) {
            if (element.equals(buffer)) {
                listDuplicate.add(element);
            }
            buffer = element;
        }
        List<Path> ListPathDuplicate = new ArrayList<>(listDuplicate.size());

        for (String duplicate : listDuplicate) {
            int count = 0;
            for (Map.Entry<Path, String> map : mapMd5.entrySet()) {
                if (map.getValue().equals(duplicate)) {
                    count++;
                    if (count > 1) {
                        ListPathDuplicate.add(map.getKey());
                    }
                }
            }
        }

        return ListPathDuplicate;
    }

    @Override
    public List<Path> getListOfDuplicatesBubbleMethod(Map<Path, String> mapMd5) {
        String bufferValueMd5;
        List<Path> listOfDuplicateKey = new ArrayList<>();
        int counterFirst = 0;
        int counterSecond;
        for (Map.Entry<Path, String> entryFirst : mapMd5.entrySet()) {
            bufferValueMd5 = entryFirst.getValue();
            counterFirst++;
            counterSecond = 0;
            for (Map.Entry<Path, String> entrySecond : mapMd5.entrySet()) {
                counterSecond++;
                if (counterSecond > counterFirst) {
                    if (entrySecond.getValue().equals(bufferValueMd5)) {
                        if (!entrySecond.getValue().equals("")) {
                            listOfDuplicateKey.add(entrySecond.getKey());
                            entrySecond.setValue("");
                        }
                    }
                }
            }

        }
        return listOfDuplicateKey;
    }
}
