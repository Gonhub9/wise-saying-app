package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    // 인스턴스 변수
    private final Scanner scanner;
    private int lastId;
    private final List<Saying> Sayings;

    public App() {
        scanner = new Scanner(System.in);
        lastId = 0;
        Sayings = new ArrayList<>();
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        makeSampleData();

        while (true) {
            System.out.print("명령 ) ");
            String cmd = scanner.nextLine();

            // 종료
            if (cmd.equals("종료")) break;

                // 등록
            else if (cmd.equals("등록")) {
                actionAdd();

                // 목록
            } else if (cmd.equals("목록")) {
                actionList();

            } else if (cmd.startsWith("삭제")) { // 완벽하게 일치하지 않더라도 눈치껏 행동하겠다
                String id = cmd.substring(6);
                actionDelete(Integer.parseInt(id));
            }

        } scanner.close();
    }

    private void makeSampleData() {
        addSaying("나의 죽음을 적들에게 알리지마라.", "이순신 장군");
        addSaying("삶이 있는 한 희망은 있다.", "키케로");
    }

    private Saying addSaying(String content, String author) {
        int id = ++lastId;

        Saying Saying = new Saying(id, content, author);

        Sayings.add(Saying);

        System.out.println(("Saying = " + Sayings));

        return Saying;
    }

    // 액션 함수들

    private void actionAdd() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();

        System.out.print("작가 : ");
        String author = scanner.nextLine();

        Saying saying = addSaying(content, author);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(saying.getId()));
    }

    private void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (Saying saying : Sayings.reversed()) {
            System.out.println("%d / %s / %s".formatted(saying.getId(), saying.getContent(), saying.getAuthor()));
        }
    }

    private void actionDelete(int id) {
        boolean removed = Sayings.removeIf(saying -> saying.getId() == id);

        if (removed) System.out.println("%d번 명언이 삭제되었습니다.".formatted(id));
    }

}
