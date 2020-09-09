public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = bf.readLine();

        int zero = 0, one = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (Integer.parseInt(String.valueOf(s.charAt(j))) == i) {
                    if (Character.getNumericValue(s.charAt(j)) == 0 && j == s.length() - 1) {
                        zero++;
                    } else if (Character.getNumericValue(s.charAt(j)) == 1 && j == s.length() - 1){
                        one++;
                    }
                    continue;
                } else if (j - 1 >= 0 && s.charAt(j - 1) == '0' && s.charAt(j) == '1') {
                    zero++;
                } else if (j - 1 >= 0 && s.charAt(j - 1) == '1' && s.charAt(j) == '0') {
                    one++;
                }

            }
        }
        if (zero > one) {
            bw.write(Integer.toString(one));
            bw.flush();
            bw.close();
        } else if (zero < one) {
            bw.write(Integer.toString(zero));
            bw.flush();
            bw.close();
        } else {
            bw.write(Integer.toString(one));
            bw.flush();
            bw.close();
        }
    }
}
