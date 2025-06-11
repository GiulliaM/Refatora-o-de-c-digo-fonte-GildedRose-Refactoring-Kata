package com.gildedrose;


public class ConjuredItemUpdateStrategy implements ItemUpdateStrategy {
    @Override
    public void update(Item item) {
        //diminui a qualidade em 2 (a menos que já seja 0)
        if (item.quality > 0) {
            item.quality = item.quality - 2; // Qualidade diminui 2x mais rápido
        }
        //garante que a qualidade não fique negativa
        if (item.quality < 0) {
            item.quality = 0;
        }


        //diminui o sellIn
        item.sellIn = item.sellIn - 1;

        //se o sellIn passou, diminui a qualidade duas vezes mais (total de 4 em relação ao normal)
        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 2; // Qualidade diminui mais 2x (total de 4x)
            }
            //garante que a qualidade não fique negativa após o segundo decremento
            if (item.quality < 0) {
                item.quality = 0;
            }
        }
    }
}

