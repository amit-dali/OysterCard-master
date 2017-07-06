package objectmodel;

import java.util.Arrays;

public class Station {

    private String name;
    private int[] zones;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getZones() {
        return zones;
    }

    public void setZones(int[] zones) {
        this.zones = zones;
    }

    @Override
    public String toString() {
        return "Station [name=" + name + ", zones=" + zones + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + Arrays.hashCode(zones);
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
        Station other = (Station) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (!Arrays.equals(zones, other.zones))
            return false;
        return true;
    }

}
