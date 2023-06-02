package ua.com.alevel.dto;


import lombok.Data;

@Data
public class OperationDto {

    private Long accountFromId;

    private Long accountToNumber;

    private Long operationSum;

    private String operationCategory;
}
