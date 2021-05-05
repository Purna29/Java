import java.text.DecimalFormat;

public class DoubleArraySeq implements Cloneable {

    public double[] data;
    public int size;
    public int currentIndex;
    public double element;

    public DoubleArraySeq() {
        data = new double[10];
        size = 0;
        currentIndex = -1;
    }

    public DoubleArraySeq(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Negative initialCapacity:" + initialCapacity);
        }
        data = new double[initialCapacity];
        size = 0;
        currentIndex = -1;
    }

    public void ensureCapacity(int minimumCapacity) {
        int ensuredCapacity;
        if (data.length < minimumCapacity) {
            ensuredCapacity = minimumCapacity;
        } else {
            ensuredCapacity = data.length;
        }
        double[] biggerArray = new double[ensuredCapacity];
        System.arraycopy(data, 0, biggerArray, 0, size);
        data = biggerArray;
    }

    public int getCapacity() {
        return data.length;
    }

    public void trimToSize() {
        double[] trimmedArray;
        if (data.length != size) {
            trimmedArray = new double[size];
            System.arraycopy(data, 0, trimmedArray, 0, size);
            data = trimmedArray;
        }
    }

    public void advance() {
        if (!isCurrent()) {
            throw new IllegalStateException("There is no Current Element");
        }
        currentIndex++;
    }

    public void removeCurrent() {
        if (size - 1 < currentIndex) {
            throw new IllegalStateException("There is no Current Element");
        }
        for (int i = currentIndex; i < size; i++) {
            try {
                data[i] = data[i + 1];
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
        data[size-- - 1] = 0;
    }

    public void print() {
        System.out.println("Capacity=" + data.length);
        System.out.println("Length=" + size);
        if (currentIndex == -1) {
            System.out.println("There is no Current Element");
        } else {
            System.out.println("currentElement=" + getCurrent());
        }
        System.out.println("" + printArray(element));
    }

    public void addAfter(double element) {
        int i;
        if (size == data.length) {
            ensureCapacity(size * 2);
        }

        if (!isCurrent()) {
            currentIndex = 0;
        } else {
            currentIndex++;
        }
        for (i = size; i > currentIndex; i--) {
            data[i] = data[i - 1];
        }
        data[currentIndex] = element;
        size++;
    }

    public void start() {
        if (data.length > 0) {
            currentIndex = 0;
        }
    }

    public void addBefore(double d) {
        if (size == data.length) {
            ensureCapacity(size * 2 + 1);
        }

        if (!isCurrent()) {
            currentIndex = 0;
        }
        for (int i = size; i > currentIndex; i--) {
            data[i] = data[i - 1];
        }
        data[currentIndex] = d;
        size++;
    }

    public void addAll(DoubleArraySeq addend) {
        if (addend == null) {
            throw new NullPointerException("Addend Array is Null Point");
        }
        this.ensureCapacity(size + addend.size);
        System.arraycopy(addend.data, 0, this.data, this.size, addend.size);
        size += addend.size;
    }

    public static DoubleArraySeq concatenation(DoubleArraySeq s, DoubleArraySeq t) {
        DoubleArraySeq s3 = new DoubleArraySeq(s.size + t.size);
        System.arraycopy(s.data, 0, s3.data, 0, s.size);
        System.arraycopy(t.data, 0, s3.data, s.size, t.size);
        s3.size = s.size + t.size;
        return s3;
    }

    public double getCurrent() {
        if (isCurrent() == true && currentIndex != -1)
            return data[currentIndex];
        else
            throw new IllegalStateException("There is no Current Element");
    }

    public DoubleArraySeq clone() {
        DoubleArraySeq answer;
        try {
            answer = (DoubleArraySeq) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("This class Doesn't implement Cloneable");
        }
        answer.data = data.clone();
        return answer;
    }

    public boolean isCurrent() {
        boolean answer = false;
        if (currentIndex <= data.length)
            answer = true;
        return answer;
    }

    public String printArray(double pattern) {
        String sequence = "element:";

        for (int currentIndex = 0; currentIndex < size; currentIndex++) {
            DecimalFormat formatter = new DecimalFormat("#0.0");
            double answer = data[currentIndex];
            sequence = sequence + formatter.format(answer) + " ";
        }
        return sequence;
    }

}