package presentation;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// Cette annotation indique que cette classe sert de fichier de configuration pour Spring

@ComponentScan(basePackages = {"dao", "metier"})
// Spring va parcourir les packages "dao" et "metier" afin de détecter automatiquement les composants (beans)

public class Presentation2 {

    public static void main(String[] args) {

        // Initialisation du conteneur Spring en utilisant une configuration basée sur les annotations
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Presentation2.class);

        // Récupération de l'objet métier géré par Spring depuis le conteneur
        IMetier metier = context.getBean(IMetier.class);

        // Appel de la méthode calcul() de la couche métier
        // puis affichage du résultat dans la console
        System.out.println("Résultat = " + metier.calcul());
    }
}
