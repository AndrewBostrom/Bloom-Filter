/**
 * Created by Andrew on 4/5/2016.
 */
public class BloomFilter {

    int m;
    BitArray bitArray;

    // j = number of hash functions in BloomFilter
    int j = 15;

    public BloomFilter(int M) {
        if (M < 0) {
            throw new IllegalArgumentException("Array size cannot be negative");
        }
        else {
            bitArray = new BitArray(M);
            m = M;
        }
    }

    private int h1(String w) {
        int hash = 1;
        for (int i = 0; i < w.length(); i++) {
            if ((i % 2) == 0) {
                hash += w.charAt(i);
            }
        }
        if (hash > m) {
            return hash % m;
        }
        return hash;
    }

    private int h2(String w) {
        int hash = 7;
        for (int i = 0; i < w.length(); i++) {
            if ((i % 2) != 0) {
                hash += w.charAt(i);
            }
        }
        if (hash > m) {
            return hash % m;
        }
        return hash;
    }

    private int h3(String w) {
        int hash = 7;
        for (int i = 0; i < w.length(); i++) {
            if ((i % 2) == 0) {
                hash += w.charAt(i);
            }
        }
        if (hash*13 > m) {
            return (hash*13) % m;
        }
        if (hash*13 > m) {
            return (hash*13) % m;
        }
        return hash * 13;
    }

    private int h4(String w) {
        int hash = 1;
        for (int i = 0; i < w.length(); i++) {
            if ((i % 2) != 0) {
                hash += w.charAt(i);
            }
        }
        if (hash*17 > m) {
            return (hash*17) % m;
        }
        if (hash*17 > m) {
            return (hash*17) % m;
        }
        return hash*17;
    }

    private int h5(String w) {
        int hash = 7;
        for (int i = 0; i < w.length(); i++) {
            hash = hash + i + w.charAt(i);
        }
        if (hash > m) {
            return hash % m;
        }
        return hash;
    }

    private int h6(String w) {
        int hash = 0;
        for (int i = 0; i < w.length(); i++) {
            hash += w.charAt(i);
        }
        if (hash%5 > m) {
            return (hash%5) % m;
        }
        return hash % 5;
    }

    private int h7(String w) {
        int hash = 0;
        for (int i = 0; i < w.length(); i++) {
            hash += w.charAt(i);
        }
        if (hash > m) {
            return hash % m;
        }
        return hash;
    }

    private int h8(String w) {
        int hash = 0;
        for (int i = 0; i < w.length(); i++) {
            hash = hash * w.charAt(i);
        }
        if (hash%5 > m) {
            return (hash%5) % m;
        }
        return hash % 5;
    }

    private int h9(String w) {
        int hash = 0;
        int hash2 = 0;
        for (int i = 0; i < w.length(); i++) {
            if ((i % 2) == 0) {
                hash += w.charAt(i);
            }
            else {
                hash2 += w.charAt(i);
            }
        }
        if (hash*hash2 > m) {
            return (hash*hash2) % m;
        }
        if (hash*hash2 > m) {
            return (hash*hash2) % m;
        }
        return hash * hash2;
    }

    private int h10(String w) {
        int hash = 0;
        int hash2 = 0;
        for (int i = 0; i < w.length(); i++) {
            if ((i % 2) == 0) {
                hash += w.charAt(i);
            }
            else {
                hash2 += w.charAt(i);
            }
        }
        if ((hash*hash2)%6 > m) {
            return ((hash*hash2)%6) % m;
        }
        return(hash * hash2) % 6;
    }

    private int h11(String w) {
        int hash = 1;
        int hash2 = 2;
        for (int i = 0; i < w.length(); i++) {
            if ((i % 2) == 0) {
                hash += (w.charAt(i) * 2);
            }
            else {
                hash2 += (w.charAt(i) * 2);
            }
        }
        if (hash+hash2 > m) {
            return (hash+hash2) % m;
        }
        return hash + hash2;
    }

    private int h12(String w) {
        int hash = 1;
        int hash2 = 1;
        int hash3 = 1;
        for (int i = 0; i < w.length(); i++) {
            if ((i % 3) == 0) {
                hash += w.charAt(i);
            }
            else if ((i % 3) == 1) {
                hash2 += w.charAt(i);
            }
            else {
                hash3 += w.charAt(i);
            }
        }
        if ((hash*hash2 + hash3) > m) {
            return (hash*hash2 + hash3) % m;
        }
        return (hash * hash2) + hash3;
    }

    private int h13(String w) {
        int hash = 0;
        int hash2 = 0;
        int hash3 = 0;
        for (int i = 0; i < w.length(); i++) {
            if ((i % 3) == 0) {
                hash += w.charAt(i);
            }
            else if ((i % 3) == 1) {
                hash2 += w.charAt(i);
            }
            else {
                hash3 += w.charAt(i);
            }
        }
        if ((hash*hash2*hash3) > m) {
            return hash*hash2*hash3 % m;
        }
        return hash * hash2 * hash3;
    }

    private int h14(String w) {
        int hash = 0;
        int hash2 = 0;
        int hash3 = 0;
        for (int i = 0; i < w.length(); i++) {
            if ((i % 3) == 0) {
                hash += w.charAt(i);
            }
            else if ((i % 3) == 1) {
                hash2 += w.charAt(i);
            }
            else {
                hash3 += w.charAt(i);
            }
        }
        hash = (hash * hash2 * hash3) / w.length();
        if (hash > m) {
            return hash % m;
        }
        return hash;
    }

    private int h15(String w) {
        int hash = 1;
        int hash2 = 1;
        int hash3 = 1;
        for (int i = 0; i < w.length(); i++) {
            if ((i % 3) == 0) {
                hash += w.charAt(i);
            }
            else if ((i % 3) == 1) {
                hash2 += w.charAt(i);
            }
            else {
                hash3 += w.charAt(i);
            }
        }
        if ((hash2*hash3 + hash) > m) {
            return (hash2*hash3 + hash) % m;
        }
        return (hash2 * hash3) + hash;
    }

    public void add(String w) {
        bitArray.set(h1(w));
        bitArray.set(h2(w));
        bitArray.set(h3(w));
        bitArray.set(h4(w));
        bitArray.set(h5(w));
        bitArray.set(h6(w));
        bitArray.set(h7(w));
        bitArray.set(h8(w));
        bitArray.set(h9(w));
        bitArray.set(h10(w));
        bitArray.set(h11(w));
        bitArray.set(h12(w));
        bitArray.set(h13(w));
        bitArray.set(h14(w));
        bitArray.set(h15(w));
    }

    public boolean isIn(String w) {
        return (bitArray.get(h1(w)) & bitArray.get(h2(w)) & bitArray.get(h3(w)) & bitArray.get(h4(w)) & bitArray.get(h5(w))
                & bitArray.get(h6(w)) & bitArray.get(h7(w)) & bitArray.get(h8(w)) & bitArray.get(h9(w)) & bitArray.get(h10(w))
                & bitArray.get(h11(w)) & bitArray.get(h12(w)) & bitArray.get(h13(w)) & bitArray.get(h14(w)) & bitArray.get(h15(w)) );
    }

    public double accuracy() {
        return (Math.pow((1 - Math.pow(Math.E, (-j*850/m))), j));
    }
}
