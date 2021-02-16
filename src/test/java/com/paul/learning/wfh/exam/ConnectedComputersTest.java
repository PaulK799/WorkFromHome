package com.paul.learning.wfh.exam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test the {@link ConnectedComputers}.
 */
@SpringBootTest
public class ConnectedComputersTest {

    @Test
    public void connectedComputersTest() {
        int[][] connections = {
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 2},
                {1, 3}
        };
        int operations = ConnectedComputers.makeConnected(6, connections);
        Assertions.assertEquals(2, operations);
    }

    @Test
    public void connectedComputersAllMappedTest() {
        int[][] connections = {
                {0, 1},
                {0, 2},
                {3, 4},
                {2, 3}
        };
        int operations = ConnectedComputers.makeConnected(5, connections);
        Assertions.assertEquals(0, operations);
    }

    @Test
    public void connectedComputersSmallMappedTest() {
        int[][] connections = {
                {0, 1},
                {0, 2},
                {1, 2}
        };
        int operations = ConnectedComputers.makeConnected(4, connections);
        Assertions.assertEquals(1, operations);
    }

    @Test
    public void connectedComputerComplexMappedTest() {
        int[][] connections = {
                {1, 5},
                {1, 7},
                {1, 2},
                {1, 4},
                {3, 7},
                {4, 7},
                {3, 5},
                {0, 6},
                {0, 1},
                {0, 4},
                {2, 6},
                {0, 3},
                {0, 2}
        };
        int operations = ConnectedComputers.makeConnected(12, connections);
        Assertions.assertEquals(4, operations);
    }

    @Test
    public void connectedComputerExtremelyLongMappedTest() {
        int[][] connections = {{17, 51}, {33, 83}, {53, 62}, {25, 34}, {35, 90}, {29, 41}, {14, 53}, {40, 84}, {41, 64}, {13, 68}, {44, 85}, {57, 58}, {50, 74}, {20, 69}, {15, 62}, {25, 88}, {4, 56}, {37, 39}, {30, 62}, {69, 79}, {33, 85}, {24, 83}, {35, 77}, {2, 73}, {6, 28}, {46, 98}, {11, 82}, {29, 72}, {67, 71}, {12, 49}, {42, 56}, {56, 65}, {40, 70}, {24, 64}, {29, 51}, {20, 27}, {45, 88}, {58, 92}, {60, 99}, {33, 46}, {19, 69}, {33, 89}, {54, 82}, {16, 50}, {35, 73}, {19, 45}, {19, 72}, {1, 79}, {27, 80}, {22, 41}, {52, 61}, {50, 85}, {27, 45}, {4, 84}, {11, 96}, {0, 99}, {29, 94}, {9, 19}, {66, 99}, {20, 39}, {16, 85}, {12, 27}, {16, 67}, {61, 80}, {67, 83}, {16, 17}, {24, 27}, {16, 25}, {41, 79}, {51, 95}, {46, 47}, {27, 51}, {31, 44}, {0, 69}, {61, 63}, {33, 95}, {17, 88}, {70, 87}, {40, 42}, {21, 42}, {67, 77}, {33, 65}, {3, 25}, {39, 83}, {34, 40}, {15, 79}, {30, 90}, {58, 95}, {45, 56}, {37, 48}, {24, 91}, {31, 93}, {83, 90}, {17, 86}, {61, 65}, {15, 48}, {34, 56}, {12, 26}, {39, 98}, {1, 48}, {21, 76}, {72, 96}, {30, 69}, {46, 80}, {6, 29}, {29, 81}, {22, 77}, {85, 90}, {79, 83}, {6, 26}, {33, 57}, {3, 65}, {63, 84}, {77, 94}, {26, 90}, {64, 77}, {0, 3}, {27, 97}, {66, 89}, {18, 77}, {27, 43}};
        int operations = ConnectedComputers.makeConnected(100, connections);
        Assertions.assertEquals(13, operations);
    }

    @Test
    public void connectedComputerSighMappedTest() {
        int[][] connections = {{0, 4}, {1, 6}, {2, 9}, {4, 7}, {0, 6}, {6, 9}, {4, 8}, {1, 4}, {4, 9}, {1, 8}, {2, 8}, {3, 4}, {0, 9}};
        int operations = ConnectedComputers.makeConnected(10, connections);
        Assertions.assertEquals(1, operations);
    }

    @Test
    public void connectedComputerSigherMappedTest() {
        int[][] connections = {{1, 4}, {0, 3}, {1, 3}, {3, 7}, {2, 7}, {0, 1}, {2, 4}, {3, 6}, {5, 6}, {6, 7}, {4, 7}, {0, 7}, {5, 7}};
        int operations = ConnectedComputers.makeConnected(11, connections);
        Assertions.assertEquals(3, operations);
    }

    @Test
    public void connectedComputerBiiiiiiiiggerMappedTest() {
        int[][] connections = {{63, 95}, {30, 57}, {33, 97}, {44, 60}, {86, 96}, {8, 86}, {63, 79}, {3, 60}, {12, 92}, {70, 74}, {15, 23}, {10, 35}, {49, 76}, {14, 90}, {48, 95}, {19, 84}, {14, 48}, {11, 15}, {64, 72}, {74, 93}, {25, 29}, {85, 97}, {47, 61}, {62, 64}, {79, 91}, {16, 35}, {83, 93}, {93, 99}, {17, 47}, {14, 96}, {23, 37}, {28, 42}, {1, 5}, {48, 87}, {13, 30}, {60, 65}, {62, 80}, {64, 69}, {23, 51}, {33, 49}, {17, 97}, {7, 25}, {10, 33}, {6, 88}, {3, 62}, {97, 99}, {60, 61}, {55, 71}, {11, 82}, {31, 40}, {29, 61}, {25, 59}, {30, 43}, {12, 54}, {65, 80}, {56, 61}, {10, 24}, {3, 93}, {62, 78}, {31, 86}, {5, 65}, {20, 83}, {43, 86}, {11, 95}, {34, 44}, {95, 98}, {3, 24}, {8, 69}, {43, 81}, {52, 95}, {12, 29}, {49, 65}, {13, 29}, {69, 91}, {19, 47}, {33, 71}, {52, 80}, {9, 57}, {54, 65}, {45, 90}, {1, 24}, {44, 88}, {38, 64}, {49, 67}, {12, 18}, {7, 36}, {28, 64}, {60, 64}, {48, 77}, {23, 95}, {5, 15}, {24, 62}, {8, 78}, {36, 65}, {70, 80}, {22, 24}, {48, 59}, {23, 45}, {81, 95}, {18, 97}, {26, 29}, {37, 80}, {26, 27}, {25, 39}, {62, 93}, {12, 56}, {33, 75}, {18, 48}, {52, 57}, {25, 94}, {61, 87}, {65, 89}, {55, 86}, {12, 88}, {34, 57}, {8, 72}, {12, 26}, {27, 92}, {84, 99}, {45, 85}, {7, 68}, {1, 12}, {12, 53}};
        int operations = ConnectedComputers.makeConnected(100, connections);
        Assertions.assertEquals(11, operations);
    }
}
