package extractor.model.action.byreflection;

import java.util.List;

import extractor.model.component.COMPONENT_1;
import extractor.model.component.COMPONENT_2;
import extractor.model.component.COMPONENT_3;
import extractor.model.core.ActionModel;

/**
 * @author jvinh
 */
public class Action_2 extends ActionModel {
    private COMPONENT_1 component_1;
    
    private COMPONENT_2 component_2;
    
    private List<COMPONENT_3> component_3_List;

    public Action_2() {
	super();
    }

    public Action_2(COMPONENT_1 component_1, COMPONENT_2 component_2, List<COMPONENT_3> component_3_List) {
	super();
	this.component_1 = component_1;
	this.component_2 = component_2;
	this.component_3_List = component_3_List;
    }

    public COMPONENT_1 getComponent_1() {
        return component_1;
    }

    public void setComponent_1(COMPONENT_1 component_1) {
        this.component_1 = component_1;
    }

    public COMPONENT_2 getComponent_2() {
        return component_2;
    }

    public void setComponent_2(COMPONENT_2 component_2) {
        this.component_2 = component_2;
    }

    public List<COMPONENT_3> getComponent_3_List() {
        return component_3_List;
    }

    public void setComponent_3_List(List<COMPONENT_3> component_3_List) {
        this.component_3_List = component_3_List;
    }
}
