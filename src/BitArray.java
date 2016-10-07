/**
 * Created by Andrew on 4/5/2016.
 */
public class BitArray {

    public int m;
    public int[] bitArray;

    public BitArray(int M) {
        if (M < 0) {
            throw new IllegalArgumentException("Array size cannot be negative");
        }
        else {
            bitArray = new int[M / 32];
            m = M;
        }
    }

    public boolean get(int n) {
        if ((n < 0) || (n >= m)) {
            throw new IndexOutOfBoundsException("Index cannot be negative or greater than M");
        }
        else {
            int a = bitArray[n/32];
            int index = n % 32;
            if (((1 << (31 - index)) & a) != 0) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    public void set(int n){
        if ((n < 0) || (n >= m)) {
            throw new IndexOutOfBoundsException("Index cannot be negative or greater than M");
        }
        else {
            int a = bitArray[n/32];
            int index = n % 32;
            bitArray[n/32] = ((1 << (31 - index)) | a);
        }
    }
}
