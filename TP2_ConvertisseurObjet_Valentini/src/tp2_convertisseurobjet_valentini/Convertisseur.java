package tp2_convertisseurobjet_valentini;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author stell
 */
public class Convertisseur {
    
    int nbConversions;

    public Convertisseur() {
        nbConversions = 0;
    }

    public double CelciusVersKelvin(double tCelcius) {
        nbConversions++;
        return tCelcius + 273.15;
    }

    public double KelvinVersCelcius(double tKelvin) {
        nbConversions++;
        return tKelvin - 273.15;
    }

    public double FarenheitVersCelcius(double tFarenheit) {
        nbConversions++;
        return (tFarenheit - 32) * 5.0 / 9.0;
    }

    public double CelciusVersFarenheit(double tCelcius) {
        nbConversions++;
        return tCelcius * 9.0 / 5.0 + 32;
    }

    public double KelvinVersFarenheit(double tKelvin) {
        nbConversions++;
        return (tKelvin - 273.15) * 9.0 / 5.0 + 32;
    }

    public double FarenheitVersKelvin(double tFarenheit) {
        nbConversions++;
        return (tFarenheit - 32) * 5.0 / 9.0 + 273.15;
    }

    @Override
    public String toString() {
        return "nb de conversions " + nbConversions;
    }
}

