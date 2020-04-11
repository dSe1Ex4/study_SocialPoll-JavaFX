package stdy.socialPoll.gateways;

import stdy.socialPoll.models.Person;
import stdy.socialPoll.models.Relation;

public class RelationGateway extends GatewayDefault<Relation> {
    public RelationGateway() {
        insert(new Relation(1, new Person(1, "Gaga", "Baba", "Obob"),
                new Person(2, "Gaga2", "Baba2", "Obob2"), 1));
        insert(new Relation(2, new Person(3, "Gaga3", "Baba3", "Obob3"),
                new Person(4, "Gaga4", "Baba4", "Obob4"), 1));
    }
}