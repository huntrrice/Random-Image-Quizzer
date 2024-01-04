public class QuizFunctions {
    /**
     * checks if chosen value is same as correct and returns true if it is
     */
    public static boolean check(String correct, String option) {
        if (correct.equals(option)) {
            return true;
        } else {
            return false;
        }
    }
}