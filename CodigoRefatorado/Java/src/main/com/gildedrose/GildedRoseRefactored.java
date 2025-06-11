package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

class GildedRoseRefactored { 
    Item[] items;
    // mapa para armazenar as estratégias de atualização de itens
    private final Map<String, ItemUpdateStrategy> strategies;
    private final ItemUpdateStrategy defaultStrategy;


    public GildedRoseRefactored(Item[] items) { 
        this.items = items;
        this.strategies = new HashMap<>();

        // inicializa as estratégias específicas
        strategies.put("Aged Brie", new AgedBrieUpdateStrategy());
        strategies.put("Sulfuras, Hand of Ragnaros", new SulfurasUpdateStrategy());
        strategies.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassUpdateStrategy());
        // adicionando a estratégia para itens Conjured
        strategies.put("Conjured Mana Cake", new ConjuredItemUpdateStrategy());
      
        // define a estratégia padrão para itens que não possuem uma estratégia específica
        this.defaultStrategy = new StandardItemUpdateStrategy();
    }

    public void updateQuality() {
        for (Item item : items) {
            // tenta obter uma estratégia específica pelo nome do item
            ItemUpdateStrategy strategy = strategies.get(item.name);

            // se não encontrar uma estratégia específica, usa a estratégia padrão
            if (strategy == null) {
                strategy = defaultStrategy;
            }
            
            // executa a atualização da qualidade do item usando a estratégia selecionada
            strategy.update(item);
        }
    }
}