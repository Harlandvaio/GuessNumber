
class Main {

  public static void main(String[] args) {
    GuessNumber.getInstance().initQuestion();
    String answer = GuessNumber.getInstance().getAnswer();

    System.out.println(answer);

    System.out.println(GuessNumber.getInstance().getAB("1234"));
    System.out.println(GuessNumber.getInstance().getAB("5678"));
    System.out.println(GuessNumber.getInstance().getAB("9912"));
    System.out.println(GuessNumber.getInstance().getAB("971"));
    System.out.println(GuessNumber.getInstance().getAB("9912222"));
    System.out.println(GuessNumber.getInstance().getAB("aaaaa"));
    System.out.println(GuessNumber.getInstance().getAB(answer));

  }

}