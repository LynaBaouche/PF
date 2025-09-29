package org.example.cours2;
import java.util.List;
public class ShoppingCart
{
    public static int getDiscountPercetage(List<String>items){
        if (items.contains ("Book")){
            return 5;

        }else{
            return 0;
        }
    }
}

