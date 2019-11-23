package extractor.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.axis.utils.StringUtils;
import org.apache.commons.collections4.CollectionUtils;

/**
 * @author jvinh
 */
public class ExtractorUtils {
    private static final String DATE_PATTERN = "yyyyMMdd";

    /**
     * @param  <T> class générique
     * @param  t   type générique
     * @return     si le parametre est null ou empty
     */
    public static <T> boolean isEmpty(T t) {
	if (t instanceof String) {
	    return StringUtils.isEmpty((String) t);
	} else if (t instanceof List<?>) {
	    return CollectionUtils.isEmpty((Collection<?>) t);
	} else {
	    return t == null;
	}
    }
    
    public static String dateConvertor(Date dateToConvert) {
	DateFormat f = new SimpleDateFormat(DATE_PATTERN);
	
	return (!isEmpty(dateToConvert) ? f.format(dateToConvert) : "");
    }
}