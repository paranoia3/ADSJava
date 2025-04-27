import java.util.Objects;

class MyTestingClass {
    private String data;
    private int id;

    public MyTestingClass(String data, int id) {
        this.data = data;
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTestingClass that = (MyTestingClass) o;
        return id == that.id && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + (data != null ? simpleStringHash(data) : 0);
        return result;
    }

    private int simpleStringHash(String s) {
        if (s == null) return 0;
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = 31 * hash + s.charAt(i);
        }
        return hash;
    }


    @Override
    public String toString() {
        return "MyTestingClass{" +
                "data='" + data + '\'' +
                ", id=" + id +
                '}';
    }
}