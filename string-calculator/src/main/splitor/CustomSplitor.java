package main.splitor;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CustomSplitor implements Splitor {

    String regex = "\\/\\/(.*)\n";

    @Override
    public int[] split(String s) {
        String separator = getSeparator(s);
        String inputReplaced = replace(s);
        return Arrays.stream(inputReplaced.split(separator))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private String replace(String s) {
        return s.replaceAll(regex, "");
    }

    private String getSeparator(String s) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        if (!m.find()) {
            return "";
        }
        return "\\" + m.group(1);
    }
}
