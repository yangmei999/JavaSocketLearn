package com.company;

import com.sun.corba.se.impl.interceptors.CDREncapsCodec;
import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.org.apache.xpath.internal.operations.String;
import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;
import oracle.jrockit.jfr.settings.PresetFile;

import javax.sound.sampled.Line;
import java.util.*;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static jdk.nashorn.internal.objects.Global.print;

public class cloud {
    //86
    import java.util.*;
    import java.util.stream.Collectors;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        List<Integer> ids = toIntList(in.nextLine());
        List<Integer> scores = toIntList(in.nextLine());
        in.close();

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i<n; i++){
            Integer id = ids.get(i);
            Integer score = scores.get(i);
            List<Integer> list = map.getOrDefault(id, new LinkedList<>());
            list.add(score);
            map.put(id,list);
        }
        StringBuilder builder = new StringBuilder();

        map.entrySet()
            .stream()
                .filter(x -> x.getValue().size() >= 3)
                .sorted((o1,o2) -> {
                    Integer sum1 = sumT3(o1.getValue());
                    Integer sum2 = sumT3(o2.getValue());
                    if(sum1.equals(sum2)){
                        return o2.getKey() - o1.getKey();
                    }else{
                        return sum2 - sum1;
                    }
                })
                .map(Map.Entry::getKey)
                .forEach(x->builder.append(x).append(","));
        System.out.println(builder.substring(0, builder.length() - 1));
    }

    private static Integer sumT3(List<Integer> list) {
        list.sort(Integer::compareTo);
        int sum = 0;
        for (int i = list.size()-1; i<list.size()-3; i--) {
            sum += list.get(i);
        }
        return sum;
    }

    private static List<Integer> toIntList(String str){
        return Arrays.stream(str.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

//85  Ctrl 给定一系列键盘输入，输出最终屏幕上字母的数量
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String ops = sc.nextLine();
    sc.close();
    String[] list = ops.split(" ");

    StringBuilder builder = new StringBuilder();

    String choose = "";
    String tab = "";

    for(String op : list){
        switch(op){
            case "1":
                choose = reset(builder, choose);
                builder.append('A');
                break;
            case "2":
                if(!choose.isEmpty()){
                    tab = choose;
                }
                break;
            case "3":
                if(!choose.isEmpty()){
                    tab = choose;
                    choose = "";
                    builder = new StringBuilder();
                }
                break;
            case "4":
                choose = reset(builder, choose);
                builder.append(tab);
                break;
            case "5":
                if(builder.length() != 0) {
                    choose = builder.toString();
                }
                break;
                default;
                break;
        }
        System.out.println(builder);
        System.out.println(builder.length());
    }
    System.out.println(builder.length());
}

private static String reset(StringBuilder builder, String choose) {
        if(!choose.isEmpty()){
            builder.replace(0, choose.length(), "");
            choose = "";
        }
        return choose;
}


//84将卡片上的数字连起来计算组成的最大数字
public static void main(String[] args) {
    Scanner in  = new Scanner(System.in);
    String nums = in.nextLine();
    in.close();

    StringBuilder builder = new StringBuilder();

    Arrays.stream(nums.split(","))
            .sorted((s1,s2)->{
                char[] v1 = s1.toCharArray();
                char[] v2 = s2.toCharArray();
                int len1 = v1.length;
                int len2 = v2.length;

                if(len1 == len2){
                    return s2.compareTo(s1);
                }

                int min = Math.min(len1, len2);
                for (int i=0; i<min; i++){
                    char c1 = v1[i];
                    char c2 = v2[i];
                    if(c1 != c2) {
                        return c2-c1;
                    }
                }
                if(len1 > len2) {
                    return v1[0] - v1[min];
                }else{
                    return v2[min] - v2[0];
                }
            })
            .forEach(builder::append);
    System.out.println(builder);
}


    //82 输入字符串s中包含所有整数的最小和
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String line = in.nextLine();
    in.close();

    char[] chars = line.toCharArray();
    int sum = 0;

    for(int i=0; i<chars.length; i++){
        char c = chars[i];
        if(c == '-'){
            i++;
            int start = i;
            while(i<chars.length && Character.isDigit(chars[i])){
                i++;
            }
            String substring = line.substring(start, i);
            if(substring.length() > 0){
                sum -= Integer.parseInt(substring);
            }
            i--;
            continue;
        }

        if(Character.isDigit(c)){
            sum += Character.digit(c, 10);
        }
    }
    System.out.println(sum);
}


//81 程序员打了一辆出租车去上班
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    int ans = N, temp = 0, k=0, j=1;
    while (N > 0) {
        //先判断个位上是否跳了4，如果个位上是5~9，就先temp=1。
        if(N%10 > 4){
            temp += (N%10 -1)*k+j;
        }else{
            temp += (N%10) *k;
        }
        k = k * 9 + j;//k代表跳了多少次4，多收了多少个1元
        j *= 10;//j代表位数，1代表个位，10代表十位
        N /= 10;//相当于将N整体右移一位
    }
    System.out.println(ans - temp);
}

//80 输入n k ,求n!的第k个数
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int k = Integer.parseInt(in.nextLine());
        StringBuilder sb = new StringBuilder();

        List<Integer> candidates = new ArrayList<>();

        int[] factorials = new int[n+1];
        factorials[0] = 1;
        int fact = 1;
        for(int i=1; i<=n; ++i){
            candidates.add(i);
            fact *= i;
            factorials[i] = fact;
        }
        k -= 1;
        for (int i=n-1; i>=0; --i){
            //计算候选数学的index
            int index = k/factorials[i];
            sb.append(candidates.remove(index));
            k -= index * factorials[i];
        }
        System.out.println(sb);
    }


    //79 某学校举行运动会，学生按编号进行标识
    import java.util.LinkedList;
    import java.util.Scanner;


    static class Stu{
        int id;
        int h;
        int w;

        public Stu(int id, int h, int w) {
            this.id = id;
            this.h = h;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] h = in.nextLine().split(" ");
        String[] w = in.nextLine().split(" ");
        in.close();

        LinkedList<Stu> stus = new LinkedList<>();
        for(int i=0; i<n; i++) {
            Stu stu = new Stu(i+1, Integer.parseInt(h[i]), Integer.parseInt(w[i]));
            stus.add(stu);
        }
        stus.sort((o1,o2)-> o1.h == o2.h ? (o1.w - o2.w) : o1.h - o2.h);
        StringBuilder builder = new StringBuilder();
        stus.forEach(x -> builder.append(x.id).append(" "));
        System.out.println(builder.substring(0, builder.length()-1));
    }

//78 运维工程师采集到某产品线网运行一天产生的日志n条
    //对日志按时间顺序排序
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        LinkedList<String> times = new LinkedList<>();
        for (int i=0; i<n; i++){
            times.add(in.nextLine());
        }
        in.close();
        times.sort(Comparator.comparingLong(Main90::getTime));
        times.forEach(System.out::println);
    }

    private static long getTime(String str) {
        String[] t1 = str.split(":");
        String[] t2 = t1[2].split("\\.");
        int h = Integer.parseInt(t1[0]) * 60 * 60 * 1000;
        int m = Integer.parseInt(t1[1]) * 60 * 1000;
        int s = Integer.parseInt(t2[0]) * 1000;
        int n = Integer.parseInt(t2[1]);
        return h+m+s+n;
    }


    //77双十一众多商品进行打折销售
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> m = Arrays.stream(in.nextLine().split(","))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        int r = Integer.parseInt(in.nextLine());
        in.close();

        int max = -1;
        for (int i=0; i<m.size()-2; i++) {
            for (int j=0; j<m.size()-1; j--) {
                for (int k=0; k<m.size(); k++) {
                    if(i!=j && j!=k && i != k) {
                        int sum = m.get(i)+m.get(j)+m.get(k);
                        if(sum <= r && sum > max){
                            max = sum;
                        }
                    }
                }
            }
            System.out.println(max);
        }
    }



    //76在学校中，N个小朋友站成一队，第i个小朋友身高为height[i]
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        if(n == 0){
            System.out.println(0);
            return;
        }

        String[] strs = in.nextLine().split(" ");

        List<Integer> height = Arrays.stream(strs)
                                .map(Integer::parseInt)
                                .collect(Collectors.toList());
        LinkedList<Integer> res = new LinkedList<>();

        for(int i=0; i<height.size(); i++) {
            int pos=0;
            for(int j=i+1; j<height.size(); i++) {
                if(height.get(j) > height.get(i)){
                    pos = j;
                    break;
                }
            }
            res.add(pos);
        }
        StringBuilder builder = new StringBuilder();
        res.forEach(x->builder.append(x).append(" "));
        if(builder.length() > 1) {
            String substring = builder.substring(0, builder.length()-1);
            System.out.println(substring);
        }
    }


    //75输入一串字符串，字符串长度不超过100，查找字符串中相同字符连续出现的最大次数
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();

        char[] chars = str.toCharArray();

        int maxLen = 0;

        for(int i=0; i<chars.length; i++){
            int index = i;
            int len = 1;
            while(index+1 < chars.length && chars[index+1] == chars[index]) {
                len++;
                index++;
            }
            if(len>maxLen) maxLen = len;
        }
        System.out.println(maxLen);
    }


    //74特定大小的停车场，三种车占数不同，最少可以占多少辆车
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String cars = in.nextLine()
                .replace(",", "");
        in.close();

        int count = 0;

        String[] split = cars.split("[0]+");
        for (String car : split) {
            int len = car.length();
            while(len > 3) {
                count++;
                len -= 3;
            }
            if(len != 0){
                count++;
            }
        }
        System.out.println(count);
    }

