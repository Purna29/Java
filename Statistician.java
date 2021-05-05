public class Statistician {

    private double totalSum;
    private int count;
    private double smallestValue;
    private double largestValue;

    public Statistician() {
        clear();
    }

    public void next(double number) {
        count++;
        totalSum = totalSum + number;
        if (count == 1) {
            smallestValue = number;
            largestValue = number;
        } else {
            if (number < smallestValue) {
                smallestValue = number;
            }
            if (number > largestValue) {
                largestValue = number;
            }
        }

    }

    public static Statistician union(Statistician s, Statistician t) {
        if (s == null || t == null)
            throw new RuntimeException("Null Pointer Exception");

        Statistician result = new Statistician();
        result.addAll(s);
        result.addAll(t);
        return result;

    }

    public void addAll(Statistician t) {
        if (t.count <= 0) {
            return;
        } else if (count <= 0) {
            count = t.count;
            totalSum = t.totalSum;
            largestValue = t.largestValue;
            smallestValue = t.smallestValue;
        } else {
            count = count + t.count;
            totalSum = totalSum + t.totalSum;
            if (t.largestValue > largestValue) {
                largestValue = t.largestValue;
            }
            if (t.smallestValue < smallestValue) {
                smallestValue = t.smallestValue;
            }
        }

    }

    public boolean equals(Object obj) {
        if (obj instanceof Statistician) {
            Statistician s = (Statistician) obj;
            if ((count == s.count) && (totalSum == s.totalSum) && (smallestValue == s.smallestValue)
                    && (largestValue == s.largestValue)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        totalSum = 0;
        count = 0;
        smallestValue = 0;
        largestValue = 0;

    }

    public double maximum() {
        if (count == 0) {
            return Double.NaN;
        } else {
            return largestValue;
        }
    }

    public double minimum() {
        if (count == 0) {
            return Double.NaN;
        } else {
            return smallestValue;
        }
    }

    public double mean() {
        if (count == 0) {
            return Double.NaN;
        } else {
            return totalSum / count;
        }
    }

    public double sum() {
        return totalSum;
    }

    public int length() {

        return count;
    }
}
