package year2024.day06;

public class Input {
    public static final String INPUT = """
            ................#.................#.#...........................#.#..................#............................................
            ..........#................#...........#...................#.#....................................................................
            ....#......#......#............#.#........#..........#.......#.......#...#........#..........#.........................#..........
            ..................#............#.....##...............#..#.....................#...........#......................................
            #.........#.............................................................#........#............#........#.....#...#...........#....
            .....#...#......#..................................................#........#..................#......#.......................#...
            #.................................................#......................#......#...................................#.............
            ...#.#...#.....................................#.......................#.........#..................................#....#........
            ..............................................#..............#...#...........##..........................#.......#............#...
            ........#.#.......#.................##.......................#..........#...........................#...#.........................
            .................#..............................#.................#............#....#.....#.......................................
            .................................................................#......#............#.#.#..................#.....................
            .#..........#......#...#.......#..........................#....................#.#.............................#..................
            ...............#.....##.......#..#...###......#......................#.................................#.#......#..#..............
            #.....................#......................................#..........#...............#........#...............#...#.#..........
            .......................................#..................#.........................#.............................................
            .......................#...............................................................#........................#...........#.....
            ......#....#..........................................................................................#..........#................
            ........#.......................................#..........................#.............##.........#............#.#.........#....
            ......#........#........................................................#..........................#..............................
            ....................#.................................................#.....................#......#..#...#....................#..
            ...........#....................##.....#...#............#...#......................................#.....#.......#.........#....#.
            #..............#.................#......#..................#...................#......#...........#...............................
            .......#.......#.........................................#.....#..#.................................................#..........#..
            ..#..................#.......................#..#..#...#..........................#.........#...##......#..........#.#..#.........
            ..#.........#....................#...........................#....................#..........................#................#..#
            ......#.....................................................#..#.......#.............#...................#......................#.
            .....#..................................................................#...#.....................#......................#.#......
            ......#..............#...................................#.......................#...................................#...##.......
            ...........#..........#....................................................................#........................#.............
            #.......................................#..........................#........#......#......................##......................
            .............#...#..........#......#..........#.#......................................................................#..........
            ........................................................#....#...#......##..........................#..........#..................
            .#...#.....#..........#....#...........................................#........#....................................#............
            ....#....................................##.......#...........................................#.......#...........................
            ...........#.............#........................................................#...#................#........#.................
            .....#.#........................................#....................#.........#..................................................
            .........#............#..............................#...#..............#...........................#...............#.....#.......
            ......................#........................................#.#..........#...#..#......................#.......................
            ##...........#..............#......#....................#..........................#.......................#.......#.......#......
            ....#..#.........................................................#.....#..#.........................................#.....#.......
            ....#......##................#......................................#.......................................#..................#..
            ..............................#............................#..................#.......#.......#..................#...#............
            ......................................................#............................#..............................................
            .......#.............................#......#.................................#...................................................
            ..................................................................................................................#...............
            .......................#.....#...........##........................................#..............................#...............
            ..........................#................................................................#..................#...................
            ..........................#..................#........#..............#.#..#...................##..................................
            ..................#............................................................................................#..................
            .......................#..........#...##................#.........................................................................
            ...............#.....................................#............................................#...............................
            ....#..................................................................................#........#.................................
            ..#................#.....................................................................#...#....................................
            ..........#.............#.........#......#................#......#.........#........#.......................#.....................
            ..........................................................................#.................................#.....#....#.#........
            ....#..........#......................................#......................................................#.......#....#.....#.
            .....#...............................#............................#........................................................#......
            .............................................................................#.......................#....................#..#....
            ................#.............................................................#...................................................
            .....#................#.......#....................#............#.......#.....#.................................#.................
            ...........................................................................................................#.#....................
            .....#...............................................#...................................................................#..#.....
            ................#..............................#.............#.#..............................................................#...
            ..#............#...................#..................................................................#...............#...#....#..
            ..........#...............#...............#............................................#......#...##........#..#..................
            ......#..###..........................................................................................#................#..........
            ..........#........#.....#.......................#.........................................#.#........#.#.........................
            .....#............................................................#.....#..........................#..............................
            ...............................................................#..............#........................................#..........
            .................................................#....#...#....................................#..#........................#......
            .................#..........#......#......................#.......#...................#.#.........................................
            .#............................................................................#..............#..............................#..#..
            ..#........#...#..........#.................#...#...................................................#...#............#............
            ...........#.......#..#...............................................................................#...........................
            .#.#..#...........##...................#...................................#...........#...............................#..........
            ......................................................................#............#.....................................#...#....
            ....#............#.#.#................#............#....#...#......#....................................................#.........
            .......................................................................................#.....................................#....
            .......................................#..................#........#................................................#.............
            .........................................#.....#..........#.......##..................................#................#..........
            ..............#.............#............#..........................................................#.............................
            .#...................#...#..........................................................#........#........#..........................#
            ..#..............................#.....................................#.................#.............#...........#..............
            .................................#........................#.#....#......#....................#....................................
            .#..................................................#.....#............................#..........#..................#.......#....
            .....................#.......................^............#...#...#..............#................#...............................
            .........#....................................#....................#...........#...........#..............#...................#...
            ............................#...........#....................#.............#.......#.......................#...#....#.............
            ............#.................#...........#..................................................................#............#.......
            ...........#....................#.................................................#......#.#....................#.................
            ..............................................................#..........#........#....#.........#................................
            ...............#.........#......#..........#.#.............................................................................#....#.
            ...............##...##..........................................................................................#.................
            ..........................#.#...........................#......................#...............#..................................
            .....#...#..................#...........#....#.........#............................#.............................................
            .........................................................................................#...................#...#................
            ............#.....................#...........#..................................................................#................
            .#.............................#............................#..........#......##...................................#.#............
            ............#.........................................#...............................................#.#....#....................
            .........................................................#..#.#...............#......#....#........#..........................#...
            ............................#..#.................#................................................................#...............
            ............................#.........................................................................#....#..#............#..#...
            ....#........#....#....#..#..............................#...#......................#.......................#............#........
            ..#...............#............................................................................................................#..
            #.......................#...#............#..................................................#.........................#...........
            .....#.................#..#.............................................#...................................................##....
            ...............#....................................#................#.........................#.#...........................#.#..
            .................#....#....#..............#....#.#....#...............#......................#...............#..................#.
            ...........#...............................................................................#....#.................#...............
            ...............#............................................###.#.#.#........#...................................#....#...........
            ................#.................#........#............#..............#.....................#.............#......................
            ....................................#.....................................................#....#..................................
            ..#..#.............#......#.#..................#........................................#..........#...#..........................
            ...............#........................#...............................#.............#...................#..#....#...............
            ......#...........................#..............................................#..............................#...............#.
            ...........#..............#................#....#..........#................#.......#..............#.........#.................#..
            ......#....................................................................................................#......................
            ...........#.............#...............#..........#....#.#...##..................#....................#.........................
            .......................................................#.#.....................................#..................#.......#.......
            ...............#...............#...........................................................................#..................#...
            ...............#......#.........#..................#.............................#..............................#.................
            ...............#..........#..#.......#.............#............................#.#............................#..................
            ..........#................................#..#...................................................................................
            ..#................#............#........#...................................#...............##.................##....#.......#...
            ..#.....................................................................#.............................................#.#.........
            #...#...#.......................##............#..............#.........#......................#........#.#........................
            ..............................#......#.......#.........#...#..#.......................................................#.#.........
            .#..................#.#................................#..........#.......#..........................#............................
            ...............#.....................#...#..........................................#..........#......#...........................
            """;
}