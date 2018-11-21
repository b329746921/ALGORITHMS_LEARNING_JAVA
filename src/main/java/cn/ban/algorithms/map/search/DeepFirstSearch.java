package cn.ban.algorithms.map.search;

import cn.ban.algorithms.map.MapUtil;

/**
 * @author banzijian
 * @date 2018/11/20
 **/
public class DeepFirstSearch {
    private static int[][] map;
    private static int[][] book;
    private static int[] target;

    static {
        target = new int[]{4, 2};
        map = new int[][]{
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 1}
        };
        book = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
    }

    public static int findTargetMinStep(){
        return findTargetMinStep(0, 0, 0);
    }

    private static int findTargetMinStep(int i1, int i2, int step){
        if (map[target[0]][target[1]] == 1) {
            System.out.println("到不了这里哦");
            return -1;
        }
        if (i1 == target[0] && i2 == target[1]) {
            return step;
        }
        int minStep = -1;
        int[][] coordinates = MapUtil.getAroundCoordinate();
        for (int[] coordinate : coordinates) {
            int ti1 = i1 + coordinate[0];
            int ti2 = i2 + coordinate[1];
            if (ti1 < 0 || ti1 >= 5 || ti2 < 0 || ti2 >= 4) {
                continue;
            }
            int location = map[ti1][ti2];
            int locationBook = book[ti1][ti2];
            if (location == 0 && locationBook == 0) {
                book[ti1][ti2] = 1;
                int currentStep = findTargetMinStep(ti1, ti2, step + 1);
                if (minStep == -1) {
                    minStep = currentStep;
                } else if(currentStep != -1){
                    minStep = Math.min(currentStep, minStep);
                }
                book[ti1][ti2] = 0;
            }
        }
        return minStep;
    }

    public static void main(String[] args) {
        System.out.println(findTargetMinStep());
    }
}
