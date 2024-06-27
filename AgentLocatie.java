package ProiectSMA;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class AgentLocatie extends Agent {

	protected void setup() {
		System.out.println("AgentLocatie " + getAID().getName() + " este activ.");

		addBehaviour(new CyclicBehaviour(this) {
			public void action() {
				MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
				ACLMessage msg = receive(mt);
				if (msg != null) {
					
					String content = msg.getContent();
					System.out.println("AgentLocatie " + getAID().getName() + " a primit o cerere: " + content);

					
					ACLMessage reply = msg.createReply();
					reply.setPerformative(ACLMessage.INFORM);
					reply.setContent("Mesajul trimis este " + content);
					send(reply);
				} else {
					block();
				}
			}
		});
	}

	protected void takeDown() {
		System.out.println("AgentLocatie " + getAID().getName() + " si-a terminat executia.");
	}
}
