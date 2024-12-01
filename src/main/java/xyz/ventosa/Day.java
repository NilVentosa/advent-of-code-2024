package xyz.ventosa;

import java.io.File;
import java.util.List;

public abstract class Day {
    protected List<String> input;

    public Day(String inputFile){
        var dayName = this.getClass().getSimpleName();
        this.input = Utils.getInput(dayName + File.separator + inputFile);
    }

    public abstract Object part1();
    public abstract Object part2();
}
