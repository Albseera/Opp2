import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;

import static java.lang.Character.isDigit;

public class Car {
    private final String brand;
    private final String model;
    private final String  country;
    private String color;
    private final Integer year;
    private Double engineVolume;

    private String transmission;
    private final  String bodyOfTape;
    private String regNumber;
    private final int numberOfPlace;

    private boolean tireOfSeason;

    public Car(String brand,
               String model,
               String country,
               String color,
               Integer year,
               Double engineVolume
    ) {
        this (brand,  model, country, color,  year,  engineVolume, "МКПП", "седан", "х000хх000",5,true);

    }


    public Car(String brand,
               String model,
               String country,
               String color,
               Integer year,
               Double engineVolume,
               String transmission,
               String bodyOfTape,
               String regNumber,
               Integer numberOfPlace,
               boolean tireOfSeason
               ) {

        if(brand==null) {
            this.brand="default";
        }else {
            this.brand=brand;
        }
        if(model==null) {
            this.model="default";
        }else {
            this.model=model;
        }
        if(country==null) {
            this.country="default";
        }else {
            this.country=country;
        }
        if(engineVolume<=0) {
            this.engineVolume=1.5;
        }else {
            this.engineVolume=engineVolume;
        }
        if(color==null) {
            this.color="белый";
        }else {
            this.color=color;
        }
        if(year<=0) {
            this.year = 2000;
        }else {
            this.year=year;
        }

        if(transmission==null) {
            this.transmission="МКПП";
        }else {
            this.transmission=transmission;
        }

        if(regNumber==null) {
            this.regNumber="x000xx000";
        }else {
            this.regNumber=regNumber;
        }
        if(bodyOfTape==null) {
            this.bodyOfTape="седан";
        }else {
            this.bodyOfTape=bodyOfTape;
        }
        this.numberOfPlace=numberOfPlace;
        this.tireOfSeason=tireOfSeason;




    }

    public String getTransmission() {
        return transmission;
    }

    public String getBodyOfTape() {
        return bodyOfTape;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public int getNumberOfPlace() {
        return numberOfPlace;
    }

    public boolean isTireOfSeason() {
        return tireOfSeason;
    }

    public String getBrand() {
        return brand;
    }



    public String getModel() {
        return model;
    }



    public String getCountry() {
        return country;
    }



    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public  boolean isCorrectRegNumber(){
        if(regNumber.length()!=9){
            return false;
        }
        char[] chars =regNumber.toCharArray();
        if(!Character.isAlphabetic(chars[0])||!Character.isAlphabetic(chars[4])||!Character.isAlphabetic(chars[5])){
            return false;
        }
        return Character.isDigit(chars[1]) && Character.isDigit(chars[2])&&Character.isDigit(chars[3])&&
                Character.isDigit(chars[6])&&Character.isDigit(chars[7])&&Character.isDigit(chars[8]);

    }

    public Integer getYear() {
        return year;
    }
    public Boolean isSummerTyres() {
        int month= LocalDate.now().getMonthValue();
        if(month<=4||month==12||month==11){
            return false;
        }else {
            return true;
        }


    }

    public Double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(Double engineVolume) {
        this.engineVolume = engineVolume;
    }

    @Override
    public String toString() {
        return "марка:" + brand + ", модель:" + model + ", страна сборки:" + country + ", цвет кузова:" + color + ", год производства:" +year + ", объем двигателя:" +engineVolume ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return brand.equals(car.brand) && model.equals(car.model) && year.equals(car.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year);
    }
}

