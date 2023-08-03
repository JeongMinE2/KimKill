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

    public void register() {
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

    public void list() {
        view.outputln("번호 / 명언 / 작가");

        for (int i = 0; i < list.size(); i++) {
            view.outputln(list.get(i).getId() + " " + list.get(i).getSaying() + " " + list.get(i).getWriter());
        }
    }

    public void del() {
        view.outputln("삭제할 정보 id를 입력해주세요.");
        view.output("명령) ");

        int del = Integer.parseInt(mrScanner.input());

        // list.set을 하면 삭제한 목록 재삭제 했을 때 목록에 출력하는 부분에서 에러가 뜬다.
        try {
            if (list.get(del - 1) != null) {
                list.remove(del - 1);
            }
        } catch (IndexOutOfBoundsException e) {
            view.outputln(del + "번 명언은 존재하지 않습니다.");
        }
    }

    public void update() {
        view.outputln("수정할 정보 id를 입력해주세요.");
        view.output("명령) ");

        int del = Integer.parseInt(mrScanner.input());

        view.outputln("명언(기존) : " + list.get(del-1).getSaying());
        view.output("명언 : ");
        String reSaying = mrScanner.input();
        view.outputln("작가(기존) : " + list.get(del-1).getWriter());
        view.output("작가 : ");
        String reWriter = mrScanner.input();

        view.outputln(reSaying);
        view.outputln(reWriter);

        for (int i = 0; i < list.size(); i++) {
        }
    }
}
