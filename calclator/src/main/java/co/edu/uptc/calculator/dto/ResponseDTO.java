package co.edu.uptc.calculator.dto;


public class ResponseDTO {

    private String operation;
    private Double result;
    private String message;
    private String ip;
    private String nameContainer;

    public ResponseDTO() {
    }

    public ResponseDTO(String operation, Double result, String message, String ip, String nameContainer) {
        this.ip = ip;
        this.nameContainer = nameContainer;
        this.operation = operation;
        this.result = result;
        this.message = message;
    }
    public ResponseDTO(String operation, Double result, String message) {
    this.operation = operation;
    this.result = result;
    this.message = message;
    }
    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getIp(){
        return ip;
    }

    public void setIp(String ip){
        this.ip=ip;
    }
    public String getNameContainer(){
        return nameContainer;
    }

    public void setNameContainer(String nameContainer){
        this.nameContainer=nameContainer;
    }
}