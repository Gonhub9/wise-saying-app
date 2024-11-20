package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        App app = new App();
        app.run();

    }
}

class App {
    public void run() {
        System.out.println("== 명언 앱 ==");

        ArrayList<Saying> sayings = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        int lastId = 1;

        while ( true ) {
            System.out.print("명령 ) ");
            String cmd = scanner.nextLine();

            // 종료
            if (cmd.equals("종료")) {
                break;

            // 등록
            } else if (cmd.equals("등록")) {

                System.out.print("명언 : ");
                String content = scanner.nextLine();

                System.out.print("작가 : ");
                String author = scanner.nextLine();

                // 클래스 불러오기
                Saying saying = new Saying(lastId++, content, author);

                // 리스트 추가
                sayings.add(saying);

                System.out.println(saying.id + "번 명언이 등록되었습니다.");

            // 목록
            } else if (cmd.equals("목록")) {

                // 목록에 아무 것도 없으면
                if (sayings.isEmpty()) {
                    System.out.println("등록된 명언이 없습니다.");

                } else {
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");

                    // 리스트 역순
                    for (int i = sayings.size() - 1; i >= 0; i--) {
                        Saying saying = sayings.get(i);
                        System.out.printf("%d / %s / %s \n", saying.id, saying.content, saying.author);
                    }
                }

            // 삭제
            } else if (cmd.equals("삭제?id=")) {
                sayings.remove(cmd.equals(""));





            } else {
                System.out.println("알 수 없는 명령어입니다.");
            }
    }
        scanner.close();
}

class Saying {
    int id;
    String content;
    String author;

    Saying(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
        }
    }
}

