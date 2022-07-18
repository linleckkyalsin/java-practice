import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        final String[] DAYS= new String[]{"月", "火", "水", "木", "金", "土", "日"};
        LocalDate defaultDate=LocalDate.of(2001,01,01);
        List<User> users=List.of(
                new User("佐藤美咲", LocalDate.of(1990, 1, 1)),
                new User("鈴木太郎", LocalDate.of(1991, 2, 2)),
                new User("山田一郎", LocalDate.of(2003, 3, 3)),
                new User("鈴木花子", LocalDate.of(2002, 4, 4))
        );

//      すべてのユーザーを表示する
        System.out.println("【すべてのユーザーを表示する】");
        users.forEach(user -> System.out.printf("名前: %s, 生年月日: %s\n", user.getName(), user.getBirthdate()));
//      すべてのユーザーを表示する。ただし生年月日はyyyy/MM/dd(E)形式で出力する
        System.out.println("【すべてのユーザーを表示する。ただし生年月日はyyyy/MM/dd(E)形式で出力する】");
        users.forEach(user -> System.out.printf("名前: %s, 生年月日: %s\n", user.getName(), user.getBirthdate().format(DateTimeFormatter.ofPattern("yyyy年MM月dd日(E)"))));
//      名前が鈴木で始まる人のみを表示する
        System.out.println("【名前が鈴木で始まる人のみを表示する】");
        users.stream().filter(user -> user.getName().startsWith("鈴木")).forEach(user -> System.out.printf("%s\n", user.getName()));
//      生年月日が2000年1月1日以降の人のみを表示する
        System.out.println("【生年月日が2000年1月1日以降の人のみを表示する】");
        users.stream().filter(user -> user.getBirthdate().isAfter(defaultDate)).forEach(user -> System.out.printf("名前: %s, 生年月日: %s\n", user.getName(), user.getBirthdate()));
//     （省略）
        System.out.println("（省略）");
        users.stream().filter(user -> user.getBirthdate().isAfter(defaultDate)).forEach(user -> System.out.printf("名前: %s, 生年月日: %s\n", user.getName(), user.getBirthdate().format(DateTimeFormatter.ofPattern("yyyy年MM月dd日(E)"))));
//     【生年月日の昇順に並び替えて表示する】
        System.out.println("【生年月日の昇順に並び替えて表示する】");
        users.stream().sorted(Comparator.comparing(User::getBirthdate)).collect(Collectors.toList()).forEach(user -> System.out.printf("名前: %s, 生年月日: %s\n", user.getName(), user.getBirthdate()));
//     【生年月日の降順に並び替えて表示する】
        System.out.println("【生年月日の降順に並び替えて表示する】");
        users.stream().sorted(Comparator.comparing(User::getBirthdate).reversed()).collect(Collectors.toList()).forEach(user -> System.out.printf("名前: %s, 生年月日: %s\n", user.getName(), user.getBirthdate()));
    }
}