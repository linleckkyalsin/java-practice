import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<User> users=List.of(
                new User("佐藤美咲", LocalDate.of(1990, 1, 1)),
                new User("鈴木太郎", LocalDate.of(1991, 2, 2)),
                new User("山田一郎", LocalDate.of(2003, 3, 3)),
                new User("鈴木花子", LocalDate.of(2002, 4, 4))
        );
        System.out.println("【すべてのユーザーを表示する】");
        users.forEach(user -> System.out.printf("名前: %s, 生年月日: %s\n",user.getName(),user.getBirthdate()));
        System.out.println("【すべてのユーザーを表示する。ただし生年月日はyyyy/MM/dd(E)形式で出力する】");
        users.forEach(user -> System.out.printf("名前: %s, 生年月日: %s年%s月%s日\n",user.getName(),user.getBirthdate().getYear(),user.getBirthdate().getMonthValue(),user.getBirthdate().getDayOfMonth()));
        System.out.println("【名前が鈴木で始まる人のみを表示する】");
        Stream<User> filterList = users.stream().filter(user -> user.getName().startsWith("鈴木"));
        filterList.forEach(user -> System.out.printf("%s\n",user.getName()));
    }
}