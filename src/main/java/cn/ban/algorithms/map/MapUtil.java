package cn.ban.algorithms.map;

/**
 * @author banzijian
 * @date 2018/11/20
 **/
public class MapUtil {

    private MapUtil() {}

    public static int[][] getAroundCoordinate() {
        return new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    }
}
