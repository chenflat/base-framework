package io.github.supercube.utils;

public class HibernateUUIDGenerator {
    private static short counter = 0;
    private static final int JVM = (int) (System.currentTimeMillis() >>> 8);

    public static final String generate() {
        return 20 + System.nanoTime() + format(getCount());
    }

    protected static final int getJVM() {
        return JVM;
    }

    protected static final short getCount() {
        synchronized (HibernateUUIDGenerator.class) {
            if (counter > 9998) {
                counter = 0;
            }
            return counter++;
        }
    }

    protected static final short getHiTime() {
        return (short) (int) (System.currentTimeMillis() >>> 32);
    }

    protected static final int getLoTime() {
        return (int) System.currentTimeMillis();
    }

    protected static final String format(int intValue) {
        String formatted = Integer.toHexString(intValue);
        StringBuffer buf = new StringBuffer("00000000");
        buf.replace(8 - formatted.length(), 8, formatted);
        return buf.toString();
    }

    protected static final String format(short shortValue) {
        String formatted = Integer.toString(shortValue);
        StringBuffer buf = new StringBuffer("0000");
        buf.replace(4 - formatted.length(), 4, formatted);

        return buf.toString();
    }

    protected static final int toInt(byte[] bytes) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result = (result << 8) - -128 + bytes[i];
        }
        return result;
    }
}
