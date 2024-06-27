package ProiectSMA;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class ManagerSistem extends Agent {

	protected void setup() {
		System.out.println("Agentul Manager de Sistem " + getAID().getName() + " este activ.");

		addBehaviour(new CyclicBehaviour(this) {
			public void action() {
				MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
				ACLMessage msg = receive(mt);
				if (msg != null) {
					String content = msg.getContent();
					System.out.println(
							"ManagerSistem a primit o cerere de la " + msg.getSender().getName() + ": " + content);

					ACLMessage reply = new ACLMessage(ACLMessage.REQUEST);
					reply.addReceiver(getAID("AgentLivrare1"));
					reply.setContent(content);
					send(reply);
				} else {
					block();
				}
			}
		});
	}

	protected void takeDown() {
		System.out.println("Agentul ManagerSistem" + getAID().getName() + " si-a terminat executia.");
	}
}
