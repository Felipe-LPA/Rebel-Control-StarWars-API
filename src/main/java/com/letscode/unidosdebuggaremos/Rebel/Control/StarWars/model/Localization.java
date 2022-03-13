package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Localization {
    private double latitude;
    private double longitude;
    private Galaxy galaxy;

    public Localization(double latitude, double longitude){
        if (latitude <= 10 && longitude <= 10){
            this.galaxy = Galaxy.Bespin;
        } else if(latitude <= 10 && longitude > 10 && longitude <= 20) {

        } else if(latitude <= 10 && longitude > 20 && longitude <= 30){

        } else if(latitude > 10 && latitude <= 20 && longitude <= 10){

        } else if(latitude > 10 && latitude <= 20 && longitude > 10 && longitude <= 20){

        } else if(latitude > 10 && latitude <= 20 && longitude > 20 && longitude <= 30){

        } else if(latitude > 20 && latitude <= 30 && longitude <= 10) {

        } else if(latitude > 20 && latitude <= 30 && longitude > 10 && longitude <= 20){

        } else if(latitude > 20 && latitude <= 30 && longitude > 20 && longitude <= 30){

        }
    }
}
