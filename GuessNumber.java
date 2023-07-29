import java.util.Random;
import java.util.ArrayList;

class GuessNumber {
  private static GuessNumber self;
  private ArrayList<Integer> questionSet = new ArrayList<Integer>();

  private GuessNumber() {
  }

  public static GuessNumber getInstance() {
    if (self == null)
      self = new GuessNumber();
    return self;
  }

  public String getAnswer() {
    return String.valueOf(questionSet.get(0)) +
        String.valueOf(questionSet.get(1)) +
        String.valueOf(questionSet.get(2)) +
        String.valueOf(questionSet.get(3));
  }

  public void initQuestion() {
    Random random = new Random();
    Integer tmp = Integer.valueOf(random.nextInt(10));
    if (!questionSet.contains(tmp)) {
      questionSet.add(tmp);
      if (questionSet.size() < 4) {
        initQuestion();
      } else {
        return;
      }
    } else {
      initQuestion();
    }
  }

  public String getAB(String anwser) {
    int nA = 0;
    int nB = 0;

    for (int i = 0; i < 4; i++) {
      String c = String.valueOf(anwser.charAt(i));
      if (String.valueOf(questionSet.get(i)).contentEquals(c)) {
        nA++;
        continue;
      }

      if (questionSet.contains(Integer.valueOf(c))) {
        nB++;
      }
    }

    return nA + "A" + nB + "B";
  }
}