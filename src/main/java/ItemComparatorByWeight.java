import java.util.Comparator;

public class ItemComparatorByWeight implements Comparator<Item> {


    @Override
    public int compare(Item firstItem, Item secondItem) {
        double firtItemWeight = firstItem.getWeight();
        double secondItemWeight = secondItem.getWeight();
        return Double.compare(firtItemWeight,secondItemWeight);
    }
}
