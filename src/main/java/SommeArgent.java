import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

public class SommeArgent {
  private int quantite;
  private String unite;

  public SommeArgent(int amount, String currency) {
    quantite = amount;
    unite = currency;
  }

  public int getQuantite() {
    return quantite;
  }

  public String getUnite() {
    return unite;
  }

  public SommeArgent add(SommeArgent m) {
    return new SommeArgent(getQuantite() + m.getQuantite(), getUnite());
  }

  public boolean equals(Object anObject) {
    if(anObject == null) {
      return false;
    }
    if(anObject instanceof SommeArgent) {
      SommeArgent somme = (SommeArgent)anObject;
      return somme.getUnite().equals(getUnite()) && getQuantite() == somme.getQuantite();
    }
    return false;
  }

  public static void main(String[] args) {
    SommeArgent m12CHF = new SommeArgent(12, "CHF");
    SommeArgent m14CHF = new SommeArgent(14, "CHF");
    SommeArgent expected = new SommeArgent(26, "CHF");
    SommeArgent result = m12CHF.add(m14CHF);
    Assertions.assertTrue(expected.equals(result));
  }
}
