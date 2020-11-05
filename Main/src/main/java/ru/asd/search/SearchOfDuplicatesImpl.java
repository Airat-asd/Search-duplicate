package ru.asd.search;

import ru.asd.code.ConvertToMd5Impl;
import ru.asd.file.ListOfFiles;
import ru.asd.file.ReadFile;
import ru.asd.file.ReadFileImpl;

import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class SearchOfDuplicatesImpl implements SearchOfDuplicates {

    //Перекладываем все values из mapMd5 в лист и далее его сортируем
    @Override
    public List<Path> getListOfDuplicatesUsingSorted(Map<Path, String> mapMd5) {
        List<String> listMd5 = new ArrayList<>(mapMd5.values());
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
}
