package com.gildedrose;

/**
 * Interface que define o contrato para estratégias de atualização de itens.
 * Cada tipo de item com regras específicas de qualidade e sellIn implementará esta interface.
 */
public interface ItemUpdateStrategy{
    void update(Item item);
}