//73给出一个只包含字母的字符串，不包含空格，统计字符串中各个子字母（区分大小写）出现的次数
    //并按照字母出现次数从大到小
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        print(map.entrySet().stream().filter(e->e.getKey() >= 'a'));
        print(map.entrySet().stream().filter(e->e.getKey() >= 'Z'));
    }
    private static void print(Stream<Map.Entry<Character, Integer>> stream) {
        List<Map.Entry<Character, Integer>> list = stream
                .sorted((o1, o2) -> {
                    int v1 = o1.getValue();
                    char k1 = o1.getKey();
                    int v2 = o2.getValue();
                    char k2 = o2.getKey();
                    if (v1 != v2) {
                        return v2 - v1;
                    } else {
                        return k1 - k2;
                    }
                }).collect(Collectors.toList());

        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            builder.append(entry.getKey()).append(":")
                    .append(entry.getValue()).append(";");
        }

        System.out.print(builder);
    }

    //72输出好朋友的位置
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        List<Integer> highs = Arrays.stream(in.nextLine().split(" "))
        .map(Integer::parseInt)
        .collect(Collectors.toList());
        in.close();

        StringBuilder builder = new StringBuilder();

        for(int i=0; i<highs.size(); i++){
            int pos = 0;
            for (int j = i ; j<highs.size(); j++){
                if(highs.get(j) > highs.get(i)){
                    pos = j;
                    break;
                }
            }
            builder.append(pos).append(" ");
        }
        System.out.println(builder.substring(0,builder.length()-1));
    }

    //71根据小朋友身高排成高矮高矮高矮的顺序
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> high = null;
        try{
            high = Arrays.stream(in.nextLine().split(" "))
                    .map(Integer::parseInt).collect(Collectors.toList());
        }catch(Exception e) {
            System.out.println("[]");
            return;
        }finally{
            in.close();
        }

        for (int i=0; i<high.size()-1; i++){
            if(i%2 == 0 && high.get(i) < high.get(i+1)){
                swap(high, i, i+1);
            }
            if(i%2 == 1 && high.get(i)>high.get(i+1)) {
                swap(high, i , i+1);
            }
        }
        StringBuilder builder  = new StringBuilder();
        high.forEach(x->builder.append(x).append(" "));
        String res = builder.substring(0, builder.length()-1);
        System.out.println(res);
    }
    static void swap (List<Integer> list, int x, int y) {
        Integer tmp = list.get(x);
        list.set(x, list.get(y));
        list.set(y,tmp);
    }


    //70水仙花数
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int N = Integer.parseInt(in.nextLine());
        int M = Integer.parseInt(in.nextLine());
        in.close();

        if(N<3 || N>7){
            System.out.println(-1);
            return;
        }

        LinkedList<Integer> res = new LinkedList<>();

        int start = (int) Math.pow(10, N-1);
        int end = (int) Math.pow(10,N);
        for(int i=start; i<end; i++){
            int sum = 0;
            int bit = start;
            while(bit != 1) {
                sum += Math.pow(i/bit %10, N);
                bit /= 10;
            }
            sum += Math.pow(i%10, N);
            if(sum == i){
                res.add(i);
            }
            if(res.size() == M+1) {
                System.out.println(i);
                return;
            }
        }
        if(M > res.size()) {
            System.out.println(M * res.getLast());
        }
    }

    //69输入一个只包含英文字母的字符串，字符串中的两个字母如果相邻且相同，就可以消除
    //在字符串上反复执行消除的动作,直到无法消除，获得最终的字符串长度
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();

        int len = str.replaceAll("[A-Z]", "")
                .replaceAll("[a-z]","")
                .length();
        if(len != 0) {
            System.out.println(0);
            return;
        }

        LinkedList<Character> characters = new LinkedList<>();
        for (char c : str.toCharArray()){
            characters.add(c);
        }

        int count = 0;
        while(characters.size() != count) {
            count = characters.size();
            for(int i=0; i<characters.size()-1; i++){
                if(characters.get(i) == characters.get(i+1)){
                    characters.remove(i);
                    characters.remove(i);
                    i--;
                }
            }
        }
        System.out.println(characters.size());
    }

//68给定一个随机的整数数组nums可能存在正整数和负整数，在该数组中找出两个数，其和的绝对值为最小值，并返回这两个数（按从小到大）以及绝对值
    //每种输入只会对应一个答案，但是，数组中同一个元素不能使用两遍
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        String[] nums = in.nextLine().split("");
        in.close();

        ArrayList<Integer> list = Arrays.stream(nums)
                                    .map(Integer::parseInt)
                                    .distinct()
                                    .collect(Collectors.toCollection(ArrayList::new));
        int min = Integer.MAX_VALUE;

        TreeSet<Integer> resSet = new TreeSet<>();

        for (int i=0; i<list.size()-1; i++) {
            for (int j=i; j<list.size(); j++) {
                Integer a = list.get(i);
                Integer b = list.get(j);
                int sum = Math.abs(a+b);
                if(sum < min && a!=b) {
                    min = sum;
                    resSet.clear();
                    resSet.add(a);
                    resSet.add(b);
                }
            }
        }
        if(resSet.size() != 0) {
            for (Integer integer : resSet) {
                System.out.print(integer + " ");
            }
            System.out.println(min);
        }
    }

//67 给定一个字符串s，交换字符串中任意两个不同位置的字符
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();
        char[] chars = str.toCharArray();
        for (int i=0; i<chars.length; i++) {
            boolean reverse = reverse(chars,i);
            if(reverse) {
                System.out.println(new String(chars));
                break;
            }
        }
        System.out.println();
    }
    private static boolean reverse(char[] chars,int start) {
        if(start == chars.length) {
            System.out.println("到头了");
            return true;
        }
        char tmp = chars[start];
        int pos = 0;
        for (int i = start+1; i<chars.length; i++){
            char cur = chars[i];
            if(cur <= tmp) {
                tmp = cur;
                pos = i;
            }
        }
        if(pos != 0) {
            chars[pos] = chars[start];
            chars[start] = tmp;
            return true;
        }
        return false;
    }


    //66当一个字符串只有元音字母组成，称为元音字符串，现给定一个字符串，请找出其中最长的元音字符串，并返回其长度，如果找不到则返回0
    //字符串中任意一个连续字符组成的子序列称为该字符串的子串
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        java.lang.String str = in.nextLine().toLowerCase();
        in.close();
        List<Character> vowel = Arrays.asList('a','e','i','o','u');
        int maxLen = 0, tmpLen = 0;
        for (char c : str.toCharArray()) {
            if(vowel.contains(c)) {
                tmpLen++;
            }else{
                maxLen = Math.max(maxLen, tmpLen);
                tmpLen = 0;
            }
        }
        maxLen = Math.max(maxLen, tmpLen);
        System.out.println(maxLen);
    }


    //65输入一个由N个大小的字母组成的字符串，按照ACSII值从小到达进行排序，查找字符串中第K个最小ASCII码值的字母（
    //输出该字母所在字符串中的位置索引（字符串的第一个位置索引为0
    // k如果大于字符串长度，输出字符串中的最大码值的字母所在的位置索引
    // 如果有重复字母则输入字母的最小位置的索引）
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int k = in.nextInt();
        in.close();

        char[] chars = str.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for (char achar : chars){
            list.add(achar);
        }
        list.sort(Character::compareTo);
        char c = k >= list.size() ? list.get(list.size()-1) : list.get(k-1);
        System.out.println(str.indexOf(c));
    }


    //64 绘图机器的绘图笔初始位置在原点，机器启动后按照以下规则来进行绘制直线
    //计算绘制的直线和横坐标轴以及x=E的直线组成的图形面积
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int E = Integer.parseInt(split[1]);
        int curX = 0, curY = 0, area = 0;
        for (int i = 0; i<N; i++) {
            String[] str = in.nextLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);

            area += (x-curX) * Math.abs(curY);

            curX = x;
            curY += y;
        }
        if(curX < E) {
            area += (E-curX) * Math.abs(curY);
        }
        System.out.println(area);
        in.close();
    }

    //63 给定两个字符集合，一个是全量字符集，一个是已占用字符集
    //已占用字符集中的字符不能再使用，要求输出剩余可用字符集
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split("@");
        in.close();

        HashMap<String, Line.Info> map = new HashMap<>();


        String[] all = split[0].split(",");
        for (int i=0; i<all.length; i++){
            String[] char_count = all[i].split(":");
            String c = char_count[0];
            map.put(c, new Line.Info(c, i, Integer.parseInt(char_count[1])));
        }
        if(split.length > 1)
            for (String s : split[1].split(",")) {
                String[] char_count = s.split(":");
                String c = char_count[0];
                Info value = map.get(c);
                value.count -= Integer.parseInt(char_count[1]);
                map.put(c,value);
            }
        StringBuilder sb = new StringBuilder();

            map.values().stream().filter(x->x.count > 0)
                    .sorted(new Comparator<Line.Info>() {
                        @Override
                        public int compare(Line.Info o1, Line.Info o2) {
                            return o1.no - o2.no;
                        }
                    }).forEach(x->
                    sb.append(x.c)
            .append(":")
                            .append(x.count)
            .append(","));

            System.out.println(sb.substring(0, sb.length()-1));
    }
    public static class Info{
        public String c;
        public int no;
        public int count;

        public Info(String c, int no, int count) {
            this.c = c;
            this.no = no;
            this.count = count;
        }
    }


    //62简易压缩算法：字符串
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();

        String res = decode(line);
        System.out.println(res);
    }
    private static String decode(String line) {
        String fixed = line.replaceAll("[a-z]|[0-9]", "");
        if(fixed.length() > 0) {
            return "!error";
        }

        StringBuilder res = new StringBuilder();
        char[] chars = line.toCharArray();
        int count = 1;
        for(int i=0; i<chars.length; i++){
            char cur = chars[i];
            if(Character.isLetter(cur)){
                if(res.length() > 2
                && cur == res.charAt(res.length()-1)
                && cur == res.charAt(res.length()-2)){
                    return "!error";
                }
                if(count == 2) {
                    return "!error";
                }
                for (int j = 0; j<count;j++){
                    res.append(cur);
                }
                count = 1;
            }
            int pos = i;
            while(Character.isDigit(chars[i])) {
                i++;
            }
            if(i>pos) {
                count = Integer.parseInt(line.substring(pos,i--));
            }
        }
        return res.toString();
    }

//61给定两个字符串t， p
    //要求从t找到一个和p相同的连续子串，并输出该子串第一个字符的下标
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String t = in.nextLine();
    String p = in.nextLine();
    in.close();

    int len = p.length();
    for (int i = 0; i<= t.length() - len; i++){
        String substring = t.substring(i, i+len);
        if(substring.equals(p)) {
            System.out.println(i+1);
            return;
        }
    }
    System.out.println("No");
}

