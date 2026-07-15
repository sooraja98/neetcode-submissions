class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            // conver the str into like 5*Hello
            sb.append(str.length());
            sb.append('*');
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i=0;
        while (i < str.length()) {
            int j=i;
                // Find the '#'
            while (str.charAt(j) != '*') {
                j++;
            }
            // Length of the string
            int len = Integer.parseInt(str.substring(i, j));
             // Move past '#'
            j++;

            // Extract the string
            list.add(str.substring(j, j + len));

            // Move to the next encoded string
            i = j + len;
        }
    return list;
    }
}
