# Balanced strings

A string containing grouping symbols `{}[]()` is said to be balanced if every open symbol `{[(` has a matching closed symbol `]}` and the substrings before, after and between each pair of symbols is also balanced. The empty string is considered as balanced.

For example: `{[][]}({})` is balanced, while `][`, `([)]`, `{`, `{(}{}` are not.

Implement the following method:

```java
public static boolean isBalanced(String str) {
    ...
}
```

`isBalanced` returns `true` if `str` is balanced according to the rules explained above. Otherwise, it returns `false`.

Use the coverage criteria studied in classes as follows:

1. Use input space partitioning to design an initial set of inputs. Explain below the characteristics and partition blocks you identified.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written so far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Write below the actions you took on each step and the results you obtained.
Use the project in [tp3-balanced-strings](../code/tp3-balanced-strings) to complete this exercise.

## Answer

1) Plusieurs critères sont à considérer
   - un bloc où la chaine de caractère à des valeurs particulières, notamment
     - chaine vide (doit être accepté)
     - chaine null (doit être refusé)
   - un bloc avec des chaines valides
     - soit des chaines simples `() []`
     - ou des chaines imbriquées `(({[]}))`
     - les caractères autres que les parenthèses doivent être ignorés`(({z[]f})e)`
   - enfin, un bloc avec des chaines non valides
     - commençant par exemple par une parenthèse fermante `))[()]`
2) 3 méthodes tests ont été utilisés, une pour chaque bloc identifié, ce qui a permis de couvrir 100% du code.

4. En exécutant les tests avec PIT, on obtient le résultat suivant

   ```
   ================================================================================
   - Statistics
   ================================================================================
   >> Line Coverage: 18/20 (90%)
   >> Generated 20 mutations Killed 17 (85%)
   >> Mutations with no coverage 2. Test strength 94%
   >> Ran 20 tests (1 tests per mutation)
   ```
