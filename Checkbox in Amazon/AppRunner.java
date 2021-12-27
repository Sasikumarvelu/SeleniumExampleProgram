package amazonOnlineShoppingWebsite;

public class AppRunner {
    public static void main(String[] args) {
        Amazon amazon = new Amazon();
        amazon.Launch_Browser();
        amazon.is_All_Element_Present();
        amazon.Is_Element_Present("Research Center");
        amazon.Close_Browser();
    }
}
