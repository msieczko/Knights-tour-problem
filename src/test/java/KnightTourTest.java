import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class KnightTourTest {
    private static final int MAX_TESTED_BOARD_SIZE = 12;
    private static final int MIN_TESTED_BOEARD_SIZE = 5;

    private int boardSize;
    private int startX;
    private int startY;

    @Parameters(name = "boardSize({0})   corner({1})")
    public static Collection<Object[]> data() {
        Integer list[][] = new Integer[4 * (MAX_TESTED_BOARD_SIZE - MIN_TESTED_BOEARD_SIZE + 1)][2];
        for (int i = 0, size = MIN_TESTED_BOEARD_SIZE - 1, corner; i < list.length; i++) {
            corner = i%4;
            if(corner == 0) ++size;
            list[i][0] = size;
            list[i][1] = corner;
        }
        return Arrays.asList(list);
    }

    // Corners:
    // |0| |1|
    // | | | |
    // |3| |2|
    public KnightTourTest(int boardSize, int corner) {
        this.boardSize = boardSize;
        switch (corner){
            case 0:
                startX = startY = 0;
                break;
            case 1:
                startX = 0;
                startY = boardSize - 1;
                break;
            case 2:
                startX = startY = boardSize - 1;
                break;
            case 3:
                startX = boardSize - 1;
                startY = 0;
                break;
        }
    }

    @Test
    public void solveKnightTourWrapper() {
        KnightTour knightTour = new KnightTour(boardSize);
        assertTrue(knightTour.solveKnightTourWrapper(startX, startY, true));
    }

}


