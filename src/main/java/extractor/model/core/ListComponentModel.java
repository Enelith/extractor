package extractor.model.core;

import java.util.ArrayList;

import extractor.model.core.interfaces.IComponentModel;

/**
 * @author jvinh
 */
public abstract class ListComponentModel extends ArrayList<IComponentModel> implements IComponentModel {
    /**
     * 
     */
    private static final long serialVersionUID = 4418510362048703906L;

    @Override
    public String generateParticle(String fatherClass) {
	StringBuilder sBuilder = new StringBuilder();
	
	for(IComponentModel iComponentModel : this) {
	    sBuilder.append(iComponentModel.generateParticle(iComponentModel.getClass().getSimpleName()));
	}
	
	return sBuilder.toString();
    }
}
