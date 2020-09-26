package ru.asd.data;

import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class SearchOfDuplicatesImpl implements SearchOfDuplicates {

    @Override
    //Использую свойство Map перезаписывать ячейки при добавлении значений с одинаковым ключём, тем самым получаем Map
    //без дублей.
    public List<Path> getListOfDuplicatesUsingHashMap(Map<Path, String> mapMd5) {
        List<Path> listOfDuplicateKey = new ArrayList<>();
        Map<String, Path> mapMd5NotDuplicate = new HashMap<>();
        mapMd5.forEach((k, v) -> mapMd5NotDuplicate.put(v, k));
        //Удаляем из mapMd5 все уникальные значения, в итоге остаются только дубли
        mapMd5NotDuplicate.forEach((k, v) -> mapMd5.remove(v));
        mapMd5.forEach((k, v) -> listOfDuplicateKey.add(k));
        return listOfDuplicateKey;
    }

    @Override
    //Проходим стримом по мапе, фильтруем элементы с помощью Set(если элемент в set уже есть,
    // то set.add возвращает false) получаем лист с дубликатами.
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
    //Проходим foreach по мапе И с помощью Set(если элемент в set уже есть,
    // то set.add возвращает false) получаем лист с дубликатами.
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
    //Перекладываем все values из mapMd5 в лист и далее его сортируем
    @Override
    public List<Path> getListOfDuplicatesUsingSorted(Map<Path, String> mapMd5) {
        List<String> listMd5 = new LinkedList<>(mapMd5.values());
        Set<String> listDuplicate = new HashSet<>();

        listMd5.sort(String::compareTo);
        //Ищем одинаковые значения, расположенные друг за другом и складываем их в listDuplicate
        String buffer = null;
        for (String element : listMd5) {
            if (element.equals(buffer)) {
                listDuplicate.add(element);
            }
            buffer = element;
        }
        List<Path> ListPathDuplicate = new ArrayList<>(listDuplicate.size());
        //Используя listDuplicate с хэшкодами Md5, собираем лист с ссылками на дубли
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
    //Используя принцип алгоритма сортировки пузырьком ищем повторяющиеся хэшкоды Md5
    public List<Path> getListOfDuplicatesBubbleMethod(Map<Path, String> mapMd5) {
        List<Path> listOfDuplicateKey = new ArrayList<>();
        int counterFirst = 0;
        int counterSecond;
        for (Map.Entry<Path, String> entryFirst : mapMd5.entrySet()) {
            counterFirst++;
            counterSecond = 0;
            for (Map.Entry<Path, String> entrySecond : mapMd5.entrySet()) {
                counterSecond++;
                if (counterSecond > counterFirst) {
                    if (entrySecond.getValue().equals(entryFirst.getValue())) {
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
