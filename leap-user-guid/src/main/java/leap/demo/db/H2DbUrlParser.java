package leap.demo.db;

import leap.core.AppPropertyProcessor;
import leap.lang.Out;
import leap.lang.Strings;

public class H2DbUrlParser implements AppPropertyProcessor {
	private static final String PLCAE_HOLDER = "classpath:/";
	private static final String PROPERTY_NAME = "h2.jdbcUrl";
	@Override
	public boolean process(String name, String value, Out<String> newValue) {
		/*if(Strings.equals(name, PROPERTY_NAME)){
			String classPath = H2DbUrlParser.class.getResource("/").getPath();
			value = Strings.replace(value, PLCAE_HOLDER, classPath);
			newValue.set(value);
			return true;
		}*/
		return false;
	}

}
