package framework;

public class Helper {
    
    public static int getRandomInteger2(int range) {
        return (int) (Math.random() * range);
    } 
    
    
    
    public static int getRandomInteger() {
        return (int) (Math.random() * 10000);
    }
    
    public static String getRandomText() {
        return "category-milica-" + getRandomInteger();
    }
    
    public static String getRandomEmail() {
        return getRandomText() + "@gmail.com";
    }
}
