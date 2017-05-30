package com.yoclabo.sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadSystemIn {

    public static void main(String args[]) {

        Test01();
        Test02();
        Test03();

        TestEnd();

    }

    private static void Test01() {

        // 一行 & 一列 読み込みのテスト
        String value = read();

        System.out.println(value);
    }

    private static void Test02() {

        // 一行 & 複数列 読み込みのテスト
        String value = read();

        System.out.println(value);
    }

    private static void Test03() {

        // 複数行 & 複数列 読み込みのテスト
        // 列のデリミタは半角ブランク
        // 最初の行 第 1 トークンに行数
        // 最初の行 第 2 トークンに列数がセットされている前提
        // 1 行目
        String firstOne = read();
        int linesCount = EvaluateFirstLine(firstOne);
        if (linesCount < 0) {
            return;
        }

        List<String> value = new ArrayList<String>();
        value.add(firstOne);

        read(linesCount).forEach(v -> value.add(v));

        value.forEach(v -> System.out.println(v));
    }

    private static void TestEnd() {

        // ユーザー入力を待機して処理を中断する
        System.out.println("文字を入力してください");

        String prompt = read();
        System.out.println(prompt);
    }

    private static String read() {

        InputStreamReader sr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(sr);

        String ret = "";
        try {
            ret = br.readLine();
        } catch (Exception e) {
            System.out.println("IO Exception caught. : " + e.getMessage());
        }
        return ret;
    }

    private static List<String> read(int linesCount) {

        List<String> ret = new ArrayList<String>();
        for (int i = 0; i < linesCount; i++) {
            String add = read();
            ret.add(add);
        }
        return ret;
    }

    private static int EvaluateFirstLine(String arg) {
        // 行数の判断
        // テスト用なので最大入力は 10 行までに制限する
        String pattern = "(\\d{1,2}) +(\\d{1,2}) +(\\w+)";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(arg);
        if (m.find()) {
            // パターンにマッチする入力があったときこちらへ分岐
            int ret = Integer.parseInt(m.group(1));
            if (ret < 0 || ret > 10) {
                System.out.println("入力行数が不正です");
                return -1;
            }
            return ret;
        }
        System.out.println("入力行数が不正です");
        return -1;
    }

}
