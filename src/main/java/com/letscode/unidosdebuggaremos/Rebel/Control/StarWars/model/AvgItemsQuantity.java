package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class AvgItemsQuantity {
    private double avgWeapon;
    private double avgAmmunition;
    private double avgWater;
    private double avgFood;

    public void setAvgWeapon(double avgWeapon) {
        this.avgWeapon += avgWeapon;
    }
    public void setAvgAmmunition(double avgAmmunition) {
        this.avgAmmunition += avgAmmunition;
    }

    public void setAvgWater(double avgWater) {
        this.avgWater += avgWater;
    }

    public void setAvgFood(double avgFood) {
        this.avgFood += avgFood;
    }
    public void setAvg(int rebelsQuantity){
        this.avgWeapon /= rebelsQuantity;
        this.avgAmmunition /= rebelsQuantity;
        this.avgWater /= rebelsQuantity;
        this.avgFood /= rebelsQuantity;
    }
}
