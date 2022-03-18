# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1) assertTrue(3 * .4 == 1.2) renvoie false. Le problème vient de la façon dont sont représentés les nombres réels en informatiques. En effet, on a un nombre de bits qui est limité, or les nombres à virgules peuvent potentiellement être très grands ce qui peut poser des problèmes en termes de stockage. C'est pour cela qu'on utilise la norme **IEEE 754** pour représenter les nombres réels.

   L'idée derrière cette norme est de représenter les nombres sous forme de virgule flottante sur 32 ou 64 bits en les divisant en 3 éléments : le **signe**, l'**exposant** et la **mantisse**. Le nombre résultant peut donc être une approximation du nombre réel.

   Pour tester ce genre d'égalité, on peut par exemple utiliser assertEquals et ajouter un troisième paramètre à l'assertion :

   ```
   assertTrue(3 * .4, 1.2, 0.00001);
   ```

   Ainsi, cette assertion vérifie si les deux nombre flottants sont égaux à l'intérieur d'un delta positif.

2) `assertEquals` utilise la méthode  la méthode `equals` de l'objet pour établir une comparaison alors que `assertSame` utilise l'opérateur `==`. 

   - Scénario où assertEquals et assertSame donnent le même résultat

   ```java
   @Test
   public void example() {
       String value1 = "ok";
       String value2 = "ok";
       
       assertEquals(value1, value2); // renvoie true
       assertSame(value1, value2); // renvoie true
   }
   ```

   - Scénario où assertEquals et assertSame ne donnent pas le même résultat

   ```java
   @Getter
   class Example {
       private String value;
       
       public example(String value) {
           this.value = value;
       }
       
       @Override
       public boolean equals(Object o) {
           if (o == this) {
               return true;
           }
           if (!(o instanceof Example)) {
               return false;
           }
           Example e = (Example) o;
           return e.getValue.equals(this.getValue);
       }
   }
   ```

   ```java
   @Test
   public void example() {
       Example e1 = new Example("test");
       Example e2 = new Example("test");
       
       assertEquals(value1, value2); // renvoie true
       assertSame(value1, value2); // renvoie false
   }
   ```

3) L'assertion `fail` peut aussi être utilisé pour vérifier si le résultat respecte les contraintes attendues.

   ```java
   @Test
   public void testFail() {
       int result = randomInteger();
       if(result > Integer.MAX_VALUE) {
           fail("Result cannot exceed integer max value");
       }
   }
   ```

4) L'avantage de la méthode `assertThrows` par rapport à l'utilisation de `@Test(expected = Exception.class) `  est que `assertThrows` nous permet de détailler l'exception. Par exemple, on peut vérifier si l'exception levée renvoie le bon message.

   ```java
   @Test
   public void whenExceptionThrown_thenAssertionSucceeds() {
       Exception exception = assertThrows(NumberFormatException.class, () -> {
           Integer.parseInt("1a");
       });
   
       String expectedMessage = "For input string";
       String actualMessage = exception.getMessage();
   
       assertTrue(actualMessage.contains(expectedMessage));
   }
   ```

   source [ici](https://www.baeldung.com/junit-assert-exception).
