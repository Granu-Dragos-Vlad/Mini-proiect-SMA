package ProiectSMA;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

public class Main {

	public static void main(String[] args) {
		jade.core.Runtime rt = jade.core.Runtime.instance();
		Profile p = new ProfileImpl();
		p.setParameter(Profile.MAIN_HOST, "localhost");
		AgentContainer container = rt.createMainContainer(p);

		try {
			AgentController managerController = container.createNewAgent("ManagerSistem", ManagerSistem.class.getName(),
					new Object[0]);
			managerController.start();

			AgentController deliveryAgent1Controller = container.createNewAgent("AgentLivrare1",
					AgentLivrare.class.getName(), new Object[] {"haina"});
			deliveryAgent1Controller.start();

			AgentController deliveryAgent2Controller = container.createNewAgent("AgentLivrare2",
					AgentLivrare.class.getName(), new Object[0]);
			deliveryAgent2Controller.start();

			AgentController deliveryAgent3Controller = container.createNewAgent("AgentLivrare3",
					AgentLivrare.class.getName(), new Object[0]);
			deliveryAgent3Controller.start();

			AgentController locationAgent1Controller = container.createNewAgent("AgentLocatie1",
					AgentLocatie.class.getName(), new Object[0]);
			locationAgent1Controller.start();

			AgentController locationAgent2Controller = container.createNewAgent("AgentLocatie2",
					AgentLocatie.class.getName(), new Object[0]);
			locationAgent2Controller.start();

			AgentController communicationController = container.createNewAgent("AgentComunicare",
					AgentLocatie.class.getName(), new Object[0]);
			communicationController.start();

		} catch (StaleProxyException e) {
			e.printStackTrace();
		}
	}
}
