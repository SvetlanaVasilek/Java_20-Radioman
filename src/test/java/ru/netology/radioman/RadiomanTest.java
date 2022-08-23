package ru.netology.radioman;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadiomanTest {
    Radioman station = new Radioman();


    @Test
    public void GetCurrentStation() {
        station.setCurrentStation(0);
        station.setCurrentStation(-1);
        station.setCurrentStation(11);
        Assertions.assertEquals(0, station.getCurrentStation());
    }

    @Test
    public void shouldPressNextStation() {
        station.setCurrentStation(0);
        station.pressNextStation();
        Assertions.assertEquals(1, station.getCurrentStation());

        station.setCurrentStation(10);
        station.pressNextStation();
        Assertions.assertEquals(0, station.getCurrentStation());

        station.setCurrentStation(-1);
        station.pressNextStation();
        Assertions.assertEquals(0, station.getCurrentStation());

        station.setCurrentStation(11);
        station.pressNextStation();
        Assertions.assertEquals(1, station.getCurrentStation());
    }

    @Test
    public void pressPrevStation() {
        station.setCurrentStation(0);
        station.pressPrevStation();
        Assertions.assertEquals(10, station.getCurrentStation());

        station.setCurrentStation(10);
        station.pressPrevStation();
        Assertions.assertEquals(9, station.getCurrentStation());
    }

    @Test
    public void shouldGetToMaxStation() {
        Assertions.assertEquals(10, station.getMaxRadioStation());
    }

    @Test
    public void shouldSetMaxStation() {
        station.setMaxRadioStation(-1);
        station.setMaxRadioStation(0);
        station.setMaxRadioStation(11);
        Assertions.assertEquals(11, station.getMaxRadioStation());
    }

    @Test
    public void getToMinStation() {
        Assertions.assertEquals(0, station.getMinRadioStation());
    }

    @Test
    public void setMinStation() {
        station.setMinRadioStation(-1);
        station.setMinRadioStation(0);
        station.setMinRadioStation(11);
        Assertions.assertEquals(11, station.getMinRadioStation());
    }

    //тестируем громкость
    @Test
    public void setCurrentVolume() {
        station.setCurrentVolume(101);
        Assertions.assertEquals(0, station.getCurrentVolume());

        station.setCurrentVolume(-1);
        Assertions.assertEquals(100, station.getCurrentVolume());

        station.setCurrentVolume(8);
        Assertions.assertEquals(8, station.getCurrentVolume());
    }

    @Test
    public void getMinVolume() {
        Assertions.assertEquals(0, station.getMinVolume());
    }

    @Test
    public void getMaxVolume() {
        Assertions.assertEquals(100, station.getMaxVolume());
    }

    @Test
    public void shouldSetMinVolume() {
        station.setMaxVolume(100);
        station.setMinVolume(1);
        Assertions.assertEquals(1, station.getMinVolume());
    }

    @Test
    public void shouldSetMaxVolume() {
        station.setMinVolume(1);
        station.setMaxVolume(101);
        Assertions.assertEquals(101, station.getMaxVolume());
    }

    @Test
    public void pressVolumeUp() {
        station.setCurrentVolume(3);
        station.pressVolumeUp();
        Assertions.assertEquals(4, station.getCurrentVolume());

        station.setCurrentVolume(100);
        station.pressVolumeUp();
        Assertions.assertEquals(0, station.getCurrentVolume());
    }

    @Test
    public void pressVolumeDown() {
        station.setCurrentVolume(4);
        station.pressVolumeDown();
        Assertions.assertEquals(3, station.getCurrentVolume());

        station.setCurrentVolume(0);
        station.pressVolumeDown();
        Assertions.assertEquals(100, station.getCurrentVolume());
    }

    @Test
    public void createStationsWithLimits() {
        Radioman radio = new Radioman(1);
        Assertions.assertEquals(0, radio.getMaxRadioStation());

        Radioman radio1 = new Radioman(100);
        Assertions.assertEquals(99, radio1.getMaxRadioStation());

        Radioman radio2 = new Radioman(10);
        Assertions.assertEquals(0, radio2.getMinRadioStation());
    }
}


