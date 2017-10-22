import cronExpression.CronExpression;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter cron expression");
        String cronStringExpression = input.nextLine();

        input.close();

        String[] cronFields = cronStringExpression.split(" ");

        CronExpression cronExpression = new CronExpression(cronFields[0], cronFields[1], cronFields[2], cronFields[3],
                cronFields[4], cronFields[5]);

        System.out.println(cronExpression.toString());
    }
}
