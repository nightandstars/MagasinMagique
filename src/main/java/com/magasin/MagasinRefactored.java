package com.magasin;

class MagasinRefactored {
    Item[] items;

    public MagasinRefactored(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            if(!items[i].name.equals("Kryptonite")){
                items[i].sellIn--;
            }

            if(items[i].quality < 50){
                switch (items[i].name) {
                    case "Comté":
                        if (items[i].sellIn <= 0) {
                            items[i].quality = items[i].quality + 2;
                        } else {
                            items[i].quality++;
                        }
                        break;
                    case "Pass VIP Concert":
                        if (items[i].sellIn <= 0) {
                            items[i].quality = 0;
                        } else if (items[i].sellIn <= 5) {
                            items[i].quality = items[i].quality + 3;
                        } else if (items[i].sellIn <= 10) {
                            items[i].quality = items[i].quality + 2;
                        } else {
                            items[i].quality++;
                        }
                        break;
                    case "Kryptonite":
                        break;
                    case "Pouvoirs magiques":
                        if (items[i].quality > 0){
                            if(items[i].sellIn > 0){
                                items[i].quality = items[i].quality - 2;
                            }
                        }else{
                            items[i].quality = 0;
                        }
                        break;
                    default:
                        if (items[i].quality > 0){
                            if(items[i].sellIn > 0){
                                items[i].quality--;
                            }else{
                                items[i].quality = items[i].quality - 2;
                            }
                        }else{
                            items[i].quality = 0;
                        }

            }
            }
        }
    }


}
