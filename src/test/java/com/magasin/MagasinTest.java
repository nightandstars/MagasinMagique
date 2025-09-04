package com.magasin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {

    @Test
    @DisplayName("Kryptonite quality doesn't change after update")
    void KryptoniteQualityAfterUpdateIsUnchanged() {
        Item[] items = new Item[] { new Item("Kryptonite", 0, 80) };
        MagasinRefactored app = new MagasinRefactored(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    @DisplayName("Comte quality gets higher after update")
    void ComteQualityAfterUpdateIsHigher(){
        Item[] items = new Item[] { new Item("Comté", 30, 10) };
        MagasinRefactored app = new MagasinRefactored(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }

    @Test
    @DisplayName("Comte quality gets two times better when expired")
    void ComteQualityIsPlus2WhenExpired(){
        Item[] items = new Item[] { new Item("Comté", 0, 10) };
        MagasinRefactored app = new MagasinRefactored(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }

    @Test
    void VIPPassQualityIsPlus2When10DaysLeftOrLess(){
        Item[] items = new Item[] { new Item("Pass VIP Concert", 7, 10) };
        MagasinRefactored app = new MagasinRefactored(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }

    @Test
    void VIPPassQualityPlus1WhenSellinHigherThan10Days(){
        Item[] items = new Item[] { new Item("Pass VIP Concert", 20, 10) };
        MagasinRefactored app = new MagasinRefactored(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void VIPPassIsPlus3When5DaysLeftOrLess(){
        Item[] items = new Item[] { new Item("Pass VIP Concert", 2, 10) };
        MagasinRefactored app = new MagasinRefactored(items);
        app.updateQuality();
        assertEquals(13, app.items[0].quality);
    }

    @Test
    void VIPPassEquals0WhenSellInEquals0(){
        Item[] items = new Item[] { new Item("Pass VIP Concert", 0, 10) };
        MagasinRefactored app = new MagasinRefactored(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void ProductQualityIsMinus2WhenSellInIs0(){
        Item[] items = new Item[] { new Item("Wand", 0, 10) };
        MagasinRefactored app = new MagasinRefactored(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void PouvoirsMagiquesQualityMinus2AfterUpdate(){
        Item[] items = new Item[] { new Item("Pouvoirs magiques", 2, 10) };
        MagasinRefactored app = new MagasinRefactored(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void PouvoirsMagiquesQualityCantBeNegative(){
        Item[] items = new Item[] { new Item("Pouvoirs magiques", 0, 0) };
        MagasinRefactored app = new MagasinRefactored(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    @DisplayName("Product quality cannot be negative")
    void ProductQualityIsntNegativeAfterUpdate(){
        Item[] items = new Item[] { new Item("Wand", 0, 0) };
        MagasinRefactored app = new MagasinRefactored(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    @DisplayName("Product quality cannot go over 50")
    void ProductQualityIsLimitedTo50AfterUpdate(){
        Item[] items = new Item[] { new Item("Comté", 30, 50) };
        MagasinRefactored app = new MagasinRefactored(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    @DisplayName("Product quality cannot go over 50")
    void ProductQualityMinusOneAfterUpdate(){
        Item[] items = new Item[] { new Item("Wand", 30, 47) };
        MagasinRefactored app = new MagasinRefactored(items);
        app.updateQuality();
        assertEquals(46, app.items[0].quality);
    }

}
