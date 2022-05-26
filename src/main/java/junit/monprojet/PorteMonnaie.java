package junit.monprojet;

import java.util.HashMap;
import java.util.Set;


public class PorteMonnaie {

  HashMap<String, Integer> contenu;

  public HashMap<String, Integer> getContenu() {
    return contenu;
  }

  public PorteMonnaie() {
    contenu = new HashMap<String, Integer>();
  }

  public void ajouteSomme(SommeArgent sa) {
    String laMonnaieDe_sa = sa.getUnite();
    Integer quantiteDansLaMonnaie = contenu.get(laMonnaieDe_sa);
    if (quantiteDansLaMonnaie == null) {
      contenu.put(laMonnaieDe_sa, sa.getQuantite());
    } else {
      Integer quantiteDejaDansLePorteMonnaie =
              contenu.get(laMonnaieDe_sa);
      Integer somme = quantiteDejaDansLePorteMonnaie +
              sa.getQuantite();
      contenu.put(laMonnaieDe_sa, somme);
    }
  }

  public String toString() {
    Set<String> lesCles = contenu.keySet();
    StringBuffer aAfficher = new StringBuffer("Contenu du porte monnaie: ");
    for (String uneCle : lesCles) {
      aAfficher.append(contenu.get(uneCle) + " " + uneCle);
    }
    return aAfficher.toString();
  }

  public boolean equals(Object anObject) {
    if (!(anObject instanceof PorteMonnaie)) return false;
    else {
      Set<String> lesCles = contenu.keySet();
      Set<String> lesClesDeAnObject =
              ((PorteMonnaie) anObject).getContenu().keySet();
      if (!lesCles.equals(lesClesDeAnObject)) return false;
      PorteMonnaie pm = (PorteMonnaie) anObject;
      for (String uneCle : lesCles) {
        if (contenu.get(uneCle).intValue() !=
                pm.getContenu().get(uneCle).intValue())
          return false;
      }
    }
    return true;
  }

}
