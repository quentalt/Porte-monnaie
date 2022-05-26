import junit.monprojet.PorteMonnaie;
import junit.monprojet.SommeArgent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PorteMonnaieTest {

  @Test
  public void test() {
    PorteMonnaie pm = new PorteMonnaie();
    SommeArgent sa1 = new SommeArgent(5, "EUR");
    pm.ajouteSomme(sa1);
    //System.out.println(pm);
    SommeArgent sa2 = new SommeArgent(5, "EUR");
    pm.ajouteSomme(sa2);
    //System.out.println(pm);
    PorteMonnaie expected = new PorteMonnaie();
    SommeArgent laSommeTotale = new SommeArgent(10, "EUR");
    expected.ajouteSomme(laSommeTotale);
    Assertions.assertTrue(expected.equals(pm));
  }
}

