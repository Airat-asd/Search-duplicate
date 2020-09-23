# Search-duplicate

В пакете "search" представлены классы для поиска дубликатов файлов в вашей файловой системе для дальнейшего их удаления.
В результате анализа результатов JMH теста делаю вывод что более оптимальные алгоритмы поиска дубликатов файлов 
расположены в классах SearchDuplicatesUsingSet и DuplicatesUsingStreamByteArray. Оба эти классы используют очень похожи 
и для поиска дублей структуру Set, где невозможно добавлять одинаковые значения.

Benchmark                                                   Mode  Cnt   Score   Error  Units
JMHTestSearch.SearchDuplicateUsingSortingByteArrayTest      avgt    5   8,820 � 0,438  ms/op
JMHTestSearch.SearchDuplicateUsingSortingHEXTest            avgt    5  26,902 � 1,552  ms/op
JMHTestSearch.SearchDuplicatesBySortingBubbleByteArrayTest  avgt    5   8,860 � 0,809  ms/op
JMHTestSearch.SearchDuplicatesBySortingBubbleHEXTest        avgt    5  26,878 � 0,540  ms/op
JMHTestSearch.SearchDuplicatesUsingHashSetByteArrayTest     avgt    5   9,742 � 3,796  ms/op
JMHTestSearch.SearchDuplicatesUsingHashSetHEXTest           avgt    5  26,710 � 1,368  ms/op
JMHTestSearch.SearchDuplicatesUsingSetTest                  avgt    5   8,562 � 0,632  ms/op
JMHTestSearch.SearchDuplicatesUsingStreamByteArrayTest      avgt    5   8,566 � 0,550  ms/op
JMHTestSearch.SearchDuplicatesUsingStreamHEXTest            avgt    5  26,676 � 0,857  ms/op
JMHTestSearch.SearchUsingHashMapByteArrayTest               avgt    5   8,970 � 0,467  ms/op
JMHTestSearch.SearchUsingHashMapHEXTest                     avgt    5  26,916 � 1,989  ms/op
