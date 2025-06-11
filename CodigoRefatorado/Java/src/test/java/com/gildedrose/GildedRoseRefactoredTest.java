package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class GildedRoseRefactoredTest { 

    // Teste para um item normal
    @Test
    void standardItem_decreasesQualityAndSellIn() {
        Item[] items = new Item[]{new Item("+5 Dexterity Vest", 10, 20)}; //
        GildedRoseRefactored app = new GildedRoseRefactored(items); //
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(19, app.items[0].quality);
    }

    // Teste para um item normal com sellIn zero ou menos (qualidade diminui 2x mais rápido)
    @Test
    void standardItem_pastSellIn_qualityDecreasesTwiceAsFast() {
        Item[] items = new Item[]{new Item("Elixir of the Mongoose", 0, 7)}; //
        GildedRoseRefactored app = new GildedRoseRefactored(items); //
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(5, app.items[0].quality); // 7 - 2 = 5
    }

    // Teste para Aged Brie
    @Test
    void agedBrie_increasesQuality() {
        Item[] items = new Item[]{new Item("Aged Brie", 2, 0)}; //
        GildedRoseRefactored app = new GildedRoseRefactored(items); //
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    // Teste para Aged Brie com qualidade máxima
    @Test
    void agedBrie_qualityNeverGoesAbove50() {
        Item[] items = new Item[]{new Item("Aged Brie", 10, 49)}; //
        GildedRoseRefactored app = new GildedRoseRefactored(items); //
        app.updateQuality(); // quality becomes 50
        app.updateQuality(); // quality remains 50
        assertEquals(50, app.items[0].quality);
    }

    // Teste para Sulfuras
    @Test
    void sulfuras_qualityAndSellInNeverChange() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 0, 80)}; //
        GildedRoseRefactored app = new GildedRoseRefactored(items); //
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    // Teste para Backstage passes com sellIn > 10
    @Test
    void backstagePasses_sellInMoreThan10_qualityIncreasesBy1() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)}; //
        GildedRoseRefactored app = new GildedRoseRefactored(items); //
        app.updateQuality();
        assertEquals(14, app.items[0].sellIn);
        assertEquals(21, app.items[0].quality);
    }

    // Teste para Backstage passes com sellIn <= 10
    @Test
    void backstagePasses_sellIn10OrLess_qualityIncreasesBy2() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)}; //
        GildedRoseRefactored app = new GildedRoseRefactored(items); //
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(22, app.items[0].quality); // 20 + 2
    }

    // Teste para Backstage passes com sellIn <= 5
    @Test
    void backstagePasses_sellIn5OrLess_qualityIncreasesBy3() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20)}; //
        GildedRoseRefactored app = new GildedRoseRefactored(items); //
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(23, app.items[0].quality); // 20 + 3
    }

    // Teste para Backstage passes com sellIn que já passou (qualidade cai para 0)
    @Test
    void backstagePasses_pastSellIn_qualityDropsToZero() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)}; //
        GildedRoseRefactored app = new GildedRoseRefactored(items); //
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    // Teste para itens Conjured
    @Test
    void conjuredItem_qualityDecreasesTwiceAsFast() {
        Item[] items = new Item[]{new Item("Conjured Mana Cake", 3, 6)}; //
        GildedRoseRefactored app = new GildedRoseRefactored(items); //
        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality); // 6 - 2 = 4
    }

    // Teste para itens Conjured com sellIn zero ou menos (qualidade diminui 4x mais rápido)
    @Test
    void conjuredItem_pastSellIn_qualityDecreasesFourTimesAsFast() {
        Item[] items = new Item[]{new Item("Conjured Mana Cake", 0, 6)}; //
        GildedRoseRefactored app = new GildedRoseRefactored(items); //
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality); // 6 - 4 = 2
    }

    // Teste para garantir que a qualidade nunca fica negativa
    @Test
    void item_qualityNeverNegative() {
        Item[] items = new Item[]{new Item("+5 Dexterity Vest", 0, 0)}; //
        GildedRoseRefactored app = new GildedRoseRefactored(items); //
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
}