package com.gildedrose;

public interface ItemUpdateStrategy{
    void update(Item item);
}

/**
 * Interface que define o contrato para estrategias de atualizacao de itens.
 * Cada tipo de item com regras especificas de qualidade e sellIn implementara esta interface
  
 */