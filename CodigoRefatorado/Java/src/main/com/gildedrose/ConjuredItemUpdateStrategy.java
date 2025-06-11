package com.gildedrose;

/**
 * Estratégia para itens "Conjured".
 * - Qualidade diminui duas vezes mais rápido que itens normais.
 * - Isso significa que diminui em 2 a cada dia (antes de sellIn < 0).
 * - E diminui em 4 quando sellIn passa de 0.
 * - Qualidade nunca é negativa.
 */
public class ConjuredItemUpdateStrategy implements ItemUpdateStrategy {
    @Override
    public void update(Item item) {
        // Diminui a qualidade em 2 (a menos que já seja 0)
        if (item.quality > 0) {
            item.quality = item.quality - 2; // Qualidade diminui 2x mais rápido
        }
        // Garante que a qualidade não fique negativa
        if (item.quality < 0) {
            item.quality = 0;
        }


        // Diminui o sellIn
        item.sellIn = item.sellIn - 1;

        // Se o sellIn passou, diminui a qualidade duas vezes mais (total de 4 em relação ao normal)
        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 2; // Qualidade diminui mais 2x (total de 4x)
            }
            // Garante que a qualidade não fique negativa após o segundo decremento
            if (item.quality < 0) {
                item.quality = 0;
            }
        }
    }
}