package extractor.model.action.byreflection;

import extractor.model.component.COMPONENT_1;
import extractor.model.component.COMPONENT_3;
import extractor.model.core.ActionModel;

/**
 * @author jvinh
 */
public class Action_3 extends ActionModel {
    private COMPONENT_1 component_1;
    
    private COMPONENT_3 component_3;

    public Action_3() {
	super();
    }

    public Action_3(COMPONENT_1 component_1, COMPONENT_3 component_3) {
	super();
	this.component_1 = component_1;
	this.component_3 = component_3;
    }

    public COMPONENT_1 getComponent_1() {
        return component_1;
    }

    public void setComponent_1(COMPONENT_1 component_1) {
        this.component_1 = component_1;
    }

    public COMPONENT_3 getComponent_3() {
        return component_3;
    }

    public void setComponent_3(COMPONENT_3 component_3) {
        this.component_3 = component_3;
    }
}