//60 输入一个只包含英文字母的字符串，字符串中的两个字母如果相邻且相同就可以消除，知道无法消除为止
//得到字符串长度
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String str  = in.nextLine();
    in.close();

    if(str.replaceAll("[a-zA-Z]", "")
        .length() > 0) {
        System.out.println(0);
        return;
    }
    LinkedList<Character> link = new LinkedList<>();
    for (char c : str.toCharArray()){
        link.add(c);
    }
    for (int i = 0; i<link.size()-1; ) {
        if(link.get(i).equals(link.get(i+1))) {
            link.remove(i);
            link.remove(i);
            i--;
            i = Math.max(i, 0);
        }else{
            i++;
        }
    }
    System.out.println(link.size());
}

//59 公司用一个特殊的字符串来标识员工的出勤信息
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = Integer.parseInt(in.nextLine());
    ArrayList<List<String>> days = new ArrayList<>();
    for (int i=0; i<n; i++) {
        String[] split = in.nextLine().split(" ");
        List<String> list = Arrays.stream(split)
                .collect(Collectors.toList());
        days.add(list);
    }
    in.close();

    StringBuilder sb = new StringBuilder();

    for (List<String> day : days) {

        //1.缺勤超过1次
        long absent = day.stream()
                .filter(x -> x.equals("absent"))
                .count();
        if (absent > 1) {
            sb.append("false").append(" ");
            continue;
        }

        //2.没有连续的迟到/早退
        boolean flag = true;
        for (int i = 0; i < day.size() - 1; i++) {
            String cur = day.get(i);
            String next = day.get(i + 1);
            if (("late".equals(cur) ||
                    "leaveearly".equals(cur)) &&
                    ("late".equals(next) ||
                            "leaveearly".equals(next))) {
                flag = false;
                break;
            }
        }
        if (!flag) {
            sb.append(flag).append(" ");
            continue;
        }

        //3.任意连续7次考勤 缺勤/迟到/早退 不超过3次
        int[] ints = new int[day.size()];
        for (int i = 0; i < day.size(); i++) {
            ints[i] = "present".equals(day.get(i)) ? 0 : 1;
        }
        if (ints.length <= 7 && Arrays.stream(ints).sum() >= 3) {
            sb.append("false").append(" ");
        } else {
            flag = true;
            for (int i = 0; i < ints.length - 7; i++) {
                int[] subArr = Arrays.copyOfRange(ints, i, i + 7);
                if (Arrays.stream(subArr).sum() >= 3) {
                    flag = false;
                    break;
                }
            }
            sb.append(flag).append(" ");
        }
    }

    System.out.println(sb.substring(0, sb.length() - 1));

}

}



//58一个工厂有m条流水线
//        来并行完成n个独立的作业
//        该工厂设置了一个调度系统
//        在安排作业时，总是优先执行处理时间最短的作业
//        现给定流水线个数m
//        需要完成的作业数n
//        每个作业的处理时间分别为 t1,t2...tn
//        请你编程计算处理完所有作业的耗时为多少
//        当n>m时 首先处理时间短的m个作业进入流水线
//        其他的等待
//        当某个作业完成时，
//        依次从剩余作业中取处理时间最短的
//        进入处理

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strs = in.nextLine().split(" ");
        int m = Integer.parseInt(strs[0]);
        int n = Integer.parseInt(strs[1]);

        String[] split = in.nextLine().split(" ");
        int[] jobs = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            jobs[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(jobs);

        if (n <= m) {
            System.out.println(jobs[jobs.length - 1]);
            return;
        }

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            res.add(jobs[i]);
        }

        for (int i = m; i < jobs.length; i++) {
            Integer min = new ArrayList<>(new TreeSet<>(res)).get(0);
            int index = res.indexOf(min);
            res.set(index, res.get(index) + jobs[i]);
        }

        ArrayList<Integer> r = new ArrayList<>(new TreeSet<>(res));

        System.out.println(r.get(r.size() - 1));

    }
}


//57给定一个字符串
//    只包含大写字母
//    求在包含同一字母的子串中
//    长度第K长的子串
//    相同字母只取最长的子串
public class Main50 {
    public static void main(String[] args) {
 Scanner in = new Scanner(System.in);
         String line = in.nextLine();
         int k = in.nextInt();
         HashMap<Character, Integer> map = new HashMap<>();

        char[] chars = line.toCharArray();
        if (chars.length == 0) {
        System.out.println(-1);
        return;
        }

        char cur = chars[0];
        int count = 1;
        map.put(cur, count);

        for (int i = 1; i < chars.length; i++) {
        char c = chars[i];
        if (c == cur) count++;
        else {
        cur = c;
        count = 1;
        }
        map.put(cur, map.containsKey(cur) ?
        map.get(cur) > count ? map.get(cur) : count :
        count);
        }

        ArrayList<String> list = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        list.add(entry.getKey() + "-" + entry.getValue());
        }

        list.sort(new Comparator<String>() {
@Override
public int compare(String o1, String o2) {
        return o2.split("-")[1].compareTo(o1.split("-")[1]);
        }
        });

        if (k > list.size()) {
        System.out.println(-1);
        } else {
        System.out.println(list.get(k - 1).split("-")[1]);
        }

        in.close();

        }
        }


        //56为了充分发挥Gpu算力，
//         需要尽可能多的将任务交给GPU执行，
//         现在有一个任务数组，
//         数组元素表示在这1s内新增的任务个数，
//         且每秒都有新增任务，
//         假设GPU最多一次执行n个任务，
//         一次执行耗时1s，
//         在保证Gpu不空闲的情况下，最少需要多长时间执行完成。
public class Main48 {
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = Integer.parseInt(in.nextLine().trim());
    int len = Integer.parseInt(in.nextLine().trim());
    String[] split = in.nextLine().split(" ");
    int[] ints = new int[len];
        for (int i = 0; i < len; i++) {
        ints[i] = Integer.parseInt(split[i]);
        }

        int time = 0;
        int more = 0;
        for (int i : ints) {
        if (i + more > n) more = i + more - n;
        else more = 0;
        time++;
        }
        while (more > 0) {
        more -= n;
        time++;
        }

        System.out.println(time);
        in.close();
        }
        }



        //55 单词接龙的规则是
//        可用于接龙的单词首字母必须要与前一个单词的尾字母相同
//        当存在多个首字母相同的单词时
//        取长度最长的单词
//        如果长度也相等则取词典序最小的单词
//        已经参与接龙的单词不能重复使用
//        现给定一组全部由小写字母组成的单词数组
//        并指定其中的一个单词为起始单词
//        进行单词接龙
//        请输出最长的单词串
//        单词串是由单词拼接而成 中间没有空格
import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = Integer.parseInt(in.nextLine());
        int n = Integer.parseInt(in.nextLine());
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            words.add(in.nextLine());
        }
        in.close();

        StringBuilder builder = new StringBuilder();
        builder.append(words.get(k));
        words.remove(k);

        words.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len1 = o1.length();
                int len2 = o2.length();
                if(len1 != len2) {
                    return len2-len1;
                }else{
                    return w1.compareTo(w2);
                }
                return 0;
            }
        });
        int len;
        do{
            len = builder.length();
            java.lang.String last = builder.substring(builder.length()-1);
            for (int i=0; i<words.size(); i++){
                String cur = words.get(i);
                if (cur.startsWith(last)) {
                    builder.append(cur);
                    words.remove(cur);
                    break;
                }
            }
        }while(builder.length() != len);
        System.out.println(builder.toString());
    }
}

//54输入一个英文文章片段
//    翻转指定区间的单词顺序，标点符号和普通字母一样处理
//    例如输入字符串 "I am a developer."
//     区间[0,3]则输出 "developer. a am I"

public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String line = in.nextLine();
    int start = Integer.parseInt(in.nextLine());
    int end = Integer.parseInt(in.nextLine());
    in.close();

    String[] words = ((java.lang.String) line).trim().split("\\s+");
    start = Math.max(start, 0);
    end = Math.min(end, words.length - 1);
    if (end == start || start > words.length - 1 || end < 0) {
        System.out.println("EMPTY");
    } else {
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(words).subList(0, start));
        for (int i = end; i >= start; i--) {
            list.add(words[i]);
        }
        list.addAll(Arrays.asList(words).subList(end + 1, words.length));

        StringBuilder builder = new StringBuilder();
        for (String word : list) {
            builder.append(word).append(" ");
        }
        String res = builder.toString().trim();
        System.out.println(res);
    }
}


//53停车场有一横排车位0代表没有停车,1代表有车.
//       至少停了一辆车在车位上,也至少有一个空位没有停车.
//       为防止刮蹭,需为停车人找到一个车位
//       使得停车人的车最近的车辆的距离是最大的
//       返回此时的最大距离


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        java.lang.String line = in.nextLine().replace(",","");
        char[] sites = line.toCharArray();
        in.close();

        int max = 0;

        for (int i=0; i<sites.length; i++){
            char cur_site = sites[i];
            if(cur_site == '0'){
                int pre = line.indexOf('1',i);
                int suf = line.lastIndexOf('1',i);
                if(pre == -1) pre = 100;
                if(suf == -1) suf = line.length() - 1;
                int min = Math.min(pre-i, i-suf);
                if(min>max) max = min;
            }
        }
        System.out.println(max);
    }



    //52 磁盘的容量单位有M,G,T这三个等级
    //    他们之间的换算关系为
    //    1T=1024G
    //    1G=1024M
    //    现在给定N块磁盘的容量
    //      请对他们按从小到大的顺序进行稳定排序

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        ArrayList<String> sizes = new ArrayList<>();
        for (int i= 0; i<N; i++){
            sizes.add(in.nextLine());
        }
        in.close();
        sizes.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Long.compare(parseLong(o1), parseLong(o2));
            }
        });
        sizes.forEach(System.out::println);
    }

    static Long parseLong(String size) {
        String[] units = size.split("[0-9]+");
        String[] nums = size.split("[A-Z]+");
        //[, M, G, M]
        //[3, 12, 9]

        long sum = 0;
        for (int i = 1; i < units.length; i++) {
            long num = Long.parseLong(nums[i - 1]);
            switch (units[i]) {
                case "M":
                    sum += num;
                    break;
                case "G":
                    sum += num * 1024;
                    break;
                case "T":
                    sum += num * 1024 * 1024;
                    break;
            }
        }

        return sum;
    }



    //51 输入一个字符串仅包含大小写字母和数字
    //            求字符串中包含的最长的非严格递增连续数字序列长度

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();
        char[] chars = line.toCharArray();
        int curLen = 0 , maxLen = 0;
        char last = 'a';
        for (char cur : chars) {
            if(Character.isDigit(cur)) {
                if(curLen == 0) {
                    curLen++;
                } else if (cur >= last) {
                    curLen++;
                } else {
                    if (curLen > maxLen) {
                        maxLen = curLen;
                    }
                    curLen = 1;
                }
                last = cur;
            } else {
                if (curLen > maxLen) maxLen = curLen;
                curLen = 0;
                last = 'a';
            }
        }

        if (curLen > maxLen) {
            maxLen = curLen;
        }

        System.out.println(maxLen);
    }


    //50小明从糖果盒中随意抓一把糖果
