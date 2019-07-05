import java.util.*;

public class Problem {


    private List<Item> availableItems = new ArrayList<Item>();
    private Backpack backpack;

    public Problem() {
        availableItems = new ArrayList<Item>();
    }

    public List<Item> getAvailableItems() {
        return availableItems;
    }

    public void setAvailableItems(List<Item> availableItems) {
        this.availableItems = availableItems;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }

    public void addAvailableItem(Item item) {
        this.availableItems.add(item);

    }

    public double getTotalWeightOfItemsInBackpack() {
        return backpack.getTotalWeightOfItems();
    }

    public double getBackpackAvailableCapacity() {
        return backpack.getAvailableCapacity();
    }

    public void moveItemsToBackpack() {
        List<Item> temporaryItemList = new ArrayList<>();
        temporaryItemList.addAll(availableItems);
        for (int index = 0; index < availableItems.size(); index++) {
            Item currentItem = availableItems.get(index);
            backpack.add(currentItem);
            temporaryItemList.remove(currentItem);
        }
//        availableItems = temporaryItemList;
    }

    public double numberOfAvailableItem(String name) {
        Map<String, Double> mapItemCount = new HashMap<>();
        for (int index = 0; index < availableItems.size(); index++) {
            Item current = availableItems.get(index);
            if (mapItemCount.get(current.getName()) != null) {
                Double count = mapItemCount.get(current.getName());
                count++;
                mapItemCount.put(current.getName(), count);
            } else {
                mapItemCount.put(current.getName(), (double) 1);
            }
        }
        return mapItemCount.get(name);
    }

    public double averageItemPrice(String name) {
        Map<String, Double> mapItemAverage = new HashMap<>();
        for (int index = 0; index < availableItems.size(); index++) {
            Item currentItem = availableItems.get(index);
            if (mapItemAverage.get(currentItem.getName()) != null) {
                Double average = (currentItem.getValue() + mapItemAverage.get(currentItem.getName())) / 2;
                mapItemAverage.put(currentItem.getName(), average);
            } else {
                mapItemAverage.put(currentItem.getName(), currentItem.getValue());

            }
        }
        return mapItemAverage.get(name);
    }

    public void moveProfitableItemsToBackpack() {
        Set<Item> itemSet = new TreeSet<>(availableItems);
        //System.out.println(itemSet);
        Iterator<Item> iterator = itemSet.iterator();
        while (iterator.hasNext()) {
            backpack.add(iterator.next());
        }
    }

    //light - usor
    public void moveLightObjectsToBackpack() {
        ItemComparatorByWeight comparator = new ItemComparatorByWeight();
        Set<Item> itemSet = new TreeSet<>(comparator);
        itemSet.addAll(availableItems);
        //System.out.println(itemSet);
        Iterator<Item> iterator = itemSet.iterator();
        while (iterator.hasNext()) {
            backpack.add(iterator.next());
        }
    }

    public double getBackCapacity() {
        return backpack.getCapacity();
    }

    public double getBackpackValue() {
        return backpack.getTotalValueOfItems();
    }

    public int getNumberOfItemsInBackpack() {
        return backpack.getNumberOfItems();
    }

    public void moveFractionItemToBackpack() {
        Set<Item> itemSet = new TreeSet<>(availableItems);
        //System.out.println(itemSet);
        Iterator<Item> iterator = itemSet.iterator();
        while (iterator.hasNext()) {
            backpack.addFraction(iterator.next());
        }
    }
}
