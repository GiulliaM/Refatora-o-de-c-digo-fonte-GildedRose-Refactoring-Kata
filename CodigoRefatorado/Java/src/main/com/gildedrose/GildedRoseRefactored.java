package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

class GildedRoseRefactored {
    Item[] items;
    // Mapa para armazenar as estratégias de atualização de itens
    private final Map<String, ItemUpdateStrategy> strategies;
    private final ItemUpdateStrategy defaultStrategy;

    public GildedRose(Item[] items) {
        this.items = items;
        this.strategies = new HashMap<>();

        // Inicializa as estratégias específicas
        strategies.put("Aged Brie", new AgedBrieUpdateStrategy());
        strategies.put("Sulfuras, Hand of Ragnaros", new SulfurasUpdateStrategy());
        strategies.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassUpdateStrategy());
        // Adicionando a estratégia para itens Conjured
        strategies.put("Conjured Mana Cake", new ConjuredItemUpdateStrategy());
        // Se houver outros itens conjured, você pode precisar de uma forma mais flexível de identificar
        // Por exemplo, checar se o nome começa com "Conjured"
        // strategies.put("Conjured Generic Item", new ConjuredItemUpdateStrategy()); // Exemplo para outros conjured
        // ... (você pode adicionar mais itens conjured se necessário)

        // Define a estratégia padrão para itens que não possuem uma estratégia específica
        this.defaultStrategy = new StandardItemUpdateStrategy();
    }

    public void updateQuality() {
        for (Item item : items) {
            // Tenta obter uma estratégia específica pelo nome do item
            ItemUpdateStrategy strategy = strategies.get(item.name);

            // Se não encontrar uma estratégia específica, usa a estratégia padrão
            if (strategy == null) {
                strategy = defaultStrategy;
            }
            
            // Executa a atualização da qualidade do item usando a estratégia selecionada
            strategy.update(item);
        }
    }
}