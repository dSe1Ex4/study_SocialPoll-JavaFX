package stdy.socialPoll.registry;

import stdy.socialPoll.gateways.PersonGateway;
import stdy.socialPoll.gateways.RelationGateway;

public class RegGatways {
    public static PersonGateway personGateway = new PersonGateway();
    public static RelationGateway relationGateway = new RelationGateway();
}
