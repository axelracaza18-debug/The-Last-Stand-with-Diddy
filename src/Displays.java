public class Displays {

    public static void typewriter(String text) {
        try {
            for (char c : text.toCharArray()) {
                System.out.print(c);

                // Slow down on punctuation
                if (c == '.' || c == '!' || c == '?') {
                    Thread.sleep(900);
                } else {
                    Thread.sleep(100);
                }
            }
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
