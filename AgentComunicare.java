package ProiectSMA;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class AgentComunicare extends Agent {

	protected void setup() {
		System.out.println("AgentComunicare " + getAID().getName() + " este activ.");

		addBehaviour(new CyclicBehaviour(this) {
			public void action() {
				ACLMessage msg = receive();
				if (msg != null) {

					String senderName = msg.getSender().getName();
					String content = msg.getContent();
					System.out.println("AgentComunicare a primit un mesaj de la " + senderName + ": " + content);

					ACLMessage reply = msg.createReply();
					reply.setPerformative(ACLMessage.INFORM);
					reply.setContent("Am primit mesajul: " + content);
					send(reply);
				} else {
					block();
				}
			}
		});
	}

	protected void takeDown() {
		System.out.println("AgentComunicare " + getAID().getName() + " si-a terminat executia.");
	}
}
