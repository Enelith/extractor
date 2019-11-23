package extractor.model.core;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import extractor.utils.ExtractorProperties;

/**
 * @author jvinh
 */
public abstract class BaseModel {
    protected static final Logger logger = (Logger) LoggerFactory.getLogger(BaseModel.class);

    protected boolean fullDisplayMode = false;
    protected Properties properties;

    protected BaseModel() {
	if (properties == null) {
	    properties = ExtractorProperties.load();
	}
    }
    
    protected void logging(String msg) {
	if(fullDisplayMode) {
	    logger.info(msg);
	}
	else {
	    logger.debug(msg);
	}
    }
    
    /**
     * @return the test mode
     */
    public boolean isFullDisplayMode() {
	return fullDisplayMode;
    }
    
    /**
     * @param fullDisplayMode the test mode to set
     */
    public void setFullDisplayModel(boolean fullDisplayMode) {
	this.fullDisplayMode = fullDisplayMode;
    }
}
