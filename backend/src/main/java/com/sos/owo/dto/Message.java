package com.sos.owo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
public class Message {
     private StatusEnum status;
     private String message;
     private Object data;

     public Message(){
          this.status = StatusEnum.BAD_REQUEST;
          this.data = null;
          this.message = null;
     }

     public Message(StatusEnum status, String message, Object data) {
          this.status = status;
          this.message = message;
          this.data = data;
     }
}
