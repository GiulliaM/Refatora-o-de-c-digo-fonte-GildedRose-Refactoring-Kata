package com.gildedrose;

public class AgedBrieUpdateStrategy implements ItemUpdateStrategy{
    @Override
    public void update (Item item){
        if (item.quality < 50) { //aumenta a qualidade (a menos que ja seja 50)
            item.quality = item.quality + 1; 
        }

       
        item.sellIn = item.sellIn - 1; //diminui o sellIn

        //se o sellIn passou, aumenta a qualidade uma vez mais
        if (item.sellIn < 0) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }
}

