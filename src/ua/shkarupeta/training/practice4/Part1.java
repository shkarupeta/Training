package ua.shkarupeta.training.practice4;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Part1 {

    private static final String FILE_NAME = "resources\\practice4\\part1.txt";


    public static String getDatfile(String fileName) {
        StringBuilder part1InputStr = new StringBuilder();


        try {

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                part1InputStr.append(line + System.lineSeparator());
            }
            return part1InputStr.toString().trim();

        } catch (FileNotFoundException e) {
            System.err.println("Part1 FileNotFound");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Part1 IO Error");
            e.printStackTrace();
        }

        return part1InputStr.toString();
    }


    private static String reverseIfLenghMoreFour(String string){
        String[] araryWords = string.split(" ");
//        String[] araryWordsTMP = new String[araryWords.length];
        String reverse;
        StringBuffer sb  = new StringBuffer("");

//         (String str:araryWords)
            for (int i = 0; i <araryWords.length ; i++) {


            if (araryWords[i].length() >= 4) {
                reverse = new StringBuffer(araryWords[i]).reverse().toString();


                sb.append(reverse + " ");
            }else {
                sb.append(araryWords[i] + " ");
            }
            }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();

    }
//    public void convertStrToRev() {
//        Scanner s;
//        try {
//            s = new Scanner(new File(fileName);
//            StringBuilder sb = new StringBuilder();
//            while (s.hasNextLine()) {
//                sb.append(s.nextLine() + System.lineSeparator());
//                Pattern p = Pattern.compile("/^[À-ßà-ÿ\\w]{4,}");
//                Matcher m = p.matcher(sb);
//
//                while (m.find()) {
//                    sb.replace(m.start(), m.end(), );
//                }
//            }
//            System.out.println(sb.toString().substring(0, sb.length() - 2));
//            s.close();
//        } catch (FileNotFoundException e) {
//            System.out.println(fileName + " not found");
//        }
//    }


    public static void main(String[] args) {

        System.out.println(reverseIfLenghMoreFour(getDatfile(FILE_NAME)));

    }

}
