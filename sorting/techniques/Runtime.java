package sorting.techniques;

/**
 * A utility class to measure and display elapsed time.
 */
public class Runtime {
    private long startTime;
    private long endTime;

    /**
     * Starts the timer by capturing the current system time in nanoseconds.
     */
    public void start() {
        startTime = System.nanoTime();
    }

    /**
     * Stops the timer by capturing the current system time in nanoseconds.
     */
    public void stop() {
        endTime = System.nanoTime();
    }

    /**
     * Calculates the duration of elapsed time.
     *
     * @return The duration in nanoseconds.
     */
    public long getDuration() {
        return endTime - startTime;
    }

    /**
     * Converts a duration from nanoseconds to seconds.
     *
     * @param duration The duration in nanoseconds to be converted.
     * @return The duration in seconds.
     */
    public double convertToSeconds(long duration) {
        return (double) duration / 1e9; // Convert nanoseconds to seconds
    }

    /**
     * Returns a formatted string representation of the elapsed time.
     * If the end time is before the start time, it returns an error message.
     *
     * @return The formatted string showing the elapsed time.
     */
    public String getFormattedTime() {
        long duration = getDuration();
        if (duration < 0) {
            return "Error: End time is before start time";
        } else {
            double seconds = convertToSeconds(duration);
            return "Elapsed time: " + seconds + " seconds";
        }
    }

    /**
     * Displays the elapsed time in the console.
     * If the end time is before the start time, it prints an error message.
     */
    public void display() {
        long duration = getDuration();
        if (duration < 0) {
            System.out.println("Error: End time is before start time");
        } else {
            System.out.println(getFormattedTime());
        }
    }
}
