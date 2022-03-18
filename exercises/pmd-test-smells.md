# Detecting test smells with PMD

In folder [`pmd-documentation`](../pmd-documentation) you will find the documentation of a selection of PMD rules designed to catch test smells.
Identify which of the test smells discussed in classes are implemented by these rules.

Use one of the rules to detect a test smell in one of the following projects:

- [Apache Commons Collections](https://github.com/apache/commons-collections)
- [Apache Commons CLI](https://github.com/apache/commons-cli)
- [Apache Commons Math](https://github.com/apache/commons-math)
- [Apache Commons Lang](https://github.com/apache/commons-lang)

Discuss the test smell you found with the help of PMD and propose here an improvement.
Include the improved test code in this file.

## Answer

Parmis les tests vus en cours on peut citer

- DetachedTestCase.md
- JUnit4TestShouldUserTestAnnotation
- JUnit4TestShouldUserAfterAnnotation
- JUnit4TestShouldUserBeforeAnnotation
- JUnitSpelling

Prenons [ce repo](https://github.com/apache/commons-collections) et appliquons par exemple le `DetachedTestCase`.

PMD propose la suggestion suivante

```
/home/jessy/M2/VV/commons-collections/src/test/java/org/apache/commons/collections4/IterableUtilsTest.java:338:	DetachedTestCase:	Probable detached JUnit test case.
```

Elle indique qu'il manque l'annotation `@Test` dans le code ci-dessous

```java
public void getFromIterable() throws Exception {
	// Collection, entry exists
	final Bag<String> bag = new HashBag<>();
	bag.add("element", 1);
	assertEquals("element", IterableUtils.get(bag, 0));
}
```

En effet, l'annotation est manquante, il suffit de l'ajouter en haut de la méthode

```java
@Test
public void getFromIterable() throws Exception {
	// Collection, entry exists
	final Bag<String> bag = new HashBag<>();
	bag.add("element", 1);
	assertEquals("element", IterableUtils.get(bag, 0));
}
```

