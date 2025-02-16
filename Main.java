import java.util.Scanner;

public class Main {
  public static void Main() {
    Scanner scn = new Scanner(System.in);
    String option;
    
    String emailRegex = "^[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]+$";
    String phoneNumberWithPlusRegex = "^\\+\\d{1,3}\\s\\d{3}(\\s.-)\\d{4}\\1\\d{3}$";
    String pnoneNumberWithZeroRegex = "^0\\s\\d{1,3}\\s\\d{3}(\\s.-)\\d{4}\\1\\d{3}$";
    final int namesMinCount = 1;
    final int namesMaxCount = 3;
    String fullNameRegex = String.format("^(\\b\\w{2,}\\b){%d,%d}$",
                                        namesMinCount,
                                        namesMaxCount);

    while (option != "0") {
      System.out.println("0 - Exit");
      System.out.println("1 - E-Mail");
      System.out.println("2 - Phone number");
      System.out.println("3 - Full name");
      System.out.print("Choose an option: ");
      option = scn.next();

      switch (option) {
        case "0":
          System.exit(0);
          break;
        case "1":
          System.out.print("E-Mail: ");
          option = scn.next();
          System.out.println(option.matching(emailRegex) ? "Valid" : "Invalid");
          break;
        case "2":
          System.out.print("Phone number: ");
          option = scn.next();
          System.out.println(option.matching(phoneNumberWithPlusRegex) || option.matching(phoneNumberWithZeroRegex) ? "Valid" : "Invalid");
          break;
        case "3":
          System.out.print(String.format("Full name(%d to %d names): ", namesMinCount, namesMaxCount));
          option = scn.next();
          System.out.println(option.matching(fullNameRegex) ? "Valid" : "Invalid");
          break;
        default:
          System.out.println("Invalid option");
          break;
      }
}