//    每次小明会取出一半的糖果分给同学们
//    当糖果不能平均分配时
//    小明可以从糖果盒中(假设盒中糖果足够)取出一个或放回一个糖果
//    小明至少需要多少次(取出放回和平均分配均记一次)能将手中糖果分至只剩一颗

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        in.close();

        int count = 0;

        for (int i = n; i != 1; i /= 2, count++) {
            if (i == 3) {
                System.out.println(count += 2);
                return;
            }
            if (i % 2 != 0) {
                if ((i + 1) / 2 % 2 == 0) i++;
                else i--;
                count++;
            }
        }

        System.out.println(count);
    }

//49一辆运送快递的货车。运送的快递均放在大小不等的长方形快递盒中
//        为了能够装载更多的快递 同时不能让货车超载
//        需要计算最多能装多少个快递
//        快递的体积不受限制
//        快递数量最多1000个
//        货车载重量50000

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(",");
        int p = Integer.parseInt(in.nextLine());
        in.close();

        List<Integer> ints = Arrays.stream(line)
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

        int sum = 0, count = 0;
        for (Integer i : ints) {
            if(sum + i <= p){
                sum += i;
                count++;
            }else break;
        }
        System.out.println(count);
    }


    //48给定一个元素类型为小写字符串的数组
    //        请计算两个没有相同字符的元素长度乘积的最大值
    //        如果没有符合条件的两个元素返回0
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();

        String[] strings = line.split(",");

        int max = 0;
        for (int i = 0; i<strings.length; i++){
            for (int j = i; j < strings.length; j++) {
                char[] chars = strings[j].toCharArray();
                int k = 0;
                while (k < chars.length) {
                    if (strings[i].indexOf(chars[k]) != -1) break;
                    k++;
                }
                int tmp = strings[i].length() * strings[j].length();
                if (k == chars.length && tmp > max) max = tmp;
            }
        }
        System.out.println(max);
    }



    //47相对开音节构成的结构为辅音+元音(aeiou)+辅音(r除外)+e
    //         常见的单词有bike cake
    //         给定一个字符串，以空格为分隔符
    //         反转每个单词的字母
    //         若单词中包含如数字等其他非字母时不进行反转
    //         反转后计算其中含有相对开音节结构的子串个数
    //         (连续子串中部分字符可以重复)

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();

        String[] words = line.split(" ");

        int count = 0;

        for (String word : words) {
            char[] chars = word.toCharArray();
            if(word.replaceAll("[a-z]+", "").isEmpty()) {
                for (int i=0, j = chars.length-1; i<j; i++,j--){
                    char tmp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = tmp;
                }
            }
            if(chars.length < 4) continue;
            for (int i=0; i<chars.length-3; i++){
                if(!isVowel(chars[i]) &&  isVowel(chars[i + 1])
                        && !isVowel(chars[i + 2]) && chars[i + 2] != 'r'
                        && chars[i + 3] == 'e') {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i'
                || c == 'o' || c == 'u';
    }




    //46已知火星人使用的运算符号为#;$
    //           其与地球人的等价公式如下
    //           x#y=2*x+3*y+4
    //           x$y=3*x+y+2
    //           x y是无符号整数
    //           地球人公式按照c语言规则进行计算
    //           火星人公式中$符优先级高于#相同的运算符按从左到右的顺序运算
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String input = in.nextLine();
        in.close();

                List<String> operators = Arrays.stream(input.split("\\w+"))
        .filter(x -> !x.isEmpty())
        .collect(Collectors.toList());

        List<Integer> nums = Arrays.stream(input.split("\\W+"))
        .map(Integer::parseInt)
        .collect(Collectors.toList());

        int pos$ = operators.indexOf("$");
        while (pos$ != -1) {
        int tmp = dollar(nums.get(pos$), nums.get(pos$ + 1));
        nums.set(pos$, tmp);
        nums.remove(pos$ + 1);
        operators.remove(pos$);
        pos$ = operators.indexOf("$");
        }

        int res = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
        res = sharp(res, nums.get(i));
        }

        System.out.println(res);
        }

public static int sharp(int x, int y) {
        return 2 * x + 3 * y + 4;
        }

public static int dollar(int x, int y) {
        return 3 * x + y + 2;
        }


     //45给定一个正整数数组
    //    检查数组中是否存在满足规则的数组组合
    //    规则：
    //      A=B+2C
     public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         int num = Integer.parseInt(in.nextLine());
         String[] nums = in.nextLine().split(" ");
         in.close();

         TreeSet<Integer> intSet = new TreeSet<>();
         for (String s : nums) {
             intSet.add(Integer.parseInt(s));
         }

         ArrayList<Integer> list = new ArrayList<>(intSet);

         String res = "0";

         for (int a = list.size() - 1; a >= 0; a--) {
             for (int b = 0; b < a; b++) {
                 for (int c = 0; c < a; c++) {
                     Integer A = list.get(a);
                     Integer B = list.get(b);
                     Integer C = list.get(c);
                     if (A == B + 2 * C) {
                         res = A + " " + B + " " + C;
                     }
                 }
             }
         }

         System.out.println(res);
     }

