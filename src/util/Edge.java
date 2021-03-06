package util;

public final class Edge {
    private final Vertex source;
    private final Vertex destination;
    private final Character color;
    private final double weight;

    Edge(Vertex src, Vertex dst, Character color) {
        this.color = color;
        this.source = src;
        this.destination = dst;
        this.weight = 0.0;
    }

    public Character color() {
        return this.color;
    }

    public Vertex destination() {
        return this.destination;
    }

    public Vertex source() {
        return this.source;
    }

    public Vertex other(Vertex v) {
        assert source == v || destination == v : "Vertex is not conected to this Edge";
        return (v == source) ? destination : source;
    }

    public double weight() {
        return this.weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Edge))
            return false;

        Edge that = (Edge) o;
        if (Double.compare(that.weight, this.weight) != 0)
            return false;
        if (this.source != null ? !this.source.equals(that.source) : that.source != null)
            return false;
        if (this.destination != null ? !this.destination.equals(that.destination) : that.destination != null)
            return false;
        return this.color != null ? this.color.equals(that.color) : that.color == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = source != null ? source.hashCode() : 0;
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
