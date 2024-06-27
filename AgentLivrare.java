package ProiectSMA;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class AgentLivrare extends Agent {

	protected void setup() {
		System.out.println("AgentLivrare " + getAID().getName() + " este activ.");

		addBehaviour(new CyclicBehaviour(this) {
			public void action() {
				MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
				ACLMessage msg = receive(mt);
				if (msg != null) {
					String content = msg.getContent();
					System.out.println("AgentLivrare " + getAID().getName() + " a primit o cerere de la ManagerSistem: "
							+ content);

					ACLMessage request = new ACLMessage(ACLMessage.REQUEST);
					request.addReceiver(getAID("AgentLocatie1"));
					request.setContent("Mesajul trimis este " + content);
					send(request);
				} else {
					block();
				}
			}
		});
	}

	protected void takeDown() {
		System.out.println("Agentul de Livrare " + getAID().getName() + " si-a terminat executia.");
	}
}
