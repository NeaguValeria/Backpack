import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Problem problem = new Problem();
        problem.setBackpack(new Backpack(12));

        List<Item> generatedItems = Util.generateItems(50);
        problem.setAvailableItems(generatedItems);

        //calcul sortat
        problem.moveProfitableItemsToBackpack();

        double totalWeightOfItemsInBackpack = problem.getTotalWeightOfItemsInBackpack();
        double backpackCapacity = problem.getBackCapacity();
        double totalValue = problem.getBackpackValue();
        System.out.println("Capacity: " + backpackCapacity + "total weight in backpackage" + totalWeightOfItemsInBackpack);
        System.out.println("total value: " + totalValue);
        System.out.println("Number of leptop are:" + problem.numberOfAvailableItem("laptop"));
        System.out.println("Number of bottle are:" + problem.numberOfAvailableItem("bottle"));
        System.out.println("Number of phone are:" + problem.numberOfAvailableItem("phone"));
        problem.averageItemPrice("laptop");
        System.out.println("\n\n");
        //calcul nesaortat
        problem.setBackpack(new Backpack(12));//RESETAM RUCSACUL
        problem.moveItemsToBackpack();
        totalWeightOfItemsInBackpack = problem.getTotalWeightOfItemsInBackpack();
        backpackCapacity = problem.getBackCapacity();
        totalValue = problem.getBackpackValue();
        System.out.println("Capacity: " + backpackCapacity + "total weight in backpackage" + totalWeightOfItemsInBackpack);
        System.out.println("total value: " + totalValue);

        System.out.println("\n\n");

        //cazul OBIECTE USOARE
        problem.setBackpack(new Backpack(12));//RESETAM RUCSACUL
        problem.moveLightObjectsToBackpack();
        totalWeightOfItemsInBackpack = problem.getTotalWeightOfItemsInBackpack();
        backpackCapacity = problem.getBackCapacity();
        totalValue = problem.getBackpackValue();
        System.out.println("Capacity: " + backpackCapacity + "total weight in backpackage" + totalWeightOfItemsInBackpack + "number of items: " + problem.getNumberOfItemsInBackpack()) ;
        System.out.println("total value: " + totalValue);

        System.out.println("\n\n");

        //cazul obiecte fractionare
        problem.setBackpack(new Backpack(12));//RESETAM RUCSACUL
        problem.moveFractionItemToBackpack();
        totalWeightOfItemsInBackpack = problem.getTotalWeightOfItemsInBackpack();
        backpackCapacity = problem.getBackCapacity();
        totalValue = problem.getBackpackValue();
        System.out.println("Capacity: " + backpackCapacity + "total weight in backpackage" + totalWeightOfItemsInBackpack + "number of items: " + problem.getNumberOfItemsInBackpack()) ;
        System.out.println("total value: " + totalValue);


        
    }

}
