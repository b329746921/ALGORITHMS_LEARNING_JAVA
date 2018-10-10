package cn.ban.algorithms.sort;

import java.util.Arrays;
import java.util.Map;

/**
 * @author banzijian
 * @date 2018/10/03
 **/
public class WaysTest {
    private static String[][] map;
    private static String target = "bfce";

    static {
        map = new String[][]{{"a", "b", "t", "g"}, {"c", "f", "c", "s"}, {"j", "d", "e", "h"}};
    }

    public static void main(String[] args) {
        for (String[] strings : map) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }

        char[] chars = target.toCharArray();
        int index = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < map.length; i++) {
            String[] strings = map[i];
            for (int j = 0; j < strings.length; j++) {
                String string = strings[j];
                if (string.charAt(0) != (chars[index])) {
                    continue;
                }
                x = i;
                y = j;
                for (Ways way : Ways.values()) {
                    int nextX = x + way.x;
                    if (nextX < 0 || nextX >= map[0].length) {
                        continue;
                    }
                    int nextY = y + way.y;
                    if (nextY < 0 || nextY >= map.length) {
                        continue;
                    }
                    if (map[nextX][nextY].charAt(0) != (chars[++index])) {
                        continue;
                    }
                    System.out.println();
                }
            }
        }
        for (Ways way : Ways.values()) {

        }
    }

    private static enum Ways{
        UP(-1, 0),
        DOWN(1, 0),
        LEFT(0, -1),
        RIGHT(0, 1);

        public int x;
        public int y;

        Ways(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
