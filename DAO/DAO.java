package MrkimRefactoring.DAO;

// 명언 종료, 등록, 목록 생성, 삭제, 삭제 시 존재하지 않는다는 메세지 나오게끔(예외 처리), 수정

import MrkimRefactoring.Entity.Entity;
import MrkimRefactoring.MrScanner.MrScanner;
import MrkimRefactoring.View.View;

import java.util.ArrayList;

public class DAO {
    ArrayList<Entity> list = new ArrayList<>();
    MrScanner mrScanner = new MrScanner();
    View view = new View();
    Entity entity = null;

    // 등록
    // 번호도 int로 입력 받게끔 했는데 문자열 입력 시 NumberFormatException 오류 떠서 예외 처리 했다.
    public void register() {
        try {
            view.output("번호 : ");
            int id = Integer.parseInt(mrScanner.input());
            view.output("명언 : ");
            String say = mrScanner.input();
            view.output("작가 : ");
            String writer = mrScanner.input();
            view.outputln(id + "번 명언이 등록되었습니다.");

            entity = new Entity();

            entity.setId(id);
            entity.setSaying(say);
            entity.setWriter(writer);

            list.add(entity);
        } catch (NumberFormatException e) {
            view.output("번호 : ");
            int id = Integer.parseInt(mrScanner.input());
            view.output("명언 : ");
            String say = mrScanner.input();
            view.output("작가 : ");
            String writer = mrScanner.input();
            view.outputln(id + "번 명언이 등록되었습니다.");

            entity = new Entity();

            entity.setId(id);
            entity.setSaying(say);
            entity.setWriter(writer);

            list.add(entity);
        }
    }

    // 목록
    public void list() {
        view.outputln("번호 / 명언 / 작가");
        view.outputln("----------------");

        // 목록 나오면 무조건 for문 써라 정민이 안 쓰면 죽음 뿐 ...
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                // list i번째를 뽑아 Id 값, Saying값, Writer값 준다.
                view.outputln(list.get(i).getId() + " " + list.get(i).getSaying() + " " + list.get(i).getWriter());
            }
        }
    }

    // 삭제
    public void del() {
        view.outputln("삭제할 정보 id를 입력해주세요.");
        view.output("명령) ");

        int del = Integer.parseInt(mrScanner.input());

        // list.set을 하면 삭제한 목록 재삭제 했을 때 목록에 출력하는 부분에서 에러가 뜬다. <- 이거 사실 어떻게 무슨 방법으로 했는지 까먹었다.
        // 없는 인덱스 번호 입력 시에 IndexOutOfBoundsException 오류 떠서 예외 처리 했다.
        try {
            // 입력받은 번호가 null이 아닐 시에 실행
            if (list.get(del-1) != null) {
                // 입력 받은 번호 리스트 삭제
                list.remove(del-1);

                // 입력 받은 번호 리스트에 null 값 추가
                list.add(del-1, null);
                view.outputln(del + "번 명언이 삭제 되었습니다.");
            }

            // 삭제가 돼서 null 값인 리스트일 경우
            else if (list.get(del-1) == null) {
                view.outputln(del + "번 명언은 존재하지 않습니다.");
            }
        } catch (IndexOutOfBoundsException e) {
            view.outputln(del + "번 명언은 존재하지 않습니다.");
        }
    }

    public void update() {
        view.outputln("수정할 정보 id를 입력해주세요.");
        view.output("명령) ");

        int up = Integer.parseInt(mrScanner.input());

        try {
            view.outputln("명언(기존) : " + list.get(up - 1).getSaying());
            view.output("명언 : ");
            String reSaying = mrScanner.input();
            view.outputln("작가(기존) : " + list.get(up - 1).getWriter());
            view.output("작가 : ");
            String reWriter = mrScanner.input();

            for (int i = up - 1; i < up; i++) {
                list.get(i).setSaying(reSaying);    // list i번째를 뽑아 reSaying 값을 Saying에 세팅
                list.get(i).setWriter(reWriter);    // list i번째를 뽑아 reWriter 값을 Writer에 세팅
            }
        }
        // 없는 인덱스 번호 입력 시 예외 처리
        catch (IndexOutOfBoundsException e) {
            view.outputln(up + "번 명언이 존재하지 않습니다.");
        }
        // null 값인 인덱스 번호 입력 시 예외 처리
        catch (NullPointerException e) {
            view.outputln(up + "번 명언이 존재하지 않습니다.");
        }
    }
}
