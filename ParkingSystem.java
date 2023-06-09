class ParkingSystem {


    int big = 0, medium = 0, small = 0;
    int bigCount = 0, mediumCount = 0, smallCount = 0;

    public ParkingSystem(int big, int medium, int small) {
                this.big = big;
        this.medium = medium;
        this.small = small;
    }
    
    public boolean addCar(int carType) {
          switch (carType) {
            case 1://big
                if (this.big > this.bigCount) {
                    this.bigCount++;
                    return true;
                }
                break;
            case 2://medium
                if (this.medium > this.mediumCount) {
                    this.mediumCount++;
                    return true;
                }
                break;
            case 3: // small
                if (this.small > this.smallCount) {
                    this.smallCount++;
                    return true;
                }
                break;
        }
        return false;
    }
}
