package top.withlevi.model.vo;


import lombok.Data;

/**
 * BI的返回结果
 */


@Data
public class BiResponse {

    private String genChart;

    private String genResult;

    private Long chartId;

}
