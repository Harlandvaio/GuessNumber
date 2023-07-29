import java.util.Random;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

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
    if(!isAnswerOk(anwser))
        return "答案格式不合法";

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

    if(nA == 4) 
      return "SUCCESS";

    return nA + "A" + nB + "B";
  }

  // 確認答題的答案是合法的
  private boolean isAnswerOk(String anwser) {
    if(anwser.length() != 4) return false;

    if(!isNumeric(anwser)) return false;

    Set<String> stringSet = new HashSet<>();
    for(int i = 0; i < 4; i++) {
      stringSet.add(String.valueOf(anwser.charAt(i)));
    }

    // 數量不一樣表示有資料重複
    if(stringSet.size() != anwser.length())
      return false;

    return true;
  }

  private boolean isNumeric(String str) {
    return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
  }
}