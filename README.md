# Search-duplicate

В пакете "search" представлены классы для поиска дубликатов файлов в вашей файловой системе И дальнейшего их удаления.
В результате анализа результатов JMH теста делаю вывод что более оптимальные алгоритмы поиска дубликатов файлов 
расположены в классах SearchDuplicatesUsingSet и DuplicatesUsingStreamByteArray. Оба эти классы очень похожи 
и для поиска дублей используют структуру Set, где невозможно добавлять одинаковые значения.

Benchmark                                                    Mode  Score   Units
JMHTestSearch.SearchDuplicateUsingSortingByteArrayTest     - avgt   8,820  ms/op
JMHTestSearch.SearchDuplicateUsingSortingHEXTest           - avgt   26,902 ms/op
JMHTestSearch.SearchDuplicatesBySortingBubbleByteArrayTest - avgt   8,860  ms/op
JMHTestSearch.SearchDuplicatesBySortingBubbleHEXTest       - avgt   26,878 ms/op
JMHTestSearch.SearchDuplicatesUsingHashSetByteArrayTest    - avgt   9,742  ms/op
JMHTestSearch.SearchDuplicatesUsingHashSetHEXTest          - avgt   26,710 ms/op
JMHTestSearch.SearchDuplicatesUsingSetTest                 - avgt   8,562  ms/op
JMHTestSearch.SearchDuplicatesUsingStreamByteArrayTest     - avgt   8,566  ms/op
JMHTestSearch.SearchDuplicatesUsingStreamHEXTest           - avgt   26,676 ms/op
JMHTestSearch.SearchUsingHashMapByteArrayTest              - avgt   8,970  ms/op
JMHTestSearch.SearchUsingHashMapHEXTest                    - avgt   26,916 ms/op
