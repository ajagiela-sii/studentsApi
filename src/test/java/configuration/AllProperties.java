package configuration;
import configuration.models.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class AllProperties {
    static Logger logger = LoggerFactory.getLogger(AllProperties.class);
    private Api api;

    private AllProperties(){
        setApiProperties();
    }

    public static AllProperties getInstance() {
        return AllProperties.AllPropertiesSingleton.INSTANCE;
    }

    private void setApiProperties() {
        api = YamlReader.getConfig().getApi();
        Map<String, Object> apiProperties = api.getApiProperties();
        for (Map.Entry entry : apiProperties.entrySet()) {
            System.setProperty(entry.getKey().toString(), entry.getValue().toString());
            logger.info("Load env properties: {} = {}", entry.getKey().toString(), entry.getValue().toString());
        }
    }

    public static class AllPropertiesSingleton {
        private static final AllProperties INSTANCE = new AllProperties();
    }
}
