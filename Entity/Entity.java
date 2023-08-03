package MrkimRefactoring.Entity;

// View에서 출력 받은 값 저장하는 데이터베이스

import MrkimRefactoring.View.View;

public class Entity {
    private int id;
    private String saying;
    private String writer;

    public int getId() {
        return id;
    }

    public String getSaying() {
        return saying;
    }

    public String getWriter() {
        return writer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSaying(String saying) {
        this.saying = saying;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
