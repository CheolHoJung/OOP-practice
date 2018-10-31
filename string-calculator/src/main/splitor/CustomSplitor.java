package main.splitor;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSplitor implements Splitor {

    final String REGEX_FOR_SEPARATOR = "\\/\\/(.)\n(.*)";

    @Override
    public int[] split(String input) {
        Matcher matcher = matching(input);
        String separator = matcher.group(1);
        String inputReplaced = matcher.group(2);
        return Arrays.stream(inputReplaced.split(separator))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private Matcher matching(String input) {
        Matcher matcher = Pattern.compile(REGEX_FOR_SEPARATOR).matcher(input);
        if (!matcher.find()) throw new RuntimeException();
        return matcher;
    }
}
