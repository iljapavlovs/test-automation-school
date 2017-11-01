package test.automation.school.cleancode.enums;


public enum Operation {
    ADDITION("ADDITION"),
    DIVISION("DIVISION"),
    MODULO("MODULO"),
    MULTIPLICATION("MULTIPLICATION"),
    SUBTRACTION("SUBTRACTION");

    private String dropdownValue;

    Operation(String dropdownValue) {
        this.dropdownValue = dropdownValue;
    }

    public String getOperation() {
        return dropdownValue;
    }
}
