package structureCoding;

public class UI_Verify extends UI_Action {

   public boolean pageTitleVerify(String exp_Title) {
        String actual_Title = getPageTitle();

        if (actual_Title.equals(exp_Title)) {

            System.out.println("Expected title and actual title is equal");
            return true;
        }else {
            System.out.println("Expected title and actual title is not equal");
            return false;
        }

    }

}
