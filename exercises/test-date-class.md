# Test the Date class

Implement a class `Date` with the interface shown below:

```java
class Date implements Comparable<Date> {

    public Date(int day, int month, int year) { ... }

    public static boolean isValidDate(int day, int month, int year) { ... }

    public static boolean isLeapYear(int year) { ... }

    public Date nextDate() { ... }

    public Date previousDate { ... }

    public int compareTo(Date other) { ... }

}
```

The constructor throws an exception if the three given integers do not form a valid date.

`isValidDate` returns `true` if the three integers form a valid year, otherwise `false`.

`isLeapYear` says if the given integer is a leap year.

`nextDate` returns a new `Date` instance representing the date of the following day.

`previousDate` returns a new `Date` instance representing the date of the previous day.

`compareTo` follows the `Comparable` convention:

* `date.compareTo(other)` returns a positive integer if `date` is posterior to `other`
* `date.compareTo(other)` returns a negative integer if `date` is anterior to `other`
* `date.compareTo(other)` returns `0` if `date` and `other` represent the same date.
* the method throws a `NullPointerException` if `other` is `null` 

Design and implement a test suite for this `Date` class.
You may use the test cases discussed in classes as a starting point. 
Also, feel free to add any extra method you may need to the `Date` class.


Use the following steps to design the test suite:

1. With the help of *Input Space Partitioning* design a set of initial test inputs for each method. Write below the characteristics and blocks you identified for each method. Specify which characteristics are common to more than one method.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written to far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Use the project in [tp3-date](../code/tp3-date) to complete this exercise.

## Answer

1) Test `isLeapYear`

   - Entiers divisibles par 400
   - Entiers divisibles par 100 et non par 400
   - Entiers divisibles par 4 et non par 100 et 400
   - Entiers divisibles par aucun des nombre ci-dessus

   Test `getMonths(int year)`

   - année bissextile
   - année non bissextile

   Test `isValidDate`

   - Tester pour des valeurs de jour/mois/année négatives
   - Tester pour des valeurs qui ne respectent pas les contraintes (ex : mois > 12)
   - Tester pour des cas particuliers (29 février d'une année bissextile et d'une année non bissextile)

   Test `nextDate` / `previousDate`

   - Tester pour des dates où seul le jour suivant / précédent change
   - Tester pour des dates où jour et mois changent
   - Tester pour la date où l'année change (31/12)

   Test `CompareTo`

   - Tester pour une valeur de date null
   - Tester pour deux dates identiques
   - Tester pour une date donnée supérieur à la date courante
   - Test pour une date donnée inférieur à la date courrante

2) Les tests réalisés couvrent 85% des lignes de code de la classe

3) 

4) 

   ```
   ================================================================================
   - Statistics
   ================================================================================
   >> Line Coverage: 41/48 (85%)
   >> Generated 74 mutations Killed 60 (81%)
   >> Mutations with no coverage 6. Test strength 88%
   >> Ran 135 tests (1.82 tests per mutation)
   ```

   

