package main.splitor;

import java.util.Arrays;

public class DefaultSplitor implements Splitor {

    private String separator = "[,:]";

    @Override
    public int[] split(String input) {
        return Arrays.stream(input.split(separator))
                    .mapToInt(Integer::parseInt)
                    .toArray();
    }
}
