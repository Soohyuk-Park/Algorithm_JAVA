package Sort;

import java.util.*;

public class JAVA5052{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for (int i = 0; i < testCase; i++) {
            int n = scanner.nextInt();
            String[] phoneBook = new String[n];
            for (int j = 0; j < phoneBook.length; j++) {
                phoneBook[j] = scanner.next();
            }
            solution(phoneBook);
        }
    }


    public static void solution(String[] phoneBook) {
        if (phoneBook.length <= 1) {
            System.out.println("YES");
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, phoneBook);
        Collections.sort(arrayList);
        for (int i = 0; i < arrayList.size() - 1; i++) {
            if (arrayList.get(i + 1).startsWith(arrayList.get(i))) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}

