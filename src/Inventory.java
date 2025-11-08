import java.util.HashMap;

public class Inventory {
    private HashMap<String, Integer> items = new HashMap<>();

    public void addItem(String item) {
        items.put(item, items.getOrDefault(item, 0) + 1);
        System.out.println("🧳 Added to inventory: " + item);
    }

    public boolean useItem(String item) {
        if (items.getOrDefault(item, 0) > 0) {
            items.put(item, items.get(item) - 1);
            return true;
        }
        return false;
    }

    public void showInventory() {
        System.out.println("\n📦 Your Inventory:");
        if (items.isEmpty()) {
            System.out.println(" - Empty -");
        } else {
            items.forEach((name, count) ->
                    System.out.println(" - " + name + " x" + count));
        }
        System.out.println();
    }
}
