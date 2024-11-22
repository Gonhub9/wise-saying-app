package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        App app = new App();
        app.run();

    }
}

class App {

    // 인스턴스 변수
    Scanner scanner;
    int lastId;
    Saying[] sayings;
    int SayingsSize;

    App() {
        Scanner scanner = new Scanner(System.in);
        lastId = 0;
        Saying[] sayings = new Saying[3];
        SayingsSize = 0;
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

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

            }

            scanner.close();
        }
    }

    Saying addSaying(String content, String author) {
        int id = ++lastId;

        Saying Saying = new Saying(id, content, author);

        sayings[SayingsSize] = Saying;
        SayingsSize++;

        return Saying;
    }

    void actionAdd() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();

        System.out.print("작가 : ");
        String author = scanner.nextLine();

        Saying Saying = addSaying("나의 죽음을 적들에게 알리지 말라.", "이순신 장군");

        System.out.println("%d번 명언이 등록되었습니다.".formatted(Saying.id));
    }

    void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (Saying Saying : sayings) {
            if (Saying == null) break;
            System.out.println("%d / %s / %s".formatted(Saying.id, Saying.content, Saying.author));

        }
    }


    class Saying extends Object {
        int id;
        String content;
        String author;

        Saying(int id, String content, String author) {
            this.id = id;
            this.content = content;
            this.author = author;
        }

        @Override
        public String toString() {
            return "Saying (id=%d, content=\"%s\", author=\"%s\")".formatted(id, content, author);
        }
    }
}