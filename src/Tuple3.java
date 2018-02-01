import java.util.Objects;

public class Tuple3<T1, T2, T3> {

    private final T1 v1;
    private final T2 v2;
    private final T3 v3;

    public Tuple3(T1 v1, T2 v2, T3 v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple3<?, ?, ?> tuple3 = (Tuple3<?, ?, ?>) o;
        return Objects.equals(v1, tuple3.v1) &&
                Objects.equals(v2, tuple3.v2) &&
                Objects.equals(v3, tuple3.v3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(v1, v2, v3);
    }

    @Override
    public String toString() {
        return "Tuple3{" +
                "v1=" + v1 +
                ", v2=" + v2 +
                ", v3=" + v3 +
                '}';
    }
}
