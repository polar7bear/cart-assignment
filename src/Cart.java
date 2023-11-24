import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Item, Integer> cart;

    public Cart() {
        this.cart = new HashMap<>();
    }

    public void addItem(Item item, int quantity) {
        cart.put(item, cart.getOrDefault(item, 0) + quantity);
        System.out.println(quantity + "개의 " + item.getItemName() + " 이(가) 카트에 추가 되었습니다.");
    }

    public void removeItem(Item item, int quantity) {
        if(cart.containsKey(item)) {
            int currentQuantity = cart.get(item);

            if(quantity >= currentQuantity) {
                cart.remove(item);
                System.out.println("카트의 " + item.getItemName() + " 이(가) 제거 되었습니다.");
            } else {
                cart.put(item, currentQuantity - quantity);
                System.out.println("카트의 " + item.getItemName() + " 이(가)" + quantity + "개 제거 되었습니다.");
            }
        } else {
            System.out.println(item.getItemName() + "는 카트에 담긴 상품이 아닙니다.");
        }
    }

    public void showItems() {
        System.out.println("---카트에 담긴 상품 정보---");
        for (Map.Entry<Item, Integer> entry : cart.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(item.getItemName() + " 수량: " + quantity);
        }
    }
}
