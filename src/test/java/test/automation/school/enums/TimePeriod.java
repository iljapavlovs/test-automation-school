package test.automation.school.enums;

public enum TimePeriod {
    TODAY("1"),
    LAST_THREE_DAYS("3"),
    LAST_WEEK("7"),
    LAST_MONTH("30"),
    ALL_PERIOD("0");

    private String dayCount;

    TimePeriod(String dayCount) {
        this.dayCount = dayCount;
    }

    public String getDayCount(){
        return dayCount;
    }
}