//44有N个正整数组成的一个序列
//         给定一个整数sum
//         求长度最长的的连续子序列使他们的和等于sum
//         返回次子序列的长度
//         如果没有满足要求的序列 返回-1
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> ints = Arrays.stream(in.nextLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int sum = Integer.parseInt(in.nextLine());
        in.close();

        int max_len = 0;

        for (int i = 0; i < ints.size(); i++) {
            int tmp_sum = 0;
            int sub_len = 0;
            for (int j = i; j < ints.size(); j++) {
                if (tmp_sum > sum) break;
                tmp_sum += ints.get(j);
                sub_len++;
                if (tmp_sum == sum && sub_len > max_len)
                    max_len = sub_len;
            }
        }

        max_len = max_len == 0 ? -1 : max_len;

        System.out.println(max_len);
    }



    //43实现一个整数编码方法
    //        使得待编码的数字越小
    //        编码后所占用的字节数越小
    //        编码规则如下
    //        1.编码时7位一组，每个字节的低7位用于存储待编码数字的补码
    //        2.字节的最高位表示后续是否还有字节，置1表示后面还有更多的字节，
    //        置0表示当前字节为最后一个字节
    //        3.采用小端序编码，低位和低字节放在低地址上
    //        4.编码结果按16进制数的字符格式进行输出，小写字母需要转化为大写字母
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());
        in.close();

        String binary = Integer.toBinaryString(num);

        int len = binary.length();

        StringBuilder sb = new StringBuilder();
        for (int i = len; i > 0; i -= 7) {
            int start = Math.max(i - 7, 0);

            String bin = binary.substring(start, i);

            if (bin.length() < 7) {
                StringBuilder head = new StringBuilder();
                for (int j = 0; j < 7 - bin.length(); j++) {
                    head.append("0");
                }
                bin = head.append(bin).toString();
            }
            bin = i - 7 <= 0 ? "0" + bin : "1" + bin;
            String hex = Integer.toHexString(Integer.parseInt(bin, 2)).toUpperCase();
            if (hex.length() == 1) hex = "0" + hex;
            sb.append(hex);
        }

        System.out.println(sb);
    }


    //42Vlan是一种为局域网设备进行逻辑划分的技术
    //    为了标识不同的vlan 引入了vlan id 1~4094之间的整数
    //    定义一个vlan id 的资源池
    //    资源池中连续的vlan用开始vlan-结束vlan表示，
    //    不连续的用单个整数表示
    //    所有的vlan用英文逗号连接起来
    //    现有一个vlan资源池，业务需要从资源池中申请一个vlan
    //    需要你输出从vlan资源池中移除申请的vlan后的资源池
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        Integer request = Integer.parseInt(in.nextLine());
        in.close();
        TreeSet<Integer> set = new TreeSet<>();
        for (String str : input.split(",")) {
            if (str.contains("-")) {
                String[] split = str.split("-");
                int start = Integer.parseInt(split[0]);
                int end = Integer.parseInt(split[1]);
                for (int i = start; i <= end; i++) {
                    set.add(i);
                }
            } else {
                set.add(Integer.parseInt(str));
            }
        }

        set.remove(request);

        ArrayList<Integer> list = new ArrayList<>(set);
        StringBuilder sb = new StringBuilder();

        Integer start = list.get(0);
        Integer last = start;

        for (int i = 1; i < list.size(); i++) {
            Integer cur = list.get(i);
            if (cur == last + 1) {
                last = cur;
            } else {
                append(sb, start, last);
                start = last = cur;
            }
        }
        append(sb, start, last);

        System.out.println(sb.substring(0, sb.length() - 1));
    }

    private static void append(StringBuilder sb, Integer start, Integer last) {
        if (start.equals(last)) {
            sb.append(last).append(",");
        } else {
            sb.append(start).append("-")
                    .append(last).append(",");
        }
    }



    //41给定参数n 从1到n会有n个整数 1，2，3，...n
    //    这n个数字共有n!种排列 按大小顺序升序列出所有排列情况
    //    并一一标记
    //    当n=3时，所有排列如下
    //    "123","132","213","231","312","321"
    //    给定n和k 返回第n个排列
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int k = Integer.parseInt(in.nextLine());
        in.close();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }
        perm(arr, 0, n - 1);
        String res = new ArrayList<>(set).get(k - 1);
        System.out.println(res);
    }
    public static void perm(Integer[] array, int start, int end) {

        if (start == end) {
            String num = Arrays.toString(array).replaceAll("\\W+", "");
            set.add(num);
        } else {
            for (int i = start; i <= end; i++) {
                swap(array, start, i);
                perm(array, start + 1, end);
                swap(array, start, i);
            }
        }
    }

    public static void swap(Integer[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    //40幼儿园两个班的小朋友排队时混在了一起
    //        每个小朋友都知道自己跟前面一个小朋友是不是同班
    //        请你帮忙把同班的小朋友找出来
    //        小朋友的编号为整数
    //        与前面一个小朋友同班用Y表示
    //        不同班用N表示
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] stus = in.nextLine().split(" ");
        in.close();

        try {

            TreeSet<Integer> c1 = new TreeSet<>();
            TreeSet<Integer> c2 = new TreeSet<>();

            boolean is1 = true;
            for (int i = 0; i < stus.length; i++) {
                String[] split = stus[i].split("/");
                String id = split[0];
                String same = split[1];
                if (i == 0) {
                    c1.add(Integer.parseInt(id));
                    continue;
                }
                if ("N".equals(same)) is1 = !is1;
                (is1 ? c1 : c2).add(Integer.parseInt(id));
            }

            StringBuilder b1 = new StringBuilder();
            for (Integer id : c1) b1.append(id).append(" ");

            if (c2.size() > 0) {
                StringBuilder b2 = new StringBuilder();
                for (Integer id : c2) b2.append(id).append(" ");
                if (c1.first() < c2.first()) {
                    System.out.println(b1.toString().trim());
                    System.out.println(b2.toString().trim());
                } else {
                    System.out.println(b2.toString().trim());
                    System.out.println(b1.toString().trim());
                }
            } else {
                System.out.println(b1.toString().trim());
            }

        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }



    //39有一个数列A[n]
    //            从A[0]开始每一项都是一个数字
    //            数列中A[n+1]都是A[n]的描述
    //            其中A[0]=1
    //            规则如下
    //            A[0]:1
    //            A[1]:11 含义其中A[0]=1是1个1 即11
    //            表示A[0]从左到右连续出现了1次1
    //            A[2]:21 含义其中A[1]=11是2个1 即21
    //            表示A[1]从左到右连续出现了2次1
    //            A[3]:1211 含义其中A[2]从左到右是由一个2和一个1组成 即1211
    //            表示A[2]从左到右连续出现了一次2又连续出现了一次1
    //            A[4]:111221  含义A[3]=1211 从左到右是由一个1和一个2两个1 即111221
    //            表示A[3]从左到右连续出现了一次1又连续出现了一次2又连续出现了2次1

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        in.close();

        StringBuilder next;
        String content = "1";

        if (n == 0) {
            System.out.println(content);
            return;
        }
        for (int i = 1; i <= n; i++) {
            next = new StringBuilder();

            char[] chars = content.toCharArray();
            char last = chars[0];
            int count = 1;
            for (int j = 1; j < chars.length; j++) {
                if (chars[j] == last) count++;
                else {
                    next.append(count).append(last);
                    count = 1;
                    last = chars[j];
                }
            }
            next.append(count).append(last);
            content = next.toString();
        }

        System.out.println(content);
    }


    //38给定一个url前缀和url后缀
    //        通过,分割 需要将其连接为一个完整的url
    //        如果前缀结尾和后缀开头都没有/
    //        需要自动补上/连接符
    //        如果前缀结尾和后缀开头都为/
    //        需要自动去重
    //        约束：
    //         不用考虑前后缀URL不合法情况
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();

        String[] split = line.split(",");
        if (split.length == 0) {
            System.out.println("/");
            return;
        }

        String combine = split[0] + "/" + split[1];
        String url = combine.replaceAll("/+", "/");
        System.out.println(url);
    }


    //37一个工厂有m条流水线
    //        来并行完成n个独立的作业
    //        该工厂设置了一个调度系统
    //        在安排作业时，总是优先执行处理时间最短的作业
    //        现给定流水线个数m
    //        需要完成的作业数n
    //        每个作业的处理时间分别为 t1,t2...tn
    //        请你编程计算处理完所有作业的耗时为多少
    //        当n>m时 首先处理时间短的m个作业进入流水线
    //        其他的等待
    //        当某个作业完成时，
    //        依次从剩余作业中取处理时间最短的
    //        进入处理
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strs = in.nextLine().split(" ");
        int m = Integer.parseInt(strs[0]);
        int n = Integer.parseInt(strs[1]);
        List<Integer> jobs = Arrays.stream(in.nextLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        in.close();

        if (n <= m) {
            System.out.println(Collections.max(jobs).intValue());
            return;
        }

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            res.add(jobs.get(i));
        }

        for (int i = m; i < jobs.size(); i++) {
            Integer min = res.stream().sorted().iterator().next();
            int index = res.indexOf(min);
            res.set(index, res.get(index) + jobs.get(i));
        }

        Integer maxTime = res.stream().max(Integer::compareTo).get();

        System.out.println(maxTime);
    }

    //36用数组代表每个人的能力
    //        一个比赛活动要求 参赛团队的最低能力值为N
    //        每个团队可以由一人或者两人组成
    //        且一个人只能参加一个团队
    //        计算出最多可以派出多少只符合要求的队伍
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] nums = in.nextLine().split(" ");
        int base = Integer.parseInt(in.nextLine());
        in.close();

        Integer[] list = Arrays.stream(nums)
                .map(Integer::parseInt)
                .filter(x -> x < base)
                .sorted()
                .toArray(Integer[]::new);

        int count = nums.length - list.length;

        int i = 0, j = list.length - 1;
        while (i < j) {
            if (list[i] + list[j] >= base) {
                count++;
                i++;
                j--;
            } else i++;
        }
        System.out.println(count);
    }


    //35同一个数轴x有两个点的集合A={A1,A2,...,Am}和B={B1,B2,...,Bm}
    //        A(i)和B(j)均为正整数
    //        A、B已经按照从小到大排好序，AB均不为空
    //        给定一个距离R 正整数，列出同时满足如下条件的
    //        (A(i),B(j))数对
    //        1. A(i)<=B(j)
    //        2. A(i),B(j)之间距离小于等于R
    //        3. 在满足1，2的情况下每个A(i)只需输出距离最近的B(j)
    //        4. 输出结果按A(i)从小到大排序
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        int R = Integer.parseInt(split[2]);
        List<Integer> A = Arrays.stream(in.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> B = Arrays.stream(in.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        in.close();

        for (int Ai : A) {
            for (int Bj : B) {
                if (Ai <= Bj && Bj - Ai <= R) {
                    System.out.println(Ai + " " + Bj);
                    break;
                }
            }
        }
    }


    //34  1.众数是指一组数据中出现次数多的数
    //        众数可以是多个
    //        2.中位数是指把一组数据从小到大排列，最中间的那个数，
    //        如果这组数据的个数是奇数，那最中间那个就是中位数
    //        如果这组数据的个数为偶数，那就把中间的两个数之和除以2就是中位数
    //        3.查找整型数组中元素的众数并组成一个新的数组
    //        求新数组的中位数
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.stream(in.nextLine().split(" "))
                .forEach(x -> {
                    int i = Integer.parseInt(x);
                    map.put(i, map.getOrDefault(i, 0)+1);
                });
        in.close();

        Integer max = map.values().stream().max(Integer::compareTo).get();

        List<Integer> newArr = map.keySet().stream()
                .filter(k -> map.get(k).equals(max))
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());

        Integer res = 0;
        int size = newArr.size();
        if (size % 2 == 0) {
            res = (newArr.get(size / 2) + newArr.get(size / 2 - 1)) / 2;
        } else {
            res = newArr.get(size / 2);
        }

        System.out.println(res);
    }

//33有一个简易内存池，内存按照大小粒度分类
//          每个粒度有若干个可用内存资源
//          用户会进行一系列内存申请
//          需要按需分配内存池中的资源
//          返回申请结果成功失败列表
//          分配规则如下
//          1.分配的内存要大于等于内存的申请量
//          存在满足需求的内存就必须分配
//          优先分配粒度小的，但内存不能拆分使用
//          2.需要按申请顺序分配
//          先申请的先分配，有可用内存分配则申请结果为true
//          没有可用则返回false
//          注释：不考虑内存释放
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    TreeMap<Integer, Integer> pool = new TreeMap<>();
    Arrays.stream(in.nextLine().split(","))
            .forEach(x -> {
                String[] split = x.split(":");
                pool.put(Integer.parseInt(split[0]),
                        Integer.parseInt(split[1]));
            });
    List<Integer> list = Arrays.stream(in.nextLine().split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    in.close();

    StringBuilder builder = new StringBuilder();

    for (Integer size : list) {
        boolean flag = false;
        for (Integer k : pool.keySet()) {
            Integer v = pool.get(k);
            if (k >= size && v != 0) {
                builder.append("true,");
                pool.put(k, v - 1);
                flag = true;
                break;
            }
        }
        if (!flag) builder.append("false,");
    }

    System.out.println(builder.substring(0, builder.length() - 1));
}


//32 有一个N个整数的数组
//        和一个长度为M的窗口
//        窗口从数组内的第一个数开始滑动
//        直到窗口不能滑动为止
//        每次滑动产生一个窗口  和窗口内所有数的和
//        求窗口滑动产生的所有窗口和的最大值

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] strs = in.nextLine().split(" ");
        int m = Integer.parseInt(in.nextLine());
        in.close();

        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(strs[i]);
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n - m + 1; i++) {
            int sum = 0;
            for (int j = i; j < i + m; j++) {
                sum += ints[j];
            }
            if (sum > res) res = sum;
        }
        System.out.println(res);
    }

    //31一个整数可以由连续的自然数之和来表示
    //        给定一个整数
    //        计算该整数有几种连续自然数之和的表达式
    //        并打印出每一种表达式

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        System.out.println(t + "=" + t);

        ArrayList<String> res = new ArrayList<>();

        for (int n = 1; n < t; n++) {
            int sum = 0;
            StringBuilder builder = new StringBuilder();
            for (int i = n; sum < t; i++) {
                sum += i;
                builder.append(i).append("+");
                if (sum == t) {
                    res.add(t + "=" + builder.substring(0, builder.length() - 1));
                    break;
                }
            }
        }
        res.sort(Comparator.comparingInt(String::length));
        res.forEach(System.out::println);

        System.out.println("Result:" + (res.size() + 1));
        in.close();
    }

    //30给定一个仅包含0和1的n*n二维矩阵
    //        请计算二维矩阵的最大值
    //        计算规则如下
    //        1、每行元素按下标顺序组成一个二进制数(下标越大约排在低位)，
    //        二进制数的值就是该行的值，矩阵各行之和为矩阵的值
    //        2、允许通过向左或向右整体循环移动每个元素来改变元素在行中的位置
    //        比如
    //        [1,0,1,1,1]   向右整体循环移动两位  [1,1,1,0,1]
    //        二进制数为11101 值为29
    //        [1,0,1,1,1]   向左整体循环移动两位  [1,1,1,1,0]
    //        二进制数为11110 值为30
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int res = 0;
        for (int i = 0; i < n; i++) {
            LinkedList<Integer> ints = new LinkedList<>();
            Arrays.stream(in.nextLine().split(","))
                    .forEach(x -> ints.add(Integer.parseInt(x)));
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                ints.addLast(ints.remove(0));

                String binInt = ints.toString()
                        .replaceAll("\\W+", "");

                int sum = Integer.parseInt(binInt, 2);
                if (sum > max) max = sum;
            }
            res += max;
        }
        System.out.println(res);
        in.close();
    }

