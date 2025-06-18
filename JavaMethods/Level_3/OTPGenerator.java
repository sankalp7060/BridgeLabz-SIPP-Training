import java.util.HashSet;

public class OTPGenerator {

    public static int generateOTP() {
        return 100000 + (int)(Math.random() * 900000);
    }

    public static boolean validateUniqueOTPs() {
        HashSet<Integer> otpSet = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            int otp = generateOTP();
            if (otpSet.contains(otp)) return false;
            otpSet.add(otp);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Generated OTPs:");
        for (int i = 0; i < 10; i++) {
            int otp = generateOTP();
            System.out.println(otp);
        }
        System.out.println("Are all OTPs unique? " + validateUniqueOTPs());
    }
}