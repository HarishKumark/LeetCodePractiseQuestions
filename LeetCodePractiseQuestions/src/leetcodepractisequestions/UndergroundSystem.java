/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leetcodepractisequestions;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hkorada
 */
public class UndergroundSystem {

    class CheckInRecord {

        String stationName;
        int time;

        public CheckInRecord(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }

    }

    class StationStats {

        int totalTime;
        int numTrips;
    }

    private Map<Integer, CheckInRecord> checkIns;
    private Map<String, StationStats> stationStats;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        stationStats = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInRecord(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInRecord startStation = checkIns.get(id);
        String route = startStation.stationName + "-" + stationName;
        stationStats.putIfAbsent(route, new StationStats());
        StationStats stationStatsObj = stationStats.get(route);
        stationStatsObj.totalTime += (t - startStation.time);
        stationStatsObj.numTrips++;
    }

    public double getAverageTime(String startStation, String endStation) {
        StationStats stationStatsObj = stationStats.get(startStation + "-" + endStation);
        return stationStatsObj.totalTime / stationStatsObj.numTrips;
    }

    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);  // Customer 45 "Leyton" -> "Waterloo" in 15-3 = 12
        undergroundSystem.checkOut(27, "Waterloo", 20);  // Customer 27 "Leyton" -> "Waterloo" in 20-10 = 10
        undergroundSystem.checkOut(32, "Cambridge", 22); // Customer 32 "Paradise" -> "Cambridge" in 22-8 = 14
        double d = undergroundSystem.getAverageTime("Paradise", "Cambridge"); // return 14.00000. One trip "Paradise" -> "Cambridge", (14) / 1 = 14
        System.out.println(d);
        d = undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 11.00000. Two trips "Leyton" -> "Waterloo", (10 + 12) / 2 = 11
        System.out.println(d);
        undergroundSystem.checkIn(10, "Leyton", 24);
        d = undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 11.00000
        System.out.println(d);
        undergroundSystem.checkOut(10, "Waterloo", 38);  // Customer 10 "Leyton" -> "Waterloo" in 38-24 = 14
        d = undergroundSystem.getAverageTime("Leyton", "Waterloo");
        System.out.println(d);

//        UndergroundSystem undergroundSystem = new UndergroundSystem();
//        undergroundSystem.checkIn(10, "Leyton", 3);
//        undergroundSystem.checkOut(10, "Paradise", 8); // Customer 10 "Leyton" -> "Paradise" in 8-3 = 5
//        double d = undergroundSystem.getAverageTime("Leyton", "Paradise"); // return 5.00000, (5) / 1 = 5
//        System.out.println(d);
//        undergroundSystem.checkIn(5, "Leyton", 10);
//        undergroundSystem.checkOut(5, "Paradise", 16); // Customer 5 "Leyton" -> "Paradise" in 16-10 = 6
//        d = undergroundSystem.getAverageTime("Leyton", "Paradise"); // return 5.50000, (5 + 6) / 2 = 5.5
//        System.out.println(d);
//        undergroundSystem.checkIn(2, "Leyton", 21);
//        undergroundSystem.checkOut(2, "Paradise", 30); // Customer 2 "Leyton" -> "Paradise" in 30-21 = 9
//        d = undergroundSystem.getAverageTime("Leyton", "Paradise"); // return 6.66667, (5 + 6 + 9) / 3 = 6.66667
//        System.out.println(d);
    }
}
