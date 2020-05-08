package stdy.socialPoll.registry;

import stdy.socialPoll.gateways.PersonGateway;
import stdy.socialPoll.gateways.QuestionGateway;
import stdy.socialPoll.gateways.RelationGateway;

public class RegGateways {
    public static PersonGateway personGateway = new PersonGateway();
    public static RelationGateway relationGateway = new RelationGateway();
    public static QuestionGateway questionGateway = new QuestionGateway();
}
