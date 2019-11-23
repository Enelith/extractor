package extractor.model.component;

import extractor.model.core.ComponentModel;

/**
 * @author jvinh
 */
public class COMPONENT_1 extends ComponentModel {
    private String codeAction;
    private String codeReference;
    private String dateBegin;
    private String flagEntry;
    private String flagExit;
    
    public String getCodeAction() {
        return codeAction;
    }
    public void setCodeAction(String codeAction) {
        this.codeAction = codeAction;
    }
    public String getCodeReference() {
        return codeReference;
    }
    public void setCodeReference(String codeReference) {
        this.codeReference = codeReference;
    }
    public String getDateBegin() {
        return dateBegin;
    }
    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin;
    }
    public String getFlagEntry() {
        return flagEntry;
    }
    public void setFlagEntry(String flagEntry) {
        this.flagEntry = flagEntry;
    }
    public String getFlagExit() {
        return flagExit;
    }
    public void setFlagExit(String flagExit) {
        this.flagExit = flagExit;
    }
}
