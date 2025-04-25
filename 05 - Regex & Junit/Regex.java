//Basic Regex Problems
/*
Problem 1
import java.util.regex.*;

public class Regex {
    public static void main(String[] args) {
        String username = "user_123";
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        
        if (username.matches(regex)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
*/

/*
Problem 2
import java.util.regex.*;

public class Regex {
    public static void main(String[] args) {
        String licensePlate = "AB1234";
        String regex = "^[A-Z]{2}\\d{4}$";
        
        if (licensePlate.matches(regex)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
*/

/*
Problem 3
import java.util.regex.*;

public class Regex {
    public static void main(String[] args) {
        String hexColor = "#FFA500";
        String regex = "^#[0-9a-fA-F]{6}$";
        
        if (hexColor.matches(regex)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
*/

/*
Problem 4
import java.util.regex.*;
import java.util.*;

public class Regex {
    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org";
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
*/

/*
Problem 5
import java.util.regex.*;
import java.util.*;

public class Regex {
    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        String regex = "\\b[A-Z][a-z]*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
*/

/*
Problem 6
import java.util.regex.*;
import java.util.*;

public class Regex {
    public static void main(String[] args) {
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
*/

/*
Problem 7
import java.util.regex.*;
import java.util.*;

public class Regex {
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        String regex = "https?://[a-zA-Z0-9.-]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
*/

/*
Problem 8
import java.util.regex.*;

public class Regex {
    public static void main(String[] args) {
        String sentence = "This is an example with multiple spaces.";
        String regex = "\\s+";
        String result = sentence.replaceAll(regex, " ");
        System.out.println(result);
    }
}
*/

/*
Problem 9
import java.util.regex.*;

public class Regex {
    public static void main(String[] args) {
        String sentence = "This is a damn bad example with some stupid words.";
        String regex = "(damn|stupid)";
        String result = sentence.replaceAll(regex, "****");
        System.out.println(result);
    }
}
*/

/*
Problem 10
import java.util.regex.*;

public class Regex {
    public static void main(String[] args) {
        String ip = "192.168.1.1";
        String regex = "^([0-9]{1,3}\\.){3}[0-9]{1,3}$";
        
        if (ip.matches(regex)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
*/

/*
Problem 11
import java.util.regex.*;

public class Regex {
    public static void main(String[] args) {
        String cardNumber = "4111111111111111";
        String regex = "^4\\d{15}$";
        
        if (cardNumber.matches(regex)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
*/

/*
Problem 12
import java.util.regex.*;
import java.util.*;

public class Regex {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        String regex = "\\b(Java|Python|JavaScript|Go)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
*/

/*
Problem 13
import java.util.regex.*;
import java.util.*;

public class Regex {
    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";
        String regex = "\\$?\\d+\\.\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
*/

/*
Problem 14
import java.util.regex.*;
import java.util.*;

public class Regex {
    public static void main(String[] args) {
        String sentence = "This is is a repeated repeated word test.";
        String regex = "\\b(\\w+)\\b(?=.*\\b\\1\\b)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sentence);
        
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
*/

/*
Problem 15
import java.util.regex.*;

public class Regex {
    public static void main(String[] args) {
        String ssn = "123-45-6789";
        String regex = "^\\d{3}-\\d{2}-\\d{4}$";
        
        if (ssn.matches(regex)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
*/

// Extraction Problems

/*
Problem 4
import java.util.regex.*;
import java.util.*;

public class Exceptions {
    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org";
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
*/

/*
Problem 5
import java.util.regex.*;
import java.util.*;

public class Exceptions {
    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        String regex = "\\b[A-Z][a-z]*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
*/

/*
Problem 6
import java.util.regex.*;
import java.util.*;

public class Exceptions {
    public static void main(String[] args) {
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
*/

/*
Problem 7
import java.util.regex.*;
import java.util.*;

public class Exceptions {
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        String regex = "https?://[a-zA-Z0-9.-]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
*/

// Replace and Modify Strings

/*
Problem 8
import java.util.regex.*;

public class Exceptions {
    public static void main(String[] args) {
        String sentence = "This  is    an example   with multiple    spaces.";
        String regex = "\\s+";
        String result = sentence.replaceAll(regex, " ");
        System.out.println(result);
    }
}
*/

/*
Problem 9
import java.util.regex.*;

public class Exceptions {
    public static void main(String[] args) {
        String sentence = "This is a damn bad example with some stupid words.";
        String regex = "(?i)\\b(damn|stupid)\\b";
        String result = sentence.replaceAll(regex, "****");
        System.out.println(result);
    }
}
*/

// Advanced Problems

/*
Problem 10
import java.util.regex.*;

public class Exceptions {
    public static void main(String[] args) {
        String ip = "192.168.1.1";
        String regex = "^((25[0-5]|2[0-4]\\d|1?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|1?\\d\\d?)$";
        
        if (ip.matches(regex)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
*/

/*
Problem 11
import java.util.regex.*;

public class Exceptions {
    public static void main(String[] args) {
        String visa = "4111111111111111";
        String mastercard = "5111111111111111";
        String regex = "^(4\\d{15}|5\\d{15})$";
        
        System.out.println(visa.matches(regex) ? "Valid" : "Invalid");
        System.out.println(mastercard.matches(regex) ? "Valid" : "Invalid");
    }
}
*/

/*
Problem 12
import java.util.regex.*;
import java.util.*;

public class Exceptions {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        String regex = "\\b(Java|Python|JavaScript|Go)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
*/

/*
Problem 13
import java.util.regex.*;
import java.util.*;

public class Exceptions {
    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";
        String regex = "\\$?\\d+\\.\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
*/

/*
Problem 14
import java.util.regex.*;
import java.util.*;

public class Exceptions {
    public static void main(String[] args) {
        String sentence = "This is is a repeated repeated word test.";
        String regex = "\\b(\\w+)\\b(?=.*\\b\\1\\b)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sentence);
        Set<String> seen = new HashSet<>();
        
        while (matcher.find()) {
            seen.add(matcher.group());
        }
        
        for (String word : seen) {
            System.out.println(word);
        }
    }
}
*/

/*
Problem 15
import java.util.regex.*;

public class Exceptions {
    public static void main(String[] args) {
        String ssn = "123-45-6789";
        String regex = "^\\d{3}-\\d{2}-\\d{4}$";
        
        if (ssn.matches(regex)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
*/
package Regex;




