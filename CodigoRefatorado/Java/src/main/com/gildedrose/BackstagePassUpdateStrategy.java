package com.gildedrose;

public class BackstagePassUpdateStrategy implements ItemUpdateStrategy {
    @Override
    public void update(Item item) {
        //aumenta a qualidade (a menos que já seja 50)
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            //aumenta em 2 se sellIn <= 10
            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            //aumenta em 3 se sellIn <= 5
            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }

        //diminui o sellIn
        item.sellIn = item.sellIn - 1;

        //se o sellIn passou, qualidade cai para 0
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}