//29主管期望你来实现英文输入法单词联想功能
//         需求如下
//         依据用户输入的单词前缀
//         从已输入的英文语句中联想出用户想输入的单词
//         按字典序输出联想到的单词序列
//         如果联想不到
//         请输出用户输入的单词前缀
//         注意
//         英文单词联想时区分大小写
//         缩略形式如
//         "don't" 判定为两个单词 "don"和 "t"
//         输出的单词序列不能有重复单词
//         且只能是英文单词，不能有标点符号
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String[] str = in.nextLine().split("\\W+");
    String pre = in.nextLine();
    in.close();

    TreeSet<String> words = new TreeSet<>(Arrays.asList(str));

    StringBuilder buffer = new StringBuilder();

    for (String word : words) {
        if (word.startsWith(pre)) {
            buffer.append(word).append(" ");
        }
    }
    if (buffer.length() == 0) buffer.append(pre);

    System.out.println(buffer.toString().trim());
}


//28给定一个数组
//            编写一个函数
//            来计算他的最大N个数和最小N个数的和
//            需要对数组进行去重
//
//            说明
//            第一行输入M
//            M表示数组大小
//            第二行输入M个数
//            表示数组内容
//            第三行输入N表示需要计算的最大最小N的个数
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int m = Integer.parseInt(in.nextLine());
    String[] numsStr = in.nextLine().split(" ");
    int n = Integer.parseInt(in.nextLine());
    in.close();

    TreeSet<Integer> ints = new TreeSet<>();
    for (String s : numsStr) {
        ints.add(Integer.parseInt(s));
    }

    int res = -1;

    if (ints.size() >= 2 * n) {
        res = 0;
        ArrayList<Integer> list = new ArrayList<>(ints);
        for (int i = 0; i < list.size(); i++) {
            if (i < n || i > list.size()-1 - n) {
                res += list.get(i);
            }
        }
    }
    System.out.println(res);
}


//27给定一个非空数组(列表)
//         起元素数据类型为整型
//         请按照数组元素十进制最低位从小到大进行排序
//         十进制最低位相同的元素，相对位置保持不变
//         当数组元素为负值时，十进制最低为等同于去除符号位后对应十进制值最低位
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String[] nums = in.nextLine().split(",");
    in.close();

    ArrayList<Integer> list = new ArrayList<>();
    for (String num : nums) {
        list.add(Integer.parseInt(num));
    }
    list.sort(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return getKey(o1) - getKey(o2);
        }

        public Integer getKey(int i) {
            i = i > 0 ? i : -i;
            return i % 10;
        }
    });

    String listStr = list.toString();
    String res = listStr.substring(1, listStr.length() - 1)
            .replaceAll(" ", "");

    System.out.println(res);
}


//26疫情过后希望小学终于又重新开学了
//        3年2班开学第一天的任务是
//        将后面的黑板报重新制作
//        黑板上已经写上了N个正整数
//        同学们需要给这每个数分别上一种颜色
//        为了让黑板报既美观又有学习意义
//        老师要求同种颜色的所有数都可以被这个颜色中最小的那个数整除
//        现在帮小朋友们算算最少需要多少种颜色，给这N个数进行上色
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String nStr = in.nextLine();
    String[] nums = in.nextLine().split(" ");
    in.close();

    TreeSet<Integer> ints = new TreeSet<>();
    for (String num : nums) {
        ints.add(Integer.parseInt(num));
    }

    if (ints.contains(1)) {
        System.out.println(1);
        ints.remove(1);
        return;
    }

    ArrayList<Integer> intList = new ArrayList<>(ints);
    for (int i = 0; i < intList.size(); i++) {
        Integer cur = intList.get(i);
        for (int j = i + 1; j < intList.size(); ) {
            if (intList.get(j) % cur == 0) {
                intList.remove(j);
            } else j++;
        }
    }
    System. out.println(intList.size());
}

//25 /**
//         * 输入
//         * -1 -3 7 5 11 15
//         * 输出
//         * -3 5 2
//         */
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] numStr = sc.nextLine().split(" ");
    sc.close();
    int[] ints = new int[numStr.length];
    for (int i = 0; i < ints.length; i++) {
        ints[i] = Integer.parseInt(numStr[i]);
    }

    int a = 0, b = 0;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < ints.length; i++) {
        for (int j = 0; j < ints.length; j++) {
            int sum = ints[i] + ints[j];
            sum = sum > 0 ? sum : -sum;
            if (i != j && sum < min) {
                a = ints[i];
                b = ints[j];
                min = sum;
            }
        }
    }
    System.out.println(a + " " + b + " " + min);
}


//24身高从低到高
//    身高相同体重从轻到重
//    体重相同维持原来顺序
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());
    String[] h = sc.nextLine().split(" ");
    String[] w = sc.nextLine().split(" ");
    sc.close();
    int[][] ints = new int[n][3];
    for (int i = 0; i < n; i++) {
        ints[i][0] = i + 1;
        ints[i][1] = Integer.parseInt(h[i]);
        ints[i][2] = Integer.parseInt(w[i]);
    }
    Arrays.sort(ints, new Comparator<int[]>() {
        @Override
        public int compare(int[] arr1, int[] arr2) {
            //身高
            if (arr1[1] == arr2[1]) return arr1[2] - arr2[2];
            else return arr1[1] - arr2[1];
        }
    });
    for (int[] anInt : ints) {
        System.out.print(anInt[0] + " ");
    }
}


//23磁盘的容量单位常用的有
//        M G T
//        他们之间的换算关系为 1T =1024G 1G=1024M
//        现在给定n块磁盘的容量，请对他们按从小到大的顺序进行稳定排序
//        例如给定5块盘的容量
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = Integer.parseInt(in.nextLine());

    ArrayList<String> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        list.add(in.nextLine());
    }
    list.sort(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(calc(o1), calc(o2));
        }
    });

    for (String s : list) {
        System.out.println(s);
    }

    in.close();
}

    static int calc(String str) {
        int size = 0;
        String upper = str.toUpperCase();
        String[] split = upper.split("[A-Z]");
        int length = 0;
        for (String s : split) {
            length += s.length();
            int num = Integer.parseInt(s);
            String substring = upper.substring(length, length + 1);
            switch (substring) {
                case "M":
                    size += num;
                    break;
                case "G":
                    size += num * 1024;
                    break;
                case "T":
                    size += num * 1024 * 1024;
                    break;
            }
            length++;
        }
        return size;
    }


    //22现在有多组整数数组
    //        需要将他们合并成一个新的数组
    //        合并规则从每个数组里按顺序取出固定长度的内容
    //        合并到新的数组
    //        取完的内容会删除掉
    //        如果改行不足固定长度，或者已经为空
    //        则直接取出剩余部分的内容放到新的数组中继续下一行
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.parseInt(scanner.nextLine());
        int num = Integer.parseInt(scanner.nextLine());
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        ArrayList<String> res = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < num; i++) {
            String[] arr = scanner.nextLine().split(",");
            sum += arr.length;
            list.add(new ArrayList<String>(Arrays.asList(arr)));
        }
        while (res.size() != sum) {
            for (ArrayList<String> strList : list) {
                if (strList.size() == 0) continue;
                int times = Math.min(strList.size(), len);
                for (int i = 0; i < times; i++) {
                    res.add(strList.remove(0));
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (String str : res) {
            builder.append(str).append(",");
        }
        String resStr = builder.toString();
        System.out.println(resStr.substring(0, resStr.length() - 1));

        scanner.close();
    }


    //21在通信系统中有一个常见的问题是对用户进行不同策略的调度
    //        会得到不同系统消耗的性能
    //        假设由N个待串行用户，每个用户可以使用A/B/C三种不同的调度策略
    //        不同的策略会消耗不同的系统资源
    //        请你根据如下规则进行用户调度
    //        并返回总的消耗资源数
    //        规则是：相邻的用户不能使用相同的调度策略
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        ArrayList<TreeMap<Integer, Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] split = in.nextLine().split(" ");
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int j = 0; j < split.length; j++) {
                map.put(Integer.parseInt(split[j]), j);
            }
            res.add(map);
        }
        in.close();

        Integer res1 = new ArrayList<>(res.get(0).keySet()).get(0);
        int sum = res1;
        Integer type = res.get(0).get(res1);

        if (res.size() > 1) {
            for (int i = 1; i < res.size(); i++) {
                ArrayList<Integer> keyList = new ArrayList<>(res.get(i).keySet());
                Integer resN = keyList.get(0);
                Integer typeN = res.get(i).get(resN);
                if (!typeN.equals(type)) {
                    sum += resN;
                    type = typeN;
                } else {
                    sum += keyList.get(1);
                    type = res.get(i).get(keyList.get(1));
                }

            }
        }

        System.out.println(sum);
    }


    //20一个正整数数组 设为nums
    //        最大为100个成员
    //        求从第一个成员开始正好走到数组最后一个成员所使用的最小步骤数
    //                    3 5 9 4 2 6 8 3 5 4 3 9
    //        要求：
    //        1. 第一步 必须从第一元素起  且 1<=第一步步长<len/2  (len为数组长度)
    //        2. 从第二步开始只能以所在成员的数字走相应的步数，不能多不能少，
    //         如果目标不可达返回-1
    //         只输出最小的步骤数量
    //        3. 只能向数组的尾部走不能向回走
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        in.close();
        ints = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            ints[i] = Integer.parseInt(split[i]);
        }
        int len = ints.length;

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 1; i < len / 2; i++) {
//            if (ints[i] >= len / 2) continue;
            step = 1;
            set.add(in(i, i));
        }
        System.out.println(set);

        if (set.size() != 1) set.pollFirst();

        System.out.println(set.first());
    }

    private static int in(int curPos, int lastPos) {
        int numStep = ints[curPos];
        if (lastPos == ints.length - 1) {
            return step;
        } else if (lastPos < ints.length - 1) {
            step++;
            return in(lastPos, lastPos + numStep);
        } else {
            return -1;
        }
    }


