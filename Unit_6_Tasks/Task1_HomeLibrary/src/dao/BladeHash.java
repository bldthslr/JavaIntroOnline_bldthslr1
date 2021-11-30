package dao;

public class BladeHash {

    public static String bladeHash256(String password) {
        int k1 = 345123242;
        int k2 = 1584832931;
        int s1 = -0, s2 = 0, s3 = -0, s4 = 0, s5 = 0, s6 = 0, s7 = 0 ,s8 = 0;
        for (char c : password.toCharArray()) {
            s1 += (c * k1);
            s2 += (c * k2);
            s3 += (c+5) * -k1;
            s4 += (c-5) * -k2;
            s5 += (c * k1) + k2;
            s6 += (-c * k1) - k2;
            s7 += (c * k1 * k2);
            s8 += (c+5) * k2 * k1;
        }
        return Integer.toHexString(s1)  + Integer.toHexString(s2)  + Integer.toHexString(s3) +  Integer.toHexString(s4) +
                Integer.toHexString(s5)  + Integer.toHexString(s6)  + Integer.toHexString(s7) +  Integer.toHexString(s8);
    }
}
