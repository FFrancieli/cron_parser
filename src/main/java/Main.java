import cronExpression.CronExpression;
import input.Input;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter cron expression");
        String cronStringExpression = new Input().readLineFromConsole();

        String[] cronFields = cronStringExpression.split(" ");

        CronExpression cronExpression = new CronExpression(cronFields[0], cronFields[1], cronFields[2], cronFields[3],
                cronFields[4], cronFields[5]);

        System.out.println(cronExpression.toString());
    }
}
