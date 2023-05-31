class UndergroundSystem {
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
        return (double)stationStatsObj.totalTime / stationStatsObj.numTrips;
    }
}
