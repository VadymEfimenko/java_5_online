package ua.com.alevel;

import java.util.Objects;

public class Edge {


    private String start;

    private String finish;

    private Integer weight;

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "start='" + start + '\'' +
                ", finish='" + finish + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Objects.equals(start, edge.start) && Objects.equals(finish, edge.finish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, finish);
    }
}
