package com.gildedrose;

/**
 * Estratégia para "Backstage passes".
 * - Qualidade aumenta em 1 a cada dia.
 * - Qualidade aumenta em 2 quando sellIn é <= 10.
 * - Qualidade aumenta em 3 quando sellIn é <= 5.
 * - Qualidade cai para 0 quando sellIn passa de 0.
 * - Qualidade nunca excede 50.
 */
public class BackstagePassUpdateStrategy implements ItemUpdateStrategy {
    @Override
    public void update(Item item) {
        // Aumenta a qualidade (a menos que já seja 50)
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            // Aumenta em 2 se sellIn <= 10
            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            // Aumenta em 3 se sellIn <= 5
            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }

        // Diminui o sellIn
        item.sellIn = item.sellIn - 1;

        // Se o sellIn passou, qualidade cai para 0
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}