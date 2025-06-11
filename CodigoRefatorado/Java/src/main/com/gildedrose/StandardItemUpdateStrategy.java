package com.gildedrose; 

public class StandardItemUpdateStrategy implements ItemUpdateStrategy{
    @Override
    public void update(Item item){
        if(item.quality > 0){ //diminui a qualidade (a menos que ja seja 0)
            item.quality = item.quality - 1;
        }

        item.sellIn = item.sellIn - 1; 

        if (item.sellIn < 0){ //se o sellIn passou, diminui a qualidade uma vez mais (total de 2)
            if(item.quality > 0){
                item.quality = item.quality - 1;
            }
        }

        if (item.quality < 0) {
            item.quality = 0;
        }
    }
}