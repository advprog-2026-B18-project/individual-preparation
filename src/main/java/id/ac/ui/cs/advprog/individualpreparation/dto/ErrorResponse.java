package id.ac.ui.cs.advprog.individualpreparation.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorResponse {
    String message;
    String status;

    public ErrorResponse(String message, String status){
        this.message = message;
        this.status = status;
    }
}
