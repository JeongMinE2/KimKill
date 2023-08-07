package MrkimRefactoring.MrScanner;

// 명언, 작자 입력만 받기

import java.util.Scanner;

public class MrScanner {
    private Scanner sc = new Scanner(System.in);

    private void MrScanner() {

    }

    private static class InnerMrScanner {
        private static final MrScanner Instance = new MrScanner();
    }

    public static MrScanner getInstance() {
        return InnerMrScanner.Instance;
    }

    public String input() {

        return sc.nextLine();
    }
}
