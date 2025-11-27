public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
            "Our product will transform the market",
            "Programming is both painful and engaging",
            "This has nothing to do with machine learning",
            "We need to leverage our core competencies",
            "Let's talk about data and algorithms",
            "Chatbots are great but must be used carefully",
            "This blockchain-based solution will disrupt the industry",
            "The team showed great Synergy in the last project",
            "Use simple words without hype and fluff",
            "Our new technology presents a significant paradigm shift",
            "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations 
        String[] keywords = {"synergy", "disrupt", "leverage", "Paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    }

    /** Returns the lowercase version of the given string. */
    public static String lowerCase(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ((ch >= 'A') && (ch <= 'Z')) {
                ch = (char) (ch - 'A' + 'a');
                str = str.substring(0, i) + ch + str.substring(i+1);
            }
        }
        return str;
    }

    /** If str1 contains str2, returns true; otherwise returns false. */
    public static boolean contains(String str1, String str2) {
        if (str1.length() < str2.length()) return false;
        for (int i = 0; i < str1.length() - str2.length() + 1; i++) {
            if (str1.charAt(i) == str2.charAt(0)) {
                boolean isMatch = true;
                for (int j = 0; j < str2.length(); j++) {
                    if (str1.charAt(i + j) != str2.charAt(j)) {
                        isMatch = false;
                    }
                }
                if (isMatch == true) return true;
            }
        }
        return false;
    }

    // Iterates through all the sentences.
    // If a sentence contains one or more of the kewords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {
        String[] sentencesLowerCase = new String[sentences.length];
        for (int i = 0; i < sentences.length; i++) {
            sentencesLowerCase[i] = lowerCase(sentences[i]);
        }
        String[] keywordsLowerCase = new String[keywords.length];
        for (int i = 0; i < keywords.length; i++) {
            keywordsLowerCase[i] = lowerCase(keywords[i]);
        }
        for (int j = 0; j < sentencesLowerCase.length; j++) {
            for (int k = 0; k < keywordsLowerCase.length; k++) {
                if (contains(sentencesLowerCase[j], keywordsLowerCase[k])) {
                    System.out.println(sentences[j]);
                    break;
                }
            }
        }
    }
}
