import junit.monprojet.SommeArgent;
import junit.monprojet.UniteDistincteException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class SommeArgentTest {
  private SommeArgent m12CHF;
  private SommeArgent m14CHF;
  private static int beforeEach = 0;
  private static int afterEach = 0;


  @BeforeEach
  void TestByBeforeEach() {
    m12CHF = new SommeArgent(12, "CHF");
    System.out.println("Initialisation m12CHF");
    m14CHF = new SommeArgent(14, "CHF");
    System.out.println("Initialistation m14CHF");
    System.out.println(++beforeEach + " ième passage avant éxecution d'un méthode de test");
  }


  public boolean equals(Object anObject) {
    if (anObject == null) {
      return false;
    }
    if (anObject instanceof SommeArgent) {
      SommeArgent somme = (SommeArgent) anObject;
      return somme.getUnite().equals(somme.getUnite()) && somme.getQuantite() == somme.getQuantite();
    }
    return false;
  }

  @Test
  void testSomme() throws UniteDistincteException {
    SommeArgent expected = new SommeArgent(26, "CHF");
    SommeArgent result = m12CHF.add(m14CHF);
    Assertions.assertTrue(expected.equals(result));
    System.out.println("Test Somme");
  }

  @Test
  void testSomme2() throws UniteDistincteException {
    SommeArgent m14USD = new SommeArgent(14, "USD");
    SommeArgent expected = new SommeArgent(26, "CHF");
    SommeArgent result = m12CHF.add(m14CHF);
    Assertions.assertEquals(m12CHF, m12CHF);
    Assertions.assertEquals(m12CHF, new SommeArgent(12, "CHF"));
    Assertions.assertTrue(!m12CHF.equals(m14CHF));
    Assertions.assertTrue(!m14USD.equals(m14CHF));
    System.out.println("Test Somme 2");
  }

  @AfterEach
  void AfterEach() {
    System.out.println(++afterEach + " ime passage APRES éxecution d'un méthode de test");
  }


}