//19删除字符串中出现次数最少的字符
//    如果多个字符出现次数一样则都删除
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    String line = in.nextLine();
    in.close();
    HashMap<Character, Long> map = new HashMap<>();
    for (char c : line.toCharArray()) {
        map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1L);
    }

    Long[] counts = new Long[map.values().size()];
    Long[] longs = map.values().toArray(counts);
    Arrays.sort(longs);
    Long min = longs[0];
    for (Map.Entry<Character, Long> entry : map.entrySet()) {
        if (entry.getValue().equals(min)) {
            line = line.replaceAll(entry.getKey() + "", "");
        }
    }

    System.out.println(line.length() == 0 ? "empty" : line);
}

//18喊7 是一个传统的聚会游戏
//        N个人围成一圈
//        按顺时针从1-7编号
//        编号为1的人从1开始喊数
//        下一个人喊得数字是上一个人喊得数字+1
//        但是当将要喊出数字7的倍数或者含有7的话
//        不能喊出 而是要喊过
//
//        假定N个人都没有失误。
//        当喊道数字k时
//        可以统计每个人喊 “过"的次数
//
//        现给定一个长度n的数组
//        存储打乱的每个人喊”过"的次数
//        请把它还原成正确顺序
//
//        即数组的第i个元素存储编号i的人喊“过“的次数
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String[] split = in.nextLine().split(" ");
    int sum = 0;
    for (String s : split) {
        sum += Integer.parseInt(s);
    }

    int[] res = new int[split.length];

    int j = 0;
    for (int i = 1; i < 300; i++, j++) {
        if (j == split.length) j = 0;
        if (i % 7 == 0 || (i + "").contains("7")) {
            res[j] += 1;
        }
        int sum1 = 0;
        for (int re : res) sum1 += re;
        if (sum == sum1) break;
    }

    StringBuilder builder = new StringBuilder();
    for (int re : res) builder.append(re).append(" ");

    String s = builder.toString();
    System.out.println(s.substring(0, s.length() - 1));

    in.close();
}


//17 给定一个字符串
//    只包含大写字母
//    求在包含同一字母的子串中
//    长度第K长的子串
//    相同字母只取最长的子串
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String line = in.nextLine();
    int k = in.nextInt();
    HashMap<Character, Integer> map = new HashMap<>();

    char[] chars = line.toCharArray();
    if (chars.length == 0) {
        System.out.println(-1);
        return;
    }

    char cur = chars[0];
    int count = 1;
    map.put(cur, count);

    for (int i = 1; i < chars.length; i++) {
        char c = chars[i];
        if (c == cur) count++;
        else {
            cur = c;
            count = 1;
        }
        map.put(cur, map.containsKey(cur) ?
                map.get(cur) > count ? map.get(cur) : count :
                count);
    }

    ArrayList<String> list = new ArrayList<>();
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        list.add(entry.getKey() + "-" + entry.getValue());
    }
    list.sort(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o2.split("-")[1].compareTo(o1.split("-")[1]);
        }
    });

    if (k > list.size()) System.out.println(-1);
    else System.out.println(list.get(k - 1).split("-")[1]);

    in.close();
}


//16单词接龙的规则是
//        可用于接龙的单词 首字母必须要与前一个单词的尾字母相同
//        当存在多个首字母相同的单词时，取长度最长的单词
//        如果长度也相等，则取字典序最小的单词
//        已经参与接龙的单词不能重复使用
//        现给定一组全部由小写字母组成的单词数组
//        并指定其中一个单词为起始单词
//        进行单词接龙
//        请输出最长的单词串
//        单词串是单词拼接而成的中间没有空格
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int k = Integer.parseInt(in.nextLine());
    int N = Integer.parseInt(in.nextLine());
    ArrayList<String> list = new ArrayList<>();
    for (int i = 0; i < N; i++) {
        list.add(in.nextLine());
    }

    StringBuilder builder = new StringBuilder();
    String head = list.get(k);
    builder.append(head);
    list.remove(k);

    String tail = head.substring(head.length() - 1);

    while (true) {
        TreeSet<String> set = new TreeSet<>();

        for (int i = 0; i < list.size(); i++) {
            String word = list.get(i);
            if (word.startsWith(tail)) {
                set.add(word);
            }
        }
        if (set.size() == 0) break;
        String first = set.pollFirst();
        int len = first.length();
        String aim = "";
        for (String s : set) {
            if (s.length() > len) {
                len = s.length();
                aim = s;
            }
        }
        String into = len != first.length() ? aim : first;
        tail = into.substring(into.length() - 1);
        builder.append(into);
        list.remove(into);
    }
    System.out.println(builder.toString());

    in.close();
}


//15给航天器一侧加装长方形和正方形的太阳能板(图中的斜线区域)
//        需要先安装两个支柱(图中的黑色竖条)
//        再在支柱的中间部分固定太阳能板
//        但航天器不同位置的支柱长度不同
//        太阳能板的安装面积受限于最短一侧的那支支柱的长度
//
//        现提供一组整型数组的支柱高度数据
//        假设每个支柱间的距离相等为一个单位长度
//        计算如何选择两根支柱可以使太阳能板的面积最大
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String[] split = in.nextLine().split(",");

    long[] ints = new long[split.length];
    for (int i = 0; i < split.length; i++) {
        ints[i] = Long.parseLong(split[i]);
    }

    long res = 0;
    for (int i = 0; i < split.length; i++) {
        for (int j = i + 1; j < split.length; j++) {
            long area = Math.min(ints[i], ints[j]) * (j - i);
            if (area > res) res = area;
        }
    }

    System.out.println(res);
}



//14单词接龙的规则是:
//可用于接龙的单词,首字母必须要与前一个单词的尾字母相同；
//当存在多个首字母相同的单词时，取长度最长的单词；
//如果长度也相等，则取字典序最小的单词；
//已经参与接龙的单词不能重复使用；
//现给定一组全部由小写字母组成的单词数组，
//并指定其中一个单词为起始单词，进行单词接龙，
//请输出最长的单词串。
//单词串是单词拼接而成的，中间没有空格

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(",");

        long[] ints = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            ints[i] = Long.parseLong(split[i]);
        }

        long res = 0;
        for (int i = 0; i < split.length; i++) {
            for (int j = i + 1; j < split.length; j++) {
                long area = Math.min(ints[i], ints[j]) * (j - i);
                if (area > res) res = area;
            }
        }

        System.out.println(res);
    }


   //13给航天器一侧加装长方形和正方形的太阳能板(图中的斜线区域);
   //需要先安装两个支柱(图中的黑色竖条);
   //再在支柱的中间部分固定太阳能板;
   //但航天器不同位置的支柱长度不同;
   //太阳能板的安装面积受限于最短一侧的那支支柱的长度;
   //
   //现提供一组整型数组的支柱高度数据;
   //假设每个支柱间的距离相等为一个单位长度;
   //计算如何选择两根支柱可以使太阳能板的面积最大;
   public static void main(String[] args) {
       try (Scanner scanner = new Scanner(System.in)) {
           String line = scanner.nextLine();

           solution(line);
       }

   }

    private static void solution(String line) {
        String[] split = line.split(",");
        long[] longs = Arrays.stream(split)
                .mapToLong(Long::parseLong)
                .toArray();

        long res = 0;
        for (int i = 0; i < split.length; i++) {
            for (int j = i + 1; j < split.length; j++) {
                long area = Math.min(longs[i], longs[j]) * (j - i);
                res = Math.max(res, area);
            }
        }

        System.out.println(res);
    }


