package MrkimRefactoring.Controller;

// View에서 입력 받은 값으로 명언 시스템 구동

import MrkimRefactoring.MrScanner.MrScanner;
import MrkimRefactoring.View.View;
import MrkimRefactoring.DAO.DAO;

public class Controller {
    View view = new View();
    MrScanner mrScanner = new MrScanner();
    DAO dao = new DAO();

    public void run() {
        while (true) {
            view.output("명령) ");
            switch (mrScanner.input()) {
                case "종료":
                    return;
                case "등록":
                    dao.register();
                    break;
                case "목록":
                    dao.list();
                    break;
                case "삭제":
                    dao.del();
                    break;
                case "수정":
                    dao.update();
                    break;
            }
        }

    }
}
