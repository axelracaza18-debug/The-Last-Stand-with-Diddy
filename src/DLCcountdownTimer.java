public class DLCcountdownTimer {

    public static void startCountdown(int seconds) {
            for (int i = seconds; i > 0; i--) {
                System.out.println("⏳ Vaccine progress: " + i + "s remaining");

                try {
                    Thread.sleep(1000); // 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("✅ Vaccine complete!");
        }

}
