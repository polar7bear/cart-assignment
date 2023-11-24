import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    //IO 스트림으로 csv파일로부터 상품목록 받아오기
    public static Set<Item> readItemListFromCSV(String filepath) {
        Set<Item> itemList = new HashSet<>();

        try(BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int key = Integer.parseInt(data[0]);
                String name = data[1];
                int price = Integer.parseInt(data[2]);

                itemList.add(new Item(key, name, price));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return itemList;
    }

    public static void main(String[] args) {
        //상품 목록 생성
        Set<Item> itemSet = new HashSet<>();
        //TODO: 상품 클래스 생성하여 상품목록에 넣기
        itemSet.add(new Item(1, "아이스크림", 500));
        itemSet.add(new Item(2, "콜라", 1500));


        //장바구니 생성
        Cart myCart = new Cart();
        
        //장바구니에 상품 추가
        Item iceCream = new Item(1, "아이스크림", 500);
        Item cola = new Item(2, "콜라", 1500);
        myCart.addItem(iceCream, 3);
        myCart.addItem(cola, 5);
        
        //장바구니에서 상품 제거
        myCart.removeItem(cola, 2);
        
        //장바구니에 현재 담긴 상품들 출력
        myCart.showItems();
    }
}
