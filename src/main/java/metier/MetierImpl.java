package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// Indique à Spring que cette classe est un composant géré par le conteneur IoC
@Component("metier")
public class MetierImpl implements IMetier {

    // Injection automatique de la dépendance DAO par Spring
    @Autowired

    // Permet de préciser quelle implémentation de l'interface IDao doit être utilisée
    // (utile lorsqu'il existe plusieurs classes DAO)
    @Qualifier("dao2")
    private IDao dao;

    @Override
    public double calcul() {
        // Utilise la méthode getValue() fournie par la couche DAO
        // puis applique un traitement simple (multiplication par 2)
        return dao.getValue() * 2;
    }

    // Méthode setter permettant d'injecter manuellement l'objet DAO si nécessaire
    // (par exemple dans un test ou avec une autre configuration)
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}