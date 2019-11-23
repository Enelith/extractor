package extractor.model.core;

import java.lang.reflect.Field;

import org.apache.commons.lang3.StringUtils;

import extractor.model.core.interfaces.IComponentModel;
import extractor.utils.ExtractorUtils;

/**
 * @author jvinh
 */
public abstract class ComponentModel extends BaseModel implements IComponentModel {
    private static final String LOGGER_HEADER = "[" + ComponentModel.class.getName() + "] ";

    public ComponentModel() {
	super();
    }

    /**
     * @return la String représentative d'un ExtractorComponent
     */
    public String generateParticle(String fatherClass) {
	String methodName = new Object() {
	}.getClass().getEnclosingMethod().getName();

	logging(LOGGER_HEADER + " call for " + methodName);

	String result = "";

	String sFieldLength = null;
	Integer fieldLength = 0;
	String fieldValue = null;

	for (Field f : this.getClass().getDeclaredFields()) {
	    f.setAccessible(true);

	    fieldValue = null;

	    sFieldLength = properties.getProperty(fatherClass + "." + f.getName());
	    fieldLength = Math.max(0,
			!ExtractorUtils.isEmpty(sFieldLength)
				    ? Integer.parseInt(sFieldLength)
				    : -1);

	    if (fieldLength > 0) {
		try {
		    // Récupérer la valeur du champs;
		    fieldValue = (String) f.get(this);
		    fieldValue = (!ExtractorUtils.isEmpty(fieldValue)
				? fieldValue
				: "");

		    String lpadFiller = properties.getProperty(fatherClass + "." + f.getName() + "." + "lpad.filler");
		    String rpadFiller = properties.getProperty(fatherClass + "." + f.getName() + "." + "rpad.filler");

		    if (!ExtractorUtils.isEmpty(lpadFiller)) {
			fieldValue = StringUtils.leftPad(fieldValue, fieldLength, lpadFiller);
		    } else {
			fieldValue = StringUtils.rightPad(fieldValue,
				    fieldLength,
				    (!ExtractorUtils.isEmpty(rpadFiller)
						? rpadFiller
						: ""));
		    }

		    // Limiter la taille valeur du champs à la fieldLength settée
		    fieldValue = fieldValue.substring(0, fieldLength);

		    if (fullDisplayMode) {
			result += (!ExtractorUtils.isEmpty(result)
				    ? "|"
				    : "") + fieldValue;
		    } else {

			result += fieldValue;
		    }
		} catch (IllegalArgumentException e) {
		    logger.error(LOGGER_HEADER + "(IllegalArgumentException) " + methodName + " : " + e.getMessage());
		} catch (IllegalAccessException e) {
		    logger.error(LOGGER_HEADER + "(IllegalAccessException) " + methodName + " : " + e.getMessage());
		}
	    }
	}

	logging(LOGGER_HEADER + "Class " + this.getClass().getName() + " value = {" + result + "}" + (fullDisplayMode
		    ? " (Debug mode activated : remove \"|\" for real value)"
		    : ""));

	return result;
    }
}