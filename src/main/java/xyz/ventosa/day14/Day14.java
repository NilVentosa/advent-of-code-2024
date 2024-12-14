package xyz.ventosa.day14;

import xyz.ventosa.Day;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day14 extends Day  {

    List<Robot> robots = new ArrayList<>();
    private static int X;
    private static int Y;

    public Day14(String inputFile) {
        super(inputFile);
        for (String line : input) {
            robots.add(Robot.fromInput(line));
        }
        if (robots.size() == 12) {
            X = 11;
            Y = 7;
        } else {
            X = 101;
            Y = 103;
        }
    }

    @Override
    public Object part1() {
        List<Robot> movedRobots = new ArrayList<>();
        for (Robot robot : robots) {
            movedRobots.add(robot.move(100));
        }
        movedRobots = movedRobots.stream().filter(robot -> robot.x != X/2 && robot.y != Y/2).toList();

        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        for (Robot robot : movedRobots) {
            if (robot.x < X / 2 && robot.y < Y / 2) {
                one++;
            } else if (robot.x < X / 2 && robot.y > Y / 2) {
                two++;
            } else if (robot.x > X / 2 && robot.y < Y / 2) {
                three++;
            } else {
                four++;
            }
        }
        return one * two * three * four;
    }

    @Override
    public Object part2() {
        List<Robot> movedRobots = new ArrayList<>();
        for (int i = 1; i < 10405; i++) {
            for (Robot robot : robots) {
                movedRobots.add(robot.move(1));
            }
            int one = 0;
            int two = 0;
            int three = 0;
            int four = 0;
            for (Robot robot : movedRobots) {
                if (robot.x < X / 2 && robot.y < Y / 2) {
                    one++;
                } else if (robot.x < X / 2 && robot.y > Y / 2) {
                    two++;
                } else if (robot.x > X / 2 && robot.y < Y / 2) {
                    three++;
                } else {
                    four++;
                }
            }

            int numRobots = robots.size()/2;
            if (one > numRobots || two > numRobots || three > numRobots || four > numRobots) {
                System.out.println(i);
                System.out.println(printRobots(movedRobots));
                return i;
            }


            robots = movedRobots;
            movedRobots = new ArrayList<>();

        }
        return 1;
    }

    record Robot(int x, int y, int dx, int dy) {
        public static Robot fromInput(String in) {
            String regex = "-?\\d+";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(in);
            List<Integer> digitGroups = new ArrayList<>();
            while (matcher.find()) {
                digitGroups.add(Integer.parseInt(matcher.group()));
            }
            return new Robot(digitGroups.get(0), digitGroups.get(1), digitGroups.get(2), digitGroups.get(3));
        }

        public Robot move(int seconds) {
            int newX = x + dx * seconds;
            if (newX > X || newX < 0) {
                newX = newX % X;
                if (newX < 0) {
                    newX += X;
                }
            }
            int newY = y + dy * seconds;
            if (newY > Y || newY < 0) {
                newY = newY % Y;
                if (newY < 0) {
                    newY += Y;
                }
            }
            return new Robot(newX, newY, dx, dy);
        }
    }

    String printRobots(List<Robot> robots) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                boolean found = false;
                for (Robot robot : robots) {
                    if (robot.x == j && robot.y == i) {
                        sb.append("#");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    sb.append(".");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
