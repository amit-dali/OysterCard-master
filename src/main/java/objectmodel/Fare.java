package objectmodel;

import java.util.Arrays;

import constants.JourneyType;

public class Fare {
    int[] journeyZones;
    float fare;
    JourneyType journeyType;

    public int[] getJourneyZones() {
        return journeyZones;
    }

    public void setJourneyZones(int[] journeyZones) {
        this.journeyZones = journeyZones;
    }

    public float getFare() {
        return fare;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }

    public JourneyType getJourneyType() {
        return journeyType;
    }

    public void setJourneyType(JourneyType journeyType) {
        this.journeyType = journeyType;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(fare);
        result = prime * result + ((journeyType == null) ? 0 : journeyType.hashCode());
        result = prime * result + Arrays.hashCode(journeyZones);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Fare other = (Fare) obj;
        if (Float.floatToIntBits(fare) != Float.floatToIntBits(other.fare))
            return false;
        if (journeyType == null) {
            if (other.journeyType != null)
                return false;
        } else if (!journeyType.equals(other.journeyType))
            return false;
        if (!Arrays.equals(journeyZones, other.journeyZones))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Fare [journeyZones=" + Arrays.toString(journeyZones) + ", fare=" + fare + ", journeyType=" + journeyType + "]";
    }
}
