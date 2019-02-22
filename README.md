## Database Systems Homework Directory
Hibernate:
```
IX. JPA
a. Stwórz nowego maina w którym zrobisz to samo co w punkcie VI ale z wykorzystaniem JPA
b. Udokumentuj wykonane kroki oraz uzyskane rezultaty  (logi wywołań sqlowych, describe table/diagram z datagrip, select * from....)

X. Kaskady
a. Zmodyfikuj model w taki sposób aby było możliwe kaskadowe tworzenie faktur wraz z nowymi produktami, oraz produktów wraz z nową fakturą
b. Udokumentuj wykonane kroki oraz uzyskane rezultaty (logi wywołań sqlowych, describe table/diagram z datagrip, select * from....)

XI. Embedded class
a. Dodaj do modelu klase adres. „Wbuduj” ją do tabeli Dostawców.
b. Udokumentuj wykonane kroki oraz uzyskane rezultaty (logi wywołań sqlowych, describe table/diagram z datagrip, select * from....)
c. Zmdyfikuj model w taki sposób, że dane adresowe znajdują się w klasie dostawców. Zmapuj to do dwóch osobnych tabel.
d. Udokumentuj wykonane kroki oraz uzyskane rezultaty  (logi wywołań sqlowych, describe table/diagram z datagrip, select * from....)

XII. Dziedziczenie
a. Wprowadź do modelu następującą hierarchie:
b. Dodaj i pobierz z bazy kilka firm obu rodzajów stosując po kolei trzy różne strategie mapowania dziedziczenia.
c. Udokumentuj wykonane kroki oraz uzyskane rezultaty (logi wywołań sqlowych, describe table/diagram z datagrip, select * from....)
```

MongoDB:
```
Na przykładzie zbioru  Jeopardy stwórz zapytania (należy przygotować sprawozdanie z kawałkami kodu i ich omówieniem oraz przedstawieniem ich rezultatu)

-jedno proste (ale np. z warunkami, sortowaniem itp),

-jedno z wykorzystaniem agregacji (dowolny sposób),

-jedno z wykorzystaniem mechanizmu map reduce.

Wspomniane zapytania należy zrobić na 2 sposoby - zapytania do użycia w konsoli mongo oraz z poziomu interfejsu programistycznego (można użyć Javy lub Pythona). Proszę w kodzie odwoływać się do bazy o nazwie "jeopardy", która zawiera zaimportowaną bazę Jeopardy (z kolekcją question). 

Rozwiązanie powinno zawierać sprawozdanie oraz projekt z kodem.
```

Neo4j:
```
3. Zaimplementować metody z klasy Solution
Dodatkowo:
4. Stworzyć dwa nowe węzły reprezentujące film oraz aktora, następnie stworzyć relacje ich łączącą
5. Ustawić zapytaniem pozostałe właściwości nowo dodanego węzła reprezentującego aktora
6. Zapytanie o aktorów którzy grali w conajmniej 6 filmach (użyć collect i length)
7. Policzyć średnią wystąpień w filmach dla grupy aktorów, którzy wystąpili w conajmniej 7 filmach
8. Wyświetlić aktorów, którzy zagrali w conajmniej pięciu filmach i wyreżyserowali conajmniej jeden film, posortować ich wg liczby wystąpień w filmach
9. Zapytanie o znajomych wybranego usera którzy ocenili film na conajmniej trzy gwiazdki 
10. Zapytanie o ścieżki między wybranymi aktorami, w ścieżkach mają nie znajdować się filmy
11. Porównać czas wykonania zapytania o wybranego aktora bez oraz z indeksem w bazie nałożonym na atrybut name, dokonać porównania dla zapytania shortestPath pomiędzy dwoma wybranymi aktorami.
Dowolność w wyborze języka wysokiego poziomu.
```
