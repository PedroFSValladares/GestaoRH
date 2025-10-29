package br.edu.infnet.pedrovalladaresapi.requests;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public abstract class ResponseRequest {
    private String status;
    private LocalDateTime timestamp;
    private Object data;

    public ResponseRequest(){
        timestamp = LocalDateTime.now();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

    public static class Ok extends ResponseRequest {
        public Ok(Object data){
            super();
            setStatus(HttpStatus.OK.toString());
            setData(data);
        }
    }

    public static class BadRequest extends ResponseRequest{
        public BadRequest(Object erros){
            super();
            setStatus(HttpStatus.BAD_REQUEST.toString());
            setData(erros);
        }
    }
}
