package extractor.model.core;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import extractor.exception.RuleException;
import extractor.exception.ValidationErrorException;
import extractor.model.core.interfaces.IComponentModel;
import extractor.utils.ExtractorUtils;
import extractor.utils.ExtractorValidator;

/**
 * @author jvinh
 */
public abstract class ActionModel extends BaseModel {
    private static final String LOGGER_HEADER = "[" + ActionModel.class.getName() + "] ";

    private static final String VALIDATOR_QUERY_SEPARATOR = "validator.query.separator";

    public ActionModel() {
	super();
    }

    /**
     * Parcours chaque propriété d'un objet ActionModel, puis génère un tableau de
     * String regroupant chaque sous détails de ses propriétés
     * 
     * @return un tableau de String représentant l'action
     */
    public List<String> generateAction_Composite() {
	logging(LOGGER_HEADER + " call for " + new Object() {
	}.getClass().getEnclosingMethod().getName());

	List<String> result = new ArrayList<>();

	for (Field f : this.getClass().getDeclaredFields()) {
	    f.setAccessible(true);

	    logging(LOGGER_HEADER + "Field : " + f.getName() + " => Field type : " + f.getType());

	    try {
		// obtain the field value from the object instance
		Object fieldValue = f.get(this);

		String rowValue = exploreComponent(f.getType(), fieldValue);
		
		result.add(rowValue);
	    } catch (IllegalAccessException e) {
		logger.error(LOGGER_HEADER + "(IllegalAccessException) : " + e.getMessage());
	    }
	}

	return result;
    }

    /**
     * Parcours chaque propriété d'un objet ActionModel, puis génère un tableau de
     * String regroupant chaque sous détails de ses propriétés
     * 
     * @return un tableau de String représentant l'action
     */
    @SuppressWarnings("unchecked")
    public List<String> generateAction_Reflection() {
	logging(LOGGER_HEADER + " call for " + new Object() {
	}.getClass().getEnclosingMethod().getName());

	List<String> result = new ArrayList<>();

	for (Field f : this.getClass().getDeclaredFields()) {
	    f.setAccessible(true);

	    logging(LOGGER_HEADER + "Field : " + f.getName() + " => Field type : " + f.getType());

	    try {
		// obtain the field value from the object instance
		Object fieldValue = f.get(this);

		if (Collection.class.isAssignableFrom(f.getType())
			    && fieldValue != null) {
		    for (Object o : (Collection<Object>) fieldValue) {
			result.add(exploreComponent(o.getClass(), o));
		    }
		} else {
		    result.add(exploreComponent(f.getType(), fieldValue));
		}
	    } catch (IllegalAccessException e) {
		logger.error(LOGGER_HEADER + "(IllegalAccessException) : " + e.getMessage());
	    }
	}

	return result;
    }

    /**
     * Appelle la méthode "generateParticle" d'un objet de type ComponentModel
     * 
     * @param targetClass the target class object
     * @param fieldInstance     the instance of the field from the object instance
     */
    private String exploreComponent(Class<?> targetClass, Object fieldInstance) {
	String methodName = new Object() {
	}.getClass().getEnclosingMethod().getName();

	String result = "";

	if (fieldInstance != null) {
	    try {
		Method myMethod = targetClass.getMethod("generateParticle", String.class);

		// invoke method on the instance of the field from your object instance
		result = (String) myMethod.invoke(fieldInstance, targetClass.getSimpleName());
	    } catch (IllegalAccessException e) {
		logger.error(LOGGER_HEADER + "(IllegalAccessException) " + methodName + " : " + e.getMessage());
	    } catch (InvocationTargetException e) {
		logger.error(LOGGER_HEADER + "(InvocationTargetException) " + methodName + " : " + e.getMessage());
	    } catch (NoSuchMethodException e) {
		logger.error(LOGGER_HEADER + "(NoSuchMethodException) " + methodName + " : " + e.getMessage());
	    }
	}

	return result;
    }

    public void validate() throws ValidationErrorException {
	logging(LOGGER_HEADER + " call for " + new Object() {
	}.getClass().getEnclosingMethod().getName());

	String stackError = "";

	String validatorQuerySeparator = properties.getProperty(VALIDATOR_QUERY_SEPARATOR);
	String[] validatorArray;

	String validatorRequest = "";
	String validatorQuery = "";
	for (Field f : this.getClass().getDeclaredFields()) {
	    f.setAccessible(true);

	    try {
		Object fieldValue = f.get(this);

		validatorRequest = this.getClass().getSimpleName() + "." + f.getName();
		validatorQuery = properties.getProperty(validatorRequest);
		logging(LOGGER_HEADER + "Validator : " + validatorRequest + " => " + validatorQuery);

		if (!ExtractorUtils.isEmpty(validatorQuery)) {
		    validatorArray = validatorQuery.split(validatorQuerySeparator);

		    for (String q : validatorArray) {
			if (!ExtractorUtils.isEmpty(q)) {
			    /**
			     * q possible values = notNull, aSize-X, aSize-X-Y
			     */
			    try {
				ExtractorValidator.process(q, f, fieldValue);
			    } catch (RuleException e) {
				logger.error(LOGGER_HEADER + "(RuleException) " + e.getMessage());
				stackError += (!ExtractorUtils.isEmpty(stackError)
					    ? " ; "
					    : "") + e.getMessage();
			    }
			}
		    }
		}
	    } catch (IllegalAccessException e) {
		logger.error(LOGGER_HEADER + "(IllegalAccessException) " + e.getMessage());
	    }
	}

	if (!ExtractorUtils.isEmpty(stackError)) {
	    throw new ValidationErrorException(
			LOGGER_HEADER + "(ValidationErrorException) " + this.getClass().getSimpleName()
					       + " validation recapitulatif : " + stackError);
	}
    }

    public String getCodeAction() {
	return properties.getProperty(this.getClass().getSimpleName() + "." + "codeAction");
    }

    public String getCodeReference() {
	return properties.getProperty(this.getClass().getSimpleName() + "." + "codeReference");
    }
}