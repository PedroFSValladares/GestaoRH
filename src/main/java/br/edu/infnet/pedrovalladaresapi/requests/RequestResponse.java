package br.edu.infnet.pedrovalladaresapi.requests;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class ResponseBody {
    private HttpStatus status;
    private LocalDateTime timestamp;
    private Object data;

    public ResponseBody(){
        timestamp = LocalDateTime.now();
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResponseEntity<ResponseBody> getByCode(HttpStatus status, Object data){
        ResponseBody responseBody = new ResponseBody();
        responseBody.status = status;
        responseBody.data = data;
        return ResponseEntity.status(responseBody.getStatus()).body(responseBody);
    }
}
