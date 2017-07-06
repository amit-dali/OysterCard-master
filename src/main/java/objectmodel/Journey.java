package objectmodel;

import constants.JourneyStatus;
import constants.JourneyType;
import constants.Swipe;

public class Journey {
    String source, destination;
    Swipe swipe;
    Fare fare;
    JourneyType journeyType;
    JourneyStatus journeyStatus;

    public JourneyStatus getJourneyStatus() {
        return journeyStatus;
    }

    public void setJourneyStatus(JourneyStatus journeyStatus) {
        this.journeyStatus = journeyStatus;
    }

    public JourneyType getJourneyType() {
        return journeyType;
    }

    public void setJourneyType(JourneyType journeyType) {
        this.journeyType = journeyType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Swipe getSwipe() {
        return swipe;
    }

    public void setSwipe(Swipe swipe) {
        this.swipe = swipe;
    }

    public Fare getFare() {
        return fare;
    }

    public void setFare(Fare fare) {
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "Journey [source=" + source + ", destination=" + destination + ", swipe=" + swipe + ", fare=" + fare + ", journeyType="
                + journeyType + ", journeyStatus=" + journeyStatus + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((destination == null) ? 0 : destination.hashCode());
        result = prime * result + ((fare == null) ? 0 : fare.hashCode());
        result = prime * result + ((journeyStatus == null) ? 0 : journeyStatus.hashCode());
        result = prime * result + ((journeyType == null) ? 0 : journeyType.hashCode());
        result = prime * result + ((source == null) ? 0 : source.hashCode());
        result = prime * result + ((swipe == null) ? 0 : swipe.hashCode());
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
        Journey other = (Journey) obj;
        if (destination == null) {
            if (other.destination != null)
                return false;
        } else if (!destination.equals(other.destination))
            return false;
        if (fare == null) {
            if (other.fare != null)
                return false;
        } else if (!fare.equals(other.fare))
            return false;
        if (journeyStatus != other.journeyStatus)
            return false;
        if (journeyType != other.journeyType)
            return false;
        if (source == null) {
            if (other.source != null)
                return false;
        } else if (!source.equals(other.source))
            return false;
        if (swipe != other.swipe)
            return false;
        return true;
    }

}
