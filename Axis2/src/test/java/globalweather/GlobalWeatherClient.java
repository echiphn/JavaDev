package globalweather;

import java.util.List;

import globalweather.GlobalWeatherStub.GetWeather;
import globalweather.GlobalWeatherStub.GetWeatherResponse;

import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.ConfigurationContextFactory;
import org.apache.axis2.engine.Phase;

import axis2.handler.SimpleHandler;

public class GlobalWeatherClient {
	public static void main(String[] args) throws Exception {
		ConfigurationContext configurationContext = ConfigurationContextFactory
				.createConfigurationContextFromFileSystem(
						"/home/cle/work/workspace/JavaDev/Axis2/src/main/resources",
						null);
		// createConfigurationContextFromFileSystem(null, null);
		// createBasicConfigurationContext("axis2.xml");
		// List<Phase> outPhases =
		// configurationContext.getAxisConfiguration().getPhasesInfo().getOUTPhases();
		// //getOutFlowPhases();
		// for(Phase phase:outPhases){
		// ""phase.getPhaseName()
		// }
		// Phase firstPhase = outPhases.get(0);
		// System.out.println("first phase name "+firstPhase.getPhaseName());
		// firstPhase.addHandler(new SimpleHandler());
		GlobalWeatherStub stub = new GlobalWeatherStub(configurationContext);

		GetWeather getWeather = new GetWeather();
		getWeather.setCityName("Bermuda");
		getWeather.setCountryName("Bermuda");
		GetWeatherResponse response = stub.getWeather(getWeather);
		System.out.println(response.getGetWeatherResult());
	}
}
