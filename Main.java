
class Main {

  public static void main(String[] args) {
    GuessNumber.getInstance().initQuestion();
    String answer = GuessNumber.getInstance().getAnswer();

    System.out.println(answer);

    System.out.println(GuessNumber.getInstance().getAB("1234"));
    System.out.println(GuessNumber.getInstance().getAB("5678"));
    System.out.println(GuessNumber.getInstance().getAB("9012"));
  }

}