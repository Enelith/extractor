package extractor.model.action.byreflection;

import java.util.List;

import extractor.model.component.COMPONENT_1;
import extractor.model.component.COMPONENT_2;
import extractor.model.component.COMPONENT_3;
import extractor.model.core.ActionModel;

/**
 * @author jvinh
 */
public class Action_1 extends ActionModel {
    private COMPONENT_1 component_1;
    
    private List<COMPONENT_2> component_2_List;
    
    private List<COMPONENT_3> component_3_List;

    public Action_1() {
	super();
    }

    public Action_1(COMPONENT_1 component_1, List<COMPONENT_2> component_2_List, List<COMPONENT_3> component_3_List) {
	super();
	this.component_1 = component_1;
	this.component_2_List = component_2_List;
	this.component_3_List = component_3_List;
    }

    public COMPONENT_1 getComponent_1() {
        return component_1;
    }

    public void setComponent_1(COMPONENT_1 component_1) {
        this.component_1 = component_1;
    }

    public List<COMPONENT_2> getComponent_2_List() {
        return component_2_List;
    }

    public void setComponent_2_List(List<COMPONENT_2> component_2_List) {
        this.component_2_List = component_2_List;
    }

    public List<COMPONENT_3> getComponent_3_List() {
        return component_3_List;
    }

    public void setComponent_3_List(List<COMPONENT_3> component_3_List) {
        this.component_3_List = component_3_List;
    }
}
