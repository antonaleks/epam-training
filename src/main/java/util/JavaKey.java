package util;

import static lombok.AccessLevel.PRIVATE;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.UtilityClass;

@FieldDefaults(level = PRIVATE, makeFinal = true)
@UtilityClass
public class JavaKey {

    @Getter
    static List<String> keys = List.of("abstract", "continue", "for", "new", "switch",
        "assert", "default", "goto", "package", "synchronized",
        "boolean", "do", "if", "private", "this",
        "break", "double", "implements", "protected", "throw",
        "byte", "else", "import", "public", "throws",
        "case", "enum", "instanceof", "return", "transient",
        "catch", "extends", "int", "short", "try",
        "char", "final", "interface", "static", "void",
        "class", "finally", "long", "strictfp", "volatile",
        "const", "float", "native", "super", "while");

    public static List<byte[]> getByteList() {
        List<byte[]> byteList = new ArrayList<>();
        for (String key : JavaKey.keys) {
            byteList.add(key.getBytes());
        }
        return byteList;
    }

    public static String findKeysInText(String text) {
        StringBuilder outText = new StringBuilder();
        for (String key : JavaKey.getKeys()) {
            int sum = 0;
            Pattern p = Pattern
                .compile("\\b" + key + "\\b", Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(text);
            while (m.find()) {
                sum++;
            }
            if (sum > 0) {
                System.out
                    .println("Ключевое слово " + key + " встречается в тексте " + sum + " раз");
                outText.append(key + " " + sum + "\n");
            }
        }
        return outText.toString();
    }
}
