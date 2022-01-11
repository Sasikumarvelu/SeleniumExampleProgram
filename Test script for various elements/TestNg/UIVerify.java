package testScripts;

import methodsReusable.ElementsActions;

public class UIVerify {
    ElementsActions actions = new ElementsActions();
    /**
     * This method is used to verify Expected title for the given web page
     * @return true or false
     */
    public boolean pageTitleVerify(String exp_Title){

        String actual_Title = actions.getPageTitle();

        if (actual_Title.equals(exp_Title)){
            return true;
        }else {
            return false;
        }

    }
}
