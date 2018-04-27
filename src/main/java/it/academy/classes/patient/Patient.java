package it.academy.classes.patient;

import it.academy.exeptions.WrongValueOfHealthExeption;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Patient {
    private String name;
    private String secondName;
    private Date birthday;
    private boolean isHealthy;
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public Patient() {
    }

    public Patient(String name, String secondName, Date birthday, boolean isHealthy) {
        this.name = name;
        this.secondName = secondName;
        this.birthday = birthday;
        this.isHealthy = isHealthy;
    }

    public Patient setName(String name) {
        this.name = name;
        return this;
    }

    public Patient setSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }

    public Patient setBirthday(String birthday) throws ParseException {
        this.birthday = sdf.parse(birthday);
        return this;
    }

    public Patient setHealthy(String healthy) throws WrongValueOfHealthExeption {
        if (healthy.equals("здоров")) {
            isHealthy = false;
        } else {
            if (healthy.equals("нездоров")) {
                isHealthy = true;
            } else {
                throw new WrongValueOfHealthExeption();
            }
        }
        return this;
    }

    public void create() {
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getBirthday() {
        return sdf.format(birthday);
    }

    public boolean getHealthy() {
        return isHealthy;
    }

    public String toString() {
        String info = "Имя : " + name
                + "\nФамилия : " + secondName
                + "\nДата рождения : " + birthday
                + "\nСостояние здоровья : ";
        if (isHealthy) {
            info = info + "нездоров";
        } else {
            info = info + "здоров";
        }
        return info;
    }
}
