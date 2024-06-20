package neu.practice.controller;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Result {
    private Integer code;
    private String message;
    private Object data;
}
