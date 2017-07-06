package objectmodel;

public class Card {

    private Journey journey;
    private String id;
    private float balance;

    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Card [journey=" + journey + ", id=" + id + ", balance=" + balance + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(balance);
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((journey == null) ? 0 : journey.hashCode());
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
        Card other = (Card) obj;
        if (Float.floatToIntBits(balance) != Float.floatToIntBits(other.balance))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (journey == null) {
            if (other.journey != null)
                return false;
        } else if (!journey.equals(other.journey))
            return false;
        return true;
    }

}
