package br.edu.infnet.pedrovalladaresapi.requests;

import org.springframework.http.HttpStatus;

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

    public static ResponseBody Ok(Object data) {
        ResponseBody responseBody = new ResponseBody();
        responseBody.status = HttpStatus.OK;
        responseBody.data = data;
        return responseBody;
    }

    public static ResponseBody BadRequest(Object data) {
        ResponseBody responseBody = new ResponseBody();
        responseBody.status = HttpStatus.BAD_REQUEST;
        responseBody.data = data;
        return responseBody;
    }

    public static ResponseBody NoContent(){
        ResponseBody responseBody = new ResponseBody();
        responseBody.status = HttpStatus.NO_CONTENT;
        responseBody.data = null;
        return responseBody;
    }

    public static ResponseBody Found(Object data){
        ResponseBody responseBody = new ResponseBody();
        responseBody.status = HttpStatus.FOUND;
        responseBody.data = data;
        return responseBody;
    }

    public static ResponseBody NotFound(){
        ResponseBody responseBody = new ResponseBody();
        responseBody.status = HttpStatus.NOT_FOUND;
        responseBody.data = null;
        return responseBody;
    }
}
