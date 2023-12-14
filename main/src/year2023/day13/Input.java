package year2023.day13;

public class Input {
    public static final String[] TEST = """
            #.##..##.
            ..#.##.#.
            ##......#
            ##......#
            ..#.##.#.
            ..##..##.
            #.#.##.#.

            #...##..#
            #....#..#
            ..##..###
            #####.##.
            #####.##.
            ..##..###
            #....#..#
            """.split("\n\n");
    public static final String[] INPUT = """
            .#.##.#.##..###
            ...##...#######
            #.####.#.#.###.
            #..##..##..#...
            ###..###....###
            .##..##..#.#...
            .#....#..######
            #..##..########
            ########.#..#..

            .#.###.###..###.#
            ..#...##########.
            ..######.#..#.###
            ..##.#.#......#..
            ..#.##....##....#
            .##..#.##.##.##.#
            #.....####..####.
            #.....####..####.
            .##..#.##.##.##.#

            ####.####.#
            #..#.#..#.#
            #..#.####.#
            ####.#..#.#
            .##.##..##.
            ######..###
            #####.##.##
            #..########
            ......##...
            .##........
            #####....##
            ######..###
            ..#.#.##.#.
            ######..###
            .##...##...
            #..#.####.#
            ######..###

            .##..#.##
            .##.####.
            ####.....
            .##...##.
            .##.#.###
            #####..##
            .##.#.##.
            ....#.###
            ####.####
            #..###..#
            .#..#####
            #..#.#...
            .....##..
            #####.###
            #####.###

            .##..##.#####
            .#.##.#..#..#
            ##....###.##.
            #......###..#
            .#.##.#......
            ...##.....##.
            #......#...#.
            .#....#......
            #......#.####
            #.#..#.#..##.
            #..##..######

            ..#..#..#..##..#.
            ...##...#...##.##
            ...##...#...##.##
            ..#..#..#..##..#.
            ..#..#...##.#####
            ..#..#..###...###
            ##.##.##..##...##
            #..##..##.#....##
            #.....###.#.##..#
            ...............##
            ########.#......#

            ..#.##....##.#.
            ###.########.##
            #...##....##...
            #####..##..####
            .#..########.##
            ..##.##..##.##.
            .###.######.###
            #.##...##...##.
            #.##...##...##.

            .###.##
            ####..#
            ####..#
            .###.##
            ..#..#.
            ##.....
            ##..#..
            ..#..#.
            .###.##

            #..####
            #.#####
            ...#...
            ..##...
            ##....#
            ##....#
            ..##...
            ...#...
            #.#####
            #..####
            .....##

            #....#.##
            ...##.#.#
            ###..#...
            #....#.##
            ######...
            ..##.##..
            ..#...#.#
            ..#...#.#
            ..##.##..
            ######...
            #....#.##
            ###..#...
            ...##.#.#
            #...##.##
            #...##.##

            ##.###..#
            ##.##.##.
            ..##..#..
            ..#..##.#
            ..#..##.#
            ..##..#..
            ##.##.##.
            ##.###..#
            ......##.
            .#######.
            ##.#.###.

            .#.....
            ..#####
            ####..#
            ...####
            ##.#..#
            #.##..#
            .#.#..#
            #..####
            #.##..#
            ..##..#
            #..####

            ....#.#
            #..#..#
            .##..##
            .##..##
            #..#..#
            ....#..
            .##.#.#
            #####..
            ....##.
            ####...
            .....##
            #..##..
            .##...#
            #..#...
            .##...#

            ..##...#.#.##....
            #.####.###.##..##
            #.####.###.##..##
            ..#....#.#.##....
            .#..#..#....#.#.#
            ###..#..##.#####.
            ##..#..####..#.#.
            ..###.#..##.#.##.
            ...##.######.....
            ..#...##.#.#...#.
            ....#...###.#....
            ....#...###.#....
            ..#...##.#.#...#.

            ##..##.#.##
            ##..##.#.##
            #######..#.
            .####..#...
            #.##.#..#.#
            .#..#.#....
            ##..##.#.#.
            .####...#..
            .####.#.###
            ..###...###
            ######..#.#
            .####.##.#.
            #.##.#.#.##
            .####.#####
            #######..##

            #.##...##
            ...####.#
            ####..###
            ###.###.#
            .#.#####.
            .#.#####.
            ###.###.#
            ####..###
            ...####.#
            #.##...##
            #.#.#.###
            #..####..
            ##.####..

            ..###.....##.
            ##....##..###
            ##....#....##
            ####.....#.#.
            ...########..
            ##...#..##.#.
            ...#.#.###..#
            ######.##..#.
            ##....#...#.#
            ...#####.##.#
            #####.#...##.
            ..#.######...
            ####.##...##.
            ###.##..#.#..
            ###.##.##.#..

            ##.#...########
            .#..##.#.......
            .#.#.....#.##.#
            .##..#.###.##.#
            #.#####.##.##.#
            .##.###.#......
            .##.###.#......
            #.#####.##.##.#
            .##..#.###.##.#
            .#.#.....#.##.#
            .#..##.#.......
            ##.#...########
            ###.....###..##
            .#.#.#.......#.
            ####.###..#..#.
            ##.##.##..####.
            #.#..#..#..##..

            #.#.....#..#...
            .#####.#.##.#.#
            .###.##.#..#.##
            #.#.###.#..#.##
            #.#####.#..#.##
            .###.##.#..#.##
            .#####.#.##.#.#
            #.#.....#..#...
            ...##.##....##.

            #......#.
            #.####.##
            ..####..#
            #......#.
            #......#.
            ..####..#
            #.####.##
            #......#.
            ########.
            ..#.##..#
            ##....##.
            .#....#..
            .##..##..

            ######.##.###
            ..##..#####.#
            .#....##.#.##
            .####..##..#.
            #######.#.###
            #######.#.###
            .####..##..#.

            .##.#..###..####.
            .##.#.####..####.
            #..#..#..###.#...
            #..#####.###.##.#
            #..###..##.####..
            #####.##...##....
            ####.#.#..###..##
            .##.#..#.#.#...#.
            #..#..####.###..#
            .##..##....#####.
            .##.............#
            .....########..##
            #..##.##..#.###.#

            ####.#..#.###
            ...#..##..#..
            ..#######.##.
            ##.#.#..#.#.#
            ...#.#..#.#..
            ##.#.#..#.#.#
            #####.##.####
            ##...#..#...#
            ......##.....
            ###.#.##.#.##
            ..###....###.
            ###...##...##
            ....######...
            ...#..##..#..
            ##.#.####.#.#

            .##.#..##.#.#.#..
            .##.#.##.########
            .....#.####.#####
            ####....##..###.#
            #..#..##..######.
            #######.###..#..#
            ####...#..#.....#
            .....##.#...###..
            .......##.##...#.
            ....#....#.#.####
            ......#..##.#..#.
            #..###....#...#.#
            #..#...##..##.###
            ....#...###....##
            .##....#..#.#...#
            ....#....#....#..
            ....#....#....#.#

            ..####..#####
            #########..##
            ##.##.####.#.
            ########..###
            ##....##.####
            ...##...#....
            ..#..#..#.#.#
            #.####.#.#.##
            ##....##.#...
            .........##.#
            ..####...#.#.
            ...##....#...
            ###..####.#..

            #..#.#..#.#
            #.###.##.##
            ..##.####.#
            .#..##..##.
            #.##..##..#
            .#.########
            ..#..#..#..
            ..#..#..#..
            .#.########
            #.##..##..#
            ....##..##.
            ..##.####.#
            #.###.##.##
            #..#.#..#.#
            #.###....##

            #...##..##..#
            ...##..####..
            .#.##........
            ###.#.##..##.
            ...##.#.##.#.
            .....#..##..#
            ...#.#..##..#
            ...##.#.##.#.
            ###.#.##..##.

            ####.######.#
            .#...........
            #.#.###..###.
            .........#...
            #............
            #..#.######.#
            #..#.######.#

            ####.###.##
            ###..#...##
            ###..#...#.
            ####.###.##
            #..#....#..
            ###...##.#.
            .##.##..#..
            #.##.#.##.#
            #..##.##.##
            ..#.###..##
            ......##.#.
            ..#.#.###.#
            #.##.####.#
            ..#.#######
            ..........#
            ..........#
            ..#.#######

            ..#.#..
            ##..#.#
            #...##.
            ..#.#..
            ...#.#.
            ....###
            #####..
            #####..
            ....###

            ..#..#..#.#.##.#.
            ..##.#..#.#.##.#.
            ..######.#......#
            #....##.####..###
            .#....#.##......#
            ..#.##.....#..#..
            .#.###..#.######.

            #####.#......
            .#.#.....#...
            #..##.#...#..
            #.#....#.....
            #....##..#.#.
            ##.#.####..##
            #..#.#.#.....
            #.####..##...
            .#....##.##..
            ..##...#.#.##
            ##..####.#.##
            ..#.#...#.#..
            ..#.#...#.#..

            #.##...##..
            ...#.......
            .###.#....#
            #.#.#.#..#.
            #.##.#....#
            ##..##.##.#
            ##..##.##.#
            #.##.#....#
            #.#.#.#..#.
            .###.#....#
            ...#.......
            #.##...##..
            ..#..#....#
            ##...#..#.#
            .###..####.
            ##..#.#..#.
            ##.#.#....#

            ..##..###
            ######.##
            ##...##..
            #.##.##..
            ##..###..
            .#..#....
            ..##..#..

            .###.###..##.
            .###.###..##.
            #.##..#...###
            ##..#..#...#.
            #..##.##..##.
            .......#..##.
            ##.##.##..#.#
            .#.##..###.##
            .#.##..###.##
            ##.##.##..#.#
            .......#.###.
            #..##.##..##.
            ##..#..#...#.
            #.##..#...###
            .###.###..##.

            .##..#..#..
            ###.##..##.
            ###.##..##.
            .##........
            ##.#..##..#
            ..##..##..#
            ##.#..##..#

            ....##..#.#.#.#.#
            ....##..#.#.#.#.#
            ######........###
            ####......###....
            .##.##.###..#####
            .......#.#..#..#.
            ####...##.#.##.#.
            #####.#..##.##..#
            #..#..##.....####
            ....#..#...###.##
            ....#....########
            .###.#...#####..#
            .##.#.##.#.....##

            .#.###.#.##.#
            ........#...#
            .#.##......##
            .#.##......##
            ........#...#
            .#.###...##.#
            #.#.#.#......
            ####....#.#.#
            .#.....####.#
            .#.#....####.
            .##.#.#...##.
            .#.##.##.....
            ..#...###..#.
            ###...#..##..
            ###...#..##..

            ###..#...
            .#.##....
            ##.##....
            ###..#...
            #...##.##
            ###......
            #....#.##
            .########
            ...####..

            ...........#..#.#
            #..####..##.#..#.
            #..####..##.#....
            ...........#..#.#
            ..#....#..#..##..
            #.#....#.##.#..##
            ..........#.#....
            #.#....#.#..#.#..
            .########.#.#.##.
            ..#.##.#...#...#.
            ..........#..#.##
            #..####..#..#.##.
            #.#....#.#.##.#..
            ##.#..#.#####.##.
            #..####..#.##..#.

            #.#.#.#..#.
            ###..######
            ##.....##..
            #.##.##..##
            .##..######
            ..#.#.#..#.
            ..#.#.#..#.
            .##..######
            ####.##..##
            ##.....##..
            ###..######
            #.#.#.#..#.
            ..##..####.

            #..#.#.#.
            #..#.#.#.
            ..#.#..#.
            .#..#....
            ..#######
            ..#######
            .#..#.#..
            ..#.#..#.
            #..#.#.#.

            ##..###...#
            #....##.#..
            ..##..#####
            ..##..#.#.#
            #.##.####..
            ######....#
            .#..#...#.#
            #....#.##.#
            .#..#....##
            .#..#....##
            #....#..#.#

            ...##.##.
            ..#..##.#
            #.###.###
            #.###.#.#
            .#.#...##
            ##...#...
            ##..##.##
            ##..##.##
            ##...#...
            .#.#...##
            #.###.#.#
            #.###.###
            ..#..##.#
            ....#.##.
            ....#.##.

            #....##.#
            #....####
            ##..##.##
            #.##.#..#
            #....##..
            .#..#..##
            #.##.#.##
            ##...####
            #.##.#.##
            #.##.#.##
            ##...####
            #.##.#.##
            .#..#..##
            #....##..
            #.##.#..#
            ##..##.##
            #....####

            #..#....##.##.#
            ....##..#..#.#.
            ....##..#..#.#.
            #..#....##.##.#
            #.######.#.##.#
            #......##.#..##
            ....###...#####
            ##...#.#...##..
            .#.......##..##
            .#.......##..##
            ##..##.#...##..
            ....###...#####
            #......##.#..##
            #.######.#.##.#
            #..#....##.##.#

            #...##...#..#
            #.####.#.####
            ..#...#..#..#
            #...#.#.##..#
            #..#..###.##.
            ...#....#....
            .###..#.##..#
            ..##.#.......
            ..##.#.......
            .###..#..#..#
            ...#....#....

            ##..##.#.#.
            .#.#.#.###.
            ####.##.#.#
            #######.#.#
            .#.#.#.###.
            ##..##.#.#.
            #.....#.#.#
            #.....#.#.#
            ##..##.#.#.
            .#.#.#.###.
            #######.#.#

            ......#
            .######
            .#..#..
            .#..#.#
            .####.#
            ......#
            ##..##.
            #....#.
            #.##.##
            #.##.##
            #....#.
            ##..##.
            ......#

            #.#.######.
            .#.##....##
            ####......#
            ...#.#..#.#
            ##...#..#..
            .#..######.
            #.#..#..#..
            ..#....#...
            .##..####..
            #.##.#..#.#
            #.###....##
            ..#........
            ..#........

            .####.####.##
            #.##.#....#.#
            .####......##
            .####..##..##
            #....#....#..
            ..##...##...#
            .......##....
            .#..#..#...#.
            ..##........#
            .#..#..##..#.
            #....##..##..
            ..##..####..#
            .####.#..#.##
            ......#..#...
            ##..###..###.

            .#..##.#.#.#..#.#
            ##.#.....#......#
            #.#..#.##.##..##.
            ....#...###.##.##
            .......#.##.##.##
            .......#.##.##.##
            ....##..###.##.##
            #.#..#.##.##..##.
            ##.#.....#......#
            .#..##.#.#.#..#.#
            #...###...#.##.#.
            .#.####..#.#..#.#
            ######...##.##.##

            ####....#####.#
            ####....#####.#
            #.###..###.###.
            #..........##..
            #..#.##....#..#
            ####.##.#######
            #..#.##.#..##..
            .##......##.#..
            ###..##..###..#

            ......##.##
            ####.##.###
            #..#####...
            .##.#.#.##.
            .##.#.#.##.
            #..#####...
            ####.##.###
            .....###.##
            #..#...##.#
            .##..##.#..
            ####....#..

            #..#..#.###.####.
            ###.##...##.....#
            ##.#........#..#.
            .....##..###.##.#
            ..#...#.##..#..#.
            .#....#######..##
            ......##.....##..
            #..###.##########
            .#..####.###....#
            ..#..##.#####..##
            .##.#.###.#.####.
            #.##..#..#.......
            .....##..##.#..#.
            .###...###..#..#.
            .###...###..#..#.

            .####..##..####
            ...###....###..
            #.#.##.##.##.#.
            ....#.#..#.#...
            #....######....
            #......##......
            ....#.#..#.#...

            ......####..###
            .#..#.#####.###
            #.##.#.........
            #.##.###.#..#.#
            .####..###..###
            ######..######.
            ..##......##...
            ##########..###
            .......#......#
            .#..#..##....##
            ......##.####.#
            ##..###........
            ......###....##
            .####....####..
            #.##.#..#....#.

            #####.#
            #.##..#
            ##.#.#.
            ###..#.
            ...#.#.
            ###.###
            ..#####
            ..#####
            ###.###

            ##.###.
            ###...#
            ##.....
            ..#...#
            ##.##.#
            ..#.###
            ..#..##
            ......#
            ......#
            ..#..##
            ..#.###
            ##..#.#
            ..#...#
            ##.....
            ###...#
            ##.###.
            ...###.

            ..##.###.#...##
            #.##.###.....##
            #.##.###.....##
            ...#.###.#...##
            .#....#...#.#..
            ..####..#####..
            ...######.##.##
            .#.#..#.#.#####
            .#...#..#......
            .#...##..######
            .#..#.####..#..

            #.##.#..#
            #.##.#..#
            ..#.#####
            ##.##.##.
            #.#.##.##
            .###.....
            ...##....

            ....#..#....###
            ##.#...##.#.###
            ###...#....#.##
            ..##.#...######
            ######.####.###
            .........##....
            #.##..######...

            ....##.
            #####.#
            ....#..
            ....##.
            #..##..
            .....#.
            #####.#
            #####.#
            .....#.
            #..##..
            ....###
            ....#..
            #####.#

            .##..#..#
            #.###.###
            .#..##..#
            ##.####..
            .#..##...
            ......#..
            ......#..
            .#..##...
            ##.####..
            .##.##..#
            #.###.###
            .##..#..#
            ....#..##
            ...###...
            .#..###.#
            .#..###.#
            ...###...

            .#....#.##...
            #......#.#.##
            #.####.###...
            ##########...
            .##..##......
            .#....#...###
            .##..##.##.##
            .##.###..##..
            ########.####
            ..####..##.##
            ...##...#..##
            .##..##...#..
            #.####.#..###
            ##....###.###
            .#....#.###..

            #..#####.#..#
            ###.##.######
            #........####
            .#.#..#.#....
            ..........##.
            #........#..#
            ##..##..#####
            #..#..#..#..#
            #.######.#..#

            .#..#.####.#..#
            ...#...##...#..
            #...##....##...
            ##..##.##.##..#
            ##..##.##.##..#
            #...##....##...
            ...#...##...#..
            .#..#.####.#..#
            ##.#........#.#
            .##.#.####.#.##
            ###..........##
            .##.########.##
            .#..##.##.##...
            ...#.#.##.#.#..
            .....#.##.#....
            ###.#......#.##
            #.###.#..#.###.

            #..#.#.##
            ....##.#.
            ....##.#.
            #..#...##
            .##.#..##
            .....#.##
            .##...#.#
            #..#....#
            ....####.

            #####..##.#
            #.#.#.#.#..
            ###.##.##..
            ##.##.#...#
            ...#..#.##.
            ...#..#.##.
            ##.##.....#
            ###.##.##..
            #.#.#.#.#..
            #####..##.#
            ####..#.#.#
            ####..#.#.#
            #####..##.#
            #.#.#.#.#..
            ###.##.##..

            ##.##.######.
            .######.##.##
            ##.##.######.
            ..#..#......#
            .#..#.#.##.#.
            #.#..#.#..#.#
            ###..########

            .#.#.#..##..#.#.#
            .###...#..#...###
            #..#.#..##..#.#..
            .#.#...####...#.#
            #.#....#.......#.
            #................
            ...#.#......#.#..
            ..#.####..####.#.
            ...#...####...#..
            #.#.##..##..##.#.
            .....#.####.#....
            #.##.#.####.#.##.
            .###..#....#..###
            .##..########..##
            .##..########..##
            .###..#....#..###
            #.##.#.####.#.##.

            #..#.#..#.#
            ..###.##..#
            #..#......#
            ###.######.
            #.##.####.#
            #.....##...
            #...#....#.
            ..#..#..#..
            #.#........
            .###..##..#
            .###..##..#
            #.#........
            ..#..#..#..
            #...#....#.
            #.....##...

            ..####..##.
            #.##.......
            ###.....##.
            .###.#..##.
            #...#......
            #.###..####
            ##..#.#####
            .#..#.#####
            #.###..####

            ......#####
            ####.##.##.
            ####.#.....
            ######...#.
            ....###.###
            .##.##.####
            .##..#.####
            ....###.###
            ######...#.
            ####.#.....
            ####.##.##.
            ......#####
            #..#.##.###
            ####.#..#..
            #..####.###

            ..##.##.##..##..#
            ..#.####.#..#.###
            #####..#####..###
            .#.##..##.#...#.#
            .#.##..##.#...#.#
            #####..#####..###
            ..#.####.#..#.###
            ..##.##.##..##..#
            ##..####..##.#..#
            #...#..#...#..#..
            ##..#..##.##.#...

            ...##..##...#..
            ##.####.##.#.##
            ...#.##.#####..
            ..#.####..#..##
            ..#########..#.
            ..#########..#.
            ..#.####..#..#.
            ...#.##.#####..
            ##.####.##.#.##
            ...##..##...#..
            ########...###.

            ####.#####.
            ...###....#
            ...#.....##
            ...#.....##
            ...###....#
            ####.#####.
            #....##.##.
            .....#.#..#
            .##..#.....
            .##..##....
            .....#.#..#
            #....##.##.
            ####.#####.
            ...###....#
            ...#.....##

            ####....##.####
            .....##.#..###.
            ##.##.#####....
            ##..###......##
            #.#..####.#.#.#
            ##..#.####.#...
            ##..#.####.#...
            #.#..####.#.#.#
            ##..###......##
            ##.##.#####....
            .....##.#..###.
            ####....##.####
            .#..####.##.###
            #.#.####..###.#
            #.######..###.#

            .#.#..#.#.#.##.#.
            .#.#..#.#.####.#.
            ...#..#.....###.#
            ####..######.##..
            ..........#.#..#.
            ..##..##..#...##.
            .###..###.##.#..#
            ...####...#.#..#.
            .#.####.#.###.#..
            #.#.##.#.###.#.#.
            .#.#..#.#.#..##..

            ###..###.
            ###...##.
            ..##.##.#
            .#..####.
            #..##.#..
            .#.##.#..
            .....#.#.
            .....#.##
            #.#.##.##
            #.#.##.##
            .....#.##
            .....#.#.
            .#.##.#..
            #..##.#..
            .#..####.

            ..#............#.
            ..##.###..###.##.
            ..##.##.##.##.##.
            ##.#####..#####.#
            ..##.##....##.##.
            .....#..##..#....
            ###.#.##..##.#.##
            ##.#.###..###.#.#
            ...#..##..##..#..
            ..#.#........#.#.
            #######.#########

            ###.....#.#.##.
            ..#..##.#.##..#
            ####.....###.##
            ..#.....#...#.#
            ..#.#...#.###.#
            ##.#..####.#..#
            ..#.#.#.###..#.
            ##.##..##..#.#.
            ##.##.###..#.#.

            ....#..#.
            ####....#
            .##......
            #.##.##.#
            #..##..##
            #..##..##
            #####..##

            .#.#.##
            ####...
            ###....
            ..#.#..
            ..#....
            ###....
            ####...
            .#.#.##
            #.##...
            .#.##..
            ..#..##
            #....##
            ...#.##
            .#...##
            .###...

            ###..###..#.#..
            .######..##.###
            ##########...##
            ..####..##.#...
            #.#..#.###.###.
            .##..#..#...##.
            ##.##.##.#..#..
            ##.##.###..##..
            ###..####.#.#.#
            ###..####.#.#.#
            ##.##.###..##..

            #.####.##
            .##..##.#
            #####.###
            ..#..#...
            ##....##.
            .######.#
            #..##..#.
            #.####.##
            ..#..#..#
            ...##....
            ..####...
            ..#..#..#
            ..#..#..#
            ..####...
            ...##....
            ..#..#..#
            #.####.##

            .#.##..#.#.....
            ..#.###.#####..
            ..#...#.#.##...
            ##.##..#.#..###
            ...#..##.###.#.
            ..##.#######.##
            ..##.#######.##
            ...#..##.###.#.
            ##.##..#.#..###
            ..#...#.#.##...
            ..#.###.#####..

            #.#########
            .#.#.#..#.#
            #.###.....#
            ##..#.##.#.
            .#..#.##.#.
            .###.#..#.#
            #...#.##.#.
            #...##..##.
            .#....##...
            #.#.#....#.
            #.#.#....#.

            #..#..#.#
            #..#..#.#
            ..#....#.
            ##..##.#.
            #.#.##.##
            .##...##.
            ##.###...
            #.####...
            ######...
            ##.###...
            .##...##.
            #.#.##.##
            ##..##.#.
            ..#....#.
            #..#..#.#

            #....#..#
            #.##.#...
            ##..##...
            ##..##...
            #.##.#..#
            #....#..#
            .####..#.
            .#..#...#
            ##..#####

            #...##...#....##.
            ..#.##.#..###....
            ..##..##..##.####
            ...####.....##..#
            #.######.#....###
            ###.##.####..#..#
            ##..##..##.##.##.
            #........##.#####
            ...........#.#..#

            .#.#..#..#.##
            .##.#...#####
            .##.#...#####
            .#.#..#..####
            #..#.....#...
            .####.##.#...
            ..#..###.#...
            #.##.##......
            ########.####
            #####..##.###
            #....#..#..##
            ..####...#.##
            ..#.#.##.#.##
            ...#.#.#.....
            #.#..#.##....
            ##.#.#.#..#..
            #.#####.#.#..

            ##.##.##.##.#
            ##.###..###.#
            .####.##.####
            #####.##.####
            ##.##.##.#..#
            #.#........#.
            #.#........#.

            ####.#.#.#..#
            .##.#.##.#..#
            .##...###.##.
            .##..##.##..#
            .....###.#..#
            ....#.#..####
            ######..#.##.
            ......##.....
            ####.#.#.#..#
            .##..##..####
            .##....#.....
            #####..#.....
            #...##..#....
            .##..########
            .##.#...#####
            #..######....
            .....##..#..#

            ###....##
            ..#.##.#.
            ..#..#.#.
            ....##...
            ##......#
            ...#..#..
            ###....##
            ..######.
            ..##..##.

            ##..##.######
            .####.#######
            .####.##.##.#
            .#..#..#.##.#
            ######.#....#
            ......#..##..
            ######.##..##
            .#..#...###..
            #....#.......
            #######.#..#.
            ..##....#..#.
            #....###....#
            ########.##.#

            #..#.##.#..
            #..#.##.#..
            #..#.#.##..
            #.#####.##.
            ####...####
            #..######.#
            .##.###..##
            #####.#.##.
            ....###..#.

            #..###.#.
            ...#...##
            ##...##..
            ###.###..
            ##...#.##
            ...###.##
            ...#.#.##
            ##...#.##
            ###.###..
            ##...##..
            ...#...##
            #..###.#.
            #..###.#.

            ####.####..##
            #.......#...#
            #.#......##.#
            #..##...#.###
            #..##...#.###
            #.#......##.#
            #.......#...#
            ####.####..##
            #.##..#######
            ....#..##.##.
            ..#...#...###
            ##.####.#####
            ##..###.#####

            ###.#.#
            ##...##
            #..##.#
            ##.#.##
            ..##...
            ..#.##.
            #####..
            #####..
            ..#.##.
            """.split("\n\n");
}
