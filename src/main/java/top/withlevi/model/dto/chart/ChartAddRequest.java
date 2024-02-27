package top.withlevi.model.dto.chart;

import lombok.Data;

import java.io.Serializable;

/**
 * 添加图表
 */
@Data
public class ChartAddRequest implements Serializable {


    /**
     * 分析目标数据
     */
    private String goal;

    /**
     * 图表数据
     */
    private String chartData;

    /**
     * 图表类型
     */
    private String chartType;

    private static final long serialVersionUID = 1L;
}