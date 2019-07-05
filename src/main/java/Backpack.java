import java.util.ArrayList;
import java.util.List;

public class Backpack {

    private double capacity;
    private List<Item> itemList;


    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Backpack(double capacity) {
        itemList = new ArrayList<Item>();
        this.capacity = capacity;
    }

    public double getTotalWeightOfItems() {
        double SumWeight = 0;
        for (int i = 0; i < itemList.size(); i++) {
            SumWeight = SumWeight + itemList.get(i).getWeight();
        }
        return SumWeight;
    }

    public void add(Item Item) {
        if (getAvailableCapacity() >= Item.getWeight()) {
            itemList.add(Item);
        }
    }

    public double getAvailableCapacity(){
        return capacity - getTotalWeightOfItems();
    }

    public double getTotalValueOfItems() {
        double SumOfValue = 0;
        for (int i = 0; i < itemList.size(); i++) {
            SumOfValue = SumOfValue + itemList.get(i).getWeight();
        }
        return SumOfValue;
    }

    public int getNumberOfItems() {
        return itemList.size();
    }

    public void addFraction(Item item) {
        double availableCapacity = getAvailableCapacity();
        if(availableCapacity == 0){
            return;
        }
        if (getAvailableCapacity() >= item.getWeight()) {
            itemList.add(item);
        }else{
            Item fractionItem = new Item(item.getName(),availableCapacity,availableCapacity*item.getWeight()/item.getWeight());
            itemList.add(fractionItem);
        }
    }
}

