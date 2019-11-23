package extractor.test.byreflection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import extractor.exception.ValidationErrorException;
import extractor.model.action.byreflection.Action_1;
import extractor.model.component.COMPONENT_1;
import extractor.model.component.COMPONENT_2;
import extractor.model.component.COMPONENT_3;
import extractor.utils.ExtractorUtils;

/**
 * @author jvinh
 */
public class Action_1_Reflection_Test {

    public static void main(String[] args) {
	boolean fullDisplayMode = true;
	
	// TODO Auto-generated method stub
	Action_1 action = new Action_1();
	action.setFullDisplayModel(fullDisplayMode);
	
	COMPONENT_1 component_1 = new COMPONENT_1();
	component_1.setFullDisplayModel(fullDisplayMode);
	component_1.setCodeAction(action.getCodeAction());
	component_1.setCodeReference(action.getCodeReference());
	component_1.setDateBegin(ExtractorUtils.dateConvertor(new Date()));
	
	List<COMPONENT_2> component_2_List = new ArrayList<>();
	COMPONENT_2 component_2 = new COMPONENT_2();
	component_2.setFullDisplayModel(fullDisplayMode);
	component_2.setLastname("LASTNAME_1");
	component_2.setFirstname("TOTO");
	component_2.setCity("PARIS");
	component_2_List.add(component_2);

	component_2 = new COMPONENT_2();
	component_2.setFullDisplayModel(fullDisplayMode);
	component_2.setLastname("LASTNAME_2");
	component_2.setFirstname("TATA");
	component_2.setCity("CHARTRES");
	component_2_List.add(component_2);

	List<COMPONENT_3> component_3_List = new ArrayList<>();
	
	action.setComponent_1(component_1);
	action.setComponent_2_List(component_2_List);
	action.setComponent_3_List(component_3_List);

	try {
	    action.validate();
	} catch (ValidationErrorException e) {
	    e.printStackTrace();
	}
	
	action.generateAction_Reflection();
    }

}
