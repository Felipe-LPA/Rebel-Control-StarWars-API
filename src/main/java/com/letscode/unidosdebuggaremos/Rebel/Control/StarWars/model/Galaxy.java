package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model;

public enum Galaxy {
    Korriban, Moraband, Coruscant, Kashyyyk, Crait, Zonama_Sekot, Cato_Neimoidia, Bespin, Kamino;

    public Galaxy getGalaxy(double latitude, double longitude) {
        if (latitude <= 10 && longitude <= 10){
            return Galaxy.Korriban;
        } else if(latitude <= 10 && longitude > 10 && longitude <= 20) {
            return Galaxy.Moraband;
        } else if(latitude <= 10 && longitude > 20 && longitude <= 30){
            return Galaxy.Coruscant;
        } else if(latitude > 10 && latitude <= 20 && longitude <= 10){
            return Galaxy.Kashyyyk;
        } else if(latitude > 10 && latitude <= 20 && longitude > 10 && longitude <= 20){
            return Galaxy.Crait;
        } else if(latitude > 10 && latitude <= 20 && longitude > 20 && longitude <= 30){
            return Galaxy.Zonama_Sekot;
        } else if(latitude > 20 && latitude <= 30 && longitude <= 10) {
            return Galaxy.Cato_Neimoidia;
        } else if(latitude > 20 && latitude <= 30 && longitude > 10 && longitude <= 20){
            return Galaxy.Bespin;
        } else {
            return Galaxy.Kamino;
        }
    }
}
