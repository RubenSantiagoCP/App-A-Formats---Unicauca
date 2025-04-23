package co.edu.unicauca.asae.app_formats_a.commons.enums;


public enum StateEnum {
    FORMULATED("Formulated"),  
    UNDER_REVIEW("Under Evaluation"),  
    TO_BE_FIXED("Needs Correction"),  
    REJECTED("Rejected"),  
    APPROVED("Approved");  

    private final String description;

    StateEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