//12一辆运送快递的货车，
//运送的快递放在大小不等的长方体快递盒中，
//为了能够装载更多的快递同时不能让货车超载，
//需要计算最多能装多少个快递。
//注：快递的体积不受限制。
//快递数最多1000个，货车载重最大50000。
public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
        String weights = scanner.nextLine();
        int capacity = scanner.nextInt();
        solution(weights, capacity);
    }
}
    private static void solution(String weightsStr, int capacity) {
        String[] split = weightsStr.split(",");
        int[] weights = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            weights[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(weights);
        int sum = 0;
        int i = 0;
        while (i < weights.length) {
            if (sum + weights[i] <= capacity) {
                sum += weights[i++];
            }else {
                break;
            }
        }
        System.out.println(i);
    }


    //11二叉树也可以用数组来存储，
    //给定一个数组，树的根节点的值储存在下标1，
    //对于储存在下标n的节点，他的左子节点和右子节点分别储存在下标2*n和2*n+1，
    //并且我们用-1代表一个节点为空，
    //给定一个数组存储的二叉树，
    //试求从根节点到最小的叶子节点的路径，
    //路径由节点的值组成。

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String treeStr = scanner.nextLine();
            solution(treeStr);
        }
    }

    private static void solution(String treeStr) {
        String[] split = ("0 " + treeStr).split(" ");
        int min = Integer.MAX_VALUE;
        int minPos = 0;
        for (int i = 2; i < split.length; i++) {
            int tmp = Integer.parseInt(split[i]);
            if (tmp != 0 && tmp != -1 && tmp < min && i * 2 > split.length) {
                min = tmp;
                minPos = i;
            }
        }
        List<String> path = new ArrayList<>();
        back(split, minPos, path);

        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i));
            if (i != 0) {
                System.out.print(" ");
            }
        }

    }

    private static void back(String[] split, int minPos, List<String> path) {
        path.add(split[minPos]);
        if (minPos == 1) {
            return;
        }
        if (minPos % 2 == 0) {
            back(split, minPos / 2, path);
        } else {
            back(split, (minPos - 1) / 2, path);
        }
    }

    //10对一个数据a进行分类，
    //分类方法是，此数据a(4个字节大小)的4个字节相加对一个给定值b取模，
    //如果得到的结果小于一个给定的值c则数据a为有效类型，其类型为取模的值。
    //如果得到的结果大于或者等于c则数据a为无效类型。
    //
    //比如一个数据a=0x01010101，b=3
    //按照分类方法计算：(0x01+0x01+0x01+0x01)%3=1
    //所以如果c等于2，则此a就是有效类型，其类型为1
    //如果c等于1，则此a是无效类型
    //
    //又比如一个数据a=0x01010103，b=3
    //按分类方法计算：(0x01+0x01+0x01+0x03)%3=0
    //所以如果c=2则此a就是有效类型 其类型为0
    //如果c等于0 则此a是无效类型
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[] ints = new int[12];
            for (int i = 0; i < ints.length; i++) {
                ints[i] = scanner.nextInt();
            }
            solution(ints);
        }
    }

    private static void solution(int[] ints) {
        int c = ints[0];
        int b = ints[1];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 2; i < ints.length; i++) {
            int r = intByteSum(ints[i]) % b;
            if (r < c) map.put(r, map.containsKey(r) ? map.get(r) + 1 : 1);
        }

        int max = 0;
        for (Integer value : map.values()) {
            if (value > max) max = value;
        }
        System.out.println(max);
    }

    private static int intByteSum(int x) {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += (byte) (x >> (i * 8));
        }
        return sum;
    }


    //9给定两个字符串，
    //从字符串2中找出字符串1中的所有字符，
    //去重并按照ASCII码值从小到大排列，
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            solution(str1, str2);
        }
    }

    private static void solution(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        Arrays.sort(chars1);
        char[] chars2 = str2.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : chars2) {
            set.add(c);
        }

        Set<Character> res = new TreeSet<>();
        for (char c : chars1) {
            if (set.contains(c)) {
                res.add(c);
            }
        }

        for (Character c : res) {
            System.out.print(c);
        }
    }


    //8  双11众多商品进行打折销售，小明想购买一些自己心仪的商品，
    //但由于受购买资金限制，所以他决定从众多心意商品中购买3件，
    //而且想尽可能的花完资金，
    //现在请你设计一个程序帮助小明计算尽可能花费的最大资金额。

    private static final List<List<Integer>> combines = new ArrayList<>();
    private static final List<Integer> combine = new ArrayList<>(3);
    private static int res = -1;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String m = scanner.nextLine();
            int r = scanner.nextInt();
            solution(m, r);
        }
    }

    private static void solution(String m, int r) {

        String[] goodsPricesString = m.split(",");
        int[] goodsPrices = new int[goodsPricesString.length];
        for (int i = 0; i < goodsPricesString.length; i++) {
            goodsPrices[i] = Integer.parseInt(goodsPricesString[i]);
        }
        Arrays.sort(goodsPrices);
        if (goodsPrices.length < 3 ||
                goodsPrices[0] + goodsPrices[1] + goodsPrices[2] > r) {
            System.out.println(-1);
            return;
        }

        takeGoods(goodsPrices, 0);
        combines.stream()
                .map(list -> sum(list))
                .sorted(Integer::compareTo)
                .forEach(sum -> {
                    if (sum > res && sum <= r) {
                        res = sum;
                    }
                });

        System.out.println(res);

    }

    private static void takeGoods(int[] goodsPrices, int start) {
        if (combine.size() == 3) {
            combines.add(new ArrayList<>(combine));
            return;
        }
        for (int i = start; i < goodsPrices.length; i++) {
            combine.add(goodsPrices[i]);
            takeGoods(goodsPrices, i + 1);
            combine.remove(combine.size() - 1);
        }
    }

    private static Integer sum(List<Integer> prices) {
        int sum = 0;
        for (Integer i : prices) {
            sum += i;
        }
        return sum;
    }


    //7  输入一个英文文章片段，
    //翻转指定区域的单词顺序，
    //标点符号和普通字母一样处理，
    //例如输入字符串
    //I am a developer.
    //[0,3]
    //则输出
    //developer. a am I
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            solution(line, l, r);
        }
    }

    private static void solution(String line, int l, int r) {
        String[] words = line.trim().split(" ");
        if (r > words.length - 1) r = words.length - 1;
        if (words.length == 0 ||
                l < 0 ||
                r - l <= 0) {
            System.out.println("EMPTY");
            return;
        }

        while (l < r) {
            String tmp = words[l];
            words[l] = words[r];
            words[r] = tmp;
            l++;
            r--;
        }

        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i]);
            if (i != words.length - 1) {
                System.out.print(" ");
            }
        }
    }


    //6  小明今年升学到了小学一年级，
    //来到新班级后，发现其他小朋友身高参差不齐，
    //然后就想基于各小朋友和自己的身高差，对他们进行排序，
    //请帮他实现排序
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int h = scanner.nextInt();
            int n = scanner.nextInt();
            List<Integer> highs = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                highs.add(scanner.nextInt());
            }
            solution(h, highs);
        }
    }

    private static void solution(int h, List<Integer> highs) {
        highs.sort((h1, h2) -> {
            int diff1 = Math.abs(h1 - h);
            int diff2 = Math.abs(h2 - h);
            return diff1 == diff2 ? h1 - h2 : diff1 - diff2;
        });

        for (int i = 0; i < highs.size(); i++) {
            System.out.print(highs.get(i));
            if (i != highs.size() - 1) {
                System.out.print(" ");
            }
        }
    }



    //5  为了充分发挥Gpu算力，
    //需要尽可能多的将任务交给GPU执行，
    //现在有一个任务数组，
    //数组元素表示在这1s内新增的任务个数，
    //且每秒都有新增任务，
    //假设GPU最多一次执行n个任务，
    //一次执行耗时1s，
    //在保证Gpu不空闲的情况下，最少需要多长时间执行完成。
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int len = scanner.nextInt();
            int[] jobCount = new int[len];
            for (int i = 0; i < len; i++) {
                jobCount[i] = scanner.nextInt();
            }
            solution(n, jobCount);
        }
    }

    private static void solution(int n, int[] jobCount) {
        int time = 0;
        int remaining = 0;
        for (int count : jobCount) {
            if (count + remaining > n) {
                remaining = count + remaining - n;
            } else {
                remaining = 0;
            }
            time++;
        }
        time += remaining / n;
        if (remaining % n > 0) {
            time++;
        }
        System.out.println(time);
    }



    //4   一天一只顽猴想要从山脚爬到山顶
    //途中经过一个有n个台阶的阶梯，但是这个猴子有个习惯，每一次只跳1步或3步
    //试问？猴子通过这个阶梯有多少种不同的跳跃方式
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            solution(n);
        }
    }

    private static void solution(int n) {
        int step1 = 1, step2 = 1, step3 = 2;
        int step4 = n == 1 || n == 2 ? 1 : 2;
        for (int i = 4; i <= n; i++) {
            step4 = step3 + step1;
            step1 = step2;
            step2 = step3;
            step3 = step4;
        }
        System.out.println(step4);
    }


    //3  TLV编码是按TagLengthValue格式进行编码的，一段码流中的信元用tag标识，tag在码流中唯一不重复，length表示信元value的长度，value表示信元的值，码流以某信元的tag开头，tag固定占一个字节，length固定占两个字节，字节序为小端序，现给定tlv格式编码的码流以及需要解码的信元tag，请输出该信元的value。
    //
    //输入码流的16进制字符中，不包括小写字母；
    //且要求输出的16进制字符串中也不要包含小写字母；
    //码流字符串的最大长度不超过50000个字节。
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String tag = scanner.nextLine();
            String source = scanner.nextLine();
            solution(tag, source);
        }
    }

    private static void solution(String tag, String source) {
        int p = 0;
        while (p < source.length()) {
            String curTag = source.substring(p, p + 2);
            String lenHEX = source.substring(p + 6, p + 8) + source.substring(p + 3, p + 5);
            int lenDEC = Integer.parseInt(lenHEX, 16);
            if (tag.equals(curTag)) {
                String value = source.substring(p + 9, p + 9 + lenDEC * 3);
                System.out.println(value);
            }
            p += 9 + lenDEC * 3;
        }
    }


    //2   给定两个整数数组，arr1、arr2，数组元素按升序排列；
    //假设从arr1、arr2中分别取出一个元素，可构成一对元素；
    //现在需要取出k对元素，并对取出的所有元素求和，计算和的最小值；
    //注意：两对元素对应arr1、arr2的下标是相同的，视为同一对元素。
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[] arr1 = parseArray(scanner.nextLine());
            int[] arr2 = parseArray(scanner.nextLine());
            int k = scanner.nextInt();
            solution(arr1, arr2, k);
        }
    }

    private static void solution(int[] arr1, int[] arr2, int k) {
        int initialCapacity = arr1.length * arr1.length;
        List<Integer> sums = new ArrayList<>(initialCapacity);
        for (int x : arr1) {
            for (int y : arr2) {
                sums.add(x + y);
            }
        }
        sums.sort(Integer::compareTo);
        int res = 0;
        for (int i = 0; i < k; i++) {
            res += sums.get(i);
        }
        System.out.println(res);
    }

    private static int[] parseArray(String line) {
        String[] split = line.split(" ");
        int[] arr = new int[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        return arr;
    }


    //1   如果三个正整数A、B、C ,A²+B²=C²则为勾股数
    //如果ABC之间两两互质，即A与B，A与C，B与C均互质没有公约数，
    //则称其为勾股数元组。
    //请求出给定n~m范围内所有的勾股数元组
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            solution(n, m);
        }
    }

    private static void solution(int n, int m) {
        int count = 0;
        for (int a = n; a < m - 1; a++) {
            for (int b = a + 1; b < m; b++) {
                for (int c = b + 1; c < m + 1; c++) {
                    if (relativelyPrime(a, b) &&
                            relativelyPrime(b, c) &&
                            relativelyPrime(a, c) &&
                            a * a + b * b == c * c) {
                        count++;
                        System.out.printf("%d %d %d\n", a, b, c);
                    }
                }
            }
        }
        if (count == 0) {
            System.out.println("Na");
        }
    }

    private static boolean relativelyPrime(int x, int y) {
        if (x == y && y == 1) {
            return false;
        }
        int min = Math.min(x, y);
        for (int i = 2; i <= min; i++) {
            if (x % i == 0 && y % i == 0) {
                return false;
            }
        }
        return true;
    }







}
