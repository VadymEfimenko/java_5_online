package ua.com.alevel.entity;

public class Bill extends BaseEntity {

    private String firstName;
    private String lastName;
    private long sum;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        if (sum > 0) {
            this.sum = sum;
        }
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id= " + getId() +
                " firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sum=" + sum +
                '}';
    }
}
