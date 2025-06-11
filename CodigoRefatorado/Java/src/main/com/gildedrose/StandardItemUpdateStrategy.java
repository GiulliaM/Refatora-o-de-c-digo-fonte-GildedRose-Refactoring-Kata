package com.gildecrose;

public class StandardItemUpdateStrategy implements ItemUpdateStrategy{
    @Override
    public void update(Item item){
        if(item.quality > 0){ //Diminui a qualidade (a menos que ja seja 0)
            item.quality = item.quality - 1;
        }

        item.sellIn = item.quality - 1; //Diminui o sellIn

        if (item.sellIn < 0){ //Se o sellIn passou, diminui a qualidade uma vez mais (total de 2)
            if(item.quality > 0){
                item.quality = item.quality - 1;
            }
        }
    }
}

/**
 * Estratégia para itens normais.
 * - Qualidade diminui em 1 a cada dia.
 * - Quando o sellIn passa de 0, a qualidade diminui em 2.
 * - Qualidade nunca é negativa.
 */