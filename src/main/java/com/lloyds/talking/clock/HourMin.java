package com.lloyds.talking.clock;

public enum HourMin {

    zero(0, ""),
    one(1, "One"),
    two(2, "Two"),
    three(3, "Three"),
    four(4, "Four"),
    five(5, "Five"),
    six(6, "Six"),
    seven(7, "Seven"),
    eight(8, "Eight"),
    nine(9, "Nine"),
    ten(10, "Ten"),
    eleven(11, "Eleven"),
    twelve(12, "Twelve"),
    thirteen(13, "Thirteen"),
    fourteen(14, "Fourteen"),
    fifteen(15, "Fifteen"),
    sixteen(16, "Sixteen"),
    seventeen(17, "Seventeen"),
    eighteen(18, "Eighteen"),
    nineteen(19, "Nineteen"),
    twenty(20, "Twenty"),
    twentyOne(21, "Twenty one"),
    twentyTwo(22, "Twenty two"),
    twentyThree(23, "Twenty three"),
    twentyFour(24, "Twenty four"),
    twentyFive(25, "Twenty five"),
    twentySix(26, "Twenty six"),
    twentySeven(27, "Twenty seven"),
    twentyEight(28, "Twenty eight"),
    twentyNine(29, "Twenty nine");

    private final String word;
    private final int number;

    HourMin(int number, String word) {
        this.word = word;
        this.number = number;
    }

    public static String convertNumToWord(int num) {
        return HourMin.values()[num].word;
    }
}
