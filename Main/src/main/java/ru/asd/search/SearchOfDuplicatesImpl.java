package ru.asd.search;

import ru.asd.data.PathAndMd5;

import java.nio.file.Path;
import java.util.*;

public class SearchOfDuplicatesImpl implements SearchOfDuplicates {

     @Override
    public List<Path> getListOfDuplicatesUsingSorted(List<PathAndMd5> listMd5) {
        List<Path> listPathDuplicate = new ArrayList<>();
        String bufferMd5 = null;
        for (int i = 0; i < listMd5.size(); i++) {
            if (listMd5.get(i).getMd5().equals(bufferMd5)) {
                listPathDuplicate.add(listMd5.get(i).getPath());
            }
            bufferMd5 = listMd5.get(i).getMd5();
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
}
