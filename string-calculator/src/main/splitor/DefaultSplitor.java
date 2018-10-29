package main.splitor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultSplitor implements Splitor {

    private String separator = "[,:]";

    @Override
    public int[] split(String input) {
        return Arrays.stream(input.split(separator))
                    .mapToInt(Integer::parseInt)
                    .toArray();
    }
}
